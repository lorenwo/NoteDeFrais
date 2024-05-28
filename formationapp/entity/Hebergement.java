package com.example.formationapp.entity;
import java.time.LocalDate;

public class Hebergement extends NoteDeFrais {
	
	    public static final int getDistance = 0;
		private int distance;

	    public Hebergement(LocalDate date, double montant, int distance) {
	        super(date,montant,"Note de frais hebergement");
	        this.distance = distance;
	    }

	    // Getters et setters`
	    public void setDistance(int distance) {
			this.distance = distance;
		}
		public int getDistance() {
			return distance;
		}
	    
		@Override
		public String toString() {
		
			String resultat = "" ;
			
			resultat += "\nVille : " + distance ;
			
			return resultat ;
		}
}


	    


