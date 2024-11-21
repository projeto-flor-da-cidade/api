// src/main/java/flordacidade/Projeto_SEAU/service/UserService.java

package com.flordacidade.api.flor_da_cidade_api.service;


import com.flordacidade.api.flor_da_cidade_api.model.User;
import com.flordacidade.api.flor_da_cidade_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listarUsuarios() {
        return userRepository.findAll();
    }

    public Optional<User> buscarPorCpf(String cpf) {
        return userRepository.findByCpf(cpf);
    }

    public User salvarUsuario(User user) {
        return userRepository.save(user);
    }

    public void deletarUsuario(Long id) {
        userRepository.deleteById(id);
    }
}