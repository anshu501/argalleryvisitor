public class StandardVisitor extends ArtGalleryVisitor{
private boolean isEligibleForDiscountUpgrade;
    private final int visitLimit;
    private float discountPercent;
//defining constructor of the class StandardVisitor which will call the attributes from the super class and initialize attributes 
public StandardVisitor(int visitorId,String fullName,String gender,String contactNumber,String registrationDate,double ticketCost,
String ticketType){
