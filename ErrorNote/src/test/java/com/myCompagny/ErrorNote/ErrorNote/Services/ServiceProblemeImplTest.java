package com.myCompagny.ErrorNote.ErrorNote.Services;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Problemes;
import com.myCompagny.ErrorNote.ErrorNote.Modeles.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ServiceProblemeImplTest {
@Autowired
  ServiceProbleme serviceProbleme;
    @Test
    void creer() {
      Users u1= new Users(1L,"fatoumataa","dembele","fatim","fatim","fatoumata@gmail.com","num3");


      Problemes l=new Problemes("probleme","sdfe","sdree","sdsf",u1);
      serviceProbleme.creer(l,"fantisca747@gmail.com","fatoumata");
    }

    @Test
    void lire() {
      serviceProbleme.lire();
    }

    @Test
    void supprimer() {
    }

    @Test
    void modifier() {
      Users u1= new Users(1L,"fatoumataa","dembele","fatim","fatim","fatoumata@gmail.com","num3");

      Problemes l=new Problemes("probleme","description","technologie","en cours",u1);

      serviceProbleme.modifier(2L,l);
    }

    @Test
    void search() {
      serviceProbleme.search("description");
    }

    @Test
    void trouverProblemeParId() {
      serviceProbleme.trouverProblemeParId(2L);
    }
}