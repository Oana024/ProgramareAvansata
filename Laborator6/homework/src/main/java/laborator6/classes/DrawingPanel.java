package laborator6.classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    int rows, cols;
    int canvasWidth = 720, canvasHeight = 720;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    int stoneSize = 30;
    int rowsNumber, colsNumber;
    int player = 0;
    int moves = 0;
    List<Stone> stones = new ArrayList<Stone>();
    List<Stick> sticks = new ArrayList<Stick>();

    BufferedImage image;
    Graphics2D offscreen;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;

        createOffscreenImage();

        rowsNumber = frame.configPanel.getRows();
        colsNumber = frame.configPanel.getCols();

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                if (verify(x, y)) {
                    player = 1 - player;
                    if (!isPosibleMove(player)) {
                        System.out.print("Jucatorul ");
                        if (player == 1)
                            System.out.print("albastru a castigat\n");
                        else
                            System.out.print("rosu a castigat\n");
                    }
                    moves++;
                }
                repaint();
            }
        });

        init(rowsNumber, colsNumber);


    }

    final void init(int rows, int cols) {

        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));

        for (int i = 0; i < (7 * (rowsNumber * colsNumber)) / 10; i++)
            drawRandomSticks();

//        for(Stick stick : sticks)
//            System.out.println(stick.getX1() + " " + stick.getY1() + " " + stick.getX2() + " " + stick.getY2());
    }

    //verific daca am dat click in interiorul unui cerc
    private Boolean isIntersection(int x, int y, int x1, int y1) {
        if ((x > (x1 - stoneSize / 2) && x < (x1 + stoneSize / 2)) && (y > (y1 - stoneSize / 2) && y < (y1 + stoneSize / 2)))
            return true;
        return false;
    }

    //verific daca cercul selectat nu este deja colorat
    private Boolean freeNode(int x, int y) {
        for (Stone stone : stones)
            if (stone.getX() == x && stone.getY() == y)
                return false;
        return true;
    }

    //verific daca piesa pe care vreau sa o pun are vecin de culoare opusa
    private Boolean isNeighbor(Stick stick, int c) {
        int x1, x2, y1, y2;
        if (c == 1) { //daca piesa mea este in capatul 1 al stick-ului, verific ce este in capatul 2
            x2 = stick.getX2();
            y2 = stick.getY2();
            for (Stone stone : stones) {
                if (stone.getX() == x2 && stone.getY() == y2 && stone.getColor() != player) { //verific daca piesa din capatul celalat al stick-ului are culoare diferita de cea curenta
                    return true;
                }
            }
        } else { //daca piesa mea este in capatul 2 al stick-ului, verific ce este in capatul 1
            x1 = stick.getX1();
            y1 = stick.getY1();
            for (Stone stone : stones) {
                if (stone.getX() == x1 && stone.getY() == y1 && stone.getColor() != player) {
                    return true;
                }
            }
        }
        return false;
    }

    /* pentru coordonatele x, y ale mouse-ului fac verificarile necesare:
        1. am dat click in interiorul unui cerc
        2. daca am trecut de pasul 1 verific sa nu fie deja ocupat nodul
        3. ultimul pas, verific daca nodul selectat este adiacent cu un nod de culoare opusa
     */
    private Boolean verify(int x, int y) {
        int x1, y1, x2, y2;
        for (Stick stick : sticks) {
            x1 = stick.getX1();
            y1 = stick.getY1();
            x2 = stick.getX2();
            y2 = stick.getY2();

            //verificare pentru un capat al stick-ului
            if (isIntersection(x, y, x1, y1)) {//pasul 1
                if (freeNode(x1, y1)) { //pasul 2
                    if (isNeighbor(stick, 1) || moves == 0) {//pasul 3
                        stones.add(new Stone(x1, y1, player)); //daca am trecut toate conditiile adaug un nou nod in lista
                        return true;
                    }
                }
            }

            //verificare pentru celalalt capat al stick-ului
            if (isIntersection(x, y, x2, y2)) {
                if (freeNode(x2, y2)) {
                    if (isNeighbor(stick, 2) || moves == 0) {
                        stones.add(new Stone(x2, y2, player));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //verific daca jucatorul curent are vreo mutare disponibila
    private Boolean isPosibleMove(int player) {
        int x1, y1, x2, y2;
        for (Stone stone : stones) { //caut in toate nodurile care au culoare opusa unul care sa aiba un nod adiacent neocupat
            if (stone.getColor() != player) {
                for (Stick stick : sticks) {
                    x1 = stick.getX1();
                    y1 = stick.getY1();
                    x2 = stick.getX2();
                    y2 = stick.getY2();

                    if (stone.getX() == x1 && stone.getY() == y1) {
                        int ok = 0;
                        for (Stone stone2 : stones) {
                            if (stone2.getX() == x2 && stone2.getY() == y2)
                                ok = 1;
                        }
                        if (ok == 0)
                            return true;
                    }

                    if (stone.getX() == x2 && stone.getY() == y2) {
                        int ok = 0;
                        for (Stone stone2 : stones) {
                            if (stone2.getX() == x1 && stone2.getY() == y1)
                                ok = 1;
                        }
                        if (ok == 0)
                            return true;
                    }
                }

            }
        }
        return false;
    }

    private void createOffscreenImage() {
        image = new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        offscreen = image.createGraphics();
        offscreen.setColor(Color.WHITE);
        offscreen.fillRect(0, 0, canvasWidth, canvasHeight);
    }

    public BufferedImage getImage() {
        return image;
    }

    private void paintGrid() {
        offscreen.setColor(Color.black);

        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            offscreen.drawLine(x1, y1, x2, y2);

        }

        for (int col = 0; col < cols; col++) {
            int x1 = padX + col * cellWidth;
            int y1 = padY;
            int x2 = x1;
            int y2 = padY + boardHeight;
            offscreen.drawLine(x1, y1, x2, y2);
        }

        for (Stick stick : sticks) {
            offscreen.setStroke(new BasicStroke(6));
            offscreen.setColor(Color.black);
            offscreen.drawLine(stick.getX1(), stick.getY1(), stick.getX2(), stick.getY2());
        }

        offscreen.setStroke(new BasicStroke(1));
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                offscreen.setColor(Color.gray);
                offscreen.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }
    }

    private void paintStones() {
        for (int i = 0; i < stones.size(); i++) {
            if (i % 2 == 0)
                offscreen.setColor(Color.BLUE);
            else
                offscreen.setColor(Color.RED);
            offscreen.fillOval(stones.get(i).getX() - stoneSize / 2, stones.get(i).getY() - stoneSize / 2, stoneSize, stoneSize);
        }
    }

    @Override
    public void update(Graphics g) {
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        paintGrid();
        paintStones();
        graphics.drawImage(image, 0, 0, this);
    }

    //verific daca stick-ul generat random nu exista deja, ca sa nu-l adaug de 2 ori in lista
    private Boolean stickExists(int x1, int y1, int x2, int y2) {
        int xs1, xs2, ys1, ys2;
        for (Stick stick : sticks) {
            if (x1 == stick.getX1() && y1 == stick.getY1() && x2 == stick.getX2() && y2 == stick.getY2())
                return true;
        }

        return false;
    }

    private void drawRandomSticks() {
        Random rand = new Random();
        int row, col, x1, x2, y1, y2;

        row = rand.nextInt(rows);
        col = rand.nextInt(cols - 1);

        x1 = padX + col * cellWidth;
        y1 = padY + row * cellHeight;

        x2 = padX + (col + 1) * cellWidth;
        y2 = y1;

        if (!stickExists(x1, y1, x2, y2))
            sticks.add(new Stick(x1, y1, x2, y2));

        //veritical
        row = rand.nextInt(rows - 1);
        col = rand.nextInt(cols);

        x1 = padX + col * cellWidth;
        y1 = padY + row * cellHeight;

        x2 = x1;
        y2 = padY + (row + 1) * cellHeight;
        ;

        if (!stickExists(x1, y1, x2, y2))
            sticks.add(new Stick(x1, y1, x2, y2));
    }

    public void changeDim() {
        createOffscreenImage();

        rowsNumber = frame.configPanel.getRows();
        colsNumber = frame.configPanel.getCols();
        sticks = new ArrayList<>();
        stones = new ArrayList<>();
        init(rowsNumber, colsNumber);
        player = 0;
        moves = 0;
        repaint();
    }

}
