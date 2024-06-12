package AnimeDatabase;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**

 * Author: Josue Suazo
 * Course: Software Development I CEN-3024C
 * Date: 6/12/2024
 * AnimeApp.java
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

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter episodes: ");
                    int episodes = scanner.nextInt();
                    System.out.print("Enter rating: ");
                    double rating = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter studio: ");
                    String studio = scanner.nextLine();
                    Anime anime = new Anime(title, genre, episodes, rating, studio);
                    animeDatabase.addAnime(anime);
                    break;
                case 2:
                    System.out.print("Enter title of anime to remove: ");
                    String titleToRemove = scanner.nextLine();
                    animeDatabase.removeAnime(titleToRemove);
                    break;
                case 3:
                    System.out.print("Enter title of anime to update: ");
                    String titleToUpdate = scanner.nextLine();
                    System.out.print("Enter new title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new genre: ");
                    String newGenre = scanner.nextLine();
                    System.out.print("Enter new episodes: ");
                    int newEpisodes = scanner.nextInt();
                    System.out.print("Enter new rating: ");
                    double newRating = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new studio: ");
                    String newStudio = scanner.nextLine();
                    Anime updatedAnime = new Anime(newTitle, newGenre, newEpisodes, newRating, newStudio);
                    animeDatabase.updateAnime(titleToUpdate, updatedAnime);
                    break;
                case 4:
                    System.out.print("Enter title of anime to search: ");
                    String titleToSearch = scanner.nextLine();
                    Anime searchedAnime = animeDatabase.searchAnime(titleToSearch);
                    if (searchedAnime != null) {
                        searchedAnime.displayAnimeDetails();
                    }
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

    /**
     * Loads sample data from a CSV file into the anime database.
     *
     * @param animeDatabase The anime database to populate.
     */
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
