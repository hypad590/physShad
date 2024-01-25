import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Draw extends JComponent {
    private static float angles = 0;
    public static void setAngle(float newAngle){
        angles = newAngle;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GREEN);
        int x = getWidth() / 3;
        g.drawLine(x, 0, x, getHeight());

        g.setColor(Color.RED);
        int y = getHeight() /2;
        g.drawLine(0, y ,getWidth(), y);

        double rads = Math.toRadians(angles);

        int centerX = getWidth()/3;
        int centerY = getHeight()/2;

        int lineLength = getWidth();


        int endX = centerX + (int) (lineLength * Math.cos(rads));
        int endY = centerY - (int) (lineLength * Math.sin(rads));

        g.setColor(Color.BLACK);
        g.drawLine(centerX,centerY,endX,endY);
    }
}

public class Main extends JFrame {

    public static JFrame window;
    public static JLabel label;
    public static ImageIcon bgimg;
    public static JLayeredPane layeredPane;
    private static int w = 800;
    private static int h = 400;
    private static JTextField textField;

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

            Draw lines = new Draw();
            lines.setBounds(0,0,w,h);
            layeredPane.add(lines, JLayeredPane.PALETTE_LAYER);

            textField = new JTextField();
            textField.setBounds(10,10,50,20);
            textField.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        float newAngle = Float.parseFloat(textField.getText());
                        Draw.setAngle(newAngle);
                        lines.repaint();
                    }catch (NumberFormatException ex){
                        JOptionPane.showMessageDialog(window, "Invalid angle input", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            layeredPane.add(textField,JLayeredPane.PALETTE_LAYER);
            window.setContentPane(layeredPane);
            window.setVisible(true);
        });
    }
}