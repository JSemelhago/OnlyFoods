package com.mie.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mie.model.Storage;
import com.mie.util.DbUtil;

/*
 * This class accesses the database to populate and return a list filled with part objects
 */


public class StorageDao {

	private Connection connection;

	public StorageDao() { //Gets the database connection
		connection = DbUtil.getConnection();
	}

	public List<Storage> getAllStorages() { //Returns all of instances of this computer part in a list
		
		List<Storage> storages = new ArrayList<Storage>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from Storage");
			while (rs.next()) {
				Storage storage = new Storage();
				storage.setStorageId(rs.getInt("Storage_ID"));
				storage.setName(rs.getString("Storage_Name"));
				storage.setSeries(rs.getString("Series"));
				storage.setForm(rs.getString("Form"));
				storage.setType(rs.getString("Type"));
				storage.setCapacity(rs.getString("Capacity"));
				storage.setCache(rs.getString("Cache"));
				storage.setPrice(rs.getFloat("Price"));
				storage.setManufacturer(rs.getString("Manufacturer"));
				
				storages.add(storage);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return storages;
	}

}