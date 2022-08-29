package com.myCompagny.ErrorNote.ErrorNote.Services;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Users;

import java.util.List;

public interface ServiceUsers {
    // On créer nos 03 méthodes de l'utilisateurs Les méthodes (CRD);

    // Reserver pour l'Admin et l'Utilisateur;
    // Une méthode qui va retournner un Objet d'utilisateur;
    Object creer (Users users);

    // Une méthode qui va retourner une liste d'utilisateurs
    // Reservez pour l'Admin;
    List<Users> lire();

    // Reservez pour l'Utilisateur;
    // Une méthode qui va permettre à l'utilisateur de modifier son compte;
    Users modifier(Long idUsers, Users users);

    // Une méthode qui va retourner un String pour Supprimer l'utilisateur; avec l'Id de l'utilisateur;
    // Reservez pour l'Admin;
    String supprimer(Long idUsers);

}
