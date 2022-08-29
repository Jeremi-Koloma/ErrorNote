package com.myCompagny.ErrorNote.ErrorNote.Repositorys;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface RepositoryProfil extends JpaRepository<Profil, Long> {
    // Pour l'insertion Automatique du profil dans la base de donnée;
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO `profil` ( `profil`) VALUES ( 'Admin'), ( 'Utilisateur');",nativeQuery = true)
    void  insererProfil();
}
