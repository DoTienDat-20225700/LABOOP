package hust.soict.aims.media;

public class Disc extends Media {
    private int length;      
    private String director; 
    
    // Getter 
    public int getLength() {
        return length;
    }
    public String getDirector() {
        return director;
    }

    // Constructor 
    public Disc(String title) {
        super(title);
    }

    public Disc(String category, String title, float cost) {
        super(title, category, cost);
    }

    public Disc(String director, String category, String title, float cost){
        super(title, category, cost);
        this.director = director;
    }
    
    public Disc(String title, String category, String director, int length, float cost) {
        super(title, category, cost); 
        this.length = length;
        this.director = director;
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
