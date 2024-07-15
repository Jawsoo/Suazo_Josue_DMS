package AnimeDatabase;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AnimeDatabaseTest {
    private AnimeDatabase animeDatabase;

    @Before
    public void setUp() {
        animeDatabase = new AnimeDatabase();
        animeDatabase.connect(System.getProperty("user.home") + "/Desktop/anime_database.sqlite");
    }

    @Test
    public void testAddAnime() {
        Anime anime = new Anime("Naruto", "Action", 220, 8.3, "Studio Pierrot", 2002, 2007, "TV Series");
        animeDatabase.addAnime(anime);
        assertNotNull(animeDatabase.searchAnime("Naruto"));
    }

    @Test
    public void testAddDuplicateAnime() {
        Anime anime1 = new Anime("Naruto", "Action", 220, 8.3, "Studio Pierrot", 2002, 2007, "TV Series");
        Anime anime2 = new Anime("Naruto", "Action", 220, 8.3, "Studio Pierrot", 2002, 2007, "TV Series");
        animeDatabase.addAnime(anime1);
        animeDatabase.addAnime(anime2);
        List<Anime> animeList = animeDatabase.displayAllAnime();
        assertEquals(1, animeList.size());
    }

    @Test
    public void testRemoveAnime() {
        Anime anime = new Anime("Naruto", "Action", 220, 8.3, "Studio Pierrot", 2002, 2007, "TV Series");
        animeDatabase.addAnime(anime);
        animeDatabase.removeAnime("Naruto");
        assertNull(animeDatabase.searchAnime("Naruto"));
    }

    @Test
    public void testRemoveAnimeByStudio() {
        Anime anime = new Anime("Naruto", "Action", 220, 8.3, "Studio Pierrot", 2002, 2007, "TV Series");
        animeDatabase.addAnime(anime);
        animeDatabase.removeAnimeByStudio("Studio Pierrot");
        assertNull(animeDatabase.searchAnime("Naruto"));
    }

    @Test
    public void testUpdateAnime() {
        Anime anime = new Anime("Naruto", "Action", 220, 8.3, "Studio Pierrot", 2002, 2007, "TV Series");
        animeDatabase.addAnime(anime);
        Anime updatedAnime = new Anime("Naruto Shippuden", "Action", 500, 8.7, "Studio Pierrot", 2007, 2017, "TV Series");
        animeDatabase.updateAnime("Naruto", updatedAnime);
        Anime foundAnime = animeDatabase.searchAnime("Naruto Shippuden");
        assertNotNull(foundAnime);
        assertEquals("Naruto Shippuden", foundAnime.getTitle());
    }

    @Test
    public void testDisplayAllAnime() {
        Anime anime1 = new Anime("Naruto", "Action", 220, 8.3, "Studio Pierrot", 2002, 2007, "TV Series");
        Anime anime2 = new Anime("Bleach", "Action", 366, 8.1, "Studio Pierrot", 2004, 2012, "TV Series");
        animeDatabase.addAnime(anime1);
        animeDatabase.addAnime(anime2);
        List<Anime> animeList = animeDatabase.displayAllAnime();
        assertEquals(2, animeList.size());
    }

    @Test
    public void testSearchAnimeByStudio() {
        Anime anime1 = new Anime("Naruto", "Action", 220, 8.3, "Studio Pierrot", 2002, 2007, "TV Series");
        Anime anime2 = new Anime("Bleach", "Action", 366, 8.1, "Studio Pierrot", 2004, 2012, "TV Series");
        animeDatabase.addAnime(anime1);
        animeDatabase.addAnime(anime2);
        List<Anime> animeList = animeDatabase.searchAnimeByStudio("Studio Pierrot");
        assertEquals(2, animeList.size());
    }
}
