package Principal;

public class AlgoritmoA extends Algoritmo {

	private int menorValor = 50;


	public void algoritmoA() {
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

	
	
}
