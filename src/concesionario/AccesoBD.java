package concesionario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccesoBD {

static Connection conexion = null;
static	Statement stmt = null;
static	String url_bd="jdbc:mysql://localhost:3306/concesionario?serverTimezone=UTC";
static	String usuario ="root";
static	String contraseña="";

	
	public static ArrayList<Vehiculo> recuperarVehiculo() {
		// TODO Auto-generated method stub
		abrirConexion();
		ArrayList<Vehiculo> lista_vehiculo = new ArrayList<>();
		String sql="SELECT * FROM tabla_concesionario";
		try {
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				 String marca=rs.getString("marca");
				 String modelo= rs.getString("modelo");
				 String bastidor= rs.getString("bastidor");
				 Vehiculo v= new Vehiculo(marca, modelo, bastidor);
				 lista_vehiculo.add(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista_vehiculo;
	}
	
	private static void abrirConexion()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion=DriverManager.getConnection(url_bd, usuario, contraseña);
			stmt = conexion.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void insertarVehiculo(Vehiculo v) {
		// TODO Auto-generated method stub
		abrirConexion();
		try {
			String query="INSERT INTO tabla_concesionario VALUES('"+v.getMarca()+ 
				"', '"+v.getModelo()+"', '"+v.getBastidor()+"');";
		
			stmt.executeUpdate(query);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
recuperarVehiculo();
	}

	public static ArrayList<Vehiculo> buscarBastidor(String bastidor_buscado) {
		// TODO Auto-generated method stub
		ArrayList<Vehiculo> lista_vehiculo = new ArrayList<>(); 

		// String query="SELECT * FROM t_palabras WHERE espanol='"+palabra_buscada+"' OR ingles='"+palabra_buscada+
		
		try {
			abrirConexion();
			String query = "SELECT * FROM tabla_concesionario WHERE bastidor LIKE'%"+bastidor_buscado+"%';";

			ResultSet resultado = stmt.executeQuery(query);
			while(resultado.next())
			{
				 String marca=resultado.getString("marca");
				 String modelo= resultado.getString("modelo");
				 String bastidor= resultado.getString("bastidor");
				 Vehiculo v= new Vehiculo(marca, modelo, bastidor);
				 lista_vehiculo.add(v);
			}
			stmt.close();
            conexion.close();
			
		} catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        } 
		return lista_vehiculo;
	}



	
}
