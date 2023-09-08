package com.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.school.configuration.HelperClass;
import com.school.dto.Student;

public class StudentDao {

	HelperClass helperClass =new HelperClass();
	
	Connection connection=null;
	//method to delete student by id
	public boolean deleteStudentById(int id) {
		
		connection=helperClass.getconnection();
		String sql="DELETE from student WHERE id=?";
		int i=0;
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			i=preparedStatement.executeUpdate();
			
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
		if (i>0) 
			return true;
		else
			return false;
		
	}
	public Student saveStudent(Student student) {
		connection=helperClass.getconnection();
		String sql="INSERT INTO student VALUES(?,?,?)";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			//passing the values to delimiters/placeholder --?
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3,student.getEmail());
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
		return student;
		
	}
	
	
	
}
