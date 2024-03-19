import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/*
 * Se ha descubierto un error con la entrada array vacío en el testC6:
 *  Se lanza una excepción java.lang.ArrayIndexOutOfBoundsException en PruebaUD3.java línea 14. Habría que comprobar que el array tiene al menos 1 elemento. Se ve una posible solución en Prueba_UD3Corregida.java
 */
public class Prueba_UD3Test {

    // Camino 1: 7-13, 32, 34 entrada null
    @Test
    void testC1() {
        char[] entrada = null;
        Exception exception = assertThrows(Exception.class, () -> Prueba_UD3.convertToEnteroNegativo(entrada));
        assertEquals(exception.getMessage(), Prueba_UD3.NULL_MESSAGE);
    }

    // Camino 2: 7-13, 14, 15, 34 entrada que no comienza por '-'
    @Test
    void testC2() {
        char[] entrada = { '4' };
        Exception exception = assertThrows(Exception.class, () -> Prueba_UD3.convertToEnteroNegativo(entrada));
        assertEquals(exception.getMessage(), Prueba_UD3.NO_NEGATIVE_INT_MESSAGE);
    }

    // Camino 3: 7-13, 14, 19, 20, 30, 34 entrada con longitud 1 y comienza por '-'
    @Test
    void testC3() throws NumberFormatException, Exception {
        char[] entrada = { '-' };
        int resultado = Prueba_UD3.convertToEnteroNegativo(entrada);
        assertEquals(resultado, -0);
    }

    // Camino 4: 7-13, 14, 19, 20, 25, 26, 20, 30, 34 entrada con longitud =2 y
    // comienza por '-'
    @Test
    void testC4() throws NumberFormatException, Exception {
        char[] entrada = { '-', '1' };
        int resultado = Prueba_UD3.convertToEnteroNegativo(entrada);
        assertEquals(resultado, -1);
    }

    // Camino 5: 7-13, 14, 19, 20, 25, 34 entrada comienza por '-' y sigue por algo
    // no convertible a entero 'a'
    @Test
    void testC5() throws NumberFormatException, Exception {
        char[] entrada = { '-', 'a' };
        Exception exception = assertThrows(Exception.class, () -> Prueba_UD3.convertToEnteroNegativo(entrada));
        assertEquals(exception.getClass(), NumberFormatException.class);
    }

    // Extra test
    // Qué pasa con array vacío: Se lanza una excepción
    // java.lang.ArrayIndexOutOfBoundsException en PruebaUD3.java línea 14. Habría
    // que comprobar que el array tiene al menos 1 elemento.
    @Test
    void testC6() throws NumberFormatException, Exception {
        char[] entrada = {};
        Exception exception = assertThrows(Exception.class, () -> Prueba_UD3.convertToEnteroNegativo(entrada));
        assertEquals(exception.getMessage(), Prueba_UD3.NULL_MESSAGE);
    }

}
