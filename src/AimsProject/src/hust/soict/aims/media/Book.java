package hust.soict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	
	//Getters
	public List<String> getAuthors() {
		return authors;
	}
	
	//Constructor
	public Book(String title) {
		super(title);
    }
	public Book(String title, String category, float cost) {
        super(title, category, cost); 
    }
	public Book(List<String> authors, String category, String title, float cost) {
        super(title, category, cost);  
        this.authors = authors;  
	}

	public Book(String title, String category, int numPages, float cost) {
		super(title, category, numPages, cost);
	}

	// Add an author to the authors list
    public void addAuthor(String authorName) {
        if (authors.size() < 100) { 
            if (!authors.contains(authorName)) {
                authors.add(authorName);
                System.out.println("The author " + authorName + " has been added to the book.");
            } else {
                System.out.println("The author " + authorName + " is already in the list.");
            }
        } else {
            System.out.println("The author list is full. Cannot add more authors.");
        }
    }

    // Remove an author from the authors list
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("The author " + authorName + " has been removed from the book.");
        } else {
            System.out.println("The author " + authorName + " is not found in the list.");
        }
    }
    // toString method for displaying book details
    @Override
    public String toString() {
        return "Book [id=" + getId() + ", title=" + getTitle() + ", category=" + getCategory() + ", authors=" + authors + ", cost=" + getCost() + "]";
    }

	@Override
	public String getDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}
}
	
