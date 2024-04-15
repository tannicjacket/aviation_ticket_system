package Flight;

public class Station {
    
    private String cityName;

    public Station(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    
    @Override
    public String toString() {
        return cityName;  
    }
    
}
