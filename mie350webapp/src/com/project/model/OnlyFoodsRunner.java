
import java.sql.*;

public class OnlyFoodsRunner {
	
	//DB connection
	public static Connection dbCon;

	public static void main(String[] args) {
		
		dbCon = null;
		String DB_DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
		String DB_OnlyFoods = "jdbc:odbc:Driver={Microsoft Access Driver (*.accdb)};DBQ=OnlyFoods.accdb";
		
		try {
			Class.forName(DBConstants.DB_DRIVER);
		} catch (ClassNotFoundException cfe) {
			System.out.println("Failed loading the JDBC driver.");
			cfe.printStackTrace();
		}
		try {
			dbCon = DriverManager.getConnection(DBConstants.DB_OnlyFoods);
		} catch (SQLException se) {
			SQLExceptionHandler.handleException(se);
		}
		try {
			dbCon.setAutoCommit(false); // to manage a transaction with multiple statements
		} catch (SQLException se) {
			SQLExceptionHandler.handleException(se);
		}
		
		try {
			dbCon.commit();
			dbCon.close();
		} catch (SQLException se) {
			SQLExceptionHandler.handleException(se);
		}
	}
	
	//Run select SQL query
	public static ResultSet runSelect(String qStr) {
		String queryString = qStr;
		ResultSet inputList = null;
		Statement statement;
		
		//Nothing to select from
		if (dbCon == null) {
			return null;
		}
		try {
			statement = dbCon.createStatement();
			inputList = statement.executeQuery(queryString);
		} catch (SQLException se) {
			SQLExceptionHandler.handleException(se);
		}
		return inputList;
	}
	
	//Run update SQL query
	public static void runUpdate(String qStr) {
		String queryString = qStr;
		Statement statement;
		PreparedStatement preparedStatement;
		try {
			statement = dbCon.createStatement();
			preparedStatement = dbCon.prepareStatement(queryString);
			preparedStatement.execute();
			statement.close();
		} catch (SQLException se) {
			SQLExceptionHandler.handleException(se);
		}
	}

}
