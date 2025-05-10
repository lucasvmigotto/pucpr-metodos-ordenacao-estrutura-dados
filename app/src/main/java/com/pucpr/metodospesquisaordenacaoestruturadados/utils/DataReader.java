package com.pucpr.metodospesquisaordenacaoestruturadados.utils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.pucpr.metodospesquisaordenacaoestruturadados.models.Book;
import com.pucpr.metodospesquisaordenacaoestruturadados.models.Relation;

public class DataReader {

    public static InputStream getFileAsStream(String filename) throws FileNotFoundException {
        InputStream content = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(filename);

        if (content == null) {
            throw new FileNotFoundException(
                    String.format(
                            "File %s not found", filename));
        }

        return content;
    }

    public static ArrayList<Book> loadBooks() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
        ArrayList<Book> list = new Gson().fromJson(
                new InputStreamReader(getFileAsStream("books.json")),
                new TypeToken<ArrayList<Book>>() {
                }.getType());

        return list;

    }

    public static ArrayList<Relation> loadRelations()
            throws JsonSyntaxException, JsonIOException, FileNotFoundException {
        ArrayList<Relation> list = new Gson().fromJson(
                new InputStreamReader(getFileAsStream("relations.json")),
                new TypeToken<ArrayList<Relation>>() {
                }.getType());

        return list;

    }

}
