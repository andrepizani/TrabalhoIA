package Principal;

public class Casa {
	
	private int posicaox;
	private int posicaoy;
	private int valor;
	private String tipo; 
	private boolean isClosed = false;

	
	
	public int getDistancia(Casa estadoFinal) {
		int distancia = 0;
		Casa aux = new Casa();
		aux.setPosicao(posicaox, posicaoy);
		
		while (!aux.getPosicao().equals(estadoFinal.getPosicao())) {
			if (aux.getPosicaoy() < 9) {
				aux.setPosicao(aux.getPosicaox(), aux.getPosicaoy() + 1);
				distancia++;
			} else if (aux.getPosicaoy() == 9) {
				aux.setPosicao(aux.getPosicaox() + 1, aux.getPosicaoy());
				distancia++;
			}
		}

		return distancia;
	}


	public boolean isClosed() {
		return isClosed;
	}

	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}

	public Casa(String tipo, int valor){
		this.setTipo(tipo);
		this.setValor(valor);
	}
	public Casa(){
		
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void setPosicao(int posicaox, int posicaoy) {
		this.posicaoy = posicaoy;
		this.posicaox = posicaox;
	}
	public String getPosicao() {
		return posicaox + "," +posicaoy;
	}
	public int getPosicaox() {
		return posicaox;
	}
	public void setPosicaox(int posicaox) {
		this.posicaox = posicaox;
	}
	public int getPosicaoy() {
		return posicaoy;
	}
	public void setPosicaoy(int posicaoy) {
		this.posicaoy = posicaoy;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}


	
	
	

}
