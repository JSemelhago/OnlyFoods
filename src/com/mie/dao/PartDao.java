package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mie.util.DbUtil;

/*
 * This class acts as a helper to search the database for a variety of parts
 */


public class PartDao {

	private Connection connection;

	public PartDao() { //Gets the database connection
		connection = DbUtil.getConnection();
	}

	public List<String> getPartByKeyword(String keyword) {

		if (!keyword.contains(":")) { //This if tree filters out basic query errors
			return null;
		} else if (!(keyword.length() >= keyword.indexOf(":")+2)){
			return null;
		}
		
		List<String> parts = new ArrayList<String>();
		String partType = keyword.substring(0, keyword.indexOf(":"));  //Breaks apart the query into part and keyword
		String searchWord = keyword.substring(keyword.indexOf(":")+2, keyword.length()); //Breaks apart the query into part and keyword
		PreparedStatement preparedStatement = null;
		
		try {
		
		//Matches part type to the appropriate search
		if(partType.equalsIgnoreCase("CPU")){ // Prepares a statement to find matching entries and makes a String from the results
			preparedStatement = connection.prepareStatement("select * from CPU where CPU_Name LIKE ? OR Manufacturer LIKE ? OR Speed_inGHz LIKE ? OR Cores LIKE ? OR Price LIKE ?");
			fillPreparedStatement(preparedStatement, searchWord, 5);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				parts.add("Name: " + rs.getString("CPU_Name") + ", Manufacturer: " + rs.getString("Manufacturer") + ", Speed in Ghz: " + rs.getFloat("Speed_inGHz") + ", Cores: " + rs.getInt("Cores") + ", Price: $" + rs.getFloat("Price"));
			}
			
		} else if (partType.equalsIgnoreCase("Motherboard")) { // Prepares a statement to find matching entries and makes a String from the results
			preparedStatement = connection.prepareStatement("select * from Motherboard where Motherboard_Name LIKE ? OR Manufacturer LIKE ? OR Form_Factor LIKE ? OR RAM_Slots LIKE ? OR Socket_CPU LIKE ? OR Price LIKE ?");
			fillPreparedStatement(preparedStatement, searchWord, 6);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				parts.add("Name: " + rs.getString("Motherboard_Name") + ", Manufacturer: " + rs.getString("Manufacturer") + ", Form: " + rs.getString("Form_Factor") + ", Ram Slots: " + rs.getInt("RAM_Slots") + ", CPU Socket Type: " + rs.getString("Socket_CPU") + ", Price: $" + rs.getFloat("Price"));
			}
			
			
		} else if (partType.equalsIgnoreCase("Memory")) { // Prepares a statement to find matching entries and makes a String from the results
			preparedStatement = connection.prepareStatement("select * from Memory where Memory_Name LIKE ? OR Manufacturer LIKE ? OR Speed LIKE ? OR Modules LIKE ? OR Size_inGB LIKE ? OR Price LIKE ?");
			fillPreparedStatement(preparedStatement, searchWord, 6);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				parts.add("Name: " + rs.getString("Memory_Name") + ", Manufacturer: " + rs.getString("Manufacturer") + ", Speed: " + rs.getString("Speed") + ", Modules: " + rs.getString("Modules") + ", Size in GB: " + rs.getInt("Size_inGB") + ", Price: $" + rs.getFloat("Price"));
			}
			
		} else if (partType.equalsIgnoreCase("Storage")) { // Prepares a statement to find matching entries and makes a String from the results
			preparedStatement = connection.prepareStatement("select * from Storage where Storage_Name LIKE ? OR Manufacturer LIKE ? OR Series LIKE ? OR Type LIKE ? OR Capacity LIKE ? OR Price LIKE ?");
			fillPreparedStatement(preparedStatement, searchWord, 6);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				parts.add("Name: " + rs.getString("Storage_Name") + ", Manufacturer: " + rs.getString("Manufacturer") + ", Series: " + rs.getString("Series") + ", Type: " + rs.getString("Type") + ", Capacity: " + rs.getString("Capacity") + ", Price: $" + rs.getFloat("Price"));
			}
			
		} else if (partType.equalsIgnoreCase("Graphics")) { // Prepares a statement to find matching entries and makes a String from the results
			preparedStatement = connection.prepareStatement("select * from Video_Card where Video_Card_Name LIKE ? OR Manufacturer LIKE ? OR Series LIKE ? OR Memory LIKE ? OR Core_Clock LIKE ? OR Price LIKE ?");
			fillPreparedStatement(preparedStatement, searchWord, 6);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				parts.add("Name: " + rs.getString("Video_Card_Name") + ", Manufacturer: " + rs.getString("Manufacturer") + ", Series: " + rs.getString("Series") + ", Memory: " + rs.getString("Memory") + ", Core Clock Speed: " + rs.getString("Core_Clock") + ", Price: $" + rs.getFloat("Price"));
			}
			
		} else if (partType.equalsIgnoreCase("Power")) { // Prepares a statement to find matching entries and makes a String from the results
			preparedStatement = connection.prepareStatement("select * from Power where Power_Name LIKE ? OR Manufacturer LIKE ? OR Watts_inW LIKE ? OR Efficiency LIKE ? OR Moduler LIKE ? OR Price LIKE ?");
			fillPreparedStatement(preparedStatement, searchWord, 6);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				parts.add("Name: " + rs.getString("Power_Name") + ", Manufacturer: " + rs.getString("Manufacturer") + ", Output: " + rs.getInt("Watts_inW") + ", Efficiency: " + rs.getString("Efficiency") + ", Modular: " + rs.getString("Moduler") + ", Price: $" + rs.getFloat("Price"));
			}
			
		} else if (partType.equalsIgnoreCase("Case")) { // Prepares a statement to find matching entries and makes a String from the results
			preparedStatement = connection.prepareStatement("select * from Case where Case_Name LIKE ? OR Manufacturer LIKE ? OR Type LIKE ? OR Power_Supply LIKE ? OR Price LIKE ?");
			fillPreparedStatement(preparedStatement, searchWord, 5);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				parts.add("Name: " + rs.getString("Case_Name") + ", Manufacturer: " + rs.getString("Manufacturer") + ", Type: " + rs.getString("Type") + ", Power Supply: " + rs.getString("Power_Supply") + ", Price: $" + rs.getFloat("Price"));
			}
			
		} else {
			return null; //if the part doesn't exist in the database, returns null
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return parts;
	}
	
	public void fillPreparedStatement(PreparedStatement ps, String searchWord, int numToFill) { //helper function to fill preparedStatements
		try {	
			for (int i = 0; i < numToFill; i++){ //loops through the number of question marks
				ps.setString(i+1, "%" + searchWord + "%"); //sets placeholder to the searchWord
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}