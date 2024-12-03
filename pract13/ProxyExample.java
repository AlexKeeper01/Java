public class ProxyExample {
    public static void main(String[] args) {
        Image image = new ImageProxy();
        System.out.println("First call to display:");
        image.display();
        System.out.println("\nSecond call to display:");
        image.display();
    }
}
