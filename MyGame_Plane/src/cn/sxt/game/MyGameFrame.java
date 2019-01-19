package cn.sxt.game;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;


public class MyGameFrame extends JFrame{
	
	Image ball = GameUtil.getImage("images/ball.png");
	Image planeImg = GameUtil.getImage("images/plane.png");
	
	Plane plane = new Plane(planeImg,250,250); //创建飞机
	Shell shell=new Shell();
	
	Shell[] shells = new Shell[50]; //炮弹数组
	
	Explode bao;
	Date startTime= new Date();
	Date endTime;
	int period; // 游戏持续的
	
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(ball, 0, 0, null);
		plane.drawSelf(g);  // 画飞机
		//shell.draw(g);   
		
		
		// 画出所有炮弹
		for(int i=0;i<shells.length;i++) {
			shells[i].draw(g);
			
			//判断炮弹是否与飞机相碰
			boolean peng=shells[i].getRect().intersects(plane.getRect());
			if(peng) {
				plane.live=false; //飞机死掉
				if(bao==null) {
					bao = new Explode(plane.x,plane.y);
					
					endTime = new Date();  // 飞机死掉时的时间
					period =(int)((endTime.getTime()-startTime.getTime())/1000);
				}
				bao.draw(g);
				System.out.println("相撞了。。。");
			}
				if(!plane.live) {
					// 显示飞机存在的时间
					g.setColor(Color.red);
					g.drawString("时间"+period+"秒",(int)plane.x,(int)plane.y);
				}
			
		}
		
	}
	
	// 内部类帮助我们反复的重画窗口
	class PaintThread extends Thread{
		@Override
		public void run() {
			while(true) {
				System.out.println("窗口画一次");
				repaint(); //重画
				
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		// 键盘监听类
		class KeyMonitor extends KeyAdapter{
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("按下"+e.getKeyCode());
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("抬起"+e.getKeyCode());
			}
		}
		
	}
	
	
	// 窗口初始化
	public void launchFrame() {
		setTitle("qqc的作品");
		// 窗口设为可见
		setVisible(true);
		
		//窗口大小
		setSize(500,500);
		
		//窗口左上角顶点坐标位置
		setLocation(300,300);
		
		//关闭窗口监听
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
		new PaintThread().start();// 启动重画窗口的线程
		//addKeyListener(new KeyListener()); //窗口增加键盘的监听
		
		//初始化50个炮弹
		for(int i = 0;i<shells.length;i++) {
			shells[i]=new Shell();
		}
	}
	
	public static void main(String[] args) {
		MyGameFrame f = new MyGameFrame();
		f.launchFrame();
	}
	/* 双缓冲
	private Image offScreenImage = null;
	 
	public void update(Graphics g) {
	    if(offScreenImage == null)
	        offScreenImage = this.createImage(Constant.GAME_WIDTH,Constent.GAME_HEIGHT);//这是游戏窗口的宽度和高度
	     
	    Graphics gOff = offScreenImage.getGraphics();
	    paint(gOff);
	    g.drawImage(offScreenImage, 0, 0, null);
	}  
	*/
}























