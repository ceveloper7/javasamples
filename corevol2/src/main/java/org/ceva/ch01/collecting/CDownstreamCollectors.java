package org.ceva.ch01.collecting;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class CDownstreamCollectors {
    private static Stream<City> getCities()throws IOException{
        InputStream is = CDownstreamCollectors.class.getClassLoader().getResourceAsStream("Cities.txt");
        Stream<City> cities = null;
        if(is != null){
            byte[] bytes = is.readAllBytes();
            String contents = new String(bytes, StandardCharsets.UTF_8);
            cities = contents.lines()
                    .map((line)-> line.split(", "))
                    .map((city) -> new City(city[0], city[1], Integer.parseInt(city[2])));
        }else{
            System.out.println("Cities file not found");
        }
        return cities;
    }

    public static void main(String[] args) throws IOException {
        Map<String, Set<Locale>> countryToLocaleSet = Locale.availableLocales()
                .collect(groupingBy(Locale::getCountry, toSet()));
        System.out.println("countryToLocaleSet: " + countryToLocaleSet);

        // doble groupingBy. get a list of Spain Locale
        Map<String, Map<String, List<Locale>>> countryAndLanguageToLocale = Locale.availableLocales()
                .collect(groupingBy(Locale::getCountry,
                        groupingBy(Locale::getLanguage)));
        System.out.println("Hindi locales in Spain: " + countryAndLanguageToLocale.get("ES").get("es"));

        // count cuantos locales hay por cada pais
        Map<String, Long> countryToLocaleCounts = Locale.availableLocales()
                .collect(groupingBy(Locale::getCountry, counting()));
        System.out.println("countryToLocaleCounts: " + countryToLocaleCounts);

        // summing population by state
        Stream<City> cities = getCities();
        Map<String, Integer> stateToCityPopulation = cities
                .collect(groupingBy(City::state, summingInt(City::population)));
        System.out.println("stateToCityPopulation: " + stateToCityPopulation);

        // state with city name longest
        cities = getCities();
        Map<String, Optional<String>> stateToLongestCityName = cities
                .collect(groupingBy(City::state,
                        mapping(City::name, maxBy(Comparator.comparing(String::length)))));
        System.out.println("stateToLongestCityName: " + stateToLongestCityName);

        cities = getCities();
        Map<String, Optional<String>> stateToShortestCityName = cities
                .collect(groupingBy(City::state,
                        mapping(City::name, minBy(Comparator.comparing(String::length)))));
        System.out.println("stateToShortestCityName: " + stateToShortestCityName);

        // using mapping. obtenemos un Set de todos los idiomas
        Map<String, Set<String>> countryToLanguages = Locale.availableLocales()
                .collect(groupingBy(Locale::getDisplayCountry,
                        mapping(Locale::getDisplayLanguage, toSet())));
        System.out.println("countryToLanguages: " + countryToLanguages);

        // obteniendo un objeto summaring statistics
        cities = getCities();
        Map<String, IntSummaryStatistics> stateToCityPopulationSummary = cities
                .collect(groupingBy(City::state, summarizingInt(City::population)));
        System.out.println(stateToCityPopulationSummary.get("NY"));

//        cities = getCities();
//        Map<String, String> stateToCityNames = cities.collect(
//                groupingBy(City::state,
//                        reducing("", City::name, (s, t) -> s.length() == 0 ? t : s + ", " + t)));


        cities = getCities();
        Map<String, String> stateToCityNames = cities.collect(groupingBy(City::state,
                mapping(City::name, joining(", "))));
        System.out.println("stateToCityNames: " + stateToCityNames);

        // doing more than one computation over stream with teeing
        cities = getCities();
        Pair<List<String>, Double> result = cities.filter(c -> c.state().equals("NV"))
                .collect(teeing(
                        mapping(City::name, toList()),
                        averagingDouble(City::population),
                        (names, avg) -> new Pair<>(names, avg)));
        System.out.println(result);


    }
}
