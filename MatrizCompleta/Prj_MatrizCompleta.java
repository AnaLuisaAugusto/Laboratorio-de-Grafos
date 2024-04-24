package padrao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Prj_MatrizCompleta {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        
        try {
            File file = new File("C:\\src\\padrao\\entrada.txt"); //obs: colocar caminho completo do arquivo
            Scanner scanner = new Scanner(file);

            int dimensao = Integer.parseInt(scanner.nextLine());
            int[][] matriz = new int[dimensao][dimensao];

            // Preenche a parte inferior da matriz com os valores fornecidos
            for (int i = 0; i < dimensao; i++) {
                String linha = scanner.nextLine();
                for (int j = 0; j <= i; j++) {
                    matriz[i][j] = Character.getNumericValue(linha.charAt(j));
                }
            }

            // Completa a matriz simetricamente
            for (int i = 0; i < dimensao; i++) {
                for (int j = 0; j < i; j++) {
                    matriz[j][i] = matriz[i][j];
                }
            }

            // Imprime a matriz completa
            for (int i = 0; i < dimensao; i++) {
                for (int j = 0; j < dimensao; j++) {
                    System.out.print(matriz[i][j]);
                }
                System.out.println();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        }
    }
}