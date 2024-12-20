package hust.soict.aims.screen;

import java.awt.*;
import javax.swing.*;
import hust.soict.aims.store.Store;
import hust.soict.aims.cart.Cart;
import hust.soict.aims.media.*;
import java.util.ArrayList;

public class StoreScreen extends JFrame {
	private Store store;
	private static Cart cart;
	
	public StoreScreen(Store store, Cart cart) {
	    this.store = store;
	    this.cart = cart;
	    Container cp = getContentPane();
	    cp.setLayout(new BorderLayout());

	    cp.add(createNorth(), BorderLayout.NORTH);
	    cp.add(createCenter(), BorderLayout.CENTER);

	    setVisible(true);
	    setTitle("Store");
	    setSize(1024, 768);
	}

	JPanel createNorth() {
	    JPanel north = new JPanel();
	    north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
	    north.add(createMenuBar());
	    north.add(createHeader());
	    return north;
	}
	
	JMenuBar createMenuBar() {
	    JMenu menu = new JMenu("Options");

	    JMenu smUpdateStore = new JMenu("Update Store");
	    smUpdateStore.add(new JMenuItem("Add Book"));
	    smUpdateStore.add(new JMenuItem("Add CD"));
	    smUpdateStore.add(new JMenuItem("Add DVD"));

	    menu.add(smUpdateStore);
	    menu.add(new JMenuItem("View store"));
	    menu.add(new JMenuItem("View cart"));

	    JMenuBar menuBar = new JMenuBar();
	    menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	    menuBar.add(menu);

	    return menuBar;
	}

	JPanel createHeader() {
	    JPanel header = new JPanel();
	    header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

	    JLabel title = new JLabel("AIMS");
	    title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
	    title.setForeground(Color.CYAN);

	    JButton cart = new JButton("View cart");
	    cart.setPreferredSize(new Dimension(100, 50));
	    cart.setMaximumSize(new Dimension(100, 50));

	    header.add(Box.createRigidArea(new Dimension(10, 10)));
	    header.add(title);
	    header.add(Box.createHorizontalGlue());
	    header.add(cart);
	    header.add(Box.createRigidArea(new Dimension(10, 10)));

	    return header;
	}
	JPanel createCenter() {

	    JPanel center = new JPanel();
	    center.setLayout(new GridLayout(3, 3, 2, 2));

	    ArrayList<Media> mediaInStore = store.getItemsInStore();
	    int numberOfCells = Math.min(9, mediaInStore.size());  
	    for (int i = 0; i < numberOfCells; i++) {
	        MediaStore cell = new MediaStore(mediaInStore.get(i));
	        center.add(cell);
	    }

	    return center;
	}
	
    public static void main(String[] args) {
        Store store = new Store();
        store.addMedia(new Book("Conan", "Detective Fiction", 20.50f));
        store.addMedia(new DigitalVideoDisc("Avengers", "Science Fiction", "Anthony Russo", 1000, 59.99f));
        store.addMedia(new CompactDisc("Duong Domic", "Du Lieu Quy", "VPOP", "DAO Entertainment", 500, 20.99f));
        store.addMedia(new Book("Doraemon", "Manga", 18.50f));
        SwingUtilities.invokeLater(() -> new StoreScreen(store, cart));
    }


}

