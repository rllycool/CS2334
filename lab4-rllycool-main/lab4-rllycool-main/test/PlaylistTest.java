import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class PlaylistTest {

	@Test
	void testConstructorFile() throws IOException {
		String info0 = "Fake Plastic Trees; Radiohead; 4:52";
		String info1 = "Subterranean Homesick Alien; Radiohead; 4:27";
		String info2 = "2 + 2 = 5; Radiohead; 3:21";
		
		Playlist playlist = new Playlist("playlists/radiohead.txt");
		assertEquals(info0, playlist.getSong(0).toString());
		assertEquals(info1, playlist.getSong(1).toString());
		assertEquals(info2, playlist.getSong(2).toString());
		
		info0 = "One Big Holiday; My Morning Jacket; 5:21";
		info1 = "Steam Engine; My Morning Jacket; 7:26";
		info2 = "Tropics (Erase Traces); My Morning Jacket; 5:10";
		
		playlist = new Playlist("playlists/my-morning-jacket.txt");
		assertEquals(info0, playlist.getSong(0).toString());
		assertEquals(info1, playlist.getSong(1).toString());
		assertEquals(info2, playlist.getSong(2).toString());
	}
	
	@Test
	void testAddSongsFile() throws IOException {
		String info0 = "A Spoonful Weighs a Ton; The Flaming Lips; 3:32";
		String info1 = "What Is the Light?; The Flaming Lips; 4:05";
		String info2 = "Fight Test; The Flaming Lips; 4:14";
		String info3 = "Yoshimi Battles the Pink Robots, Pt. 1; "
				+ "The Flaming Lips; 4:45";
		String info4 = "Do You Realize??; The Flaming Lips; 3:32";
		String info5 = "The Yeah Yeah Yeah Song (With All Your Power); "
				+ "The Flaming Lips; 4:51";
		
		Playlist playlist = new Playlist();
		playlist.addSongs("playlists/the-flaming-lips-soft-bulletin.txt");
		assertEquals(info0, playlist.getSong(0).toString());
		assertEquals(info1, playlist.getSong(1).toString());
		
		playlist.addSong(new Song(info2));
		assertEquals(info0, playlist.getSong(0).toString());
		assertEquals(info1, playlist.getSong(1).toString());
		assertEquals(info2, playlist.getSong(2).toString());
		
		playlist.addSongs("playlists/the-flaming-lips-yoshimi.txt");
		assertEquals(info0, playlist.getSong(0).toString());
		assertEquals(info1, playlist.getSong(1).toString());
		assertEquals(info2, playlist.getSong(2).toString());
		assertEquals(info3, playlist.getSong(3).toString());
		assertEquals(info4, playlist.getSong(4).toString());
		
		playlist.addSong(new Song(info5));
		assertEquals(info0, playlist.getSong(0).toString());
		assertEquals(info1, playlist.getSong(1).toString());
		assertEquals(info2, playlist.getSong(2).toString());
		assertEquals(info3, playlist.getSong(3).toString());
		assertEquals(info4, playlist.getSong(4).toString());
		assertEquals(info5, playlist.getSong(5).toString());
	}
	
	@Test
	void testToString() {
		String info0 = "Dreams; Fleetwood Mac; 4:14";
		String info1 = "The Chain; Fleetwood Mac; 4:28";
		String info2 = "Silver Springs; Fleetwood Mac; 4:29";
		
		Playlist playlist = new Playlist();
		assertEquals("", playlist.toString());
		
		playlist.addSong(new Song(info0));
		String songStrings = info0;
		assertEquals(songStrings, playlist.toString());
		
		playlist.addSong(new Song(info1));
		songStrings = info0 + System.lineSeparator() + info1;
		assertEquals(songStrings, playlist.toString());
		
		playlist.addSong(new Song(info2));
		songStrings = info0 + System.lineSeparator() + info1 
				+ System.lineSeparator() + info2;
		assertEquals(songStrings, playlist.toString());
	}
	
	@Test
	void testSaveSongs() throws IOException {
		String info0 = "You're All I Need to Get By; "
				+ "Marvin Gaye & Tammi Terrell; 2:38";
		String info1 = "What's Going On; Marvin Gaye; 3:53";
		String info2 = "Trouble Man; Marvin Gaye; 3:49";
		String filename = "playlists/marvin-gaye.txt";
		
		Playlist playlist = new Playlist();
		playlist.addSong(new Song(info0));
		playlist.saveSongs(filename);
		String[] expectedLines = {info0};
		assertTrue(checkFile(expectedLines, filename));
		
		playlist.addSong(new Song(info1));
		playlist.saveSongs(filename);
		expectedLines = new String[] {info0, info1};
		assertTrue(checkFile(expectedLines, filename));
		
		playlist.addSong(new Song(info2));
		playlist.saveSongs(filename);
		expectedLines = new String[] {info0, info1, info2};
		assertTrue(checkFile(expectedLines, filename));
	}
	
	@Test
	void testFindSongsByArtist() {
		
		String info0 = "Fake Plastic Trees; Radiohead; 4:52";
		String info1 = "Subterranean Homesick Alien; Radiohead; 4:27";
		String info2 =  "2 + 2 = 5; Radiohead; 3:21";
		String info3 = "A Spoonful Weighs a Ton; The Flaming Lips; 3:32";
		String info4 = "Stairway to Heaven; Led Zeppelin; 8:02";
		String info5 = "What Is the Light?; The Flaming Lips; 4:05";
		String info6 = "Tropics (Erase Traces); My Morning Jacket; 5:10";
		String info7 = "One Big Holiday; My Morning Jacket; 5:21";
		
		Playlist playlist = new Playlist();
		assertEquals(0, playlist.findSongsByArtist("Radiohead").length);	
		
		playlist.addSong(new Song(info0));
		
		playlist.addSong(new Song(info1));
		
		playlist.addSong(new Song(info2));
		
		playlist.addSong(new Song(info3));
		
		playlist.addSong(new Song(info4));
		
		playlist.addSong(new Song(info5));
		
		playlist.addSong(new Song(info6));
		
		playlist.addSong(new Song(info7));
		
		assertEquals(3, playlist.findSongsByArtist("Radiohead").length);
		assertEquals(1, playlist.findSongsByArtist("Led Zeppelin").length);
		assertEquals(2, playlist.findSongsByArtist("The Flaming Lips").length);
		assertEquals(2, playlist.findSongsByArtist("My Morning Jacket").length);
		
	}
	


	// Define a helper method that checks the lines of a text file.
	private static boolean checkFile(String[] expectedLines, String filename) 
			throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		
		// Return false if any of the lines don't match.
		for (String expected : expectedLines) {
			String actual = reader.readLine();
			if (actual == null || !expected.equals(actual)) {
				reader.close();
				return false;
			}
		}
		
		reader.close();
		return true;
	}
}
