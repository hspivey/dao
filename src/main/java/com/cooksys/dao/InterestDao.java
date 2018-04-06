package com.cooksys.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InterestDao {
	public static Interest getInterest(int id) throws SQLException {
		ResultSet results = ConnectionManager.executeQuery(
				"Select int_id, title from interest Where int_id = " + id + "");
		Interest interest = new Interest();
		while (results.next()) {
			interest.setId(results.getLong(1));
			interest.setTitle(results.getString(2));
		}
		return interest;
	}
	public static void saveInterest(Interest i) {
		if (i.getId()== null) {
			ConnectionManager.executeUpdate("Insert into interest (title) values ('"+i.getTitle()+"');");
}
		if (i.getId()!= null) {
			ConnectionManager.executeUpdate("Update interest set title = '"+i.getTitle()+"' where int_id = "+i.getId()+";");
		}
	}
}
