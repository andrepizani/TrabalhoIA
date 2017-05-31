//mover para cima
		if (posicaoy != 0){
			if (matriz[posicaox - 1][posicaoy] != null) {
				if (matriz[posicaox - 1][posicaoy].isClosed() == false) {
					System.out.println("movmendo para cima");
					
					matriz[posicaox][posicaoy].setClosed(true);
					matriz[posicaox][posicaoy].setTipo("-");
					valorAtual = matriz[posicaox - 1][posicaoy];
					matriz[posicaox - 1][posicaoy].setTipo("R");
					//apoio, retirar dps
					Stringaux[posicaox - 1][posicaoy] = "R";
					Stringaux[posicaox][posicaoy] = "L";
					valorAtual.setTipo(Stringaux[posicaox - 1][posicaoy]);
					valorAtual.setValor(Matrizaux[posicaox + 1][posicaoy]);
					valorAtual.setPosicao(posicaox+1, posicaoy);
					System.out.println(valorAtual.getPosicaox() + ", " + valorAtual.getPosicaoy());
					
					
				}
			}
		//mover para baixo
		}else if (posicaoy != 9 && posicaox < 9){
			System.out.println("Teste");
			if (matriz[posicaox + 1][posicaoy] != null) {
				if (matriz[posicaox + 1][posicaoy].isClosed() == false) {
					System.out.println("movmendo para baixo");
					
					/*matriz[posicaox][posicaoy].setClosed(true);
					matriz[posicaox][posicaoy].setTipo("-");
					valorAtual = matriz[posicaox + 1][posicaoy];
					matriz[posicaox + 1][posicaoy].setTipo("R");*/
					
					//apoio, retirar dps
					Stringaux[posicaox + 1][posicaoy] = "R";
					Stringaux[posicaox][posicaoy] = "-";
					valorAtual.setTipo(Stringaux[posicaox + 1][posicaoy]);
					valorAtual.setValor(Matrizaux[posicaox + 1][posicaoy]);
					valorAtual.setPosicao(posicaox+1, posicaoy);
					System.out.println(valorAtual.getPosicaox() + ", " + valorAtual.getPosicaoy());
					
					
					
					
				}
			}
		}else if (posicaox != 9){
			
			if (matriz[posicaox][posicaoy+1] != null) {
				if (matriz[posicaox][posicaoy+1].isClosed() == false) {
					System.out.println("movmendo para direita");
				/*
				matriz[posicaox][posicaoy].setClosed(true);
				matriz[posicaox][posicaoy].setTipo("-");
				valorAtual = matriz[posicaox][posicaoy+1];
				matriz[posicaox][posicaoy+1].setTipo("R");*/
				
				//apoio, retirar dps
					Stringaux[posicaox][posicaoy+1] = "R";
					Stringaux[posicaox][posicaoy] = "-";
					valorAtual.setTipo(Stringaux[posicaox][posicaoy+1]);
					valorAtual.setValor(Matrizaux[posicaox ][posicaoy+1]);
					valorAtual.setPosicao(posicaox, posicaoy+1);
					System.out.println(valorAtual.getPosicaox() + ", " + valorAtual.getPosicaoy());
					
			}
		}
		}else if (posicaoy != 0){
			if (matriz[posicaox][posicaoy -1] != null) {
				if (matriz[posicaox][posicaoy -1].isClosed() == false) {
					System.out.println("movmendo para esquerda");
				
					matriz[posicaox][posicaoy].setClosed(true);
					matriz[posicaox][posicaoy].setTipo("-");
					valorAtual = matriz[posicaox - 1][posicaoy];
					matriz[posicaox][posicaoy-1].setTipo("R");
					
					//apoio, retirar dps
					Stringaux[posicaox][posicaoy-1] = "R";
					Stringaux[posicaox][posicaoy] = "L";
					valorAtual.setTipo(Stringaux[posicaox][posicaoy-1]);
					valorAtual.setValor(Matrizaux[posicaox][posicaoy-1]);
					valorAtual.setPosicao(posicaox, posicaoy-1);
					System.out.println(valorAtual.getPosicaox() + ", " + valorAtual.getPosicaoy());
				
				}
			}
		}else{
			System.out.println("movmendo para lugar nenhum");
		}