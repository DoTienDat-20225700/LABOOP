
import hust.soict.aims.cart.Cart;
import hust.soict.aims.media.*;
import hust.soict.aims.store.Store;
import hust.soict.aims.media.MediaComparatorByCostTitle;
import hust.soict.aims.media.MediaComparatorByTitleCost;

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Aims {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        Store store = new Store();
        Cart cart = new Cart();

        int option = -1;
        while (option != 0) {
        	showMenu();
        	option = scanner.nextInt();
        	scanner.nextLine();
        	switch (option) {
            	case 1:
            		storeMenu(store, cart, scanner);
            		break;
            	case 2: 
            		updateStore(store, scanner);
            		break;
            	case 3: 
            		cartMenu(cart, scanner);
            		break;
            	case 0:
            		break;
            	default:
            		System.out.println("Invalid option. Please try again.");
        	}
        }
	}
	
    public static void showMenu() { 
		System.out.println("AIMS: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. View store"); 
		System.out.println("2. Update store"); 
		System.out.println("3. See current cart"); 
		System.out.println("0. Exit"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3"); 
		} 
	
	public static void storeMenu(Store store, Cart cart, Scanner scanner) { 
		int option = -1;
    	while (option != 0) {
			System.out.println("Options: "); 
			System.out.println("--------------------------------"); 
			System.out.println("1. See a media’s details");
			System.out.println("2. Add a media to cart"); 
			System.out.println("3. Play a media"); 
			System.out.println("4. See current cart"); 
			System.out.println("0. Back"); 
			System.out.println("--------------------------------"); 
			System.out.println("Please choose a number: 0-1-2-3-4"); 
			option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
            case 1: 
                viewMediaDetails(store, scanner, cart);
                break;
            case 2: 
                addMediaToCart(store, cart, scanner);
                break;
            case 3: 
                playMedia(store, scanner);
                break;
            case 4: 
                cart.displayCart();
                break;
            case 0:
                return;
            default:
                System.out.println("Please try again!");
            }
    	}
	}	
	
	public static void viewMediaDetails(Store store, Scanner scanner, Cart cart) {
        System.out.print("Please enter the title: ");
        String title = scanner.nextLine();
        Media media = store.searchMediaByTitle(title);
        if (media != null) {
            mediaDetailsMenu(scanner, media, cart);
        } else {
            System.out.println("Not found!");
        }
    }
	
	
	
	public static void mediaDetailsMenu(Scanner scanner, Media media, Cart cart) { 
		int option = -1;
		while (option != 0) {
			System.out.println("Options: "); 
			System.out.println("--------------------------------"); 
			System.out.println("1. Add to cart"); 
			System.out.println("2. Play"); 
			System.out.println("0. Back"); 
			System.out.println("--------------------------------"); 
			System.out.println("Please choose a number: 0-1-2"); 
			option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Please try again!");
            }
        }
    }
	
	public static void addMediaToCart(Store store, Cart cart, Scanner scanner) {
        System.out.print("Please enter the title of the media you wish to add to the cart: ");
        String title = scanner.nextLine();
        Media media = store.searchMediaByTitle(title);
        if (media != null) {
            cart.addMedia(media);
        } else {
            System.out.println("The specified media could not be found!");
        }
    }
	
	public static void playMedia(Store store, Scanner scanner) {
        System.out.print("Please enter the title of the media you want to play: ");
        String title = scanner.nextLine();
        Media media = store.searchMediaByTitle(title);
        if (media != null) {
            if (media instanceof Playable) {
                ((Playable) media).play();
            } else {
                System.out.println("This media is not playable.");
            }
        } else {
            System.out.println("The specified media could not be found!");
        }
    }
	
	public static void updateStore(Store store, Scanner scanner) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media");
        System.out.println("2. Remove a media");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
        	case 1:
		        System.out.print("Enter media type (Book/DVD/CD): ");
		        String mediaType = scanner.nextLine();
		        if (mediaType.equalsIgnoreCase("Book")) {
		            System.out.print("Enter title, category, cost: ");
		            String title = scanner.nextLine();
		            String category = scanner.nextLine();
		            float cost = scanner.nextFloat();
		            store.addMedia(new Book(title, category, cost));
		        } else if (mediaType.equalsIgnoreCase("DVD")) {
		            System.out.print("Enter title, category, director, length, cost: ");
		            String titleDVD = scanner.nextLine();
		            String categoryDVD = scanner.nextLine();
		            String director = scanner.nextLine();
		            int lengthDVD = scanner.nextInt();
		            float costDVD = scanner.nextFloat();
		            store.addMedia(new DigitalVideoDisc(titleDVD, categoryDVD, director, lengthDVD, costDVD));
		        } else if (mediaType.equalsIgnoreCase("CD")) {
		            System.out.print("Enter title, category, artist, director, length, cost: ");
		            String titleCD = scanner.nextLine();
		            String categoryCD = scanner.nextLine();
		            String artist = scanner.nextLine();
		            String directorCD = scanner.nextLine();
		            int lengthCD = scanner.nextInt();
		            float costCD = scanner.nextFloat();
		            store.addMedia(new CompactDisc(artist, titleCD, categoryCD, directorCD, lengthCD, costCD));
		        } else {
		            System.out.println("Invalid media type!");
		        }
        	case 2:
        		System.out.print("Enter the title of the media to remove: ");
        		String titleToRemove = scanner.nextLine();
        		Media mediaToRemove = store.searchMediaByTitle(titleToRemove);
        		if (mediaToRemove != null) {
        			store.removeMedia(mediaToRemove);
        		} else {
        			System.out.println("Media not found!");
        		}
        		break;
        	case 0:
        		return;
        	default:
        		System.out.println("Invalid option.");
        	}
        }
	
	public static void cartMenu(Cart cart, Scanner scanner) { 
		int option = -1;
		while (option != 0) {
			System.out.println("Options: "); 
			System.out.println("--------------------------------"); 
			System.out.println("1. Filter medias in cart"); 
			System.out.println("2. Sort medias in cart"); 
			System.out.println("3. Remove media from cart"); 
			System.out.println("4. Play a media"); 
			System.out.println("5. Place order"); 
			System.out.println("0. Back"); 
			System.out.println("--------------------------------"); 
			System.out.println("Please choose a number: 0-1-2-3-4-5"); 
			option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
            case 1:
            	filterMediaCart(scanner);
                break;
            case 2:
                sortCart(cart, scanner);
                break;
            case 3:
                removeMediaFromCart(cart, scanner);
                break;
            case 4:
                playMediaFromCart(cart, scanner);
                break;
            case 5:
                placeOrder(cart);
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid option.");
            }
		}
	}
	
	public static ArrayList<Media> filterMediaCart(Scanner aims) {
		ArrayList<Media> filteredList = new ArrayList<>();
		System.out.print("Choose an option to filter Media: ");
		System.out.println("1: By title, 2: By id: ");
		int option = aims.nextInt();
		aims.nextLine();
		while (true) {
			switch (option) {
			case 1:
				System.out.print("Please enter the title: ");
				String title = aims.nextLine();
				for (Media media: Cart.getItemsInCart()) {
					if (media.getTitle().toLowerCase().contains(title.toLowerCase())){
						filteredList.add(media);
					}
				}
				return filteredList;
			case 2:
				System.out.print("Please enter the id: ");
				String id = aims.nextLine();
				for (Media media: Cart.getItemsInCart()) {
					String idString = String.valueOf(media.getId());
					if (id.equals(idString)) {
						filteredList.add(media);
					}
				}
				return filteredList;
			}
		}
	}
	
	public static void sortCart(Cart cart, Scanner scanner) {
        System.out.println("Sort by: ");
        System.out.println("1. Title");
        System.out.println("2. Cost");
        int sortOption = scanner.nextInt();
        scanner.nextLine();
        switch (sortOption) {
            case 1:
            	Collections.sort(cart.getItemsOrdered(), new MediaComparatorByTitleCost());
                break;
            case 2:
                Collections.sort(cart.getItemsOrdered(), new MediaComparatorByCostTitle());
                break;
            default:
                System.out.println("Invalid option.");
                return;
        }
        cart.displayCart();
	}
	public static void removeMediaFromCart(Cart cart, Scanner scanner) {
        System.out.print("Enter media title to remove: ");
        String title = scanner.nextLine();
        Media mediaToRemove = cart.getItemsOrdered().stream()
                .filter(m -> m.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
        if (mediaToRemove != null) {
            cart.removeMedia(mediaToRemove);
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMediaFromCart(Cart cart, Scanner scanner) {
        System.out.print("Enter media title to play: ");
        String title = scanner.nextLine();
        Media mediaToPlay = cart.getItemsOrdered().stream()
                .filter(m -> m.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
        if (mediaToPlay != null && mediaToPlay instanceof Playable) {
            ((Playable) mediaToPlay).play();
        } else {
            System.out.println("Media not found or cannot be played.");
        }
    }

    public static void placeOrder(Cart cart) {
        System.out.println("Order placed! Total Cost: $" + cart.totalCost());
        cart.getItemsOrdered().clear();
        System.out.println("Cart has been cleared.");
    }
	
}
