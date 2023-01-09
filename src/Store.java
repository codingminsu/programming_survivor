import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;



public class Store extends JFrame {
	JLayeredPane pane =new JLayeredPane();

    private Image coin = new ImageIcon("src/image/Gold.png").getImage();
    private Image speed = new ImageIcon("src/image/fast.png").getImage();
    private Image maxHp = new ImageIcon("src/image/MaxHP.png").getImage();
    private Image Hp = new ImageIcon("src/image/HP.png").getImage();
   //private Image attackspeed = new ImageIcon("src/image/Aspeed.png").getImage();
    private Image damage = new ImageIcon("src/image/Damage.png").getImage();
    private Image arrow = new ImageIcon("src/image/Arrow.png").getImage();
    
	static JButton btn11= new JButton(new ImageIcon("src/image/Storebtn.png"));
	static JButton btn22 = new JButton(new ImageIcon("src/image/Storebtn.png"));
	static JButton btn33= new JButton(new ImageIcon("src/image/Storebtn.png"));
	static JButton btn44 = new JButton(new ImageIcon("src/image/Storebtn.png"));
	static JButton btn55 = new JButton(new ImageIcon("src/image/StoreBtn.png"));
	static JButton btn66 = new JButton(new ImageIcon("src/image/Storecl.png"));
	
	
	

	
    private Image skill1;
    private Image skill2;
    private Image skill3;

    int x1=50;
    int y1=20, y2=190, y3=360;
	
	JPanel item1 = new JPanel() {
		Image bgi2 = new ImageIcon("src/image/Store.png").getImage();
		public void paint(Graphics g) {
			g.drawImage(bgi2, 0 , 0 ,600,600,null);
			Draw(g);
			fDraw(g);
		}
	};

	int rn1,rn2;
    int items1,items2,items3;
    static int price1=30,price2=10,price3=10,price4=10,price5=20;
    static int resSpeed = Game.playerSpeed+1;
    static double resDmg = Game.playerDmg+0.1;
    static int resMaxHp = Game.playerMaxHp+50;
   //static double resAspeed = Game.playerAspeed+0.1;
    static int resHp = Game.uiHp+2;
    
	public Store() {

		setUndecorated(true);
		setSize(600,400);
		setResizable(false);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
        setVisible(false);
        pane.setSize(600,400);
        pane.setLayout(null);
       
        
	    pane.add(item1);

	}
	
	public void storeon() {
        setVisible(true);

		item1.setBounds(0,0,600,400);

		
		btn11.setBounds(70,150,100,50);
        btn11.setBorderPainted(false);
        btn11.setContentAreaFilled(false);
        btn11.setFocusPainted(false);
		add(btn11);

        btn22.setBounds(180,150,100,50);
        btn22.setBorderPainted(false);
        btn22.setContentAreaFilled(false);
        btn22.setFocusPainted(false);
        add(btn22);
        
    	btn33.setBounds(290,150,100,50);
        btn33.setBorderPainted(false);
        btn33.setContentAreaFilled(false);
        btn33.setFocusPainted(false);
        add(btn33);

        //btn44.setBounds(360,150,100,50);
       // btn44.setBorderPainted(false);
       // btn44.setContentAreaFilled(false);
       // btn44.setFocusPainted(false);
       // add(btn44);
        
        btn55.setBounds(400,150,100,50);
        btn55.setBorderPainted(false);
        btn55.setContentAreaFilled(false);
        btn55.setFocusPainted(false);
        btn55.setHorizontalTextPosition(JButton.CENTER);
        add(btn55);
        
		btn66.setBounds(0,350,600,50);
        btn66.setBorderPainted(false);
        btn66.setContentAreaFilled(false);
        btn66.setFocusPainted(false);
        add(btn66);
        
        add(pane);
        
        pane.repaint();
		cg();
	}

