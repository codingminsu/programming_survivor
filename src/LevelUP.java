import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;



public class LevelUP extends JFrame {
	JLayeredPane pane =new JLayeredPane();

	static JButton btn11= new JButton(new ImageIcon("src/image/Levelupg.png"));
	static JButton btn22 = new JButton(new ImageIcon("src/image/Levelupg.png"));
	static JButton btn33 = new JButton(new ImageIcon("src/image/Levelupg.png"));
	
    private Image skill1;
    private Image skill2;
    private Image skill3;

    
    
    int x1=150;
    int y1=35, y2=205, y3=390;
    static int[] max = new int[8];
    JPanel item1 = new JPanel() {
	Image bgi1 = new ImageIcon("src/image/Levelup.png").getImage();
	public void paint(Graphics g) {
			g.drawImage(bgi1, 0 , 0 ,400,600,null);
			skillDraw(g);
		}
	};

	int rn1,rn2;
    int items1,items2,items3;
    
	public LevelUP() {

		setUndecorated(true);
		setSize(400,600);
		setResizable(false);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
        setVisible(false);
        pane.setSize(400,600);
        pane.setLayout(null);
	    pane.add(item1);

	}
	
	public void levelon() {
        setVisible(true);

		item1.setBounds(0,0,400,800);

	    
		btn11.setBounds(20,150,350,50);
        btn11.setBorderPainted(false);
        btn11.setContentAreaFilled(false);
        btn11.setFocusPainted(false);
        add(btn11);

        btn22.setBounds(20,330,350,50);
        btn22.setBorderPainted(false);
        btn22.setContentAreaFilled(false);
        btn22.setFocusPainted(false);
        add(btn22);

		btn33.setBounds(20,500,350,50);
        btn33.setBorderPainted(false);
        btn33.setContentAreaFilled(false);
        btn33.setFocusPainted(false);
        add(btn33);


        add(pane);
        do {
        	items1=(1+(int)(Math.random()*7));
        }while(max[items1]==1);        
        rn1=items1;
        System.out.println(""+items1);
        imagesel(1,items1);
        
        do{
        	items2=(1+(int)(Math.random()*7));
        }while(rn1==items2||max[items2]==1);
        
		rn2=items2;	
        System.out.println(""+items2);
        imagesel(2,items2);

        
        do{
        	items3=(1+(int)(Math.random()*7));
        }while(rn1==items3||rn2==items3||max[items3]==1);
	

        System.out.println(""+items3);
        imagesel(3,items3);
        pane.repaint();
		cg();
	}
	public void imagesel( int n, int i) {
		if(n==1) {
			if(i==1) {
				skill1 = new ImageIcon("src/image/Keyboard.png").getImage();
			}
			else if(i==2) {
				skill1 = new ImageIcon("src/image/모니터 real.png").getImage();
			}
			else if(i==3) {
				skill1 = new ImageIcon("src/image/전북대 real.png").getImage();
			}
			else if(i==4) {
				skill1 = new ImageIcon("src/image/Mouse2.png").getImage();
			}
			else if(i==5){
				skill1 = new ImageIcon("src/image/팩맨.png").getImage();
			}
			else if(i==6) {
				skill1 = new ImageIcon("src/image/드론 realreal.png").getImage();
			}
			else if(i==7) {
				skill1 = new ImageIcon("src/image/전기1.png").getImage();
			}
		}
		else if(n==2) {
			if(i==1) {
				skill2 = new ImageIcon("src/image/Keyboard.png").getImage();
			}
			else if(i==2) {
				skill2 = new ImageIcon("src/image/모니터 real.png").getImage();
			}
			else if(i==3) {
				skill2 = new ImageIcon("src/image/전북대 real.png").getImage();
			}
			else if(i==4) {
				skill2 = new ImageIcon("src/image/Mouse2.png").getImage();
			}
			else if(i==5){
				skill2 = new ImageIcon("src/image/팩맨.png").getImage();
			}
			else if(i==6) {
				skill2 = new ImageIcon("src/image/드론 realreal.png").getImage();
			}
			else if(i==7) {
				skill2 = new ImageIcon("src/image/전기1.png").getImage();
			}
		}
		else if(n==3) {
			if(i==1) {
				skill3 = new ImageIcon("src/image/Keyboard.png").getImage();
			}
			else if(i==2) {
				skill3 = new ImageIcon("src/image/모니터 real.png").getImage();
			}
			else if(i==3) {
				skill3 = new ImageIcon("src/image/전북대 real.png").getImage();
			}
			else if(i==4) {
				skill3 = new ImageIcon("src/image/Mouse2.png").getImage();
			}
			else if(i==5){
				skill3 = new ImageIcon("src/image/팩맨.png").getImage();
			}
			else if(i==6) {
				skill3 = new ImageIcon("src/image/드론 realreal.png").getImage();
			}
			else if(i==7) {
				skill3 = new ImageIcon("src/image/전기1.png").getImage();
			}
		}
	}
	
	public void skillDraw(Graphics g) {
		g.drawImage(skill1,x1,y1,100,100, null);
		g.drawImage(skill2,x1,y2,100,100, null);
		g.drawImage(skill3,x1,y3,100,100, null);
	}
	
	public void cg(){
		btn11.addMouseListener(new MouseAdapter() { 
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) { 
			}
			public void mousePressed(MouseEvent e) {
				
				weponLevel(items1);
				rn1=0;
				rn2=0;
				items1=0;
				items2=0;
				items3=0;
				wayReset();
				Game.Over=false;
		        setVisible(false);
			} 
		});
		btn22.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) { 
			}
			public void mousePressed(MouseEvent e) {
				weponLevel(items2);
				rn1=0;
				rn2=0;
				items1=0;
				items2=0;
				items3=0;
		        wayReset();
				Game.Over=false;
		        setVisible(false);

			} 
		});
		btn33.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) { 
			}
			public void mousePressed(MouseEvent e) {
				weponLevel(items3);
				rn1=0;
				rn2=0;
				items1=0;
				items2=0;
				items3=0;
		        wayReset();
				Game.Over=false;
		        setVisible(false);
			} 
		});
	}

	public void weponLevel(int n) {
		if(n==1) {
			Game.firstWeaponLev++;
			if(Game.firstWeaponLev==5) {
				max[1]=1;
			}
		}
		else if(n==2) {
			Game.secondWeaponLev++;
			if(Game.secondWeaponLev==8) {
				max[2]=1;
			}
		}
		else if(n==3) {
			Game.thirdWeaponLev++;
			if(Game.thirdWeaponLev==2) {
				max[3]=1;
			}
		}
		else if(n==4) {
			Game.fourthWeaponLev++;
			if(Game.fourthWeaponLev==5) {
				max[4]=1;
			}
		}
		else if(n==5) {
			Game.fifthWeaponLev++;
			if(Game.fifthWeaponLev==7) {
				max[5]=1;
			}
		}
		else if(n==6) {
			Game.sixthWeaponLev++;
			if(Game.sixthWeaponLev==8) {
				max[6]=1;
			}
		}
		else if(n==7) {
			Game.seventhWeaponLev++;
			if(Game.seventhWeaponLev==7) {
				max[7]=1;
			}
		}
	}
	public void wayReset() {
		Game.up= false;
		Game.down=false;
		Game.right=false;
		Game.left=false;
	}
	static void reset() {
		for(int i=0; i<8; i++) {
			max[i]=0;
		}
	}
	
    }
