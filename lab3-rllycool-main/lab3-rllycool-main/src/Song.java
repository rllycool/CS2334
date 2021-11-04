import java.util.Arrays;

public class Song {

	private String title;
	private String artist;
	private int[] time;
	
	public Song(String title, String artist, int[] time) {
		
		this.title = title;
		this.artist = artist;
		int[] Copytime = Arrays.copyOf(time, time.length);
		this.time = Copytime;
	}
	
	public String getTitle() {
		return title; 
	}
	public String getArtist() {		
		return artist; //stub
	}
	public int[] getTime() {
		
		int[] copyTime = Arrays.copyOf(time, time.length);
		return copyTime;//stub
	}
	
	

}
