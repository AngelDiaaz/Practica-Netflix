package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class DocumentWrite {
	
	/**
	 * Crea un archivo csv y vuelva todos los shows favoritos en el archivo
	 * @param text Show que queremos volvar en el archivo
	 * @param separador Separador que usamos para separar los distintos shows
	 */

	public static void write(String text, String separador) {
		try {
			File fav = new File("asserts/fav.csv");

			FileWriter fw = new FileWriter(fav, true);

			//Comprueba si el show ya esta registrado previamente o no
			if (comprobarFavoritos(text, separador)) {
				//Escribe el texto en el archivo
				fw.write(text + separador);

				fw.flush();
				fw.close();
			} else {
				JOptionPane.showMessageDialog(null, "Show ya registrado en favoritos");
			}

		} catch (

		Exception e) {
			JOptionPane.showMessageDialog(null, "No se ha podido incribir adecuadamente en el archivo");
		}
	}
	
	/**
	 * Compruba si el show ya esta registrado en favoritos o no
	 * @param text Show que queremos comprobar
	 * @param separador Separador que hemos usado para separar los shows en el texto
	 * @return True si no esta en favoritos y false si ya se encuentra registrado
	 */

	private static boolean comprobarFavoritos(String text, String separador) {
		String filename = "asserts/fav.csv";
		Scanner sc = null;
		try {
			sc = new Scanner(new File(filename), "UTF-8");
			while (sc.hasNextLine()) {
				String s = sc.nextLine();
				// Omite las cadenas internas ""
				var trozos = s.split(separador);
				for (String trozo : trozos) {
					if (text.equals(trozo)) {
						return false;
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();
		return true;
	}
}

//	List<List<String>> rows = Arrays.asList(
//		    Arrays.asList("Jean", "author", "Java"),
//		    Arrays.asList("David", "editor", "Python"),
//		    Arrays.asList("Scott", "editor", "Node.js")
//		);
