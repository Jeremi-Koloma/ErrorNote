package com.myCompagny.ErrorNote.ErrorNote.Modeles;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PROFIL")
@NoArgsConstructor
@Getter
@Setter
public class Profil {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String profil;
}
