package apj.p5;

import java.sql.Connection;
import java.sql.DriverManager;

//CTRL + SHIFT + O pour générer les imports
public class Connect {
public static void main(String[] args) {      
  try {
    Class.forName("org.postgresql.Driver");
    System.out.println("Driver O.K.");

    String url = "jdbc:postgresql://192.168.1.41:5432/Ecole";
    String user = "postgres";
    String passwd = "ga9399ghr";

    Connection conn = DriverManager.getConnection(url, user, passwd);
    System.out.println("Connexion effective !" + conn.getCatalog());         
       
  } catch (Exception e) {
    e.printStackTrace();
  }      
}
}
