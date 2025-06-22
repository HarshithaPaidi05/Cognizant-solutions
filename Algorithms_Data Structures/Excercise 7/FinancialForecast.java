public class FinancialForecast {

    
    public static double calculateFutureValue(double initialAmount, double rate, int years) {
        if (years == 0) {
            return initialAmount;
        }
        return (1 + rate) * calculateFutureValue(initialAmount, rate, years - 1);
    }

    public static void main(String[] args) {
        double initialAmount = 10000;   
        double annualGrowthRate = 0.08; 
        int years = 5;                  
        double futureValue = calculateFutureValue(initialAmount, annualGrowthRate, years);
        System.out.printf("Future Value after %d years: Rs %.2f%n", years, futureValue);
    }
}
