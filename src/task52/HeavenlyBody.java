package task52;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(Key key, double orbitalPeriod) {
        this.key = key;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }
    public static Key makeKey(String name, BodyTypes bodyType){
        return new Key(name,bodyType);
    }
    public static class Key{
        private String name;
        private BodyTypes bodyType;

        Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return Objects.equals(name, key.name) && bodyType == key.bodyType;
        }
        @Override
        public int hashCode() {
            return Objects.hash(name, bodyType);
        }

        @Override
        public String toString() {
            return "Key{" +
                    "name='" + name + '\'' +
                    ", bodyType=" + bodyType +
                    '}';
        }
    }
    public enum BodyTypes{
        PLANET,DWARF_PLANET,MOON
    }

    public Key getKey() {
        return key;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellite(HeavenlyBody body) {
        return this.satellites.add(body);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeavenlyBody that = (HeavenlyBody) o;
        return Double.compare(that.orbitalPeriod, orbitalPeriod) == 0 && Objects.equals(key, that.key) && Objects.equals(satellites, that.satellites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, orbitalPeriod, satellites);
    }

    @Override
    public String toString() {
        return "HeavenlyBody{" +
                "name='" + key + '\'' +
                ", orbitalPeriod=" + orbitalPeriod +
                ", satellites=" + satellites +
                '}';
    }
}
