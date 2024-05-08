import java.util.ArrayList;
import java.util.Scanner;

public class PointRedeem {
    private ArrayList<Coupon> availableCoupons;

    public PointRedeem(ArrayList<Coupon> availableCoupons) {
        this.availableCoupons = availableCoupons;
    }

    // Method to display available coupons for redemption
    public void displayAvailableCoupons() {
        System.out.println("Available Coupons for Redemption:");
        for (int i = 0; i < availableCoupons.size(); i++) {
            Coupon coupon = availableCoupons.get(i);
            System.out.println("Coupon " + (i + 1) + ": " + coupon.getCouponName() + " - Price: " + coupon.getCouponPrice());
        }
    }

    // Method to redeem a coupon
    public void redeemCoupon(int couponIndex, double totalPrice) {
        if (couponIndex >= 0 && couponIndex < availableCoupons.size()) {
            Coupon coupon = availableCoupons.get(couponIndex);
            double discountedPrice;
            if (coupon instanceof FixedDiscount) {
                FixedDiscount fixedDiscount = (FixedDiscount) coupon;
                discountedPrice = totalPrice - fixedDiscount.getValue();
            } else if (coupon instanceof PercentageDiscount) {
                PercentageDiscount percentageDiscount = (PercentageDiscount) coupon;
                discountedPrice = totalPrice * (1 - percentageDiscount.getPercentage() / 100);
            } else {
                discountedPrice = totalPrice; // Default behavior
            }
            System.out.println("Coupon Redeemed: " + coupon.getCouponName());
            System.out.println("Discounted Price: " + discountedPrice);
        } else {
            System.out.println("Invalid coupon index! Please try again");
        }
    }

    // Method to generate a list of example coupons
    public void generateExampleCoupons() {
        availableCoupons.add(new FixedDiscount(10, "Coupon 1", "Terms and conditions for Coupon 1", "Fixed", 5.0, "C1", 5.0));
        availableCoupons.add(new PercentageDiscount(20, "Coupon 2", "Terms and conditions for Coupon 2", "Percentage", 10.0, "C2", 10.0));
        availableCoupons.add(new FixedDiscount(15, "Coupon 3", "Terms and conditions for Coupon 3", "Fixed", 7.0, "C3", 7.0));
        availableCoupons.add(new PercentageDiscount(25, "Coupon 4", "Terms and conditions for Coupon 4", "Percentage", 15.0, "C4", 15.0));
        availableCoupons.add(new FixedDiscount(12, "Coupon 5", "Terms and conditions for Coupon 5", "Fixed", 6.0, "C5", 6.0));
        availableCoupons.add(new PercentageDiscount(22, "Coupon 6", "Terms and conditions for Coupon 6", "Percentage", 12.0, "C6", 12.0));
        availableCoupons.add(new FixedDiscount(18, "Coupon 7", "Terms and conditions for Coupon 7", "Fixed", 8.0, "C7", 8.0));
        availableCoupons.add(new PercentageDiscount(30, "Coupon 8", "Terms and conditions for Coupon 8", "Percentage", 20.0, "C8", 20.0));
    }

    // For testing purpose
    public static void main(String[] args) {
        ArrayList<Coupon> coupons = new ArrayList<>();
        PointRedeem redeem = new PointRedeem(coupons);
        redeem.generateExampleCoupons();
        redeem.displayAvailableCoupons();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose a coupon to redeem (enter index): ");
        int couponIndex = scanner.nextInt();
        redeem.redeemCoupon(couponIndex - 1, 50); // Assuming total price is 50
    }
}
