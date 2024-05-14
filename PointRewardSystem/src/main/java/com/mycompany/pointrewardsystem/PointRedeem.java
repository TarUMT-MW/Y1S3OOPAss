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
            System.out.println("Coupon " + (i + 1) + ": " + coupon.getCouponName() + " - Points : " + coupon.getCouponPrice());
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
            System.out.println("Discounted Price: RM " + discountedPrice);
        } else {
            System.out.println("Invalid coupon index! Please try again");
        }
    }

    // Method to generate a list of example coupons
    public void generateExampleCoupons() {
        availableCoupons.add(new FixedDiscount(10, "KFC Discount RM 10 voucher", "Terms and conditions for Coupon 1", "Fixed", 10.0, "C1", 10.0));
        availableCoupons.add(new PercentageDiscount(100, "STARBUCKS Discount 20% voucher", "Terms and conditions for Coupon 2", "Percentage", 20.0, "C2", 20.0));
        availableCoupons.add(new FixedDiscount(15, "MCDONALD Discount RM 15 voucher", "Terms and conditions for Coupon 3", "Fixed", 15.0, "C3", 15.0));
        availableCoupons.add(new PercentageDiscount(125, "YUMMYCAFE Discount 25% voucher", "Terms and conditions for Coupon 4", "Percentage", 25.0, "C4", 25.0));
        availableCoupons.add(new FixedDiscount(12, "MRDIY Discount RM 12 voucher", "Terms and conditions for Coupon 5", "Fixed", 12.0, "C5", 12.0));
        availableCoupons.add(new PercentageDiscount(100, "AEON Discount 20% voucher", "Terms and conditions for Coupon 6", "Percentage", 20.0, "C6", 20.0));
        availableCoupons.add(new FixedDiscount(18, "PAVILLION Discount RM 18 voucher", "Terms and conditions for Coupon 7", "Fixed", 18.0, "C7", 18.0));
        availableCoupons.add(new PercentageDiscount(150, "PARKSON Discount 30% voucher", "Terms and conditions for Coupon 8", "Percentage", 30.0, "C8", 30.0));
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
        redeem.redeemCoupon(couponIndex - 1, 50); // Assuming total points is 50
    }
}
