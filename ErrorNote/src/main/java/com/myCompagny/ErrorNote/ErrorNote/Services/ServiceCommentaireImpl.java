package com.myCompagny.ErrorNote.ErrorNote.Services;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Commentaires;
import com.myCompagny.ErrorNote.ErrorNote.Repositorys.RepositoryCommentaires;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// Cette classe va implementer l'interface de ServiceCommentaire;
@Service // Identifier la classe comme étant un service métiers;
@AllArgsConstructor // Un contructeur avec tous les arguments pour l'injections de notre RepositoryCOmmentaire;
public class ServiceCommentaireImpl implements ServiceCommentaire{
    // on Implémentes les méthodes déjà créer dans l'interface Commentaire;

    // Injectons notre RepositoryCommentaires;
    private final RepositoryCommentaires repositoryCommentaires;

    // Reserver pour l'Admin et l'Utilisateur;
    @Override // implémentations de la méthode qui va creér un commentaire;
    public Commentaires creer(Commentaires commentaires) { // retourner la repository.la méthode (save) pour la persistance des donnée dans la base de donéé
        return repositoryCommentaires.save(commentaires);
    }

    // Reserver pour l'Admin et le Visiteurs;
    @Override // implementation de la méthode qui va modifier le commentaire;
    public List<Commentaires> lire() { // on retourne repository.la méthode(findAll) pour afficher tous les commentaires;
        return repositoryCommentaires.findAll();
    }

    // Reserver pour l'Utilisateur;
    @Override // implementation de la méthode qui va modifier le commentaire;
    public Commentaires modifier(Long idCommentaires, Commentaires commentaires) {
        return repositoryCommentaires.findById(idCommentaires) // Cherchons le commentaire id si on trouve;
                .map(c->{ // Si on trouve on fait le mappage;
                    c.setCommentaires(commentaires.getCommentaires()); // on modifie le commentaire;
                    return repositoryCommentaires.save(c); // On l'Enregistre dans la base de donnée;
                }).orElseThrow(()-> new RuntimeException("Commentaire non trouvé !"));
    }

    // Reserver pour l'Admin et l'Utilisateur;
    @Override // implementations de la méthode qui va Supprimer un commentaire;
    public String supprimer(Long idCommentaires) { // on retourne repository.la méthode(deleteById) pour supprimer le commentaire;
        repositoryCommentaires.deleteById(idCommentaires);
        return "Commentaire Supprimer !";
    }
}
