import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.Frame;
import java.io.*;
import java.awt.event.WindowEvent.*;

public class ArtGalleryGUI{
    ArrayList<ArtGalleryVisitor> visitors = new ArrayList<>();  //Initialising arraylist
    //Initialising variables
    JFrame frame;
    JPanel header, leftNav, mainPanel, genderPanel, registrationPanel, buttonPanel, login;
    JPanel artworksPanel, detailsPanel, ticketTypePanel, buyingPanel, actionPanel, artworkButton;
    CardLayout cardLayout;

    JLabel headerText, visitorId, fullName, contactNumber, ticketPrice, artworkName, artworkPrice, cancellationReason, gender, registrationDate, type;
    JLabel typeSecondPage, idSecondPage;
    JTextField idText, nameText, contactText, ticketText, artworkNameText, artworkPriceText, typeSecondPageText, idSecondPageText;
    JButton entry, artworks, details, addVisitor, logVisit, clearField, buyProduct, cancelProduct, personalArtAdvisor, checkUpgrade, calcDiscount, calcReward, generateBill, displayDetails, saveFiles, readFiles;
    JRadioButton maleButton, femaleButton, othersButton;
    JComboBox<String> day, month, year, ticketType;
    //Constructors
    public ArtGalleryGUI(){
        frame = new JFrame("Art Gallery Visitor System");
        frame.setSize(1000,800);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(226,232,192));
        //Operation for closing application
        frame.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosing(WindowEvent event){
                    int choice = JOptionPane.showConfirmDialog(null, "Do you want to save before closing?", "Closing", JOptionPane.YES_NO_OPTION);
                    if(choice == JOptionPane.YES_OPTION){
                        System.exit(0);
                    }
                    else{
                        System.exit(0);
                    }

                }
        
            });
        //creating objects of Components
        header = new JPanel();
        header.setBackground(new Color(237,217,163));
        header.setPreferredSize(new Dimension(0,100));
        header.setLayout(new FlowLayout(FlowLayout.CENTER,0,30));
        headerText = new JLabel("Art Gallery Visitor System"); 
        headerText.setFont(new Font("Arial",Font.BOLD,30));
        header.add(headerText);
        frame.add(header, BorderLayout.NORTH);

        leftNav = new JPanel();
        leftNav.setBackground(new Color(206,160,126));
        leftNav.setPreferredSize(new Dimension(200,0));
        leftNav.setLayout(new BoxLayout(leftNav, BoxLayout.Y_AXIS));

        entry = new JButton("Entry");
        entry.setAlignmentX(Component.CENTER_ALIGNMENT);
        entry.setPreferredSize(new Dimension(200,50));
        entry.setMaximumSize(entry.getPreferredSize());

        artworks = new JButton("Artworks");
        artworks.setAlignmentX(Component.CENTER_ALIGNMENT);
        artworks.setPreferredSize(new Dimension(200,50));
        artworks.setMaximumSize(artworks.getPreferredSize());

        details = new JButton("Details");
        details.setAlignmentX(Component.CENTER_ALIGNMENT);
        details.setPreferredSize(new Dimension(200,50));
        details.setMaximumSize(details.getPreferredSize());
        //Creating object of card layout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(new Color(226,232,192));

        login = new JPanel(new GridBagLayout());
        //Creating a border
    