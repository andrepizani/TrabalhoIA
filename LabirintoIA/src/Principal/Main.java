package Principal;

import java.util.Random;

public class Main {

	private static Casa[][] matriz = new Casa[10][10];
	private static Casa estadoFinal;
	private static Casa valorAtual;
	private static int vida = 50;

	static void andarCima() {
		matriz[valorAtual.getPosicaox() - 1][valorAtual.getPosicaoy()].setTipo("R");
		matriz[valorAtual.getPosicaox()][valorAtual.getPosicaoy()].setTipo("-");
		matriz[valorAtual.getPosicaox()][valorAtual.getPosicaoy()].setClosed(true);
		valorAtual.setValor(matriz[valorAtual.getPosicaox() - 1][valorAtual.getPosicaoy()].getValor());
		valorAtual.setTipo(matriz[valorAtual.getPosicaox() - 1][valorAtual.getPosicaoy()].getTipo());
		valorAtual.setPosicao(valorAtual.getPosicaox() - 1, valorAtual.getPosicaoy());

		vida += valorAtual.getValor();
	}

	static void andarBaixo() {
		matriz[valorAtual.getPosicaox() + 1][valorAtual.getPosicaoy()].setTipo("R");
		matriz[valorAtual.getPosicaox()][valorAtual.getPosicaoy()].setTipo("-");
		matriz[valorAtual.getPosicaox()][valorAtual.getPosicaoy()].setClosed(true);
		valorAtual.setValor(matriz[valorAtual.getPosicaox() + 1][valorAtual.getPosicaoy()].getValor());
		valorAtual.setTipo(matriz[valorAtual.getPosicaox() + 1][valorAtual.getPosicaoy()].getTipo());
		valorAtual.setPosicao(valorAtual.getPosicaox() + 1, valorAtual.getPosicaoy());

		vida += valorAtual.getValor();
	}

	static void andarDireita() {
		matriz[valorAtual.getPosicaox()][valorAtual.getPosicaoy() + 1].setTipo("R");
		matriz[valorAtual.getPosicaox()][valorAtual.getPosicaoy()].setTipo("-");
		matriz[valorAtual.getPosicaox()][valorAtual.getPosicaoy()].setClosed(true);
		valorAtual.setValor(matriz[valorAtual.getPosicaox()][valorAtual.getPosicaoy() + 1].getValor());
		valorAtual.setTipo(matriz[valorAtual.getPosicaox()][valorAtual.getPosicaoy() + 1].getTipo());
		valorAtual.setPosicao(valorAtual.getPosicaox(), valorAtual.getPosicaoy() + 1);

		vida += valorAtual.getValor();
	}

	static void andarEsquerda() {
		matriz[valorAtual.getPosicaox()][valorAtual.getPosicaoy() - 1].setTipo("R");
		matriz[valorAtual.getPosicaox()][valorAtual.getPosicaoy()].setTipo("-");
		matriz[valorAtual.getPosicaox()][valorAtual.getPosicaoy()].setClosed(true);
		valorAtual.setValor(matriz[valorAtual.getPosicaox()][valorAtual.getPosicaoy() - 1].getValor());
		valorAtual.setTipo(matriz[valorAtual.getPosicaox()][valorAtual.getPosicaoy() - 1].getTipo());
		valorAtual.setPosicao(valorAtual.getPosicaox(), valorAtual.getPosicaoy() - 1);

		vida += valorAtual.getValor();
	}

