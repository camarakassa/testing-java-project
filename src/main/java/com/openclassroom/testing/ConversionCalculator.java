package com.openclassroom.testing;

public class ConversionCalculator {

    // constantes pour la conversion des températures
    private static final double BASE_FAHRENHEIT = 32.0;
    private static final double CELSIUS_FAHRENHEIT_CONVERSION_FACTOR = 9.0 / 5.0;

    // constantes pour la conversion des volumes
    private static final double LITRE_TO_GALLON_MULTIPLIER = 0.264172;

    // Exposant pour le calcul d'une aire de disque
    private static final double POWER_OF_RADIUS = 2.0;

    /**
     * Convertir centigrade en fahrenheit.
     * @param celsiusTemperature à convertir
     * @return fahrenheit temperature
     */
    public Double celsiusToFahrenheit(double celsiusTemperature) {
        return (celsiusTemperature * CELSIUS_FAHRENHEIT_CONVERSION_FACTOR) + BASE_FAHRENHEIT;
    }

    /**
     * Convertir fahrenheit en centigrade
     * @param fahrenheitTemperature à convertir
     * @return Centigrade temperature
     */
    public Double fahrenheitToCelsius(double fahrenheitTemperature) {
        return (fahrenheitTemperature - BASE_FAHRENHEIT) * CELSIUS_FAHRENHEIT_CONVERSION_FACTOR;
    }

    /**
     * Convertir à volume en litres en gallons.
     * @param litreVolume à convertir
     * @return volume en gallons
     */
    public Double litresToGallons(double litreVolume) {
        return Math.ceil(litreVolume * LITRE_TO_GALLON_MULTIPLIER);
    }

    /**
     * Convertir un rayon en air de disque
     * @param radius du disque
     * @return air du disque
     */
    public Double radiusToAreaOfCircle(double radius) {
        return Math.PI * Math.pow(radius, POWER_OF_RADIUS);
    }
}
