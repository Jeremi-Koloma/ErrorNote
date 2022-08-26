package com.myCompagny.ErrorNote.ErrorNote.Repositorys;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Commentaires;
import org.springframework.data.jpa.repository.JpaRepository;

// cette classe etends de l'interface JPA Repository avec <Entity name, Long>
public interface RepositoryCommentaires extends JpaRepository<Commentaires, Long> {

}
