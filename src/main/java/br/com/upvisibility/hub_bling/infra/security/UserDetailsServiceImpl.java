package br.com.upvisibility.hub_bling.infra.security;

import br.com.upvisibility.hub_bling.business.dto.UsuarioDTO;
import br.com.upvisibility.hub_bling.infra.client.UsuarioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {

    @Autowired
    private UsuarioClient client;

    public UserDetails carregaDadosDeUsuario(String token) {
        UsuarioDTO usuarioDTO = client.buscarUsuarioAutenticado(token);
        return User
                .withUsername(usuarioDTO.getEmail()) // Define o nome de usuário como o e-mail
                .password(usuarioDTO.getSenha()) // Define a senha do usuário
                .build(); // Constrói o objeto UserDetails
    }
}
