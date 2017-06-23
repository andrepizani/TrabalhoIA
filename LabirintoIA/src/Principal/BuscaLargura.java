package Principal;

public class BuscaLargura extends Algoritmo {
	


	public void buscaLargura() {
		String movimento ="";
		estadoAnterior.setPosicao(estadoAtual.getPosicaox(), estadoAtual.getPosicaoy());
		if (estadoAtual.getPosicaox() == 0) {
			if (estadoAtual.getPosicaox() > 0 && estadoAtual.getPosicaoy() < 9) {
				if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1].isClosed() == false) {
					movimento = "Esquerda";
				} else if (matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].isClosed() == false) {
					movimento = "Baixo";
				} else if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1].isClosed() == false) {
					movimento = "Direita";
				}

			} else if (estadoAtual.getPosicaoy() == 9) {
				if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1].isClosed() == false) {
					movimento = "Esquerda";
				} else if (matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].isClosed() == false) {
					movimento = "Baixo";
				}

			} else if (estadoAtual.getPosicaox() == 0) {

				if (matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].isClosed() == false) {
					movimento = "Baixo";
				} else if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1].isClosed() == false) {
					movimento = "Direita";
				}
			}
		} else if (estadoAtual.getPosicaox() > 0) {
			if (estadoAtual.getPosicaox() < 9 && estadoAtual.getPosicaoy() == 0) {

				if (matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].isClosed() == false) {
					movimento = "Baixo";
				} else if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1].isClosed() == false) {
					movimento = "Direita";
				} else if (matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].isClosed() == false) {
					movimento = "Cima";
				}

			} else if (estadoAtual.getPosicaox() == 9 && estadoAtual.getPosicaoy() == 0) {

				if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1].isClosed() == false) {
					movimento = "Direita";
				} else if (matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].isClosed() == false) {
					movimento = "Cima";
				}

			} else if (estadoAtual.getPosicaox() < 9 && estadoAtual.getPosicaoy() > 0
					&& estadoAtual.getPosicaoy() < 9) {
				if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1].isClosed() == false) {
					movimento = "Esquerda";
				} else if (matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].isClosed() == false) {
					movimento = "Baixo";
				} else if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1].isClosed() == false) {
					movimento = "Direita";
				} else if (matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].isClosed() == false) {
					movimento = "Cima";
				}

			} else if (estadoAtual.getPosicaox() > 0 && estadoAtual.getPosicaox() < 9
					&& estadoAtual.getPosicaoy() == 9) {
				if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1].isClosed() == false) {
					movimento = "Esquerda";
				} else if (matriz[estadoAtual.getPosicaox() + 1][estadoAtual.getPosicaoy()].isClosed() == false) {
					movimento = "Baixo";
				} else if (matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].isClosed() == false) {
					movimento = "Cima";
				}

			} else if (estadoAtual.getPosicaox() == 9 && estadoAtual.getPosicaoy() == 9) {

				if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1].isClosed() == false) {
					movimento = "Esquerda";
				} else if (matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].isClosed() == false) {
					movimento = "Cima";
				}

			} else if (estadoAtual.getPosicaox() == 9 && estadoAtual.getPosicaoy() < 9
					&& estadoAtual.getPosicaoy() > 0) {
				if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() - 1].isClosed() == false) {
					movimento = "Esquerda";
				} else if (matriz[estadoAtual.getPosicaox()][estadoAtual.getPosicaoy() + 1].isClosed() == false) {
					movimento = "Direita";
				} else if (matriz[estadoAtual.getPosicaox() - 1][estadoAtual.getPosicaoy()].isClosed() == false) {
					movimento = "Cima";
				}

			}
		}
		realizarMovimento(movimento);
	}
	
	public String toString(){
		System.out.println("Sentido: Esquerda, Baixo, Direita, Cima");
		return super.toString();
	}

}
