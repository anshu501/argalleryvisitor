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
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3),
                "Visitor's Detail",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("Arial", Font.BOLD, 20),
                new Color(0, 51, 102)
            );
        login.setBorder(titledBorder);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,10,10,5);
        gbc.anchor = GridBagConstraints.WEST;

        Font labelFont = new Font("Arial", Font.PLAIN, 20);

        visitorId = new JLabel("Visitor ID:");
        visitorId.setFont(labelFont);
        gbc.gridy = 0;
        gbc.gridx = 0;
        login.add(visitorId, gbc);

        idText = new JTextField(10);
        gbc.gridy = 0;
        gbc.gridx = 1;
        login.add(idText, gbc);

        fullName = new JLabel("Full Name:");
        fullName.setFont(labelFont);
        gbc.gridy = 1;
        gbc.gridx = 0;
        login.add(fullName, gbc);

        nameText = new JTextField(10);
        gbc.gridy = 1;
        gbc.gridx = 1;
        login.add(nameText, gbc);

        // Contact Number
        contactNumber = new JLabel("Contact Number: ");
        contactNumber.setFont(labelFont);
        gbc.gridy = 2;
        gbc.gridx = 0;
        login.add(contactNumber, gbc);

        contactText = new JTextField(10);
        gbc.gridy = 2;
        gbc.gridx = 1;
        login.add(contactText, gbc);

        // Gender
        gender = new JLabel("Gender:");
        gender.setFont(labelFont);
        gbc.gridy = 3;
        gbc.gridx = 0;
        login.add(gender, gbc);

        genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        maleButton = new JRadioButton("Male");
        maleButton.setFont(labelFont);
        femaleButton = new JRadioButton("Female");
        femaleButton.setFont(labelFont);
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        othersButton = new JRadioButton("Others");
        othersButton.setFont(labelFont);
        genderPanel.add(othersButton);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderGroup.add(othersButton);

        gbc.gridy = 3;
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        login.add(genderPanel, gbc);
        gbc.gridwidth = 1; 

        registrationDate = new JLabel("Registration Date: ");
        registrationDate.setFont(labelFont);
        gbc.gridy = 4;
        gbc.gridx = 0;
        login.add(registrationDate, gbc);

        registrationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));

        String[] dayArray =new String[31];
        for(int i = 0; i < 31; i++){
            dayArray[i] = String.valueOf(i+1);
        }
        day = new JComboBox<>(dayArray);
        registrationPanel.add(day);

        String[] monthArray = {"January","February","March","April","May","June","July","August",
                "September","October","November","December"
            };
        month = new JComboBox<>(monthArray);
        registrationPanel.add(month);

        String[] yearArray = new String[26];
        for(int i = 0; i < 26; i++){
            yearArray[i] = String.valueOf(i+2000);
        }
        year = new JComboBox<>(yearArray);
        registrationPanel.add(year);
        gbc.gridy = 4;
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        login.add(registrationPanel,gbc);
        gbc.gridwidth = 1; 

        type = new JLabel("Ticket Type:");
        type.setFont(labelFont);
        gbc.gridy = 5;
        gbc.gridx = 0;
        login.add(type, gbc);

        String[] ticketTypes = {"Select","Standard", "Elite"};
        ticketType = new JComboBox<>(ticketTypes);
        gbc.gridy = 5;
        gbc.gridx = 1;
        login.add(ticketType, gbc);

        ticketPrice = new JLabel("Ticket Price:");
        ticketPrice.setFont(labelFont);
        gbc.gridy = 6;
        gbc.gridx = 0;
        login.add(ticketPrice, gbc);

        ticketText = new JTextField(10);
        ticketText.setEditable(false);
        gbc.gridy = 6;
        gbc.gridx = 1;
        login.add(ticketText, gbc);

        ticketType.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    String selected = (String) ticketType.getSelectedItem();
                    double price = 0.0;
                    if ("Standard".equals(selected)) {
                        price = 1000.00;

                    }
                    else if ("Elite".equals(selected)) {
                        price = 2000.00;

                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Please select ticket type.", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    ticketText.setText(String.valueOf(price));

                }
            });

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,50,50));
        TitledBorder titledBorder2 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3),
                "Logging zone",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("Arial", Font.BOLD, 20),
                new Color(0, 51, 102));

        buttonPanel.setBorder(titledBorder2);

        addVisitor = new JButton("Add Visitor");
        addVisitor.setPreferredSize(new Dimension(200, 50));
        logVisit = new JButton("Log Your Visit");
        logVisit.setPreferredSize(new Dimension(200, 50));
        clearField = new JButton("Clear the Fields");
        clearField.setPreferredSize(new Dimension(200, 50));

        buttonPanel.add(addVisitor);
        buttonPanel.add(logVisit);
        buttonPanel.add(clearField);

        addVisitor.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    try{
                        String visitorIdString = idText.getText(); 
                        String fullName = nameText.getText(); 
                        String contactNumber = contactText.getText(); 
                        String ticketSelected = (String) ticketType.getSelectedItem();

                        if (visitorIdString.isEmpty() || fullName.isEmpty() || contactNumber.isEmpty() || ticketText.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please fill all the required fields.", "Input Error Message", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        if(!contactNumber.matches("\\d{10}")){
                            JOptionPane.showMessageDialog(null, "Please enter a valid 10 digit phone number.", "Warning", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        double ticketCost = Double.parseDouble(ticketText.getText()); 

                        int visitorId = Integer.parseInt(visitorIdString); 
                        if(visitorId <= 0){
                            JOptionPane.showMessageDialog(null, "Visitor Id cannot be 0 or a negative number. Try Again!!", "Invalid Id", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        boolean found = false;
                        for(ArtGalleryVisitor visitor : visitors){
                            if(visitor.getVisitorId() == visitorId){ 
                                JOptionPane.showMessageDialog(null, "Visitor ID " + visitorId + " already exists.", "Duplicate ID", JOptionPane.WARNING_MESSAGE);
                                found = true;
                                break; 
                            }
                        }

                        String selectedGender = "";
                        if (maleButton.isSelected()) {
                            selectedGender = "Male";
                        } else if (femaleButton.isSelected()) {
                            selectedGender = "Female";
                        } else if (othersButton.isSelected()) {
                            selectedGender = "Others";
                        } else {
                            JOptionPane.showMessageDialog(frame, "Please select a gender.", "Warning", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        String regDate = day.getSelectedItem() + " " + month.getSelectedItem() + ", " + year.getSelectedItem();

                        if ("Standard".equals(ticketSelected) && found == false) {
                            StandardVisitor standardVisitor = new StandardVisitor(visitorId, fullName, selectedGender, contactNumber, regDate, ticketCost, ticketSelected);
                            visitors.add(standardVisitor);
                            JOptionPane.showMessageDialog(null, "Standard Visitor " + fullName + " (ID: " + visitorId + ") added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

                        } else if("Elite".equals(ticketSelected) && found == false) {
                            EliteVisitor eliteVisitor = new EliteVisitor(visitorId, fullName, selectedGender, contactNumber, regDate, ticketCost, ticketSelected);
                            visitors.add(eliteVisitor);
                            JOptionPane.showMessageDialog(null, "Elite Visitor " + fullName + " (ID: " + visitorId + ") added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

                        }

                    }
                    catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Enter numeric ID value","Warning",JOptionPane.WARNING_MESSAGE);
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Exception Occured", "Warning", JOptionPane.WARNING_MESSAGE);

                    }
                }

            });
        logVisit.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    try{
                        String visitorIdString = idText.getText();

                        if(visitorIdString.isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Please enter a Visitor ID to log a visit.", "Input Error", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        int visitorId = Integer.parseInt(visitorIdString);
                        boolean foundVisitor = false;

                        for (ArtGalleryVisitor visitor : visitors) {
                            if (visitor.getVisitorId() == visitorId) {
                                idSecondPageText.setText(visitorIdString);
                                typeSecondPageText.setText(visitor.getTicketType());
                                visitor.logVisit();
                                JOptionPane.showMessageDialog(null, "Visitor ID " + visitorId + " (Name: " + visitor.getFullName() + ") has successfully logged a visit. " +
                                    "Total visits: " + visitor.getVisitCount(),
                                    "Visit Logged", JOptionPane.INFORMATION_MESSAGE);
                                foundVisitor = true;
                                break; 
                            }
                        }

                        if(!foundVisitor){

                            JOptionPane.showMessageDialog(null, "Visitor ID or name might be incorrect", "Visitor Not Found", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Please enter a numeric value for id", "Warning Message",JOptionPane.WARNING_MESSAGE);

                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Exception Occured", "Warning", JOptionPane.WARNING_MESSAGE);

                    }
                }
            });

        clearField.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    idText.setText("");
                    nameText.setText("");
                    contactText.setText("");
                    genderGroup.clearSelection();
                    day.setSelectedIndex(0);
                    month.setSelectedIndex(0);
                    year.setSelectedIndex(0);
                    ticketType.setSelectedItem("Select");

                }

            });

        JPanel entryPagePanel = new JPanel(); 
        entryPagePanel.setLayout(new BoxLayout(entryPagePanel, BoxLayout.Y_AXIS));
        login.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        entryPagePanel.add(login);
        entryPagePanel.add(buttonPanel);

        buyingPanel = new JPanel();
        buyingPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3),"Buying and Canceling", 
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("Arial", Font.BOLD, 20)));
        buyingPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbcBuying = new GridBagConstraints();
        gbcBuying.insets = new Insets(10,10,10,10);
        gbcBuying.anchor = GridBagConstraints.WEST;

        idSecondPage = new JLabel("Your ID: ");
        idSecondPage.setFont(labelFont);
        gbcBuying.gridy = 0;
        gbcBuying.gridx = 0;
        buyingPanel.add(idSecondPage, gbcBuying);
        idSecondPageText= new JTextField(10);
        idSecondPageText.setPreferredSize(new Dimension(100, 30));
        gbcBuying.gridy = 0;
        gbcBuying.gridx = 1;
        idSecondPageText.setEditable(false);
        buyingPanel.add(idSecondPageText, gbcBuying);

        typeSecondPage = new JLabel("Your ticket type: ");
        typeSecondPage.setFont(labelFont);
        gbcBuying.gridy = 1;
        gbcBuying.gridx = 0;
        buyingPanel.add(typeSecondPage, gbcBuying);
        typeSecondPageText = new JTextField(10);
        typeSecondPageText.setPreferredSize(new Dimension(100, 30));
        typeSecondPageText.setEditable(false);
        gbcBuying.gridy = 1;
        gbcBuying.gridx = 1;
        buyingPanel.add(typeSecondPageText, gbcBuying);

        artworkName = new JLabel("Artwork's Name: ");
        artworkName.setFont(labelFont);
        gbcBuying.gridy = 2;
        gbcBuying.gridx = 0;
        buyingPanel.add(artworkName, gbcBuying);
        artworkNameText = new JTextField(10);
        artworkNameText.setPreferredSize(new Dimension(100, 30));
        gbcBuying.gridy = 2;
        gbcBuying.gridx = 1;
        buyingPanel.add(artworkNameText, gbcBuying);

        artworkPrice = new JLabel("Artwork's Price: ");
        artworkPrice.setFont(labelFont);
        gbcBuying.gridy = 3;
        gbcBuying.gridx = 0;
        buyingPanel.add(artworkPrice, gbcBuying);
        artworkPriceText = new JTextField(10);
        artworkPriceText.setPreferredSize(new Dimension(100, 30));
        gbcBuying.gridy = 3;
        gbcBuying.gridx = 1;
        buyingPanel.add(artworkPriceText, gbcBuying);

        cancellationReason = new JLabel("Cancellation Reason: ");
        cancellationReason.setFont(labelFont);
        gbcBuying.gridy = 4;
        gbcBuying.gridx = 0;
        buyingPanel.add(cancellationReason, gbcBuying);
        JTextArea cancellationReasonText = new JTextArea(5,15);
        JScrollPane scrollPane = new JScrollPane(cancellationReasonText);
        gbcBuying.gridy = 4;
        gbcBuying.gridx = 1;
        buyingPanel.add(scrollPane, gbcBuying);

        artworkButton = new JPanel();
        artworkButton.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buyProduct = new JButton("Buy Product");
        buyProduct.setPreferredSize(new Dimension(200, 50));

        buyProduct.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event){
                    try{
                        String idStr = idSecondPageText.getText().trim();
                        String name = artworkNameText.getText();
                        String priceStr = artworkPriceText.getText().trim();

                        int id = Integer.parseInt(idStr);
                        double price = Double.parseDouble(priceStr);
                        boolean visitorFound = false; 
                        if(price <= 0){
                            JOptionPane.showMessageDialog(null, "The price cannot be negative or zero", "Invalid Price!!", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        for (ArtGalleryVisitor visitor : visitors){
                            if(visitor.getVisitorId() == id){
                                String message = visitor.buyProduct(name, price);
                                JOptionPane.showMessageDialog(null, message, "Remarks", JOptionPane.INFORMATION_MESSAGE);
                                visitorFound = true;
                                break;
                            }
                        }
                        if (!visitorFound) {
                            JOptionPane.showMessageDialog(null, "The visitor Id: " + idStr + " cannot be found", "Warning", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                    }
                    catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Please enter numeric value for price", "warning", JOptionPane.WARNING_MESSAGE);  
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Exception Occured", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                }
            });
        cancelProduct = new JButton("Cancel Product");
        cancelProduct.setPreferredSize(new Dimension(200, 50));
        artworkButton.add(buyProduct);
        artworkButton.add(cancelProduct);
        gbcBuying.gridy = 5;
        gbcBuying.gridx = 0;
        gbcBuying.gridwidth = 2; 
        gbcBuying.anchor = GridBagConstraints.CENTER; 
        gbcBuying.fill = GridBagConstraints.NONE; 
        gbcBuying.weighty = 0; 
        buyingPanel.add(artworkButton, gbcBuying); 
        cancelProduct.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    try{
                        String idString = idSecondPageText.getText().trim();
                        String cancellationReason = cancellationReasonText.getText().trim();
                        String artworkName = artworkNameText.getText();

                        int id = Integer.parseInt(idString);
                        ArtGalleryVisitor foundVisitor = null;
                        for(ArtGalleryVisitor visitor : visitors){
                            if(visitor.getVisitorId() == id){
                                foundVisitor = visitor;
                                break;
                            }
                        }
                        if(foundVisitor != null && !cancellationReason.isEmpty() && !artworkName.isEmpty()){
                            String message = foundVisitor.cancelProduct(artworkName, cancellationReason);
                            JOptionPane.showMessageDialog(null, message, "Remarks", JOptionPane.INFORMATION_MESSAGE);

                            return;
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Required fields are empty", "Warning", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                    }
                    catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Enter Numeric Id value.", "Warning", JOptionPane.WARNING_MESSAGE);

                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, "An error occured.", "Warning", JOptionPane.WARNING_MESSAGE);

                    }

                }

            } );
        actionPanel = new JPanel();
        actionPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3),
                "Actions",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("Arial", Font.BOLD, 20)));

        actionPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbcAction = new GridBagConstraints();
        gbcAction.insets = new Insets(10,10,10,10);
        gbcAction.anchor = GridBagConstraints.WEST;

        calcDiscount = new JButton("Calculate Discount");
        calcDiscount.setPreferredSize(new Dimension(200, 30));
        gbcAction.gridy = 0;
        gbcAction.gridx = 0;
        actionPanel.add(calcDiscount, gbcAction);
        calcDiscount.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    try{
                        String idStr = idSecondPageText.getText().trim();
                        int id = Integer.parseInt(idStr);
                        ArtGalleryVisitor found = null;

                        if (idStr.isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Please enter a Visitor ID.", "Warning", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        for (ArtGalleryVisitor visitor : visitors){
                            if(visitor.getVisitorId() == id){
                                found = visitor;
                                break;
                            }
                        }
                        if(found == null){
                            JOptionPane.showMessageDialog(null, "Id not found.", "warning",JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        if (found.getIsBought()) {
                            double discount = found.calculateDiscount();
                            double finalPriceDiscount = found.getFinalPrice();
                            String artworkNameDiscount = found.getArtworkName();
                            double artworkPriceDiscount = found.getArtworkPrice();

                            JOptionPane.showMessageDialog(null, found.getFullName() + "discount is RS." + discount, "Discount amount", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "No artwork has been bought", "Warning", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, "An error occured.", "Warning", JOptionPane.WARNING_MESSAGE);

                    }
                }
            });

        calcReward = new JButton("Calculate Reward");
        calcReward.setPreferredSize(new Dimension(200, 30));
        gbcAction.gridy = 0;
        gbcAction.gridx = 1;
        actionPanel.add(calcReward, gbcAction);
        calcReward.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    try{
                        String idStr = idSecondPageText.getText().trim();
                        int id = Integer.parseInt(idStr);
                        ArtGalleryVisitor found = null;

                        if (idStr.isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Please enter a Visitor ID.", "Warning", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        for (ArtGalleryVisitor visitor : visitors){
                            if(visitor.getVisitorId() == id){
                                found = visitor;
                                break;
                            }
                        }
                        if(found == null){
                            JOptionPane.showMessageDialog(null, "Id not found.", "warning",JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        if (found.getIsBought()) {
                            if(found.getDiscountAmount()>0){
                                double finalPriceDiscount = found.getFinalPrice();      
                                double reward = found.calculateRewardPoint();

                                JOptionPane.showMessageDialog(null, found.getFullName() + "Reward for the purchase" + reward , "Reward", JOptionPane.WARNING_MESSAGE);

                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Please calculate discount first", "Warning", JOptionPane.WARNING_MESSAGE);
                                return;
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "No artwork has been bought", "Warning", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, "An error occured.", "Warning", JOptionPane.WARNING_MESSAGE);

                    }
                }
            });
        checkUpgrade = new JButton("Check for Upgrade");
        checkUpgrade.setPreferredSize(new Dimension(200, 30));
        gbcAction.gridy = 1;
        gbcAction.gridx = 0;
        actionPanel.add(checkUpgrade, gbcAction);
        checkUpgrade.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    try{
                        String idStr = idSecondPageText.getText().trim();
                        int id = Integer.parseInt(idStr);
                        ArtGalleryVisitor found = null;

                        if (idStr.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please enter your Visitor Id.", "Warning", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        for (ArtGalleryVisitor visitor : visitors) {
                            if (visitor.getVisitorId() == id) {
                                found = visitor;
                                break;
                            }
                        }

                        if (found != null){
                            if (found instanceof StandardVisitor){
                                StandardVisitor standardVisitor = (StandardVisitor) found;
                                boolean upgradeStatus = standardVisitor.checkDiscountUpgrade();

                                if(upgradeStatus){
                                    JOptionPane.showMessageDialog(null, "The visitor with Id " + idStr + " is now eligible for a discount upgrade.", "Upgrade Successful", JOptionPane.INFORMATION_MESSAGE);

                                }
                                else {
                                    JOptionPane.showMessageDialog(null, "The visitor with Id " + idStr + " is not yet eligible.", "Not eligible yet", JOptionPane.INFORMATION_MESSAGE);
                                }

                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Your ticket type is not a Standard ticket type.", "Not a Standard Visitor", JOptionPane.WARNING_MESSAGE);
                            }

                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Visitor Id not found!! Please enter a valid visitor Id.", "Visitor id not found",JOptionPane.WARNING_MESSAGE);
                        }

                    }
                    catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid numeric value for Visitor Id.", "Id not numeric", JOptionPane.WARNING_MESSAGE);}
                    catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "An unexpected error occurred: ", "Error", JOptionPane.ERROR_MESSAGE);   
                    }

                }

            });

        personalArtAdvisor = new JButton("Get Your Personal Art Advisor");
        personalArtAdvisor.setPreferredSize(new Dimension(250, 30));
        gbcAction.gridy = 1;
        gbcAction.gridx = 1;
        actionPanel.add(personalArtAdvisor, gbcAction);
        personalArtAdvisor.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    try{
                        String idStr = idSecondPageText.getText().trim();
                        int id = Integer.parseInt(idStr);
                        ArtGalleryVisitor found = null;

                        if (idStr.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please enter your Visitor Id.", "Warning", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        for (ArtGalleryVisitor visitor : visitors) {
                            if (visitor.getVisitorId() == id) {
                                found = visitor;
                                break;
                            }
                        }
                        if (found != null){
                            if (found instanceof EliteVisitor){
                                EliteVisitor eliteVisitor = (EliteVisitor) found; 
                                boolean assignStatus = eliteVisitor.assignPersonalArtAdvisor();

                                if(assignStatus){
                                    JOptionPane.showMessageDialog(null, "The visitor with Id " + idStr + " has been assigned with an Art Advisor", "Advisor assigned", JOptionPane.INFORMATION_MESSAGE);

                                }
                                else {
                                    JOptionPane.showMessageDialog(null, "The visitor with Id " + idStr + " is not yet eligible.", "Not eligible yet", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Your ticket type is not a Elite ticket type.", "Not an Elite Visitor", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Visitor Id not found!! Please enter a valid visitor Id.", "Visitor id not found",JOptionPane.WARNING_MESSAGE);
                        }

                    }
                    catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid numeric value for Visitor Id.", "Id not numeric", JOptionPane.WARNING_MESSAGE);}
                    catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "An unexpected error occurred: ", "Error", JOptionPane.ERROR_MESSAGE);   
                    }
                }
            });

        generateBill = new JButton("Generate Bill");
        generateBill.setPreferredSize(new Dimension(200, 30));
        gbcAction.gridy = 2;
        gbcAction.gridx = 0;
        actionPanel.add(generateBill, gbcAction);
        generateBill.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    try {
                        String idStr = idSecondPageText.getText().trim();
                        if (idStr.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please enter a Visitor ID.", "Warning", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        int id = Integer.parseInt(idStr);

                        ArtGalleryVisitor foundVisitor = null;
                        for (ArtGalleryVisitor visitor : visitors) {
                            if (visitor.getVisitorId() == id) {
                                foundVisitor = visitor;
                                break;
                            }
                        }
                        File writer = new File("Bill.txt");
                        BufferedWriter bw = new BufferedWriter(new FileWriter(writer));
                        if (foundVisitor != null) {
                            if(foundVisitor.getIsBought()){
                                if(foundVisitor.getDiscountAmount() > 0){
                                    System.out.println();
                                    System.out.println("=".repeat(60));
                                    System.out.println(String.format("%35s", "Purchase Bill"));
                                    System.out.println("=".repeat(60));
                                    foundVisitor.generateBill();
                                    System.out.println("=".repeat(60));
                                    System.out.println(String.format("%40s", "Thank you for your visit!!"));
                                    System.out.println("=".repeat(60) + "\n");

                                    int idHere = foundVisitor.getVisitorId();
                                    String name = foundVisitor.getFullName();
                                    String artworkName = foundVisitor.getArtworkName();
                                    double discountAmount = foundVisitor.getDiscountAmount();
                                    double finalPrice = foundVisitor.getFinalPrice();
                                    bw.write("\n");
                                    bw.write("=".repeat(60));
                                    bw.newLine();
                                    bw.write(String.format("%35s", "Purchase Bill"));
                                    bw.newLine();
                                    bw.write("=".repeat(60));
                                    bw.newLine();

                                    // Instead of repeating, reuse visitor details
                                    bw.write("Visitor Id         : " + idHere + "\n");
                                    bw.write("Visitor's Name     : " + name + "\n");
                                    bw.write("Artwork Purchased  : " + artworkName + "\n");
                                    bw.write("Discounted Amount  : " + discountAmount + "\n");
                                    bw.write("Final Price        : " + finalPrice + "\n");

                                    bw.write("=".repeat(60));
                                    bw.newLine();
                                    bw.write(String.format("%40s", " Thank you for your visit!!"));
                                    bw.newLine();
                                    bw.write("=".repeat(60));
                                    bw.newLine();
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "Please calculate discount before generating bill", "Warning", JOptionPane.WARNING_MESSAGE);
                                    return;
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "You have not bought any item!! Please buy first", "Item not bought", JOptionPane.WARNING_MESSAGE);
                                return;
                            }
                        } else {
                            JOptionPane.showMessageDialog(frame,"Visitor with ID: " + idStr + " not found.", "Visitor Not Found", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        bw.close();
                        
                        JOptionPane.showMessageDialog(null, "Saved successfully:\n" + writer.getAbsolutePath(), "Success", JOptionPane.INFORMATION_MESSAGE);

                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Please Enter Numeric ID", "Input Error", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "An error occured","Error", JOptionPane.ERROR_MESSAGE);

                    }
                }
            });

        displayDetails = new JButton("Visitor Details");
        displayDetails.setPreferredSize(new Dimension(200, 30));
        gbcAction.gridy = 2;
        gbcAction.gridx = 1;
        actionPanel.add(displayDetails, gbcAction);
        displayDetails.addActionListener(new ActionListener(){ 
                @Override
                public void actionPerformed(ActionEvent event) {

                    String[] columns = {"Visitor IDs", "Name", "Gender", "Date", "Ticket Type", "Ticket Price","Visit Count", "Active Status"};
                    DefaultTableModel model = new DefaultTableModel(columns, 0);
                    JTable table = new JTable(model);
                    for(ArtGalleryVisitor visitor : visitors){
                        Object[] row = {visitor.getVisitorId(), visitor.getFullName(), visitor.getGender(), visitor.getRegistrationDate(), visitor.getTicketType(), visitor.getTicketCost(),visitor.getVisitCount(), visitor.getIsActive()};
                        model.addRow(row);
                    }

                    JScrollPane scrollPane = new JScrollPane(table);
                    JDialog dialog = new JDialog(frame, "Visitor Data", true);
                    dialog.setSize(800, 800);
                    dialog.getContentPane().setBackground(new Color(30, 144, 255));
                    dialog.setLocationRelativeTo(null);
                    dialog.add(scrollPane);
                    dialog.setVisible(true);

                }
            });

        saveFiles = new JButton("Write to file");
        saveFiles.setPreferredSize(new Dimension(200,30));
        gbcAction.gridy = 3;
        gbcAction.gridx = 0;
        actionPanel.add(saveFiles, gbcAction);
        saveFiles.addActionListener(new ActionListener() { //Event listener to save to files
                public void actionPerformed(ActionEvent event) {
                    try{
                        File file = new File("data.txt");
                        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                        //ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("visitor.dat"));
                        StringBuilder sb = new StringBuilder();

                        // Table header
                        sb.append("=".repeat(200)).append("\n"); 
                        String header = String.format(
                                "%-10s %-20s %-10s %-15s %-15s %-12s %-12s %-10s %-10s %-10s %-20s %-12s %-12s %-20s",
                                "ID", "Full Name", "Gender", "Contact No", "Reg Date",
                                "Ticket Cost", "Ticket Type", "Active", "Visits", "Buys",
                                "Artwork Name", "Art Price", "Cancels", "Personal Art Advisor"
                            );
                        sb.append(header).append("\n");

                        sb.append("=".repeat(200)).append("\n"); // underline (adjust 160 if needed)

                        // Table rows
                                   

