package Principal;

import java.util.Random;

public class Main {

	private static Casa[][] matriz = new Casa[10][10];
	private static Casa estadoFinal;
	private static Casa valorAtual;
	private static String[][] Stringaux = new String[10][10];
	private static int[][] Matrizaux = new int[10][10];
	private static int vida = 50;

	static void andarCima(int posicaox, int posicaoy) {
		Stringaux[posicaox - 1][posicaoy] = "R";
		Stringaux[posicaox][posicaoy] = "-";
		valorAtual.setTipo(Stringaux[posicaox - 1][posicaoy]);
		valorAtual.setValor(Matrizaux[posicaox - 1][posicaoy]);
		valorAtual.setPosicao(posicaox - 1, posicaoy);
		System.out.println(valorAtual.getPosicaox() + ", " + valorAtual.getPosicaoy());
	}

	static void andarBaixo(int posicaox, int posicaoy) {
		Stringaux[posicaox + 1][posicaoy] = "R";
		Stringaux[posicaox][posicaoy] = "-";
		valorAtual.setTipo(Stringaux[posicaox + 1][posicaoy]);
		valorAtual.setValor(Matrizaux[posicaox + 1][posicaoy]);
		valorAtual.setPosicao(posicaox + 1, posicaoy);
		System.out.println(valorAtual.getPosicaox() + ", " + valorAtual.getPosicaoy());
	}

	static void andarDireita(int posicaox, int posicaoy) {
		Stringaux[posicaox][posicaoy + 1] = "R";
		Stringaux[posicaox][posicaoy] = "-";
		valorAtual.setTipo(Stringaux[posicaox][posicaoy + 1]);
		valorAtual.setValor(Matrizaux[posicaox][posicaoy + 1]);
		valorAtual.setPosicao(posicaox, posicaoy + 1);
		System.out.println(valorAtual.getPosicaox() + ", " + valorAtual.getPosicaoy());
	}

	static void andarEsquerda(int posicaox, int posicaoy) {
		Stringaux[posicaox][posicaoy - 1] = "R";
		Stringaux[posicaox][posicaoy] = "-";
		valorAtual.setTipo(Stringaux[posicaox][posicaoy - 1]);
		valorAtual.setValor(Matrizaux[posicaox][posicaoy - 1]);
		valorAtual.setPosicao(posicaox, posicaoy - 1);
		System.out.println(valorAtual.getPosicaox() + ", " + valorAtual.getPosicaoy());
	}

	static boolean isClosed(int posicaox, int posicaoy) {
		if (Stringaux[posicaox][posicaoy].equals("P") || Stringaux[posicaox][posicaoy].equals("-")) { // no
																										// caso
																										// aquiso
																										// para
			// teste, dps usar
			// campo isclosed
			// objeto.isclosed
			return true;
		}
		return false;
	}

