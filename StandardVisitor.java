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
    return visitLimit;
}

//defining method checkDiscountUpgrade() which checks whether the visitor is eligible for discount or not
public boolean checkDiscountUpgrade(){
    isEligibleForDiscountUpgrade = true;
    discountPercent = 0.15f;
    return isEligibleForDiscountUpgrade;
}        
/*method buyProduct() is implemented from the parent class which will first check whether the visitor have logged in or not and allow
    visitor to buy the product*/
@Override
public String buyProduct(String artworkName, double artworkPrice) {
    if (!isActive) {
        return "Please log in before purchasing.";
    }
    if(this.artworkName==null || !this.artworkName.equals(artworkName)){
        this.artworkName = artworkName;
        this.artworkPrice = artworkPrice;     
        this.isBought = true;       
        this.buyCount++;
        return "You have already purchased this product";
    }
    return "You have already purchased this product";
}

//method calculateDiscount() is implemented from parents class which will let user get a discount on the artwork they have bought
@Override
    public double calculateDiscount(){
 if(!isBought){
      return 0;
    }
        checkDiscountUpgrade();
 discountAmount = artworkPrice * discountPercent;
finalPrice = artworkPrice - discountAmount;
 return discountAmount;
 }
which will calculate the reward points gained by the visitor
    @Override 
public double calculateRewardPoint(){ //implementing method calculateRewardPoint() from the parents class
        if(isBought){
 rewardPoints += finalPrice * 5;
 }
 return rewardPoints;
  }   

    ss which will generate the bill 
 @Override
public void generateBill(){//implementing method generateBill() from the parents cla
if(!isBought){
 System.out.println("You have not made any purchase to generate a bill");
        }
        else{
 System.out.println("Visitor Id: " + visitorId);
System.out.println("Full Name: " + fullName);
 System.out.println("Artwork purchased: " + artworkName);
 System.out.println("Initial Price: " + artworkPrice);
System.out.println("Discounted amount: " + discountAmount);
 System.out.println("Final Price: " + finalPrice);
        }
   }
/*difining terminateVisitor() method which will set active status and discount eligibility to false and set visit count, cancel count, and 
    reward points to 0*/
  private void terminateVisitor(){
 isActive = false;
isEligibleForDiscountUpgrade = false;
visitCount = 0;
cancelCount = 0;
rewardPoints = 0;
 }
//implementing cancelProduct from the parent class
//implementing cancelProduct from the parent class
public String cancelProduct(String artworkName,String cancellationReason){
        if(cancelCount == 3){
 terminateVisitor();
            return "Your account has been terminated because it exceeded the cancel limit of 3";
        }
if(buyCount > 0){
if(this.artworkName.equals(artworkName)){
                this.artworkName = "";
this.isBought = false;
                refundableAmount = artworkPrice - (artworkPrice * 0.05);
                rewardPoints -= finalPrice * 5;
 cancelCount++;
                buyCount--;
                this.cancellationReason = cancellationReason;
                return "Your purchase is now cancelled";
            }
 else{
                return "Make sure you have entered the correct artwork name";
            }
        }

        else{
            return "You have not made any purchase";
        }
    }
//implementing display method from the parent class
    @Override
public void display(){
 super.display();
 System.out.println("Eligible for the discount upgrade: " + isEligibleForDiscountUpgrade);
        System.out.println("The visit limit: " + visitLimit);
