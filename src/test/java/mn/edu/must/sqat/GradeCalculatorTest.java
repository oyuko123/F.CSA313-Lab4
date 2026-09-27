package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorTest {

    @Test
    @DisplayName("95 оноо A дүн байх ёстой")
    void ninetyFiveIsA() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        String grade = calc.letterGrade(95.0);

        // Assert
        assertEquals("A", grade);
    }

    @Test
    @DisplayName("85 оноо B дүн байх ёстой")
    void eightyFiveIsB() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        String grade = calc.letterGrade(85.0);

        // Assert
        assertEquals("B", grade);
    }

    @Test
    @DisplayName("75 оноо C дүн байх ёстой")
    void seventyFiveIsC() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        String grade = calc.letterGrade(75.0);

        // Assert
        assertEquals("C", grade);
    }

    @Test
    @DisplayName("65 оноо D дүн байх ёстой")
    void sixtyFiveIsD() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        String grade = calc.letterGrade(65.0);

        // Assert
        assertEquals("D", grade);
    }

    @Test
    @DisplayName("30 оноо F дүн байх ёстой")
    void thirtyIsF() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        String grade = calc.letterGrade(30.0);

        // Assert
        assertEquals("F", grade);
    }

    @Test
    @DisplayName("90 оноо яг A дүн байх ёстой (хязгаарын тохиолдол)")
    void ninetyIsExactlyA() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        String grade = calc.letterGrade(90.0);

        // Assert
        assertEquals("A", grade);
    }

    @Test
    @DisplayName("60 оноо яг D дүн байх ёстой (хязгаарын тохиолдол)")
    void sixtyIsExactlyD() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        String grade = calc.letterGrade(60.0);

        // Assert
        assertEquals("D", grade);
    }

    @Test
    @DisplayName("59.99 оноо F дүн байх ёстой")
    void fiftyNinePointNineNineIsF() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        String grade = calc.letterGrade(59.99);

        // Assert
        assertEquals("F", grade);
    }

    @Test
    @DisplayName("0 оноо F дүн байх ёстой")
    void zeroIsF() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        String grade = calc.letterGrade(0.0);

        // Assert
        assertEquals("F", grade);
    }

    @Test
    @DisplayName("100 оноо A дүн байх ёстой")
    void oneHundredIsA() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        String grade = calc.letterGrade(100.0);

        // Assert
        assertEquals("A", grade);
    }

    @Test
    @DisplayName("-1 оноо IllegalArgumentException үүсгэх ёстой")
    void negativeScoreThrowsException() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> calc.letterGrade(-1.0)
        );
    }

    @Test
    @DisplayName("101 оноо IllegalArgumentException үүсгэх ёстой")
    void scoreOverOneHundredThrowsException() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> calc.letterGrade(101.0)
        );
    }

    @Test
    @DisplayName("Бүх дээд хязгаарын нийлбэр 100 байх ёстой")
    void totalScoreCanBeOneHundred() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        double total = calc.totalScore(10, 40, 10, 10, 30);

        // Assert
        assertEquals(100.0, total);
    }

    @Test
    @DisplayName("Сөрөг ирц IllegalArgumentException үүсгэх ёстой")
    void negativeAttendanceThrowsException() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> calc.totalScore(-5, 40, 10, 10, 30)
        );
    }

    @Test
    @DisplayName("Лабораторийн 40-өөс дээш оноо IllegalArgumentException үүсгэх ёстой")
    void labOverMaximumThrowsException() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> calc.totalScore(10, 41, 10, 10, 30)
        );
    }

    @ParameterizedTest
    @DisplayName("Хязгаарын оноонууд зөв үсгэн дүнтэй байх ёстой")
    @CsvSource({
            "95, A",
            "90, A",
            "89.99, B",
            "80, B",
            "70, C",
            "60, D",
            "59.99, F",
            "0, F"
    })
    void letterGradeBoundaries(double score, String expected) {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        String actual = calc.letterGrade(score);

        // Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @DisplayName("Зөв оноонуудын нийлбэрийг зөв тооцоолох ёстой")
    @CsvSource({
            "10, 40, 10, 10, 30, 100",
            "8, 35, 9, 8, 25, 85",
            "5, 30, 7, 6, 20, 68"
    })
    void totalScoreCalculations(
            double att,
            double lab,
            double quiz1,
            double quiz2,
            double exam,
            double expected) {

        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        double actual = calc.totalScore(att, lab, quiz1, quiz2, exam);

        // Assert
        assertEquals(expected, actual);
    }
}
