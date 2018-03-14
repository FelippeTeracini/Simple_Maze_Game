package br.pro.hashi.ensino.desagil.tequilada;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Board {
	private boolean[][] isWall;
	private int numRows;
	private int numCols;


	public Board(String path) {
		// A instrução "try" delimita um trecho no qual erros
		// graves, que devem ser tratados, podem acontecer.
		try {
			// Objetos da classe FileReader não possuem o método
			// readLine, então construímos um objeto da classe
			// BufferedReader "em volta" para dar essa capacidade.
			BufferedReader reader = new BufferedReader(new FileReader(path));

			// Lê a primeira linha do arquivo e devolve como String.
			String line = reader.readLine();

			// Usando espaços em branco como o critério de separação,
			// quebra a string em pedaços e devolve um vetor de strings.
			String[] words = line.split(" ");

			// Converte cada um dos dois pedaços em um inteiro.
			numRows = Integer.parseInt(words[0]);
			numCols = Integer.parseInt(words[1]);

			// Constrói uma matriz, de acordo com o número de colunas
			// e número de linhas lidos do arquivo, e atribui a isWall.
			isWall = new boolean[numRows][numCols];

			// Para cada uma das linhas restantes do arquivo...
			for(int i = 0; i < numRows; i++) {
				line = reader.readLine();

				// Para cada um dos caracteres da linha...
				for(int j = 0; j < numCols; j++) {
					boolean value;

					if(line.charAt(j) == '#') {
						value = true;
					}
					else {
						value = false;
					}

					isWall[i][j] = value;
				}
			}

			// Fecha o reader, pois seu uso terminou.
			reader.close();
		}

		// Trata o erro FileNotFoundException, se ele acontecer.
		catch(FileNotFoundException exception) {
			System.out.println(exception);
		}

		// Trata o erro IOException, se ele acontecer.
		catch(IOException exception) {
			System.out.println(exception);
		}
	}


	public boolean isWall(int row, int col) {
	    return isWall[row][col];
	}


	public int getNumRows() {
		return numRows;
	}
	public int getNumCols() {
		return numCols;
	}
}
