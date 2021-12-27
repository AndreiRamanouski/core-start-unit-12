package task52;

public class Planet extends HeavenlyBody {

    public Planet(Key key, double orbitalPeriod) {
        super(key, orbitalPeriod);
    }

    @Override
    public boolean addSatellite(HeavenlyBody body) {
        if (body.getKey().getBodyType() == BodyTypes.MOON) {
            return super.addSatellite(body);
        } else return false;
    }
}
