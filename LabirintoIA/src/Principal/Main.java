package Principal;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		AlgoritmoA algoA = new AlgoritmoA();
		BuscaLargura buscaL = new BuscaLargura();
		Algoritmo heuristica = new Algoritmo();
		
		int opcao = 1;
		Scanner scan = new Scanner(System.in);

		while (opcao > 0) {

			System.out.println("Digite 1 para Busca em Largura ou 2 para Algoritmo A* e tecle enter:");
			
			int opcaoIA = Integer.parseInt(scan.nextLine());
			if(opcaoIA == 1){
				heuristica = buscaL;
				heuristica = new BuscaLargura();
			}else if(opcaoIA == 2){
				heuristica = algoA;
				heuristica = new AlgoritmoA();
			}
			heuristica.iniciar();
			while (!heuristica.estadoAtual.getPosicao().equals(heuristica.estadoFinal.getPosicao())) {

				if (heuristica.vida > 0 && !heuristica.estadoAtual.getPosicao().equals(heuristica.estadoAnterior.getPosicao())) {
					if(opcaoIA == 1){
						System.out.println("Sentido: Esquerda, Baixo, Direita, Cima");
						}
						
						System.out.println("Quantidade de Paredes (P): " + heuristica.numeroParedes);
						System.out.println("5 Vidas de +5 | 3 Vidas de +10");
						System.out.println("Posição Atual: " + heuristica.estadoAtual.getPosicao() + " | Posição Final: "
								+ heuristica.estadoFinal.getPosicao() + " | Posição Anterior: " + heuristica.estadoAnterior.getPosicao());
						System.out.println("Vida: " + heuristica.vida + " | Movimentos: " + heuristica.movimentos + " | Distancia: "
								+ heuristica.estadoAtual.getDistancia(heuristica.estadoFinal));
					if (opcaoIA == 1) {
						buscaL.toString();
						buscaL.buscaLargura();
					} else if (opcaoIA == 2) {
						algoA.toString();
						algoA.algoritmoA();
					} else {
						System.out.println("Opção incorreta.");
					}

					try {
						Thread.sleep(300);
					} catch (InterruptedException ex) {
					}

				} else {
					System.out.println("G A M E  O V E R");
					
					break;

				}
			}
			

			System.out.println("Digite 0 para sair ou 1 para ir novamente e tecle enter.");
			opcao = Integer.parseInt(scan.nextLine());
			 algoA = new AlgoritmoA();
			 buscaL = new BuscaLargura();
		}
	}
}
