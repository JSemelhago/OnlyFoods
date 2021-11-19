
import java.sql.*;

public class OnlyFoodsRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
