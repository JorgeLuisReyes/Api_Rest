package com.sybven.jwt.token.services;

import com.sybven.jwt.token.model.User;
import com.sybven.jwt.token.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
    
    //Metodo para crear User
    public void crearUser(User user){
        userRepo.save(user);
    }

    //Metodo para listar los User en muestra BD
    public List<User> listarUser(){
        return userRepo.findAll();
    }
    
    //Metodo para buscar un User por un ID especifico
    public Optional<User> buscarPorId(Long id){
        return userRepo.findById(id);
    }
    
    //Metodo para actualizar User
    public void actualizarUser(User user){
        userRepo.save(user);
    }
    
    //Metodo para eliminar un User
    public void eliminarUserPorId(Long id){
        userRepo.deleteById(id);
    }
    
    //Metodos para buscar segun atributos
    public List<User> buscarPorNombre(String nombre){
        return userRepo.findByNombre(nombre);
    }
    
    
}
