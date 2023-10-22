package com.crud.crud.repository;

import com.crud.crud.modelo.Licencias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ILicenciaRepository extends JpaRepository<Licencias, Long>, JpaSpecificationExecutor <Licencias> {
}
