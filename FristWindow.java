import javax.swing.*;

public class Graphics {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        JLabel lab = new JLabel("Я не метка 1");
        JPanel p = new JPanel();
        JButton b1 = new JButton("Кнопка 1");
        JButton b2 = new JButton("Кнопка 2");
        JButton b3 = new JButton("Кнопка 3");
        JButton b4 = new JButton("Кнопка 4");
        JButton b5 = new JButton("Кнопка 5");
        JButton b6 = new JButton("Кнопка 6");
        JButton b7 = new JButton("Кнопка 7");
        JButton b8 = new JButton("Кнопка 8");
        JButton b9 = new JButton("Кнопка 9");

        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(b7);
        p.add(b8);
        p.add(b9);

        f.setSize(500,500);
        f.add(p);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
