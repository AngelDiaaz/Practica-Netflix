package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import dao.ShowDAO;
import models.Show;

public class DocumentWrite {

	/**
	 * Crea un archivo csv y vuelva todos los shows favoritos en el archivo
	 * 
	 * @param text Show que queremos volvar en el archivo
	 * @param separador Separador que usamos para separar los distintos shows
	 * @param sobrescribir True si queremos agregar mas al id y false si queremos sobrescribir el documento con el texto que le pasamos
	 */

	public static void write(String text, String separador, boolean sobrescribir, boolean comprobar) {
		try {
			File fav = new File("assets/fav.csv");

			FileWriter fw = new FileWriter(fav, sobrescribir);

			// Comprueba si el show ya esta registrado previamente o no
			if (comprobarFavoritos(text, separador) || comprobar) {
				// Escribe el texto en el archivo
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
	 * Elimina el id del archivo csv que nosotros queremos
	 * 
	 * @param id Id que queremos eliminar del archivo csv
	 * @param separador Caracter con el que esta separado las ids en el archivo csv
	 */
	
	public static void eliminarFavoritos(String id, String separador) {
		String filename = "assets/fav.csv";
		Scanner sc = null;
		boolean sobrescribir = false;
		try {
			sc = new Scanner(new File(filename), "UTF-8");
			while (sc.hasNextLine()) {
				String s = sc.nextLine();
				var trozos = s.split(separador);
					for (String trozo : trozos) {
					//Cuando el id coincide no se escribe en el archivo csv
					if (!id.equals(trozo)) {
						write(trozo,separador, sobrescribir, true);
						sobrescribir = true;
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();
	}

	/**
	 * Compruba si el show ya esta registrado en favoritos o no
	 * 
	 * @param text      Show que queremos comprobar
	 * @param separador Separador que hemos usado para separar los shows en el texto
	 * @return True si no esta en favoritos y false si ya se encuentra registrado
	 */

	private static boolean comprobarFavoritos(String text, String separador) {
		String filename = "assets/fav.csv";
		Scanner sc = null;
		try {
			sc = new Scanner(new File(filename), "UTF-8");
			while (sc.hasNextLine()) {
				String s = sc.nextLine();

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
	
	/**
	 * Lee el archivo de favoritos y saca las ids, y almacena todos los shows de favoritos en un array list
	 * 
	 * @return Array list con todos los shows que se le han dado a favoritos
	 */

	public static ArrayList<Show> readFavs() {
		var shows = new ArrayList<Show>();
		ShowDAO showDAO = new ShowDAO();
		Scanner sc = null;
		File f = new File("assets/fav.csv");
		try {
			sc = new Scanner(f, "UTF-8");
			String s = sc.nextLine();
			var ids = s.split(",");
			
			for (String id : ids) {
				//Llama a la funcion consulta para sacar el show de la base de datos con esa id
				shows.add(showDAO.consulta(id));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return shows;
	}
}
