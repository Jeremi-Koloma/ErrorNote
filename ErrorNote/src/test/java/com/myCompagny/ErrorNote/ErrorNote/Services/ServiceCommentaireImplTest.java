package com.myCompagny.ErrorNote.ErrorNote.Services;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Commentaires;
import com.myCompagny.ErrorNote.ErrorNote.Modeles.Problemes;
import com.myCompagny.ErrorNote.ErrorNote.Modeles.Solutions;
import com.myCompagny.ErrorNote.ErrorNote.Modeles.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ServiceCommentaireImplTest {
    @Autowired
    ServiceCommentaireImpl serviceCommentaire;

    @Test
    void creer() {
        Users u1= new Users(1L,"fatoumataaa","dembele","fatima","fatima","fatoumata@gmail.com","num3");
        Problemes l=new Problemes(2L,"probleme","description","technologie","en cours",u1);
        Solutions h=new Solutions(2L,"solution","la description","ressource","methode","estimation",l);
        Commentaires u=new Commentaires("commentaire",u1,h);
        serviceCommentaire.creer(u);
    }

    @Test
    void lire() {
        serviceCommentaire.lire();
    }

    @Test
    void modifier() {
        Users u1= new Users(1L,"fatoumataaa","dembele","fatima","fatima","fatoumata@gmail.com","num3");
        Problemes l=new Problemes(2L,"probleme","description","technologie","en cours",u1);
        Solutions h=new Solutions(2L,"solution","la description","ressource","methode","estimation",l);
        Commentaires u=new Commentaires("commen",u1,h);
        serviceCommentaire.modifier(1L,u);
    }

    @Test
    void supprimer() {
    }
}