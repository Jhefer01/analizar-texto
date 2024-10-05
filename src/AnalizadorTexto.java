import java.util.Scanner;

public class AnalizadorTexto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un texto para analizar:");
        String texto = scanner.nextLine().toLowerCase();

        int[] frecuencia = new int[26];
        int totalLetras = 0;
        int totalPalabras = 0;
        int totalVocales = 0;

        final int LARGO_DEL_TEXTO = texto.length();//esta funcion lo que hace es sacar del fork para asi no repetir muchas veces

        for (int i = 0; i < LARGO_DEL_TEXTO; i++) {
            char letra = texto.charAt(i);//cambiamos en nombre de la variable por una mas descriptiva
            if (letra >= 'a' && letra <= 'z') {
                frecuencia[letra - 'a']++;
                totalLetras++;
                if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                    totalVocales++;
                }
            } else if (letra == ' ' && i > 0 && texto.charAt(i - 1) != ' ') {
                totalPalabras++;
            }
        }
        totalPalabras++; // Contar la última palabra

        System.out.println("Análisis del texto:");
        System.out.println("Total de letras: " + totalLetras);
        System.out.println("Total de palabras: " + totalPalabras);
        System.out.println("Total de vocales: " + totalVocales);
        System.out.println("Frecuencia de letras:");
        final int LETRAS_DEL_ALFABETO = 26;//quitamos el valor magico y le asignamos un nombre
        for (int i = 0; i < LETRAS_DEL_ALFABETO; i++) {
            if (frecuencia[i] > 0) {
                System.out.println((char) (i + 'a') + ": " + frecuencia[i]);
            }
        }

        scanner.close();
    }
}

