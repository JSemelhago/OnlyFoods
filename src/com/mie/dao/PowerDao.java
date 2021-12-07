package com.mie.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mie.model.Power;
import com.mie.util.DbUtil;

/*
 * This class accesses the database to populate and return a list filled with part objects
 */


public class PowerDao {

	private Connection connection;

	public PowerDao() { //Gets the database connection
		connection = DbUtil.getConnection();
	}

	public List<Power> getAllPowers() { //Returns all of instances of this computer part in a list

		List<Power> powers = new ArrayList<Power>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from Power");
			while (rs.next()) {
				Power power = new Power();
				power.setPowerId(rs.getInt("Power_ID"));
				power.setName(rs.getString("Power_Name"));
				power.setSeries(rs.getString("Series"));
				power.setForm(rs.getString("Form"));
				power.setEfficiency(rs.getString("Efficiency"));
				power.setWatts(rs.getInt("Watts_inW"));
				power.setModular(rs.getString("Moduler"));
				power.setPrice(rs.getFloat("Price"));
				power.setManufacturer(rs.getString("Manufacturer"));
				power.setFanless(rs.getInt("Fanless"));
				
				powers.add(power);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return powers;
	}

}