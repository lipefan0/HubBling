package br.com.upvisibility.hub_bling.business.request.contatos;

public record EnderecoGeral(
        String endereco,
        String numero,
        String complemento,
        String bairro,
        String municipio,
        String uf,
        String cep
) {}