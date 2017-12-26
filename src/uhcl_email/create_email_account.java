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
import java.util.*;
/**
 *
 * @author vikra
 */
public class create_email_account {
    public static void createAccount(){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter name");
        String name=sc.next();
        System.out.println("enter eamil id ");
        String email_id=sc.next();
        boolean iscont=false;
        while(email_id.length()<3||email_id.length()>10||iscont==false){
            System.out.println("enter email again");
              email_id=sc.next();
              int count=0;
              int count1=0;
            for(char c:email_id.toCharArray()){
                if(Character.isDigit(c)){
                    count++;
                }
                if(Character.isLetter(c)){
                    count1++;
                }
            }
            if(count>=1&&count1>=1){
                iscont=true;
            }
        }
        System.out.println("enter password");
        String psw=sc.next();
        final String DATABASE_URL="jdbc:mysql://mis-sql.uhcl.edu/gandhariv9568";
        Connection connection=null;
        Statement statement=null;
        ResultSet resultset=null;
        try{
           connection=DriverManager.getConnection(DATABASE_URL,"gandhariv9568","1494883");
           statement=connection.createStatement();
           resultset=statement.executeQuery("select * from email_account where email='"+email_id+"'");
           if(resultset.next()){
               System.out.println("error in creation");
           }
           else{
                
               int a=statement.executeUpdate("insert into email_account values('"+name+"','"+email_id+"','"+psw+"')");
           }
           
        }
         catch (SQLException e)
        {
            
            
            e.printStackTrace();
        }
        finally{
            try{
                connection.close();
                statement.close();
                resultset.close();
                
            }
            catch(Exception e){
                
            }
        }
    }
}
