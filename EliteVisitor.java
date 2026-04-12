//Defining the child class EliteVisitor
public class EliteVisitor extends ArtGalleryVisitor{
        //declaring the attributes
           private boolean assignedPersonalArtAdvisor;
               private boolean exclusiveEventAccess;

    //defining the constructor of EliteVisitor

        public EliteVisitor(int visitorId,String fullName,String gender,String contactNumber,String registrationDate,double ticketCost,
            String ticketType){
                        super(visitorId,fullName,gender,contactNumber,registrationDate,ticketCost,ticketType);
                         assignedPersonalArtAdvisor = false;
                             exclusiveEventAccess = false;
    }

        //defining the accessor methods of the attributes

    public boolean getAssignedPersonalArtAdvisor(){
         return assignedPersonalArtAdvisor;
           }

         public boolean getExclusiveEventAccess(){
               return exclusiveEventAccess;
         }

     //defining method assignPersonalArtAdvisor()
          public boolean assignPersonalArtAdvisor(){
              if(rewardPoints > 5000){
                 assignedPersonalArtAdvisor = true;
           }
                  return assignedPersonalArtAdvisor;
             }    

     //defining method exclusiveEventAccess()
      public boolean exclusiveEventAccess(){
         if(assignedPersonalArtAdvisor){
            exclusiveEventAccess = true;
             }
              return exclusiveEventAccess;
         }

  //method buyProduct() is implemented from the parent class 
    @Override
     public String buyProduct(String artworkName, double artworkPrice) {
          if (!isActive) {
              return "Please log in before purchasing.";
          }

       if(this.artworkName == null || !this.artworkName.equals(artworkName)){
        this.artworkName = artworkName;
        this.artworkPrice = artworkPrice;
        this.isBought = true;
        this.buyCount++;
        return "Product purchased successfully.";
     }

    return "You have already purchased this product";
}

//method calculateDiscount() is implemented from parents class
  @Override
   public double calculateDiscount(){

     if(!isBought){
        return 0;
      }

      discountAmount = artworkPrice * 0.40;
      finalPrice = artworkPrice - discountAmount;
      return discountAmount;

}

    //implementing method calculateRewardPoint() from the parents class
    @Override
    public double calculateRewardPoint(){
        if(isBought){
              rewardPoints += finalPrice * 10;
          }
          return rewardPoints;
   }

    //implementing method generateBill() from the parents class
    @Override
    public void generateBill(){
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

  //defining terminateVisitor() method
   private void terminateVisitor(){
    isActive = false;
    assignedPersonalArtAdvisor = false;
    exclusiveEventAccess = false;
    visitCount = 0;
    cancelCount = 0;
    rewardPoints = 0;
}
 //implementing cancelProduct from the parent class
 @Override
     public String cancelProduct(String artworkName,String cancellationReason){
       if(cancelCount == 3){
         terminateVisitor();
         return "Your account has been terminated because it exceeded the cancel limit of 3";
      }
       if(buyCount > 0){
        if(this.artworkName.equals(artworkName)){
            this.artworkName = null;
            this.isBought = false;
            refundableAmount = artworkPrice - (artworkPrice * 0.05);
            rewardPoints -= finalPrice * 10;
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
      System.out.println("Personal Art advisor: " + assignedPersonalArtAdvisor);
      System.out.println("Exclusive events access: " + exclusiveEventAccess);
  }
  }
  