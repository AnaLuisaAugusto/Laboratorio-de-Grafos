package padrao;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        try {
            File arquivo = new File("C:\\src\\padrao\\entrada.txt"); //obs: colocar caminho completo do arquivo
            Scanner scanner = new Scanner(arquivo);

            int numVertices = Integer.parseInt(scanner.nextLine());
            int[][] matrizAdj = new int[numVertices][numVertices];

            for (int i = 0; i < numVertices; i++) {
                String linha = scanner.nextLine();
                for (int j = 0; j < numVertices; j++) {
                    matrizAdj[i][j] = linha.charAt(j) - '0';
                }
            }

            Leitor grafo = new Leitor(matrizAdj);
            
            System.out.println("___________ Iniciando Programa ____________");
            
            System.out.println("\nQuais são as arestas do grafo?");
            grafo.imprimirArestas();
            System.out.println("------------------------------------");
            
            System.out.println("\n É um dígrafo ou um grafo não-direcionado?");
            grafo.tipoGrafo();
            System.out.println("------------------------------------");
            
            System.out.println("\nQual é o grau de cada vértice?");
            grafo.grauVertices();
            System.out.println("------------------------------------");
            
            System.out.println("\nO grafo é conexo ou desconexo?");
            grafo.verificarConexo();
            System.out.println("------------------------------------");
            
            System.out.println("\nO grafo é cíclico ou acíclico?");
            grafo.verificarCiclo();
            System.out.println("------------------------------------");
            
            System.out.println("\nQual é a lista de adjacências do mesmo grafo?");
            grafo.imprimirListaAdjacencias();
            
            System.out.println("___________ Finalizando Programa ____________");
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        }
    }
}
