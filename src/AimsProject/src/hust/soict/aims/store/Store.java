package hust.soict.aims.store;

import hust.soict.aims.media.Media;
import java.util.ArrayList;

public class Store {
    public static final int MAX_NUMBERS_IN_STORE = 50;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();  
    // Add a Media to the store 
    public void addMedia(Media media) {
        if (itemsInStore.size() < MAX_NUMBERS_IN_STORE) {
            itemsInStore.add(media);  // Add the media to the ArrayList
            System.out.println("The media " + media.getTitle() + " has been added to the store.");
        } else {
            System.out.println("The store is full. Cannot add more media.");
        }
    }

    // Remove a Media from the store
    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);  
            System.out.println("The media " + media.getTitle() + " has been removed from the store.");
        } else {
            System.out.println("The media " + media.getTitle() + " is not found in the store.");
        }
    }
    
    // Search a Media by title
    public Media searchMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }
    
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}
