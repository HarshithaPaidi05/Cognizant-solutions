
interface PaymentProcessor {
    void processPayment(double amount);
}


class PayPalGateway {
    public void makePayPalPayment(double amount) {
        System.out.println("Processing payment through PayPal: " + amount);
    }
}

class StripeGateway {
    public void stripePayment(double amount) {
        System.out.println("Processing payment through Stripe: " + amount);
    }
}


class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway paypal;

    public PayPalAdapter(PayPalGateway paypal) {
        this.paypal = paypal;
    }

    public void processPayment(double amount) {
        paypal.makePayPalPayment(amount);
    }
}


class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripe;

    public StripeAdapter(StripeGateway stripe) {
        this.stripe = stripe;
    }

    public void processPayment(double amount) {
        stripe.stripePayment(amount);
    }
}


public class AdapterExample {
    public static void main(String[] args) {
        
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPalGateway());
        paypalProcessor.processPayment(2500.0);

        
        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());
        stripeProcessor.processPayment(3500.0);
    }
}
