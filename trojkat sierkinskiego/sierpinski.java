import liceum28.*;
import java.awt.*;
import java.applet.*;

public class sierpinski extends Applet
{double a=12,h=0.5*a*Math.sqrt(3);
 pkt2d A=new pkt2d (-a/2,-h/3);
 pkt2d B=new pkt2d (a/2,-h/3);
 pkt2d C=new pkt2d (0,2*h/3);


public void init()
   {    
	      lo28.init(getSize());
          setBackground(lo28.tlo);  // lub jakikolwiek inny kolor
   }
//------------------------------------
void tr(Graphics g,pkt2d x,pkt2d y,pkt2d z)
{
	lo28.linia(g,x,y);
	lo28.linia(g,y,z);
	lo28.linia(g,z,x);
}
//------------------------------------
pkt2d sr(pkt2d p,pkt2d k)
{
	return new pkt2d(0.5*(p.x+k.x),0.5*(p.y+k.y));
}
//------------------------------------
void tr_s(Graphics g,pkt2d a,pkt2d b,pkt2d c,int st)
{pkt2d sa,sb,sc;
	if (st>0)
	{
		sa=sr(a,b);
		sb=sr(b,c);
		sc=sr(c,a);
		tr(g,sa,sb,sc);
		
		tr_s(g,sa,b,sb,st-1);
		tr_s(g,sb,c,sc,st-1);
		tr_s(g,sa,a,sc,st-1);
	}
}
//------------------------
public void paint(Graphics g)
	{
		tr(g,A,B,C);
		tr_s(g,A,B,C,4);
		
	}
}	