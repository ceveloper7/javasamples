package com.ceva.ch05.practicing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class PuttingIntoPractice {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // Solucion 1. Encontrar todas las transacciones del anio 2011 y ordenarlas por valor de menos a mayor
        List<Transaction> transactions2011 = transactions.stream()
                // pasamos predicado para filtrar las transacciones del 2011
                .filter(t -> t.getYear() == 2011)
                // Ordenamos las transacciones por valor
                .sorted(Comparator.comparing(Transaction::getValue))
                // Recolectamos toso las transaciones en una lista
                .toList();
        System.out.println(transactions2011);

        // Solucion 2: Cuales son las ciudades unicas donde los Traders trabajan
        List<String> cities = transactions.stream()
                // extraemos cada ciudad de las transacciones
                .map(t -> t.getTrader().getCity())
                // descartamos duplicados
                .distinct()
                // Recolectamos las ciudades en una lista
                .toList();
        System.out.println(cities);

        // Solucion 3: Encontrar todos los Traders de Cambridge y ordenados por nombre
        List<Trader> traders = transactions.stream()
                // extraemos todos los Traders en las transacciones
                .map(Transaction::getTrader)
                // Seleccionamos solo los Traders de Cambridge
                .filter(trader -> trader.getCity().equals("Cambridge"))
                // removemos los nombres duplicados
                .distinct()
                // ordenamos los Traders alfabeticamente
                .sorted(Comparator.comparing((Trader::getName)))
                // Recolectamos los Traders en una lista
                .toList();
        System.out.println(traders);

        // Solution 4: Retornar un string con todos los nombres ordenamos alfabeticamente
        String traderNames = transactions.stream()
                // Extramos todos los nombres de los Traders
                .map(transaction -> transaction.getTrader().getName())
                // removemos nombres duplicados
                .distinct()
                // ordenamos los nombres alfabeticamente
                .sorted()
                // Combinamos los nombre de los traders uno a uno para formar una cadena con todos los nombres
                .reduce("", (n1,n2) -> n1 + n2);
        System.out.println(traderNames);

        // Solucion 5: Algun Trader basado en Milan
        boolean milanBased = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println("Any Trader based on Milan? " + milanBased);

        // Solucion 6: Imprimir los valores de las transacciones cuyo Traders vivan  en Cambridges
        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        // Solucion 7: Cual es el valor mas alto de las transacciones
        Optional<Integer> highestValue = transactions.stream()
                // extraemos el valor de cada transaccion
                .map(transaction -> transaction.getValue())
                // calculamos el valor maximo
                .reduce(Integer::max);
        System.out.println("The highest value in transactions: " + highestValue.get());

        // Solucion 8: Encontrar la Transaccion con el valor mas bajo
        Optional<Transaction> lowestValue = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));
        System.out.println("The lowest value in transactions: " + lowestValue.get());
    }
}
