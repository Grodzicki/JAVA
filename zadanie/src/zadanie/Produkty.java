package zadanie;

public class Produkty {

		private int kod;
		private String nazwa;
		private double cena;
		
 
		/**
		 * @param kod
		 * @param nazwa
		 * @param cena
		 */
		public Produkty(int kod, String nazwa, double cena) {
			this.kod = kod;
			this.nazwa = nazwa;
			this.cena = cena;
		}

		public int getKod() {
			return kod;
		}

		public void setKod(int kod) {
			this.kod = kod;
		}

		public String getNazwa() {
			return nazwa;
		}

		public void setNazwa(String nazwa) {
			this.nazwa = nazwa;
		}

		public double getCena() {
			return cena;
		}

		public void setCena(double cena) {
			this.cena = cena;
		}




}