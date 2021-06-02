package lab6;

import java.awt.*;

public class Main6 {
    static int count;

    public static void main(String[] args) {
        count = 0;
        Balls balls = new Balls();
        balls.setLocationRelativeTo(null); // Окно в центре экрана
        balls.setResizable(false); // Фиксированный размер
        balls.setTitle("Laba6");
        balls.setBackground(Color.WHITE);
    }
}
