package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable{
	private static int nbCompactDisc = 1;
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	public CompactDisc(String title, String category, float cost, int length, String director, String artist, List<Track> tracks) {
		super(nbCompactDisc, title, category, cost, length, director);
		this.artist = artist;
		this.tracks = tracks;
	}
	
	public void addTrack(Track track) {
		if (!(tracks.contains(track))) {
			tracks.add(track);
		}
		else {
			System.out.println("Track already in disc");
		}
	}
	
	public void removeTrack(Track track) {
		if (tracks.contains(track)) {
			tracks.add(track);
		}
		else {
			System.out.println("Track not in disc");
		}
	}
	
	public int getLength() {
		int sum = 0;
		for (int i = 0; i < tracks.size(); i++) {
			sum += tracks.get(i).getLength();
		}
		return sum;
	}
	
	public void play() throws PlayerException {
	    if (this.getLength() <= 0) {
	        throw new PlayerException("ERROR: CD length is non-positive");
	    }
	    System.out.println("CompactDisc: " + title);
	    System.out.println("Artist: " + artist);
	    for (Track track : tracks) {
	        try {
	            track.play();
	        } catch (PlayerException e) {
	            throw new PlayerException("Cannot play track \"" + track.getTitle() + "\": " + e.getMessage());
	        }
	    }
	}
	
	public String toString() {
		return this.title + " - " + this.category + " - Artist: " + this.artist + " - Director: " + getDirector() + " - Length: " + getLength() + " - $" + getCost();
	}

}
