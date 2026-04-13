//Defining the parent class ArtGalleryVisitor
public abstract class ArtGalleryVisitor{
    //Declaring the attributes which are of protected access modifiers
    protected int visitorId;
    protected String fullName;
    protected String gender;
    protected String contactNumber;
    protected String registrationDate;
    protected double ticketCost;
    protected String ticketType;
    protected int visitCount;
    protected double rewardPoints;
    protected final int cancelLimit = 3;
    protected int cancelCount;
    protected String cancellationReason;
    protected double refundableAmount;
    protected boolean isActive;
    protected boolean isBought;
    protected int buyCount;
    protected double finalPrice;
    protected double discountAmount;
    protected String artworkName;
    protected double artworkPrice;

    //Constructor of the class ArtGalleryVisitor which will initialize the attributes 
    public ArtGalleryVisitor(int visitorId,String fullName,String gender,String contactNumber,String registrationDate,double ticketCost,
    String ticketType){
        //Initialisation of the attributes inside constructor
        this.visitorId = visitorId;
        this.fullName = fullName;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.registrationDate = registrationDate;
        this.ticketCost = ticketCost;
        this.ticketType = ticketType;

        this.visitCount = 0;
        this.rewardPoints = 0;
        this.cancelCount = 0;
        this.buyCount = 0;
        this.discountAmount = 0;
        this.finalPrice = 0;
        this.refundableAmount = 0;
        this.isActive = false;
        this.isBought = false;
        this.cancellationReason = "";

    }

//defining the accessor (getters) methods individually
    public int getVisitorId(){
        return visitorId;
    }

    public String getFullName(){
        return fullName;
    }

    public String getGender(){
        return gender;
    }

    public String getContactNumber(){
        return contactNumber;
    }

    public String getRegistrationDate(){
        return registrationDate;
    }

    public double getTicketCost(){
        return ticketCost;
    }

    public String getTicketType(){
        return ticketType;
    }

    public int getVisitCount(){
        return visitCount;
    }

    public double getRewardPoints(){
        return rewardPoints;
    }

    public int getCancelLimit(){
        return cancelLimit;
    }

    public int getCancelCount(){
        return cancelCount;
    }

    public String getCancellationReason(){
        return cancellationReason;
    }

    public double getRefundableAmount(){
        return refundableAmount;
    }

    public boolean getIsActive(){
        return isActive;
    }

    public boolean getIsBought(){
        return isBought;
    }

    public int getBuyCount(){
        return buyCount;
    }

    public double getFinalPrice(){
        return finalPrice;
    }

    public double getDiscountAmount(){
        return discountAmount;
    }

    public String getArtworkName(){
        return artworkName;
    }

    public double getArtworkPrice(){
        return artworkPrice;
    }
    //defining mutator methods (setters)
    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    }

    //defining method named logVisit() which will increment the visit count by 1 and set the active status to true
    public void logVisit(){
        visitCount++;
        isActive = true;
        
    }

    