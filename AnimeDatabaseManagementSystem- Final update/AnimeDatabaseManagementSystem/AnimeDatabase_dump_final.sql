--
-- File generated with SQLiteStudio v3.4.4 on Thu Jul 25 21:58:15 2024
--
-- Text encoding used: UTF-8
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: anime
CREATE TABLE IF NOT EXISTS anime (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title TEXT NOT NULL UNIQUE,
    genre TEXT NOT NULL,
    episodes INTEGER NOT NULL,
    rating REAL NOT NULL,
    studio TEXT NOT NULL,
    start_year INTEGER NOT NULL,
    end_year INTEGER,
    type TEXT NOT NULL
);
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (1, 'Naruto', 'Action', 220, 8.3, 'Studio Pierrot', 2002, 2007, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (2, 'One Piece', 'Adventure', 1000, 9.0, 'Toei Animation', 1999, 'current', 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (3, 'Attack on Titan', 'Action', 75, 9.1, 'Wit Studio', 2013, 2021, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (4, 'Spirited Away', 'Fantasy', 1, 8.6, 'Studio Ghibli', 2001, 2001, 'Movie');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (5, 'My Hero Academia', 'Action', 113, 8.5, 'Bones', 2016, 'current', 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (6, 'Demon Slayer', 'Action', 26, 8.8, 'ufotable', 2019, 2019, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (7, 'Death Note', 'Thriller', 37, 9.0, 'Madhouse', 2006, 2007, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (8, 'Fullmetal Alchemist: Brotherhood', 'Adventure', 64, 9.2, 'Bones', 2009, 2010, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (9, 'Sword Art Online', 'Fantasy', 25, 7.6, 'A-1 Pictures', 2012, 2012, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (10, 'Your Name', 'Romance', 1, 8.4, 'CoMix Wave Films', 2016, 2016, 'Movie');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (11, 'Dragon Ball Z', 'Action', 291, 8.7, 'Toei Animation', 1989, 1996, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (12, 'Cowboy Bebop', 'Sci-Fi', 26, 8.9, 'Sunrise', 1998, 1999, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (13, 'Neon Genesis Evangelion', 'Mecha', 26, 8.5, 'Gainax', 1995, 1996, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (14, 'Bleach', 'Action', 366, 7.9, 'Studio Pierrot', 2004, 2012, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (15, 'Tokyo Ghoul', 'Horror', 24, 7.8, 'Studio Pierrot', 2014, 2014, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (16, 'Fate/stay night: Unlimited Blade Works', 'Fantasy', 26, 8.1, 'ufotable', 2014, 2015, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (17, 'Code Geass', 'Mecha', 50, 8.7, 'Sunrise', 2006, 2008, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (18, 'JoJo''s Bizarre Adventure', 'Adventure', 152, 8.5, 'David Production', 2012, 'current', 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (19, 'Black Clover', 'Fantasy', 170, 7.9, 'Studio Pierrot', 2017, 2021, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (20, 'Fairy Tail', 'Fantasy', 328, 7.7, 'A-1 Pictures', 2009, 2019, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (21, 'My Neighbor Totoro', 'Fantasy', 1, 8.2, 'Studio Ghibli', 1988, 1988, 'Movie');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (22, 'Fate/Zero', 'Action', 25, 8.3, 'Ufotable', 2011, 2012, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (23, 'One Punch Man', 'Action', 12, 8.8, 'Madhouse', 2015, 2015, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (24, 'Gintama', 'Comedy', 367, 8.9, 'Sunrise', 2006, 2018, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (25, 'Re:Zero', 'Fantasy', 25, 8.3, 'White Fox', 2016, 2016, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (26, 'Steins;Gate', 'Sci-Fi', 24, 9.1, 'White Fox', 2011, 2011, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (27, 'Hunter x Hunter', 'Adventure', 148, 9.0, 'Madhouse', 2011, 2014, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (28, 'Mob Psycho 100', 'Action', 25, 8.6, 'Bones', 2016, 2019, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (29, 'Konosuba', 'Comedy', 10, 8.2, 'Studio Deen', 2016, 2016, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (32, 'Naruto Shippuden', 'Action', 500, 8.6, 'Studio Pierrot', 2007, 2017, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (33, 'Dragon Ball', 'Action', 153, 8.5, 'Toei Animation', 1986, 1989, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (34, 'Akira', 'Sci-Fi', 1, 8.0, 'TMS Entertainment', 1988, 1988, 'Movie');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (35, 'Ghost in the Shell', 'Sci-Fi', 1, 8.0, 'Production I.G', 1995, 1995, 'Movie');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (36, 'Princess Mononoke', 'Fantasy', 1, 8.4, 'Studio Ghibli', 1997, 1997, 'Movie');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (37, 'Hellsing Ultimate', 'Action', 10, 8.4, 'Madhouse', 2006, 2012, 'OVA');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (38, 'Kimi no Na wa', 'Romance', 1, 8.4, 'CoMix Wave Films', 2016, 2016, 'Movie');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (39, 'Howl''s Moving Castle', 'Fantasy', 1, 8.2, 'Studio Ghibli', 2004, 2004, 'Movie');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (40, 'The Promised Neverland', 'Horror', 23, 8.6, 'CloverWorks', 2019, 2021, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (41, 'Paranoia Agent', 'Thriller', 13, 8.0, 'Madhouse', 2004, 2004, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (42, 'Elfen Lied', 'Horror', 13, 7.5, 'Arms', 2004, 2004, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (43, 'Claymore', 'Action', 26, 7.8, 'Madhouse', 2007, 2007, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (44, 'Inuyasha', 'Adventure', 167, 7.9, 'Sunrise', 2000, 2004, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (45, 'Great Teacher Onizuka', 'Comedy', 43, 8.5, 'Pierrot', 1999, 2000, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (46, 'Bakuman', 'Slice of Life', 75, 8.3, 'J.C.Staff', 2010, 2013, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (47, 'Anohana', 'Drama', 11, 8.4, 'A-1 Pictures', 2011, 2011, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (48, 'Samurai Champloo', 'Action', 26, 8.5, 'Manglobe', 2004, 2005, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (49, 'Blue Exorcist', 'Action', 25, 7.5, 'A-1 Pictures', 2011, 2011, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (50, 'Erased', 'Thriller', 12, 8.5, 'A-1 Pictures', 2016, 2016, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (51, 'No Game No Life', 'Fantasy', 12, 8.3, 'Madhouse', 2014, 2014, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (52, 'Psycho-Pass', 'Sci-Fi', 22, 8.4, 'Production I.G', 2012, 2013, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (53, 'Noragami', 'Action', 12, 8.0, 'Bones', 2014, 2014, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (54, 'The Seven Deadly Sins', 'Action', 24, 8.1, 'A-1 Pictures', 2014, 2015, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (55, 'Yu Yu Hakusho', 'Adventure', 112, 8.5, 'Pierrot', 1992, 1995, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (56, 'Kuroko no Basket', 'Sports', 75, 8.2, 'Production I.G', 2012, 2015, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (57, 'Rurouni Kenshin', 'Adventure', 95, 8.3, 'Studio Gallop', 1996, 1998, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (58, 'Trigun', 'Action', 26, 8.2, 'Madhouse', 1998, 1998, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (59, 'Tengen Toppa Gurren Lagann', 'Mecha', 27, 8.7, 'Gainax', 2007, 2007, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (60, 'Neon Genesis Evangelion: The End of Evangelion', 'Mecha', 1, 8.6, 'Gainax', 1997, 1997, 'Movie');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (61, 'Clannad', 'Drama', 23, 8.0, 'Kyoto Animation', 2007, 2008, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (62, 'Clannad: After Story', 'Drama', 24, 8.8, 'Kyoto Animation', 2008, 2009, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (63, 'Kill la Kill', 'Action', 24, 8.1, 'Trigger', 2013, 2014, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (64, 'Higurashi: When They Cry', 'Horror', 26, 7.9, 'Studio Deen', 2006, 2006, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (65, 'Monogatari Series', 'Slice of Life', 15, 8.2, 'Shaft', 2009, 2019, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (66, 'Ano Hi Mita Hana no Namae wo Bokutachi wa Mada Shiranai.', 'Drama', 11, 8.5, 'A-1 Pictures', 2011, 2011, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (67, 'Made in Abyss', 'Adventure', 13, 8.8, 'Kinema Citrus', 2017, 2017, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (68, 'Angel Beats!', 'Action', 13, 7.8, 'P.A. Works', 2010, 2010, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (69, 'K-On!', 'Music', 13, 7.9, 'Kyoto Animation', 2009, 2009, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (70, 'Madoka Magica', 'Fantasy', 12, 8.4, 'Shaft', 2011, 2011, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (71, 'Shokugeki no Souma', 'Ecchi', 24, 8.3, 'J.C.Staff', 2015, 2015, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (72, 'Toradora!', 'Romance', 25, 8.2, 'J.C.Staff', 2008, 2009, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (73, 'Boku no Hero Academia', 'Action', 13, 8.2, 'Bones', 2016, 2016, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (74, 'Re:Zero kara Hajimeru Isekai Seikatsu', 'Fantasy', 25, 8.3, 'White Fox', 2016, 2016, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (75, 'Owari no Seraph', 'Action', 12, 7.5, 'Wit Studio', 2015, 2015, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (76, 'Berserk', 'Action', 25, 8.4, 'OLM', 1997, 1998, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (77, 'Log Horizon', 'Adventure', 25, 8.0, 'Satelight', 2013, 2014, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (78, 'Haikyuu!!', 'Sports', 25, 8.5, 'Production I.G', 2014, 2014, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (79, 'Durarara!!', 'Action', 24, 8.2, 'Brain''s Base', 2010, 2010, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (80, 'Nichijou', 'Comedy', 26, 8.5, 'Kyoto Animation', 2011, 2011, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (81, 'Assassination Classroom', 'Comedy', 47, 8.1, 'Lerche', 2015, 2016, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (82, 'Violet Evergarden', 'Drama', 13, 8.6, 'Kyoto Animation', 2018, 2018, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (83, 'Devilman Crybaby', 'Action', 10, 7.6, 'Science SARU', 2018, 2018, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (84, 'The Rising of the Shield Hero', 'Fantasy', 25, 8.0, 'Kinema Citrus', 2019, 2019, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (85, 'Overlord', 'Fantasy', 39, 8.0, 'Madhouse', 2015, 2018, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (86, 'Saiki Kusuo no Psi-nan', 'Comedy', 120, 8.3, 'J.C.Staff', 2016, 2018, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (87, 'Your Lie in April', 'Drama', 22, 8.8, 'A-1 Pictures', 2014, 2015, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (88, 'Goblin Slayer', 'Fantasy', 12, 7.4, 'White Fox', 2018, 2018, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (89, 'Kaguya-sama: Love is War', 'Comedy', 12, 8.5, 'A-1 Pictures', 2019, 2019, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (90, 'D.Gray-man', 'Action', 103, 8.0, 'TMS Entertainment', 2006, 2008, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (91, 'Hyouka', 'Mystery', 22, 8.0, 'Kyoto Animation', 2012, 2012, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (92, 'Shingeki no Kyojin: The Final Season', 'Action', 28, 9.1, 'Mappa', 2020, 2021, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (93, 'A Silent Voice', 'Drama', 1, 8.2, 'Kyoto Animation', 2016, 2016, 'Movie');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (94, 'The Quintessential Quintuplets', 'Comedy', 12, 7.7, 'Tezuka Productions', 2019, 2019, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (95, 'My Hero Academia Season 2', 'Action', 25, 8.4, 'Bones', 2017, 2017, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (96, 'My Hero Academia Season 3', 'Action', 25, 8.5, 'Bones', 2018, 2018, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (97, 'My Hero Academia Season 4', 'Action', 25, 8.1, 'Bones', 2019, 2020, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (98, 'Sword Art Online: Alicization', 'Adventure', 24, 7.6, 'A-1 Pictures', 2018, 2019, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (99, 'Sword Art Online: Alicization - War of Underworld', 'Adventure', 12, 7.9, 'A-1 Pictures', 2019, 2020, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (100, 'The Disastrous Life of Saiki K.', 'Comedy', 120, 8.3, 'J.C.Staff', 2016, 2018, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (101, 'March Comes in Like a Lion', 'Drama', 44, 8.5, 'Shaft', 2016, 2018, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (102, 'Dr. Stone', 'Adventure', 24, 8.2, 'TMS Entertainment', 2019, 2019, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (103, 'Beastars', 'Drama', 12, 8.0, 'Orange', 2019, 2019, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (104, 'Vinland Saga', 'Action', 24, 8.8, 'Wit Studio', 2019, 2019, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (105, 'Promised Neverland Season 2', 'Horror', 11, 5.9, 'CloverWorks', 2021, 2021, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (106, 'Black Lagoon', 'Action', 24, 8.0, 'Madhouse', 2006, 2006, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (107, 'Fruits Basket (2019)', 'Drama', 63, 8.5, 'TMS Entertainment', 2019, 2021, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (108, 'Kakegurui', 'Drama', 12, 7.3, 'Mappa', 2017, 2017, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (109, 'To Your Eternity', 'Adventure', 20, 8.5, 'Brain''s Base', 2021, 2021, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (110, 'Komi Can''t Communicate', 'Comedy', 12, 8.1, 'OLM', 2021, 2021, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (111, 'Chainsaw Man', 'Action', 12, 8.7, 'Mappa', 2022, 2022, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (112, 'Call of the Night', 'Romance', 13, 7.6, 'LIDENFILMS', 2022, 2022, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (113, 'Cyberpunk: Edgerunners', 'Sci-Fi', 10, 8.4, 'Trigger', 2022, 2022, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (114, 'Spy x Family', 'Comedy', 12, 8.9, 'Wit Studio', 2022, 2022, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (115, 'Tower of God', 'Action', 13, 7.8, 'Telecom Animation Film', 2020, 2020, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (116, 'Jujutsu Kaisen', 'Action', 24, 8.8, 'Mappa', 2020, 2021, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (117, 'Horimiya', 'Romance', 13, 8.2, 'CloverWorks', 2021, 2021, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (118, 'Yuru Camp△', 'Slice of Life', 12, 8.3, 'C-Station', 2018, 2018, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (119, 'Wonder Egg Priority', 'Drama', 12, 7.8, 'CloverWorks', 2021, 2021, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (120, 'Hajime no Ippo', 'Action', 75, 8.7, 'Madhouse', 2000, 2002, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (121, 'Mushoku Tensei: Jobless Reincarnation', 'Fantasy', 11, 8.4, 'Studio Bind', 2021, 2021, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (122, 'The God of High School', 'Action', 13, 7.4, 'Mappa', 2020, 2020, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (123, 'Rent-A-Girlfriend', 'Romance', 12, 7.3, 'TMS Entertainment', 2020, 2020, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (124, 'ID: Invaded', 'Thriller', 13, 7.8, 'Naz', 2020, 2020, 'TV');
INSERT INTO anime (id, title, genre, episodes, rating, studio, start_year, end_year, type) VALUES (125, 'Fire Force', 'Action', 24, 7.7, 'David Production', 2019, 2019, 'TV');

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
