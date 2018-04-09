package liceum28;   // plik znajduje sie w folderze 'liceum28'
import java.awt.*;
//========================================================== 
public class _2d  // nazwa pliku: _2d.java
{ 
public static pkt2d wektor(pkt2d p,pkt2d k)
   {
	   return new pkt2d(k.x-p.x,k.y-p.y);
   }
//---------------------------------------------------- 
public static double dl(pkt2d v)
 {
	 return Math.sqrt(Math.pow(v.x,2)+Math.pow(v.y,2));
 }
//----------------------------------------------------- 
public static double odl(pkt2d a,pkt2d b)
 {pkt2d v=wektor(a,b);
	 return Math.sqrt(Math.pow(v.x,2)+Math.pow(v.y,2));
 }
//----------------------------------------------------- 
public static pkt2d sk(double a,pkt2d v)
   {pkt2d aa=new pkt2d(a*v.x,a*v.y);

	  // v.war(a*v.x,a*v.y);
	   return aa;
   }
//----------------------------------------------------
public static pkt2d suma(pkt2d a,pkt2d b)
 {
	 return new pkt2d(a.x+b.x,a.y+b.y);
 }
//----------------------------------------------------
public static pkt2d WD(pkt2d X,pkt2d Y,pkt2d Z)
 {pkt2d a=wektor(Y,X);
  pkt2d b=wektor(Y,Z);
  pkt2d a_=sk(dl(b),a);
  pkt2d b_=sk(dl(a),b);
  return suma(a_,b_);
 }
//---------------------------------------------- 
public static void pr(Graphics g,pkt2d a,pkt2d b,double tp,double tk)
   {pkt2d v=wektor(a,b);
    pkt2d p=new pkt2d(a.x+tp*v.x,a.y+tp*v.y);
    pkt2d k=new pkt2d(a.x+tk*v.x,a.y+tk*v.y);
    lo28.linia(g,p,k);
   }
//-------------------------------------------------------   
public static void odcinek(Graphics g,pkt2d a,pkt2d b)
   {
	   pr(g,a,b,0,1);
   }
//---------------------------------------------------   
public static void prosta(Graphics g,pkt2d a,pkt2d b)
   {
	   pr(g,a,b,-2,2);
   }
//---------------------------------------------------
public static void polprosta(Graphics g,pkt2d a,pkt2d b)
   {
	   pr(g,a,b,0,2);
   }
//---------------------------------------------------
public static void dw(Graphics g,pkt2d X,pkt2d Y,pkt2d Z)
{pkt2d wd=WD(X,Y,Z);
 pkt2d yy=suma(Y,wd);
 
   polprosta(g,Y,yy);
}
//-----------------------------------------------------
public static double det(double a11,double a12,double a21,double a22)
{
  return (a11*a22-a21*a12);
}
//-----------------------------------------------------
public static pkt2d wspolny(pkt2d a,pkt2d b,pkt2d c,pkt2d d)
{pkt2d v1=wektor(a,b),v2=wektor(c,d);
 double d_=det(v1.x,-v2.x,v1.y,-v2.y);
 double dt=det(c.x-a.x,-v2.x, c.y-a.y,-v2.y);
 double t;
 if(d_!=0) t=dt/d_; else t=1;
 
 return new pkt2d(a.x+t*v1.x,a.y+t*v1.y);
}
//-----------------------------------------------------
public static pkt2d w_pr(pkt2d a,pkt2d b)
{pkt2d v=wektor(a,b);
  return new pkt2d(-v.y,v.x);
}
//------------------------------------------------
public static void pr_pr(Graphics g,pkt2d Z,pkt2d X,pkt2d Y)
{pkt2d Z1=suma(Z,w_pr(X,Y));
  
  prosta(g,Z,Z1);
}
//---------------------------------------------------------
       
}