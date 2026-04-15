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

    