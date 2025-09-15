package br.com.upvisibility.hub_bling.business.request.fpagamentos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoPagamento {
    DINHEIRO(1),
    CHEQUE(2),
    CARTAO_CREDITO(3),
    CARTAO_DEBITO(4),
    CARTAO_LOJA(5),
    VALE_ALIMENTACAO(10),
    VALE_REFEICAO(11),
    VALE_PRESENTE(12),
    VALE_COMBUSTIVEL(13),
    DUPLICATA_MERCANTIL(14),
    BOLETO(15),
    DEPOSITO_BANCARIO(16),
    PIX_DINAMICO(17),
    TRANSF_CARTERA_DIGITAL(18),
    FIDELIDADE_CASHBACK(19),
    PIX_ESTATICO(20),
    CREDITO_LOJA(21),
    PAG_ELETRONICO_NAO_INFORMADO(22),
    SEM_PAGAMENTO(90),
    OUTROS(99);

    private final int code;
    TipoPagamento(int code){ this.code = code; }
    @JsonValue
    public int getCode(){ return code; }
    @JsonCreator
    public static TipoPagamento from(int c){
        for (var v: values()) if (v.code == c) return v;
        throw new IllegalArgumentException("TipoPagamento inválido: " + c);
    }
}
