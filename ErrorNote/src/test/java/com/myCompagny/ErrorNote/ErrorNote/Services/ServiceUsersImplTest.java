package com.myCompagny.ErrorNote.ErrorNote.Services;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Users;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ServiceUsersImplTest {
  @Autowired
   ServiceUsers serviceUsers;
    @Test
    void passwordEncoder() {
    }

    @Test
    void creer() {
        Users u1= new Users("fatoumata","dembele","fatima","fatima","fatoumata@gmail.com","num3");
        serviceUsers.creer(u1);

    }

    @Test
    void lire() {
        List<Users> testuser = serviceUsers.lire();
        System.out.println(testuser);
    }

    @Test
    void modifier() {
        Users u1= new Users("fatoumata","dembele","fatima","fatima","fatoumata@gmail.com","num3");
      serviceUsers.modifier(1L,u1);
    }

    @Test
    void supprimer() {
    }

    @Test
    void login() {
        serviceUsers.login("fatima","fatoumata@gmail.com");
    }
}