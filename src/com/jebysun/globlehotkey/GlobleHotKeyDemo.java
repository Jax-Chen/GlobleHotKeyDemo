package com.jebysun.globlehotkey;


import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.util.Random;

/**
 * 利用JIntellitype实现全局热键设置
 * @author Jeby Sun
 *
 */
public class GlobleHotKeyDemo extends JFrame {


	//定义热键标识，用于在设置多个热键时，在事件处理中区分用户按下的热键
	public static final int FUNC_KEY_MARK = 1;
	public static final int EXIT_KEY_MARK = 0;
	public static final int F1_KEY_MARK = 11;
	public static final int F2_KEY_MARK = 12;
	public static final int F3_KEY_MARK = 13;
	public static final int F4_KEY_MARK = 14;
	public static final int F5_KEY_MARK = 15;
    public static final int F6_KEY_MARK = 16;
    public static final int F7_KEY_MARK = 17;
    public static final int F8_KEY_MARK = 18;

	JButton msgBtn;
	JButton exitBtn;
	static volatile JTextField
            t1x,t2x,t3x,t4x,t5x,t6x,t7x,t8x,//横坐标
            t1y,t2y,t3y,t4y,t5y,t6y,t7y,t8y,//纵坐标
            tFreq,tTimes,// 间隔时间、次数
            t1s,t2s,t3s,t4s,t5s,t6s,t7s,t8s,//每个点等待时间
            t1w,t2w,t3w,t4w,t5w,t6w,t7w,t8w //每个点点击之后滚轮上下滑动举例
    ;
	JLabel b1x,b2x,b3x,b4x,b5x,b6x,b7x,b8x,
            b1y,b2y,b3y,b4y,b5y,b6y,b7y,b8y,
            bFreq,bTimes,
            b1s,b2s,b3s,b4s,b5s,b6s,b7s,b8s,
            b1w,b2w,b3w,b4w,b5w,b6w,b7w,b8w;

