package br.com.upvisibility.hub_bling.business.response.fpagamentos;

public record FPagamentoList(
        Long id,
        String descricao,
        Integer tipoPagamento,
        Integer situacao,
        Boolean fixa,
        Integer padrao,
        Integer finalidade,
        Float juros,
        Float multa

) {
}
