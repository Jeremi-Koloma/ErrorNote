package com.myCompagny.ErrorNote.ErrorNote.Repositorys;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Problemes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Cette classe va etendre de l'interface JPA Repository avec <Entity name, Long>
public interface RepositoryProblemes extends JpaRepository<Problemes, Long> {
    @Query(value = "SELECT * FROM problemes WHERE problemes.titre_problemes LIKE %?1%"
            + "OR problemes.description_problemes LIKE %?1%",nativeQuery = true)
    // On retourne une liste de probleme avec le mot clé;
    List<Problemes> findAll(String motCle);
}
