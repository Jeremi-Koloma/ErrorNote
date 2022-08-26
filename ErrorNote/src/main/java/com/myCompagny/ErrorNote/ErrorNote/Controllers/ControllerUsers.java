package com.myCompagny.ErrorNote.ErrorNote.Controllers;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Users;
import com.myCompagny.ErrorNote.ErrorNote.Services.ServiceUsers;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Identifier la classe comme un controller;
@RequestMapping("/users") // Donner un nom de path pour le mapping ou l'URL dans navifateur;
@AllArgsConstructor // un contructeurs avec tous les arguments pour l'injections de notre ServiceUsers;
public class ControllerUsers {
    //Injectons notre ServiceUsers pour les méthodes;
    private final ServiceUsers serviceUsers;

    //Controllers qui va créer les utilisateurs;
    // public EntityName, le nom de la méthode, puis (EntityName, aleas)
    @PostMapping("/create") // pour une requête de type (POST);
    public Users create(@RequestBody Users users){ // @RequestBoby pour pouvoir envoyer les donnée de boby de postman dans la base de donnée;
        return serviceUsers.creer(users); // on retourne service.la méthode(creer)depuis serviceUsers pour créer l'utilisateur;
    }

    // Controller pour la méthode qui va Afficher tous les utilisateurs;
    @GetMapping("/read") // pour une requête de type (GET);
    public List<Users> read(){
        return serviceUsers.lire();
    }

    // Controller pour la méthode qui va permettre à l'utilisateur de modifier son compte;
    @PutMapping("/update/{idUsers}") // pour une requête de type (PUT)
    public Users update(@PathVariable Long idUsers, @RequestBody Users users){
        return serviceUsers.modifier(idUsers, users);
    }

    // Controller pour la méthode qui va supprimer l'utilisateur;
    @DeleteMapping("/delete/{idUsers}") // Pour une requête de type (Delete)
    public String delete(@PathVariable Long idUsers){
        return serviceUsers.supprimer(idUsers);
    }

}
