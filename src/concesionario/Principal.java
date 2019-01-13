package concesionario;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		//AccesoBD.crearTabla();
		int opcion = Consola.pedirMenu(); //5 - salir
		
		while(opcion!=5) 
		{
			switch (opcion) {
			case 1:
				//Insertar
				Vehiculo v = Consola.pedirVehiculo();
				AccesoBD.insertarVehiculo(v);
				
				break;
			case 2:
				//Listar vehiculo
				ArrayList<Vehiculo> lista_vehiculos = AccesoBD.recuperarVehiculo();
				Consola.listarVehiculos(lista_vehiculos);
				
				
				break;
			case 3:
				//Buscar vehiculo por marca: pedir >> buscar en BD >> enseñar
				String bastidor_buscado = Consola.pedirVehiculoBuscado();
				ArrayList<Vehiculo> lista_vehiculo = AccesoBD.buscarBastidor(bastidor_buscado);
				Consola.mostrarVehiculo(lista_vehiculo);
				
				
				break;
			case 4:
				//Exportar base de datos
				exportar();
				break;

			default:
				break;
			}
			opcion= Consola.pedirMenu();//5salir
			
		}
		
		
		
	}



	private static void exportar() {
		// TODO Auto-generated method stub
		int opcion = Consola.pedirExportacion();
		ArrayList<Vehiculo> lista_vehiculo = AccesoBD.recuperarVehiculo();
		switch (opcion) {
		case 1:
			//exportar csv
			AccesoFichero.exportarCSV(lista_vehiculo);
			
			break;

		case 2:
			//exportar sql
			AccesoFichero.exportarSQL(lista_vehiculo);
			break;
		}
	}
}
