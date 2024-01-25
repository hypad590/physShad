import javax.swing.*;
import java.awt.*;
class VertLine extends JComponent{
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.cyan);
        int x = getWidth() /3;
        g.drawLine(x,0,x, getHeight());
    }
}
public class Main extends JFrame {

    public static JFrame window;
    public static JLabel label;
    public static ImageIcon bgimg;
    public static JPanel panel;
    private static int w= 800;
    private static int h = 400;
    public float angle;

    public static void main(String[] args) {
        window = new JFrame("physShad");
        window.setBounds(0,0,w,h);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setLayout(null);
        panel= new JPanel(new BorderLayout());
        bgimg = new ImageIcon("D:/projects/jav/physShadows/src/bg.png");
        label = new JLabel(bgimg);
        label.setSize(new Dimension(w,h));
        panel.add(label, BorderLayout.CENTER);
        VertLine line = new VertLine();
        panel.add(line);
        window.setContentPane(panel);
        window.setVisible(true);
    }
}
