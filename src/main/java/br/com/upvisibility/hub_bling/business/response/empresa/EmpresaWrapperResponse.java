package br.com.upvisibility.hub_bling.business.response.empresa;

public record EmpresaWrapperResponse(
        String id,
        String nome,
        String cnpj,
        String email,
        String dataContrato
) {
}
