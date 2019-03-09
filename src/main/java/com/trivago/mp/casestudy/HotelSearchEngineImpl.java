package com.trivago.mp.casestudy;

import static java.util.stream.Collectors.toList;

import com.trivago.mp.casestudy.repositories.AdvertiserRepository;
import com.trivago.mp.casestudy.repositories.AdvertiserRepositoryImpl;
import com.trivago.mp.casestudy.repositories.HotelMetrics;
import com.trivago.mp.casestudy.repositories.HotelMetricsImpl;
import com.trivago.mp.casestudy.repositories.HotelRepository;
import com.trivago.mp.casestudy.repositories.HotelRepositoryImpl;
import com.trivago.mp.casestudy.repositories.Relations;
import com.trivago.mp.casestudy.repositories.RelationsImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.util.Pair;

/**
 * TODO: Implement this class.
 * Your task will be to implement two functions, one for loading the data which is stored as .csv files in the ./data
 * folder and one for performing the actual search.
 */
public class HotelSearchEngineImpl implements HotelSearchEngine {

    private final AdvertiserRepository advertiserRepository = new AdvertiserRepositoryImpl();
    private final HotelRepository      hotelRepository      = new HotelRepositoryImpl();
    private final Relations            relations            = new RelationsImpl();
    private final HotelMetrics         hotelMetrics         = new HotelMetricsImpl();

    private Stream<List<String>> streamer(final String fileName) {
        Path path = Paths.get(fileName);
        if (Files.exists(path)) {
            try {
                return Files.lines(path)
                    .skip(1)
                    .parallel()
                    .map((line) -> Arrays.asList(line.split(",")))
                    ;
            }
            catch (IOException e) {
                e.printStackTrace();
                return Stream.empty();
            }
        }
        else
            return Stream.empty();
    }

    private Advertiser advertiserConversion(final List<String> properties) {
        return new Advertiser(
            Integer.parseInt(properties.get(0)),
            properties.get(1)
        );
    }

    private Hotel hotelConversion(final List<String> properties, Map<String, String> cities) {
        return new Hotel(
            Integer.parseInt(properties.get(0)),
            cities.get(properties.get(1)),
            properties.get(4),
            Integer.parseInt(properties.get(5)),
            Integer.parseInt(properties.get(6))
        );
    }

    /**
     * consider to change Pair to something suitable like Tuples from Project Reactor
     */

    @SuppressWarnings("unchecked")
    private Pair<Integer, Long> metricsClickConversion(final List<String> properties) {
        return new Pair(
            Integer.parseInt(properties.get(0)),
            Long.parseLong(properties.get(2))
        );
    }

    /**
     * consider to change Pair to something suitable like Tuples from Project Reactor
     */

    @SuppressWarnings("unchecked")
    private Pair<Integer, Long> metricsImpressionConversion(final List<String> properties) {
        return new Pair(
            Integer.parseInt(properties.get(0)),
            Long.parseLong(properties.get(3))
        );
    }

    /**
     * consider to change CompletableFuture to Mono+Flux from Project Reactor
     * to have reactive pipeline
     */

    @Override
    public void initialize() {

        CompletableFuture<Void> completableFutureAdv =
            CompletableFuture.runAsync(() ->
                advertiserRepository.saveAll(
                    streamer("./data/advertisers.csv")
                        .map(this::advertiserConversion)
                        .collect(Collectors.toMap(Advertiser::getId, y -> y))
                ));

        CompletableFuture<Void> completableFutureHotel =
            CompletableFuture.runAsync(() -> {
                Map<String, String> cities = streamer("./data/cities.csv")
                    .collect(Collectors.toMap(list -> list.get(0), list -> list.get(1)));
                hotelRepository.saveAll(
                    streamer("./data/hotels.csv")
                        .map(list -> hotelConversion(list, cities))
                        .collect(Collectors.toMap(Hotel::getId, y -> y))
                );
            });

        CompletableFuture<Void> completableFutureHotelMetricsClick =
            CompletableFuture.runAsync(() ->
                hotelMetrics.setHotelClicks(
                    streamer("./data/hotels.csv")
                        .map(this::metricsClickConversion)
                        .collect(Collectors.toMap(Pair::getKey, Pair::getValue))
                ));

        CompletableFuture<Void> completableFutureHotelMetricsImpression =
            CompletableFuture.runAsync(() ->
                hotelMetrics.setHotelImpression(
                    streamer("./data/hotels.csv")
                        .map(this::metricsImpressionConversion)
                        .collect(Collectors.toMap(Pair::getKey, Pair::getValue))
                ));

        CompletableFuture<Void> completableFutureRelations =
            CompletableFuture.runAsync(() -> {
                // probably do that in transaction to avoid de-synchronisation of two tables
                Map<Integer, List<Integer>> ah = new ConcurrentHashMap<>();
                Map<Integer, List<Integer>> ha = new ConcurrentHashMap<>();
                streamer("./data/hotel_advertiser.csv")
                    .map(list -> list.stream()
                        .map(Integer::parseInt)
                        .collect(toList()))
                    .collect(toList())
                    .forEach(list -> {
                            ah.merge(list.get(0), new ArrayList<>(),
                                    (innerList, value) -> {
                                        innerList.add(list.get(1));
                                        return innerList;
                                    }
                            );
                            ha.merge(list.get(1), new ArrayList<>(),
                                    (innerList, value) -> {
                                        innerList.add(list.get(0));
                                        return innerList;
                                    }
                            );
                        }
                    );
                relations.setAdvertiserHotel(ah);
                relations.setHotelAdvertiser(ha);
            });

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(
            completableFutureAdv,
            completableFutureHotel,
            completableFutureRelations,
            completableFutureHotelMetricsClick,
            completableFutureHotelMetricsImpression
        );

        try {
            combinedFuture.get();
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

    /**
     * consider to change Repositories Lists to Flux from Project Reactor
     * to have reactive pipeline
     */

    @Override
    public List<HotelWithOffers> performSearch(String cityName, DateRange dateRange, OfferProvider offerProvider) {

        return hotelRepository.findAll().values().stream()
            .filter(s -> s.getCityName().equals(cityName))
            .map(Hotel::getId)
            // having map of advertiser + filtered hotels
            .map(hotelId -> relations.getAdvertiserHotel().entrySet().parallelStream()
                .collect(Collectors.toMap(
                    k -> advertiserRepository.findById(k.getKey()),
                    v -> v.getValue().stream()
                        .filter(value -> value.equals(hotelId))
                        .collect(toList()))))
            // call each advertiser to get offer for specified list of hotels
            // consider here response caching mechanism with cache eviction by ttl lets say
            .flatMap(ahMap -> ahMap.entrySet().parallelStream()
                .map(entry -> offerProvider.getOffersFromAdvertiser(entry.getKey(), entry.getValue(), dateRange)))
            .flatMap(map -> map.entrySet().stream())
            // grouping parallel responses into one stream
            .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toList())))
            .entrySet().stream()
            .map(entry -> {
                final Hotel hotel = hotelRepository.findById(entry.getKey());
                final List<Offer> offers = entry.getValue();
                return new HotelWithOffers(hotel, offers);
            })
            .collect(toList());

    }
}
