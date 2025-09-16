package br.com.upvisibility.hub_bling.business.request.contatos;

public record EnderecoRequest(
        EnderecoGeral geral,
        EnderecoGeral cobranca
) {
}