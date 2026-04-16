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
