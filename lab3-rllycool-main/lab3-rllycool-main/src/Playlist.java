import java.util.Arrays;


public class Playlist {
	
	private Song[] songs;
	private int numSongs;
	
	private static final int MIN_CAPACITY = 3;

	public Playlist() {
		//new Song[]
		songs= new Song[MIN_CAPACITY];
	} 
	public Playlist(int capacity) {

		if(capacity < MIN_CAPACITY) {
			songs = new Song[MIN_CAPACITY];
		}
		else {
			songs= new Song[capacity];
		}
	}
	
	//getters
	public int getCapacity() {
		
		int theLength = songs.length;
		return theLength; 
	}
	
	public int getNumSongs() {
		return numSongs;
	}
	
	public Song getSong(int index) {
		if(index < 0 || index >= numSongs) {
			return null;
		}
		
		return songs[index];
	}
	
	public Song[] getSongs() {
		
		Song copyOfSongs[] = new Song[numSongs];
		for(int i = 0; i<numSongs; i++) {
			
			copyOfSongs[i] = songs[i];
			
		}
		return copyOfSongs;
	}
	
	//Song Adders
	
	public boolean addSong(Song song) {
	
		
		return addSong(numSongs,song);
		
	}
	//worked with SofDogs on this method
	public boolean addSong(int index, Song song) {
		
		if(numSongs == songs.length || (index < 0 || index  > numSongs) || song == null) {
			return false;
		}
		else {
			for(int i = numSongs-1; i>= index ; --i) {
				songs[i+1] = songs[i];
			}
			songs[index] = song;
			numSongs++;
		
			return true; //stub
		}
	}
	//recieved help from Trevor maxwell on discord
	public int addSongs(Playlist playlist) {
		if(playlist ==  null) {
			return 0;
		}
		int songAdded = 0;
		int bro = playlist.numSongs;
		for(int i= songAdded; i < bro ; i++) {
			if(!(addSong(playlist.getSong(i)))){
				
				return songAdded;
			
			}
			songAdded++;
		}
		return songAdded; 
		
	}
	
	//Song Removers
	
	public Song removeSong() {
		return removeSong(numSongs-1);
		}
	
	//worked with sofia dogs on this method
	
	public Song removeSong(int index) {
	
		
		if(index < 0 || index >= numSongs) {
			return null;
	
		}
		Song returnedSong = songs[index];
		
		for(int i =index; i < numSongs-1; ++i) {
			songs[i] = songs[i+1];
			
		}
		numSongs--;
		return returnedSong;
	}
	
	
}
