package hust.soict.aims.media;

import java.util.Arrays;

public class TestBook {
    public static void main(String[] args) {
        // Tạo đối tượng sách với nhiều tác giả
        Book book1 = new Book("The Great Gatsby");
        Book book2 = new Book("Fiction", "To Kill a Mockingbird", 12.99f);
        Book book3 = new Book(Arrays.asList("Harper Lee", "Someone Else"), "Fiction", "Go Set a Watchman", 15.99f);
        Book book4 = new Book(Arrays.asList("George Orwell"), "Dystopian", "1984", 13.99f);

        // In thông tin từng cuốn sách
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);
        System.out.println(book4);
    }
}
