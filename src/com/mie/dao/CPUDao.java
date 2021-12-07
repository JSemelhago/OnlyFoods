package com.mie.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mie.model.CPU;
import com.mie.util.DbUtil;

/*
 * This class accesses the database to populate and return a list filled with part objects
 */

public class CPUDao {
	
	private Connection connection;

	public CPUDao() { //Gets the database connection
		connection = DbUtil.getConnection();
	}

	public List<CPU> getAllCPUs() { //Returns all of instances of this computer part in a list

		List<CPU> cpus = new ArrayList<CPU>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from CPU");
			while (rs.next()) {
				CPU cpu = new CPU();
				cpu.setCPUid(rs.getInt("CPU_ID"));
				cpu.setCPUName(rs.getString("CPU_Name"));
				cpu.setSpeed(rs.getFloat("Speed_inGHz"));
				cpu.setCores(rs.getInt("Cores"));
				cpu.setPrice(rs.getFloat("Price"));
				cpu.setRating(rs.getFloat("Rating"));
				cpu.setManufacturer(rs.getString("Manufacturer"));
				cpu.setSeries(rs.getString("Series"));
				cpu.setSimultanueousMultithreading(rs.getInt("Simultaneous_Multithreading"));
				cpu.setSupportsECC(rs.getInt("Supports_ECC"));
				
				cpus.add(cpu);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cpus;
	}

}