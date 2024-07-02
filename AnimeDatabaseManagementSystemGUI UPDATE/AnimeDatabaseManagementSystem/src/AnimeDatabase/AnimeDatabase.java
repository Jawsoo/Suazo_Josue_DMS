package AnimeDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Josue Suazo
 * Course: Software Development I CEN-3024C
 * Date: 6/12/2024 (Update 1 6/19/2024) (GUI Update 7/1/2024)
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
    public boolean addAnime(Anime anime) {
        if (!isDuplicate(anime.getTitle())) {
            animeList.add(anime);
            System.out.println("Anime '" + anime.getTitle() + "' added successfully.");
            return true;
        } else {
            System.out.println("Anime with the title '" + anime.getTitle() + "' already exists.");
            return false;
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
    public boolean removeAnime(String title) {
        for (Anime anime : animeList) {
            if (anime.getTitle().equalsIgnoreCase(title)) {
                animeList.remove(anime);
                System.out.println("Anime '" + title + "' removed successfully.");
                return true;
            }
        }
        System.out.println("Anime '" + title + "' not found.");
        return false;
    }

    // Remove an anime from the database by studio
    public boolean removeAnimeByStudio(String studio) {
        boolean removed = false;
        for (Anime anime : new ArrayList<>(animeList)) {
            if (anime.getStudio().equalsIgnoreCase(studio)) {
                animeList.remove(anime);
                removed = true;
            }
        }
        if (removed) {
            System.out.println("Animes from studio '" + studio + "' removed successfully.");
        } else {
            System.out.println("Animes from studio '" + studio + "' not found.");
        }
        return removed;
    }

    // Update anime details
    public boolean updateAnime(String title, Anime updatedAnime) {
        for (Anime anime : animeList) {
            if (anime.getTitle().equalsIgnoreCase(title)) {
                anime.setTitle(updatedAnime.getTitle());
                anime.setGenre(updatedAnime.getGenre());
                anime.setEpisodes(updatedAnime.getEpisodes());
                anime.setRating(updatedAnime.getRating());
                anime.setStudio(updatedAnime.getStudio());
                System.out.println("Anime '" + title + "' updated successfully.");
                return true;
            }
        }
        System.out.println("Anime '" + title + "' not found.");
        return false;
    }

    // Search for an anime by title
    public Anime searchAnime(String title) {
        for (Anime anime : animeList) {
            if (anime.getTitle().equalsIgnoreCase(title)) {
                return anime;
            }
        }
        System.out.println("Anime '" + title + "' not found.");
        return null;
    }

    // Search for anime by studio
    public String searchAnimeByStudio(String studio) {
        StringBuilder result = new StringBuilder();
        for (Anime anime : animeList) {
            if (anime.getStudio().equalsIgnoreCase(studio)) {
                result.append(anime).append("\n");
            }
        }
        if (result.length() == 0) {
            return "Animes from studio '" + studio + "' not found.";
        }
        return result.toString();
    }

    // Display all anime in the database
    public String displayAllAnime() {
        if (animeList.isEmpty()) {
            return "No anime in the database.";
        }
        StringBuilder allAnime = new StringBuilder();
        for (Anime anime : animeList) {
            allAnime.append(anime.toString()).append("\n");
        }
        return allAnime.toString();
    }

    // Method to get the list of anime for testing
    public List<Anime> getAnimeList() {
        return animeList;
    }
}
