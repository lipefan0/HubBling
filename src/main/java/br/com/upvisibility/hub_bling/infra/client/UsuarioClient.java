package br.com.upvisibility.hub_bling.infra.client;

import br.com.upvisibility.hub_bling.business.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "usuarios",
        url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping("/usuario/me")
    UsuarioDTO buscarUsuarioAutenticado(@RequestHeader String token);
}
