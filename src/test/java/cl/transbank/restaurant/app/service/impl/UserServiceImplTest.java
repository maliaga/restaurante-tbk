package cl.transbank.restaurant.app.service.impl;

import cl.transbank.restaurant.app.service.LoginUserDetailsService;
import cl.transbank.restaurant.app.service.dto.LoginDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private LoginUserDetailsService loginUserDetailsService;

    @Test
    public void deberiaValidarElServicioDeLogin(){

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUser("maliaga");
        loginDTO.setPassword("12345");

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        when(loginUserDetailsService.loadUserByUsername(any(String.class))).thenReturn(
                new User("maliaga",
                "12345", true, true, true,
                        true, authorities));

        when(passwordEncoder.encode(any(String.class))).thenReturn(
                "$2a$10$fHuK3SwqohBDUXIXg2zqYeKY9q0BcQtTbLtkfvxCyRp/dx4Oy1zPq");

        String encryptedPassword = userService.login(loginDTO);

        assertThat(encryptedPassword).isEqualTo("$2a$10$fHuK3SwqohBDUXIXg2zqYeKY9q0BcQtTbLtkfvxCyRp/dx4Oy1zPq");

    }
}
