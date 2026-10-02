package org.example;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner entrada = new Scanner(System.in);

        double[] chuvas = new double[7];
        double[][] umidade = new double[4][4];
        int opcao = 0;

        System.out.println("\n--- Sistema Integrado do Agronegócio (AgroJava) ---");

        do {
            System.out.println("""
                
                1 - Cadastrar Dados
                2 - Exibir Mapa do Campo
                3 - Relatório de Alertas de Irrigação
                4 - Sair
                
                Escollha uma opção:""");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    for (int i = 0; i < chuvas.length; i++) {
                        System.out.println("\nRegistre o volume da chuva em mm (" + (i + 1) + "/7): ");
                        chuvas[i] = entrada.nextDouble();
                    }

                    for (int i = 0; i < umidade.length; i++) {
                        for (int j = 0; j < umidade.length; j++) {
                            System.out.println("\nInforme a umidade do Talhão [" + i + "][" + j + "] ( %): ");
                            umidade[i][j] = entrada.nextDouble();
                        }
                    }
                    break;

                case 2:
                    double soma = 0;
                    int indchuva = 0;

                    for (int i = 0; i < chuvas.length; i++) {
                        soma += chuvas[i];
                        if (chuvas[i] > chuvas[indchuva]) {
                            indchuva = i;
                        }
                    }

                    System.out.println("\nMédia semanal de pluviosidade: " + (soma / 7) + " mm");
                    System.out.println("\nDia com maior índice de chuva: Dia " + (indchuva + 1));

                    System.out.println("\nUmidade dos talhões:");
                    for (int i = 0; i < umidade.length; i++) {
                        for (int j = 0; j < umidade.length; j++) {
                            System.out.print("[" + umidade[i][j] + "%] ");
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    System.out.println("\nAlertas de Irrigação dos Talhões:");
                    for (int i = 0; i < umidade.length; i++) {
                        for (int j = 0; j < umidade.length; j++) {
                            if (umidade[i][j] < 30.0) {
                                System.out.println("\nO Talhão [" + i + "][" + j + "] precisa de irrigação");
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("\nOperação encerrada...");
                    break;
            }
        } while (opcao != 4);
    }
}