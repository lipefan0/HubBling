package br.com.upvisibility.hub_bling.business.response.vendas;

import java.time.LocalDate;

public record VendaResponse(
        Long id,
        String numero,
        String numeroLoja,
        LocalDate data,
        LocalDate dataSaida,
        LocalDate dataPrevista,
        Float totalProdutos,
        Float total,
        ContatoResponseVenda contato,
        SituacaoResponseVenda situacao,
        LojaResponseVenda loja

) {
}
