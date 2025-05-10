package com.pucpr.metodospesquisaordenacaoestruturadados.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.pucpr.metodospesquisaordenacaoestruturadados.models.Book;
import com.pucpr.metodospesquisaordenacaoestruturadados.models.BooksGraph;
import com.pucpr.metodospesquisaordenacaoestruturadados.models.Relation;
import com.pucpr.metodospesquisaordenacaoestruturadados.utils.DataReader;

public class UserInterface {

    private final Scanner userInputReader;

    private final String INVALID_OPTION = "Invalid option, please try again.";

    private int exitCode = 0;

    private final ArrayList<String> menuOptions = new ArrayList<>(
            Arrays.asList(
                    "Exit",
                    "Get Suggestions"));

    private ArrayList<Book> books = null;
    private ArrayList<Relation> relations = null;
    private BooksGraph graph = null;

    public int getExitCode() {
        return exitCode;
    }

    public UserInterface() {
        this.userInputReader = new Scanner(System.in);
    }

    private UserInterface loadData() {
        try {
            this.books = DataReader.loadBooks();
            this.relations = DataReader.loadRelations();
            this.graph = new BooksGraph(this.books, this.relations);
        } catch (FileNotFoundException e) {
            System.out.println("Data file not found error:\n\t" + e.getMessage());
            this.exitCode = 1;
        } catch (JsonIOException | JsonSyntaxException e) {
            System.out.println("JSON data file is invalid:\n\t" + e.getMessage());
            this.exitCode = 1;
        }
        return this;
    }

    private Process cleanOutput() throws IOException {
        return new ProcessBuilder(
                System.getProperty("os.name").equals("Windows") ? "cls" : "clear").start();
    }

    private String renderMenu() {
        StringBuilder menuBuilder = new StringBuilder("");

        ListIterator<String> iterator = this.menuOptions.listIterator();

        while (iterator.hasNext()) {
            menuBuilder.append(
                    String.format(
                            "%d - %s\n",
                            iterator.nextIndex(),
                            iterator.next()));
        }

        return menuBuilder.toString();
    }

    private void getSuggestions() throws IOException {
        Book option = null;
        String options = this.books.stream().map(
                book -> String.format(
                        "%d - %s by: %s\n",
                        this.books.indexOf(book),
                        book.getTitle(),
                        book.getAuthor()))
                .collect(Collectors.joining());

        while (option == null) {
            this.cleanOutput();

            try {
                System.out.println(options);

                System.out.print("Choose a book: ");
                option = this.books.get(this.userInputReader.nextInt());

                this.cleanOutput();
                System.out.println("You may also like:");
                String suggestions = this.graph.getGraph().get(option).stream().map(
                        book -> String.format(
                                "%s (%d) by: %s\n",
                                book.getTitle(),
                                book.getReleaseYear(),
                                book.getAuthor()))
                        .collect(Collectors.joining());

                System.out.println(suggestions);

                System.out.println("\nPress any key to continue...");
                this.userInputReader.nextLine();

            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid option. Press any key to continue...");
                this.userInputReader.nextLine();
            }

        }

    }

    private int menu() {
        int userInput = -1;

        while (userInput != 0 || this.exitCode != 0) {
            try {
                this.cleanOutput();

                System.out.println(this.renderMenu());

                System.out.print("Choose an option: ");
                userInput = this.userInputReader.nextInt();

                switch (userInput) {
                    case 1:
                        this.getSuggestions();
                        break;
                    case 0:
                    default:
                        return this.exitCode;
                }

            } catch (IOException error) {
                System.out.println(INVALID_OPTION);

            } catch (Exception error) {
                System.err.println(INVALID_OPTION);
                this.exitCode = 1;
            }

        }

        return this.exitCode;

    }

    public int runApp() {
        if (this.books == null || this.relations == null || this.graph == null) {
            this.loadData();
            if (this.exitCode == 1) {
                return this.exitCode;
            }
        }

        this.menu();

        return this.exitCode;
    }

}
