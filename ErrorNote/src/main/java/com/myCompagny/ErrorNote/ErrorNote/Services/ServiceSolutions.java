package com.myCompagny.ErrorNote.ErrorNote.Services;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Problemes;
import com.myCompagny.ErrorNote.ErrorNote.Modeles.Solutions;

import java.util.List;

public interface ServiceSolutions {
    // Definissons les 02 méthode de la Solutions;

    // Reserver pour l'Admin et l'Utilisateur;
    // Une méthode qui va retourner une Solution pour la créer;
    Solutions creer (Solutions solutions);

    // Reserver pour l'Admin et le Visiteurs;
    // Une méthode qui va retourner une liste des Solutions trouvées;
    List<Solutions> lire();

    // méthode qui va modifier une Solution;
    Solutions modifier(Long idSolutions, Solutions solutions);

    // Une méthode qui va Supprimer une Solutions
    String supprimer(Long idSolutions);

    // Donner une solution par probleme;
    Solutions donnerSolutionParProbleme(Problemes problemes);

    //
    Object solution(Long idSolutions);

}
