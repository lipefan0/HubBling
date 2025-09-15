package br.com.upvisibility.hub_bling.business.request.fpagamentos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Destino {
    CONTAS_RECEBER_PAGAR(1),
    FICHA_FINANCEIRA(2),
    CAIXA_BANCOS(3);

    private final int value;

    Destino(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public static Destino from(int value) {
        for (Destino destino : Destino.values()) {
            if (destino.value == value) {
                return destino;
            }
        }
        throw new IllegalArgumentException("Invalid value for Destino: " + value);
    }
}
