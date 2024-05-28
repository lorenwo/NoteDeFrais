package com.example.formationapp.entity;


	import androidx.annotation.NonNull;

	import java.time.LocalDate;


	public class AvanceSurFrais extends NoteDeFrais{
		
		
		    private final String justificatif;

		    public AvanceSurFrais(double montant, LocalDate date, String justificatif) {
		        super(date,montant,"Avance sur frais");
		        this.justificatif = justificatif;
		    }
		    @NonNull
			@Override
			public String toString() {
			
				String resultat = "" ;
				
				resultat += "\nJustificatif : " + justificatif ;
				
				return resultat ;
			}
	}




