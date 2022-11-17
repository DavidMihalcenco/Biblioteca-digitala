package Tema1;

public class Country {
    private Integer ID;
    private String countryCode;

    public Country(Integer ID, String countryCode) {
        this.ID = ID;
        this.countryCode = countryCode;
    }

    public Integer getID() {
        return ID;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
