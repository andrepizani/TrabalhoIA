package Principal;

public class Main {

	private static Casa[][] matriz = new Casa[10][10];
	private static Casa estadoFinal;
	private static Casa valorAtual;
	private static String[][] Stringaux = new String[10][10];
	private static int[][] Matrizaux = new int[10][10];

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
		if (Stringaux[posicaox][posicaoy].equals("P") || Stringaux[posicaox][posicaoy].equals("-")) { // no caso aquiso para
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
				}  else if (isClosed(posicaox + 1, posicaoy) == false) {
					andarBaixo(valorAtual.getPosicaox(), valorAtual.getPosicaoy());
				}	else if (isClosed(posicaox, posicaoy + 1) == false) {
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

			} else if (posicaoy == 9 && posicaox < 9 && posicaox >0) {
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

	public static void main(String[] args) {

		Stringaux[0][0] = "R";
		Stringaux[0][1] = "P";
		Stringaux[0][2] = "L";
		Stringaux[0][3] = "L";
		Stringaux[0][4] = "V";
		Stringaux[0][5] = "L";
		Stringaux[0][6] = "L";
		Stringaux[0][7] = "L";
		Stringaux[0][8] = "L";
		Stringaux[0][9] = "P";

		Stringaux[1][0] = "L";
		Stringaux[1][1] = "P";
		Stringaux[1][2] = "P";
		Stringaux[1][3] = "P";
		Stringaux[1][4] = "P";
		Stringaux[1][5] = "L";
		Stringaux[1][6] = "P";
		Stringaux[1][7] = "P";
		Stringaux[1][8] = "F";
		Stringaux[1][9] = "L";

		Stringaux[2][0] = "L";
		Stringaux[2][1] = "V";
		Stringaux[2][2] = "L";
		Stringaux[2][3] = "L";
		Stringaux[2][4] = "L";
		Stringaux[2][5] = "L";
		Stringaux[2][6] = "L";
		Stringaux[2][7] = "L";
		Stringaux[2][8] = "L";
		Stringaux[2][9] = "L";

		Stringaux[3][0] = "L";
		Stringaux[3][1] = "P";
		Stringaux[3][2] = "L";
		Stringaux[3][3] = "P";
		Stringaux[3][4] = "V";
		Stringaux[3][5] = "L";
		Stringaux[3][6] = "L";
		Stringaux[3][7] = "P";
		Stringaux[3][8] = "V";
		Stringaux[3][9] = "L";

		Stringaux[4][0] = "L";
		Stringaux[4][1] = "L";
		Stringaux[4][2] = "L";
		Stringaux[4][3] = "P";
		Stringaux[4][4] = "P";
		Stringaux[4][5] = "L";
		Stringaux[4][6] = "L";
		Stringaux[4][7] = "P";
		Stringaux[4][8] = "P";
		Stringaux[4][9] = "L";

		Stringaux[5][0] = "L";
		Stringaux[5][1] = "P";
		Stringaux[5][2] = "L";
		Stringaux[5][3] = "P";
		Stringaux[5][4] = "V";
		Stringaux[5][5] = "L";
		Stringaux[5][6] = "L";
		Stringaux[5][7] = "P";
		Stringaux[5][8] = "L";
		Stringaux[5][9] = "L";

		Stringaux[6][0] = "L";
		Stringaux[6][1] = "V";
		Stringaux[6][2] = "L";
		Stringaux[6][3] = "L";
		Stringaux[6][4] = "L";
		Stringaux[6][5] = "P";
		Stringaux[6][6] = "P";
		Stringaux[6][7] = "P";
		Stringaux[6][8] = "V";
		Stringaux[6][9] = "P";

		Stringaux[7][0] = "L";
		Stringaux[7][1] = "L";
		Stringaux[7][2] = "P";
		Stringaux[7][3] = "L";
		Stringaux[7][4] = "L";
		Stringaux[7][5] = "L";
		Stringaux[7][6] = "L";
		Stringaux[7][7] = "P";
		Stringaux[7][8] = "L";
		Stringaux[7][9] = "P";

		Stringaux[8][0] = "L";
		Stringaux[8][1] = "L";
		Stringaux[8][2] = "P";
		Stringaux[8][3] = "L";
		Stringaux[8][4] = "P";
		Stringaux[8][5] = "L";
		Stringaux[8][6] = "L";
		Stringaux[8][7] = "L";
		Stringaux[8][8] = "L";
		Stringaux[8][9] = "L";

		Stringaux[9][0] = "L";
		Stringaux[9][1] = "L";
		Stringaux[9][2] = "P";
		Stringaux[9][3] = "L";
		Stringaux[9][4] = "P";
		Stringaux[9][5] = "V";
		Stringaux[9][6] = "L";
		Stringaux[9][7] = "P";
		Stringaux[9][8] = "P";
		Stringaux[9][9] = "L";

		Matrizaux[0][0] = 0;
		Matrizaux[0][1] = 0;
		Matrizaux[0][2] = -1;
		Matrizaux[0][3] = -1;
		Matrizaux[0][4] = 10;
		Matrizaux[0][5] = -1;
		Matrizaux[0][6] = -1;
		Matrizaux[0][7] = -1;
		Matrizaux[0][8] = -1;
		Matrizaux[0][9] = 0;

		Matrizaux[1][0] = -1;
		Matrizaux[1][1] = 0;
		Matrizaux[1][2] = 0;
		Matrizaux[1][3] = 0;
		Matrizaux[1][4] = 0;
		Matrizaux[1][5] = -1;
		Matrizaux[1][6] = 0;
		Matrizaux[1][7] = 0;
		Matrizaux[1][8] = 20;
		Matrizaux[1][9] = 0;

		Matrizaux[2][0] = -1;
		Matrizaux[2][1] = 5;
		Matrizaux[2][2] = -1;
		Matrizaux[2][3] = -1;
		Matrizaux[2][4] = -1;
		Matrizaux[2][5] = -1;
		Matrizaux[2][6] = -1;
		Matrizaux[2][7] = -1;
		Matrizaux[2][8] = -1;
		Matrizaux[2][9] = -1;

		Matrizaux[3][0] = -1;
		Matrizaux[3][1] = 0;
		Matrizaux[3][2] = 0;
		Matrizaux[3][3] = 0;
		Matrizaux[3][4] = 5;
		Matrizaux[3][5] = -1;
		Matrizaux[3][6] = -1;
		Matrizaux[3][7] = 0;
		Matrizaux[3][8] = 10;
		Matrizaux[3][9] = -1;

		Matrizaux[4][0] = -1;
		Matrizaux[4][1] = -1;
		Matrizaux[4][2] = -1;
		Matrizaux[4][3] = 0;
		Matrizaux[4][4] = 0;
		Matrizaux[4][5] = -1;
		Matrizaux[4][6] = -1;
		Matrizaux[4][7] = 0;
		Matrizaux[4][8] = 0;
		Matrizaux[4][9] = -1;

		Matrizaux[5][0] = -1;
		Matrizaux[5][1] = 0;
		Matrizaux[5][2] = -1;
		Matrizaux[5][3] = 0;
		Matrizaux[5][4] = 10;
		Matrizaux[5][5] = -1;
		Matrizaux[5][6] = -1;
		Matrizaux[5][7] = 0;
		Matrizaux[5][8] = -1;
		Matrizaux[5][9] = -1;

		Matrizaux[6][0] = -1;
		Matrizaux[6][1] = 5;
		Matrizaux[6][2] = -1;
		Matrizaux[6][3] = -1;
		Matrizaux[6][4] = -1;
		Matrizaux[6][5] = 0;
		Matrizaux[6][6] = 0;
		Matrizaux[6][7] = 0;
		Matrizaux[6][8] = 5;
		Matrizaux[6][9] = 0;

		Matrizaux[7][0] = -1;
		Matrizaux[7][1] = -1;
		Matrizaux[7][2] = 0;
		Matrizaux[7][3] = -1;
		Matrizaux[7][4] = -1;
		Matrizaux[7][5] = -1;
		Matrizaux[7][6] = -1;
		Matrizaux[7][7] = 0;
		Matrizaux[7][8] = -1;
		Matrizaux[7][9] = 0;

		Matrizaux[8][0] = -1;
		Matrizaux[8][1] = -1;
		Matrizaux[8][2] = 0;
		Matrizaux[8][3] = -1;
		Matrizaux[8][4] = 0;
		Matrizaux[8][5] = -1;
		Matrizaux[8][6] = -1;
		Matrizaux[8][7] = -1;
		Matrizaux[8][8] = -1;
		Matrizaux[8][9] = -1;

		Matrizaux[9][0] = -1;
		Matrizaux[9][1] = -1;
		Matrizaux[9][2] = 0;
		Matrizaux[9][3] = -1;
		Matrizaux[9][4] = 0;
		Matrizaux[9][5] = 5;
		Matrizaux[9][6] = -1;
		Matrizaux[9][7] = 0;
		Matrizaux[9][8] = 0;
		Matrizaux[9][9] = 0;

		/*
		 * for (int i = 0; i < matriz.length; i++) { String log = " "; for (int
		 * j = 0; j < matriz.length; j++) { matriz[i][j] = new
		 * Casa(Stringaux[i][j], Matrizaux[i][j]); log = log + "[" +
		 * matriz[i][j].getTipo() + "] "; } System.out.println(log);
		 * 
		 * }
		 */

		valorAtual = new Casa(Stringaux[0][0], Matrizaux[0][0]);
		valorAtual.setPosicaox(0);
		valorAtual.setPosicaoy(0);
		estadoFinal = new Casa(Stringaux[9][9], Matrizaux[1][8]);
		estadoFinal.setPosicaox(1);
		
		
		while (valorAtual.getValor() != estadoFinal.getValor()) {
			for (int i = 0; i < matriz.length; i++) {
				String log = " ";
				for (int j = 0; j < matriz.length; j++) {
					matriz[i][j] = new Casa(Stringaux[i][j], Matrizaux[i][j]);
					if (!matriz[i][j].getTipo().equals("L")) {
						log = log + "[" + matriz[i][j].getTipo() + "] ";
					} else {
						log = log + "[ ] ";
					}
				}
				System.out.println(log);

			}

			System.out.println("\n");
			try {
				Thread.sleep(500);
			} catch (InterruptedException ex) {
			}

			acao(valorAtual.getPosicaox(), valorAtual.getPosicaoy());
		}
	}
}
