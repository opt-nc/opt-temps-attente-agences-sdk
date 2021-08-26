package nc.opt.tempsattente;

import java.util.Locale;

public class LonLat {
    private double lat;
    private double lon;

    public LonLat(double lon, double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "{lon: %f, lat: %f}", lon, lat);
    }    
}
