package com.mie.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mie.model.Motherboard;
import com.mie.util.DbUtil;

/*
 * This class accesses the database to populate and return a list filled with part objects
 */


public class MotherboardDao {

	private Connection connection;

	public MotherboardDao() { //Gets the database connection
		connection = DbUtil.getConnection();
	}

	public List<Motherboard> getAllMotherboards() { //Returns all of instances of this computer part in a list

		List<Motherboard> motherboards = new ArrayList<Motherboard>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from Motherboard");
			while (rs.next()) {
				Motherboard motherboard = new Motherboard();
				motherboard.setMotherboardId(rs.getInt("Motherboard_ID"));
				motherboard.setName(rs.getString("Motherboard_Name"));
				motherboard.setCpuSocketType(rs.getString("Socket_CPU"));
				motherboard.setForm(rs.getString("Form_Factor"));
				motherboard.setRamSlots(rs.getInt("RAM_Slots"));
				motherboard.setMaxRam(rs.getInt("Max_RAM_inGB"));
				motherboard.setPrice(rs.getFloat("Price"));
				motherboard.setManufacturer(rs.getString("Manufacturer"));
				
				motherboards.add(motherboard);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return motherboards;
	}

}