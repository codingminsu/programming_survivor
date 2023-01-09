import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Game extends Thread {


    private int delay = 20;
    private long pretime;
    private int cnt;
    private int time;
    private int min;
    private int sec;
    private int[] bx=new int[20],by=new int[20];
    int cnt6=0;
    int BarrierCnt=0;
    private Image player = new ImageIcon("src/image/Player.png").getImage(); 
    private Image speed = new ImageIcon("src/image/fast.png").getImage();
    private Image maxHp = new ImageIcon("src/image/MaxHP.png").getImage();
    private Image attackspeed = new ImageIcon("src/image/Aspeed.png").getImage();
    private Image damage = new ImageIcon("src/image/Damage.png").getImage();
    private Image info = new ImageIcon("src/image/INFO.png").getImage();
    private Image coin = new ImageIcon("src/image/Gold.png").getImage();
    private Image bosse = new ImageIcon("src/image/bosse.png").getImage();
    private Image bosse2 = new ImageIcon("src/image/bosse2.png").getImage();
    private Image AttackInfo = new ImageIcon("src/image/Attackinfo.png").getImage();
    
    
    private Image skill11 = new ImageIcon("src/image/Keyboard.png").getImage();
    private Image skill22= new ImageIcon("src/image/모니터 real.png").getImage();
    private Image skill33 = new ImageIcon("src/image/전북대 real.png").getImage();
    private Image skill44 = new ImageIcon("src/image/Mouse2.png").getImage();
    private Image skill55 = new ImageIcon("src/image/팩맨.png").getImage();
    private Image skill66 = new ImageIcon("src/image/드론 realreal.png").getImage();
    private Image skill77 = new ImageIcon("src/image/전기1.png").getImage();
    
    private Image tp = new ImageIcon("src/image/tpicon.png").getImage();
    private Image stp = new ImageIcon("src/image/tp.gif").getImage();
    private Image boom = new ImageIcon("src/image/boom.gif").getImage();
    
    static int playerX , playerY ;  //플레이어 좌표
    private int playerWidth = 20;  //플레이어 크기(좌우)
    private int playerHeight = 20; //플레이어 크기(상하)
    static int playerSpeed = 5;  //플레이어 속도
    static int playerMaxHp = 30;  //플레이어 최대체력 
    static int playerHp = 30;   //플레이어 현재 체력
    static double playerDmg = 1.0; //플레이어 데미지
    static double playerAspeed = 1.0; //플레이어 공속
    private int playerMaxExp = 10; //플레이어 경치통
    private int playerExp = 0; //플레이어 현재경치
    static int playerGold = 500; //돈
    static int uiHp = (playerHp*250/playerMaxHp);
    static int firstWeaponLev = 1;
    static int secondWeaponLev = 1;
    static int thirdWeaponLev = 0;
    static int fourthWeaponLev = 0;
    static int fifthWeaponLev = 0;
    static int sixthWeaponLev = 0;
    static int seventhWeaponLev = 1;
    private int ex,ey,dex,dey;
    private int usetp = 0;
    private int tpp = 0;
    private int tptime1 = 320, tptime2 = 640;
    private int boom1 = 0;
    
    private boolean clear=false;
    static boolean up, down, left, right,attack;
    protected int pos; 
    static boolean Over;
    static boolean barrier;
    static boolean dron1;
    static boolean dron2;
    static boolean dron3;
    private LevelUP levelup = new LevelUP();
    
    ArrayList<PlayerAttack> playerAttackList = new ArrayList<PlayerAttack>();
    private PlayerAttack playerAttack;

    static protected ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
    private ArrayList<Gold> goldList = new ArrayList<Gold>();
    private ArrayList<Exp> expList = new ArrayList<Exp>();
    private ArrayList<Magnet> magnetList = new ArrayList<Magnet>();
    private ArrayList<Bomb> bombList = new ArrayList<Bomb>();
    
    protected Enemy enemy;  
    private Gold gold;
    private Exp exp;
    private Magnet magnet;
    private Bomb bomb;
    
    private Audio bgm;
    static Audio hitSound;
    static Audio attack4sound;
    static Audio boomsound;
    static Audio itemboomsound;
    static Audio expsound;
    static Audio attack5sound;
    static Audio coinsound;
    static Audio diesound;
    static Audio levelupsound;
    static Audio victorysound;
    static Audio clicksound;
    static Audio bossound;
    static Audio basikweaponsound;
    static Audio attack3sound;
    static Audio tpsound;

    //계속 실행됨
    public void run() {
        bgm = new Audio("src/audio/Bgm.wav", true);
        hitSound =new Audio("src/audio/enemyattack.wav", false);
        attack4sound =new Audio("src/audio/mouseattack.wav", false);
        boomsound =new Audio("src/audio/boomsound.wav", false);
        coinsound = new Audio("src/audio/coinsound.wav", false);
        attack5sound = new Audio("src/audio/attack5.wav", false);
        expsound = new Audio("src/audio/expsound.wav", false);
        diesound = new Audio("src/audio/die.wav", false);
        levelupsound = new Audio("src/audio/levelupsound.wav", false);
        victorysound = new Audio("src/audio/victroy.wav", false);
        clicksound = new Audio("src/audio/clicksound.wav", false);
        bossound = new Audio("src/audio/bosssound.wav", false);
        itemboomsound =new Audio("src/audio/itemboomsound.wav", false);
        basikweaponsound =new Audio("src/audio/basikweaponsound.wav", false);
        attack3sound =new Audio("src/audio/attack3sound.wav", false);
        tpsound = new Audio("src/audio/tps.wav",false);
            
        reset();
        while (true) {
            while (!Over) {
                pretime = System.currentTimeMillis();
                if (System.currentTimeMillis() - pretime < delay) {
                    try {//여기에 실행될 프로세스들 추가

                        Thread.sleep(delay - System.currentTimeMillis() + pretime);
                        keyProcess();
                        enemyAppearProcess();
                        enemyProcess();
                        goldEatProcess();
                        expEatProcess();
                        magnetEatProcess();
                        bombEatProcess();
                        playerAttackProcess(pos);
                        cnt++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //리셋
    public void reset() {
        Over = false;
        clear = false;
        cnt = 0;
        playerX = (Main.SCREEN_WIDTH - playerWidth) / 2;
        playerY = (Main.SCREEN_HEIGHT - playerHeight) / 2;
        playerSpeed = 5;  
        playerMaxHp = 500;  
        playerHp = 500;   
        playerDmg = 1.0;
        playerAspeed = 1.0; 
        playerMaxExp = 10; 
        playerExp = 0;
        playerGold = 0; 
        firstWeaponLev = 1;
        secondWeaponLev = 1;
        thirdWeaponLev = 1;
        fourthWeaponLev = 0;
        fifthWeaponLev = 0;
        sixthWeaponLev = 1;
        seventhWeaponLev = 1;        
        enemyList.clear();
        expList.clear();
        goldList.clear();
        playerAttackList.clear();
        magnetList.clear();
        bombList.clear();
        bgm.start();
        bgm.volume();
        barrier = false;
        dron1 = false;
        dron2 = false;
        Store.storeReset();
        LevelUP.reset();
    }
    //키압력
    private void keyProcess() {
        if (up && playerY - playerSpeed > 0) playerY -= playerSpeed;
        if (down && playerY + playerHeight + playerSpeed < Main.SCREEN_HEIGHT) playerY += playerSpeed;
        if (left && playerX - playerSpeed > 0) playerX -= playerSpeed;
        if (right && playerX + playerWidth + playerSpeed < Main.SCREEN_WIDTH) playerX += playerSpeed;
   
    }
    
    public void tp() {
    	if(usetp>0) {
    		tpsound.start();
        	tpp=1;
        	usetp-=1;
        	if(usetp==1) {
        		tptime1=cnt+320;
        	}
        	else if(usetp==0) {
        		tptime2=tptime1+320;
        	}
            if (up && playerY - 100 > 0) playerY -= 100;
            if (down && playerY + playerHeight + 100 < Main.SCREEN_HEIGHT) playerY += 100;
            if (left && playerX - 100 > 0) playerX -= 100;
            if (right && playerX + playerWidth + 100 < Main.SCREEN_WIDTH) playerX += 100;
            Timer t = new java.util.Timer();
            t.schedule( 
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            tpp=0;
                            t.cancel();
                        }
                    }, 
                    100 
            );
    	}

    }
    
    private void playerAttackProcess(int pos) {
    	  ////////////////////////          직선형             ////////////////////////  	
    	    	if (cnt % (30/firstWeaponLev) == 0) { // 
    				playerAttack = new PlayerAttack(1, pos, playerX, playerY - 10); // 직선형 시작
    				playerAttackList.add(playerAttack);
    				basikweaponsound.start();
    			}
    	    	
    		    if (cnt % (30/firstWeaponLev) == 0&&firstWeaponLev>=3) { // 직선형 업그레이드시작
    				playerAttack = new PlayerAttack(11, pos, playerX, playerY - 10); 
    				playerAttackList.add(playerAttack);
    				
    			}
    	    	
    	    	
    		   	if (cnt % (30/firstWeaponLev) == 0&&firstWeaponLev>=5) { // 직선형 업그레이드 시작
    				playerAttack = new PlayerAttack(12, pos, playerX, playerY - 10); 
    				playerAttackList.add(playerAttack);
    			}
////////////////////////////////////    	          폭발형            //////////////////////////////////////////
    	    	
    			if (cnt % (180/secondWeaponLev) == 0&&secondWeaponLev>1) { 
    				playerAttack = new PlayerAttack(2, pos, playerX, playerY - 10); // weapon2 폭발형 start
    				playerAttackList.add(playerAttack);
    				}
    			if (cnt % (180/secondWeaponLev) == 0&&secondWeaponLev==8 && fifthWeaponLev >=1) { 
    				playerAttack = new PlayerAttack(51, pos, playerX, playerY - 10); // weapon2  업그레이드 만렙 폭발형 start
    				playerAttackList.add(playerAttack);
    				attack5sound.start();
    				}
    			if (cnt % (180/secondWeaponLev) == 0&&secondWeaponLev==8 && fifthWeaponLev >=3) { 
    				playerAttack = new PlayerAttack(51, pos, playerX, playerY - 10); // weapon2 업그레이드 만렙 폭발형 start
    				playerAttackList.add(playerAttack);
    				attack5sound.start();
    				}
    			if (cnt % (180/secondWeaponLev) == 0&&secondWeaponLev==8 && fifthWeaponLev >=5) { 
    				playerAttack = new PlayerAttack(51, pos, playerX, playerY - 10); // weapon2 업그레이드 만렙 폭발형 start
    				playerAttackList.add(playerAttack);
    				attack5sound.start();
    				}
    	   ///////////////////              베리어형               ////////////////////////////// 	
    			
    			if (thirdWeaponLev >1 &&barrier==false) { 
    				playerAttack = new PlayerAttack(3, pos, playerX, playerY - 10); // weapon3 베리어 start
    				playerAttackList.add(playerAttack);
    				attack3sound.start();
    				barrier = true;
    			}
    			
    	   ///////////////////          곡선공격형               /////////////////////////////////
    		   
    			if (cnt % 80 ==0&&fourthWeaponLev>=1) {
    				playerAttack = new PlayerAttack(4, pos, playerX, playerY - 10);  // weapon4  왼쪽공격start
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(41, pos, playerX, playerY - 10); // weapon4 오른쪽 곡선공격 start
    				playerAttackList.add(playerAttack);
    				attack4sound.start();
    			}

    	    
    		    
    			if (cnt % 60 ==0 &&fourthWeaponLev>=3) {
    				playerAttack = new PlayerAttack(4, pos, playerX, playerY - 10); // weapon4  왼쪽공격start
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(41, pos, playerX, playerY - 10);// weapon4 오른쪽 곡선공격 start
    				playerAttackList.add(playerAttack);
    				attack4sound.start();
    			}
    			    
    		   
    			if (cnt % 50 ==0&&fourthWeaponLev>=5) {
    				playerAttack = new PlayerAttack(4, pos, playerX, playerY - 10); // weapon4  왼쪽공격start
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(41, pos, playerX, playerY - 10);// weapon4 오른쪽 곡선공격 start
    				playerAttackList.add(playerAttack);
    				attack4sound.start();
    			}
    			
    			    
    				
    			    
    		
    				
    					
    			   
//////////////////////    	       자동공격형        ///////////////////////////	    
    		    
    			if (cnt % 60 ==0 && fifthWeaponLev >=1 && fifthWeaponLev <3 &&secondWeaponLev!=8) {
    				playerAttack = new PlayerAttack(5, pos, playerX, playerY - 10); // 5자동공격 start
    			    playerAttackList.add(playerAttack);
    			    attack5sound.start();
    			}
    			
    			if (cnt % 30 ==0 && fifthWeaponLev >=3 && secondWeaponLev!=8) {
    				playerAttack = new PlayerAttack(5, pos, playerX, playerY - 10); // 5자동공격 2단계 start
    			    playerAttackList.add(playerAttack);
    			    attack5sound.start();
    			}
    			if (cnt % 30 ==0 && fifthWeaponLev >=5 && secondWeaponLev!=8 ) {
    				playerAttack = new PlayerAttack(5, pos, playerX, playerY - 10); // 5자동공격 3단계 start
    			    playerAttackList.add(playerAttack);
    			    attack5sound.start();
    			}
    		
//////////////////    	          펫형         ///////////////////////////////
    			if (sixthWeaponLev>1 && dron1 ==false){
    				playerAttack = new PlayerAttack(61, pos, playerX, playerY - 10); // 6펫 소환 start
    				playerAttackList.add(playerAttack);
    				attack4sound.start();
    				dron1 = true;
    			}
    			
    			if (sixthWeaponLev>3&& dron2 == false){
    				playerAttack = new PlayerAttack(62, pos, playerX, playerY - 10); // 6번 펫 소환 2단계 start
    				playerAttackList.add(playerAttack);
    				attack4sound.start();
    				dron2 = true;
    			}
    			
    			
    			if (sixthWeaponLev>7&& dron3 == false){
    				playerAttack = new PlayerAttack(63, pos, playerX, playerY - 10); // 6번 만렙형 펫 소환 3단계 start
    				playerAttackList.add(playerAttack);
    				attack4sound.start();
    				dron3 = true;
    			}
    			
    			
    			
    			
    		    
    			if(cnt %20==0&&sixthWeaponLev>1) {
    				playerAttack = new PlayerAttack(611, pos, playerX+70, playerY - 40); // 6펫자동공격 start
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(612, pos, playerX+70, playerY - 40); // 6펫자동공격 start
    				playerAttackList.add(playerAttack);
    			}
    		 
    			if(cnt %20==0&&sixthWeaponLev>3) {  //
    				playerAttack = new PlayerAttack(621, pos, playerX-70, playerY - 40); //6번 펫자동공격 2단계
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(622, pos, playerX-70, playerY - 40); //6번 펫자동공격 2단계
    				playerAttackList.add(playerAttack);
    			}
    			if(cnt %20==0&&sixthWeaponLev>7) {  //
    				playerAttack = new PlayerAttack(631, pos, playerX+10, playerY - 90); //6번 펫자동공격 3단계
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(632, pos, playerX+20, playerY - 90); //6번 펫자동공격 3단계
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(633, pos, playerX-10, playerY - 90); //6번 펫자동공격 3단계
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(634, pos, playerX-20, playerY - 90); //6번 펫자동공격 3단계
    				playerAttackList.add(playerAttack);
    			}
    			
//////////////////    	      전체공격           /////////////////////////	
    			if(cnt % 100 == 0&&seventhWeaponLev>=1 &&seventhWeaponLev<7) { //7번 전체공격 1단계
    				playerAttack = new PlayerAttack(7, pos, playerX, playerY ); 
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(71, pos, playerX, playerY); 
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(72, pos, playerX, playerY ); 
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(73, pos, playerX, playerY ); 
    				playerAttackList.add(playerAttack);
    				basikweaponsound.start();
    			}
    			if(cnt % 100 == 0 &&seventhWeaponLev>=2&&seventhWeaponLev<7)//7번 전체공격 2단계
    			{
    				playerAttack = new PlayerAttack(75, pos, playerX, playerY ); 
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(74, pos, playerX, playerY); 
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(76, pos, playerX, playerY ); 
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(77, pos, playerX, playerY ); 
    				playerAttackList.add(playerAttack);
    			}
    			if(cnt % 100 == 0 &&seventhWeaponLev>=4&&seventhWeaponLev<7)//7번 전체공격 3단계
    			{
    				playerAttack = new PlayerAttack(711, pos, playerX, playerY ); 
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(712, pos, playerX, playerY ); 
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(713, pos, playerX, playerY ); 
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(714, pos, playerX, playerY ); 
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(715, pos, playerX, playerY ); 
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(716, pos, playerX, playerY ); 
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(717, pos, playerX, playerY ); 
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(718, pos, playerX, playerY ); 
    				playerAttackList.add(playerAttack);
    				
    			}
    			if(cnt % 100 == 0 &&seventhWeaponLev>=7)//7번 전체공격 3단계
    			{
    				playerAttack = new PlayerAttack(7, pos, playerX, playerY ); 
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(71, pos, playerX, playerY); 
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(72, pos, playerX, playerY ); 
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(73, pos, playerX, playerY ); 
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(75, pos, playerX, playerY ); 
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(74, pos, playerX, playerY); 
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(76, pos, playerX, playerY ); 
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(77, pos, playerX, playerY ); 
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(711, pos, playerX, playerY ); 
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(712, pos, playerX, playerY ); 
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(713, pos, playerX, playerY ); 
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(714, pos, playerX, playerY ); 
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(715, pos, playerX, playerY ); 
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(716, pos, playerX, playerY ); 
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(717, pos, playerX, playerY ); 
    				playerAttackList.add(playerAttack);
    				playerAttack = new PlayerAttack(718, pos, playerX, playerY ); 
    				playerAttackList.add(playerAttack);
    				basikweaponsound.start();
    			}

    	    	for(int i =0; i<playerAttackList.size();i++) { //모든 공격객체에 대하여 조사
    	    		playerAttack = playerAttackList.get(i);
    	    	
    	    		playerAttack.fire(); // 공격 개체 이동
    	    		
    	    		for(int j =0; j < enemyList.size(); j++) {
    	    			enemy = enemyList.get(j);
    	    			if((Math.abs(playerAttack.x-enemy.x)<playerAttack.width)&&(Math.abs(playerAttack.y-enemy.y)<playerAttack.height)) {
    	    				enemy.hp -= playerAttack.attack;
    	    				if(playerAttack.weapon==1||playerAttack.weapon==11||playerAttack.weapon==13) {
    	    					playerAttackList.remove(playerAttack);
    	    				}
    	    				
    	    			}
    	    		}
    	    		
    				if(playerAttack.x<0||playerAttack.x>1300||playerAttack.y<0||playerAttack.y>750)
    					playerAttackList.remove(playerAttack); //필드를 벗어날시 공격사라짐
    				if (playerAttack.wcnt > 80&&playerAttack.weapon==2) {
    					playerAttackList.remove(playerAttack); // 2번폭발지속딜 종료
    				}
    				if (playerAttack.wcnt > 50&&playerAttack.weapon==51) {
    					playerAttackList.remove(playerAttack); // 5번 폭발지속딜 종료
    				}
    				if (playerAttack.wcnt > 40&&playerAttack.weapon==5) {
    					playerAttackList.remove(playerAttack); // 5번자동공격 종료
    				}
    				if (playerAttack.wcnt > 200&&playerAttack.weapon!=3) {
    					playerAttackList.remove(playerAttack); //전체무기 일정시간 지나면 사라짐
    				}
    	    	}
    	    	

    	    }


    //몹생성
    private void enemyAppearProcess() {
        if (cnt % 32 == 0) {
        	do {
            	 ex=(int)(Math.random()*1120);
            	 ey=(int)(Math.random()*621);
            	 dex=Math.abs(ex-playerX);
            	 dey=Math.abs(ey-playerY);
        	}while((dex+dey)<100);
            enemy = new Enemy(1,ex,ey); 
            enemyList.add(enemy);  
        }
        if(min<4) {
        	if (cnt % 160 == 0) {
            	do {
                	ex=(int)(Math.random()*1120);
                	ey=(int)(Math.random()*621);
                	dex=Math.abs(ex-playerX);
                	dey=Math.abs(ey-playerY);
            	}while((dex+dey)<100);
            	enemy = new Enemy(2,ex, ey);            	
            	enemyList.add(enemy);
            }
        	if (cnt % 32 == 0) {      
            	do {
                	 ex=(int)(Math.random()*1120);
                	 ey=(int)(Math.random()*621);
                	 dex=Math.abs(ex-playerX);
                	 dey=Math.abs(ey-playerY);
            	}while((dex+dey)<100);
            	enemy = new Enemy(1,ex, ey);            	
            	enemyList.add(enemy);
            }
        }
        if(min<3) {
        	if (cnt % 32 == 0) {
            	do {
                	 ex=(int)(Math.random()*1120);
                	 ey=(int)(Math.random()*621);
                	 dex=Math.abs(ex-playerX);
                	 dey=Math.abs(ey-playerY);
            	}while((dex+dey)<100);
            	enemy = new Enemy(3,ex, ey);            	
            	enemyList.add(enemy);
            }
        }
        if(min<2) {
        	if (cnt % 32 == 0) {
            	do {
                	 ex=(int)(Math.random()*1120);
                	 ey=(int)(Math.random()*621);
                	 dex=Math.abs(ex-playerX);
                	 dey=Math.abs(ey-playerY);
            	}while((dex+dey)<100);
            	enemy = new Enemy(1,ex, ey);            	
            	enemyList.add(enemy);
            }
        	if (cnt % 32 == 0) {
            	do {
                	 ex=(int)(Math.random()*1120);
                	 ey=(int)(Math.random()*621);
                	 dex=Math.abs(ex-playerX);
                	 dey=Math.abs(ey-playerY);
            	}while((dex+dey)<100);
            	enemy = new Enemy(3,ex, ey);            	
            	enemyList.add(enemy);
            }
        	if (cnt % 128 == 0) {
            	do {
                	 ex=(int)(Math.random()*1120);
                	 ey=(int)(Math.random()*621);
                	 dex=Math.abs(ex-playerX);
                	 dey=Math.abs(ey-playerY);
            	}while((dex+dey)<100);
            	enemy = new Enemy(4,ex, ey);            	
            	enemyList.add(enemy);
            }
        }
        if(min<1) {
        	if (cnt % 32 == 0) {
            	do {
                	 ex=(int)(Math.random()*1120);
                	 ey=(int)(Math.random()*621);
                	 dex=Math.abs(ex-playerX);
                	 dey=Math.abs(ey-playerY);
            	}while((dex+dey)<100);
            	enemy = new Enemy(1,ex, ey);            	
            	enemyList.add(enemy);
            }
        	if (cnt % 128 == 0) {
            	do {
                	 ex=(int)(Math.random()*1120);
                	 ey=(int)(Math.random()*621);
                	 dex=Math.abs(ex-playerX);
                	 dey=Math.abs(ey-playerY);
            	}while((dex+dey)<100);
            	enemy = new Enemy(4,ex, ey);            	
            	enemyList.add(enemy);
            }
        	if (cnt % 160 == 0) {
            	do {
                	 ex=(int)(Math.random()*1120);
                	 ey=(int)(Math.random()*621);
                	 dex=Math.abs(ex-playerX);
                	 dey=Math.abs(ey-playerY);
            	}while((dex+dey)<100);
            	enemy = new Enemy(2,ex, ey);            	
            	enemyList.add(enemy);
            }
        }
        
       if(time==0) {
       	if(cnt%60==0) {
           bombList.clear();
        	enemy = new Enemy(10,0,0);
        	bossound.start();
       	enemyList.add(enemy);
        	}
        }
    }

    //몹 프로세서
    private void enemyProcess() {
        for (int i = 0; i< enemyList.size(); i++) {
            enemy = enemyList.get(i);
            enemy.DX = Math.abs(playerX-enemy.x);
    		enemy.DY = Math.abs(playerY-enemy.y);
            if(enemy.x>(playerX)) {
 
            	enemy.x-=enemy.Espeed;
            }
            else {
  
            	enemy.x+=enemy.Espeed;
            }
            if(enemy.y>(playerY)) {

            	enemy.y-=enemy.Espeed;
            }
            else {
     
            	enemy.y+=enemy.Espeed;
            }
            //테스트


            if ((enemy.DX<enemy.width)&&(enemy.DY<enemy.height)) {
                playerHp -= enemy.Edamage;
                
                if (playerHp <= 0) Over = true;
            }
            
            //22
            if(enemy.hp < 0) {
                enemyList.remove(enemy);
                if(enemy.boss==1) {
                	victorysound.start();
                	Over=true;
                	clear=true;
                }
                int rc = ((int)(Math.random()*100));
                if(time>0) {
                    if (rc >= 0&&rc <= 33) {
                    	exp = new Exp (enemy.x, enemy.y);
                    	expList.add(exp);
                    }
                    else if(rc > 33&& rc <= 66) {
                    	gold = new Gold (enemy.x, enemy.y);
                    	goldList.add(gold);
                    }
                    else if(rc >70 && rc <= 73) {
                    	magnet = new Magnet(enemy.x,enemy.y);
                    	magnetList.add(magnet);
                    }
                    else if(rc == 88) {
                    	bomb = new Bomb(enemy.x,enemy.y);
                    	bombList.add(bomb);
                    }
                }
                else {
                    if (rc >= 0&&rc <= 33) {
                    	exp = new Exp (enemy.x, enemy.y);
                    	expList.add(exp);
                    }
                    else if(rc > 33&& rc <= 66) {
                    	gold = new Gold (enemy.x, enemy.y);
                    	goldList.add(gold);
                    }
                    else if(rc >70 && rc <= 73) {
                    	magnet = new Magnet(enemy.x,enemy.y);
                    	magnetList.add(magnet);
                    }
                }

                if(playerExp>=playerMaxExp) {
            		playerLevelUp();
            	}
            }
            //33
            if(enemy.boss==1) {
            	
            }
        }
    }
    
    
    //몹 공격
    private void enemyAttackProcess() {
    	for (int i = 0; i< enemyList.size(); i++) {
            enemy = enemyList.get(i);
            enemy.DX = Math.abs(playerX-enemy.x);
 		    enemy.DY = Math.abs(playerY-enemy.y);

        if ((enemy.DX<enemy.width)&&(enemy.DY<enemy.height)) {
             playerHp -= enemy.Edamage;
              hitSound.start();
             if (playerHp <= 0) {
            	 Over = true;
            	 diesound.start();
             }
         }
 	}

 }
    
    //몹 죽기
//    public void enemyDie() {
//    	for (int i = 0; i< enemyList.size(); i++) {
//            enemy = enemyList.get(i);
//            if(enemy.hp < 0) {
//                enemyList.remove(enemy);
//                if(enemy.boss==1) {
//                	Over=true;
//                	clear=true;
//                }
//                int rc = ((int)(Math.random()*3));
//                if (rc == 1) {
//                	exp = new Exp (enemy.x, enemy.y);
//                	expList.add(exp);
//                }
//                else if(rc == 2) {
//                	gold = new Gold (enemy.x, enemy.y);
//                	goldList.add(gold);
//                }
//                if(playerExp>=playerMaxExp) {
//            		playerLevelUp();
//            	}
//            }
//    	}
//    }
    
    //코인 주워먹기 프로세스
    public void goldEatProcess() {
    	for (int i = 0; i< goldList.size(); i++) {
            gold = goldList.get(i);
            gold.DX = Math.abs(playerX-gold.x); 
    		gold.DY = Math.abs(playerY-gold.y);
    		if((gold.DX<30)&&(gold.DY<30)) {
                if(gold.x>(playerX)) {
                	gold.x-=7;
                	coinsound.start();
                }
                else {
                	gold.x+=7;
                	coinsound.start();
                }
                if(gold.y>(playerY)) {
                	gold.y-=7;
                	coinsound.start();
                }
                else {
                	gold.y+=7;
                	coinsound.start();
                }
    		}
            if ((gold.DX<10)&&(gold.DY<10)) {
            	goldList.remove(gold);
            	playerGold++;
            }
    	}
    }
    //경험치 주워먹기 프로세스
    public void expEatProcess() {
    	for (int i = 0; i< expList.size(); i++) {
            exp = expList.get(i);
            exp.DX = Math.abs(playerX-exp.x); 
    		exp.DY = Math.abs(playerY-exp.y); 
    		if((exp.DX<30)&&(exp.DY<30)) {
                if(exp.x>(playerX)) {
                	exp.x-=7;
                	expsound.start();
                }
                else {
                	exp.x+=7;
                	expsound.start();
                }
                if(exp.y>(playerY)) {
                	exp.y-=7;
                	expsound.start();
                }
                else {
                	exp.y+=7;
                	expsound.start();
                }
    		}
            if ((exp.DX<10)&&(exp.DY<10)) {
            	expList.remove(exp);
            	playerExp+=4;
            	if(playerExp>=playerMaxExp) {
            		playerLevelUp();
                    playerAttackList.clear();
                    barrier =false;
                    dron1 = false;
                    dron2 = false;
                    dron3 = false;
                   
            	}
            }
    	}
    }
    
    //자석
    public void magnetEatProcess() {
    	for (int i = 0; i< magnetList.size(); i++) {
            magnet = magnetList.get(i);
            magnet.DX = Math.abs(playerX-magnet.x); 
    		magnet.DY = Math.abs(playerY-magnet.y); 
    		if((magnet.DX<30)&&(magnet.DY<30)) {
                if(magnet.x>(playerX)) {
                	magnet.x-=7;
                }
                else {
                	magnet.x+=7;
                }
                if(magnet.y>(playerY)) {
                	magnet.y-=7;
                }
                else {
                	magnet.y+=7;
                }
    		}
            if ((magnet.DX<10)&&(magnet.DY<10)) {
            	magnetList.remove(magnet);
            	magnetEat();
            	expsound.start();
            	}
            }
    	}
    public void magnetEat() {
    	for (int i = 0; i< expList.size(); i++) {
            exp = expList.get(i);
            exp.DX = Math.abs(playerX-exp.x); 
    		exp.DY = Math.abs(playerY-exp.y); 
    		if((exp.DX<1300)&&(exp.DY<800)) {
//                if(exp.x>(playerX)) {
//                	exp.x-=30;
//                }
//                else {
//                	exp.x+=30;
//                }
//                if(exp.y>(playerY)) {
//                	exp.y-=30;
//                }
//                else {
//                	exp.y+=30;
//    		}
    			exp.x=playerX;
    			exp.y=playerY;
    	}
    	for (int j = 0; j< goldList.size(); j++) {
            gold = goldList.get(j);
            gold.DX = Math.abs(playerX-gold.x); 
    		gold.DY = Math.abs(playerY-gold.y);
    		if((gold.DX<1300)&&(gold.DY<800)) {
//                if(gold.x>(playerX)) {
//                	gold.x-=30;
//                }
//                else {
//                	gold.x+=30;
//                }
//                if(gold.y>(playerY)) {
//                	gold.y-=30;
//                }
//                else {
//                	gold.y+=30;
//                }
    			gold.x=playerX;
    			gold.y=playerY;
    		}
    	}
    }
    }
    //폭탄먹기 프로세스
    public void bombEatProcess() {
    	for (int i = 0; i< bombList.size(); i++) {
            bomb = bombList.get(i);
            bomb.DX = Math.abs(playerX-bomb.x); 
            bomb.DY = Math.abs(playerY-bomb.y); 
    		if((bomb.DX<30)&&(bomb.DY<30)) {
                if(bomb.x>(playerX)) {
                	bomb.x-=7;
                }
                else {
                	bomb.x+=7;
                }
                if(bomb.y>(playerY)) {
                	bomb.y-=7;
                }
                else {
                	bomb.y+=7;
                }
    		}
            if ((bomb.DX<10)&&(bomb.DY<10)) {
            	bombList.remove(bomb);
            	boom1 = 1;
            	itemboomsound.start();
            	enemyList.clear();
                playerAttackList.clear();
                barrier = false;
                dron1 =false;
                dron2 =false;
                dron3 = false;
                Timer t = new java.util.Timer();
                t.schedule( 
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                boom1=0;
                                t.cancel();
                            }
                        }, 
                        200 
                );
            	}
            }
    	}

    
    //레벨업
    public void playerLevelUp() {
    	Over=true;
    	playerExp-=playerMaxExp;
    	playerMaxExp*=1.2;
    	
        levelup.levelon();
        levelupsound.start();
        

    	
    }
    
  //게임 시작시 나타나는 아이들
    public void gameDraw(Graphics g) {
        playerDraw(g);
        enemyDraw(g);
        expDraw(g);
        goldDraw(g);
        bombDraw(g);
        magnetDraw(g);
        infoDraw(g);
        uiDraw(g);
        playerAttackDraw(g);
        AttackInfoDraw(g);
        tpDraw(g);
    }
    
    
    //게임 실행중에 보이는 정보들이나 종료시 나타나는 것들
    public void infoDraw(Graphics g) {
    	//time=(28800-cnt)/32;
    	//time=(500-cnt)/32;
    	time=(9600-cnt)/32;
    	min=time/60;
    	sec=time%60;
    	

    	
    	if(time>0) {
    		g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString(min+":"+sec, 1200, 665);
    	}

    	else {
    		g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Boss!", 1200, 665);
            
    	}
    	if(min==0&&sec==10) {
        	if(cnt%60==0) {
        		setbxby();
        	}	
        }
    	//if(cnt>18900&&cnt<19200) {
//    	if(cnt>300&&cnt<320) {
//        	bossound.start();
//    	}
//    	if(cnt>320&&cnt<500) {
//			g.drawImage(bosse, bx[0], by[0], null);//if(cnt>18900&&cnt<19200) {
//    	if(cnt>300&&cnt<320) {
//        	bossound.start();
//    	}
//    	if(cnt>320&&cnt<500) {
//			g.drawImage(bosse, bx[0], by[0], null)
//    	}
//    	if(cnt>19000&&cnt<19200) {
//    		bossound.start();
//			g.drawImage(bosse, bx[1], by[1], null);
//    	}
//    	if(cnt>19040&&cnt<19200) {
//    		bossound.start();
//			g.drawImage(bosse, bx[10], by[10], null);
//    	}
//    	if(cnt>19070&&cnt<19200) {
//    		bossound.start();
//			g.drawImage(bosse, bx[2], by[2], null);
//    	}
//    	if(cnt>19090&&cnt<19200) {
//    		bossound.start();
//			g.drawImage(bosse, bx[3], by[3], null);
//    	}
//    	if(cnt>19110&&cnt<19200) {
//    		bossound.start();
//			g.drawImage(bosse, bx[4], by[4], null);
//    	}
//    	if(cnt>19120&&cnt<19200) {
//    		bossound.start();
//			g.drawImage(bosse, bx[5], by[6], null);
//    	}
//    	if(cnt>19130&&cnt<19200) {
//    		bossound.start();
//			g.drawImage(bosse2, 490, 260, null);
//    	}
    	        
    	
    	
        if (playerHp<=0) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 80));
            g.drawString("Press R to restart", 295, 380);
        }
        if (clear==true) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 80));
            g.drawString("You Win", 505, 380);
        }
        
        
        g.drawImage(speed, 10, 200, 25,25,null);
        g.drawImage(damage, 10, 225, 25,25,null);
        g.drawImage(maxHp, 10, 250, 25,25,null);

		String Dmg = String.format("%.1f",playerDmg);
        g.setFont(new Font("Arial", Font.BOLD,20));
        g.setColor(Color.BLACK);
        g.drawString(" "+playerSpeed, 45, 223);
        g.drawString(" "+Dmg, 45, 248);
        g.drawString(" "+playerMaxHp, 45, 273);
        
    }
    public void setbxby() {
      for(int i=0; i<20; i++) {
      	bx[i]=(int)(Math.random()*980);
      	by[i]=(int)(Math.random()*520);
      }
    }

    //캐릭터 그리기
    public void playerDraw(Graphics g) { 
        g.drawImage(player, (int)playerX, (int)playerY,20,20, null);

        
        //좌표로 크기 20 20으로 생성
        //상태체력바 표시(나중에 수정해서 옮길예정)
        //g.setColor(Color.GREEN);
        //g.fillRect((int)playerX - 1, (int)playerY - 40, playerHp * 6, 20);
        //밑부부들은 그냥 디버깅용 좌표 표시
//        g.setColor(Color.BLACK);
//        g.setFont(new Font("Arial", Font.BOLD, 20));
//        g.drawString("X:"+playerX+" Y:"+playerY + "HP: "+ playerHp+bx[1]+by[1], (int)playerX, (int)playerY);
    }
    
    //공격 그리기
    public void playerAttackDraw(Graphics g) {
    	 for(int i =0; i<playerAttackList.size();i++) {
     		playerAttack = playerAttackList.get(i);
     		g.drawImage(playerAttack.image,playerAttack.x,playerAttack.y-10,playerAttack.width,playerAttack.height, null);
         }
    }
    
    public void uiDraw(Graphics g) {
    	int tpt;
        g.drawImage(info, 10,10, 280, 130,null);
        g.drawImage(coin, 15, 80, 50,50,null);

        g.setColor(Color.RED); 
        g.drawRect(20,20,250,20);
        g.fillRect(20,20,(playerHp*250/playerMaxHp),20);
        g.setColor(Color.GREEN);
        g.drawRect(20,50,250,20);
        g.fillRect(20,50,(playerExp*250/playerMaxExp),20);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.drawString(" "+playerGold, 70,120);
        g.drawImage(tp,10, 638, 40, 40, null);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        g.drawString(" "+usetp, 39,670);
        
        if(tptime1==cnt) {
        	usetp++;
        	tptime1=tptime2;
        	tptime2=0;
        }
        tpt=(tptime1-cnt)/32;
        if(usetp<2) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString(" "+tpt, 8,670);
        }
        
    }
    public void AttackInfoDraw(Graphics g) {
    	g.drawImage(AttackInfo, 1190, 190, 80, 360, null);
    	g.drawImage(skill11, 1200, 200, 50, 50, null);
    	g.drawImage(skill22, 1200, 250, 40, 40, null);
    	g.drawImage(skill33, 1200, 300, 40, 40, null);
    	g.drawImage(skill44, 1200, 350, 50, 50, null);
    	g.drawImage(skill55, 1200, 400, 50, 50, null);
    	g.drawImage(skill66, 1200, 450, 50, 50, null);
    	g.drawImage(skill77, 1200, 500, 50, 50, null);
    	
    	
    	g.setColor(Color.BLACK);
    	g.setFont(new Font("Arial", Font.BOLD, 12));
    	g.drawString("Lv. "+firstWeaponLev, 1235, 200);
    	g.drawString("Lv. "+(secondWeaponLev-1), 1235, 255);
    	g.drawString("Lv. "+(thirdWeaponLev-1), 1235, 305);
    	g.drawString("Lv. "+fourthWeaponLev, 1235, 355);
    	g.drawString("Lv. "+fifthWeaponLev, 1235, 407);
    	g.drawString("Lv. "+(sixthWeaponLev-1), 1235, 457);
    	g.drawString("Lv. "+seventhWeaponLev, 1235, 507);
    	
    }	
    
    
    //적 그리기
    public void enemyDraw(Graphics g) {
        for (int i = 0; i< enemyList.size(); i++) {
            enemy = enemyList.get(i);
            g.drawImage(enemy.image, (int)enemy.x, (int)enemy.y, enemy.width,enemy.height,null);
            //g.setColor(Color.BLACK);
            //g.setFont(new Font("Arial", Font.BOLD, 20));
            //g.drawString("X:"+enemy.DX+" Y:"+enemy.DY, (int)enemy.x, (int)enemy.y);
            if(enemy.boss==1) {
            	 g.setColor(Color.RED); 
                 g.drawRect(300,20,800,20);
                 g.fillRect(300,20,((int)enemy.hp*800/2000),20);
            }

        }
    }
    
    //코인 그리기
    public void goldDraw(Graphics g) {
        for (int i = 0; i< goldList.size(); i++) {
            gold = goldList.get(i);
            g.drawImage(gold.gold, (int)gold.x, (int)gold.y, 15,15,null);
        }
    }
    
    //경험치 그리기
    public void  expDraw(Graphics g) {
        for (int i = 0; i< expList.size(); i++) {
            exp = expList.get(i);
            g.drawImage(exp.exp, (int)exp.x, (int)exp.y, 15,15,null);
        }
    }
    //텔포 이펙트
    public void tpDraw(Graphics g) {
    	if(tpp==1) {
        	g.drawImage(stp, playerX-20, playerY-20, 60, 60, null);
    	}
    }
    //폭탄 그리기
    public void bombDraw(Graphics g) {
        for (int i = 0; i< bombList.size(); i++) {
            bomb = bombList.get(i);
            g.drawImage(bomb.bomb, (int)bomb.x, (int)bomb.y, 20,20,null);
        }
        if(boom1==1) {
        	g.drawImage(boom, 300, 0, 700, 700, null);
        }
    }
    //자석 그리기
    public void magnetDraw(Graphics g) {
        for (int i = 0; i< magnetList.size(); i++) {
        	magnet = magnetList.get(i);
            g.drawImage(magnet.magnet, (int)magnet.x, (int)magnet.y, 20,20,null);
        }
    }

    public boolean isOver() {
        return Over;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }
    public void setPos(int pos) {
    	this.pos = pos;
    
    }
  
    
   

    
    
    
}