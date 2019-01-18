package game;

import java.awt.*;
import javax.swing.*;

public class BallGame extends JFrame{
	 
	// 图片加载到窗口
	Image ball = Toolkit.getDefaultToolkit().getImage("img/ball.jpg");  // 球
	Image desk = Toolkit.getDefaultToolkit().getImage("img/desk.jpg");  // 背景图片
	
	// 球的大小
	double x=100;
	double y=100;
	//boolean rigint =true; 方向
	
	double degree = 3.14/3;  // 弧度
	
	//画窗口方法
	public void paint(Graphics g){
		System.out.println("窗口被画了一次");
		g.drawImage(desk,0,0,null);
		g.drawImage(ball,(int)x,(int)100,null);
		
		x= x+10*Math.cos(degree);
		y = y+10*Math.sin(degree);
		
		if(y>500-40-30) {
			degree = -degree;
		}
		
		//碰到左右边界
		if(x<0||x>856) {
			degree = 3.14-degree;
		}
		
	}
		
		
		
		/*
		if(right) {
			x = x+10;
		}else {
			x = x-10;
		}
		
		if(x>856) {
			right = false;
		}
		
		if(x<0) {
			right = true;
		}
	}
	*/
	
	//窗口加载
	void launchFrame(){
		setSize(856,500); //窗口宽高
		setLocation(50,50); //与屏幕的距离
		setVisible(true);
	

	//重划窗口
	while(true) {
		repaint();
		try {
			Thread.sleep(40); //40ms
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
	
	
	
	public static void main(String[] args) {
		System.out.println("桌球游戏开始了");
		BallGame game = new BallGame();
		game.launchFrame();
	}
	}

