package cn.sxt.game;

import java.awt.Color;
import java.awt.Graphics;

// 炮弹类
public class Shell extends GameObject {
	double degree;
	
	public Shell() {
		x=200;
		y=200;
		width=10;
		height = 10;
		speed = 3;
		
		degree = Math.random()*Math.PI*2;    //炮弹的随机弧度
	}
	
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.YELLOW);
		
		g.fillOval((int)x,(int)y,width,height);
		
		x+=speed*Math.cos(degree);
		y+=speed*Math.asin(degree);
		
		// 炮弹碰到边框弹走
		if(x<0||x>Constant.GAME_WIDTH-height) {
			degree =Math.PI-degree;
		}
		
		if(y<30||y>Constant.GAME_HEIGHT-height) {
			degree = -degree;
		}
		
		g.getColor();
	}
}






















