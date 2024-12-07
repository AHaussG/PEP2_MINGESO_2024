package com.app2.usuario_service.service;

import com.app2.usuario_service.entity.User;
import com.app2.usuario_service.exception.DuplicateRutException;
import com.app2.usuario_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        // Validar unicidad del RUT
        if (userRepository.existsByRut(user.getRut())) {
            throw new DuplicateRutException("Ya existe un usuario registrado con el RUT: " + user.getRut());
        }
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public boolean validarUsuario(String nombre, String rut) {
        return userRepository.findByNombreAndRut(nombre, rut).isPresent();
    }
    public boolean existsByRut(String rut) {
        return userRepository.existsByRut(rut);
    }

}
