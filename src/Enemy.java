import javax.swing.*;
import java.awt.*;


//적 클래스
public class Enemy {
    Image image;  
    
    int x, y;
    int width;
    int height;
    double hp; 
    int Edamage; 
    int Espeed; 
    int DX;
	int DY;
	int boss;
	
    public Enemy(int a,int x, int y) {
    	if(a==1) {
    		this.image = new ImageIcon("src/image/Python.png").getImage();
    		this.width=30;
    		this.height=30;
    		this.hp = 30; 
    		this.Edamage = 1; 
    		this.Espeed = 2;
            this.x = x;
            this.y = y;
    	}
    	else if(a==2) {
    		this.image = new ImageIcon("src/image/Java.png").getImage();
    		this.width=40;
    		this.height=40;
    		this.hp = 60; 
    		this.Edamage = 1; 
    		this.Espeed = 5;
            this.x = x;
            this.y = y;
    	}
    	else if(a==3) {
    		this.image = new ImageIcon("src/image/C.png").getImage();
    		this.width=30;
    		this.height=30;
    		this.hp = 100; 
    		this.Edamage = 2; 
    		this.Espeed = 3;
            this.x = x;
            this.y = y;
    	}
    	else if(a==4) {
    		this.image = new ImageIcon("src/image/C++.png").getImage();
    		this.width=30;
    		this.height=30;
    		this.hp = 150; 
    		this.Edamage = 3; 
    		this.Espeed = 3;
            this.x = x;
            this.y = y;
    	}
    	else if(a==10) {
    		this.image = new ImageIcon("src/image/Boss.png").getImage();
    		this.width=80;
    		this.height=80;
    		this.hp = 2000; 
    		this.Edamage = 5; 
    		this.Espeed = 5;
            this.x = x;
            this.y = y;
            this.boss=1;
    	}
    	
    }
    

}