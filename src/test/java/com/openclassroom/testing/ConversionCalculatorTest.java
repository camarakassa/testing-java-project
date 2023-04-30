package com.openclassroom.testing;

import org.junit.jupiter.api.*;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import static java.lang.Math.PI;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;

/*
* @Tag désigne tous les tests de la classe comme étant des tests de conversion,
* avec un tag nommé "ConversionTests".*/
@Tag("ConversionTests")
// @DisplayName vous permet de nommer vos tests de façon lisible par tous.
@DisplayName("Réussir à convertir entre différentes unités.")
public class ConversionCalculatorTest {

    private static Instant startedAt;
    private ConversionCalculator calculatorUnderTest;

    @BeforeEach
    public void initConversionCalculator() {
        System.out.println("Nous instancions la classe avant chaque méthode de test");
        calculatorUnderTest = new ConversionCalculator();
    }

    @AfterEach
    public void undefineConversionCalculator() {
        System.out.println("Affectation d'une valeur nulle après chaque méthode de test");
        calculatorUnderTest = null;
    }

    @BeforeAll
    public static void initStartingTime() {
        System.out.println("Appel avant tous les tests");
        startedAt = Instant.now();
    }

    @AfterAll
    public static void showTestDuration() {
        System.out.println("Appel après tous les tests");
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
    }

    /*
    * @Nested vous permet de grouper vos tests dans une classe interne.
    *  Avec @Nested, si un seul test échoue, tout le groupe désigné par cette annotation échoue !*/
    @Nested
    @Tag("TemperatureTests")
    @DisplayName("Réussir à convertir des températures")
    class TemperatureTest {
        @Test
        @DisplayName("Soit une T° à 0°C, lorsque l'on convertit en °F, alors on obtient 32°C.")
        void celsiusToFahrenheit_returnsAFahrenheitTemperature_whenCelsiusIsZero() {
            Double actualFahrenheit = calculatorUnderTest.celsiusToFahrenheit(0.0);
            assertThat(actualFahrenheit).isCloseTo(32.0, withinPercentage(0.01));
        }

        @Test
        @DisplayName("Soit une T° à 32°F, lorsque l'on convertit en °C, alors on obtient 0°C.")
        void fahrenheitToCelsius_returnsZeroCelsiusTemperature_whenThirtyTwo() {
            Double actualCelsius = calculatorUnderTest.fahrenheitToCelsius(32.0);
            assertThat(actualCelsius).isCloseTo(0.0, withinPercentage(0.01));
        }
    }

    @Test
    @DisplayName("Soit un volume de 3.78541 litres, en gallons, on obtient 1 gallon.")
    void litresToGallons_returnsOneGallon_whenConvertingTheEquivalentLitres() {
        Double actualLitres = calculatorUnderTest.litresToGallons(3.78541);
        assertThat(actualLitres).isCloseTo(1.0, withinPercentage(0.01));
    }

    @Test
    @DisplayName("L'aire d'un disque de rayon 1 doit valoir PI.")
    void radiusToAreaOfCircle_returnsPi_whenWeHaveARadiusOfOne() {
        Double actualArea = calculatorUnderTest.radiusToAreaOfCircle(1.0);
        assertThat(actualArea).isCloseTo(PI, withinPercentage(0.01));
    }

}
