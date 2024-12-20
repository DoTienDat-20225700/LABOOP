package hust.soict.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	private static int nbDigitalVideoDiscs = 0;
	
	//Getters
	public static int getNbDigitalVideoDiscs() { 
        return nbDigitalVideoDiscs;
    }
	
	// Constructors
    public DigitalVideoDisc(String title) {
       super(title);
    }

   public DigitalVideoDisc(String category, String title, float cost) {
       super(title, category, cost);
   }

   public DigitalVideoDisc(String director, String category, String title, float cost) {
       super(title, category, director, cost);
   }

   public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
       super(title, category, director, length, cost);
   }
   //toString method to display DVD 
   @Override
   public String toString() {
		return "DigitalVideoDisc [id=" + getId() + ", title=" + getTitle() + ", category=" + getCategory() + ", director=" + getDirector() + ", length="
				+ getLength() + ", cost=" + getCost() + "]";
   }
   public void play() {
       System.out.println("Playing DVD: " + this.getTitle());
       System.out.println("DVD length: " + this.getLength());
   }
  
}



