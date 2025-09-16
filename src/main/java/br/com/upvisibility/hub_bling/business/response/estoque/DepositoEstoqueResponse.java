package br.com.upvisibility.hub_bling.business.response.estoque;

public record DepositoEstoqueResponse(
        Long id,
        Float saldoFisico,
        Float saldoVirtual
) {
}
