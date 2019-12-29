package cl.transbank.restaurant.app.service;

import cl.transbank.restaurant.app.entity.Role;
import cl.transbank.restaurant.app.entity.Usuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class LoginUserDetailsServiceTest {

    @InjectMocks
    LoginUserDetailsService loginUserDetailsService;

    @Mock
    IUsuarioDao usuarioDao;

    @Test
    public void deberiaValidarLaLecturaDeUnUsuarioPorUsername(){

        Role role = new Role();
        role.setId(1L);
        role.setAuthority("ROLE_ADMIN");
        role.setAuthority("ROLE_USER");

        Usuario usuario = new Usuario();
        usuario.setUsername("maliaga");
        usuario.setPassword("12345");
        usuario.setEnabled(true);

        List<Role> roles = new ArrayList<>(0);
        roles.add(role);

        usuario.setRoles(roles);

        when(usuarioDao.findByUsername(any(String.class))).thenReturn(usuario);

        UserDetails userDetails = loginUserDetailsService.loadUserByUsername("maliaga");

        assertThat(userDetails.getUsername()).isEqualTo("maliaga");
        assertThat(userDetails.getPassword()).isEqualTo("12345");
        assertThat(userDetails.getAuthorities().size()).isEqualTo(1);
    }

}
