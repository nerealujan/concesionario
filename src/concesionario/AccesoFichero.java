package concesionario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AccesoFichero {
	static String ruta_csv="C:\\PracticaExamen\\exportado.csv";
	static String ruta_sql="C:\\PracticaExamen\\exportado.sql";

	public static void exportarSQL(ArrayList<Vehiculo> lista_vehiculo) {
		// TODO Auto-generated method stub
		String creacion = "CREATE TABLE tabla_concesionario (marca VARCHAR(50), modelo VARCHAR(50), bastidor VARCHAR(50))";
		String aux = creacion;
		for (Vehiculo vehiculo : lista_vehiculo) {
			String insercion = "INSERT INTO `tabla_concesionario` VALUES('"+vehiculo.getMarca()+ 
					"', '"+vehiculo.getModelo()+"', '"+vehiculo.getBastidor()+"');";
			aux+=insercion+"\n";
		}
		try {
			FileWriter fw= new FileWriter(new File(ruta_sql));
			fw.write(aux);
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void exportarCSV(ArrayList<Vehiculo> lista_vehiculo) {
		// TODO Auto-generated method stub
		try {
			FileWriter fw=new FileWriter(new File(ruta_csv), false);
			String aux="";
			for (Vehiculo vehiculo : lista_vehiculo)
			{
				aux += vehiculo.getModelo()+","+vehiculo.getMarca()+","+vehiculo.getBastidor()+"\n";
				
			}
			fw.write(aux);
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
