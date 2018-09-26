package com.slokam.FamilyDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.slokam.pojo.familypojo;

public class familyDao {

	public void FamilyDetailsSave(familypojo family) {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/f13","root","root");
			
			java.sql.PreparedStatement ps=con.prepareStatement("insert into family(name,age,fname,mname,address,phone) values(?,?,?,?,?,?)");
	
		ps.setString(1, family.getName());
		ps.setString(2, family.getAge());
		ps.setString(3, family.getFname());
		ps.setString(4, family.getMname());
		ps.setString(5, family.getAddress());
		ps.setString(6, family.getPhone());
		
		
		
		 ps.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public ArrayList<familypojo> GetAllDetails() {
		ArrayList<familypojo> fa=new ArrayList<familypojo>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/f13","root","root");
			
			java.sql.PreparedStatement ps=con.prepareStatement("select * from family");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				familypojo fm=new familypojo();
				fm.setId(rs.getInt("id"));
				fm.setName(rs.getString("name"));
				fm.setAge(rs.getString("age"));
				fm.setFname(rs.getString("fname"));
				fm.setMname(rs.getString("mname"));
				fm.setAddress(rs.getString("address"));
				fm.setPhone(rs.getString("phone"));
				fa.add(fm);
				
			}
	
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return fa;
	}

	public familypojo GetDetailsById(int i) {
	
		familypojo fm=new familypojo();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/f13","root","root");
			
			java.sql.PreparedStatement ps=con.prepareStatement(" select * from family where id= ? ");
			ps.setInt(1, i);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				
				fm.setId(rs.getInt("id"));
				fm.setName(rs.getString("name"));
				fm.setAge(rs.getString("age"));
				fm.setFname(rs.getString("fname"));
				fm.setMname(rs.getString("mname"));
				fm.setAddress(rs.getString("address"));
				fm.setPhone(rs.getString("phone"));
				
				
			}
	
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fm;
		
	}

	public void UpdateFamily(familypojo fam) {
		
		familypojo fm=new familypojo();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/f13","root","root");
			
			java.sql.PreparedStatement ps=con.prepareStatement(" update family set name=?,age=?,fname=?,mname=?,address=?,phone=? where id=? ");
			ps.setString(1, fam.getName());
			ps.setString(2, fam.getAge());
			ps.setString(3, fam.getFname());
			ps.setString(4, fam.getMname());
			ps.setString(5, fam.getAddress());
			ps.setString(6, fam.getPhone());
			ps.setInt(7, fam.getId());
			
			
			ps.executeUpdate();
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void DeleteData(int id1) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/f13","root","root");
			
			java.sql.PreparedStatement ps=con.prepareStatement(" delete from family where id=? ");
			
			ps.setInt(1, id1);
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
