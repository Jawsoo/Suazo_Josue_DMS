package AnimeDatabase;

/**

 * Author: Josue Suazo
 * Course: Software Development I CEN-3024C
 * Date: 6/12/2024
 * Anime.java
 * This class represents an anime object with attributes like title, genre, episodes, etc.
 * It includes getters and setters for each attribute and a method to display anime details.
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

    // Method to display anime details
    public void displayAnimeDetails() {
        System.out.println("Title: " + title);
        System.out.println("Genre: " + genre);
        System.out.println("Episodes: " + episodes);
        System.out.println("Rating: " + rating);
        System.out.println("Studio: " + studio);
    }
}