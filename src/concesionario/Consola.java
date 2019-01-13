package concesionario;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Consola {

	static Scanner sc = new Scanner(System.in);
	public static int pedirMenu() {
		// TODO Auto-generated method stub
		boolean entrada_correcta=false;
		System.out.println("1 - Insertar vehículo");
		System.out.println("2 - Listar vehículos");
		System.out.println("3 - Buscar vehículos");
		System.out.println("4 - Exportar (a csv o sql)");
		System.out.println("5 - Salir");
		
		int n=0;
		while(entrada_correcta==false) 
		{
				try {
					n = sc.nextInt();
					sc.nextLine();
					entrada_correcta=true;
				} catch (InputMismatchException e) {
					// TODO: handle exception
					System.out.println("Introduzca un numero por favor");
					sc.nextLine(); //tenemos que poner esto para que no se quede en modo bucle el error
					
				}
		}		
		
		return n;
	}

	public static int pedirExportacion() {
		// TODO Auto-generated method stub
		boolean entrada_correcta=false;
		System.out.println("1 - Exportar como csv");
		System.out.println("2 - Exportar como sql");
		int n=0;
		while(entrada_correcta==false) 
		{
				try {
					n = sc.nextInt();
					entrada_correcta=true;
				} catch (InputMismatchException e) {
					// TODO: handle exception
					System.out.println("Introduzca el 1 o el 2");
					sc.nextLine(); //tenemos que poner esto para que no se quede en modo bucle el error
					
				}
		}		
		
		return n;
	}

	public static Vehiculo pedirVehiculo() {
		// TODO Auto-generated method stub
		
		System.out.println("Introduzca marca");
		String marca = sc.nextLine();
		
		System.out.println("Introduzca modelo");
		String modelo = sc.nextLine();
		
		System.out.println("Introduzca bastidor");
		String bastidor = sc.nextLine();
		
		Vehiculo v = new Vehiculo(marca, modelo, bastidor);
		
		return v;
	}

	public static String pedirVehiculoBuscado() {
		// TODO Auto-generated method stub
				
		System.out.println("Introduzca bastidor");
		String bastidor = sc.nextLine();
		
		
		return bastidor;
	}

	public static void mostrarVehiculo(ArrayList<Vehiculo> lista_vehiculo) {
		// TODO Auto-generated method stub
		
		if(lista_vehiculo!=null)
		{
			for (int i = 0; i<lista_vehiculo.size(); i++) 
			{
				System.out.println(lista_vehiculo.get(i).getMarca()+"\t"+lista_vehiculo.get(i).getModelo()+"\t"+lista_vehiculo.get(i).getBastidor());
				
			} 
		}
	}

	public static void listarVehiculos(ArrayList<Vehiculo> lista_vehiculos) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i<lista_vehiculos.size(); i++) 
		{
			System.out.println(lista_vehiculos.get(i).getMarca()+"\t"+lista_vehiculos.get(i).getModelo()+"\t"+lista_vehiculos.get(i).getBastidor());
			
		}
		
	}
	

}
