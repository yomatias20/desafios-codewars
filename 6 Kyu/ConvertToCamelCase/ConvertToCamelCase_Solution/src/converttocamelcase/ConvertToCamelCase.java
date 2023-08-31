
package converttocamelcase;

class ConvertToCamelCase {

    public static void main(String[] args) {
        String cadena = "Vamos_a_ver_si_esto_funciona"; // try other values
        String result = toCamelCase(cadena);
        System.out.println("Cadena original: " + cadena);
        System.out.println("Resultado: " + result);
        System.out.println("");
    }
    
    static String toCamelCase(String s) {
        String smod = "";
        String caracter;
        boolean postGuion = false;
        for (int i = 0; i < s.length(); i++) {
            caracter = s.substring(i, i + 1);
            if (!caracter.equals("-") && !caracter.equals("_")) {
                if (postGuion == false) {
                    smod = smod + caracter;
                } else {
                    smod = smod + caracter.toUpperCase();
                }
                postGuion = false;
            } else {
                postGuion = true;
            }
        }
        return smod;
    }
    
}
