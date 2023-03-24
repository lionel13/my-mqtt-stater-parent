package fr.varex13.mqtt.sampleapp.humidity;

import java.util.StringJoiner;

public class HumiditeDto {

    private String valeur;

    public HumiditeDto() {
    }

    public HumiditeDto(final String valeur) {
        this.valeur = valeur;
    }

    public String getValeur() {
        return valeur;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", HumiditeDto.class.getSimpleName() + "[", "]")
                .add("valeur='" + valeur + "'")
                .toString();
    }
}
