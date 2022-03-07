import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreditTest {

    Credit sut;

    @BeforeEach
    public void init() {
        System.out.println("test started");
        sut = new Credit();
    }

    @Test
    public void testPaymentPerMonth() {
        //arrange
        int a = 120000, b = 12, c = 12;
        double expected = 11200;

        //act
        double result = sut.getPaymentPerMonth(a, b, c);

        //assert
        assertEquals(expected, result);
    }

    @Test
    public void validValue() {
        int a = 120000, b = 12, c = 0;
        assertThrows(ArithmeticException.class, () -> sut.getPaymentPerMonth(a, b, c));
    }

    @Test
    public void testGetTotalAmount() {
        //arrange
        int a = 30000, b = 15, c = 3;
        double expected = 43500;

        //act
        double result = sut.getTotalAmount(a, b, c);

        //assert
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("source")
    public void testPaymentPerMonth(int a, int b, int c, double expected) {
        //act
        double result = sut.getPaymentPerMonth(a,b,c);

        //assert
        assertEquals(expected, result);
    }

    private static Stream<Arguments> source() {
        return Stream.of(Arguments.of(10000, 10, 12, 916), Arguments.of(200000, 10, 24, 9166));
    }

}
