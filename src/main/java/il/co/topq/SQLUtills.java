package il.co.topq;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;
import il.co.topq.difido.model.Enums.Status;

public class SQLUtills {
	
	private ReportDispatcher report = ReportManager.getInstance();
	private static String jdbcDriver = "";  
	private static String dbUrl = "";
	private static String user = "";
	private static String password = "";
	private static Connection connection = null;
	private static Statement statement = null;
	
	public static void setDBConnection(){
		
	}
	
	public static void closeDBConnection(){
		try {
			if(connection!=null){
				connection.close();
			}
			if(statement!=null){
				statement.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public SQLResultTable executeQuery(String query){
		try {
			return new SQLResultTable(statement.executeQuery(query));
		} catch (SQLException e) {
			//TODO: handle
			return null;
		}
	}
}
