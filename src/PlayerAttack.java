import javax.swing.*;
import java.lang.Math;
import java.awt.*;
import java.util.Random;

public class PlayerAttack extends Game {

	Image image;
	int x, y;
	int width; // 무기 데미지판정 너비
	int height; // 무기 판정높이
	double attack; // 공격력
	int weapon; // 무기 종류 1,11,12=직선공격 2=폭발형 3=베리어 4=곡선형 5= 자동공격형 6= 펫소환
	int way; // 공격방향
	int wcnt; // 무기방향조절
	int weaponSpeed; // 무기속도조절
	int tmpx, tmpy,tmpxy,min=500;

	public PlayerAttack(int a, int pos, int x, int y) { 
		if (a == 1 && (pos == 0 || pos == 1)) {  //1번공격 직선 좌우공격
			this.image = new ImageIcon("src/image/Keyboard.png").getImage();
			this.width = 60;
			this.height = 60;
			this.attack = 3*playerDmg;
			this.x = x;
			this.y = y;
			weapon = a;

			way = pos; // 무기 방향 조정
		}
		if (a == 11 && (pos == 0 || pos == 1)) {//1번공격 직선 좌우공격
			this.image = new ImageIcon("src/image/Keyboard.png").getImage();
			this.width = 60;
			this.height = 60;
			this.attack = 3*playerDmg;
			this.x = x;
			this.y = y;
			weapon = a;

			way = pos; // 무기 방향 조정
		}
		if (a == 12 && (pos == 0 || pos == 1)) {//1번공격 직선 좌우공격
			this.image = new ImageIcon("src/image/Keyboard.png").getImage();
			this.width = 60;
			this.height = 60;
			this.attack = 3*playerDmg;
			this.x = x;
			this.y = y;
			weapon = a;

			way = pos; // 무기 방향 조정
		}
		
		
		
		if (a == 1 && (pos == 2 || pos == 3)) { //1번공격 위아래 직선공격
			this.image = new ImageIcon("src/image/Keyboard2.png").getImage();
			this.width = 60;
			this.height = 60;
			this.attack = 3*playerDmg;
			this.x = x;
			this.y = y;
			weapon = a;
			this.wcnt =0;

			way = pos;// 무기 방향 조정
		}
		if (a == 11 && (pos == 2 || pos == 3)) { //1번공격 위아래 직선공격
			this.image = new ImageIcon("src/image/Keyboard2.png").getImage();
			this.width = 60;
			this.height = 60;
			this.attack = 3*playerDmg;
			this.x = x;
			this.y = y;
			weapon = a;
			this.wcnt =0;

			way = pos;// 무기 방향 조정
		}
		if (a == 12 && (pos == 2 || pos == 3)) { // 1번공격 위아래 직선공격
			this.image = new ImageIcon("src/image/Keyboard2.png").getImage();
			this.width = 60;
			this.height = 60;
			this.attack = 3*playerDmg;
			this.x = x;
			this.y = y;
			weapon = a;
			this.wcnt =0;

			way = pos;// 무기 방향 조정
		}
		
		
		
		if (a == 2 ) {//2번공격  폭발형
			this.image = new ImageIcon("src/image/모니터 real.png").getImage();
			this.width = 60;
			this.height = 60;
			this.attack = 0;
			this.x = (int) (Math.random() * 1280); // x축 랜덤시작
			this.y = 0; // 맵 제일위에서 시작
			this.attack = 0; //떨어지는 데미지 0
			this.weapon = a;
			this.way = pos;// 무기 방향 조정
			this.wcnt = 0;
			do {
				this.weaponSpeed = (int) (Math.random() * 80);
			} while (this.weaponSpeed < 3 || this.weaponSpeed > 40);
		}
		

		if (a == 3) { //3번공격 베리어
			this.image = new ImageIcon("src/image/전북대 real.png").getImage();
			this.width= 60;
			this.height = 60;
			this.attack = 0;
			this.x = x;
			this.y = y;
			this.attack = 5*playerDmg;
			this.weapon = a;
			this.way = pos;// 무기 방향 조정
			this.wcnt = 0;

		}
		if (a == 4) { //4번공격 오른쪽곡선공격
			this.image = new ImageIcon("src/image/Mouse2.png").getImage();
			this.width = 60;
			this.height = 60;
			this.attack = 0;
			this.x = x;
			this.y = y;
			this.attack = 5*playerDmg;
			this.weapon = a;
			this.way = pos; // 무기 방향 조정
			this.wcnt = 0;
			do {
				this.weaponSpeed = (int) (Math.random() * 30);
			} while (this.weaponSpeed < 10 || this.weaponSpeed > 20); // 속도 조절
		}
		if (a == 41) { //4번공격 왼쪽곡선공격
			this.image = new ImageIcon("src/image/Mouse.png").getImage();
			this.width = 60;
			this.height = 60;
			this.attack = 0;
			this.x = x;
			this.y = y;
			this.attack = 5*playerDmg;
			this.weapon = a;
			this.way = pos; // 무기 방향 조정
			this.wcnt = 0;

			do {
				this.weaponSpeed = (int) (Math.random() * 30);
			} while (this.weaponSpeed < 10 || this.weaponSpeed > 20); // 속도 조절
		}
		if (a == 5) { // 5번공격 자동공격
			
			this.image = new ImageIcon("src/image/팩맨 움직임.gif").getImage();
			this.width = 40;
			this.height = 40;
			this.attack = 5*playerDmg;

			this.weapon = a;
			this.way = pos; // 무기 방향 조정
			this.wcnt = 0;

		
			for (int i = 0; i < enemyList.size(); i++) {
				enemy = enemyList.get(i);
				tmpx = Math.abs(playerX - enemy.x);
				tmpy = Math.abs(playerY - enemy.y);
				tmpxy=tmpx+tmpy;
				if(min>tmpxy) {
					this.x=enemy.x;
					this.y=enemy.y;
					break;
				}
			}
		
	}
		if (a == 51) { // 5번 공격 자동공격+폭발공격 
			
			this.image = new ImageIcon("src/image/팩맨 움직임.gif").getImage();
			this.width = 40;
			this.height = 40;
			this.attack = 5*playerDmg;

			this.weapon = a;
			this.way = pos; // 무기 방향 조정
			this.wcnt = 0;

		
			for (int i = 0; i < enemyList.size(); i++) {
				enemy = enemyList.get(i);
				tmpx = Math.abs(playerX - enemy.x);
				tmpy = Math.abs(playerY - enemy.y);
				tmpxy=tmpx+tmpy;
				if(min>tmpxy) {
					this.x=enemy.x;
					this.y=enemy.y;
					break;
				}
			}
		
	}

		if (a == 61) {//  6번공격 1번째드론 펫
			this.image = new ImageIcon("src/image/드론 realreal.png").getImage();
			this.width = 60;
			this.height = 60;
			this.x = x ;
			this.y = y ;
			this.attack = 0.5*playerDmg;
			this.weapon = a;
			this.way = pos;// 무기 방향 조정
			this.wcnt = 0;
		
		}	
		if (a == 611 ) {// 6번공격 1번째드론 펫 우측공격
			this.image = new ImageIcon("src/image/전기 2.png").getImage();
			this.width = 20;
			this.height = 20;
			this.x = x;
			this.y = y ;
			this.attack = 0.5*playerDmg;
			this.weapon = a;
			this.way = pos;// 무기 방향 조정
			this.wcnt = 0;
			do {
				this.weaponSpeed = (int) (Math.random() * 20);
			} while (this.weaponSpeed < 5 || this.weaponSpeed > 10); // 속도 조절
		
		}
		if (a == 612 ) {//6번공격 1번째드론 펫 좌측공격
			this.image = new ImageIcon("src/image/전기 2.png").getImage();
			this.width = 20;
			this.height = 20;
			this.x = x;
			this.y = y ;
			this.attack = 0.5*playerDmg;
			this.weapon = a;
			this.way = pos;// 무기 방향 조정
			this.wcnt = 0;
			do {
				this.weaponSpeed = (int) (Math.random() * 20);
			} while (this.weaponSpeed < 5 || this.weaponSpeed > 10); // 속도 조절
		
		}
		if (a == 62) {//6번공격 2번째드론 펫
			this.image = new ImageIcon("src/image/드론 realreal.png").getImage();
			this.width = 60;
			this.height = 60;
			this.x = x ;
			this.y = y ;
			this.attack = 0.5*playerDmg;
			this.weapon = a;
			this.way = pos;// 무기 방향 조정
			this.wcnt = 0;
		
		}	
		
		if (a == 621 ) {//6번공격 2번째드론 펫 우측공격
			this.image = new ImageIcon("src/image/전기 2.png").getImage();
			this.width = 20;
			this.height = 20;
			this.attack = 0.5*playerDmg;
			this.x = x;
			this.y = y ;
			//this.attack = 5;
			this.weapon = a;
			this.way = pos;// 무기 방향 조정
			this.wcnt = 0;
			do {
				this.weaponSpeed = (int) (Math.random() * 20);
			} while (this.weaponSpeed < 5 || this.weaponSpeed > 10); // 속도 조절
		
		}
		if (a == 622 ) {//6번공격 2번째드론 펫 좌측공격
			this.image = new ImageIcon("src/image/전기 2.png").getImage();
			this.width = 20;
			this.height = 20;
			this.attack = 1*playerDmg;
			this.x = x;
			this.y = y ;
			//this.attack = 5;
			this.weapon = a;
			this.way = pos;// 무기 방향 조정
			this.wcnt = 0;
			do {
				this.weaponSpeed = (int) (Math.random() * 20);
			} while (this.weaponSpeed < 5 || this.weaponSpeed > 10); // 속도 조절
		
		}
		
		if (a == 63) {//6번공격  만렙형 3번째드론 펫
			this.image = new ImageIcon("src/image/드론 realreal.png").getImage();
			this.width = 100;
			this.height = 100;
			this.x = x ;
			this.y = y ;
			this.attack = 0.5*playerDmg;
			this.weapon = a;
			this.way = pos;// 무기 방향 조정
			this.wcnt = 0;
		
		}	
		if (a == 631 ) {//6번공격 만렙형 3번째드론 펫 우측공격1
			this.image = new ImageIcon("src/image/전기 2.png").getImage();
			this.width = 40;
			this.height = 40;
			this.attack = 0.5*playerDmg;
			this.x = x;
			this.y = y ;
			//this.attack = 5;
			this.weapon = a;
			this.way = pos;// 무기 방향 조정
			this.wcnt = 0;
			do {
				this.weaponSpeed = (int) (Math.random() * 20);
			} while (this.weaponSpeed < 5 || this.weaponSpeed > 10); // 속도 조절
		
		}
		if (a == 632 ) {//6번공격 만렙형 3번째드론 펫 우측공격2
			this.image = new ImageIcon("src/image/전기 2.png").getImage();
			this.width = 40;
			this.height = 40;
			this.attack = 0.5*playerDmg;
			this.x = x;
			this.y = y ;
			//this.attack = 5;
			this.weapon = a;
			this.way = pos;// 무기 방향 조정
			this.wcnt = 0;
			do {
				this.weaponSpeed = (int) (Math.random() * 20);
			} while (this.weaponSpeed < 5 || this.weaponSpeed > 10); // 속도 조절
		
		}
		if (a == 633 ) {//6번공격 만렙형 3번째드론 펫 좌측공격1
			this.image = new ImageIcon("src/image/전기 2.png").getImage();
			this.width = 40;
			this.height = 40;
			this.attack = 1*playerDmg;
			this.x = x;
			this.y = y ;
			//this.attack = 5;
			this.weapon = a;
			this.way = pos;// 무기 방향 조정
			this.wcnt = 0;
			do {
				this.weaponSpeed = (int) (Math.random() * 20);
			} while (this.weaponSpeed < 5 || this.weaponSpeed > 10); // 속도 조절
		
		}
		if (a == 634 ) {//6번공격 만렙형 3번째드론 펫 좌측공격2
			this.image = new ImageIcon("src/image/전기 2.png").getImage();
			this.width = 40;
			this.height = 40;
			this.attack = 1*playerDmg;
			this.x = x;
			this.y = y ;
			//this.attack = 5;
			this.weapon = a;
			this.way = pos;// 무기 방향 조정
			this.wcnt = 0;
			do {
				this.weaponSpeed = (int) (Math.random() * 20);
			} while (this.weaponSpeed < 5 || this.weaponSpeed > 10); // 속도 조절
		
		}
		
		if (a == 7) { // 7번공격 전체공격(오른쪽)
					
			this.image = new ImageIcon("src/image/전기1.png").getImage();
			this.width = 40;
			this.height = 40;
			this.attack = 5*playerDmg;
			this.x =x;
			this.y =y;
			this.weapon = a;
			this.way = pos; // 무기 방향 조정
			this.wcnt = 0;
		}
		if (a == 71) { // 7번공격 전체공격(왼쪽)
			
			this.image = new ImageIcon("src/image/전기1.png").getImage();
			this.width = 40;
			this.height = 40;
			this.attack = 5*playerDmg;
			this.x =x;
			this.y =y;
			this.weapon = a;
			this.way = pos; // 무기 방향 조정
			this.wcnt = 0;
		}
		
		if (a == 72) { // 7번공격 전체공격(위)
			
			this.image = new ImageIcon("src/image/전기1.png").getImage();
			this.width = 40;
			this.height = 40;
			this.attack = 5*playerDmg;
			this.x =x;
			this.y =y;
			this.weapon = a;
			this.way = pos; // 무기 방향 조정
			this.wcnt = 0;
		}
		
		if (a == 73) { // 7번공격 전체공격(아래)
			
			this.image = new ImageIcon("src/image/전기1.png").getImage();
			this.width = 40;
			this.height = 40;
			this.attack = 5*playerDmg;
			this.x =x;
			this.y =y;
			this.weapon = a;
			this.way = pos; // 무기 방향 조정
			this.wcnt = 0;
		}
		
		if (a == 74) { // 7번공격 전체공격(북동)
			
			this.image = new ImageIcon("src/image/전기1.png").getImage();
			this.width = 40;
			this.height = 40;
			this.attack = 5*playerDmg;
			this.x =x;
			this.y =y;
			this.weapon = a;
			this.way = pos; // 무기 방향 조정
			this.wcnt = 0;
		}
		
		if (a == 75) { // 7번공격 전체공격(남동)
			
			this.image = new ImageIcon("src/image/전기1.png").getImage();
			this.width = 40;
			this.height = 40;
			this.attack = 5*playerDmg;
			this.x =x;
			this.y =y;
			this.weapon = a;
			this.way = pos; // 무기 방향 조정
			this.wcnt = 0;
		}
		
		if (a == 76) { // 7번공격 전체공격(북서)
			
			this.image = new ImageIcon("src/image/전기1.png").getImage();
			this.width = 40;
			this.height = 40;
			this.attack = 5*playerDmg;
			this.x =x;
			this.y =y;
			this.weapon = a;
			this.way = pos; // 무기 방향 조정
			this.wcnt = 0;
		}
		
		if (a == 77) { // 7번공격 전체공격(남서)
			
			this.image = new ImageIcon("src/image/전기1.png").getImage();
			this.width = 40;
			this.height = 40;
			this.attack = 5*playerDmg;
			this.x =x;
			this.y =y;
			this.weapon = a;
			this.way = pos; // 무기 방향 조정
			this.wcnt = 0;
		}
		if (a == 711) { // 7번공격 
			
			this.image = new ImageIcon("src/image/전기1.png").getImage();
			this.width = 40;
			this.height = 40;
			this.attack = 5*playerDmg;
			this.x =x;
			this.y =y;
			this.weapon = a;
			this.way = pos; // 무기 방향 조정
			this.wcnt = 0;
		}
		if (a == 712) { // 7번공격 
			
			this.image = new ImageIcon("src/image/전기1.png").getImage();
			this.width = 40;
			this.height = 40;
			this.attack = 5*playerDmg;
			this.x =x;
			this.y =y;
			this.weapon = a;
			this.way = pos; // 무기 방향 조정
			this.wcnt = 0;
		}		
		if (a == 713 ) { // 7번공격 
			
			this.image = new ImageIcon("src/image/전기1.png").getImage();
			this.width = 40;
			this.height = 40;
			this.attack = 5*playerDmg;
			this.x =x;
			this.y =y;
			this.weapon = a;
			this.way = pos; // 무기 방향 조정
			this.wcnt = 0;
		}		
		if (a == 714) { // 7번공격 
			
			this.image = new ImageIcon("src/image/전기1.png").getImage();
			this.width = 40;
			this.height = 40;
			this.attack = 5*playerDmg;
			this.x =x;
			this.y =y;
			this.weapon = a;
			this.way = pos; // 무기 방향 조정
			this.wcnt = 0;
		}
	if (a == 715) { // 7번공격 
			
			this.image = new ImageIcon("src/image/전기1.png").getImage();
			this.width = 40;
			this.height = 40;
			this.attack = 5*playerDmg;
			this.x =x;
			this.y =y;
			this.weapon = a;
			this.way = pos; // 무기 방향 조정
			this.wcnt = 0;
		}
	if (a == 716) { // 7번공격 
		
		this.image = new ImageIcon("src/image/전기1.png").getImage();
		this.width = 40;
		this.height = 40;
		this.attack = 5*playerDmg;
		this.x =x;
		this.y =y;
		this.weapon = a;
		this.way = pos; // 무기 방향 조정
		this.wcnt = 0;
	}
	if (a == 717) { // 7번공격 
		
		this.image = new ImageIcon("src/image/전기1.png").getImage();
		this.width = 40;
		this.height = 40;
		this.attack = 5*playerDmg;
		this.x =x;
		this.y =y;
		this.weapon = a;
		this.way = pos; // 무기 방향 조정
		this.wcnt = 0;
	}
	if (a == 718) { // 7번공격 
		
		this.image = new ImageIcon("src/image/전기1.png").getImage();
		this.width = 40;
		this.height = 40;
		this.attack = 5*playerDmg;
		this.x =x;
		this.y =y;
		this.weapon = a;
		this.way = pos; // 무기 방향 조정
		this.wcnt = 0;
	}
	}

