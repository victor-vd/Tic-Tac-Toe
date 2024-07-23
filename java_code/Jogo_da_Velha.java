package jogoDaVelha;

import java.util.Scanner;

public class Jogo_da_Velha {

	public static void main(String[] args) {
		Scanner JogoDaVelhaSc = new Scanner(System.in);

		@SuppressWarnings("unused")
		int pausarTela, repetir;
		char[][] posicao = new char[3][3];
		char bolaOuCruzP1, bolaOuCruzP2;
		boolean[][] jaJogado = new boolean[3][3];
		int w = 0, x = 0, y = 0, z = 0, rodada = 1;
		do {
		//Atribui espaços em todas as posições de posicao[][]
		for (int i = 0; i <= 2; i++) {
			for (int k = 0; k <= 2; k++) {
				posicao[i][k] = ' ';
			}
		}
		
		do {
			System.out.println("O Jogador 1 vai ser o 'X' ou 'O'?");
			bolaOuCruzP1 = JogoDaVelhaSc.next().toUpperCase().charAt(0);
		} while (bolaOuCruzP1 != 'X' && bolaOuCruzP1 != 'O');
		
		//Atribui o que o segundo jogador vai jogar
		if (bolaOuCruzP1 == 'X') {
			bolaOuCruzP2 = 'O';
		} else {
			bolaOuCruzP2 = 'X';
		}

		System.out.println("\n\n\n\n");
		//imprimir tabuleiro
		System.out.println("\n\n\n\n");
		System.out.println(" " + posicao[0][0] + " | " + posicao[0][1] + " | " + posicao[0][2] + "");
		System.out.println("---" + "|" + "---" + "|" + "---");
		System.out.println(" " + posicao[1][0] + " | " + posicao[1][1] + " | " + posicao[1][2] + "");
		System.out.println("---" + "|" + "---" + "|" + "---");
		System.out.println(" " + posicao[2][0] + " | " + posicao[2][1] + " | " + posicao[2][2] + "");
		
		for (int i = 0; i <= 9; i++) {
			if (bolaOuCruzP1 == 'X' || i > 0) {
				do {
					do {
						//Jogador 1 joga
						System.out.println("Rodada: "+rodada);
						System.out.println("\n Vez do Jogador 1! ["+bolaOuCruzP1+"]");
						System.out.println("Qual a posição que você deseja jogar (de 1 a 3)?");
						System.out.print("Linha: ");
						w = JogoDaVelhaSc.nextInt() - 1;
						System.out.print("Coluna: ");
						x = JogoDaVelhaSc.nextInt() - 1;
					} while ((w > 3 || w < 0) || (x > 3 || x < 0));
					//Checa se já a posição do tabuleiro já foi jogada
					if (jaJogado[w][x] == false) {
						posicao[w][x] = bolaOuCruzP1;
						rodada++;
						//imprimir tabuleiro
						System.out.println("\n\n\n\n");
						System.out.println(" " + posicao[0][0] + " | " + posicao[0][1] + " | " + posicao[0][2] + "");
						System.out.println("---" + "|" + "---" + "|" + "---");
						System.out.println(" " + posicao[1][0] + " | " + posicao[1][1] + " | " + posicao[1][2] + "");
						System.out.println("---" + "|" + "---" + "|" + "---");
						System.out.println(" " + posicao[2][0] + " | " + posicao[2][1] + " | " + posicao[2][2] + "");
					} else {
						System.out.println("Essa posição já foi jogada");
					}
				} while (jaJogado[w][x] == true);
				jaJogado[w][x] = true;
			}

			
			//Verifica vitória
			if 		(((posicao[0][0] == 'X' && posicao[0][1] == 'X' && posicao[0][2] == 'X') 		// checa vitorias de X horizontal
					|| (posicao[1][0] == 'X' && posicao[1][1] == 'X' && posicao[1][2] == 'X') 		// checa vitorias de X horizontal
					|| (posicao[2][0] == 'X' && posicao[2][1] == 'X' && posicao[2][2] == 'X')) 		// checa vitorias de X horizontal
					|| ((posicao[0][0] == 'X' && posicao[1][0] == 'X' && posicao[2][0] == 'X') 		// checa vitorias de X vertical
					|| (posicao[0][1] == 'X' && posicao[1][1] == 'X' && posicao[2][1] == 'X') 		// checa vitorias de X vertical
					|| (posicao[0][2] == 'X' && posicao[1][2] == 'X' && posicao[2][2] == 'X')) 		// checa vitorias de X vertical
					|| ((posicao[0][0] == 'X' && posicao[1][1] == 'X' && posicao[2][2] == 'X') 		// checa vitorias de X diagonal
					|| (posicao[0][2] == 'X' && posicao[1][1] == 'X' && posicao[2][0] == 'X'))) 	// checa vitorias de X diagonal
			{
				if (bolaOuCruzP1 == 'X') {
					System.out.println("/----------------------------\\");
					System.out.println("|     O Jogador 1 ganhou     |");
					System.out.println("\\----------------------------/");
					pausarTela = JogoDaVelhaSc.nextInt();
					break;
				} else {
					System.out.println("/----------------------------\\");
					System.out.println("|     O Jogador 2 ganhou     |");
					System.out.println("\\----------------------------/");
					pausarTela = JogoDaVelhaSc.nextInt();
					break;
				}
			} else if	(((posicao[0][0] == 'O' && posicao[0][1] == 'O' && posicao[0][2] == 'O') 		// checa vitorias de O horizontal
						|| (posicao[1][0] == 'O' && posicao[1][1] == 'O' && posicao[1][2] == 'O') 		// checa vitorias de O horizontal
						|| (posicao[2][0] == 'O' && posicao[2][1] == 'O' && posicao[2][2] == 'O'))		// checa vitorias de O horizontal
						|| ((posicao[0][0] == 'O' && posicao[1][0] == 'O' && posicao[2][0] == 'O') 		// checa vitorias de O vertical
						|| (posicao[0][1] == 'O' && posicao[1][1] == 'O' && posicao[2][1] == 'O') 		// checa vitorias de O vertical
						|| (posicao[0][2] == 'O' && posicao[1][2] == 'O' && posicao[2][2] == 'O')) 		// checa vitorias de O vertical
						|| ((posicao[0][0] == 'O' && posicao[1][1] == 'O' && posicao[2][2] == 'O') 		// checa vitorias de O diagonal
						|| (posicao[0][2] == 'O' && posicao[1][1] == 'O' && posicao[2][0] == 'O'))) 	// checa vitorias de O diagonal
			{
				if (bolaOuCruzP1 == 'O') {
					System.out.println("/--------------------------\\");
					System.out.println("|   O Jogador 1 ganhou!!   |");
					System.out.println("\\--------------------------/");
					pausarTela = JogoDaVelhaSc.nextInt();
					break;
				} else {
					System.out.println("/--------------------------\\");
					System.out.println("|   O Jogador 2 ganhou!!   |");
					System.out.println("\\--------------------------/");
					pausarTela = JogoDaVelhaSc.nextInt();
					break;
				}
			} else if (rodada == 10) {
				System.out.println("/----------------\\");
				System.out.println("|     Empate     |");
				System.out.println("\\----------------/");
				pausarTela = JogoDaVelhaSc.nextInt();
				break;
			}
			
			
			// Jogador 2 joga
			do {
				do {
					System.out.println("Rodada: "+rodada);
					System.out.println("\n Vez do Jogador 2! ["+bolaOuCruzP2+"]");
					System.out.println("Qual a posição que você deseja jogar (de 1 a 3)?");
					System.out.print("Linha: ");
					y = JogoDaVelhaSc.nextInt() - 1;
					System.out.print("Coluna: ");
					z = JogoDaVelhaSc.nextInt() - 1;
				} while ((y > 3 || y < 0) || (z > 3 || z < 0));

				if (jaJogado[y][z] == false) {
					posicao[y][z] = bolaOuCruzP2;
					rodada++;
					//imprimir tabuleiro
					System.out.println("\n\n\n\n");
					System.out.println(" " + posicao[0][0] + " | " + posicao[0][1] + " | " + posicao[0][2] + "");
					System.out.println("---" + "|" + "---" + "|" + "---");
					System.out.println(" " + posicao[1][0] + " | " + posicao[1][1] + " | " + posicao[1][2] + "");
					System.out.println("---" + "|" + "---" + "|" + "---");
					System.out.println(" " + posicao[2][0] + " | " + posicao[2][1] + " | " + posicao[2][2] + "");
				} else {
					System.out.println("Essa posição já foi jogada");
				}
			} while (jaJogado[y][z] == true);
			jaJogado[y][z] = true;
			
			
			
			//Verificar vitória
			if 		(((posicao[0][0] == 'X' && posicao[0][1] == 'X' && posicao[0][2] == 'X') 		// checa vitorias de X horizontal
					|| (posicao[1][0] == 'X' && posicao[1][1] == 'X' && posicao[1][2] == 'X') 		// checa vitorias de X horizontal
					|| (posicao[2][0] == 'X' && posicao[2][1] == 'X' && posicao[2][2] == 'X')) 		// checa vitorias de X horizontal
					|| ((posicao[0][0] == 'X' && posicao[1][0] == 'X' && posicao[2][0] == 'X') 		// checa vitorias de X vertical
					|| (posicao[0][1] == 'X' && posicao[1][1] == 'X' && posicao[2][1] == 'X') 		// checa vitorias de X vertical
					|| (posicao[0][2] == 'X' && posicao[1][2] == 'X' && posicao[2][2] == 'X')) 		// checa vitorias de X vertical
					|| ((posicao[0][0] == 'X' && posicao[1][1] == 'X' && posicao[2][2] == 'X') 		// checa vitorias de X diagonal
					|| (posicao[0][2] == 'X' && posicao[1][1] == 'X' && posicao[2][0] == 'X'))) 	// checa vitorias de X diagonal
			{
				if (bolaOuCruzP1 == 'X') {
					System.out.println("/----------------------------\\");
					System.out.println("|     O Jogador 1 ganhou     |");
					System.out.println("\\----------------------------/");
					pausarTela = JogoDaVelhaSc.nextInt();
					break;
				} else {
					System.out.println("/----------------------------\\");
					System.out.println("|     O Jogador 2 ganhou     |");
					System.out.println("\\----------------------------/");
					pausarTela = JogoDaVelhaSc.nextInt();
					break;
				}
			} else if	(((posicao[0][0] == 'O' && posicao[0][1] == 'O' && posicao[0][2] == 'O') 		// checa vitorias de O horizontal
						|| (posicao[1][0] == 'O' && posicao[1][1] == 'O' && posicao[1][2] == 'O') 		// checa vitorias de O horizontal
						|| (posicao[2][0] == 'O' && posicao[2][1] == 'O' && posicao[2][2] == 'O'))		// checa vitorias de O horizontal
						|| ((posicao[0][0] == 'O' && posicao[1][0] == 'O' && posicao[2][0] == 'O') 		// checa vitorias de O vertical
						|| (posicao[0][1] == 'O' && posicao[1][1] == 'O' && posicao[2][1] == 'O') 		// checa vitorias de O vertical
						|| (posicao[0][2] == 'O' && posicao[1][2] == 'O' && posicao[2][2] == 'O')) 		// checa vitorias de O vertical
						|| ((posicao[0][0] == 'O' && posicao[1][1] == 'O' && posicao[2][2] == 'O') 		// checa vitorias de O diagonal
						|| (posicao[0][2] == 'O' && posicao[1][1] == 'O' && posicao[2][0] == 'O'))) 	// checa vitorias de O diagonal
			{
				if (bolaOuCruzP1 == 'O') {
					System.out.println("/--------------------------\\");
					System.out.println("|   O Jogador 1 ganhou!!   |");
					System.out.println("\\--------------------------/");
					pausarTela = JogoDaVelhaSc.nextInt();
					break;
				} else {
					System.out.println("/--------------------------\\");
					System.out.println("|   O Jogador 2 ganhou!!   |");
					System.out.println("\\--------------------------/");
					pausarTela = JogoDaVelhaSc.nextInt();
					break;
				}
			} else if (rodada == 10) {
				System.out.println("/----------------\\");
				System.out.println("|     Empate     |");
				System.out.println("\\----------------/");
				pausarTela = JogoDaVelhaSc.nextInt();
				break;
			}
		
			
		}
		System.out.println("Deseja jogar nomvamente? [1]: Sim [2]: Não");
		repetir = JogoDaVelhaSc.nextInt();
		}while(repetir!=2);
		
		JogoDaVelhaSc.close();
	}

}
