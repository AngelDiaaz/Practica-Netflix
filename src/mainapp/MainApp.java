package mainapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import dao.ShowDAO;
import models.Show;
import ui.LoginView;

public class MainApp {

	public static void main(String[] args) {

		new LoginView();
}

	private void enviarDatosBD() {
		String filename = "netflix_titles.csv";
		Scanner sc = null;
		boolean isString = false;
		String trozoString = "";
		int fila = 0;
		ShowDAO showDAO = new ShowDAO();
		try {
			sc = new Scanner(new File(filename), "UTF-8");
			sc.nextLine();// cabecera
			while (sc.hasNextLine()) {
			
				String s = sc.nextLine();
				// Omite las cadenas internas ""
				var trozos = s.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				for (String trozo : trozos) {
					if (trozo.startsWith("\"")) {
						trozo = trozo.substring(1, trozo.length() - 1);
						trozo = trozo.replaceAll("\"\"", "");
						isString = true;
					}
					if (trozo.endsWith("\"")) {
						isString = false;
						trozo = trozo.replaceAll("\"\"", "");
						trozoString += trozo;
						trozo = trozoString;
						trozo.substring(0, trozo.length());
						trozoString = "";
					}
					if (isString) {
						trozo = trozo.replaceAll("'", "");
						trozoString += trozo + ",";
					}
					for (int j = 0; j < trozos.length; j++) {
	                    trozos[j] = trozos[j].replaceAll("'", "´");
	                    trozos[j] = trozos[j].replaceAll("\"", "");
	                }
				}
//				for (String string : trozos) {
//					System.out.println(string);
//				}
				showDAO.insert(new Show(trozos[0], trozos[1], trozos[2], trozos[3], trozos[4], trozos[5], trozos[6],
						trozos[7], trozos[8], trozos[9], trozos[10], trozos[11]));
				fila++;
				System.out.println(fila);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();
	}
}
//		File f = new File("netflix_titles.csv");
//		Scanner sc = null;
//
//		try {
//			sc = new Scanner(f, "UTF-8");
//			sc.useDelimiter(",");
//			Show show;
//			sc.nextLine();
//			String s = sc.nextLine();
//			ArrayList<Show> lista = new ArrayList<Show>();
//			String[] palabras = new String[s.length()];
//			String[] aux = new String[12];
//			while (sc.hasNextLine()) {
//				s = sc.nextLine();
//				palabras = new String[s.length() - 1];
//				for (int i = 0; i < s.length() - 1; i++) {
//					String palabra = s.charAt(i) + "";
//					if (s.charAt(i) == '"') {
//						for (int j = i + 1; j < s.length()-1; j++) {
//							if (s.charAt(j) != '"') {
//								i++;
//								palabra += s.charAt(j);
//							} else {
//								i++;
//								palabra += s.charAt(j);
//								break;
//							}
//						}
//						palabras[i] = palabra;
//					} else {
//						for (int j = i + 1; j < s.length() - 1; j++) {
////						System.out.println(s.charAt(j));
//							if (s.charAt(j) != ',') {
//								if (s.charAt(j) != '"') {
//									i++;
//									palabra += s.charAt(j);
//
//								} else {
//									break;
//								}
//							} else if (s.charAt(j) == ',' && s.charAt(j + 1) == ',') {
//								//System.out.println(s.charAt(j + 1));
//								palabras[i] = "Vaciooooo";
//								//System.out.println("aaaaaaaa");
//								i++;
//
//							} else {
//								palabras[i] = palabra;
//								i++;
//								//System.out.println("++++++" + palabra);
//								break;
//							}
//						}
//					}
//				}
//			
//
//			int cont = 0;
//			for (int i = 0; i < palabras.length - 1; i++) {
//				if(cont == 12) {
//					break;
//				}
//				if (palabras[i] != null) {
//					aux[cont++] = palabras[i];
//				}
//			}
//
//			for (int i = 0; i < aux.length - 1; i++) {
//
//				if (aux[i].charAt(0) == ',') {
//					aux[i] = aux[i].substring(1);
//				} else if (aux[i].equals("Vaciooooo")) {
//					aux[i] = " ";
//				}
//				//System.out.println(aux[i]);
//			}
//			show = new Show(aux[0], aux[1], aux[2], aux[3], aux[4], aux[5], aux[6], aux[7], aux[8], aux[9], aux[10],
//					aux[11]);
//			// System.out.println(show);
//			lista.add(show);
//			}
//
//			for (Show a : lista) {
//				System.out.println(a);
//			}

//			//String[] palabras = s.split(",");
//			boolean fin = false;
//
//			for (int j = 0; j < palabras.length; j++) {
//				if (palabras[j].startsWith("\"")) {
//					for (int i = j + 1; i < palabras.length; i++) {
//						if (!fin) {
//							palabras[j] = palabras[j].concat(palabras[i]);
//						}
//						if (palabras[i].endsWith("\"")) {
//							break;
//						}
//					}
//				}
//			}
//
//			for (String string : palabras) {
//				System.out.println(string);
//			}
//
//			for (int j = 0; j < palabras.length; j++) {
//				if (palabras[j].startsWith("\"") && palabras[j].endsWith("\"")) {
//					for (int i = j + 1; i < palabras.length; i++) {
//						if (!palabras[j].contains(palabras[i])) {
//							if (!palabras[i].startsWith("\"") && !palabras[i].endsWith("\""))
//								palabras[++j] = palabras[i];
//						}
////						if(!palabras[j].substring(palabras[j].length() - 5, palabras[j].length() - 1).contains("2")) {
////							j++;
////						}
//
//					}
//				}
//				// System.out.println(palabras[j]);
//			}
//
//			show = new Show(palabras[0], palabras[1], palabras[2], palabras[3], palabras[4], palabras[5], palabras[6],
//					palabras[7], palabras[8], palabras[9], palabras[10], palabras[11]);
//			// System.out.println(show);
//			lista.add(show);
//			// }
//
//			for (Show shows : lista) {
//				System.out.println(shows);
//			}
//
//			for (String string : palabras) {
//				System.out.println(string);
//			}
/*
 * File f = new File("netflix_titles.csv"); Scanner sc = null;
 * 
 * try { sc = new Scanner(f, "UTF-8"); sc.useDelimiter(","); Show show;
 * sc.nextLine(); String s = sc.nextLine(); TreeSet<Show> lista = new
 * TreeSet<Show>((Show s1, Show s2) -> { int show1 =
 * Integer.parseInt(s1.getYear()); int show2 = Integer.parseInt(s1.getYear());
 * 
 * 
 * if(show1 >= show2) { return -1; } else if(s1.getYear() == s2.getYear()) {
 * return 0; } else { return 1; } }); // while (sc.hasNextLine()) { // s =
 * sc.nextLine();
 * 
 * String[] palabras = s.split(","); boolean fin = false;
 * 
 * for (int j = 0; j < palabras.length; j++) { if (palabras[j].startsWith("\""))
 * { for (int i = j + 1; i < palabras.length; i++) { if (!fin) { palabras[j] =
 * palabras[j].concat(palabras[i]); } if (palabras[i].endsWith("\"")) { break; }
 * } } }
 * 
 * for (String string : palabras) { System.out.println(string); }
 * 
 * for (int j = 0; j < palabras.length; j++) { if (palabras[j].startsWith("\"")
 * && palabras[j].endsWith("\"")) { for (int i = j + 1; i < palabras.length;
 * i++) { if (!palabras[j].contains(palabras[i])) { //if(palabras[i].length() !=
 * 5) palabras[++j] = palabras[i]; } //
 * if(!palabras[j].substring(palabras[j].length() - 5, palabras[j].length() -
 * 1).contains("2")) { // j++; // }
 * 
 * } } //System.out.println(palabras[j]); }
 * 
 * 
 * show = new Show(palabras[0], palabras[1], palabras[2], palabras[3],
 * palabras[4], palabras[5], palabras[6], palabras[7], palabras[8], palabras[9],
 * palabras[10], palabras[11]); //System.out.println(show); lista.add(show); //
 * }
 * 
 * // for (Show shows : lista) { // System.out.println(shows); // }
 * 
 * } catch (Exception e) { e.printStackTrace(); } sc.close(); }
 */
