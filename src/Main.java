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
    public static JLayeredPane layeredPane;
    private static int w = 800;
    private static int h = 400;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            window = new JFrame("physShad");
            window.setBounds(0, 0, w, h);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            layeredPane = new JLayeredPane();

            bgimg = new ImageIcon("D:/projects/jav/physShadows/src/bg.png");
            label = new JLabel(bgimg);
            label.setBounds(0, 0, w, h);
            layeredPane.add(label, JLayeredPane.DEFAULT_LAYER);

            VertLine line = new VertLine();
            int lineX = w / 2;
            line.setBounds(lineX, 0, 1, h);
            layeredPane.add(line, JLayeredPane.PALETTE_LAYER);

            window.setContentPane(layeredPane);
            window.setVisible(true);
        });
    }
}