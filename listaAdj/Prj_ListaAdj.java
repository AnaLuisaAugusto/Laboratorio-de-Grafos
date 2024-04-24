package padrao;

import java.util.Scanner;

public class Prj_ListaAdj {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("__________________Iniciando Programa_________________");
        
        System.out.println("Digite o número de vértices (n): ");
        int n = scanner.nextInt();

        int[][] matrizAdj = gerarMatrizAdj(n);
        imprimirMatrizAdj(matrizAdj);

        System.out.println("\nLista de adjacências:");
        imprimirListaAdj(matrizAdj);
        scanner.close();
        
        System.out.println("__________________Finalizando Programa_________________");
    }

    // Método para gerar a matriz de adjacências de um grafo completo Kn
    public static int[][] gerarMatrizAdj(int n) {
        int[][] matrizAdj = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                matrizAdj[i][j] = 1;
                matrizAdj[j][i] = 1;
            }
        }

        return matrizAdj;
    }

    // Método para imprimir a matriz de adjacências
    public static void imprimirMatrizAdj(int[][] matrizAdj) {
        System.out.println("Matriz de adjacências:");
        for (int i = 0; i < matrizAdj.length; i++) {
            for (int j = 0; j < matrizAdj[i].length; j++) {
                System.out.print(matrizAdj[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Método para imprimir a lista de adjacências
    public static void imprimirListaAdj(int[][] matrizAdj) {
        for (int i = 0; i < matrizAdj.length; i++) {
            System.out.print("Vértice " + i + ": ");
            for (int j = 0; j < matrizAdj[i].length; j++) {
                if (matrizAdj[i][j] == 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }
}