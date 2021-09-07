package com.example.planets;

public class PlanetDataSource {

    // PlanetDataSource and Planet have HAS-A relationship.
    private Planet[] dataSource;

    PlanetDataSource() {
        dataSource = new Planet[]{
            new Planet("MERCURY", R.drawable.mercury, 0.377),
            new Planet("VENUS", R.drawable.venus, 0.905),
            new Planet("THE MOON", R.drawable.moon, 0.1654),
            new Planet("MARS", R.drawable.mars, 0.379),
            new Planet("JUPITER", R.drawable.jupiter, 2.528),
            new Planet("SATURN", R.drawable.saturn, 1.065),
            new Planet("URANUS", R.drawable.uranus, 0.886),
            new Planet("NEPTUNE", R.drawable.neptune, 1.137),
            new Planet("PLUTO", R.drawable.pluto, 0.063)
        };
    }

    public Planet[] getDataSource() {
        return dataSource;
    }

    public String[] getNames() {
        String[] names = new String[dataSource.length];
        for (int i = 0; i < dataSource.length; i++) {
            names[i] = dataSource[i].getName();
        }
        return names;
    }
}
