package AnimeDatabase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Author: Josue Suazo
 * Course: Software Development I CEN-3024C
 * Date: 7/1/2024 (GUI Update 7/1/2024)
 * AnimeApp.java
 * This class is the main entry point for the console-based application.
 * It includes the main method and demonstrates how to use the AnimeDatabase class.
 */
public class AnimeApp {
    public static void main(String[] args) {
        AnimeDatabase animeDatabase = new AnimeDatabase();
        Scanner scanner = new Scanner(System.in);

        // Load sample data
        loadSampleData(animeDatabase);

        // Display all anime
        System.out.println(animeDatabase.displayAllAnime());

        // Search for an anime by title
        searchAnime(animeDatabase, scanner);

        // Close scanner
        scanner.close();
    }

    /**
     * Loads sample data into the anime database.
     *
     * @param animeDatabase the anime database to load data into
     */
    private static void loadSampleData(AnimeDatabase animeDatabase) {
        String filename = "Sample_anime.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean isFirstLine = true; // Flag to skip the header line
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                if (data.length == 5) {
                    String title = data[0];
                    String genre = data[1];
                    int episodes = Integer.parseInt(data[2]);
                    double rating = Double.parseDouble(data[3]);
                    String studio = data[4];
                    Anime anime = new Anime(title, genre, episodes, rating, studio);
                    animeDatabase.addAnime(anime);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading sample data: " + e.getMessage());
        }
    }

    /**
     * Searches for an anime in the database by title.
     *
     * @param animeDatabase the anime database to search in
     * @param scanner the scanner to read user input
     */
    private static void searchAnime(AnimeDatabase animeDatabase, Scanner scanner) {
        System.out.print("Enter title of anime to search: ");
        String titleToSearch = scanner.nextLine();
        Anime searchedAnime = animeDatabase.searchAnime(titleToSearch);
        if (searchedAnime != null) {
            System.out.println(searchedAnime);
        } else {
            System.out.println("Anime not found.");
        }
    }
}
