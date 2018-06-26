import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.annotation.processing.Messager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class CCSAD extends JFrame {

	private JPanel contentPane;
	private Excalibur [][] btn=new Excalibur[10][10];
	private Random random=new Random();
	private int count=10;
	private int p=0;

	public CCSAD() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		mntmNew.addActionListener(new ActionListener() {
			
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				contentPane.removeAll();
				newbtn();
				validate();
			}
		});
		
		JMenuItem mntmRemove = new JMenuItem("Remove");
		mnFile.add(mntmRemove);
		mntmRemove.addActionListener(new ActionListener() {
			
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				contentPane.removeAll();
				repaint();
			}
		});
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(10, 10, 0, 0));
		
		newbtn();
	}

	void newbtn(){
		p=0;
		for (int k = 0; k < btn.length; k++) {
			for (int k2 = 0; k2 < btn[k].length; k2++) {
				btn[k][k2]=new Excalibur();
				contentPane.add(btn[k][k2]);
				btn[k][k2].addMouseListener(new click());
			}
		}
		for (int i = 0; i < count; i++) {
			int x=0;int y=0;
			x=random.nextInt(10);y=random.nextInt(10);
			if(btn[x][y].isnnot())i--;
			else {btn[x][y].isnnot(true);}
		}
		for (int k = 0; k < btn.length; k++) {
			for (int k2 = 0; k2 < btn[k].length; k2++) {
				for (int i = -1; i < 2; i++) {
					for (int j = -1; j < 2; j++) {
						if(k+i>=0&&k2+j>=0&&k+i<10&&k2+j<10&&btn[k+i][k2+j].isnnot())btn[k][k2].Point(btn[k][k2].Point()+1);
					}
				}
			}
		}
	}
	
	private class click implements MouseListener{
		
		public void mouseClicked(MouseEvent e) {
			
		}
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			JButton tmp = (JButton)e.getSource();
			boolean flag=false;
			for (int k = 0; k < btn.length; k++) {
				for (int k2 = 0; k2 < btn[k].length; k2++) {
					if(tmp==btn[k][k2]){
						if(e.getButton()==MouseEvent.BUTTON1){ //左鍵
							System.out.println("(" + k + ", " + k2 + ")");
							flag = true;
							if(btn[k][k2].Point()>0){btn[k][k2].setText(""+btn[k][k2].Point());p++;btn[k][k2].setEnabled(false);}
							else {OpenZeroPoint(k, k2);btn[k][k2].setEnabled(false);}
							if(!btn[k][k2].isnnot()&&btn[k][k2].isEnabled())
							{
								if(p==(btn.length*btn[0].length)-count)JOptionPane.showMessageDialog(null,"炸彈拆完","恭喜通關！" ,JOptionPane.ERROR_MESSAGE);
							}
							if(btn[k][k2].isnnot())
							{
								JOptionPane.showMessageDialog(null,"地雷爆炸，請重新開始～","失敗！地雷總數量："+count,JOptionPane.ERROR_MESSAGE );
								contentPane.removeAll();
								newbtn();
								validate();
							}
							break;
						}
						if(e.getButton()==MouseEvent.BUTTON2){ //中鑑
							
						}
						if(e.getButton()==MouseEvent.BUTTON3&&btn[k][k2].isEnabled()){ //右鑑
							btn[k][k2].JUDGEMENT(btn[k][k2].JUDGEMENT());
							if(btn[k][k2].JUDGEMENT()==0)btn[k][k2].setText("");
							if(btn[k][k2].JUDGEMENT()==1)btn[k][k2].setText("flag");
							if(btn[k][k2].JUDGEMENT()==2)btn[k][k2].setText("?");
						}
					}
				}
				if(flag)break;
			}
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	void OpenZeroPoint(int k,int k2){
		for (int i = -1; i < 2 ; i++) {
			for (int j = -1; j < 2; j++) {
				if(k+i>=0&&k2+j>=0&&k+i<10&&k2+j<10&&btn[k][k2]!=btn[k+i][k2+j]&&btn[k+i][k2+j].isEnabled()){
					if(btn[k+i][k2+j].Point()!=0)
					{
						btn[k+i][k2+j].setEnabled(false);
						btn[k+i][k2+j].setText(""+btn[k+i][k2+j].Point());
						p++;
					}
					else
					{
						btn[k+i][k2+j].setEnabled(false);
						p++;
						OpenZeroPoint(k+i,k2+j);
					}
				}
			}
		}
	}

}
