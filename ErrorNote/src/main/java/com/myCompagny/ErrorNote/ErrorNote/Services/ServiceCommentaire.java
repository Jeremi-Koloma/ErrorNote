package com.myCompagny.ErrorNote.ErrorNote.Services;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Commentaires;

import java.util.List;

public interface ServiceCommentaire {
    // Définissons nos 04 méthodes de commentaires (CRUD);

    // Une méthode qui va retourner un Entity Commentaire pour le créer
    // Reserver pour l'Admin et l'Utilisateur;
    Commentaires creer(Commentaires commentaires);

    // Une méthode qui va retourné une liste de commentaires pour Afficher tous les commentaires;
    // Reserver pour l'Admin et Visitor;
    List<Commentaires> lire();

    // Une méthode qui va retourné Entity Commentaire avec (id commentaire, et Entity commentaire) pour le modifier;
    // Reserver pour l'Admin et l'Utilisateur;
    Commentaires modifier(Long idCommentaires, Commentaires commentaires);

    // Une méthode qui va retourné un String, id du Commentaires, pour le supprimer;
    // Reserver pour l'Admin et l'Utilisateur;
    String supprimer(Long idCommentaires);
}
