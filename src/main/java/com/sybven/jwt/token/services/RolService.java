package com.sybven.jwt.token.services;

import com.sybven.jwt.token.dto.GenericDTO;
import com.sybven.jwt.token.dto.ResponseDTO;
import com.sybven.jwt.token.dto.RolDTO;
import com.sybven.jwt.token.model.Rol;
import com.sybven.jwt.token.repositories.RolRepository;
import com.sybven.jwt.token.util.EndPointCodeResponse;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {
    
    private RolRepository rolRepo;

    @Autowired
    public RolService(RolRepository rolRepo) {
        this.rolRepo = rolRepo;
    }
    
    //Metodo para crear rol
    @Transactional
    public ResponseDTO crearRol(RolDTO rolDTO) {

        ResponseDTO responseDTO = new ResponseDTO();

        Rol rolForName = rolRepo.findByNombreIgnoreCase(rolDTO.getNombre());

        if (rolForName != null) {
            GenericDTO genericDTO = new GenericDTO();
            genericDTO.setMessage("El rol ya existe.");
            EndPointCodeResponse enumResult = EndPointCodeResponse
                                                .getByCode(EndPointCodeResponse.E0400.toString());
            responseDTO.setCode(enumResult.getValue());
            responseDTO.setStatus(enumResult.getStatus());
            responseDTO.setMessages(new ArrayList<>(Arrays.asList(genericDTO)));
            return responseDTO;
        }
        
        Rol rolCreate = new Rol();
        rolCreate.setNombre(rolDTO.getNombre());
        rolRepo.save(rolCreate);

        EndPointCodeResponse enumResult = EndPointCodeResponse
                                            .getByCode(EndPointCodeResponse.E0201.toString());
        responseDTO.setCode(enumResult.getValue());
        responseDTO.setStatus(enumResult.getStatus());
        responseDTO.setData(rolCreate);
        return responseDTO;
    }

    //Metodo para listar los roles en muestra BD
    @Transactional
    public ResponseDTO listarRoles() {

        ResponseDTO responseDTO = new ResponseDTO();
        List<Rol> rol = rolRepo.findAll();
        
        EndPointCodeResponse enumResult = EndPointCodeResponse
                                            .getByCode(EndPointCodeResponse.E0200.toString());
        responseDTO.setCode(enumResult.getValue());
        responseDTO.setStatus(enumResult.getStatus());
        responseDTO.setData(rol);
        return responseDTO;
    }
    
    //Metodo para buscar un Rol por un ID especifico
    @Transactional
    public ResponseDTO buscarPorId(Long id) {

        ResponseDTO responseDTO = new ResponseDTO();
        
        if (id == null) {
            GenericDTO genericDTO = new GenericDTO();
            genericDTO.setMessage("id del rol no puede ser nulo.");

            EndPointCodeResponse enumResult = EndPointCodeResponse
                                                .getByCode(EndPointCodeResponse.E0400.toString());
            responseDTO.setCode(enumResult.getValue());
            responseDTO.setStatus(enumResult.getStatus());
            responseDTO.setMessages(new ArrayList<>(Arrays.asList(genericDTO)));
            return responseDTO;
        }
        
        Optional<Rol> rol = rolRepo.findById(id);
        
        if (!rol.isPresent()) {
            GenericDTO genericDTO = new GenericDTO();
            genericDTO.setMessage("El rol no existe.");
            EndPointCodeResponse enumResult = EndPointCodeResponse
                                                .getByCode(EndPointCodeResponse.E0400.toString());
            responseDTO.setCode(enumResult.getValue());
            responseDTO.setStatus(enumResult.getStatus());
            responseDTO.setMessages(new ArrayList<>(Arrays.asList(genericDTO)));
            return responseDTO;
        }
        
        RolDTO rolDTO = RolDTO.builder()
                .idRol(rol.get().getIdRol())
                .nombre(rol.get().getNombre())
                .build();
        
        EndPointCodeResponse enumResult = EndPointCodeResponse
                                            .getByCode(EndPointCodeResponse.E0200.toString());
        responseDTO.setCode(enumResult.getValue());
        responseDTO.setStatus(enumResult.getStatus());
        responseDTO.setData(rolDTO);
        return responseDTO;
    }

    //Metodo para actualizar Rol
    @Transactional
    public ResponseDTO actualizarRol(RolDTO rolDTO) {
        
        ResponseDTO responseDTO = new ResponseDTO();
        
        if (rolDTO.getIdRol() == null) {
            GenericDTO genericDTO = new GenericDTO();
            genericDTO.setMessage("El id del rol no puede ser nulo.");

            EndPointCodeResponse enumResult = EndPointCodeResponse
                                                .getByCode(EndPointCodeResponse.E0400.toString());
            responseDTO.setCode(enumResult.getValue());
            responseDTO.setStatus(enumResult.getStatus());
            responseDTO.setMessages(new ArrayList<>(Arrays.asList(genericDTO)));
            return responseDTO;
        }
        
        Optional<Rol> rolForId = rolRepo.findById(rolDTO.getIdRol());

        if (!rolForId.isPresent()) {
            GenericDTO genericDTO = new GenericDTO();
            genericDTO.setMessage("El rol no existe.");
            EndPointCodeResponse enumResult = EndPointCodeResponse
                                                .getByCode(EndPointCodeResponse.E0400.toString());
            responseDTO.setCode(enumResult.getValue());
            responseDTO.setStatus(enumResult.getStatus());
            responseDTO.setMessages(new ArrayList<>(Arrays.asList(genericDTO)));
            return responseDTO;
        }
        
        Rol rolForName = rolRepo.findByNombreIgnoreCase(rolDTO.getNombre());
        
        if (rolForName != null) {
            GenericDTO genericDTO = new GenericDTO();
            genericDTO.setMessage("El rol ya existe.");
            EndPointCodeResponse enumResult = EndPointCodeResponse
                                                .getByCode(EndPointCodeResponse.E0400.toString());
            responseDTO.setCode(enumResult.getValue());
            responseDTO.setStatus(enumResult.getStatus());
            responseDTO.setMessages(new ArrayList<>(Arrays.asList(genericDTO)));
            return responseDTO;
        }
        
        Rol rolUpdate = Rol.builder()
                            .idRol(rolDTO.getIdRol())
                            .nombre(rolDTO.getNombre())
                            .build();

        rolRepo.save(rolUpdate);        
        
        EndPointCodeResponse enumResult = EndPointCodeResponse
                                            .getByCode(EndPointCodeResponse.E0200.toString());
        responseDTO.setCode(enumResult.getValue());
        responseDTO.setStatus(enumResult.getStatus());
        responseDTO.setData(rolDTO);
        return responseDTO;
    }
    
    //Metodo para eliminar un Rol
    @Transactional
    public ResponseDTO eliminarRolPorId(RolDTO rolDTO) {
        
        ResponseDTO responseDTO = new ResponseDTO();
        
        if (rolDTO.getIdRol() == null) {
            GenericDTO genericDTO = new GenericDTO();
            genericDTO.setMessage("El id del rol no puede ser nulo.");

            EndPointCodeResponse enumResult = EndPointCodeResponse
                                                .getByCode(EndPointCodeResponse.E0400.toString());
            responseDTO.setCode(enumResult.getValue());
            responseDTO.setStatus(enumResult.getStatus());
            responseDTO.setMessages(new ArrayList<>(Arrays.asList(genericDTO)));
            return responseDTO;
        }
        
        Optional<Rol> rolForName = rolRepo.findById(rolDTO.getIdRol());

        if (!rolForName.isPresent()) {
            GenericDTO genericDTO = new GenericDTO();
            genericDTO.setMessage("El rol no existe.");
            EndPointCodeResponse enumResult = EndPointCodeResponse
                                                .getByCode(EndPointCodeResponse.E0400.toString());
            responseDTO.setCode(enumResult.getValue());
            responseDTO.setStatus(enumResult.getStatus());
            responseDTO.setMessages(new ArrayList<>(Arrays.asList(genericDTO)));
            return responseDTO;
        }
        
        rolRepo.deleteById(rolForName.get().getIdRol());        
        
        EndPointCodeResponse enumResult = EndPointCodeResponse
                                            .getByCode(EndPointCodeResponse.E0203.toString());
        responseDTO.setCode(enumResult.getValue());
        responseDTO.setStatus(enumResult.getStatus());
        responseDTO.setData(rolDTO);
        return responseDTO;
    }
    
}
