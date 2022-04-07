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
	
	private final static String fav = "assets/fav.csv";
	private static File f = new File(fav);

	/**
	 * Crea un archivo csv y vuelva todos los shows favoritos en el archivo
	 * 
	 * @param text         Show que queremos volvar en el archivo
	 * @param separador    Separador que usamos para separar los distintos shows
	 * @param sobrescribir True si queremos agregar mas a las ids y false si queremos
	 *                     sobrescribir el documento con el texto que le pasamos
	 */

	public static void write(String text, String separador, boolean sobrescribir, boolean comprobar) {
		try {
			FileWriter fw = new FileWriter(f, sobrescribir);

			// Comprueba si el show ya esta registrado previamente o no
			if (comprobarFavoritos(text) || comprobar) {
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
	 * @param id        Id que queremos eliminar del archivo csv
	 * @param separador Caracter con el que esta separado las ids en el archivo csv
	 */

	public static void eliminarFavoritos(String id, String separador) {
		Scanner sc = null;
		boolean sobrescribir = false;
		try {
			sc = new Scanner(f, "UTF-8");
			while (sc.hasNextLine()) {
				String s = sc.nextLine();
				var trozos = s.split(",|;|\t");
				for (String trozo : trozos) {
					if(trozos.length == 1) {
						separador = "";
					}
					
					// Cuando el id coincide no se escribe en el archivo csv, la primera vez que se
					// usa este metodo se sobrescribe el csv
					if (!id.equals(trozo)) {
						write(trozo, separador, sobrescribir, true);
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

	public static boolean comprobarFavoritos(String text) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File(fav), "UTF-8");
			while (sc.hasNextLine()) {
				String s = sc.nextLine();

				var trozos = s.split(",|;|\t");
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
	 * Lee el archivo de favoritos y saca las ids, y almacena todos los shows de
	 * favoritos en un array list
	 * 
	 * @return Array list con todos los shows que se le han dado a favoritos
	 */

	public static ArrayList<Show> readFavs() {
		var shows = new ArrayList<Show>();
		ShowDAO showDAO = new ShowDAO();
		Scanner sc = null;
		try {
			sc = new Scanner(f, "UTF-8");
			String s = sc.nextLine();
			var ids = s.split(",|;|\t");

			for (String id : ids) {
				// Llama a la funcion consulta para sacar el show de la base de datos con esa id
				shows.add(showDAO.consulta(id));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return shows;
	}
	
	/**
	 * Elimina el archivo csv y vuelve a crear otro nuevo
	 */
	
	public static void deleteFile() {
		f.delete();
		
		f = new File(fav);
		
	}
}
