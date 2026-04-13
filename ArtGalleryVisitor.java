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

