package com.myCompagny.ErrorNote.ErrorNote.Controllers;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Users;
import com.myCompagny.ErrorNote.ErrorNote.Services.ServiceUsers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ControllerUsersTest {
    @Autowired
    ServiceUsers serviceUsers;

    @Test
    void create() {
        Users u1= new Users("fatoumata","dembele","fatim","fatim","fatou@gmail.com","num2");
        serviceUsers.creer(u1);
    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}