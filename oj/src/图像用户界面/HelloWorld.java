package ͼ���û�����;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainWind w=new MainWind();
		w.repaint();
	}

}
class MainWind extends JFrame{
	public MainWind() {
		setTitle("ͼ���û�������ʾ����");
		setSize(460,300);
		setLocation(100,100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void paint(Graphics g) {
		super.paint(g);
		
		Font ef=new Font("TimeRoman",Font.PLAIN,16);
		g.setFont(ef);
		g.drawString("��ã�����", 8, 50);
		Font cf=new Font("����",Font.PLAIN,24);
		g.setFont(cf);
		g.setColor(Color.black);
		g.fillRect(10, 50, 10, 10);
		g.setColor(Color.RED);
		g.drawRect(10, 50, 10, 10);
	}
}