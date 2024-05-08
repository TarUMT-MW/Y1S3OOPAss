public class Coupon {
    private int couponPrice;
    private String couponName;
    private String tsAndCs;
    private String discountType;
    private double discount;
    private String couponID;

    // Constructors
    public Coupon(int couponPrice, String couponName, String tsAndCs, String discountType, double discount, String couponID) {
        this.couponPrice = couponPrice;
        this.couponName = couponName;
        this.tsAndCs = tsAndCs;
        this.discountType = discountType;
        this.discount = discount;
        this.couponID = couponID;
    }

    // Getters and setters
    public int getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(int couponPrice) {
        this.couponPrice = couponPrice;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getTsAndCs() {
        return tsAndCs;
    }

    public void setTsAndCs(String tsAndCs) {
        this.tsAndCs = tsAndCs;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getCouponID() {
        return couponID;
    }

    public void setCouponID(String couponID) {
        this.couponID = couponID;
    }
}

class FixedDiscount extends Coupon {
    private double value;

    // Constructor
    public FixedDiscount(int couponPrice, String couponName, String tsAndCs, String discountType, double discount, String couponID, double value) {
        super(couponPrice, couponName, tsAndCs, discountType, discount, couponID);
        this.value = value;
    }

    // Getter and setter for value
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}

class PercentageDiscount extends Coupon {
    private double percentage;

    // Constructor
    public PercentageDiscount(int couponPrice, String couponName, String tsAndCs, String discountType, double discount, String couponID, double percentage) {
        super(couponPrice, couponName, tsAndCs, discountType, discount, couponID);
        this.percentage = percentage;
    }

    // Getter and setter for percentage
    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}