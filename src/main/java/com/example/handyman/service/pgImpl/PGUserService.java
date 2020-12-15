package com.example.handyman.service.pgImpl;

import com.example.handyman.dao.UserDAO;
import com.example.handyman.entity.UserEntity;
import com.example.handyman.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PGUserService implements UserService {
    private UserDAO userDAO;

    @Override
    public UserEntity getUserById(Long id) {
        return userDAO.getOne(id);
    }

    @Override
    public List<UserEntity> getAll() {
        return userDAO.findAll();
    }

    @Override
    public Optional<UserEntity> getUserByLogin(String login) {
        return userDAO.getUserEntitiesByLogin(login);
    }
}
