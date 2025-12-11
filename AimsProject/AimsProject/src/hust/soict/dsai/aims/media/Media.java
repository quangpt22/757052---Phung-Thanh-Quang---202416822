package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
	int id;
	String title;
	String category;
	Float cost;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}
	
	public Media(int id, String title, String category, float cost) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Media) {
			Media that = (Media) o;
			return (this.title.equals(that.title));
		}
		else {
			return false;
		}
	}
	
	@Override
    public String toString() {
        return "Media ID: " + id + " - Title: " + title + " - Category: " + category + " - Cost: $" + cost;
    }

}
