package Principal;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		AlgoritmoA algoA = new AlgoritmoA();
		BuscaLargura buscaL = new BuscaLargura();

		int opcao = 1;
		Scanner scan = new Scanner(System.in);

		while (opcao > 0) {

			System.out.println("Digite 1 para Busca em Largura ou 2 para Algoritmo A* e tecle enter:");

			int opcaoIA = Integer.parseInt(scan.nextLine());
			if (opcaoIA == 1) {
				buscaL.gerador();
				buscaL.instanciar();
				while (!buscaL.estadoAtual.getPosicao().equals(buscaL.estadoFinal.getPosicao())) {

					if (buscaL.vida > 0
							&& !buscaL.estadoAtual.getPosicao().equals(buscaL.estadoAnterior.getPosicao())) {
						buscaL.toString();
						buscaL.buscaLargura();

						try {
							Thread.sleep(300);
						} catch (InterruptedException ex) {
						}

					} else {
						System.out.println("G A M E  O V E R");
						break;
					}
				}
				buscaL.toString();
			} else if (opcaoIA == 2) {
				algoA.gerador();
				algoA.instanciar();
				while (!algoA.estadoAtual.getPosicao().equals(algoA.estadoFinal.getPosicao())) {

					if (algoA.vida > 0 && !algoA.estadoAtual.getPosicao().equals(algoA.estadoAnterior.getPosicao())) {
						algoA.toString();
						algoA.algoritmoA();

						try {
							Thread.sleep(300);
						} catch (InterruptedException ex) {
						}

					} else {
						System.out.println("G A M E  O V E R");

						break;

					}
				}
				algoA.toString();
			}

			System.out.println("Digite 0 para sair ou 1 para ir novamente e tecle enter.");
			opcao = Integer.parseInt(scan.nextLine());
			algoA = new AlgoritmoA();
			buscaL = new BuscaLargura();
		}
	}
}
