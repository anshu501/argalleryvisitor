public class EliteVisitorTest {
    public static void main(String[] args) {

        EliteVisitor visitor = new EliteVisitor(
                101,
                "Madhbi Sah",
                "Female",
                "8876543210",
                "18-04-2026",
                500,
                "Elite"
        );

        System.out.println(visitor.buyProduct("Mona Lisa", 10000));
        System.out.println("Discount: " + visitor.calculateDiscount());
        System.out.println("Reward Points: " + visitor.calculateRewardPoint());

        System.out.println("Advisor Assigned: " + visitor.assignPersonalArtAdvisor());

        visitor.generateBill();
        visitor.display();

        System.out.println(visitor.cancelProduct("Mona Lisa", "Changed mind"));
        visitor.display();
    }
}