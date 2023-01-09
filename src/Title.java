import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Title extends JFrame {
	static JLayeredPane pane =new JLayeredPane();
	
	static JPanel storep = new JPanel();
	static JButton btn1= new JButton(new ImageIcon("src/image/Gamestart.png"));
	static JButton btn3 = new JButton(new ImageIcon("src/image/Storeon.png"));
	static JButton btn2 = new JButton(new ImageIcon("src/image/Htp.png"));
	static JButton backBtn=new JButton(new ImageIcon("src/image/Back.png"));
	static JButton endBtn = new JButton(new ImageIcon("src/image/exit.png"));
	private Image icon = new ImageIcon("src/image/icon.png").getImage();

	
    private Image bufferImage;
    private Graphics screenGraphic;
    private Audio bgm;

    private boolean isMainScreen, isGameScreen;
	private static Game game = new Game();
    private static Store store = new Store();
    
  
	static JLayeredPane page1 = new JLayeredPane() {
		Image mainScreen = new ImageIcon("src/image/BG.png").getImage();
		public void paint(Graphics g) {
			g.drawImage(mainScreen, 0 , 0 ,null);
			
		}
	};
	static JLayeredPane page2=new JLayeredPane() {	
		Image background=new ImageIcon("src/image/BG21.png").getImage();
		public void paint(Graphics g) {
			g.drawImage(background,0,-40,null);
			game.gameDraw(g);
			this.repaint();
		}
		
		
	};
	static JLayeredPane page3 = new JLayeredPane() {
		Image HowToPlayScreen = new ImageIcon("src/image/BG3.png").getImage();//이미지 수정예정
		public void paint(Graphics g) {
			g.drawImage(HowToPlayScreen,0,0,null);
		}
	};
	

	
	public Title() {
				setTitle("Programing Survivor");
				//setUndecorated(true);
				setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
				setResizable(false);
				setLocationRelativeTo(null);
				setIconImage(icon);
		        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        setVisible(true);
		        setLayout(null);
		        pane.setSize(1280,720);
		        pane.setLayout(null);
		        
		        storep.setSize(200,200);
		        storep.setLayout(null);
		        
		        btn1.setBounds(420,350,450,80);
		        btn1.setBorderPainted(false);
		        btn1.setContentAreaFilled(false);
		        btn1.setFocusPainted(false);
		        add(btn1);
		        btn2.setBounds(420,460,450,80);
		        btn2.setBorderPainted(false);
		        btn2.setContentAreaFilled(false);
		        btn2.setFocusPainted(false);
		        add(btn2);
		        endBtn.setBounds(420,570,450,80);
		        endBtn.setBorderPainted(false);
		        endBtn.setContentAreaFilled(false);
		        endBtn.setFocusPainted(false);
		        add(endBtn);
		        
		        backBtn.setBounds(0,0,100,50);
		        backBtn.setBorderPainted(false);
		        backBtn.setContentAreaFilled(false);
		        backBtn.setFocusPainted(false);
		        add(backBtn);

		        add(pane);

		        page1.setBounds(0,0,1280,720);
		        page2.setBounds(0,0,1280,720);
		        page3.setBounds(0,0,1280,720);
			    storep.setBounds(1150,20,100,50);
		        pane.add(storep);
			    pane.add(page1);
			    pane.add(page2);
			    pane.add(page3);
			    storep.setBackground(new Color(255,0,0,0));

			    btn3.setBounds(0,0,100,50);
		        btn3.setBorderPainted(false);
		        btn3.setContentAreaFilled(false);
		        btn3.setFocusPainted(false);
			    storep.add(btn3);
		        focus();
		        init();

				pane.addKeyListener(new KeyListener());

		        
		        
		        cg();

			}
	
    private void init() {
        isMainScreen = true;
        isGameScreen = false;
		page3.setVisible(false);
		page2.setVisible(false);
        page1.setVisible(true);
        btn1.setVisible(true);
        btn2.setVisible(true);
        endBtn.setVisible(true);

        storep.setVisible(false);
        backBtn.setVisible(false);
        
        bgm = new Audio("src/audio/Bgm.wav",true);
        bgm.start();
    }
	
    private void gameStart() {
        isMainScreen = false;
        isGameScreen = true;
        page1.setVisible(false);
		page2.setVisible(true);
		page3.setVisible(false);
	    btn1.setVisible(false);
	    btn2.setVisible(false);
	    endBtn.setVisible(false);
	    
	    backBtn.setVisible(false);
	    storep.setVisible(true);
	    bgm.stop();
        game.start();

    }

    static void focus() {
	    pane.setFocusable(true);
	    pane.requestFocus();
    }
    
	public void cg(){
		btn1.addMouseListener(new MouseAdapter() { 
			@Override 
			public void mouseEntered(MouseEvent e) {
			} 
			@Override 
			public void mouseExited(MouseEvent e) { 
			}
			@Override 
			public void mousePressed(MouseEvent e) {
				gameStart();
				
				//game.start();
			} 
		});
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override 
			public void mouseExited(MouseEvent e) { 
			}
			@Override 
			public void mousePressed(MouseEvent e) {
				page1.setVisible(false);
				page2.setVisible(false);
				page3.setVisible(true);
			    btn1.setVisible(false);
			    btn2.setVisible(false);
			    endBtn.setVisible(false);
			    storep.setVisible(false);
			    backBtn.setVisible(true);
			    bgm.stop();
			        
			} 
		});
		
		endBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override 
			public void mouseExited(MouseEvent e) { 
			}
			@Override 
			public void mousePressed(MouseEvent e) {
				System.exit(0);
				
			} 
		});
		
		
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override 
			public void mouseExited(MouseEvent e) { 				
			}
			@Override 
			public void mousePressed(MouseEvent e) {
				init();
				
			} 
		});
		
		
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override 
			public void mouseExited(MouseEvent e) { 
			}
			@Override 
			public void mousePressed(MouseEvent e) {
				if(Game.Over==false) {
					Game.Over=true;
					store.storeon();	
				}
				
			} 
		});
	}

    class KeyListener extends KeyAdapter {
    	public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    game.setUp(true);
                    game.setPos(3);
                    break;
                case KeyEvent.VK_DOWN:
                    game.setDown(true);
                    game.setPos(2);
                    System.out.println("down");
                    break;
                case KeyEvent.VK_LEFT:
                    game.setLeft(true);
                    game.setPos(1);
                    break;
                case KeyEvent.VK_RIGHT:
                    game.setRight(true);
                    game.setPos(0);
                   
                    break;
                case KeyEvent.VK_R:
                    if (game.isOver()) game.reset();
                    break;

                case KeyEvent.VK_ENTER:
//                    if (isMainScreen) gameStart();
                    break;
                case KeyEvent.VK_ESCAPE:
                    System.exit(0);
                    break;
                case KeyEvent.VK_SPACE:
                    game.tp();
                    break;
            }
        }

        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    game.setUp(false);
                    break;
                case KeyEvent.VK_DOWN:
                    game.setDown(false);
                    break;
                case KeyEvent.VK_LEFT:
                    game.setLeft(false);
                    break;
                case KeyEvent.VK_RIGHT:
                    game.setRight(false);
                    break;

            }
        }
    }
        
	}

	
	