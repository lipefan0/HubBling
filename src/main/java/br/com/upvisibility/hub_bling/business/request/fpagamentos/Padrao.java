package br.com.upvisibility.hub_bling.business.request.fpagamentos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Padrao {
    NAO(0),
    PADRAO(1),
    PADRAO_DEVOLUCAO(2);;

    private final int value;

    Padrao(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public static Padrao from(int value) {
        for (var v: values())
            if (v.value == value) return v;
            throw new IllegalArgumentException("Padrao inválido: " + value);
    }
}
