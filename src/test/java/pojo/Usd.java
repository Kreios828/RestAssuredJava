package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Usd {
    @JsonProperty("ID")
    private static String iD;
    @JsonProperty("NumCode")
    private static String numCode;
    @JsonProperty("CharCode")
    private static String charCode;
    @JsonProperty("Nominal")
    private static Integer nominal;
    @JsonProperty("Name")
    private static String name;
    @JsonProperty("Value")
    private static Double value;
    @JsonProperty("Previous")
    private static Double previous;

    public Usd() {
    }

    public Usd(String iD, String numCode, String charCode, Integer nominal, String name, Double value, Double previous) {
        this.iD = iD;
        this.numCode = numCode;
        this.charCode = charCode;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
        this.previous = previous;
    }

    public String getCharCode() {
        return charCode;
    }

    public Double getValue() {
        return value;
    }

}
