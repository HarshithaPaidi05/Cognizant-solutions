import java.util.*;


interface Stock {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}


class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private int stockPrice;

    public void setStockPrice(int price) {
        this.stockPrice = price;
        notifyObservers();  
    }

    public int getStockPrice() {
        return stockPrice;
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockPrice);
        }
    }
}


interface Observer {
    void update(int price);
}


class MobileApp implements Observer {
    public void update(int price) {
        System.out.println("Mobile App - Stock price updated to: " + price);
    }
}

class WebApp implements Observer {
    public void update(int price) {
        System.out.println("Web App - Stock price updated to: " + price);
    }
}


public class Main {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        market.registerObserver(mobile);
        market.registerObserver(web);

        System.out.println("Stock price set to 100:");
        market.setStockPrice(100);

        System.out.println("\nStock price updated to 150:");
        market.setStockPrice(150);

        market.removeObserver(web);

        System.out.println("\nWeb App removed, update price to 200:");
        market.setStockPrice(200);
    }
}
