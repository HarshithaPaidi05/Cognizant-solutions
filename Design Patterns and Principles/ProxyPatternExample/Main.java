
interface Image {
    void display();
}

class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromServer();  
    }

    private void loadFromServer() {
        System.out.println("Loading image from server: " + fileName);
    }

    public void display() {
        System.out.println("Displaying image: " + fileName);
    }
}


class ProxyImage implements Image {
    private String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    public void display() {
        
        if (realImage == null) {
            realImage = new RealImage(fileName); // first time load
        }
        realImage.display(); 
    }
}


public class Main {
    public static void main(String[] args) {
        Image img1 = new ProxyImage("flower.jpg");
        Image img2 = new ProxyImage("sunset.png");

        System.out.println("First display:");
        img1.display(); 

        System.out.println("\nSecond display:");
        img1.display();  

        System.out.println("\nDisplay another image:");
        img2.display();  
    }
}
