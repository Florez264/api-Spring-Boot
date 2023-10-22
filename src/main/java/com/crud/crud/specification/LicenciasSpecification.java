package com.crud.crud.specification;

import org.springframework.data.jpa.domain.Specification;

import com.crud.crud.modelo.Funcionarios;
import com.crud.crud.modelo.Licencias;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;

public class LicenciasSpecification {
    
    public static Specification<Licencias> licenciaPorFuncionario(Funcionarios funcionarios){
        return (root, query, cb) -> cb.equal(root.get("funcionarios"), funcionarios); 
    }

    public static  Specification<Licencias> porNombreLicencia(String nombreLicencia){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("nombre_licencia"), nombreLicencia);
    }

    public static  Specification<Licencias> estadoVencido(){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("estado"),"vencido");
    }

    public static Specification<Funcionarios> masDedosLicencias(){
        return (root, query, cb) ->{
            query.distinct(true);
            Join<Funcionarios, Licencias> JoLicencias = root.join("licencias");
            query.groupBy(root.get("funcionarioid"));

            query.having(cb.greaterThan(cb.count(JoLicencias), 2L));

            //Predicate masdedosLicencia = cb.greaterThan(cb.count(JoLicenciasJoin),Long.valueOf(2));

           // query.groupBy(root.get("funcionarioid"));
            return null;
        };
    }

}
