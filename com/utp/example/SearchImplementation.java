package com.utp.example;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class SearchImplementation {
	public static void main(String... arg) {
		internalSearch();
		System.out.println("==========================================");
		hashTableSearch();
	}

	private static void hashTableSearch() {
		HashMap<String, String> map = new HashMap<>();
		
		String option = "";
		boolean interactive = false;
		
		do {
			if (!interactive) {
				option = JOptionPane.showInputDialog("""
						Selecciona las opciones:
						1. Ingresar datos
						2. Buscar
						3. Eliminar
						4. Imprimir los valores
						0. Salir
						""");
			}
			
			switch (option) {
			case "0" -> JOptionPane.showMessageDialog(null, "Adios !");
			case "1" -> {
				interactive = true;
				String input = JOptionPane.showInputDialog("""
						- Ingresa los datos separados por coma, ejemplo: \"clave,valor\"
						- Escribe \"salir\" para volver. 
						""");
				if (input != null && !"salir".equals(input)) {
					System.out.println("Se ingreso: " + input);
					String[] values = input.split(",");
					map.put(values[0], values[1]);
				} else {
					interactive = false;
				}
			}
			case "2" -> {
				String input = JOptionPane.showInputDialog("""
						Ingresa el valor a buscar:
						""");
				if (map.containsKey(input)) {
					String value = map.get(input);
					JOptionPane.showMessageDialog(null, "Se encontró el valor: " + value);
					interactive = false;
				} else {
					JOptionPane.showMessageDialog(null, "La clave no existe, volveras al menú inicial");
					interactive = false;
				}
			}
			case "3" -> {
				String input = JOptionPane.showInputDialog("""
						Ingresa el valor a eliminar:
						""");
				if (map.containsKey(input)) {
					map.remove(input);
					JOptionPane.showMessageDialog(null, "Se eliminó con exito la clave: " + input);
					interactive = false;
				} else {
					JOptionPane.showMessageDialog(null, "La clave no existe, volveras al menú inicial");
					interactive = false;
				}
			}
			case "4" -> {
				String values = "";
				for (String key : map.keySet()) {
					values += key + "," + map.get(key) + "\n";
				}
				JOptionPane.showMessageDialog(null, "Tabla de HASH: \n" + values);
				interactive = false;
			}
			default -> JOptionPane.showMessageDialog(null, "Opción invalida!");
			}
		} while (!"0".equals(option));
		
	}

	private static void internalSearch() {
		int[] numbers = { 10, 20, 30, 40, 50 };
		int inputSearch = 30;
		boolean inputSearched = false;
		for (int num : numbers) {
			if (inputSearch == num) {
				System.out.println("El número " + inputSearch + " fue encontrado!");
				inputSearched = true;
				break;
			}
		}
		if (!inputSearched) {
			System.out.println("Lamentablemente no encontramos el número " + inputSearch);
		}
	}
}
