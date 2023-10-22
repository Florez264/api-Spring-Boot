package com.crud.crud.controller;

import com.crud.crud.modelo.Licencias;
import com.crud.crud.repository.ILicenciaRepository;
import com.crud.crud.specification.LicenciasSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/licencias")
public class LicenciaControllers {

    @Autowired
    private ILicenciaRepository iLicenciaRepository;


    @GetMapping("/mostrar")
    public List<Licencias> getMostrar(){
        return iLicenciaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Licencias getObtenerPorID(@PathVariable Long id){

        return iLicenciaRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Licencias getAgregar(@RequestBody Licencias licencias){
        return iLicenciaRepository.save(licencias);
    }

    @PutMapping("/{id}")
    public Licencias getActualizar(@PathVariable Long id, @RequestBody Licencias licencias){
        if(iLicenciaRepository.existsById(id)){
            licencias.setLicenciaid(id);
            return iLicenciaRepository.save(licencias);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void setEliminar(@PathVariable Long id){
        iLicenciaRepository.deleteById(id);

    }

    @GetMapping("/")
    public List<Licencias> buscarLicenciaPorNombre(@RequestParam String nombreLicencia){
        return iLicenciaRepository.findAll(LicenciasSpecification.porNombreLicencia(nombreLicencia));
    }

    @GetMapping("/vencidas")
    public List<Licencias> obtenerLicenciaPorEstado(){
        Specification<Licencias> especificacion = LicenciasSpecification.estadoVencido();
        return iLicenciaRepository.findAll(especificacion);
    }
}
