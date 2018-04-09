import liceum28.*;
import java.util.Random;
import java.awt.*;
import java.applet.*;

public class lesnik extends Applet
{double h=1.5,pf=0.27;
pkt2d A=new pkt2d(0,-4);
int pom_h=1,pom_fi;
Random r=new Random();

public void init()
   {    
	      lo28.init(getSize());
          setBackground(lo28.tlo);  // lub jakikolwiek inny kolor
   }
//-------------------------------
void drzewo(Graphics g,pkt2d w,double fi,int wiek)
{pkt2d nw=new pkt2d(0,0);

	wiek--;
	if(wiek>0)
	{
		pom_h=r.nextInt(31);
		h=pom_h/10;
		nw.x=w.x+h*Math.cos(fi);
		nw.y=w.y+h*Math.sin(fi);
		lo28.linia(g,w,nw);
		drzewo(g,nw,fi-pf,wiek);
		drzewo(g,nw,fi+pf,wiek);
		
		if(wiek==1)
			{
				lo28.kropka(g,nw,Color.green);
			}
	}
	
}
//--------------------------------
	public void paint(Graphics g)
	{
		drzewo(g,A,Math.PI/2,7);
	}
}	