	public void Draw(Graphics g) {
		g.drawImage(speed,100, 60, 50,50,null);
		g.drawImage(coin, 100, 110, 25,25,null);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString(" "+price1, 130, 130);
		g.drawImage(damage,215, 60, 50,50,null);
		g.drawImage(coin, 210, 110, 25,25,null);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString(" "+price2, 240, 130);
		g.drawImage(maxHp,320, 60, 50,50,null);
		g.drawImage(coin, 320, 110, 25,25,null);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString(" "+price3, 350, 130);
		//g.drawImage(attackspeed,380, 60, 50,50,null);
		//g.drawImage(coin, 380, 110, 25,25,null);
		//g.setColor(Color.BLACK);
		//g.setFont(new Font("Arial", Font.BOLD, 20));
		//g.drawString(" "+price4, 410, 130);
		g.drawImage(Hp,420, 60, 50,50,null);
		g.drawImage(coin, 420, 110, 25,25,null);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString(" "+price5, 450, 130);

	
		
		
	}
	public void fDraw(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString(""+Game.playerSpeed,120,220);
		g.drawImage(arrow,100, 230, 50,50,null);
		g.drawString(""+resSpeed,110,310);
		String Dmg = String.format("%.1f",Game.playerDmg);
		g.drawString(""+Dmg, 220,220);
		g.drawImage(arrow,210, 230, 50,50,null);
		String resDmg2 = String.format("%.1f",resDmg);
		g.drawString(""+resDmg2,220,310);
		g.drawString(""+Game.playerMaxHp, 325,220);
		g.drawImage(arrow,320, 230, 50,50,null);
		g.drawString(""+resMaxHp,325,310);
		//String Aspeed = String.format("%.1f",Game.playerAspeed);
		//g.drawString(""+Aspeed, 390,220);
		//g.drawImage(arrow,380, 230, 50,50,null);
		//String resAspeed2 = String.format("%.1f",resAspeed);
		//g.drawString(""+resAspeed2,390,310);
		g.drawImage(Hp,410, 240, 30,30,null);
		g.drawString("Full HP",450,260);
	}
	
	public void cg(){
		btn11.setEnabled(true);
		btn22.setEnabled(true);
		btn33.setEnabled(true);
		btn55.setEnabled(true);
		
		btn11.addMouseListener(new MouseAdapter() { 
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) { 
			}
			public void mousePressed(MouseEvent e) {
					if(Game.playerGold>=price1) {
						btn11.setEnabled(true);
						Game.playerSpeed+=1;
						Game.playerGold-=price1;
						price1 +=20;
						resSpeed+=1;
						repaint();
					}
					else
						btn11.setEnabled(false);
				
			} 
		});
		btn22.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) { 
			}
			public void mousePressed(MouseEvent e) {
			
					if(Game.playerGold>=price2) {
						btn22.setEnabled(true);
						Game.playerDmg+=0.1;
						Game.playerGold-=price2;
						price2 +=10;
						resDmg+=0.1;
						repaint();
					}
					else
						btn22.setEnabled(false);

			} 
		});
		btn33.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) { 
			}
			public void mousePressed(MouseEvent e) {
					if(Game.playerGold>=price3) {
						btn33.setEnabled(true);
						Game.playerMaxHp+=50;
						Game.playerGold-=price3;
						price3 +=10;
						resMaxHp+=50;
						repaint();
					}
					else
						btn33.setEnabled(false);
						
				}
			 
		});
		
		btn55.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) { 
			}
			public void mousePressed(MouseEvent e) {
					if((Game.playerGold>=price5)&&(Game.playerHp<Game.playerMaxHp)) {
						btn55.setEnabled(true);
						Game.playerHp=Game.playerMaxHp;
						if(Game.playerHp>Game.playerMaxHp) {
							Game.playerHp=Game.playerMaxHp;
						}
						
						Game.playerGold-=price5;
						repaint();
					}
					else
						btn55.setEnabled(false);
						
				}
				
			
		});
		
		btn66.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) { 
			}
			public void mousePressed(MouseEvent e) {
				//종료에 이 3친구 필수
		        wayReset();
		        Title.focus();
				Game.Over=false;
		        setVisible(false);
			} 
		});
	}


	public void wayReset() {
		Game.up= false;
		Game.down=false;
		Game.right=false;
		Game.left=false;
	}
	static void storeReset() {
     	price1=30;
     	price2=10;
     	price3=10;
     	price5=20;
     	resSpeed = Game.playerSpeed+1;
     	resDmg = Game.playerDmg+0.1;
     	resMaxHp = Game.playerMaxHp+5;
     	resHp = Game.uiHp+2;
	}

	
    }
