package br.com.upvisibility.hub_bling.business.request.fpagamentos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Finalidade {
    PAGAMENTOS(1),
    RECEBIMENTOS(2),
    AMBOS(3);

    private final int value;

    Finalidade(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public static Finalidade from(int value) {
        for (Finalidade finalidade : Finalidade.values()) {
            if (finalidade.value == value) {
                return finalidade;
            }
        }
        throw new IllegalArgumentException("Valor inválido para Finalidade: " + value);
    }
}
