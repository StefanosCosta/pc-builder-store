/**
 * The PCScreen contains a simple screen size variable.
 */
public class PCScreen {
    private float screenSize;

    PCScreen(float screenSize) {
        this.screenSize = screenSize;
    }

    public String getScreenSize() {
        return Float.toString(screenSize) + " inches";
    }
    
}
