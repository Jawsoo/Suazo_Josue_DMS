package AnimeDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Josue Suazo
 * Course: Software Development I CEN-3024C
 * Date: 6/12/2024 (Update 1 6/19/2024) (GUI Update 7/1/2024) (SQLite update 7/10/2024) (Jar update 7/14/2024)
 * AnimeDatabase.java
 * This class provides the database management for the Anime Database Management System.
 */
public class AnimeDatabase {
    private Connection connection;

    /**
     * Default constructor for the AnimeDatabase class.
     */
    public AnimeDatabase() {
        // Default constructor
    }

    /**
     * Connects to the SQLite database with the provided path.
     *
     * @param dbPath the path to the SQLite database file
     */
    public void connect(String dbPath) {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
            System.out.println("Connected to the database successfully.");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error connecting to SQLite database: " + e.getMessage());
            connection = null;
        }
    }

    /**
     * Adds an anime to the database.
     *
     * @param anime the Anime object to add
     * @return true if the anime was added successfully, false otherwise
     */
    public boolean addAnime(Anime anime) {
        if (connection == null) {
            System.err.println("Connection is null. Cannot add anime.");
            return false;
        }

        String sql = "INSERT INTO anime (title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, anime.getTitle());
            pstmt.setString(2, anime.getGenre());
            pstmt.setInt(3, anime.getEpisodes());
            pstmt.setDouble(4, anime.getRating());
            pstmt.setString(5, anime.getStudio());
            pstmt.setInt(6, anime.getStartYear());
            pstmt.setInt(7, anime.getEndYear());
            pstmt.setString(8, anime.getType());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error adding anime: " + e.getMessage());
            return false;
        }
    }

    /**
     * Removes an anime from the database by title.
     *
     * @param title the title of the anime to remove
     * @return true if the anime was removed successfully, false otherwise
     */
    public boolean removeAnime(String title) {
        if (connection == null) {
            System.err.println("Connection is null. Cannot remove anime.");
            return false;
        }

        String sql = "DELETE FROM anime WHERE title = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, title);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Error removing anime: " + e.getMessage());
            return false;
        }
    }

    /**
     * Removes an anime from the database by studio.
     *
     * @param studio the studio of the anime to remove
     * @return true if the anime was removed successfully, false otherwise
     */
    public boolean removeAnimeByStudio(String studio) {
        if (connection == null) {
            System.err.println("Connection is null. Cannot remove anime.");
            return false;
        }

        String sql = "DELETE FROM anime WHERE studio = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, studio);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Error removing anime: " + e.getMessage());
            return false;
        }
    }

    /**
     * Updates an anime in the database.
     *
     * @param title the title of the anime to update
     * @param updatedAnime the updated Anime object
     * @return true if the anime was updated successfully, false otherwise
     */
    public boolean updateAnime(String title, Anime updatedAnime) {
        if (connection == null) {
            System.err.println("Connection is null. Cannot update anime.");
            return false;
        }

        String sql = "UPDATE anime SET title = ?, genre = ?, episodes = ?, rating = ?, studio = ?, start_year = ?, end_year = ?, type = ? WHERE title = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, updatedAnime.getTitle());
            pstmt.setString(2, updatedAnime.getGenre());
            pstmt.setInt(3, updatedAnime.getEpisodes());
            pstmt.setDouble(4, updatedAnime.getRating());
            pstmt.setString(5, updatedAnime.getStudio());
            pstmt.setInt(6, updatedAnime.getStartYear());
            pstmt.setInt(7, updatedAnime.getEndYear());
            pstmt.setString(8, updatedAnime.getType());
            pstmt.setString(9, title);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Error updating anime: " + e.getMessage());
            return false;
        }
    }

    /**
     * Searches for an anime by title.
     *
     * @param title the title of the anime to search for
     * @return the Anime object if found, null otherwise
     */
    public Anime searchAnime(String title) {
        if (connection == null) {
            System.err.println("Connection is null. Cannot search anime.");
            return null;
        }

        String sql = "SELECT * FROM anime WHERE title = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, title);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Anime(
                        rs.getString("title"),
                        rs.getString("genre"),
                        rs.getInt("episodes"),
                        rs.getDouble("rating"),
                        rs.getString("studio"),
                        rs.getInt("start_year"),
                        rs.getInt("end_year"),
                        rs.getString("type")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error searching anime: " + e.getMessage());
        }
        return null;
    }

    /**
     * Searches for anime by studio.
     *
     * @param studio the studio of the anime to search for
     * @return a list of Anime objects if found, empty list otherwise
     */
    public List<Anime> searchAnimeByStudio(String studio) {
        if (connection == null) {
            System.err.println("Connection is null. Cannot search anime.");
            return new ArrayList<>();
        }

        List<Anime> animeList = new ArrayList<>();
        String sql = "SELECT * FROM anime WHERE studio = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, studio);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                animeList.add(new Anime(
                        rs.getString("title"),
                        rs.getString("genre"),
                        rs.getInt("episodes"),
                        rs.getDouble("rating"),
                        rs.getString("studio"),
                        rs.getInt("start_year"),
                        rs.getInt("end_year"),
                        rs.getString("type")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error searching anime: " + e.getMessage());
        }
        return animeList;
    }

    /**
     * Displays all anime in the database.
     *
     * @return a list of all Anime objects in the database
     */
    public List<Anime> displayAllAnime() {
        if (connection == null) {
            System.err.println("Connection is null. Cannot display anime.");
            return new ArrayList<>();
        }

        List<Anime> animeList = new ArrayList<>();
        String sql = "SELECT * FROM anime";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                animeList.add(new Anime(
                        rs.getString("title"),
                        rs.getString("genre"),
                        rs.getInt("episodes"),
                        rs.getDouble("rating"),
                        rs.getString("studio"),
                        rs.getInt("start_year"),
                        rs.getInt("end_year"),
                        rs.getString("type")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error displaying all anime: " + e.getMessage());
        }
        return animeList;
    }
}
