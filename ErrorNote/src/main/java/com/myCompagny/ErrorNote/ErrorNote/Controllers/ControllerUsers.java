package com.myCompagny.ErrorNote.ErrorNote.Controllers;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Users;
import com.myCompagny.ErrorNote.ErrorNote.Services.ServiceUsers;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "hello", description = "Les fonctionnalités de mon API de ErroNote ")
@RestController // Identifier la classe comme un controller;
@RequestMapping("/users") // Donner un nom de path pour le mapping ou l'URL dans navifateur;
@AllArgsConstructor // un contructeurs avec tous les arguments pour l'injections de notre ServiceUsers;
public class ControllerUsers {
    //Injectons notre ServiceUsers pour les méthodes;
    private final ServiceUsers serviceUsers;

    //Controllers qui va créer les utilisateurs;
    // public EntityName, le nom de la méthode, puis (EntityName, aleas)
    @ApiOperation(value = "Ajouter un l'utilisateur")
    @PostMapping("/create") // pour une requête de type (POST);
    public Object create(@RequestBody Users users){ // @RequestBoby pour pouvoir envoyer les donnée de boby de postman dans la base de donnée;
        try {
            return serviceUsers.creer(users); // on retourne service.la méthode(creer)depuis serviceUsers pour créer l'utilisateur;
        }catch (DataIntegrityViolationException e){ // l'email est unique;
            return "Cet e-mail exite déja !";
        }

    }

    // Controller pour la méthode qui va Afficher tous les utilisateurs;
    @ApiOperation(value = "Afficher tous les utilisateurs")
    @GetMapping("/read") // pour une requête de type (GET);
    public List<Users> read(){
        return serviceUsers.lire();
    }

    // Controller pour la méthode qui va permettre à l'utilisateur de modifier son compte;
    @ApiOperation(value = "Modifier un utilisateur")
    @PutMapping("/update/{idUsers}") // pour une requête de type (PUT)
    public Users update(@PathVariable Long idUsers, @RequestBody Users users){
        return serviceUsers.modifier(idUsers, users);
    }

    // Controller pour la méthode qui va supprimer l'utilisateur;
    @ApiOperation(value = "Supprimer un utilisateur")
    @DeleteMapping("/delete/{idUsers}") // Pour une requête de type (Delete)
    public String delete(@PathVariable Long idUsers){
        return serviceUsers.supprimer(idUsers);
    }

}
