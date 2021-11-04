import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.Throwable;

/** 
 * This class, Playlist, reads a file to add to an ArrayList the song, the artist, and the length of the song.
 * 
 * 
 * @author Ethan Tillotson
 * @version 1.0
 *
 */
public class Playlist {
	
	private ArrayList<Song> songs;
	/**
	 * Constructor for new playlist
	 * 
	 */
	public Playlist() {
		songs = new ArrayList<>();
		
	}
	
	public Playlist(String fileName) {
		
		this();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			while((line = br.readLine()) != null){
				Song song = new Song(line);
				songs.add(song);
			}
			
			
			br.close();
		}
		
		catch(Exception E) {
			E.printStackTrace();
		}
		
		
		
	}
	/**
	 * Getter Method which gets number of songs in array list
	 * 
	 * @return the size of the songs array list
	 */
	public int getNumSongs() {
		return songs.size();
	}
	
	
	/** 
	 * Getter method gets the song at a certian index in the arrayList.
	 * 
	 * 
	 * @param index
	 * @return the song in the array list at the specified index
	 */
	public Song getSong(int index) {
		if (index < 0 || index >= getNumSongs()) {
			return null;
		}
		return songs.get(index);
	}
	/**
	 * converts arrayList songs to an array
	 * @return Song[] contatining the songs arraylist turned to array
	 */
	
	public Song[] getSongs() {
		return songs.toArray(new Song[0]);
	}
	
	/**
	 * Adds parameter song to playlist
	 * @param song you want to add to playlist
	 * @return the arrayList including the now added song
	 */
	
	public boolean addSong(Song song) {
		return addSong(getNumSongs(), song);
	}
	
	/**
	 * Adds a song to a playlist if the condtions are met
	 *
	 * @param index the index you want to put the song at
	 * @param song that you want to add to arraylist 
	 * @return true or false depending on tests
	 */
	
	public boolean addSong(int index, Song song) {
		// TODO: Update the Lab 3 method.
		
		if(song == null || index < 0 || index > songs.size()) {
			return false;
		}
		songs.add(index,song);
		return true;
	}
	
	/**
	 * Adding songs to the end of the playlist
	 * @param playlist playlist you want to create
	 * @return num of added songs
	 */
	public int addSongs(Playlist playlist) {
		
		if (playlist == null) {
			return 0;
		}
		int addedSong =0;
		int temp = playlist.getNumSongs();
		
		for(int i = addedSong; i < temp; ++i) {
			if(!(addSong(playlist.getSong(i)))) {
				return addedSong;
			}
			addedSong++;
		}
		return addedSong;
		
	}
	/**
	 * reads a file of info strings with song names
	 * @param fileName the name of the file to parse
	 * @return num times a song was added
	 */
	public int addSongs(String fileName) {
		int count =0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			while((line = br.readLine()) != null) {
				Song song = new Song(line);
				songs.add(song);
				count++;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * removes the song
	 * 
	 * @return arraylist without the removed object
	 */
	public Song removeSong() {
		return removeSong(getNumSongs() - 1);
	}
	/**
	 * removes the song at the give index
	 * 
	 * @param index
	 * @return null if outofBoudsn .else returns the arraylist
	 */
	public Song removeSong(int index) {
		if(index< 0|| index >= getNumSongs()) {
			return null;
		}
		return songs.remove(index);
	}
	
	/**
	 * saves the output to a file with the given name
	 * @param fileName name of the file to be read
	 */
	
	public void saveSongs(String fileName) {
		
		try { 
			BufferedWriter bw = new BufferedWriter( new FileWriter(fileName));
			bw.write(this.toString());
			bw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
			
		}
	}
	
	
	public String toString() {
		if(getNumSongs()==0 ) {
			return "";
			
		}
		String str = "" + getSong(0);
		for(int i =1; i< getNumSongs(); ++i) {
			str += System.lineSeparator() + getSong(i).toString();
		}
		return str;
	}
	
	/**
	 * 
	 * @param artist
	 * @return
	 */
	public Song[] findSongsByArtist(String artist) {
		ArrayList<Song> listOfSongs = new ArrayList<Song>();
		
		for( Song song: songs) {
			if(song.getArtist().indexOf(artist) != -1) {
				listOfSongs.add(song);
				
			}
		}
		return listOfSongs.stream().toArray(Song[] ::new);
	}
}
