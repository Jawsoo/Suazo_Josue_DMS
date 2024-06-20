package AnimeDatabase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * AnimeApp.java
 * Author: Josue Suazo
 * Course: Software Development I CEN-3024C
 * Date: 6/12/2024 (Update 1 6/19/2024)
 * This class contains the main method and provides a command-line interface
 * for interacting with the Anime Database Management System.
 */
public class AnimeApp {

    public static void main(String[] args) {
        AnimeDatabase animeDatabase = new AnimeDatabase();
        loadSampleData(animeDatabase);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Anime Database Management System");
            System.out.println("1. Add Anime");
            System.out.println("2. Remove Anime");
            System.out.println("3. Update Anime");
            System.out.println("4. Search Anime");
            System.out.println("5. Display All Anime");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
                continue;
            }

            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addAnime(animeDatabase, scanner);
                    break;
                case 2:
                    removeAnime(animeDatabase, scanner);
                    break;
                case 3:
                    updateAnime(animeDatabase, scanner);
                    break;
                case 4:
                    searchAnime(animeDatabase, scanner);
                    break;
                case 5:
                    animeDatabase.displayAllAnime();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addAnime(AnimeDatabase animeDatabase, Scanner scanner) {
        try {
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            System.out.print("Enter genre: ");
            String genre = scanner.nextLine();
            System.out.print("Enter episodes: ");
            int episodes = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter rating: ");
            double rating = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter studio: ");
            String studio = scanner.nextLine();
            Anime anime = new Anime(title, genre, episodes, rating, studio);
            animeDatabase.addAnime(anime);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numbers for episodes and rating.");
        }
    }

    private static void removeAnime(AnimeDatabase animeDatabase, Scanner scanner) {
        System.out.print("Enter title of anime to remove: ");
        String titleToRemove = scanner.nextLine();
        boolean removed = animeDatabase.removeAnime(titleToRemove);
        if (removed) {
            System.out.println("Anime removed successfully.");
        } else {
            System.out.println("Anime not found.");
        }
    }

    private static void updateAnime(AnimeDatabase animeDatabase, Scanner scanner) {
        try {
            System.out.print("Enter title of anime to update: ");
            String titleToUpdate = scanner.nextLine();
            System.out.print("Enter new title: ");
            String newTitle = scanner.nextLine();
            System.out.print("Enter new genre: ");
            String newGenre = scanner.nextLine();
            System.out.print("Enter new episodes: ");
            int newEpisodes = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter new rating: ");
            double newRating = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter new studio: ");
            String newStudio = scanner.nextLine();
            Anime updatedAnime = new Anime(newTitle, newGenre, newEpisodes, newRating, newStudio);
            boolean updated = animeDatabase.updateAnime(titleToUpdate, updatedAnime);
            if (updated) {
                System.out.println("Anime updated successfully.");
            } else {
                System.out.println("Anime not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numbers for episodes and rating.");
        }
    }

    private static void searchAnime(AnimeDatabase animeDatabase, Scanner scanner) {
        System.out.print("Enter title of anime to search: ");
        String titleToSearch = scanner.nextLine();
        Anime searchedAnime = animeDatabase.searchAnime(titleToSearch);
        if (searchedAnime != null) {
            searchedAnime.displayAnimeDetails();
        } else {
            System.out.println("Anime not found.");
        }
    }

    private static void loadSampleData(AnimeDatabase animeDatabase) {
        String filename = "Sample_anime.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean isFirstLine = true; // Flag to skip the header line

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the header line
                }

                String[] values = line.split(",");
                if (values.length == 5) {
                    String title = values[0];
                    String genre = values[1];
                    int episodes = Integer.parseInt(values[2]);
                    double rating = Double.parseDouble(values[3]);
                    String studio = values[4];
                    Anime anime = new Anime(title, genre, episodes, rating, studio);
                    animeDatabase.addAnime(anime);
                }
            }
            System.out.println("Sample data loaded successfully.");
        } catch (IOException e) {
            System.err.println("Error loading sample data: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number: " + e.getMessage());
        }
    }
}
