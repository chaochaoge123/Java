package cn.sxt.game;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class Plane extends GameObject{
	
	//int speed = 3;
	boolean left,up,right,down; //控制飞机方向
	
	boolean live=true;  //定义飞机属性(死亡，活着)
	
	public void drawSelf(Graphics g) {
		
		if(live) {   // 飞机活着
			g.drawImage(img,(int)x,(int)y,null);
			
			if(left) {
				x-=speed;
			}
			if(right) {
				x+=speed;
			}
			if(up) {
				y-=speed;
			}
			if(down) {
				y+=speed;
			}
			}else {
				
			}
			
			x++;
		}
	
	public Plane(Image img,double x,double y) {
		this.img=img;
		this.x=x;
		this.y= y;
		this.speed=3;
		this.width = img.getWidth(null);
		this.height=img.getHeight(null);
	}
	
	//键盘控制方向
	public void addDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
        case KeyEvent.VK_LEFT:
            left = true;
            break;
        case KeyEvent.VK_UP:
            up = true;
            break;
        case KeyEvent.VK_RIGHT:
            right = true;
            break;
        case KeyEvent.VK_DOWN:
            down = true;
            break;
        default:
            break;
		}
	}
}
