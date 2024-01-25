import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public static JFrame window;
    public static JLabel label;
    private static int w= 800;
    private static int h = 400;
    public float angle;

    public static void main(String[] args) {
        window = new JFrame("physShad");
        window.setBounds(0,0,w,h);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setLayout(null);
        ImageIcon bgimg = new ImageIcon("D:/projects/jav/physShadows/src/bg.jpg");
        label = new JLabel(bgimg);
        label.setLayout(new BorderLayout());
        label.setBounds(window.getBounds());
        window.setContentPane(label);
        window.setVisible(true);
    }
}
