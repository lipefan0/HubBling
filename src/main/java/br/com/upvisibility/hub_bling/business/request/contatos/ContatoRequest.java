package br.com.upvisibility.hub_bling.business.request.contatos;

import lombok.Builder;

@Builder
public record ContatoRequest(
        String nome,
        String codigo,
        String situacao,
        String numeroDocumento,
        String telefone,
        String celular,
        String fantasia,
        String tipo,
        String ie,
        String rg,
        String email,
        EnderecoRequest endereco

) {
}
