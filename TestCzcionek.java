import java.awt.Font;
import java.awt.GraphicsEnvironment;

public class TestCzcionek {
    public static void main(String[] args){
        //fontTest();
        //iteracjaPoStringu();
    }
    static void fontTest(){
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font[] fontNames = graphicsEnvironment.getAllFonts();
        for (Font s : fontNames) {
            System.out.println(s);
        }
    }

    static void iteracjaPoStringu(){
        String s = "Adrian";
        for (char c: s.toCharArray()){
            System.out.println(c);
        }
    }
}
