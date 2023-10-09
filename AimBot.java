import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;

public class AimBot{
    public static void main(String[] args) throws AWTException{
        Robot robot = new Robot();
        
        Color color = new Color(255,87,34);

        Rectangle obszar = new Rectangle(550, 340, 800, 480);

        while (true){
            BufferedImage ss = robot.createScreenCapture(obszar);
            for (int row = 0; row < 800; row += 5){
                for (int col = 0; col < 480; col += 5){
                    Color currentColor = new Color(ss.getRGB(row, col));
                    if (currentColor.equals(color)){
                        robot.mouseMove(550 + row, 340 + col);
                        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                    }
                }
            }
        }
    }

    int[] mousePosition(){
        PointerInfo a = MouseInfo.getPointerInfo();
        Point b = a.getLocation();
        int x = (int) b.getX();
        int y = (int) b.getY();
        int[] wspolrzedne = {x, y};
        return wspolrzedne;
    }
}
