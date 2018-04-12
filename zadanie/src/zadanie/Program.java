package zadanie;
import java.util.ArrayList;
import java.util.Scanner;

 
 
public class Program {	
	public static boolean distinctValues(ArrayList<Produkty> produkty,int kod_kreskowy){

		 for (Produkty str : produkty)
		 {
			 if(str.getKod()==kod_kreskowy)
			 {
				 return true;			
			 }
		 }
	           
		 	return false;          
		}
		public static void main (String[] args)
		{
			int menu;
			int kod_kreskowy;
			boolean flaga;
			boolean flaga1=false;
			double suma_cen=0;
			
			System.out.println("Jakub Grodzicki - zadanie rekrutacyjne kwiecieñ 2018. \n"); //pierwsza linijka tekstu
//			tworzenie produktow
			Produkty produkt1 = new Produkty(578946214,"maslo",30.65);
			Produkty produkt2 = new Produkty(578946497,"ser",5.59);
			Produkty produkt3 = new Produkty(571486214,"mieso",99.73);
			Produkty produkt4 = new Produkty(984946214,"woda",21.15);

			ArrayList<Produkty> produkty = new ArrayList<Produkty>();
			ArrayList<Produkty> zeskanowane = new ArrayList<Produkty>();
			Scanner input = new Scanner(System.in);			
//			dodawanie produktow do arraylist
			produkty.add(produkt1);
			produkty.add(produkt2);
			produkty.add(produkt3);
			produkty.add(produkt4);

//			wypisanie dostepnych kodow w celu poprawnego wprowadzenia do konsoli
			for (Produkty str : produkty) 
			 {	 
					 System.out.println("Kod: " + str.getKod());
			 }

			System.out.println("Menu:\n [1] zeskanowanie kodu ");
			
			do{
				menu = input.nextInt();
				
				switch(menu)
				{
				case 0:
					if(flaga1==false)
					{
					System.out.println("Koniec programu");
					}
					else
					{
						System.out.println("Paragon:");
						for(Produkty temp: zeskanowane)
						 {
							 System.out.println(temp.getKod()+" "+temp.getNazwa()+" "+temp.getCena()+" zl");
						 }
						System.out.format("Laczna wartosc paragonu: %.2f zl ",suma_cen);
					}
					break;
					
				case 1:
					System.out.println("Zeskanuj kod kreskowy / podaj wartosc liczbowa kodu:\n");
					kod_kreskowy=input.nextInt(); //trzeba podac wartosc liczbowa z zakresu int
					
					flaga=distinctValues(produkty,kod_kreskowy);
					if(flaga==true)
					{
						 for (Produkty str : produkty) //sprzawdzenie czy kod jest w bazie
						 {
							 if(str.getKod()==kod_kreskowy) //sprawdzenie czy jest podany kod
							 {
								 flaga1=true;
								 zeskanowane.add(str);
								 suma_cen=suma_cen+str.getCena();
								 
								 for(Produkty temp: zeskanowane)
								 {
									 System.out.println(temp.getKod()+" "+temp.getNazwa()+" "+temp.getCena());
								 } 
							 }
						 }
					}
					else
					{
						System.out.println("Product not found");
					}

					System.out.println("Menu:\n [1] zeskanowanie kodu \n [0] koniec programu");
					break;
					
				default:
					System.out.println("zla wartosc, wprowadz jeszcze raz");	
					break;
				}
			}
			while(menu !=0);			
		}
}
