package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media media1, Media media2) {
        // First compare by title, then by cost
        return Comparator.comparing(Media::getTitle)
                        .thenComparing(Media::getCost)
                        .compare(media1, media2);
    }
}
