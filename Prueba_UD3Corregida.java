
public class Prueba_UD3Corregida {

    public static final String NULL_MESSAGE = "La entrada no puede ser null ni array vacío";
    public static final String NO_NEGATIVE_INT_MESSAGE = "Solo se permiten enteros negativos";

    public static int convertToEnteroNegativo(char[] entrada) throws NumberFormatException, Exception {

        int digitoEntero = 0;
        int numero = 0;
        int longitud = 0;

        if ((entrada != null) && (entrada.length>=1)){
            if (entrada[0] != '-') { 
                throw new Exception(NO_NEGATIVE_INT_MESSAGE);

            } else {

                longitud = entrada.length;
                for (int i = 1; i < longitud; i++) {
                    /*
                     * parseInt puede lanzar NumberFormatException -
                     * si la cadena de entrada no es convertible a un entero
                     */
                    digitoEntero = Integer.parseInt(String.valueOf(entrada[i]));
                    numero += digitoEntero * Math.pow(10, longitud - 1 - i);

                }
            }
            return numero *(-1);
        } else {
            throw new Exception(NULL_MESSAGE);
        }
    }

    public static void main(String[] args) throws Exception {
        char[] charArray = {  '-', '4', '1', '0' };
        int entero = convertToEnteroNegativo(charArray);
        System.out.println("Se ha leído: " + entero);
    }
}