	public void init(){
		// 第1个点-----------------------------------------------------------
		b1x = new JLabel("F1-x");
		b1x.setBounds(70,20,30,20);
		layeredPane.add(b1x,JLayeredPane.MODAL_LAYER);

		t1x = new JTextField();
		t1x.setBounds(100,20,40,20);
		layeredPane.add(t1x,JLayeredPane.MODAL_LAYER);

		b1y = new JLabel("F1-y");
		b1y.setBounds(150,20,30,20);
		layeredPane.add(b1y,JLayeredPane.MODAL_LAYER);

		t1y = new JTextField();
		t1y.setBounds(180,20,40,20);
		layeredPane.add(t1y,JLayeredPane.MODAL_LAYER);

		b1s = new JLabel("该点结束停顿时间");
		b1s.setBounds(480,20,120,20);
		layeredPane.add(b1s,JLayeredPane.MODAL_LAYER);

		t1s = new JTextField();
		t1s.setBounds(600,20,40,20);
		layeredPane.add(t1s,JLayeredPane.MODAL_LAYER);

		b1w = new JLabel("点击后滚轮距离");
		b1w.setBounds(280,20,120,20);
		layeredPane.add(b1w,JLayeredPane.MODAL_LAYER);

		t1w = new JTextField();
		t1w.setBounds(400,20,40,20);
		layeredPane.add(t1w,JLayeredPane.MODAL_LAYER);

		// 第2个点-----------------------------------------------------------

		b2x = new JLabel("F2-x");
		b2x.setBounds(70,50,30,20);
		layeredPane.add(b2x,JLayeredPane.MODAL_LAYER);

		t2x = new JTextField();
		t2x.setBounds(100,50,40,20);
		layeredPane.add(t2x,JLayeredPane.MODAL_LAYER);

		b2y = new JLabel("F2-y");
		b2y.setBounds(150,50,30,20);
		layeredPane.add(b2y,JLayeredPane.MODAL_LAYER);

		t2y = new JTextField();
		t2y.setBounds(180,50,40,20);
		layeredPane.add(t2y,JLayeredPane.MODAL_LAYER);


		b2s = new JLabel("该点结束停顿时间");
		b2s.setBounds(480,50,120,20);
		layeredPane.add(b2s,JLayeredPane.MODAL_LAYER);

		t2s = new JTextField();
		t2s.setBounds(600,50,40,20);
		layeredPane.add(t2s,JLayeredPane.MODAL_LAYER);

		b2w = new JLabel("点击后滚轮距离");
		b2w.setBounds(280,50,120,20);
		layeredPane.add(b2w,JLayeredPane.MODAL_LAYER);

		t2w = new JTextField();
		t2w.setBounds(400,50,40,20);
		layeredPane.add(t2w,JLayeredPane.MODAL_LAYER);

		// 第3个点-----------------------------------------------------------

		b3x = new JLabel("F3-x");
		b3x.setBounds(70,80,30,20);
		layeredPane.add(b3x,JLayeredPane.MODAL_LAYER);

		t3x = new JTextField();
		t3x.setBounds(100,80,40,20);
		layeredPane.add(t3x,JLayeredPane.MODAL_LAYER);

		b3y = new JLabel("F3-y");
		b3y.setBounds(150,80,30,20);
		layeredPane.add(b3y,JLayeredPane.MODAL_LAYER);

		t3y = new JTextField();
		t3y.setBounds(180,80,40,20);
		layeredPane.add(t3y,JLayeredPane.MODAL_LAYER);

		b3s = new JLabel("该点结束停顿时间");
		b3s.setBounds(480,80,120,20);
		layeredPane.add(b3s,JLayeredPane.MODAL_LAYER);

		t3s = new JTextField();
		t3s.setBounds(600,80,40,20);
		layeredPane.add(t3s,JLayeredPane.MODAL_LAYER);

		b3w = new JLabel("点击后滚轮距离");
		b3w.setBounds(280,80,120,20);
		layeredPane.add(b3w,JLayeredPane.MODAL_LAYER);

		t3w = new JTextField();
		t3w.setBounds(400,80,40,20);
		layeredPane.add(t3w,JLayeredPane.MODAL_LAYER);

		// 第4个点-----------------------------------------------------------

		b4x = new JLabel("F4-x");
		b4x.setBounds(70,110,30,20);
		layeredPane.add(b4x,JLayeredPane.MODAL_LAYER);

		t4x = new JTextField();
		t4x.setBounds(100,110,40,20);
		layeredPane.add(t4x,JLayeredPane.MODAL_LAYER);

		b4y = new JLabel("F4-y");
		b4y.setBounds(150,110,30,20);
		layeredPane.add(b4y,JLayeredPane.MODAL_LAYER);

		t4y = new JTextField();
		t4y.setBounds(180,110,40,20);
		layeredPane.add(t4y,JLayeredPane.MODAL_LAYER);


		b4s = new JLabel("该点结束停顿时间");
		b4s.setBounds(480,110,120,20);
		layeredPane.add(b4s,JLayeredPane.MODAL_LAYER);

		t4s = new JTextField();
		t4s.setBounds(600,110,40,20);
		layeredPane.add(t4s,JLayeredPane.MODAL_LAYER);

		b4w = new JLabel("点击后滚轮距离");
		b4w.setBounds(280,110,120,20);
		layeredPane.add(b4w,JLayeredPane.MODAL_LAYER);

		t4w = new JTextField();
		t4w.setBounds(400,110,40,20);
		layeredPane.add(t4w,JLayeredPane.MODAL_LAYER);

		// 第5个点-----------------------------------------------------------

		b5x = new JLabel("F5-x");
		b5x.setBounds(70,140,30,20);
		layeredPane.add(b5x,JLayeredPane.MODAL_LAYER);

		t5x = new JTextField();
		t5x.setBounds(100,140,40,20);
		layeredPane.add(t5x,JLayeredPane.MODAL_LAYER);

		b5y = new JLabel("F5-y");
		b5y.setBounds(150,140,30,20);
		layeredPane.add(b5y,JLayeredPane.MODAL_LAYER);

		t5y = new JTextField();
		t5y.setBounds(180,140,40,20);
		layeredPane.add(t5y,JLayeredPane.MODAL_LAYER);

		b5s = new JLabel("该点结束停顿时间");
		b5s.setBounds(480,140,120,20);
		layeredPane.add(b5s,JLayeredPane.MODAL_LAYER);

		t5s = new JTextField();
		t5s.setBounds(600,140,40,20);
		layeredPane.add(t5s,JLayeredPane.MODAL_LAYER);

		b5w = new JLabel("点击后滚轮距离");
		b5w.setBounds(280,140,120,20);
		layeredPane.add(b5w,JLayeredPane.MODAL_LAYER);

		t5w = new JTextField();
		t5w.setBounds(400,140,40,20);
		layeredPane.add(t5w,JLayeredPane.MODAL_LAYER);

        // 第6个点-----------------------------------------------------------

        b6x = new JLabel("F6-x");
        b6x.setBounds(70,170,30,20);
        layeredPane.add(b6x,JLayeredPane.MODAL_LAYER);

        t6x = new JTextField();
        t6x.setBounds(100,170,40,20);
        layeredPane.add(t6x,JLayeredPane.MODAL_LAYER);

        b6y = new JLabel("F6-y");
        b6y.setBounds(150,170,30,20);
        layeredPane.add(b6y,JLayeredPane.MODAL_LAYER);

        t6y = new JTextField();
        t6y.setBounds(180,170,40,20);
        layeredPane.add(t6y,JLayeredPane.MODAL_LAYER);

        b6s = new JLabel("该点结束停顿时间");
        b6s.setBounds(480,170,120,20);
        layeredPane.add(b6s,JLayeredPane.MODAL_LAYER);

        t6s = new JTextField();
        t6s.setBounds(600,170,40,20);
        layeredPane.add(t6s,JLayeredPane.MODAL_LAYER);

        b6w = new JLabel("点击后滚轮距离");
		b6w.setBounds(280,170,120,20);
		layeredPane.add(b6w,JLayeredPane.MODAL_LAYER);

		t6w = new JTextField();
		t6w.setBounds(400,170,40,20);
		layeredPane.add(t6w,JLayeredPane.MODAL_LAYER);

        // 第7个点-----------------------------------------------------------

        b7x = new JLabel("F7-x");
        b7x.setBounds(70,200,30,20);
        layeredPane.add(b7x,JLayeredPane.MODAL_LAYER);

        t7x = new JTextField();
        t7x.setBounds(100,200,40,20);
        layeredPane.add(t7x,JLayeredPane.MODAL_LAYER);

        b7y = new JLabel("F7-y");
        b7y.setBounds(150,200,30,20);
        layeredPane.add(b7y,JLayeredPane.MODAL_LAYER);

        t7y = new JTextField();
        t7y.setBounds(180,200,40,20);
        layeredPane.add(t7y,JLayeredPane.MODAL_LAYER);

        b7s = new JLabel("该点结束停顿时间");
        b7s.setBounds(480,200,120,20);
        layeredPane.add(b7s,JLayeredPane.MODAL_LAYER);

        t7s = new JTextField();
        t7s.setBounds(600,200,40,20);
        layeredPane.add(t7s,JLayeredPane.MODAL_LAYER);

        b7w = new JLabel("点击后滚轮距离");
		b7w.setBounds(280,200,120,20);
		layeredPane.add(b7w,JLayeredPane.MODAL_LAYER);

		t7w = new JTextField();
		t7w.setBounds(400,200,40,20);
		layeredPane.add(t7w,JLayeredPane.MODAL_LAYER);

        // 第8个点-----------------------------------------------------------

        b8x = new JLabel("F8-x");
        b8x.setBounds(70,230,30,20);
        layeredPane.add(b8x,JLayeredPane.MODAL_LAYER);

        t8x = new JTextField();
        t8x.setBounds(100,230,40,20);
        layeredPane.add(t8x,JLayeredPane.MODAL_LAYER);

        b8y = new JLabel("F8-y");
        b8y.setBounds(150,230,30,20);
        layeredPane.add(b8y,JLayeredPane.MODAL_LAYER);

        t8y = new JTextField();
        t8y.setBounds(180,230,40,20);
        layeredPane.add(t8y,JLayeredPane.MODAL_LAYER);

        b8s = new JLabel("该点结束停顿时间");
        b8s.setBounds(480,230,120,20);
        layeredPane.add(b8s,JLayeredPane.MODAL_LAYER);

        t8s = new JTextField();
        t8s.setBounds(600,230,40,20);
        layeredPane.add(t8s,JLayeredPane.MODAL_LAYER);

        b8w = new JLabel("点击后滚轮距离");
		b8w.setBounds(280,230,120,20);
		layeredPane.add(b8w,JLayeredPane.MODAL_LAYER);

		t8w = new JTextField();
		t8w.setBounds(400,230,40,20);
		layeredPane.add(t8w,JLayeredPane.MODAL_LAYER);
        
		// 频率-----------------------------------------------------------

		bFreq = new JLabel("频率（毫秒）");
		bFreq.setBounds(70,260,80,20);
		layeredPane.add(bFreq,JLayeredPane.MODAL_LAYER);

		tFreq = new JTextField();
		tFreq.setBounds(180,260,40,20);
		tFreq.setText("1000");
		layeredPane.add(tFreq,JLayeredPane.MODAL_LAYER);

		
		

		// 循环次数-----------------------------------------------------------

		bTimes = new JLabel("剩余循环次数");
		bTimes.setBounds(70,290,80,20);
		layeredPane.add(bTimes,JLayeredPane.MODAL_LAYER);

		tTimes = new JTextField();
		tTimes.setBounds(180,290,40,20);
		tTimes.setText("1");
		layeredPane.add(tTimes,JLayeredPane.MODAL_LAYER);




		// 开始暂停-----------------------------------------------------------
		msgBtn = new JButton("开始（Home）");
		//设置按钮边距
//		msgBtn.setMargin(new Insets(0,0,0,0));
		msgBtn.setFocusable(false);
		msgBtn.setBounds(140, 320, 120, 30);
		msgBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				ifRun = true;
				start();
			}
		});
		layeredPane.add(msgBtn,JLayeredPane.MODAL_LAYER);

		exitBtn = new JButton("暂停（End）");
