import liceum28.*;
import java.awt.*;
import java.applet.*;

public class animacja_mapa extends Applet implements Runnable
{pkt2d A=new pkt2d(-5,-3);
 pkt2d B=new pkt2d(6,-1);
 pkt2d C=new pkt2d(2,4);
 pkt2d C1=new pkt2d(2,4);
 pkt2d v=_2d.wektor(A,B);
 double t=0,dt=0.01;
 Thread animacja;
 boolean ruch=true,aktywna=true;
 Image strona,srodki;
 Graphics g_strony,gs;
 
 public void init()
   	{    
	   	lo28.init(getSize());
         setBackground(lo28.tlo);
         
         strona=createImage(getWidth(),getHeight());  
         g_strony=strona.getGraphics();
         
         srodki=createImage(getWidth(),getHeight());  
         gs=srodki.getGraphics();
   	}

 public void start()
		{
			animacja=new Thread(this);
			animacja.start();	
		}
	
 public void stop()
		{
			ruch=false;	
		}
	
 public void run()
		{
			while(ruch)
				{
               t+=dt;
               if(Math.abs(t)>2)
               	dt*=-1;
	            C.war(C1.x+t*v.x,C1.y+t*v.y);
	            repaint();
	            	            
	            try
	            	{
			            Thread.sleep(5);
						}
			      catch(InterruptedException e)
			      	{}	
				}
		}
 
void trojkat(Graphics g,pkt2d a,pkt2d b,pkt2d c)
		{
			g.setColor(Color.black);
			lo28.linia(g,a,b);
			lo28.linia(g,a,c);
			lo28.linia(g,c,b);
			lo28.wspolrzedne(g,a,"A");
			lo28.wspolrzedne(g,b,"B");
			lo28.wspolrzedne(g,c,"C");
		}
	
	void zadanie(Graphics g)
		{pkt2d A1=_2d.suma(A,_2d.WD(B,A,C));
		 pkt2d B1=_2d.suma(B,_2d.WD(A,B,C));
		 pkt2d s=_2d.wspolny(A,A1,B,B1);
		 pkt2d s1=_2d.wspolny(A,B,s,_2d.suma(s,_2d.w_pr(A,B)));
		 double r=_2d.dl(_2d.wektor(s,s1));
		 
			trojkat(g,A,B,C);
			lo28.przerywana(g);
			_2d.prosta(g,C,_2d.suma(C1,_2d.wektor(A,B)));
			g.setColor(Color.gray);
			_2d.dw(g,B,A,C);
			_2d.dw(g,A,B,C);
			_2d.dw(g,A,C,B);
			lo28.ciagla(g,1);
			lo28.wspolrzedne(g,s,"S");
			lo28.punkt_(gs,s);
			g.setColor(Color.green);
			//pr_pr(g,s,A,B);
			lo28.oznacz(g,s1,"S1");
			_2d.odcinek(g,s,s1);
			lo28.okrag(g,s,r);
		}
	
	public void update(Graphics g)
   	{
	   	paint(g);
   	}
	
	public void paint(Graphics g)
	{
		lo28.uklad(g);
		//lo28.czysc(g_strony,lo28.tlo);
		g_strony.drawImage(srodki,0,0,this);
		zadanie(g_strony);
		g.drawImage(strona,0,0,this);
	}
}