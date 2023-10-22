package com.crud.crud.modelo;

import com.fasterxml.jackson.annotation.*;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "funcionarios")
@Data
@Getter
@Setter

@NoArgsConstructor
public class Funcionarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long funcionarioid;

    //@Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    @NotNull
    private String cargo;
    //@Column(nullable = false)
    @NotNull
    private String telefono;
    //@Column(nullable = false)
    @NotNull
    private String correo;
    //@Column(nullable = false)
    @NotNull
    private String oficina;

    @OneToMany(mappedBy = "funcionarios")
    @JsonIgnore
    private Set<Licencias> licencias;



    public Funcionarios(Long funcionarioid, String nombre, String cargo, String telefono, String correo, String oficina) {
        this.funcionarioid = funcionarioid;
        this.nombre = nombre;
        this.cargo = cargo;
        this.telefono = telefono;
        this.correo = correo;
        this.oficina = oficina;
    }
}