//		exitBtn.setMargin(new Insets(0,0,0,0));
		exitBtn.setFocusable(false);
		exitBtn.setBounds(300, 320, 120, 30);
		exitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ifRun = false;
			}
		});
		layeredPane.add(exitBtn,JLayeredPane.MODAL_LAYER);

	}

	//创建一个JLayeredPane用于分层的。
	JLayeredPane layeredPane;
	//创建一个Panel和一个Label用于存放图片，作为背景。
	JPanel jp;
	JLabel jl;
	ImageIcon image;
	public GlobleHotKeyDemo() {
	    javax.swing.ImageIcon icon = new javax.swing.ImageIcon("image/icon2.jpg");
        this.setIconImage(icon.getImage());

        this.setTitle("抢票软件");
		this.setBounds(100, 100, 800, 450);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		layeredPane=new JLayeredPane();
		image = new ImageIcon("image/icon.jpg");
		image.setImage(image.getImage().getScaledInstance(800, 400,
				Image.SCALE_DEFAULT));
		jp=new JPanel();
		jp.setBounds(0,0,image.getIconWidth(),image.getIconHeight());
		jl=new JLabel(image);
		jp.add(jl);
		//将jp放到最底层。
		layeredPane.add(jp,JLayeredPane.DEFAULT_LAYER);
		this.setLayeredPane(layeredPane);

		//控件初始化
		init();
		this.setVisible(true);
        //第一步：注册热键，第一个参数表示该热键的标识，第二个参数表示组合键，如果没有则为0，第三个参数为定义的主要热键
    	JIntellitype.getInstance().registerHotKey(FUNC_KEY_MARK, 0, 36);
    	JIntellitype.getInstance().registerHotKey(EXIT_KEY_MARK, 0, 35);
    	JIntellitype.getInstance().registerHotKey(F1_KEY_MARK, 0, 112);
    	JIntellitype.getInstance().registerHotKey(F2_KEY_MARK, 0, 113);
    	JIntellitype.getInstance().registerHotKey(F3_KEY_MARK, 0, 114);
    	JIntellitype.getInstance().registerHotKey(F4_KEY_MARK, 0, 115);
    	JIntellitype.getInstance().registerHotKey(F5_KEY_MARK, 0, 116);
        JIntellitype.getInstance().registerHotKey(F6_KEY_MARK, 0, 117);
        JIntellitype.getInstance().registerHotKey(F7_KEY_MARK, 0, 118);
        JIntellitype.getInstance().registerHotKey(F8_KEY_MARK, 0, 119);

    	//第二步：添加热键监听器
        JIntellitype.getInstance().addHotKeyListener(new HotkeyListener() {
			
			@Override
			public void onHotKey(int markCode) {
				switch (markCode) {  
		        case FUNC_KEY_MARK:
//					ifRun = true;
					start();
		            break;  
		        case EXIT_KEY_MARK:
					ifRun = false;
		            break;
				case F1_KEY_MARK:
					t1x.setText(String.valueOf(getMouseX()));
					t1y.setText(String.valueOf(getMouseY()));
					break;
				case F2_KEY_MARK:
					t2x.setText(String.valueOf(getMouseX()));
					t2y.setText(String.valueOf(getMouseY()));
					break;
				case F3_KEY_MARK:
					t3x.setText(String.valueOf(getMouseX()));
					t3y.setText(String.valueOf(getMouseY()));
					break;
				case F4_KEY_MARK:
					t4x.setText(String.valueOf(getMouseX()));
					t4y.setText(String.valueOf(getMouseY()));
					break;
				case F5_KEY_MARK:
					t5x.setText(String.valueOf(getMouseX()));
					t5y.setText(String.valueOf(getMouseY()));
					break;
                case F6_KEY_MARK:
                    t6x.setText(String.valueOf(getMouseX()));
                    t6y.setText(String.valueOf(getMouseY()));
                    break;
                case F7_KEY_MARK:
                    t7x.setText(String.valueOf(getMouseX()));
                    t7y.setText(String.valueOf(getMouseY()));
                    break;
                case F8_KEY_MARK:
                    t8x.setText(String.valueOf(getMouseX()));
                    t8y.setText(String.valueOf(getMouseY()));
                    break;
				} 				
			}
		});  
		
		this.setVisible(true);
		//this.setEnabled(true);
	}

    public int getMouseX (){
		return (int)MouseInfo.getPointerInfo().getLocation().getX();
	}

	public int getMouseY (){
		return (int)MouseInfo.getPointerInfo().getLocation().getY();
	}

	public static void main(String[] args) {
	    try {
            //if (EncryptAlgorithmUtils.validLicense()) {
                new GlobleHotKeyDemo();
            //}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


	public static int on = 0;
	public void start(){

		if(on ==0){
			thread.start();
			on =1;
		}
		ifRun = true;
	}

	static Thread thread = new Thread(new Runnable() {

		@Override
		public void run() {
			Robot robot = null;
			try {
				robot = new Robot();
			} catch (AWTException e) {
				e.printStackTrace();
			}
			// 模拟移动到当前鼠标位置
			while (true){
				while (ifRun) {

					if(getValue(tTimes)>0){
						Point point = MouseInfo.getPointerInfo().getLocation();
						System.out.println("x=" + point.getX() + ",y=" + point.getY());
						robot.mouseMove((int) point.getX(), (int) point.getY());
//                robot.mouseMove((int) point.getX() +50, (int) point.getY() + 50);

                        // 移动鼠标
						if(status==0){
							robot.mouseMove(getValue(t1x),getValue(t1y));

						}else if (status ==1){
							robot.mouseMove(getValue(t2x),getValue(t2y));

						}else if(status == 2){
							robot.mouseMove(getValue(t3x),getValue(t3y));
						}else if(status == 3){
							robot.mouseMove(getValue(t4x),getValue(t4y));
						}else if(status == 4){
                            robot.mouseMove(getValue(t5x),getValue(t5y));
                        }else if(status == 5){
                            robot.mouseMove(getValue(t6x),getValue(t6y));
                        }else if(status == 6){
                            robot.mouseMove(getValue(t7x),getValue(t7y));
                        }
						else{
							robot.mouseMove(getValue(t8x),getValue(t8y));
						}


						// 模拟鼠标按下左键
						robot.mousePress(InputEvent.BUTTON1_MASK);
						try {
							thread.sleep(5);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						// 模拟鼠标松开左键
						robot.mouseRelease(InputEvent.BUTTON1_MASK);


						// 滚轮
						if(status==0){
                            robot.mouseWheel(getValue(t1w));
						}else if (status ==1){
						    robot.mouseWheel(getValue(t2w));
						}else if(status == 2){
						    robot.mouseWheel(getValue(t3w));
						}else if(status == 3){
						    robot.mouseWheel(getValue(t4w));
						}else if(status == 4){
						    robot.mouseWheel(getValue(t5w));
                        }else if(status == 5){
						    robot.mouseWheel(getValue(t6w));
                        }else if(status == 6){
						    robot.mouseWheel(getValue(t7w));
                        }else{
						    robot.mouseWheel(getValue(t8w));
						}


						try {

							int sleep = 1000;

							switch (status) {
								case 0:
									sleep = getSleepTime(t1s);
									break;
								case 1:
									sleep = getSleepTime(t2s);
									break;
								case 2:
									sleep = getSleepTime(t3s);
									break;
								case 3:
									sleep = getSleepTime(t4s);
									break;
								case 4:
									sleep = getSleepTime(t5s);
									break;
                                case 5:
                                    sleep = getSleepTime(t6s);
                                    break;
                                case 6:
                                    sleep = getSleepTime(t7s);
                                    break;
                                case 7:
                                    sleep = getSleepTime(t8s);
                                    break;

							}


								thread.sleep(sleep);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

						status++;
						if(status>=8){
							status=0;
						}

						if(status==0){
							tTimes.setText(String.valueOf(getValue(tTimes)-1));
						}
					}else{
						ifRun =false;
					}



				}
			}


		}
	});

	public static int getSleepTime(JTextField t){
		int sleep = getValue(t);

		if(sleep==0){
			sleep = (getValue(tFreq)==0?1000:getValue(tFreq));
		}

		return sleep;
	}

	public static int getValue(JTextField t){
		int r = 0;
		String tValue = t.getText();
		if(null != tValue && !"".equals(tValue)){
			r = Integer.valueOf(tValue);
		}
		return r;
	}

	static volatile boolean ifRun = false;
	static volatile int status = 0;
	static volatile int count = 0;

}
