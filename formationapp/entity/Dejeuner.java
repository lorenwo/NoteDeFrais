package com.example.formationapp.entity;


import com.example.formationapp.entity.NoteDeFrais;

import java.time.LocalDate;

import java.util.List;

class Dejeuner extends NoteDeFrais {
 
    private final List<String> inviter;
    private final String nomSociete;
    
    public Dejeuner(LocalDate date, double montant, List<String> inviter, String nomSociete) {
        super(date, montant, "Note de frais du déjeuner");
        this.inviter = inviter;
        this.nomSociete = nomSociete;
    }
    @Override
	public String toString() {
	
		String resultat = "" ;
		
		resultat += "\nListe d'inviter : " + inviter ;
		resultat += "\nNom de la société: " + nomSociete ;

		
		return resultat ;
	}
    
    
}
