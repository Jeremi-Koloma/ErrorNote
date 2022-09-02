package com.myCompagny.ErrorNote.ErrorNote.Services;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Problemes;
import com.myCompagny.ErrorNote.ErrorNote.Modeles.Solutions;
import com.myCompagny.ErrorNote.ErrorNote.Modeles.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ServiceSolutionsImplTest {
    @Autowired
    ServiceSolutions serviceSolutions;

    @Test
    void creer() {
        Users u1= new Users(1L,"fatoumataa","dembele","fatim","fatim","fatoumata@gmail.com","num3");

        Problemes l=new Problemes(2L,"probleme","description","technologie","en cours",u1);
        Solutions h=new Solutions("solution","la description","ressource","methode","estimation",l);
        serviceSolutions.creer(h,"fantisca747@gmail.com","fatoumata");

    }

    @Test
    void lire() {
        serviceSolutions.lire();
    }

    @Test
    void modifier() {
        Users u1= new Users(1L,"fatoumataa","dembele","fatim","fatim","fatoumata@gmail.com","num3");

        Problemes l=new Problemes(2L,"probleme","description","technologie","en cours",u1);
        Solutions h=new Solutions("solution","la description","ressource","methode","estimation",l);
      serviceSolutions.modifier(2L,h);

    }

    @Test
    void supprimer() {
    }

    @Test
    void donnerSolutionParProbleme() {
        Users u1= new Users(1L,"fatoumataa","dembele","fatim","fatim","fatoumata@gmail.com","num3");

        Problemes l=new Problemes(2L,"probleme","description","technologie","en cours",u1);
        serviceSolutions.donnerSolutionParProbleme(l);
    }

    @Test
    void solution() {
        serviceSolutions.solution(2L);
    }
}