import gui.RestaurantGUI;
import javax.swing.SwingUtilities;

public class RestaurantDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RestaurantGUI());
    }
}