/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import rawjava.parkingselection;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import rawjava.parkingselection;

@WebServlet("/register")
public class register extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password"); 
                String email = request.getParameter("Email");
                String first_name= request.getParameter("First Name");
                String last_name= request.getParameter("Last Name");
                String License= request.getParameter("License");
		parkingselection sparking=new parkingselection(); 
                try{
                    Statement statement=sparking.con.createStatement();
                    ResultSet resultset=statement.executeQuery("SELECT UserName FROM USERS WHERE UserName='"+username+"';");
                    if(resultset.next()){
                            JOptionPane.showMessageDialog(null, "username not available");
                            response.sendRedirect("register.html");
                    }
                    else{
                        statement.executeUpdate("INSERT INTO USERS (ID,UserName,licenseplate,Fname,Password,EMAIL,Lname) "
                                + "VALUES "+ "("+0+",'"+username+"','"+License+"','"
                                +first_name+"','"+password+"','"+email+"','"+last_name+"');");
                        response.sendRedirect("Parking-selection.html");
                    }
                    sparking.con.close();
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "error accured");
                }

    }
}
