package com.example.handyman.security;

import com.example.handyman.entity.UserEntity;
import com.example.handyman.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service("pgUserDetailsService")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PGUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserEntity userEntity = userService.getUserByLogin(login).orElseThrow(() ->
                new UsernameNotFoundException("User doesn't exist"));
        return JwtUserFactory.createUserDetails(userEntity);
    }
}
