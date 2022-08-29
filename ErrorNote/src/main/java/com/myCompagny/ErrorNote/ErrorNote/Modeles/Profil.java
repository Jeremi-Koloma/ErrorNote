package com.myCompagny.ErrorNote.ErrorNote.Modeles;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.persistence.*;

@Entity
@Table(name = "PROFIL")
@NoArgsConstructor
@Data
public class Profil {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String profil;
    public Profil(long id){
        this.id=id;
    }
}
