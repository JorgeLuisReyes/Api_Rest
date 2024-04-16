package com.sybven.jwt.token.repositories;

import com.sybven.jwt.token.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    List<User> findByNombre(String nombre);
    
}
