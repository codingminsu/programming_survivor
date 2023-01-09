import javax.swing.*;
import java.awt.*;

//경험치 클래스
public class Exp {
    Image exp = new ImageIcon("src/image/Exp.png").getImage();
    
    int x, y;
    int width = 10;
    int height = 10;
    int DX;
    int DY;
    
    public Exp(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
