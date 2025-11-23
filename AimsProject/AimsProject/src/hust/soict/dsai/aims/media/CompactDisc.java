package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

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
	
	public void play() {
		System.out.println("CompactDisc: " + title);
		System.out.println("Artist: " + artist);
		for (int i = 0; i < tracks.size(); i++) {
			tracks.get(i).play();
		}
	}
	
	public String toString() {
		return this.title + " - " + this.category + " - Artist: " + this.artist + " - Director: " + getDirector() + " - Length: " + getLength() + " - $" + getCost();
	}

}
