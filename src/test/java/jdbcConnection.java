import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




public class jdbcConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		String host="localhost";
		String port="3306";
		

		
		
		Connection con= DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/practice", "root", "Shimson@12345");
		Statement s=con.createStatement();
		ResultSet rs	=s.executeQuery("SELECT * FROM practice.stocks_data order by stocks_sector;");
		rs.next();
		rs.getString("StockName");
		System.out.println(rs.getString("StockName"));
	}

}
