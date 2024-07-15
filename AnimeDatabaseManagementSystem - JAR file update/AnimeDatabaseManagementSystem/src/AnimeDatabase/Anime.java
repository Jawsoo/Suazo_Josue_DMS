/**
 * Author: Josue Suazo
 * Course: Software Development I CEN-3024C
 * Date: 6/12/2024 (Update 1 6/19/2024) (GUI Update 7/1/2024) (SQlite update 7/10/2024) (Jar update 7/14/2024)
 * Anime.java
 * This class represents an anime entity in the Anime Database Management System.
 * It contains properties for title, genre, episodes, rating, studio, start year, end year, and type.
 */

package AnimeDatabase;

import javafx.beans.property.*;

public class Anime {
    private final StringProperty title;
    private final StringProperty genre;
    private final IntegerProperty episodes;
    private final DoubleProperty rating;
    private final StringProperty studio;
    private final IntegerProperty startYear;
    private final IntegerProperty endYear;
    private final StringProperty type;

    /**
     * Constructor to initialize an Anime object with specified values.
     *
     * @param title     the title of the anime
     * @param genre     the genre of the anime
     * @param episodes  the number of episodes of the anime
     * @param rating    the rating of the anime
     * @param studio    the studio that produced the anime
     * @param startYear the year the anime started airing
     * @param endYear   the year the anime ended airing
     * @param type      the type of the anime (e.g., TV, Movie, OVA, ONA)
     */
    public Anime(String title, String genre, int episodes, double rating, String studio, int startYear, int endYear, String type) {
        this.title = new SimpleStringProperty(title);
        this.genre = new SimpleStringProperty(genre);
        this.episodes = new SimpleIntegerProperty(episodes);
        this.rating = new SimpleDoubleProperty(rating);
        this.studio = new SimpleStringProperty(studio);
        this.startYear = new SimpleIntegerProperty(startYear);
        this.endYear = new SimpleIntegerProperty(endYear);
        this.type = new SimpleStringProperty(type);
    }

    /**
     * Gets the title property of the anime.
     *
     * @return the title property
     */
    public StringProperty titleProperty() {
        return title;
    }

    /**
     * Gets the title of the anime.
     *
     * @return the title
     */
    public String getTitle() {
        return title.get();
    }

    /**
     * Sets the title of the anime.
     *
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title.set(title);
    }

    /**
     * Gets the genre property of the anime.
     *
     * @return the genre property
     */
    public StringProperty genreProperty() {
        return genre;
    }

    /**
     * Gets the genre of the anime.
     *
     * @return the genre
     */
    public String getGenre() {
        return genre.get();
    }

    /**
     * Sets the genre of the anime.
     *
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre.set(genre);
    }

    /**
     * Gets the episodes property of the anime.
     *
     * @return the episodes property
     */
    public IntegerProperty episodesProperty() {
        return episodes;
    }

    /**
     * Gets the number of episodes of the anime.
     *
     * @return the number of episodes
     */
    public int getEpisodes() {
        return episodes.get();
    }

    /**
     * Sets the number of episodes of the anime.
     *
     * @param episodes the number of episodes to set
     */
    public void setEpisodes(int episodes) {
        this.episodes.set(episodes);
    }

    /**
     * Gets the rating property of the anime.
     *
     * @return the rating property
     */
    public DoubleProperty ratingProperty() {
        return rating;
    }

    /**
     * Gets the rating of the anime.
     *
     * @return the rating
     */
    public double getRating() {
        return rating.get();
    }

    /**
     * Sets the rating of the anime.
     *
     * @param rating the rating to set
     */
    public void setRating(double rating) {
        this.rating.set(rating);
    }

    /**
     * Gets the studio property of the anime.
     *
     * @return the studio property
     */
    public StringProperty studioProperty() {
        return studio;
    }

    /**
     * Gets the studio of the anime.
     *
     * @return the studio
     */
    public String getStudio() {
        return studio.get();
    }

    /**
     * Sets the studio of the anime.
     *
     * @param studio the studio to set
     */
    public void setStudio(String studio) {
        this.studio.set(studio);
    }

    /**
     * Gets the start year property of the anime.
     *
     * @return the start year property
     */
    public IntegerProperty startYearProperty() {
        return startYear;
    }

    /**
     * Gets the start year of the anime.
     *
     * @return the start year
     */
    public int getStartYear() {
        return startYear.get();
    }

    /**
     * Sets the start year of the anime.
     *
     * @param startYear the start year to set
     */
    public void setStartYear(int startYear) {
        this.startYear.set(startYear);
    }

    /**
     * Gets the end year property of the anime.
     *
     * @return the end year property
     */
    public IntegerProperty endYearProperty() {
        return endYear;
    }

    /**
     * Gets the end year of the anime.
     *
     * @return the end year
     */
    public int getEndYear() {
        return endYear.get();
    }

    /**
     * Sets the end year of the anime.
     *
     * @param endYear the end year to set
     */
    public void setEndYear(int endYear) {
        this.endYear.set(endYear);
    }

    /**
     * Gets the type property of the anime.
     *
     * @return the type property
     */
    public StringProperty typeProperty() {
        return type;
    }

    /**
     * Gets the type of the anime.
     *
     * @return the type
     */
    public String getType() {
        return type.get();
    }

    /**
     * Sets the type of the anime.
     *
     * @param type the type to set
     */
    public void setType(String type) {
        this.type.set(type);
    }
}
