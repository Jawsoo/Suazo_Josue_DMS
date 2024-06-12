package AnimeDatabase;

import java.util.ArrayList;
import java.util.List;

/**

 * Author: Josue Suazo
 * Course: Software Development I CEN-3024C
 * Date: 6/12/2024
 * AnimeDatabase.java
 * This class manages a list of anime objects and provides CRUD operations.
 */
public class AnimeDatabase {
    private final List<Anime> animeList;

    // Constructor
    public AnimeDatabase() {
        this.animeList = new ArrayList<>();
    }

    // Add an anime to the database
    public void addAnime(Anime anime) {
        if (!isDuplicate(anime.getTitle())) {
            animeList.add(anime);
            System.out.println("Anime added successfully.");
        } else {
            System.out.println("Anime with this title already exists.");
        }
    }

    // Check for duplicate anime by title
    private boolean isDuplicate(String title) {
        for (Anime anime : animeList) {
            if (anime.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }

    // Remove an anime from the database by title
    public void removeAnime(String title) {
        for (Anime anime : animeList) {
            if (anime.getTitle().equalsIgnoreCase(title)) {
                animeList.remove(anime);
                System.out.println("Anime removed successfully.");
                return;
            }
        }
        System.out.println("Anime not found.");
    }

    // Update anime details
    public void updateAnime(String title, Anime updatedAnime) {
        for (Anime anime : animeList) {
            if (anime.getTitle().equalsIgnoreCase(title)) {
                anime.setTitle(updatedAnime.getTitle());
                anime.setGenre(updatedAnime.getGenre());
                anime.setEpisodes(updatedAnime.getEpisodes());
                anime.setRating(updatedAnime.getRating());
                anime.setStudio(updatedAnime.getStudio());
                System.out.println("Anime updated successfully.");
                return;
            }
        }
        System.out.println("Anime not found.");
    }

    // Search for an anime by title
    public Anime searchAnime(String title) {
        for (Anime anime : animeList) {
            if (anime.getTitle().equalsIgnoreCase(title)) {
                return anime;
            }
        }
        System.out.println("Anime not found.");
        return null;
    }

    // Display all anime in the database
    public void displayAllAnime() {
        if (animeList.isEmpty()) {
            System.out.println("No anime in the database.");
            return;
        }
        for (Anime anime : animeList) {
            anime.displayAnimeDetails();
            System.out.println("----------------------");
        }
    }
}
