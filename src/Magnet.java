import javax.swing.*;
import java.awt.*;

//자석
public class Magnet {
    Image magnet = new ImageIcon("src/image/Magnet.png").getImage();
    
    int x, y;
    int width = 10;
    int height = 10;
    int DX;
    int DY;
    public Magnet(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
