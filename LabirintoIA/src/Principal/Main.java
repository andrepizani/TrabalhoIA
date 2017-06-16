package Principal;

import java.util.Random;
import java.util.Scanner;

public class Main {

	private static Casa[][] matriz = new Casa[10][10];
	private static Casa estadoFinal;
	private static Casa estadoAtual;
	private static Casa estadoAnterior;
	private static int vida = 50;
	private static int numeroParedes;
	private static int menorValor = 50;
	private static int movimentos = 0;

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

	static void buscaLargura() {
		estadoAnterior.setPosicao(estadoAtual.getPosicaox(), estadoAtual.getPosicaoy());
		if (estadoAtual.getPosicaox() == 0) {
			if (estadoAtual.getPosicaox() > 0 && estadoAtual.getPosicaoy() < 9) {

				if (matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].isClosed() == false) {
					andarBaixo();
				} else if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1].isClosed() == false) {
					andarEsquerda();
				} else if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1].isClosed() == false) {
					andarDireita();
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

			} else if (estadoAtual.getPosicaox() < 9 && estadoAtual.getPosicaoy() > 0
					&& estadoAtual.getPosicaoy() < 9) {

				if (matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].isClosed() == false) {
					andarBaixo();
				} else if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1].isClosed() == false) {
					andarEsquerda();
				} else if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1].isClosed() == false) {
					andarDireita();
				} else if (matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].isClosed() == false) {
					andarCima();
				}

			} else if (estadoAtual.getPosicaox() > 0 && estadoAtual.getPosicaox() < 9
					&& estadoAtual.getPosicaoy() == 9) {

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

			} else if (estadoAtual.getPosicaox() == 9 && estadoAtual.getPosicaoy() < 9
					&& estadoAtual.getPosicaoy() > 0) {
				if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1].isClosed() == false) {
					andarEsquerda();
				} else if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1].isClosed() == false) {
					andarDireita();
				} else if (matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].isClosed() == false) {
					andarCima();
				}

			}
		}
	}

	static void realizarMovimento(String movimento) {
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

	static void algoritmoA() {
		estadoAnterior.setPosicao(estadoAtual.getPosicaox(), estadoAtual.getPosicaoy());
		String movimento = "";
		int direita;
		int esquerda;
		int baixo;
		int cima;
		menorValor = 50;

		if (estadoAtual.getPosicaox() == 0) {

			if (estadoAtual.getPosicaox() > 0 && estadoAtual.getPosicaoy() < 9) {

				if (matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].isClosed() == false) {

					baixo = matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].getDistancia(estadoFinal);

					if (baixo < menorValor) {
						menorValor = baixo;
						movimento = "Baixo";
					}

				} else if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1].isClosed() == false) {

					direita = matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1]
							.getDistancia(estadoFinal);

					if (direita < menorValor) {
						menorValor = direita;
						movimento = "Direita";
					}

				} else if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1].isClosed() == false) {

					esquerda = matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1]
							.getDistancia(estadoFinal);

					if (esquerda < menorValor) {
						menorValor = esquerda;
						movimento = "Esquerda";
					}

				}

			} else if (estadoAtual.getPosicaoy() == 9) {

				if (matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].isClosed() == false) {

					baixo = matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].getDistancia(estadoFinal);

					if (baixo < menorValor) {
						menorValor = baixo;
						movimento = "Baixo";
					}
				} else if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1].isClosed() == false) {

					esquerda = matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1]
							.getDistancia(estadoFinal);

					if (esquerda < menorValor) {
						menorValor = esquerda;
						movimento = "Esquerda";
					}

				}

			} else if (estadoAtual.getPosicaox() == 0) {

				if (matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].isClosed() == false) {

					baixo = matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].getDistancia(estadoFinal);

					if (baixo < menorValor) {
						menorValor = baixo;
						movimento = "Baixo";
					}

				} else if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1].isClosed() == false) {

					direita = matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1]
							.getDistancia(estadoFinal);

					if (direita < menorValor) {
						menorValor = direita;
						movimento = "Direita";
					}

				}
			}
		} else if (estadoAtual.getPosicaox() > 0) {
			if (estadoAtual.getPosicaox() < 9 && estadoAtual.getPosicaoy() == 0) {

				if (matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].isClosed() == false) {

					baixo = matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].getDistancia(estadoFinal);

					if (baixo < menorValor) {
						menorValor = baixo;
						movimento = "Baixo";
					}

				} else if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1].isClosed() == false) {

					direita = matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1]
							.getDistancia(estadoFinal);

					if (direita < menorValor) {
						menorValor = direita;
						movimento = "Direita";
					}

				} else if (matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].isClosed() == false) {

					cima = matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].getDistancia(estadoFinal);

					if (cima < menorValor) {
						menorValor = cima;
						movimento = "Cima";
					}
				}

			} else if (estadoAtual.getPosicaox() == 9 && estadoAtual.getPosicaoy() == 0) {

				if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1].isClosed() == false) {

					direita = matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1]
							.getDistancia(estadoFinal);

					if (direita < menorValor) {
						menorValor = direita;
						movimento = "Direita";
					}

				} else if (matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].isClosed() == false) {

					cima = matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].getDistancia(estadoFinal);

					if (cima < menorValor) {
						menorValor = cima;
						movimento = "Cima";
					}
				}

			} else if (estadoAtual.getPosicaox() < 9 && estadoAtual.getPosicaoy() > 0
					&& estadoAtual.getPosicaoy() < 9) {

				if (matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].isClosed() == false) {

					baixo = matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].getDistancia(estadoFinal);

					if (baixo < menorValor) {
						menorValor = baixo;
						movimento = "Baixo";
					}

				} else if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1].isClosed() == false) {

					direita = matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1]
							.getDistancia(estadoFinal);

					if (direita < menorValor) {
						menorValor = direita;
						movimento = "Direita";
					}

				} else if (matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].isClosed() == false) {

					cima = matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].getDistancia(estadoFinal);

					if (cima < menorValor) {
						menorValor = cima;
						movimento = "Cima";
					}
				} else if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1].isClosed() == false) {

					esquerda = matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1]
							.getDistancia(estadoFinal);

					if (esquerda < menorValor) {
						menorValor = esquerda;
						movimento = "Esquerda";
					}
				}

			} else if (estadoAtual.getPosicaox() > 0 && estadoAtual.getPosicaox() < 9
					&& estadoAtual.getPosicaoy() == 9) {

				if (matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].isClosed() == false) {

					baixo = matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].getDistancia(estadoFinal);

					if (baixo < menorValor) {
						menorValor = baixo;
						movimento = "Baixo";
					}

				} else if (matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].isClosed() == false) {

					cima = matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].getDistancia(estadoFinal);

					if (cima < menorValor) {
						menorValor = cima;
						movimento = "Cima";
					}
				} else if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1].isClosed() == false) {

					esquerda = matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1]
							.getDistancia(estadoFinal);

					if (esquerda < menorValor) {
						menorValor = esquerda;
						movimento = "Esquerda";
					}
				}

			} else if (estadoAtual.getPosicaox() == 9 && estadoAtual.getPosicaoy() == 9) {

				if (matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].isClosed() == false) {

					cima = matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].getDistancia(estadoFinal);

					if (cima < menorValor) {
						menorValor = cima;
						movimento = "Cima";
					}
				} else if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1].isClosed() == false) {

					esquerda = matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1]
							.getDistancia(estadoFinal);

					if (esquerda < menorValor) {
						menorValor = esquerda;
						movimento = "Esquerda";
					}
				}

			} else if (estadoAtual.getPosicaox() == 9 && estadoAtual.getPosicaoy() < 9
					&& estadoAtual.getPosicaoy() > 0) {

				if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1].isClosed() == false) {

					direita = matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1]
							.getDistancia(estadoFinal);

					if (direita < menorValor) {
						menorValor = direita;
						movimento = "Direita";
					}

				} else if (matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].isClosed() == false) {

					cima = matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].getDistancia(estadoFinal);

					if (cima < menorValor) {
						menorValor = cima;
						movimento = "Cima";
					}
				} else if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1].isClosed() == false) {

					esquerda = matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1]
							.getDistancia(estadoFinal);

					if (esquerda < menorValor) {
						menorValor = esquerda;
						movimento = "Esquerda";
					}
				}
			}
		}
		realizarMovimento(movimento);
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

	static void gerador() {

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

	public static void main(String[] args) {
		int opcao = 1;
		Scanner scan = new Scanner(System.in);
		while (opcao > 0) {

			gerador();
			estadoAtual = new Casa();
			estadoFinal = new Casa();
			estadoAtual.setPosicao(0, 0);
			estadoFinal.setPosicao(9, 9);
			estadoAnterior = new Casa();
			estadoAnterior.setPosicao(0, -1);
			movimentos = 0;

			System.out.println("Digite 1 para Busca em Largura ou 2 para Algoritmo A*:");
			int opcaoIA = Integer.parseInt(scan.nextLine());

			while (!estadoAtual.getPosicao().equals(estadoFinal.getPosicao())) {

				if (vida > 0 && !estadoAtual.getPosicao().equals(estadoAnterior.getPosicao())) {

					System.out.println("Sentido: Baixo, Esquerda, Direita, Cima");
					System.out.println("Quantidade de Paredes (P): " + numeroParedes);
					System.out.println("5 Vidas de +5 | 3 Vidas de +10");
					System.out.println("Posição Atual: " + estadoAtual.getPosicao() + " | Posição Final: "
							+ estadoFinal.getPosicao() + " | Posição Anterior: " + estadoAnterior.getPosicao());
					System.out.println("Vida: " + vida + " | Movimentos: " + movimentos + " | Distancia: "
							+ estadoAtual.getDistancia(estadoFinal));

					movimentos++;
					mostrar();

					try {
						Thread.sleep(300);
					} catch (InterruptedException ex) {
					}
					if (opcaoIA == 1) {
						buscaLargura();
					} else {
						algoritmoA();
					}
				} else {
					System.out.println("G A M E  O V E R");
					break;

				}
			}
			mostrar();
			System.out.println("Digite 0 para sair ou 1 para ir novamente:");
			opcao = Integer.parseInt(scan.nextLine());
		}
	}
}
