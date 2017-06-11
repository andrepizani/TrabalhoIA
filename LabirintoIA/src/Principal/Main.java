package Principal;

import java.util.Random;

public class Main {

	private static Casa[][] matriz = new Casa[10][10];
	private static Casa estadoFinal;
	private static Casa estadoAtual;
	private static Casa estadoAnterior;
	private static int vida = 50;
	private static int numeroParedes;
	
	static void andarCima() {

		matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].setTipo("R");
		matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy()].setTipo("-");
		matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy()].setClosed(true);
		estadoAtual.setValor(matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].getValor());
		estadoAtual.setTipo(matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].getTipo());
		estadoAtual.setPosicao(estadoAtual.getPosicaox() - 1, estadoAtual.getPosicaoy());

		vida += estadoAtual.getValor();
	}

	static void andarBaixo() {
		matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].setTipo("R");
		matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy()].setTipo("-");
		matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy()].setClosed(true);
		estadoAtual.setValor(matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].getValor());
		estadoAtual.setTipo(matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].getTipo());
		estadoAtual.setPosicao(estadoAtual.getPosicaox() + 1, estadoAtual.getPosicaoy());

		vida += estadoAtual.getValor();
	}

	static void andarDireita() {
		matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1].setTipo("R");
		matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy()].setTipo("-");
		matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy()].setClosed(true);
		estadoAtual.setValor(matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1].getValor());
		estadoAtual.setTipo(matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1].getTipo());
		estadoAtual.setPosicao(estadoAtual.getPosicaox(), estadoAtual.getPosicaoy() + 1);

		vida += estadoAtual.getValor();
	}

	static void andarEsquerda() {

		matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1].setTipo("R");
		matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy()].setTipo("-");
		matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy()].setClosed(true);
		estadoAtual.setValor(matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1].getValor());
		estadoAtual.setTipo(matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1].getTipo());
		estadoAtual.setPosicao(estadoAtual.getPosicaox(), estadoAtual.getPosicaoy() - 1);

		vida += estadoAtual.getValor();
	}

	static void acao() {
		estadoAnterior.setPosicao(estadoAtual.getPosicaox(), estadoAtual.getPosicaoy());
		if (estadoAtual.getPosicaox() == 0) {
			if (estadoAtual.getPosicaox() > 0 && estadoAtual.getPosicaoy() < 9) {

				if (matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].isClosed() == false) {
					andarBaixo();
				} else if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1].isClosed() == false) {
					andarDireita();
				} else if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1].isClosed() == false) {
					andarEsquerda();
				}

			} else if (estadoAtual.getPosicaoy() == 9) {

				if (matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].isClosed() == false) {
					andarBaixo();
				} else if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1].isClosed() == false) {
					andarEsquerda();
				}

			} else if (estadoAtual.getPosicaox() == 0) {

				if (matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].isClosed() == false) {
					andarBaixo();
				} else if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1].isClosed() == false) {
					andarDireita();
				}
			}
		} else if (estadoAtual.getPosicaox() > 0) {
			if (estadoAtual.getPosicaox() < 9 && estadoAtual.getPosicaoy() == 0) {

				if (matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].isClosed() == false) {
					andarBaixo();
				} else if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1].isClosed() == false) {
					andarDireita();
				} else if (matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].isClosed() == false) {
					andarCima();
				}

			} else if (estadoAtual.getPosicaox() == 9 && estadoAtual.getPosicaoy() == 0) {

				if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1].isClosed() == false) {
					andarDireita();
				} else if (matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].isClosed() == false) {
					andarCima();
				}

			} else if (estadoAtual.getPosicaox() < 9 && estadoAtual.getPosicaoy() > 0 && estadoAtual.getPosicaoy() < 9) {

				if (matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].isClosed() == false) {
					andarBaixo();
				} else if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1].isClosed() == false) {
					andarDireita();
				} else if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1].isClosed() == false) {
					andarEsquerda();
				} else if (matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].isClosed() == false) {
					andarCima();
				}

			} else if (estadoAtual.getPosicaox() > 0 && estadoAtual.getPosicaox() < 9 && estadoAtual.getPosicaoy() == 9) {

				if (matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].isClosed() == false) {
					andarBaixo();
				} else if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1].isClosed() == false) {
					andarEsquerda();
				} else if (matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].isClosed() == false) {
					andarCima();
				}

			} else if (estadoAtual.getPosicaox() == 9 && estadoAtual.getPosicaoy() == 9) {

				if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1].isClosed() == false) {
					andarEsquerda();
				} else if (matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].isClosed() == false) {
					andarCima();
				}

			} else if (estadoAtual.getPosicaox() == 9 && estadoAtual.getPosicaoy() < 9 && estadoAtual.getPosicaoy() > 0) {

				if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1].isClosed() == false) {
					andarDireita();
				} else if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1].isClosed() == false) {
					andarEsquerda();
				} else if (matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].isClosed() == false) {
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
	
	static void gerador(){
		
		//gerando matriz
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Casa teste = new Casa();
				teste.setTipo("L");
				teste.setValor(-1);
				matriz[i][j] = teste;
			}
		}
		//definindo inicio e fim
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

	public static void main(String[] args) {
		
		
		gerador();
		estadoAtual = new Casa();
		estadoFinal = new Casa();
		estadoAtual.setPosicao(0, 0);
		estadoFinal.setPosicao(9, 9);
		estadoAnterior = new Casa();
		estadoAnterior.setPosicao(9, 9);
		int m = 0; 
		
		while (!estadoAtual.getPosicao().equals(estadoFinal.getPosicao())) {
			
			if (vida > 0 && !estadoAtual.getPosicao().equals(estadoAnterior.getPosicao())){
				
				System.out.println("Sentido: Baixo, Direita, Esquerda, Cima");
				System.out.println("Quantidade de Paredes (P): " + numeroParedes);
				System.out.println("5 Vidas de +5 | 3 Vidas de +10");
				System.out.println(
						"Posição Atual: " + estadoAtual.getPosicao() + " | Posição Final: " + estadoFinal.getPosicao() + " | Posição Anterior: " + estadoAnterior.getPosicao());
				System.out.println("Vida: " + vida + " | Movimentos: " + m);

				m++;
				mostrar();
				try {
					Thread.sleep(100);
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
