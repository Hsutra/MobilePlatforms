import javax.swing.*;

public class Graphics {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        JLabel lab = new JLabel("Я не метка 1");
        JPanel p = new JPanel();
        JButton b1 = new JButton("Кнопка 1");
        JButton b2 = new JButton("Кнопка 2");
        JButton b3 = new JButton("Кнопка 3");
        p.add(b1);
        p.add(b2);
        p.add(b3);
        f.setSize(500,500);
        f.add(p);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
