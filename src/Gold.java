import javax.swing.*;
import java.awt.*;

//골드 클래스
public class Gold {
    Image gold = new ImageIcon("src/image/Gold.png").getImage();
    
    int x, y;
    int width = 10;
    int height = 10;
    int DX;
    int DY;
    public Gold(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
