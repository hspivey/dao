package com.cooksys.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonDao {

	public static Person getPerson(int id) throws SQLException {
		ResultSet results = ConnectionManager.executeQuery("Select \"Id\", first_name, last_name, age, interest, city from person join location on \"location_id\" = \"loco_id\" inner join pi_join on \"Id\" = \"person_id\" inner join interest on \"interest_id\" = \"int_id\" Where \"Id\" = "+id+"");
		Person person = new Person();
		while (results.next()) {
			person.setId(results.getLong(1));
			person.setFirstName(results.getString(2));
			person.setLastName(results.getString(3));
			person.setAge(results.getInt(4));
			person.setInterest(results.getString(5));
			person.setCity(results.getString(6));

		}
		return person;
	}
public static void savePerson(Person p) {
	if (p.getId()== null) {
		ConnectionManager.executeUpdate("Insert into person (first_name, last_name, age) values ('"+p.getFirstName()+"', '"+p.getLastName()+"', "+p.getAge()+");");
	}
	if (p.getId()!= null) {
		ConnectionManager.executeUpdate("Update person set first_name = '"+p.getFirstName()+"', last_name = '"+p.getLastName()+"', age = "+p.getAge()+" where \"Id\" = "+p.getId()+";");
	}
}

	
	public static ArrayList<Person> findInterestGroup(String interest, String location) throws SQLException {
		ResultSet results = ConnectionManager.executeQuery(
				"SELECT \"Id\", first_name, last_name, age, interest, city from person join location on \"location_id\" = \"loco_id\" inner join pi_join on \"Id\" = \"person_id\" inner join interest on \"interest_id\" = \"int_id\" where title = '"
						+ interest + "' and city = '" + location + "';");

		ArrayList<Person> persons = new ArrayList<Person>();

		while (results.next()) {
			Person person = new Person();

			person.setId(results.getLong(1));
			person.setFirstName(results.getString(2));
			person.setLastName(results.getString(3));
			person.setAge(results.getInt(4));
			person.setInterest(results.getString(5));
			person.setCity(results.getString(6));
			persons.add(person);
		}
		return persons;
	}
}