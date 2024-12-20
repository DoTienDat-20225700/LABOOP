package hust.soict.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;

import hust.soict.aims.media.Media;
import hust.soict.aims.media.Playable;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        container.add(new JButton("Add to cart"));
        if (media instanceof Playable) {
            container.add(new JButton("Play"));
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    private void addToCart() {
        JOptionPane.showMessageDialog(this, 
            media.getTitle() + " has been added to the cart!", 
            "Add to Cart", 
            JOptionPane.INFORMATION_MESSAGE);
    }

    private void playMedia(Playable playable) {
        JDialog playDialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(this), 
                                         "Playing Media", true);
        playDialog.setSize(300, 150);
        playDialog.setLayout(new BorderLayout());

        JLabel playingLabel = new JLabel("Playing: " + media.getTitle(), SwingConstants.CENTER);
        playDialog.add(playingLabel, BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> playDialog.dispose());
        playDialog.add(closeButton, BorderLayout.SOUTH);

        playDialog.setLocationRelativeTo(this);
        playDialog.setVisible(true);
    }
}
