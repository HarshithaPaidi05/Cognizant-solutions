
interface PaymentStrategy {
    void pay(int amount);
}


class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}


class PaymentContext {
    private PaymentStrategy strategy;

    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executePayment(int amount) {
        strategy.pay(amount);
    }
}


public class Main {
    public static void main(String[] args) {
        
        PaymentContext context = new PaymentContext(new CreditCardPayment());
        context.executePayment(1000);

        
        context.setPaymentStrategy(new PayPalPayment());
        context.executePayment(500);
    }
}
