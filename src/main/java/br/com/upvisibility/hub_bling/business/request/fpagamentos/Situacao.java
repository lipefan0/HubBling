package br.com.upvisibility.hub_bling.business.request.fpagamentos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Situacao {
    ATIVO(1),
    INATIVO(0);

    private final int code;
    Situacao(int code) {
        this.code = code;
    }
    @JsonValue
    public int getCode() {
        return code;
    }

    @JsonCreator
    public static Situacao forValue(int value) {
        for (var v : values())
            if (v.code == value)
                return v;
        throw new IllegalArgumentException("Situação inválida: " + value);
    }
}
