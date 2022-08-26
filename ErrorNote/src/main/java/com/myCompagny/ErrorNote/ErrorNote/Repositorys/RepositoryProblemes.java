package com.myCompagny.ErrorNote.ErrorNote.Repositorys;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Problemes;
import org.springframework.data.jpa.repository.JpaRepository;

// Cette classe va etendre de l'interface JPA Repository avec <Entity name, Long>
public interface RepositoryProblemes extends JpaRepository<Problemes, Long> {

}
