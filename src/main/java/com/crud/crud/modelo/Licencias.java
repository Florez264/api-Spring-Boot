package com.crud.crud.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "licencias")
@Data
@Getter
@Setter
@NoArgsConstructor
public class Licencias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long licenciaid;

    private String nombre_licencia;
    private String estado;
    private Date fecha_inicio;
    private Date fecha_finalizacion;
    private String proveedor;
    private  String empresa_matriz;

    @ManyToOne
    @JoinColumn(name = "funcionarioid")
    @JsonIgnore
    private Funcionarios funcionarios;

    public Licencias(Long licenciaid, String nombre_licencia, String estado, Date fecha_inicio, Date fecha_finalizacion, String proveedor, String empresa_matriz) {
        this.licenciaid = licenciaid;
        this.nombre_licencia = nombre_licencia;
        this.estado = estado;
        this.fecha_inicio = fecha_inicio;
        this.fecha_finalizacion = fecha_finalizacion;
        this.proveedor = proveedor;
        this.empresa_matriz = empresa_matriz;
    }
}
