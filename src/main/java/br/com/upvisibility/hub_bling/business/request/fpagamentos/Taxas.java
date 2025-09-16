package br.com.upvisibility.hub_bling.business.request.fpagamentos;

public record Taxas(
        Float aliquota,
        Float valor,
        Integer prazo
) {
}
