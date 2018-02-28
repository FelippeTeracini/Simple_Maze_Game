package br.pro.hashi.ensino.desagil.tequilada;

import java.io.*;
import java.util.LinkedList;

public class Reader {
	
	void ReadFile(){
			
		try {
			
			String line = null;
			int n_line = 0;
			BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Felippe/Documents/Insper/Semestre 3/Desenvolvimento Colaborativo Ágil/Projetos/Projeto1/teste.txt"));
			
			while((line = reader.readLine()) != null) {
				
				int col = 0;
				
				if(n_line > 0){
					
					LinkedList<String> lista_linha = new LinkedList<>();
					String array[] = line.split("");
					
					while(col < array.length){
						if(array[col].equals("#")){
							array[col] = "X";
						}
					lista_linha.add(array[col]);
					col ++;
					}
					
					String print_linha = String.join("", lista_linha);
					System.out.println(print_linha);
				}
				n_line ++;
			}
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
}

