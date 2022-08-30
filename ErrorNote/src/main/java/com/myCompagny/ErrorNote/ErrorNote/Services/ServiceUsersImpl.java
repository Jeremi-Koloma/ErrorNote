package com.myCompagny.ErrorNote.ErrorNote.Services;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Profil;
import com.myCompagny.ErrorNote.ErrorNote.Modeles.Users;
import com.myCompagny.ErrorNote.ErrorNote.Repositorys.RepositoryUsers;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

// Cette classe va implémenter l'interface de notre ServiceUsers;
@Service // Identifier la classe comme étant un service métiers;
@AllArgsConstructor // Un constructeur avec tout les Arguments pour l'injection de notre Repostiroy Users
public class ServiceUsersImpl implements ServiceUsers{
    // Les 03 méthodes implémenter;

    // Injectons notre RepositoryUsers;
    private final RepositoryUsers repositoryUsers;

    // Une fonction Criptage de mots de passe;
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    // Implementation de la méthode Créer l'utilisateur;
    @Override
    public Object creer(Users users) { // On retourne repository.la méthode (SAVE) pour la persistence des donnée dans la base de donéé;
       users.setProfil(new Profil(2)); // Redirection de user comme utilisateur;
        // Vérifier si le mots de passe sont conforme;
        if (users.getPassword().equals(users.getPwdConfirm())){
            users.setPassword(passwordEncoder().encode(users.getPassword())); // Crypter le password;
            repositoryUsers.save(users);
            return "Compte Créer avec Succès ! " + users.getPrenom();
        } else {
            return "Mots de passe non conforme !";
        }

    }

    // Reservez pour l'Admin;
    @Override // implementation de la méthode Afficher les users;
    public List<Users> lire() { // on retoune la méthode (findAll) pour pouvoir afficher tous utilisateurs;
        return repositoryUsers.findAll();
    }

    // Reservez pour l'Utilisateur;
    @Override // implementation de la méthode qui va permettre à l'utilisateur de modifier son compte;
    public Users modifier(Long idUsers, Users users) {
        return repositoryUsers.findById(idUsers) // Cherchons par l'id;
                .map(u->{ // si on trouve, on fait de mappage;
                    u.setNom(users.getNom());
                    u.setPrenom(users.getPrenom());
                    u.setPassword(users.getPassword());
                    u.setEmail(users.getEmail());
                    u.setNumero(users.getNumero());
                    return repositoryUsers.save(u);
                }).orElseThrow(()-> new RuntimeException("Utilisateur non trouvé !"));
    }

    // Reservez pour l'Admin;
    @Override // implementation de la méthode Supprimer;
    public String supprimer(Long idUsers) { // On repository. la (deleteById) pour supprimer l'utilisateur;
        repositoryUsers.deleteById(idUsers);
        return "Utilisateur Supprimer ✅ !";
    }

    @Override // implementation de la méthode se loger;
    public Object login(String password, String email) {
        Users newUser = repositoryUsers.findByEmail(email);
        // faire une correspondance de mots de passe;
        if (passwordEncoder().matches(password, newUser.getPassword())){
            return "Nom: " + newUser.getNom()+ "" +"\nPrénom: " +newUser.getPrenom() + "\nEmail: " +newUser.getEmail();
        }else {
            return "Mots de passe incorrect !";
        }
    }


}
