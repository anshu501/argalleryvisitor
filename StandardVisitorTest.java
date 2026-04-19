public class StandardVisitorTest {
    public static void main(String[] args) {

        // Creating a Standard Visitor object
        StandardVisitor visitor = new StandardVisitor(
                101,
                "Anita Kumari Gupta",
                "Female",
                "7768010110",
                "2026-04-18",
                2000.0,
                "Regular"
        );

        // Simulate login (assuming parent class has isActive)
        visitor.isActive = true;

        System.out.println("=== Visitor Details ===");
        visitor.display();

        // Buying artwork
        System.out.println("\n=== Buying Artwork ===");
        String result = visitor.buyProduct("Mona Lisa", 5000);
        System.out.println(result);

        // Calculating discount
        System.out.println("\n=== Discount Calculation ===");
        double discount = visitor.calculateDiscount();
        System.out.println("Discount: " + discount);

        // Calculating reward points
        System.out.println("\n=== Reward Points ===");
        double points = visitor.calculateRewardPoint();
        System.out.println("Reward Points: " + points);

        // Generating bill
        System.out.println("\n=== Bill ===");
        visitor.generateBill();

        // Cancelling product
        System.out.println("\n=== Cancel Product ===");
        String cancelMsg = visitor.cancelProduct("Mona Lisa", "Changed mind");
        System.out.println(cancelMsg);

        // Display again after cancellation
        System.out.println("\n=== Updated Visitor Details ===");
        visitor.display();
    }
}