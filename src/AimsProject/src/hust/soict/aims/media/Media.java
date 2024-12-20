package hust.soict.aims.media;

import java.util.Comparator;
	
public abstract class Media {
    private static int idCounter = 0;
    private int id;
    private int numPages;
    private String title;
    private String category;
    private float cost;
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    // Constructor 
    public Media(String title) {
        this.title = title;
        incrementAndSetId();
    }
    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        incrementAndSetId();
    }

	public Media(String title, String category, int numPages, float cost) {
		this.title = title;
        this.category = category;
        this.numPages = numPages;
        this.cost = cost;
        incrementAndSetId();
	}
	// Getter 
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public float getCost() {
        return cost;
    }
    
    private void incrementAndSetId() {
        this.id = ++idCounter;
    }
    
    public abstract String getDetails();
    
    public abstract String getType();
    
  //Setter for title
  	public void setTitle(String title) {
      if (title != null && !title.trim().isEmpty()) {
          	this.title = title;
      	} else {
      		System.out.println("Invalid title. Title cannot be null or empty.");
      	}
  	}
  @Override
  	public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Media media = (Media) o;
        return this.title != null && this.title.equals(media.title);
    }
  
}
