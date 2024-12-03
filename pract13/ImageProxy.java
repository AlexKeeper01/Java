public class ImageProxy implements Image {
    private RealImage realImage;

    public ImageProxy() {
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage();
        }
        realImage.display();
    }
}
