package lab6;

import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

class Balls extends Frame implements Observer, ActionListener, ItemListener {

    private LinkedList LL = new LinkedList();
    public Color col;
    private Frame f;
    private Button b;
    private Choice colChoice;
    private Choice speedChoice;
    private Choice objChoice;
    private Choice newspeedChoice;
    private TextField txtObj;
    private TextField txtNom;
    private Integer speed;
    private Integer newspeed;

    Balls() {
        this.addWindowListener(new WindowAdapter2());
        f = new Frame();
        f.setSize(new Dimension(300, 270));
        f.setLocation(950, 140); // Расположение основного окна
        f.setResizable(false); // Фиксированный размер
        f.setBackground(Color.LIGHT_GRAY); // цвет фона
        f.setLayout(new FlowLayout());
        f.setTitle("Настройки");
        f.addWindowListener(new WindowAdapter2());

        Label lab1 = new Label("Название объекта", Label.RIGHT);
        f.add(lab1);
        txtObj = new TextField("Текст", 13); // текст поле
        f.add(txtObj);

        Label lab2 = new Label("Выбор цвета", Label.RIGHT);
        f.add(lab2);
        colChoice = new Choice(); // список
        colChoice.addItem("Синий");
        colChoice.addItem("Зелёный");
        colChoice.addItem("Красный");
        colChoice.addItem("Розовый");
        colChoice.addItem("Оранжевый");
        colChoice.addItemListener(this);
        f.add(colChoice);

        Label lab3 = new Label("Начальная скорость", Label.LEFT);
        f.add(lab3);
        speedChoice = new Choice(); // список
        speedChoice.addItem("1");
        speedChoice.addItem("2");
        speedChoice.addItem("3");
        speedChoice.addItem("4");
        speedChoice.addItem("5");
        speedChoice.addItemListener(this);
        f.add(speedChoice);

        Label labEmpty = new Label("");
        f.add(labEmpty);

        Label lab4 = new Label(" Выбор объекта");
        f.add(lab4);
        objChoice = new Choice(); // список
        objChoice.addItem(" ");
        objChoice.addItemListener(this);
        f.add(objChoice);

        Label lab5 = new Label(" Номера объекта");
        f.add(lab5);
        txtNom = new TextField("", 13); // текст поле
        f.add(txtNom);

        Label lab6 = new Label("Изменение скорости");
        f.add(lab6);

        newspeedChoice = new Choice(); // список
        newspeedChoice.addItem("1");
        newspeedChoice.addItem("2");
        newspeedChoice.addItem("3");
        newspeedChoice.addItem("4");
        newspeedChoice.addItem("5");
        newspeedChoice.addItemListener(this);
        f.add(newspeedChoice);

        Label l11 = new Label(" ");
        f.add(l11);
        b = new Button(" Пуск "); // кнопка
        b.setActionCommand("OK");
        b.addActionListener(this);
        f.add(b);
        f.setVisible(true);

        this.setSize(500, 300);
        this.setVisible(true);
        this.setLocation(100, 150);
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

    public int maxSize = 3;

    public void paint(Graphics g) {

        if (!LL.isEmpty()) {
            for (Object LL1 : LL) {
                Ball ball = (Ball) LL1;
                g.setColor(ball.col);
                g.setFont(ball.fn);
                if (ball.count <= maxSize) {
                    g.drawString((ball.txt + " " + ball.count).trim(), ball.x, ball.y);
                }
                if (ball.count > maxSize) {
                    continue;
                }
            }
        }
    }

    public void itemStateChanged(ItemEvent iE) {
    }

    public void actionPerformed(ActionEvent aE) {
        String str = aE.getActionCommand();
        if (str.equals("OK")) {
            setBackground(Color.WHITE); // Фон демонстрационного окна
            // Меняем цвет
            switch (colChoice.getSelectedIndex()) {
                case 0 -> col = Color.blue;
                case 1 -> col = Color.green;
                case 2 -> col = Color.red;
                case 3 -> col = Color.pink;
                case 4 -> col = Color.orange;
            }

            // Начальная скорость
            switch (speedChoice.getSelectedIndex()) {
                case 0 -> speed = 6;
                case 1 -> speed = 8;
                case 2 -> speed = 10;
                case 3 -> speed = 12;
                case 4 -> speed = 14;
                case 5 -> speed = 16;
            }

            // Меняем скорость
            switch (newspeedChoice.getSelectedIndex()) {
                case 0 -> newspeed = 3;
                case 1 -> newspeed = 5;
                case 2 -> newspeed = 7;
                case 3 -> newspeed = 9;
                case 4 -> newspeed = 11;
                case 5 -> newspeed = 13;
            }

            String txt = txtObj.getText(); // Меняем текст
            Integer len = (txt.toString()).trim().length(); // узнаем длину текстового блока
            txtNom.setText(String.valueOf(objChoice.countItems())); // Значение текст поля Номер
            boolean ft;
            String strN = String.valueOf(objChoice.getSelectedIndex());
            if (objChoice.getSelectedIndex() != 0) {
                txtNom.setText(strN);
                ft = true;
            }
            else
                ft = false;


            int count = Integer.parseInt(txtNom.getText()); // Номер фигуры

            if (!ft) { // Если новая фигура
                objChoice.addItem(txt);
                Ball ball = new Ball(col, txt, speed, count, len);
                LL.add(ball);
                ball.addObserver(this);
            }

            else { // Если старая фигура
                int x = 0;
                System.out.println(LL.get(count - 1)); // цвет старой фигуры
                for (Object LL1 : LL) {
                    Ball ball = (Ball) LL1;
                    System.out.println(ball.count);
                    break;
                }
                x++;
            }

            speed = newspeed;
            Ball ball = new Ball(col, txt, speed, count, len);
            LL.set(count - 1, ball);
            ball.addObserver(this);
        }
    }

    static class Ball extends Observable implements Runnable {

        Thread thr;
        private boolean xplus;
        private boolean yplus;
        int x;
        int y;
        int widtxt;
        Integer len;
        Integer count;
        Integer speed;
        String txt;
        Color col;

        Font fn;
        public Ball(Color col, String text, Integer speed, Integer count, Integer len) {
            xplus = true;
            yplus = true;
            x = -5;
            y = 30;
            this.col = col;
            this.txt = text;
            this.speed = speed;
            this.count = count;
            this.len = len + 3;
            fn = new Font("Courier", Font.ITALIC, 12);
            Main6.count++;
            thr = new Thread(this, Main6.count + ":" + text + ":");
            thr.start();
        }

        public void run() {
            while (true) {
                widtxt = x + len;
                if (widtxt > 460) {
                    xplus = false;
                }
                if (x <= 0) {
                    xplus = true;
                }
                if (y >= 290) {
                    yplus = false;
                }
                if (y < 37) {
                    yplus = true;
                }
                if (xplus)
                    x++;
                else
                    x--;

                if (yplus)
                    y++;
                else
                    y--;

                setChanged();
                notifyObservers(this);
                try {
                    Thread.sleep(speed);
                }
                catch (InterruptedException e) {
                }
            }
        }
    }

    // обработчик для закрытия окна

    static class WindowAdapter2 extends WindowAdapter {
        public void windowClosing(WindowEvent wE) {
            System.exit(0);
        }
    }
}
