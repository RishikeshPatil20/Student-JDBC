package com.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.school.configuration.HelperClass;
import com.school.dto.Teacher;

public class TeacherDao {

	HelperClass helperClass =new HelperClass();
	
	Connection connection=null;
	
	public Teacher saveTeacher(Teacher teacher) {
		connection=helperClass.getconnection();
		String sql="INSERT INTO teacher VALUES(?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareCall(sql);
			preparedStatement.setInt(1, teacher.getId());
			preparedStatement.setString(2, teacher.getName());
			preparedStatement.setString(3, teacher.getEmail());
			//execute
			preparedStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return teacher;
	}
}
