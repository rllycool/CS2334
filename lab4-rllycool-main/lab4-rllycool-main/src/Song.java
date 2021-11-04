import java.util.Arrays;

public class Song {
	
	private String title;
	private String artist;
	private int[] time;
	
	private static final String INFO_DELIMITER = "; ";
	private static final String TIME_DELIMITER = ":";
			
	private static final int IDX_TITLE = 0;
	private static final int IDX_ARTIST = 1;
	private static final int IDX_TIME = 2;
	
	public Song(String title, String artist, int[] time) {
		this.title = title;
		this.artist = artist;
		this.time = Arrays.copyOf(time, time.length);
	}
	
	public Song(String info) {
		
		 String[] songInfo = info.split(INFO_DELIMITER);
	
		 this.title = songInfo[0];
		 this.artist = songInfo[1];
		 
		 
		 String[] timeSplit;
		 int hours =0;
		 int minutes =0;
		 int seconds =0 ;
		
		 hours = Integer.parseInt(timeSplit[0]);
		 minutes = Integer.parseInt(timeSplit[1]);
		 seconds = Integer.parseInt(timeSplit[2]);
		 
		 timeSplit =  songInfo[2].split(TIME_DELIMITER);
		 
		 if(timeSplit.length == 1) {
			 
			 seconds = Integer.parseInt(timeSplit[0]);
			// int[] timeTempy = {seconds};
			 
		 }
		 if(timeSplit.length == 2) {
			 
			 minutes = Integer.parseInt(timeSplit[0]);
			 seconds = Integer.parseInt(timeSplit[1]);
			// int[] timeTempy = {minutes,seconds};
		 }
		
		 if(timeSplit.length ==3) {
			 
			 hours = Integer.parseInt(timeSplit[0]);
			 minutes = Integer.parseInt(timeSplit[1]);
			 seconds = Integer.parseInt(timeSplit[2]);
			 //int[] timeTempy =  {hours,minutes,seconds};
		 }
		 
		 	if(hours == 0 && minutes == 0) {
		 		
		 		
		 		
		 	}
		
		 int[] yeah = {hours,minutes,seconds};
		 
		Song song = new Song(this.title,this.artist, yeah);
		
	}
	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public int[] getTime() {
		return Arrays.copyOf(time, time.length);
	}
	@Override
	public String toString() {
		
		return (title + INFO_DELIMITER + artist + INFO_DELIMITER + time);
	}
}
