package AnimeDatabase;

/**
 * Author: Josue Suazo
 * Course: Software Development I CEN-3024C
 * Date: 6/12/2024 (Update 1 6/19/2024) (GUI Update 7/1/2024)
 * Anime.java
 * This class represents an anime object with its details.
 */
public class Anime {
    private String title;
    private String genre;
    private int episodes;
    private double rating;
    private String studio;

    // Constructor
    public Anime(String title, String genre, int episodes, double rating, String studio) {
        this.title = title;
        this.genre = genre;
        this.episodes = episodes;
        this.rating = rating;
        this.studio = studio;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    @Override
    public String toString() {
        return title + "," + genre + "," + episodes + "," + rating + "," + studio;
    }
}