	static void acao() {

		if (valorAtual.getPosicaox() == 0) {
			if (valorAtual.getPosicaox() > 0 && valorAtual.getPosicaoy() < 9) {

				if (matriz[valorAtual.getPosicaox() + 1][valorAtual.getPosicaoy()].isClosed() == false) {
					andarBaixo();
				} else if (matriz[valorAtual.getPosicaox()][valorAtual.getPosicaoy() + 1].isClosed() == false) {
					andarDireita();
				} else if (matriz[valorAtual.getPosicaox()][valorAtual.getPosicaoy() - 1].isClosed() == false) {
					andarEsquerda();
				}

			} else if (valorAtual.getPosicaoy() == 9) {

				if (matriz[valorAtual.getPosicaox() + 1][valorAtual.getPosicaoy()].isClosed() == false) {
					andarBaixo();
				} else if (matriz[valorAtual.getPosicaox()][valorAtual.getPosicaoy() - 1].isClosed() == false) {
					andarEsquerda();
				}

			} else if (valorAtual.getPosicaox() == 0) {

				if (matriz[valorAtual.getPosicaox() + 1][valorAtual.getPosicaoy()].isClosed() == false) {
					andarBaixo();
				} else if (matriz[valorAtual.getPosicaox()][valorAtual.getPosicaoy() + 1].isClosed() == false) {
					andarDireita();
				}
			}
		} else if (valorAtual.getPosicaox() > 0) {
			if (valorAtual.getPosicaox() < 9 && valorAtual.getPosicaoy() == 0) {

				if (matriz[valorAtual.getPosicaox() + 1][valorAtual.getPosicaoy()].isClosed() == false) {
					andarBaixo();
				} else if (matriz[valorAtual.getPosicaox()][valorAtual.getPosicaoy() + 1].isClosed() == false) {
					andarDireita();
				} else if (matriz[valorAtual.getPosicaox() - 1][valorAtual.getPosicaoy()].isClosed() == false) {
					andarCima();
				}

			} else if (valorAtual.getPosicaox() == 9 && valorAtual.getPosicaoy() == 0) {

				if (matriz[valorAtual.getPosicaox()][valorAtual.getPosicaoy() + 1].isClosed() == false) {
					andarDireita();
				} else if (matriz[valorAtual.getPosicaox() - 1][valorAtual.getPosicaoy()].isClosed() == false) {
					andarCima();
				}

			} else if (valorAtual.getPosicaox() < 9 && valorAtual.getPosicaoy() > 0 && valorAtual.getPosicaoy() < 9) {

				if (matriz[valorAtual.getPosicaox() + 1][valorAtual.getPosicaoy()].isClosed() == false) {
					andarBaixo();
				} else if (matriz[valorAtual.getPosicaox()][valorAtual.getPosicaoy() + 1].isClosed() == false) {
					andarDireita();
				} else if (matriz[valorAtual.getPosicaox()][valorAtual.getPosicaoy() - 1].isClosed() == false) {
					andarEsquerda();
				} else if (matriz[valorAtual.getPosicaox() - 1][valorAtual.getPosicaoy()].isClosed() == false) {
					andarCima();
				}

			} else if (valorAtual.getPosicaox() > 0 && valorAtual.getPosicaox() < 9 && valorAtual.getPosicaoy() == 9) {

				if (matriz[valorAtual.getPosicaox() + 1][valorAtual.getPosicaoy()].isClosed() == false) {
					andarBaixo();
				} else if (matriz[valorAtual.getPosicaox()][valorAtual.getPosicaoy() - 1].isClosed() == false) {
					andarEsquerda();
				} else if (matriz[valorAtual.getPosicaox() - 1][valorAtual.getPosicaoy()].isClosed() == false) {
					andarCima();
				}

			} else if (valorAtual.getPosicaox() == 9 && valorAtual.getPosicaoy() == 9) {

				if (matriz[valorAtual.getPosicaox()][valorAtual.getPosicaoy() - 1].isClosed() == false) {
					andarEsquerda();
				} else if (matriz[valorAtual.getPosicaox() - 1][valorAtual.getPosicaoy()].isClosed() == false) {
					andarCima();
				}

			} else if (valorAtual.getPosicaox() == 9 && valorAtual.getPosicaoy() < 9 && valorAtual.getPosicaoy() > 0) {

				if (matriz[valorAtual.getPosicaox()][valorAtual.getPosicaoy() + 1].isClosed() == false) {
					andarDireita();
				} else if (matriz[valorAtual.getPosicaox()][valorAtual.getPosicaoy() - 1].isClosed() == false) {
					andarEsquerda();
				} else if (matriz[valorAtual.getPosicaox() - 1][valorAtual.getPosicaoy()].isClosed() == false) {
					andarCima();
				}

			}
		}
	}

	static void prencher(int posicaox, int posicaoy, String tipo, int valor) {
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

	static void mostrar() {
		for (int i = 0; i < matriz.length; i++) {
			String log = " ";
			for (int j = 0; j < matriz.length; j++) {

				if (!matriz[i][j].getTipo().equals("L")) {
					log = log + "[" + matriz[i][j].getTipo() + "] ";
				} else {
					log = log + "[ ] ";
				}
			}
			System.out.println(log);
		}
		System.out.println("\n");

	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Casa teste = new Casa();
				teste.setTipo("L");
				teste.setValor(-1);
				matriz[i][j] = teste;
			}
		}

		matriz[0][0].setTipo("R");
		matriz[0][0].setPosicao(0, 0);
		matriz[9][9].setTipo("F");
		matriz[9][9].setPosicao(9, 9);

		// gerando paredes
		Random r = new Random();
		int numeroParedes = r.nextInt(15) + 10;
		System.out.println("Numero de paredes é " + numeroParedes);
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
		valorAtual = new Casa();
		estadoFinal = new Casa();
		valorAtual.setPosicao(0, 0);
		estadoFinal.setPosicao(9, 9);
		int m = 0;
		while (!valorAtual.getPosicao().equals(estadoFinal.getPosicao())) {
			if (vida > 0) {

				System.out.println("Sentido: Baixo, Direita, Esquerda, Cima");
				System.out.println("Quantidade de Paredes (P): " + numeroParedes);
				System.out.println("5 Vidas de +5 | 3 Vidas de +10");
				System.out.println(
						"Posição Atual: " + valorAtual.getPosicao() + " | Posição Final: " + estadoFinal.getPosicao());
				System.out.println("Vida: " + vida + " | Movimentos: " + m);

				m++;
				mostrar();
				try {
					Thread.sleep(700);
				} catch (InterruptedException ex) {
				}
				acao();
			} else {
				System.out.println("G A M E  O V E R");
				break;

			}
		}
		mostrar();
	}
}
