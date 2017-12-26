/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uhcl_email;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author vikra
 */
public class login_account {
    
    public  void login(){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter email_id");
        String a=sc.next();
        System.out.println("enter password");
        String b=sc.next();
        final String DATABASE_URL="jdbc:mysql://mis-sql.uhcl.edu/gandhariv9568";
        Connection connection=null;
        ResultSet resultset=null;
        Statement statement=null;
        try{
            connection=DriverManager.getConnection(DATABASE_URL,"gandhariv9568","1494883");
            statement=connection.createStatement();
            resultset=statement.executeQuery("select * from email_account where email='"+a+"' and psw='"+b+"'");
            if(resultset.next()){
              welcome g=new welcome();
              g.showmain(a,1);
               System.out.println();
               
            }
            else{
                System.out.println("error in login");
            }
             
           
            
            
        }
        catch(SQLException e){
            System.out.println("error takes place ");
            e.printStackTrace();
        }
        finally{
            try{
                connection.close();
                statement.close();
                resultset.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
        
    
        
    }
}
