package com.crud.crud.repository;

import com.crud.crud.modelo.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IFuncionarioRepository extends JpaRepository<Funcionarios, Long>, JpaSpecificationExecutor <Funcionarios> {
}
