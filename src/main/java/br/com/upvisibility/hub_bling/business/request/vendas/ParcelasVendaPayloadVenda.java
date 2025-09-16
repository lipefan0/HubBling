package br.com.upvisibility.hub_bling.business.request.vendas;

import java.time.LocalDate;

public record ParcelasVendaPayloadVenda(
        LocalDate dataVencimento,
        Float valor,
        String observacoes,
        FormaPagamentoPayloadVenda formaPagamento
) {
}
