package fr.varex13.mqtt.sampleapp.temperature;

import java.util.StringJoiner;

public class TemperatureDTO {

    private String valeur;

    public TemperatureDTO() {
    }

    public TemperatureDTO(final String valeur) {
        this.valeur = valeur;
    }

    public String getValeur() {
        return valeur;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TemperatureDTO.class.getSimpleName() + "[", "]")
                .add("valeur='" + valeur + "'")
                .toString();
    }

}
