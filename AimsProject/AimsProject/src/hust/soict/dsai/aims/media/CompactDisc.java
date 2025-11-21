package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc{
	private static int nbCompactDisc = 1;
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	public CompactDisc(String title, String artist, List<Track> tracks) {
		super(nbCompactDisc, title, "", 0, 0, "");
		this.artist = artist;
		this.tracks = tracks;
	}
	
	public void addTrack(Track track) {
		
	}
	
	public void removeTrack(Track track) {
		
	}
	
	public int getLength() {
		int sum = 0;
		for (int i = 0; i < tracks.size(); i++) {
			sum += tracks.get(i).getLength();
		}
		return sum;
	}

}
