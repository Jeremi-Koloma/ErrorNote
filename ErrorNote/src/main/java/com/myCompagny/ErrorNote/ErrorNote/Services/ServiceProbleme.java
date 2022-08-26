package com.myCompagny.ErrorNote.ErrorNote.Services;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Problemes;

import java.util.List;

public interface ServiceProbleme {
    // Définissons les méthode ou fonctionnalité de probleme;

    // Reserver pour l'Admin et le l'Utlisatuer;
    // Une méthode qui va retourner un probleme pour le Creer;
    Problemes creer(Problemes problemes);

    // Une méthode qui va retourner une liste de problibleme pour Afficher tous les problemes créer;
    // Reserver pour l'Admin et le Visiteurs;
    List<Problemes> lire();

    // La méthode qui va nous permetre de faire des recherches par mot clé
    Object search(String motCle);
}