	public void fire() {
		if (weapon == 11) { // 직선형 공격
			if (way == 0)
			{
				this.x = x + 15;  //right
				this.y = y - 1;
				wcnt++;
			}
			else if (way == 1)
			{
				this.x = x - 15; // left
				this.y = y - 1;
				wcnt++;
			}
			else if (way == 2)
			{   this.x = x - 1;
				this.y = y + 15; // up
				wcnt++;
				
			}
			else if (way == 3)
			{
				this.x= x  - 1;
				this.y = y - 15; // down
				wcnt++;
			}
			} 
		if (weapon == 12) { //직선형 공격
			if (way == 0)
			{
				this.x = x + 15; // right
				this.y = y +1;
				wcnt++;
			}
			else if (way == 1)
			{
				this.x = x - 15;// left
				this.y = y + 1;
				wcnt++;
			}
			else if (way == 2)
			{   this.x = x + 1;
				this.y = y + 15; // up
				wcnt++;
			}
			else if (way == 3)
			{   this.x = x + 1;
				this.y = y - 15;// down
				wcnt++;
			}
			} 
		if (weapon == 1) {
			if (way == 0) {
				this.x = x + 15;
				wcnt++;
			}// right
			else if (way == 1)
			{
				this.x = x - 15;
				wcnt++;
			}// left
			else if (way == 2) {
				this.y = y + 15;
				wcnt++;
			}// up
			else if (way == 3) {
				this.y = y - 15;
				wcnt++;
			}// down
			} 
		
		
		
		else if (weapon == 2) { // 폭발형
			
				if (wcnt < 15) {
					this.y = y + weaponSpeed;
					wcnt++;
				}
				if (wcnt >= 15) {
					this.image = new ImageIcon("src/image/boom.gif").getImage();
					boomsound.start();
					this.width = 100;
					this.height = 100;
					this.attack = 10;
					wcnt++;
				}
		}
		
		
		
		else if (weapon == 3) { // 베리어 코드줄일수있으면 수정바람..
			if (wcnt % 80 == 0) {
				this.x = playerX + 100;
				this.y = playerY;
				wcnt++;
			}
			else if (wcnt % 80 == 1) {
				this.x = playerX + 100;
				this.y = playerY +10;
				wcnt++;
			}
			else if (wcnt % 80 == 2) {
				this.x = playerX + 100;
				this.y = playerY +20;
				wcnt++;
			}
			else if (wcnt % 80 == 3) {
				this.x = playerX + 100;
				this.y = playerY + 30;
				wcnt++;
			}
			else if (wcnt % 80 == 4) {
				this.x = playerX + 100;
				this.y = playerY+ 40;
				wcnt++;
			}	
			else if (wcnt % 80== 5) {
				this.x = playerX + 100;
				this.y = playerY+ 50;
				wcnt++;
			}
			else if (wcnt % 80 == 6) {
				this.x = playerX + 100;
				this.y = playerY + 60;
				wcnt++;
			}
			else if (wcnt % 80 == 7) {
				this.x = playerX + 100;
				this.y = playerY + 70;
				wcnt++;
			}
			else if (wcnt % 80 == 8) {
				this.x = playerX + 100;
				this.y = playerY + 80;
				wcnt++;
			}
			else if (wcnt % 80 == 9) {
				this.x = playerX + 100;
				this.y = playerY + 90;
				wcnt++;
			}
			else if (wcnt % 80 == 10) {
				this.x = playerX + 100;
				this.y = playerY + 100;;
				wcnt++;
			}
			else if (wcnt % 80 ==11) {
				this.x = playerX + 90;
				this.y = playerY+ 100;
				wcnt++;
			}
			else if (wcnt % 80 == 12) {
				this.x = playerX + 80;
				this.y = playerY + 100;
				wcnt++;
			}
			else if (wcnt % 80 == 13) {
				this.x = playerX + 70;
				this.y = playerY + 100;
				wcnt++;
			}
			else if (wcnt % 80 == 14) {
				this.x = playerX + 60;
				this.y = playerY + 100;
				wcnt++;
			}
			else if (wcnt % 80== 15) {
				this.x = playerX + 50;
				this.y = playerY+ 100;
				wcnt++;
			}	if (wcnt % 80== 16) {
				this.x = playerX + 40;
				this.y = playerY+ 100;
				wcnt++;
			}
			else if (wcnt % 80 == 17) {
				this.x = playerX + 30;
				this.y = playerY + 100;
				wcnt++;
			}
			else if (wcnt % 80 == 18) {
				this.x = playerX + 20;
				this.y = playerY + 100;
				wcnt++;
			}
			else if (wcnt % 80 == 19) {
				this.x = playerX + 10;
				this.y = playerY + 100;
				wcnt++;
			}
			else if (wcnt % 80 == 20) {
				this.x = playerX ;
				this.y = playerY + 100;
				wcnt++;
			}
			else if (wcnt % 80 == 21) {
				this.x = playerX -10;
				this.y = playerY + 100;
				wcnt++;
			}
			else if (wcnt % 80 == 22) {
				this.x = playerX - 20;
				this.y = playerY+ 100;
				wcnt++;
			}
			else if (wcnt % 80== 23) {
				this.x = playerX  - 30;
				this.y = playerY +100;
				wcnt++;
			}
			else if (wcnt % 80 == 24) {
				this.x = playerX -40;
				this.y = playerY +100;
				wcnt++;
			}
			else if (wcnt % 80 == 25) {
				this.x = playerX - 50;
				this.y = playerY + 100;
				wcnt++;
			}
			else if (wcnt % 80 == 26) {
				this.x = playerX - 60;
				this.y = playerY+ 100;
				wcnt++;
			}	if (wcnt % 80== 27) {
				this.x = playerX - 70;
				this.y = playerY+ 100;
				wcnt++;
			}
			else if (wcnt % 80 == 28) {
				this.x = playerX - 80;
				this.y = playerY + 100;
				wcnt++;
			}
			else if (wcnt % 80 == 29) {
				this.x = playerX - 90;
				this.y = playerY + 100;
				wcnt++;
			}
			else if (wcnt % 80 == 30) {
				this.x = playerX - 100;
				this.y = playerY + 100;
				wcnt++;
			}
			else if (wcnt % 80 == 31) {
				this.x = playerX -100;
				this.y = playerY + 90;
				wcnt++;
			}
			else if (wcnt % 80 == 32) {
				this.x = playerX - 100;
				this.y = playerY + 80;
				wcnt++;
			}
			else if (wcnt % 80 == 33) {
				this.x = playerX - 100;
				this.y = playerY + 70;
				wcnt++;
			}
			else if (wcnt % 80 == 34) {
				this.x = playerX - 100;
				this.y = playerY + 60;
				wcnt++;
			}
			else if (wcnt % 80 == 35) {
				this.x = playerX - 100;
				this.y = playerY + 50;
				wcnt++;
			}
			else if (wcnt % 80 == 36) {
				this.x = playerX - 100;
				this.y = playerY + 40;
				wcnt++;
			}
			else if (wcnt % 80 == 37) {
				this.x = playerX - 100;
				this.y = playerY+ 30;
				wcnt++;
			}	if (wcnt % 80== 38) {
				this.x = playerX - 100;
				this.y = playerY+ 20 ;
				wcnt++;
			}
			else if (wcnt % 80 == 39) {
				this.x = playerX - 100;
				this.y = playerY + 10;
				wcnt++;
			}
			else if (wcnt % 80 == 40) {
				this.x = playerX - 100;
				this.y = playerY ;
				wcnt++;
			}
			else if (wcnt % 80 == 41) {
				this.x = playerX - 100;
				this.y = playerY - 10;
				wcnt++;
			}
			else if (wcnt % 80 == 42) {
				this.x = playerX - 100;
				this.y = playerY - 20;
				wcnt++;
			}
			else if (wcnt % 80 == 43) {
				this.x = playerX - 100;
				this.y = playerY - 30;
				wcnt++;
			}
			else if (wcnt % 80 == 44) {
				this.x = playerX -100;
				this.y = playerY - 40;
				wcnt++;
			}
			else if (wcnt % 80 == 45) {
				this.x = playerX - 100;
				this.y = playerY - 50;
				wcnt++;
			}
			else if (wcnt % 80== 46) {
				this.x = playerX - 100;
				this.y = playerY - 60;
				wcnt++;
			}
			else if (wcnt % 80 == 47) {
				this.x = playerX - 100;
				this.y = playerY - 70;
				wcnt++;
			}
			else if (wcnt % 80 == 48) {
				this.x = playerX - 100;
				this.y = playerY -  80;
				wcnt++;
			}	
			else if (wcnt % 80== 49) {
				this.x = playerX - 100;
				this.y = playerY -90;
				wcnt++;
			}
			else if (wcnt % 80 == 50) {
				this.x = playerX - 100;
				this.y = playerY - 100;
				wcnt++;
			}
			else if (wcnt % 80 == 51) {
				this.x = playerX -90;
				this.y = playerY - 100;
				wcnt++;
			}
			else if (wcnt % 80 == 52) {
				this.x = playerX - 80;
				this.y = playerY - 100;
				wcnt++;
			}
			else if (wcnt % 80 == 53) {
				this.x = playerX - 70;
				this.y = playerY - 100;
				wcnt++;
			}
			else if (wcnt % 80 == 54) {
				this.x = playerX - 60;
				this.y = playerY - 100;
				wcnt++;
			}	
			else if (wcnt % 80 == 55) {
				this.x = playerX - 50;
				this.y = playerY - 100;
				wcnt++;
			}
			else if (wcnt % 80 == 56) {
				this.x = playerX - 40;
				this.y = playerY - 100;
				wcnt++;
			}
			else if (wcnt % 80 == 57) {
				this.x = playerX - 30;
				this.y = playerY  - 100;
				wcnt++;
			}
			else if (wcnt % 80 == 58) {
				this.x = playerX - 20;
				this.y = playerY - 100;
				wcnt++;
			}
			else if (wcnt % 80 == 59) {
				this.x = playerX - 10;
				this.y = playerY - 100;
				wcnt++;
			}	
			else if (wcnt % 80 == 60) {
				this.x = playerX ;
				this.y = playerY - 100;
				wcnt++;
			}
			else if (wcnt % 80 == 61) {
				this.x = playerX + 10;
				this.y = playerY -100;
				wcnt++;
			}
			else if (wcnt % 80 == 62) {
				this.x = playerX + 20;
				this.y = playerY -100;
				wcnt++;
			}
			else if (wcnt % 80 == 63) {
				this.x = playerX + 30;
				this.y = playerY -100;
				wcnt++;
			}
			else if (wcnt % 80 == 64) {
				this.x = playerX + 40;
				this.y = playerY - 100;
				wcnt++;
			}
			else if (wcnt % 80 == 65) {
				this.x = playerX + 50;
				this.y = playerY - 100;
				wcnt++;
			}
			else if (wcnt % 80 == 66) {
				this.x = playerX + 60;
				this.y = playerY - 100;
				wcnt++;
			}
			else if (wcnt % 80 == 67) {
				this.x = playerX + 70;
				this.y = playerY - 100;
				wcnt++;
			}
			else if (wcnt % 80 == 68) {
				this.x = playerX + 80;
				this.y = playerY - 100;
				wcnt++;
			}
			else if (wcnt % 80 == 69) {
				this.x = playerX + 90;
				this.y = playerY - 100;
				wcnt++;
			}
			else if (wcnt % 80 == 70) {
				this.x = playerX + 100;
				this.y = playerY - 100;
				wcnt++;
			}	
			else if (wcnt % 80 == 71) {
				this.x = playerX + 100;
				this.y = playerY - 90;
				wcnt++;
			}
			else if (wcnt % 80 == 72) {
				this.x = playerX + 100;
				this.y = playerY - 80;
				wcnt++;
			}
			else if (wcnt % 80 == 73) {
				this.x = playerX + 100;
				this.y = playerY - 70;
				wcnt++;
			}
			else if (wcnt % 80 == 74) {
				this.x = playerX + 100;
				this.y = playerY - 60;
				wcnt++;
			}
			else if (wcnt % 80 == 75) {
				this.x = playerX + 100;
				this.y = playerY - 50;
				wcnt++;
			}
			else if (wcnt % 80 == 76) {
				this.x = playerX + 100;
				this.y = playerY - 40;
				wcnt++;
			}	
			else if (wcnt % 80 == 77) {
				this.x = playerX + 100;
				this.y = playerY - 30;
				wcnt++;
			}
			else if (wcnt % 80 == 78) {
				this.x = playerX + 100;
				this.y = playerY - 20;
				wcnt++;
			}
			else if (wcnt % 80 == 79) {
				this.x = playerX + 100;
				this.y = playerY - 10;
				wcnt++;
			}
	} 
		
		
		else if (weapon == 4) { // 곡선형 오른쪽공격

			if (wcnt < 15) {
				this.x = x + weaponSpeed;
				this.y = y - weaponSpeed;
				wcnt++;
			}
			if (wcnt >= 15) {
				this.x = x + 5;
				this.y = y + 20;
				wcnt++;
			}
		}
		else if (weapon == 41) { // 곡선형 왼쪽공격

			if (wcnt < 15) {
				this.x = x - weaponSpeed;
				this.y = y - weaponSpeed;
				;
				wcnt++;
			}
			if (wcnt >= 15) {
				this.x = x - 5;
				this.y = y + 20;
				wcnt++;
			}
		}
		
		
		
		
		else if (weapon == 5) { //5번째 공격 

			wcnt++;
		
		}
		
		else if (weapon == 51) { //5번째 공격 

			wcnt++;
			if (wcnt >= 30) {
				this.image = new ImageIcon("src/image/boom.gif").getImage();
				boomsound.start();
				this.width = 100;
				this.height = 100;
				this.attack = 10;
			}
		
		}
		
		
		
		
		
		else if (weapon==61) { // 1번재 드론펫 소환
			this.x =playerX+ 50;
			this.y =playerY- 50;
		}
		
		else if(weapon == 611) {// 1번째 드론펫 오른쪽공격
			
			if (wcnt < 15) {
				this.x = x + weaponSpeed;
				this.y = y - weaponSpeed;
				wcnt++;
			}
			if (wcnt >= 15) {
				this.x = x + 2;
				this.y = y + 20;
				wcnt++;
			}
			
		}
		else if(weapon == 612) { //1번째 드론펫 왼쪽공격 구현
				
				if (wcnt < 15) {
					this.x = x - weaponSpeed;
					this.y = y - weaponSpeed;
					wcnt++;
				}
				if (wcnt >= 15) {
					this.x = x - 2;
					this.y = y + 20;
					wcnt++;
				}
				
			}
		
		
		else if (weapon==62) { // 2번째 드론펫 소환 구현
			this.x =playerX- 80;
			this.y =playerY- 50;
		}
		
		else if(weapon == 621) { //2번째 드론펫 오른쪽공격 구현
			
			if (wcnt < 15) {
				this.x = x + weaponSpeed;
				this.y = y - weaponSpeed;
				wcnt++;
			}
			if (wcnt >= 15) {
				this.x = x + 2;
				this.y = y + 20;
				wcnt++;
			}
			
		}
		else if(weapon == 622) { //2번째 드론펫 왼쪽공격 구현
				
				if (wcnt < 15) {
					this.x = x - weaponSpeed;
					this.y = y - weaponSpeed;
					wcnt++;
				}
				if (wcnt >= 15) {
					this.x = x - 2;
					this.y = y + 20;
					wcnt++;
				}
			
		}
		else if (weapon==63) { // 3번째 드론펫 소환 구현
			this.x =playerX-30;
			this.y =playerY- 100;
		}
		else if(weapon == 631) { //3번째 드론펫 오른쪽공격 구현
			
			if (wcnt < 15) {
				this.x = x + weaponSpeed;
				this.y = y - weaponSpeed;
				wcnt++;
			}
			if (wcnt >= 15) {
				this.x = x + 2;
				this.y = y + 20;
				wcnt++;
			}
			
		}
		else if(weapon == 632) { //3번째 드론펫 오른쪽공격 구현
			
			if (wcnt < 15) {
				this.x = x + weaponSpeed;
				this.y = y - weaponSpeed;
				wcnt++;
			}
			if (wcnt >= 15) {
				this.x = x + 2;
				this.y = y + 20;
				wcnt++;
			}
			
		}
		else if(weapon == 633) { //2번째 드론펫 왼쪽공격 구현
			
			if (wcnt < 15) {
				this.x = x - weaponSpeed;
				this.y = y - weaponSpeed;
				wcnt++;
			}
			if (wcnt >= 15) {
				this.x = x - 2;
				this.y = y + 20;
				wcnt++;
			}
		
		}
		else if(weapon == 634) { //2번째 드론펫 왼쪽공격 구현
			
			if (wcnt < 15) {
				this.x = x - weaponSpeed;
				this.y = y - weaponSpeed;
				wcnt++;
			}
			if (wcnt >= 15) {
				this.x = x - 2;
				this.y = y + 20;
				wcnt++;
			}
		
		}
	
		
		
		
		 if(weapon ==7) {
			this.x= x+15;
			wcnt++;
		}
		 if(weapon ==71) {
			this.x= x-15;
			wcnt++;
		}
		if(weapon ==72) {
			this.y= y-15;
			wcnt++;
		}
		 if(weapon ==73) {
			this.y= y+15;
			wcnt++;
		}
		 if(weapon ==74) {
			this.x= x+8;
			this.y= y-8;
			wcnt++;
		}
		if(weapon ==75) {
			this.x= x+8;
			this.y= y+8;
			wcnt++;
		}
		if(weapon ==76) {
			this.x= x-8;
			this.y= y-8;
			wcnt++;
		}
	    if(weapon ==77) {
			this.x= x-8;
			this.y= y+8;
			wcnt++;
		}
	    if(weapon==711)
	    {
	    	this.x=x+11;
	    	this.y=y+4;
	    	wcnt++;
	    }
	    if(weapon==712)
	    {
	    	this.x=x+11;
	    	this.y=y-4;
	    	wcnt++;
	    }
	    if(weapon==713)
	    {
	    	this.x=x-11;
	    	this.y=y+4;
	    	wcnt++;
	    }
	    if(weapon==714)
	    {
	    	this.x=x-11;
	    	this.y=y-4;
	    	wcnt++;
	    }
	    if(weapon==715)
	    {
	    	this.x=x-4;
	    	this.y=y-11;
	    	wcnt++;
	    }
	    if(weapon==716)
	    {
	    	this.x=x-4;
	    	this.y=y+11;
	    	wcnt++;
	    }
	    if(weapon==717)
	    {
	    	this.x=x+4;
	    	this.y=y-11;
	    	wcnt++;
	    }
	    if(weapon==718)
	    {
	    	this.x=x+4;
	    	this.y=y+11;
	    	wcnt++;
	    }
}
}

