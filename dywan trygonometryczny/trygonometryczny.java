import liceum28.*;
import java.awt.*;
import java.applet.*;

public class trygonometryczny extends Applet
{double mx, my;
int mr=200,mg=240,mb=180;


Image strona;
Graphics g_strony;
boolean narysowane=false;

public void init()
   {    
	      lo28.init(getSize());
          setBackground(lo28.tlo);  // lub jakikolwiek inny kolor
          mx=lo28.max_x();
          my=lo28.max_y();
          
          strona=createImage(getWidth(),getHeight());  
          g_strony=strona.getGraphics(); 
			 
   }
   

//------------------------------------------------
Color JakiKolor(pkt2d w)
   {float r,g,b;
	   
	   r=Math.max((float)Math.sin(w.x-w.y),0f);
	   g=Math.max((float)Math.cos(w.x+w.y),0f);	
	   b=Math.min((float)Math.abs(Math.sin(w.x)+Math.sin(w.y)),1f); 
	   
	   return new Color(r,g,b);  
   }
//---------------------------------------------   
void maluj(Graphics g)
   {pkt2d p=new pkt2d(0,0);
     for(p.x=-mx;p.x<mx;p.x+=0.05)
      for(p.y=-my;p.y<my;p.y+=0.05)
        {
	        g.setColor(JakiKolor(p));
	        lo28.punkt(g,p);
        }
        narysowane=true;
   }
//----------------------------------------------
public void paint(Graphics g)
	{
		if(narysowane) g.drawImage(strona,0,0,this);
	   	else 
	 		  {		
				maluj(g_strony);g.drawImage(strona,0,0,this);
	   	  }
	
		//maluj(g);
	}
}	
