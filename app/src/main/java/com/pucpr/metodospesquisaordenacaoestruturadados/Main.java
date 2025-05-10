package com.pucpr.metodospesquisaordenacaoestruturadados;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.pucpr.metodospesquisaordenacaoestruturadados.models.Book;
import com.pucpr.metodospesquisaordenacaoestruturadados.models.BooksGraph;
import com.pucpr.metodospesquisaordenacaoestruturadados.models.Relation;
import com.pucpr.metodospesquisaordenacaoestruturadados.utils.DataReader;

public class Main {

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Relation> relations = new ArrayList<>();

        try {
            books = DataReader.loadBooks();
            relations = DataReader.loadRelations();
        } catch (JsonSyntaxException | JsonIOException ex) {
            System.out.println("Error during data loading");
            System.exit(1);
        } catch (FileNotFoundException ex) {
            System.exit(1);
        }

        BooksGraph graph = new BooksGraph(books, relations);

        System.out.println(graph);

    }
}
