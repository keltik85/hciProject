package my.app.model.angular;



import my.app.model.angular.details.*;

public class PhoneDetail {
    public PhoneDetail(String additionalFeatures,
                       Android android,
                       String[] availability,
                       Battery battery,
                       Camera camera,
                       Connectivity connectivity,
                       String description,
                       Display display,
                       Hardware hardware,
                       String id,
                       String[] images,
                       String name,
                       SizeAndWeight sizeAndWeight,
                       Storage storage) {
        this.additionalFeatures = additionalFeatures;
        this.android = android;
        this.availability = availability;
        this.battery = battery;
        this.camera = camera;
        this.connectivity = connectivity;
        this.description = description;
        this.display = display;
        this.hardware = hardware;
        this.id = id;
        this.images = images;
        this.name = name;
        this.sizeAndWeight = sizeAndWeight;
        this.storage = storage;
    }

    String additionalFeatures;
    Android android;
    String[] availability;
    Battery battery;
    Camera camera;
    Connectivity connectivity;
    String description;
    Display display;
    Hardware hardware;
    String id;
    String[] images;
    String name;
    SizeAndWeight sizeAndWeight;
    Storage storage;

    public String getAdditionalFeatures() {
        return additionalFeatures;
    }

    public void setAdditionalFeatures(String additionalFeatures) {
        this.additionalFeatures = additionalFeatures;
    }

    public Android getAndroid() {
        return android;
    }

    public void setAndroid(Android android) {
        this.android = android;
    }

    public String[] getAvailability() {
        return availability;
    }

    public void setAvailability(String[] availability) {
        this.availability = availability;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public Connectivity getConnectivity() {
        return connectivity;
    }

    public void setConnectivity(Connectivity connectivity) {
        this.connectivity = connectivity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public Hardware getHardware() {
        return hardware;
    }

    public void setHardware(Hardware hardware) {
        this.hardware = hardware;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SizeAndWeight getSizeAndWeight() {
        return sizeAndWeight;
    }

    public void setSizeAndWeight(SizeAndWeight sizeAndWeight) {
        this.sizeAndWeight = sizeAndWeight;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
