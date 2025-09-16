package br.com.upvisibility.hub_bling.business.request.vendas;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record VendaRequest(
        String numero,
        String numeroLoja,
        LocalDate data,
        LocalDate dataSaida,
        LocalDate dataPrevista,
        ContatoPayloadVenda contato,
        SituacaoPayloadVenda situcao,
        LojaPayloadVenda loja,
        Float outrasDespesas,
        String observacoes,
        String observacoesInternas,
        DescontoPayloadVenda desconto,
        List<ItensVendaPayloadVenda> itens,
        List<ParcelasVendaPayloadVenda> parcelas
) {
}
