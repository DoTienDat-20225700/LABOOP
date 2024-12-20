package hust.soict.aims.media;

public class Track implements Playable {
    private String title;  
    private int length;     

    // Constructor 
    public Track(String title) {
    	this.title = title;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Getter cho title
    public String getTitle() {
        return title;
    }
    
    public int getLength() {
        return length;
    }

    // toString để hiển thị thông tin Track
    @Override
    public String toString() {
        return "Track [title=" + title + ", length=" + length + " seconds]";
    }
    public void play() {
        System.out.println("Playing track: " + this.title);
        System.out.println("Track length: " + this.length);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Track track = (Track) o;
        return this.getTitle().equals(track.getTitle()) && this.length == track.length;
    }
}

