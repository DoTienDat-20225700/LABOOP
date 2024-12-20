package hust.soict.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;                  
	private ArrayList<Track> tracks = new ArrayList<>();
	
    // Constructor 
	public CompactDisc(String title ,String category, String artist, float cost) {
		super(title, category, cost);
		this.artist = artist;
	}
    public CompactDisc(String artist, String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost); 
        this.artist = artist;
    }
    public CompactDisc(String artist, String title, String category, String director, float cost) {
        super(title, category, director, cost); 
        this.artist = artist;
    }
    // Getter 
    public String getArtist() {
        return artist;
    }
    
    // Add a track to a list
    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("The track " + track.getTitle() + " is already in the list.");
        } else {
            tracks.add(track);
            System.out.println("The track " + track.getTitle() + " has been added to the CD.");
        }
    }

    // Remove a track
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("The track " + track.getTitle() + " has been removed from the CD.");
        } else {
            System.out.println("The track " + track.getTitle() + " is not found in the list.");
        }
    }

    // Sum of lengths of all tracks
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    // toString để hiển thị thông tin của CompactDisc
    @Override
    public String toString() {
        return "CompactDisc [artist=" + artist + ", title=" + getTitle() + ", category=" + getCategory() +
               ", cost=" + getCost() + ", length=" + getLength() + " seconds]";
    }
    
    public void play() {
        System.out.println("Playing Compact Disc: " + this.getTitle());
        System.out.println("Artist: " + this.artist);
        System.out.println("Tracks:");

        for (Track track : tracks) {
            track.play(); 
        }
    }
}
