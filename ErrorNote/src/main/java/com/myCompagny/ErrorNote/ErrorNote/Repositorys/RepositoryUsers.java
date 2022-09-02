package com.myCompagny.ErrorNote.ErrorNote.Repositorys;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

// Cette classe va Etendre de JPA Repository avec <Entity name> Long
public interface RepositoryUsers extends JpaRepository<Users, Long> {
    // Se loger;
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO `users` (`id_users`, `email`, `nom`, `numero`, `password`, `prenom`, `id_profil`) VALUES (1, 'fantisca747@gmail.com', 'Dembele', 'num1', 'fatoumata', 'Fatou', '1');", nativeQuery = true)
    Void insertadmin() ;

    @Query(value = "SELECT * FROM `users` WHERE users.password=? AND users.email=?;",nativeQuery = true)
    Users login(String password, String email);

    // Chercher par Email déja enregistré;
    Users findByEmail(String email);





}
