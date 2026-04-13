public class StandardVisitor extends ArtGalleryVisitor{
private boolean isEligibleForDiscountUpgrade;
    private final int visitLimit;
    private float discountPercent;
//defining constructor of the class StandardVisitor which will call the attributes from the super class and initialize attributes 
public StandardVisitor(int visitorId,String fullName,String gender,String contactNumber,String registrationDate,double ticketCost,
String ticketType){ 
super(visitorId,fullName,gender,contactNumber,registrationDate,ticketCost,ticketType);
this.visitLimit = 5;
this.discountPercent = 0.10f;
this.isEligibleForDiscountUpgrade = false;
}
//defining the accessor methods
public boolean getIsEligibleForDiscountUpgrade(){
return isEligibleForDiscountUpgrade;
    }
 public int getVisitLimit(){
return discountPercent;
}
grade() which //defining method checkDiscountUpchecks whether the visitor is eligible for discount or not
public boolean checkDiscountUpgrade(){
