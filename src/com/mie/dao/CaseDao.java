package com.mie.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mie.model.Case;
import com.mie.util.DbUtil;

/*
 * This class accesses the database to populate and return a list filled with part objects
 */

public class CaseDao {

	private Connection connection;

	public CaseDao() { //Gets the database connection
		connection = DbUtil.getConnection();
	}

	public List<Case> getAllCases() { //Returns all of instances of this computer part in a list
		List<Case> cases = new ArrayList<Case>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from Case");
			while (rs.next()) {
				Case caseVar = new Case();
				caseVar.setCaseId(rs.getInt("Case_ID"));
				caseVar.setName(rs.getString("Case_Name"));
				caseVar.setType(rs.getString("Type"));
				caseVar.setExtFiveQuarter(rs.getInt("Ext_Five_Quarter"));
				caseVar.setIntThreeHalf(rs.getInt("Int_Three_Half"));
				caseVar.setPowerSupply(rs.getString("Power_Supply"));
				caseVar.setPrice(rs.getFloat("Price"));
				caseVar.setManufacturer(rs.getString("Manufacturer"));
				caseVar.setSidePanelWindow(rs.getInt("Side_Panel_Window"));
				caseVar.setFrontPanelUsb3(rs.getInt("Front_Panel_USB_Three"));
				
				cases.add(caseVar);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cases;
	}

}