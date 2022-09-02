package com.myCompagny.ErrorNote.ErrorNote.Repositorys;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

// Cette classe va Etendre de JPA Repository avec <Entity name> Long
public interface RepositoryUsers extends JpaRepository<Users, Long> {
    // Se loger;
    @Query(value = "SELECT * FROM `users` WHERE users.password=? AND users.email=?;",nativeQuery = true)
    Users login(String password, String email);

    // Chercher par Email déja enregistré;
    Users findByEmail(String email);

    // Création automatique de l'Admin
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO `users` (`email`, `nom`, `numero`, `password`, `prenom`, `id_profil`) VALUES ('kolomajeremi60@gmail.com', 'KOLOMA', '73230609', '123', 'Jeremi', 1);",nativeQuery = true)
    void createAdmin();
}
