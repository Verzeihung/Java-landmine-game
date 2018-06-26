import javax.swing.JButton;

public class Excalibur extends JButton{
	private boolean boom;
	private int p;
	private int g;
	public void Excalibur(){
		boom=false;
		p=0;
		g=0;
	}
	public void isnnot(boolean boom){
		this.boom=boom;
	}
	public boolean isnnot(){
		return boom;
	}
	public void Point(int p){
		this.p=p;
	}
	public int Point(){
		return p;
	}
	public void JUDGEMENT(int g){
		if(g==0)this.g=1;
		if(g==1)this.g=2;
		if(g==2)this.g=0;
	}
	public int JUDGEMENT(){
		return g;
	}
}
