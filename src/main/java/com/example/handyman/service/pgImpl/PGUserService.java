package com.example.handyman.service.pgImpl;

import com.example.handyman.dao.UserDAO;
import com.example.handyman.entity.UserEntity;
import com.example.handyman.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PGUserService implements UserService {
    private UserDAO userDAO;

    @Override
    public UserEntity getUserById(Long id) {
       return userDAO.getOne(id);
    }
}
