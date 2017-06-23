package Principal;

import java.util.Random;

public class Algoritmo {
	Casa[][] matriz = new Casa[10][10];
	Casa estadoFinal;
	Casa estadoAtual ;
	Casa estadoAnterior;
	int vida = 50;
	int numeroParedes;
	int menorValor = 50;
	int movimentos = 0;

	public void instanciar() {
		estadoAtual = new Casa();
		estadoFinal = new Casa();
		estadoAtual.setPosicao(0, 0);
		estadoFinal.setPosicao(9, 9);
		estadoAnterior = new Casa();
		estadoAnterior.setPosicao(0, -1);
		movimentos = 0;
	}
	

	public void menu(int opcaoIA){
		gerador();
		instanciar();
		System.out.println(estadoAtual.getPosicao());
		AlgoritmoA algoA = new AlgoritmoA();
		BuscaLargura buscaL = new BuscaLargura();

		while (!estadoAtual.getPosicao().equals(estadoFinal.getPosicao())) {

			if (vida > 0 && !estadoAtual.getPosicao().equals(estadoAnterior.getPosicao())) {
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
		algoA.toString();
		
	}
	
	public void prencher(int posicaox, int posicaoy, String tipo, int valor) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (posicaox == i && posicaoy == j) {
					if (tipo.equals("P")) {
						matriz[i][j].setClosed(true);
					}
					matriz[i][j].setPosicao(i, j);
					matriz[i][j].setTipo(tipo);
					matriz[i][j].setValor(valor);
				} else {
					matriz[i][j].setPosicao(i, j);
				}
			}
		}
	}

	public void gerador() {

		
		
		// gerando matriz
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Casa teste = new Casa();
				teste.setTipo("L");
				teste.setValor(-1);
				matriz[i][j] = teste;
			}
		}
		// definindo inicio e fim
		matriz[0][0].setTipo("R");
		matriz[0][0].setPosicao(0, 0);
		matriz[9][9].setTipo("F");
		matriz[9][9].setPosicao(9, 9);

		// gerando paredes
		Random r = new Random();
		numeroParedes = r.nextInt(15) + 10;
		// gerando posicoes da parede
		for (int i = 1; i <= numeroParedes; i++) {
			Random posicao = new Random();
			int posicaox = posicao.nextInt(9);
			int posicaoy = posicao.nextInt(9);
			if (posicaox == 0 && posicaoy == 0) {
				i--;
			} else if (posicaox == 9 && posicaoy == 9) {
				i--;
			}
			if (matriz[posicaox][posicaoy].getTipo().equals("L")) {
				prencher(posicaox, posicaoy, "P", 0);
			} else {
				i--;
			}
		}
		// gerando vidas de 5
		for (int i = 1; i <= 5; i++) {
			Random posicao = new Random();
			int posicaox = posicao.nextInt(9);
			int posicaoy = posicao.nextInt(9);
			if (posicaox == 0 && posicaoy == 0) {
				i--;
			} else if (posicaox == 9 && posicaoy == 9) {
				i--;
			}
			if (matriz[posicaox][posicaoy].getTipo().equals("L")) {
				prencher(posicaox, posicaoy, "C", 5);
			} else {
				i--;
			}
		}
		// gerando vidas de 10
		for (int i = 1; i <= 3; i++) {
			Random posicao = new Random();
			int posicaox = posicao.nextInt(9);
			int posicaoy = posicao.nextInt(9);
			if (posicaox == 0 && posicaoy == 0) {
				i--;
			} else if (posicaox == 9 && posicaoy == 9) {
				i--;
			}
			if (matriz[posicaox][posicaoy].getTipo().equals("L")) {
				prencher(posicaox, posicaoy, "D", 10);
			} else {
				i--;
			}
		}
	}

	public void realizarMovimento(String movimento) {
		if (movimento.equals("Direita")) {
			andarDireita();
		} else if (movimento.equals("Esquerda")) {
			andarEsquerda();
		} else if (movimento.equals("Cima")) {
			andarCima();
		} else if (movimento.equals("Baixo")) {
			andarBaixo();
		}
	}

	public void andarCima() {

		matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].setTipo("R");
		matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy()].setTipo("-");
		matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy()].setClosed(true);
		estadoAtual.setValor(matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].getValor());
		estadoAtual.setTipo(matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].getTipo());
		estadoAtual.setPosicao(estadoAtual.getPosicaox() - 1, estadoAtual.getPosicaoy());

		vida += estadoAtual.getValor();
	}

	public void andarBaixo() {
		matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].setTipo("R");
		matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy()].setTipo("-");
		matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy()].setClosed(true);
		estadoAtual.setValor(matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].getValor());
		estadoAtual.setTipo(matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].getTipo());
		estadoAtual.setPosicao(estadoAtual.getPosicaox() + 1, estadoAtual.getPosicaoy());

		vida += estadoAtual.getValor();
	}

	public void andarDireita() {
		matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1].setTipo("R");
		matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy()].setTipo("-");
		matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy()].setClosed(true);
		estadoAtual.setValor(matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1].getValor());
		estadoAtual.setTipo(matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1].getTipo());
		estadoAtual.setPosicao(estadoAtual.getPosicaox(), estadoAtual.getPosicaoy() + 1);

		vida += estadoAtual.getValor();
	}

	public void andarEsquerda() {

		matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1].setTipo("R");
		matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy()].setTipo("-");
		matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy()].setClosed(true);
		estadoAtual.setValor(matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1].getValor());
		estadoAtual.setTipo(matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1].getTipo());
		estadoAtual.setPosicao(estadoAtual.getPosicaox(), estadoAtual.getPosicaoy() - 1);
		System.out.println(estadoAtual.getPosicao());
		vida += estadoAtual.getValor();
	}

	public String toString() {
		String retorno = "";
		
		System.out.println("Quantidade de Paredes (P): " + numeroParedes);
		System.out.println("5 Vidas de +5 (C) | 3 Vidas de +10 (D)");
		System.out.println("Posição Atual: " + estadoAtual.getPosicao() + " | Posição Final: "
				+ estadoFinal.getPosicao() + " | Posição Anterior: " + estadoAnterior.getPosicao());
		System.out.println("Vida: " + vida + " | Movimentos: " + movimentos + " | Distancia: "
				+ estadoAtual.getDistancia(estadoFinal));
		
		for (int i = 0; i < matriz.length; i++) {
			retorno = " ";
			for (int j = 0; j < matriz.length; j++) {

				if (!matriz[i][j].getTipo().equals("L")) {
					retorno = retorno + "[" + matriz[i][j].getTipo() + "] ";
				} else {
					retorno = retorno + "[ ] ";
				}
			}
			System.out.println(retorno);
			
		}
		System.out.println();

		movimentos++;
		return retorno;

	}
}
