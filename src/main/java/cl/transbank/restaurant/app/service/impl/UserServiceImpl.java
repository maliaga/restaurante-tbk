package cl.transbank.restaurant.app.service.impl;

import cl.transbank.restaurant.app.service.IUserService;
import cl.transbank.restaurant.app.service.LoginUserDetailsService;
import cl.transbank.restaurant.app.service.dto.LoginDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private LoginUserDetailsService loginUserDetailsService;


    /**
     * M&eacute;todo que tiene la l&oacute;gica para validar si el usuario está en la base de datos
     * @param loginDTO <code>usuario y password</code>
     * @return password encriptado
     */
    @Override
    public String login(LoginDTO loginDTO) {

        UserDetails userDetails = loginUserDetailsService.loadUserByUsername(loginDTO.getUser());
        log.info(userDetails.getUsername());
        log.info(userDetails.getPassword());
        log.info(userDetails.getAuthorities().toString());

        String encryptedPassword = passwordEncoder.encode(loginDTO.getPassword());

        return encryptedPassword;
    }
}
