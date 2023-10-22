package com.crud.crud.controller;

import com.crud.crud.modelo.Funcionarios;
import com.crud.crud.modelo.Licencias;
import com.crud.crud.repository.IFuncionarioRepository;
import com.crud.crud.repository.ILicenciaRepository;
import com.crud.crud.specification.LicenciasSpecification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioControllers {

    @Autowired
    private IFuncionarioRepository funcionarioRepository;

    @Autowired
    private ILicenciaRepository iLicenciaRepository;


    @GetMapping
    public List<Funcionarios> getObtener(){
        return funcionarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Funcionarios ObtenerpoID(@PathVariable Long id){
        return funcionarioRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Funcionarios Agregar(@RequestBody Funcionarios funcionarios){
        return funcionarioRepository.save(funcionarios);
    }

    @PutMapping("/{id}")
    public Funcionarios ActualizarFunci(@PathVariable Long id, @RequestBody Funcionarios funcionarios){
        if (funcionarioRepository.existsById(id)){
            funcionarios.setFuncionarioid(id);

            return funcionarioRepository.save(funcionarios);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void EliminarFuncionario(@PathVariable Long id){
        funcionarioRepository.deleteById(id);
    }

    @GetMapping("/{id}/licencias")
    public List<Licencias> liceciasPorFuncionario(@PathVariable Long id){
        Funcionarios funcionarios = null;
        try {
            funcionarios = funcionarioRepository.findById(id).orElseThrow(NotFoundException::new);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
        return iLicenciaRepository.findAll(LicenciasSpecification.licenciaPorFuncionario(funcionarios));
    }

    @GetMapping("/masdedoslicencias")
    public List<Funcionarios> getFuncionarioConMasDeDosLicencia(){
        return funcionarioRepository.findAll(LicenciasSpecification.masDedosLicencias());
    }
}
