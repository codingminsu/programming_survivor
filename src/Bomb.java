import javax.swing.*;
import java.awt.*;

//폭탄
public class Bomb {
    Image bomb = new ImageIcon("src/image/Bomb.png").getImage();
    
    int x, y;
    int width = 10;
    int height = 10;
    int DX;
    int DY;
    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
