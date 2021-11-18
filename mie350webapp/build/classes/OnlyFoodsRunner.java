
import java.sql.*;

public class OnlyFoodsRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
