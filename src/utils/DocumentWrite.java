package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class DocumentWrite {

	public static void write(String text, String separador) {
		try {
			File fav = new File("fav.csv");

			FileWriter fw = new FileWriter(fav, true);

			fw.write(text + separador);
			
			fw.flush();
			fw.close();

		} catch (

		Exception e) {
			JOptionPane.showMessageDialog(null, "No se ha podido incribir adecuadamente en el archivo");
		}
	}
	
	private static void leerArchivo() {
		String filename = "fav.csv";
		Scanner sc = null;
		try {
			sc = new Scanner(new File(filename), "UTF-8");
			System.out.println("hola");
			while (sc.hasNextLine()) {
				String s = sc.nextLine();
				// Omite las cadenas internas ""
				var trozos = s.split(",");
				for (String trozo : trozos) {
					System.out.println(trozo);
					
					
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();
	}

//	List<List<String>> rows = Arrays.asList(
//		    Arrays.asList("Jean", "author", "Java"),
//		    Arrays.asList("David", "editor", "Python"),
//		    Arrays.asList("Scott", "editor", "Node.js")
//		);
}
