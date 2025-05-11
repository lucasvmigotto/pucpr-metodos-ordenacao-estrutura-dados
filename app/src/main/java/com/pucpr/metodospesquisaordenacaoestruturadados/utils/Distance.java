package com.pucpr.metodospesquisaordenacaoestruturadados.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.pucpr.metodospesquisaordenacaoestruturadados.models.Book;

public class Distance {

    public static Map<Book, Integer> djikstra(HashMap<Book, Set<Book>> graph, Book book) {
        Map<Book, Integer> distances = new HashMap<>() {
            {
                put(book, 0);
            }
        };

        Queue<Book> queue = new LinkedList<>() {
            {
                add(book);
            }
        };

        while (!queue.isEmpty()) {

            Book current = queue.poll();

            int currentDistance = distances.get(current);

            for (Book neighbor : graph.getOrDefault(current, new HashSet<>())) {

                if (!distances.containsKey(neighbor)) {

                    distances.put(neighbor, currentDistance + 1);

                    queue.add(neighbor);

                }

            }

        }

        return distances;
    }

}
