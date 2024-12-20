package hust.soict.test.store;
import hust.soict.aims.media.DigitalVideoDisc;
import hust.soict.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // Create a new store
        Store store = new Store();

        // Create new DVD objects
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);

        // Add DVDs to the store
        store.addMedia(dvd1);
        store.addMedia(dvd2);

        // Remove a DVD from the store
        store.removeMedia(dvd1);

        // Attempt to remove a DVD not in the store
        store.removeMedia(dvd1); // Should display not found
    }
}
