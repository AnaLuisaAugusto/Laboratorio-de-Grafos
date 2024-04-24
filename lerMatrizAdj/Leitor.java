package padrao;

import java.io.*;
import java.util.Scanner;

public class Leitor {
    
    private int[][] matrizAdj;
    private int numVertices;

    public Leitor(int[][] matrizAdj) {
        this.matrizAdj = matrizAdj;
        this.numVertices = matrizAdj.length;
    }

    // Método para imprimir as arestas do grafo
    public void imprimirArestas() {
        System.out.println("Arestas do grafo:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                if (matrizAdj[i][j] != 0) {
                    System.out.println("(" + i + ", " + j + ")");
                }
            }
        }
    }

    // Método para verificar se é dígrafo ou não-direcionado
    public void tipoGrafo() {
        boolean dirigido = false;
        boolean naoDirigido = false;
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdj[i][j] != matrizAdj[j][i]) {
                    dirigido = true;
                } else if (matrizAdj[i][j] != 0) {
                    naoDirigido = true;
                }
            }
        }
        if (dirigido && naoDirigido) {
            System.out.println("O grafo é um dígrafo e um grafo não-direcionado.");
        } else if (dirigido) {
            System.out.println("O grafo é um dígrafo.");
        } else if (naoDirigido) {
            System.out.println("O grafo é um grafo não-direcionado.");
        } else {
            System.out.println("O grafo é vazio.");
        }
    }

    // Método para calcular o grau de cada vértice
    public void grauVertices() {
        System.out.println("Grau de cada vértice:");
        for (int i = 0; i < numVertices; i++) {
            int grau = 0;
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdj[i][j] != 0) {
                    grau++;
                }
            }
            System.out.println("Vértice " + i + ": " + grau);
        }
    }

    // Método para verificar se o grafo é conexo ou desconexo
    public void verificarConexo() {
        boolean[] visitado = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visitado[i] = false;
        }
        
        dfs(0, visitado);

        for (boolean v : visitado) {
            if (!v) {
                System.out.println("O grafo é desconexo.");
                return;
            }
        }
        System.out.println("O grafo é conexo.");
    }

    // Método para fazer busca em profundidade 
    private void dfs(int vertice, boolean[] visitado) {
        visitado[vertice] = true;
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdj[vertice][i] != 0 && !visitado[i]) {
                dfs(i, visitado);
            }
        }
    }

    // Método para verificar se o grafo é cíclico ou acíclico
    public void verificarCiclo() {
        boolean[] visitado = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            if (!visitado[i]) {
                if (verificarCicloUtil(i, -1, visitado)) {
                    System.out.println("O grafo é cíclico.");
                    return;
                }
            }
        }
        System.out.println("O grafo é acíclico.");
    }

    private boolean verificarCicloUtil(int vertice, int pai, boolean[] visitado) {
        visitado[vertice] = true;
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdj[vertice][i] != 0) {
                if (!visitado[i]) {
                    if (verificarCicloUtil(i, vertice, visitado))
                        return true;
                } else if (i != pai) {
                    return true;
                }
            }
        }
        return false;
    }

    // Método para imprimir a lista de adjacências
    public void imprimirListaAdjacencias() {
        System.out.println("Lista de adjacências:");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdj[i][j] != 0) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }
}