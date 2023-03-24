package fr.varex13.mqtt.sampleapp.temperature;

import fr.varex13.mqtt.sampleapp.humidity.HumiditeDto;

import java.util.StringJoiner;

public class TemperatureDTO /*extends DataDTO*/ {

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


//    private String temperature;
//
//    private TemperatureDTO() {
//        super();
//    }
//
//    public TemperatureDTO(String timestamp, String sensorId, String temperature) {
//        super(timestamp, sensorId);
//        this.temperature = temperature;
//    }
//
//    public static Temperature toTemperature(final TemperatureDTO temperatureDTO) {
//        return  Temperature.builder()
//                .value(Float.valueOf(temperatureDTO.getTemperature()))
//                .horodatage(LocalDateTime.parse(temperatureDTO.getTimestamp()))
//                .build();
//    }
//
//    public String getTemperature() {
//        return temperature;
//    }
//
//    @Override
//    public String toString() {
//        return "TemperatureDTO{" +
//                "temperature=" + temperature +
//                ", timestamp=" + getTimestamp() +
//                ", sensorId=" + getSensorId() +
//                "} ";
//    }
}
