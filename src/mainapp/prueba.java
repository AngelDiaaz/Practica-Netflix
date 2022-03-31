package mainapp;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;

public class prueba {

	public static void main(String[] args) {
		
		try {
			FileWriter fw = new FileWriter("prueba.txt");
			
			Files.readAllLines(new File("prueba.txt").toPath());
			
			fw.write("hola");
			
			fw.flush();
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