	static void acao(int posicaox, int posicaoy) {

		if (posicaox == 0) {
			if (posicaoy > 0 && posicaoy < 9) {
				// pode andar baixo, direita, esquerda
				// verificar posicao baixo
				if (isClosed(posicaox + 1, posicaoy) == false) {
					andarBaixo(valorAtual.getPosicaox(), valorAtual.getPosicaoy());
				} else if (isClosed(posicaox, posicaoy + 1) == false) {
					andarDireita(valorAtual.getPosicaox(), valorAtual.getPosicaoy());
				} else if (isClosed(posicaox, posicaoy - 1) == false) {
					andarEsquerda(valorAtual.getPosicaox(), valorAtual.getPosicaoy());
				}
			} else if (posicaoy == 9) {
				// pode andar Esquerda, baixo
				if (isClosed(posicaox + 1, posicaoy) == false) {
					andarBaixo(valorAtual.getPosicaox(), valorAtual.getPosicaoy());
				} else if (isClosed(posicaox, posicaoy - 1) == false) {
					andarEsquerda(valorAtual.getPosicaox(), valorAtual.getPosicaoy());
				}
			} else if (posicaoy == 0) {
				// pode direita, baixo
				if (isClosed(posicaox + 1, posicaoy) == false) {
					andarBaixo(valorAtual.getPosicaox(), valorAtual.getPosicaoy());
				} else if (isClosed(posicaox, posicaoy + 1) == false) {
					andarDireita(valorAtual.getPosicaox(), valorAtual.getPosicaoy());
				}
			}
		} else if (posicaox > 0) {
			if (posicaoy == 0 && posicaox < 9) {
				// mover direita, cima, baixo
				if (isClosed(posicaox - 1, posicaoy) == false) {
					andarCima(valorAtual.getPosicaox(), valorAtual.getPosicaoy());
				} else if (isClosed(posicaox + 1, posicaoy) == false) {
					andarBaixo(valorAtual.getPosicaox(), valorAtual.getPosicaoy());
				} else if (isClosed(posicaox, posicaoy + 1) == false) {
					andarDireita(valorAtual.getPosicaox(), valorAtual.getPosicaoy());
				}
			} else if (posicaoy == 0 && posicaox == 9) {
				// mover cima, direita
				if (isClosed(posicaox - 1, posicaoy) == false) {
					andarCima(valorAtual.getPosicaox(), valorAtual.getPosicaoy());
				} else if (isClosed(posicaox, posicaoy + 1) == false) {
					andarDireita(valorAtual.getPosicaox(), valorAtual.getPosicaoy());
				}
			} else if (posicaoy > 0 && posicaox < 9 && posicaoy < 9) {
				// mover cima, direita, baixo, esquerda
				if (isClosed(posicaox - 1, posicaoy) == false) {
					andarCima(valorAtual.getPosicaox(), valorAtual.getPosicaoy());
				} else if (isClosed(posicaox + 1, posicaoy) == false) {
					andarBaixo(valorAtual.getPosicaox(), valorAtual.getPosicaoy());
				} else if (isClosed(posicaox, posicaoy + 1) == false) {
					andarDireita(valorAtual.getPosicaox(), valorAtual.getPosicaoy());
				} else if (isClosed(posicaox, posicaoy - 1) == false) {
					andarEsquerda(valorAtual.getPosicaox(), valorAtual.getPosicaoy());
				}

			} else if (posicaoy == 9 && posicaox < 9 && posicaox > 0) {
				// esquerda, cima, baixo
				if (isClosed(posicaox - 1, posicaoy) == false) {
					andarCima(valorAtual.getPosicaox(), valorAtual.getPosicaoy());
				} else if (isClosed(posicaox + 1, posicaoy) == false) {
					andarBaixo(valorAtual.getPosicaox(), valorAtual.getPosicaoy());
				} else if (isClosed(posicaox, posicaoy - 1) == false) {
					andarEsquerda(valorAtual.getPosicaox(), valorAtual.getPosicaoy());
				}
			} else if (posicaoy == 9 && posicaox == 9) {
				// cima, esquerda
				if (isClosed(posicaox - 1, posicaoy) == false) {
					andarCima(valorAtual.getPosicaox(), valorAtual.getPosicaoy());
				} else if (isClosed(posicaox, posicaoy - 1) == false) {
					andarEsquerda(valorAtual.getPosicaox(), valorAtual.getPosicaoy());
				}
			} else if (posicaoy > 0 && posicaoy < 9 && posicaox == 9) {
				// cima, direita, esquerda
				if (isClosed(posicaox - 1, posicaoy) == false) {
					andarCima(valorAtual.getPosicaox(), valorAtual.getPosicaoy());
				} else if (isClosed(posicaox, posicaoy + 1) == false) {
					andarDireita(valorAtual.getPosicaox(), valorAtual.getPosicaoy());
				} else if (isClosed(posicaox, posicaoy - 1) == false) {
					andarEsquerda(valorAtual.getPosicaox(), valorAtual.getPosicaoy());
				}
			}
		}

	}

	static void prencher(int posicaox, int posicaoy, String tipo, int valor) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (posicaox == i && posicaoy == j) {
					System.out.println(posicaox + ", " + posicaoy);
					if (tipo.equals("P")) {
						matriz[i][j].setClosed(true);
					}
					matriz[i][j].setPosicao(i, j);
					matriz[i][j].setTipo(tipo);
					matriz[i][j].setValor(valor);
				} else {

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
		matriz[9][9].setTipo("F");

		// gerando paredes
		Random r = new Random();
		int numeroParedes = 25;
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
				System.out.println("Cai aqui");
				i--;
			}
			mostrar();
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
						System.out.println("Cai aqui");
						i--;
					}
					mostrar();
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
						System.out.println("Cai aqui");
						i--;
					}
					mostrar();
				}

		


	
		
	}
}
