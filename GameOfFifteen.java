import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;



public class FifteenGame extends JPanel {

    // Размер нашей игры "Пятнашки"
    private int size;
    // Количество плиток
    private int nbTiles;
    // Графические размеры игрового поля
    private int dimension;
    // Цвет переднего плана
    private static final Color FOREGROUND_COLOR = new Color(239, 83, 80); // мы используем произвольный цвет
    // Объект для случайного перемешивания плиток
    private static final Random RANDOM = new Random();
    // Хранение плиток в одномерном массиве целых чисел
    private int[] tiles;
    // Размер плитки на экране
    private int tileSize;
    // Позиция пустой плитки
    private int blankPos;
    private boolean gameOver; // true, если игра окончена, иначе false

    public FifteenGame(int size, int dim) {
        this.size = size;
        dimension = dim;

        // Инициализация плиток
        nbTiles = size * size - 1; // -1, потому что мы не считаем пустую плитку
        tiles = new int[size * size];

        // Вычисление размера сетки и размера плитки
        tileSize = dimension / size;

        setPreferredSize(new Dimension(dimension, dimension));
        setBackground(Color.WHITE);
        setForeground(FOREGROUND_COLOR);
        setFont(new Font("TimesNewRoman", Font.BOLD, 60));

        gameOver = true;

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                // Используется для взаимодействия пользователей с сеткой при клике
                // Пришло время реализовать взаимодействие с пользователем для перемещения плиток и решения игры!
                if (gameOver) {
                    newGame();
                } else {
                    // Получение позиции клика
                    int ex = e.getX();
                    int ey = e.getY();

                    // Клик в пределах сетки?
                    if (ex < 0 || ex > dimension || ey < 0 || ey > dimension)
                        return;

                    // Получение позиции в сетке
                    int c1 = ex / tileSize;
                    int r1 = ey / tileSize;

                    // Получение позиции пустой ячейки
                    int c2 = blankPos % size;
                    int r2 = blankPos / size;

                    // Преобразование в 1D координаты
                    int clickPos = r1 * size + c1;

                    int dir = 0;

                    // Поиск направления для перемещения нескольких плиток сразу
                    if (c1 == c2 && Math.abs(r1 - r2) > 0)
                        dir = (r1 - r2) > 0 ? size : -size;
                    else if (r1 == r2 && Math.abs(c1 - c2) > 0)
                        dir = (c1 - c2) > 0 ? 1 : -1;

                    if (dir != 0) {
                        // Перемещаем плитки в указанном направлении
                        do {
                            int newBlankPos = blankPos + dir;
                            tiles[blankPos] = tiles[newBlankPos];
                            blankPos = newBlankPos;
                        } while (blankPos != clickPos);

                        tiles[blankPos] = 0;
                    }

                    // Проверяем, решена ли игра
                    gameOver = SolvedTiles();
                }

                // Перерисовываем панель
                repaint();
            }
        });
        newGame();
    }

    private void newGame() {
        do {
            reset();
            shuffle();
        } while(!isSolvable());
        gameOver = false;
    }

    private void reset() {
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = (i + 1) % tiles.length;
        }
        blankPos = tiles.length - 1;
    }

    private void shuffle() {
        int n = nbTiles;

        while (n > 1) {
            int r = RANDOM.nextInt(n--);
            int tmp = tiles[r];
            tiles[r] = tiles[n];
            tiles[n] = tmp;
        }
    }

    private boolean SolvedTiles() {
        if (tiles[tiles.length - 1] != 0)
            return false;
        for (int i = nbTiles - 1; i >= 0; i--) {
            if (tiles[i] != i + 1)
                return false;
        }

        return true;
    }

    private void drawGrid(Graphics2D g) {
        for (int i = 0; i < tiles.length; i++) {
            int r = i / size;
            int c = i % size;
            // Преобразуем в координаты на экране
            int x = c * tileSize;
            int y = r * tileSize;
            // Если пустая плитка
            if(tiles[i] == 0) {
                if (gameOver) {
                    g.setColor(FOREGROUND_COLOR);
                    drawCenteredString(g, "\u2713", x, y);
                }
                continue;
            }
            // Для остальных плиток
            g.setColor(getForeground());
            g.fillRoundRect(x, y, tileSize, tileSize, 25, 25);
            g.setColor(Color.BLACK);
            g.drawRoundRect(x, y, tileSize, tileSize, 25, 25);
            g.setColor(Color.WHITE);

            drawCenteredString(g, String.valueOf(tiles[i]), x , y);
        }
    }

    private void drawCenteredString(Graphics2D g, String s, int x, int y) {
        FontMetrics fm = g.getFontMetrics();
        int asc = fm.getAscent();
        int desc = fm.getDescent();
        g.drawString(s,  x + (tileSize - fm.stringWidth(s)) / 2,
                y + (asc + (tileSize - (asc + desc)) / 2));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        drawGrid(g2D);

    }

    public boolean isSolvable()
    {
        int inversions = 0;
        for(int i = 0; i < nbTiles; i++)
            for(int j = 0; j < i; j++)
                if(tiles[j] > tiles[j])
                    inversions++;
        return inversions % 2 == 0;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Игра в Пятнашки");
        frame.add(new FifteenGame(4, 500), BorderLayout.CENTER);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
