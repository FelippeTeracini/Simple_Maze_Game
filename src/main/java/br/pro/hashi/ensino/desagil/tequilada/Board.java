package br.pro.hashi.ensino.desagil.tequilada;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Board {
	
	boolean isWall[][];
	
	void loadFromFile(String path){
		
		try{
			
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			String line = reader.readLine();
			
			String[] words = line.split(" ");
			
			int numRows = Integer.parseInt(words[0]);
			int numColumns = Integer.parseInt(words[1]);
			
			isWall = new boolean[numRows][numColumns];
			
			for(int i = 0; i < numRows; i++){
				
				line = reader.readLine();
				
				for(int j = 0; j < numColumns; j++){
					
					boolean value;
					
					if(line.charAt(j) == '#'){
						value = true;
					}
					else{
						value = false;
					}
					
					isWall[i][j] = value;
				}
			}
			
			reader.close();
			
		}
		
		catch(FileNotFoundException exception){
			
			System.out.println(exception);
			
		}
		
		catch(IOException exception){
			
			System.out.println(exception);
			
		}
	}
	
}
