package com.mie.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mie.model.Memory;
import com.mie.util.DbUtil;

/*
 * This class accesses the database to populate and return a list filled with part objects
 */


public class MemoryDao {

	private Connection connection;

	public MemoryDao() { //Gets the database connection
		connection = DbUtil.getConnection();
	}

	public List<Memory> getAllMemorys() { //Returns all of instances of this computer part in a list

		List<Memory> memorys = new ArrayList<Memory>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from Memory");
			while (rs.next()) {
				Memory memory = new Memory();
				memory.setMemoryId(rs.getInt("Memory_ID"));
				memory.setName(rs.getString("Memory_Name"));
				memory.setSpeed(rs.getString("Speed"));
				memory.setType(rs.getString("Type"));
				memory.setCas(rs.getInt("CAS"));
				memory.setModules(rs.getString("Modules"));
				memory.setSizeGB(rs.getInt("Size_inGB"));
				memory.setPrice(rs.getFloat("Price"));
				memory.setManufacturer(rs.getString("Manufacturer"));
				memory.setHeatSpreader(rs.getInt("Heat_Spreader"));

				
				memorys.add(memory);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memorys;
	}

}