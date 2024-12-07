package com.app2.usuario_service.service;

import com.app2.usuario_service.entity.User;
import com.app2.usuario_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<User> existingUser = userRepository.findByNombreAndRut(user.getNombre(), user.getRut());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("El usuario con ese nombre y RUT ya existe.");
        }
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public boolean validarUsuario(String nombre, String rut) {
        return userRepository.findByNombreAndRut(nombre, rut).isPresent();
    }
}
