package AnimeDatabase;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * AnimeDatabaseTest.java
 * Author: Josue Suazo
 * Course: Software Development I CEN-3024C
 * Date: 6/19/2024
 * This class contains unit tests for the AnimeDatabase class.
 * It verifies that the methods in AnimeDatabase work correctly under various conditions.
 */
public class AnimeDatabaseTest {
    private AnimeDatabase animeDatabase;

    @Before
    public void setUp() {
        animeDatabase = new AnimeDatabase();
    }

    @Test
    public void testAddAnime() {
        Anime anime = new Anime("Naruto", "Action", 220, 8.3, "Studio Pierrot");
        animeDatabase.addAnime(anime);
        assertNotNull(animeDatabase.searchAnime("Naruto"));
    }

    @Test
    public void testAddDuplicateAnime() {
        Anime anime1 = new Anime("Naruto", "Action", 220, 8.3, "Studio Pierrot");
        Anime anime2 = new Anime("Naruto", "Action", 220, 8.3, "Studio Pierrot");
        animeDatabase.addAnime(anime1);
        animeDatabase.addAnime(anime2);

        // Ensure only one instance of Naruto exists by checking the size of the animeList
        List<Anime> animeList = animeDatabase.getAnimeList();
        long count = animeList.stream().filter(a -> a.getTitle().equalsIgnoreCase("Naruto")).count();
        assertEquals(1, count);
    }

    @Test
    public void testRemoveAnime() {
        Anime anime = new Anime("Naruto", "Action", 220, 8.3, "Studio Pierrot");
        animeDatabase.addAnime(anime);
        assertTrue(animeDatabase.removeAnime("Naruto"));
        assertNull(animeDatabase.searchAnime("Naruto"));
    }

    @Test
    public void testRemoveNonExistentAnime() {
        assertFalse(animeDatabase.removeAnime("NonExistentAnime"));
    }

    @Test
    public void testUpdateAnime() {
        Anime anime = new Anime("Naruto", "Action", 220, 8.3, "Studio Pierrot");
        animeDatabase.addAnime(anime);
        Anime updatedAnime = new Anime("Naruto Shippuden", "Action", 500, 8.6, "Studio Pierrot");
        assertTrue(animeDatabase.updateAnime("Naruto", updatedAnime));
        assertEquals(500, animeDatabase.searchAnime("Naruto Shippuden").getEpisodes());
    }

    @Test
    public void testUpdateNonExistentAnime() {
        Anime updatedAnime = new Anime("Naruto Shippuden", "Action", 500, 8.6, "Studio Pierrot");
        assertFalse(animeDatabase.updateAnime("NonExistentAnime", updatedAnime));
    }

    @Test
    public void testSearchAnime() {
        Anime anime = new Anime("Naruto", "Action", 220, 8.3, "Studio Pierrot");
        animeDatabase.addAnime(anime);
        assertNotNull(animeDatabase.searchAnime("Naruto"));
    }

    @Test
    public void testSearchNonExistentAnime() {
        assertNull(animeDatabase.searchAnime("NonExistentAnime"));
    }
}
