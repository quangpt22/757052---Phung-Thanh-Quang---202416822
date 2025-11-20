package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc{
	private static int nbDigitalVideoDiscs = 1;
	
	public DigitalVideoDisc(String title) {
		super(nbDigitalVideoDiscs++, title, "", 0.0f, 0, "");
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super(nbDigitalVideoDiscs++, title, category, cost, 0, "");
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(nbDigitalVideoDiscs++, title, category, cost, length, director);
	}

	public String toString() {
		return id + ". " + title + " - " + category + " - " + getDirector() + " - " + getLength() + " mins - " + cost + "$";
	}

	public boolean isMatch(String title) {
		String tmp = this.title.toLowerCase();
		if (tmp.contains(title.toLowerCase())) {
			return true;
		}
		else {
			return false;
		}
	}
}
