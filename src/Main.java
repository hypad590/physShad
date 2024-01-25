import javax.swing.*;
import java.awt.*;

class VertLine extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.CYAN);
        int x = getWidth() / 3;
        g.drawLine(x, 0, x, getHeight());
    }
}

public class Main extends JFrame {

    public static JFrame window;
    public static JLabel label;
    public static ImageIcon bgimg;
    public static JPanel panel;
    private static int w = 800;
    private static int h = 400;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            window = new JFrame("physShad");
            window.setBounds(0, 0, w, h);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            panel = new JPanel(null);
            bgimg = new ImageIcon("D:/projects/jav/physShadows/src/bg.png");
            label = new JLabel(bgimg);
            label.setSize(new Dimension(w, h));
            panel.add(label);

            VertLine line = new VertLine();
            line.setSize(1, h);
            line.setLocation(w / 3, 0);
            panel.add(line);

            window.setContentPane(panel);
            window.setVisible(true);
        });
    }
}