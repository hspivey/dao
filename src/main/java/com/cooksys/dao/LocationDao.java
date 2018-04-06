package com.cooksys.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationDao {
	public static Location getLocation(int id) throws SQLException {
		ResultSet results = ConnectionManager.executeQuery(
				"Select loco_id, city, state, country from location Where loco_id = " + id + "");
		Location location = new Location();
		while (results.next()) {
			location.setId(results.getLong(1));
			location.setCity(results.getString(2));
			location.setState(results.getString(3));
			location.setCountry(results.getString(4));
		}
		return location;
	}
	public static void saveLocation(Location l) {
		if (l.getId()== null) {
			ConnectionManager.executeUpdate("Insert into location (city, state, country) values ('"+l.getCity()+"', '"+l.getState()+"', '"+l.getCountry()+"');");
}
		if (l.getId()!= null) {
			ConnectionManager.executeUpdate("Update location set city = '"+l.getCity()+"', state = '"+l.getState()+"', country = '"+l.getCountry()+"' where loco_id = "+l.getId()+";");
		}
	}
}