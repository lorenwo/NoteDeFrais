package com.example.formationapp.entity;

import java.time.LocalDate;



public abstract class NoteDeFrais {
    private LocalDate date;
    private double montant;
    private String details;

    public NoteDeFrais(LocalDate date, double montant, String details) {
        this.date = date;
        this.montant = montant;
        this.details = details;
    }
    
    public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalDate getDate() {
		return date;
	}
	
	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	public double getMontant() {
		return montant;
	}
	 @Override
		public String toString() {
		
			String resultat = "" ;
			
			resultat += "\nVille de départ : " + date ;
			resultat += "\nVille d'arrivée : " + montant ;
			resultat += "\nNom du client : " + details ;
			
			return resultat ;
		}
    
}