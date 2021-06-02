package lab6;

import java.awt.*;
import java.util.Observable;

class Ball extends Observable implements Runnable {
    Thread thr;
    private boolean xplus;
    private boolean yplus;
    int x;
    int y;
    int widtxt;

    Color col;
    String txt;
    Integer speed;
    Integer count;
    Integer len;
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

    @Override
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
            } catch (InterruptedException e) {
            }
        }
    }
}
