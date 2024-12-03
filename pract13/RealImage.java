class RealImage implements Image {
    public RealImage() {
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading image.");
    }

    public void display() {
        System.out.println("Displaying image.");
    }
}
