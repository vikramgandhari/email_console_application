/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uhcl_email;
import java.util.*;
/**
 *
 * @author vikra
 */
public class Uhcl_email {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       String a="";
       while(!a.equals("x")){
           System.out.println("1:create account");
           System.out.println("2:login");
           System.out.println("x:close");
            a=sc.nextLine();
            System.out.println();
           if(a.equals("1")){
              create_email_account.createAccount();
              
           }
           if(a.equals("2")){
               login_account j=new login_account();
               j.login();
              
              
           }
           
       }
    }
    
}
