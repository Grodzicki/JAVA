import liceum28.*;
import java.awt.*;
import java.applet.*;

public class arty extends Applet
{
pkt2d p=new pkt2d(-5,-7);
pkt2d k=new pkt2d(4,-1);
pkt2d cel=new pkt2d(1,2);

Image strona;
Graphics g_strony;

  
   public void init()
   {    
	      lo28.init(getSize());
          setBackground(lo28.tlo);  // lub jakikolwiek inny kolor

          strona=createImage(getWidth(),getHeight());  
          g_strony=strona.getGraphics(); 
          				
	}
	
double  odl(pkt2d a,pkt2d b)
{
return Math.sqrt(Math.pow(b.x-a.x,2)+Math.pow(b.y-a.y,2));
}

void  ruch(Graphics g)
{double fi2=Math.atan((cel.y-k.y)/(cel.x-k.x));

double fi1=Math.atan((cel.y-p.y)/(cel.x-p.x));
 
 
 if(cel.x-p.x<0)fi1+=3.1415926535;
 if(cel.x-k.x<0)fi2+=3.1415926535;

  double v=0.01; 
   
 pkt2d w=new pkt2d(p.x,p.y);
 
 pkt2d w2=new pkt2d(k.x,k.y);
 
 double v2=(odl(k,cel)/odl(p,cel))*v;

    while(odl(w,cel)>v)
   {

	   w.x+=v*Math.cos(fi1);
	   w.y+=v*Math.sin(fi1);
	   
	   w2.x+=v2*Math.cos(fi2);
	   w2.y+=v2*Math.sin(fi2);

      lo28.czysc(g_strony,lo28.tlo);              //mapê bitow¹
        
   lo28.wspolrzedne(g_strony,p,"punkt startu celu");
   lo28.wspolrzedne(g_strony,k,"dzialo");
   lo28.wspolrzedne(g_strony,cel,"punkt spotkania");
   
	  g_strony.setColor(Color.blue); lo28.okrag(g_strony,w,0.2); lo28.okrag(g_strony,w2,0.2);
	  g.drawImage(strona,0,0,this);
   }
   
}
     public boolean mouseDown(Event zd, int x, int y)
   {
        cel=lo28.r2(x,y);
	     repaint();
	   
	  return true;
   }
   
     public boolean mouseDrag(Event zd, int x, int y)
   {
      cel=lo28.r2(x,y);
	   repaint();
	   
	  return true;
   }

	 public void paint(Graphics g)
	{
	    ruch(g);
	}
}