package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable{
	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	public void play() throws PlayerException {
	    if (this.getLength() <= 0) {
	        throw new PlayerException("ERROR: Track length is non-positive");
	    }
	    System.out.println("Playing Track: " + this.getTitle());
	    System.out.println("Track length: " + this.getLength());
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Track) {
			Track that = (Track) o;
			return (this.title.equals(that.title))&&(this.length == that.length);
		}
		else {
			return false;
		}
	}
}
