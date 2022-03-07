public class Credit {

    public double getPaymentPerMonth (int money, int percent, int month) {
        double paymentPerMonth = (money / 100 * percent + money) / month;
        return paymentPerMonth;
    }

    public double getTotalAmount (int money, int percent, int month) {
        double totalAmount = getOverpayments(money, percent, month) + money;
        return totalAmount;
    }


    public double getOverpayments (int money, int percent, int month) {
        double overPayments = (money / 100 * percent) * month;
        return overPayments;
    }
}

