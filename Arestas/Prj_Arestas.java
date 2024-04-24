package padrao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Prj_Arestas {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
  
        try {
            File file = new File("C:\\src\\padrao\\entrada.txt"); //obs.: Colocar o caminho completo do arquivo
            Scanner scanner = new Scanner(file);

            // Lê a dimensão da matriz
            int dimensao = scanner.nextInt();
            scanner.nextLine(); 

            // Cria a matriz de adjacências
            int[][] matriz = new int[dimensao][dimensao];
            for (int i = 0; i < dimensao; i++) {
                String linha = scanner.nextLine();
                for (int j = 0; j < dimensao; j++) {
                    matriz[i][j] = Character.getNumericValue(linha.charAt(j));
                }
            }

            // Imprime as arestas do grafo com seus pesos
            for (int i = 0; i < dimensao; i++) {
                for (int j = i + 1; j < dimensao; j++) {
                    if (matriz[i][j] == 1) {
                        System.out.println("(" + i + ", " + j + ") peso " + matriz[i][j]);
                    }
                }
            }scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        }
    }
}