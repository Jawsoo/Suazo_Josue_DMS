package AnimeDatabase;

/**
 * Author: Josue Suazo
 * Course: Software Development I CEN-3024C
 * Date: 6/12/2024 (Update 1 6/19/2024) (GUI Update 7/1/2024) (SQlite update 7/10/2024)
 * Anime.java
 * This class represents an anime object with its details.
 */
public class Anime {
    private String title;
    private String genre;
    private int episodes;
    private double rating;
    private String studio;
    private int startYear;
    private int endYear;
    private String type;

    // Constructor
    public Anime(String title, String genre, int episodes, double rating, String studio, int startYear, int endYear, String type) {
        this.title = title;
        this.genre = genre;
        this.episodes = episodes;
        this.rating = rating;
        this.studio = studio;
        this.startYear = startYear;
        this.endYear = endYear;
        this.type = type;
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

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return title + "," + genre + "," + episodes + "," + rating + "," + studio + "," + startYear + "," + endYear + "," + type;
    }
}
