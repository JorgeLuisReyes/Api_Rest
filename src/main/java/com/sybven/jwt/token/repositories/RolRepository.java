package com.sybven.jwt.token.repositories;

import com.sybven.jwt.token.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{
    
    Rol findByNombreIgnoreCase(String nombre);
}
