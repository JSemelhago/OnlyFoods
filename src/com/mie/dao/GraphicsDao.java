package com.mie.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mie.model.Graphics;
import com.mie.util.DbUtil;

/*
 * This class accesses the database to populate and return a list filled with part objects
 */


public class GraphicsDao {
	
	private Connection connection;

	public GraphicsDao() { //Gets the database connection
		connection = DbUtil.getConnection();
	}

	public List<Graphics> getAllGraphics() {

		List<Graphics> graphicsCards = new ArrayList<Graphics>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from Video_Card");
			while (rs.next()) {
				Graphics graphics = new Graphics();
				graphics.setGraphicsId(rs.getInt("Video_Card_ID"));
				graphics.setName(rs.getString("Video_Card_Name"));
				graphics.setSeries(rs.getString("Series"));
				graphics.setChipset(rs.getString("Chipset"));
				graphics.setMemoryGB(rs.getString("Memory"));
				graphics.setClockGhz(rs.getString("Core_Clock"));
				graphics.setPrice(rs.getFloat("Price"));
				graphics.setManufacturer(rs.getString("Manufacturer"));
				graphics.setFanless(rs.getInt("Fanless"));
				
				graphicsCards.add(graphics);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return graphicsCards;
	}

}