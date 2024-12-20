package hust.soict.aims.cart;

import java.util.Collections;
import java.util.ArrayList;

import hust.soict.aims.media.Media;
import hust.soict.aims.media.DigitalVideoDisc;
import hust.soict.aims.media.MediaComparatorByCostTitle;
import hust.soict.aims.media.MediaComparatorByTitleCost;
import javafx.collections.ObservableList;


public class Cart {
    // Use ArrayList instead of an array to store ordered items
    private static ObservableList<Media> itemsOrdered = (ObservableList<Media>) new ArrayList<Media>();

    // Add a Media (DigitalVideoDisc, CompactDisc, etc.) to the cart
    public void addMedia(Media media) {
        itemsOrdered.add(media);
        System.out.println("The media " + media.getTitle() + " has been added.");
    }

    // Add a list of Media to the cart
    public void addMedia(Media[] mediaList) {
        for (Media media : mediaList) {
            itemsOrdered.add(media);
            System.out.println("The media " + media.getTitle() + " has been added.");
        }
    }

    // Remove a Media from the cart
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media " + media.getTitle() + " has been removed.");
        } else {
            System.out.println("The media " + media.getTitle() + " is not in the cart.");
        }
    }

    // Calculate the total cost of the cart
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost(); 
        }
        return total;
    }

    // Display the media in the cart
    public void displayCart() {
        System.out.println("***************CART****************");
        System.out.println("Ordered Items:");

        for (int i = 0; i < itemsOrdered.size(); i++) {
            Media media = itemsOrdered.get(i);
            System.out.printf("%d. %s - [%s] - [%s] - [%s] - [%d]: [%.2f] $\n", 
                i + 1,
                media.getTitle(),
                media.getCategory() == null ? "Unknown Category" : media.getCategory(),
                media instanceof DigitalVideoDisc ? ((DigitalVideoDisc) media).getDirector() : "Unknown Director",
                media instanceof DigitalVideoDisc ? ((DigitalVideoDisc) media).getLength() : "N/A",
                media.getCost()
            );
        }

        System.out.printf("Total cost: [%.2f] $\n", totalCost());
        System.out.println("************************************");
    }

    // Search for a media by ID
    public void searchById(int id) {
        boolean found = false; 
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Media Found: " + media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No media found with ID: " + id);
        }
    }

    // Search for a media by title
    public void searchByTitle(String title) {
        boolean found = false; 
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Media Found: " + media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found with the title: " + title);
        }
    }
    
    public void sortByTitleThenCost() {
        Collections.sort(itemsOrdered, new MediaComparatorByTitleCost());
        System.out.println("\nCart sorted by Title then Cost:");
        displayCart();
    }

    public void sortByCostThenTitle() {
        Collections.sort(itemsOrdered, new MediaComparatorByCostTitle());
        System.out.println("\nCart sorted by Cost then Title:");
        displayCart();
    }
    
    public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
    
    public static ObservableList<Media> getItemsInCart(){
		return itemsOrdered;
	}
    
    public int getSize() {
		return Cart.itemsOrdered.size();
    }
    
    public void empty() {
    	Cart.itemsOrdered.clear();
	}
    
}
