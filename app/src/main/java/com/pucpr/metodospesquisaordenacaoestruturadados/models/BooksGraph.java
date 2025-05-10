package com.pucpr.metodospesquisaordenacaoestruturadados.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public final class BooksGraph {

    private ArrayList<Book> books;
    private ArrayList<Relation> relations;
    private HashMap<Book, Set<Book>> graph;

    public BooksGraph() {
    }

    public BooksGraph(ArrayList<Book> books, ArrayList<Relation> relations) {
        this.books = books;
        this.relations = relations;
        this.buildGraph();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public BooksGraph setBooks(ArrayList<Book> books) {
        this.books = books;
        return this;
    }

    public ArrayList<Relation> getRelations() {
        return relations;
    }

    public BooksGraph setRelations(ArrayList<Relation> relations) {
        this.relations = relations;
        return this;
    }

    public HashMap<Book, Set<Book>> getGraph() {
        return graph;
    }

    public BooksGraph buildGraph() {

        this.graph = new HashMap<Book, Set<Book>>() {
        };

        for (Book book : this.books) {

            this.graph.put(
                    book,
                    this.relations.stream()
                            .filter(relation -> relation.getOrigin().equals(book.getId()))
                            .map(relation -> this.books.stream()
                                    .filter(compare -> relation.getRelatedTo().equals(compare.getId()))
                                    .findFirst()
                                    .get())
                            .collect(Collectors.toSet()));

        }

        return this;

    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("");

        for (Book book : this.graph.keySet()) {
            output.append(
                    String.format(
                            "%s\n%s\n",
                            book.toString(),
                            this.graph.get(book).stream().map(related -> String.format("\t%s\n", related.toString()))
                                    .collect(Collectors.joining())

                    ));
        }

        return output.toString();
    }

}
