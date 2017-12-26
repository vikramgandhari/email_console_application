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
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author vikra
 */
public class welcome {
    ArrayList<email_account> eacc=new ArrayList<email_account>();
    private String Account_num;
    private int num;
  
    public void showmain(String Account_nu,int n){
        this.num=n;
        Scanner sc=new Scanner(System.in);
        Account_num=Account_nu;
        final String DATABASE_URL="jdbc:mysql://mis-sql.uhcl.edu/gandhariv9568";
        Connection connection=null;
        Statement statement=null;
        ResultSet resultset=null;
        ResultSet r2=null;
        ResultSet r3=null;
        try{
            connection=DriverManager.getConnection(DATABASE_URL,"gandhariv9568","1494883");
            statement=connection.createStatement();
           // resultset=statement.executeQuery("select * from email_account where email='"+Account_num+"'");
            r2=statement.executeQuery("select * from email_all where email_all.to='"+Account_num+"' order by email_all.dateandtime DESC");
            if(r2.next()){
                
                for(int i=0;i<r2.getRow();i++){
                  
                    
                eacc.add(new email_account(r2.getString(1),r2.getString(2),r2.getString(3),r2.getString(4),r2.getString(5),r2.getString(6),r2.getInt(7),r2.getInt(8)));
                r2.next();
               
                }
                
            
            }
            if(eacc.size()==1){
                if(eacc.get(0).getoldornew()==0){
                 System.out.println( 0+":"+eacc.get(0).getfrom()+","+eacc.get(0).getsubject()+"  "+"(new)"+eacc.get(0).getdate());
                }
                else if(eacc.get(0).getoldornew()==1){
                    System.out.println( 0+":"+eacc.get(0).getfrom()+","+eacc.get(0).getsubject()+"  "+eacc.get(0).getdate());
                }
                
            }
            else{
            for(int i=num-1;i<=num&&num>=0&&num<eacc.size();i++){
                  if(eacc.get(i).getoldornew()==1){
                    System.out.println( i+":"+eacc.get(i).getfrom()+","+eacc.get(i).getsubject()+"  "+eacc.get(i).getdate());
                  }
                  else if(eacc.get(i).getoldornew()==0){
                       System.out.println( i+":"+eacc.get(i).getfrom()+","+eacc.get(i).getsubject()+"  "+"(new)"+eacc.get(i).getdate());
                  }
                  
                }
            }
            String a="";
           
            
            System.out.println();
            System.out.println("select options from below");
            System.out.println("w:write an email");
            System.out.println("s:sent mails");
            if(num<eacc.size()-2){
            System.out.println("n:next page");
            }
            if(num>1){
            System.out.println("p:previous page");
            }
            System.out.println("v:view email");
            System.out.println("x:logout");
           a=sc.next();
            
            String b="";
            if(a.equals("v")){
                if(eacc.size()==1){
                if(eacc.get(0).getoldornew()==0){
                 System.out.println( 0+":"+eacc.get(0).getfrom()+","+eacc.get(0).getsubject()+"  "+"(new)"+eacc.get(0).getdate());
                }
                else if(eacc.get(0).getoldornew()==1){
                    System.out.println( 0+":"+eacc.get(0).getfrom()+","+eacc.get(0).getsubject()+"  "+eacc.get(0).getdate());
                }
                
            }
            else{
            for(int i=num-1;i<=num&&num>=0&&num<eacc.size();i++){
                  if(eacc.get(i).getoldornew()==1){
                    System.out.println( i+":"+eacc.get(i).getfrom()+","+eacc.get(i).getsubject()+"  "+eacc.get(i).getdate());
                  }
                  else if(eacc.get(i).getoldornew()==0){
                       System.out.println( i+":"+eacc.get(i).getfrom()+","+eacc.get(i).getsubject()+"  "+"(new)"+eacc.get(i).getdate());
                  }
                    
                }
            }
                ArrayList<email_account> arrayli=new ArrayList<email_account>();
                 System.out.println("which one u want to view");
                 b=sc.next();
                 while(Integer.parseInt(b)>n || Integer.parseInt(b)<n-1 ){
                   System.out.println("please enter what is there in header:");
                   b=sc.next();
                 }
                 int kl=0;
                 
                 if(Integer.parseInt(b)<=n && Integer.parseInt(b)>=n-1 && eacc.size()>0 && !(eacc.size()<=Integer.parseInt(b))){
                     kl=Integer.parseInt(b);
                     resultset=statement.executeQuery("select * from email_all where nextaccountnumb='"+eacc.get(kl).getAccountnum()+"'");
                 if(resultset.next()){
                    for(int i=0;i<resultset.getRow();i++){
                        arrayli.add(new email_account(resultset.getString(1),resultset.getString(2),resultset.getString(3),resultset.getString(4),resultset.getString(5),resultset.getString(6),resultset.getInt(7),resultset.getInt(8)));
                        resultset.next();
                    }
                    
                 }
                String prevsub="";
                 if(arrayli.size()>=2){
                  System.out.println("from:"+arrayli.get(0).getfrom());
                  System.out.println( "message:"+arrayli.get(0).getmessage());
                  System.out.println(".");
                  System.out.println(".");
                  System.out.println(".");
                  System.out.println("Reply from:"+eacc.get(kl).getfrom());
                  System.out.println( "Reply message:"+eacc.get(kl).getmessage());
                  prevsub=arrayli.get(0).getsubject();
                 }
                 else if(arrayli.size()==0){
                     System.out.println("no  messages to view");
                 }
                 else{
                        System.out.println("from:"+eacc.get(kl).getfrom());
                  System.out.println( "message:"+eacc.get(kl).getmessage());
                    prevsub=arrayli.get(0).getsubject();
                 }
                 
                 
                  int upd=statement.executeUpdate("update email_all set neworold='"+1+"' where nextaccountnumb='"+eacc.get(kl).getAccountnum()+"'");
                  System.out.println("reply then press r");
                  String k=sc.next();
                  int i=kl;
                  String g="";
                   r3=statement.executeQuery("select * from email_account where email='"+eacc.get(i).getto()+"'");
                      if(r3.next()){
                         g=r3.getString(1); 
                      }
                  if(k.equals("r")){
                      sc.nextLine();          
                     
                      System.out.println("enter message");
                      String message=sc.nextLine();
                     
                      int h=statement.executeUpdate("insert into email_all values('"+eacc.get(i).getto()+"','"+eacc.get(i).getemail_account()+"','"+g+"','RE:'"+"'"+prevsub+"','"+message+"','"+DateAndTime.DateTime()+"',0,'"+eacc.get(i).getAccountnum()+"')");
                      System.out.println("reply sent");
                       welcome l=new welcome();
                        l.showmain(Account_nu,1);
                      
                  }
                  
                 }
                 else{
                     System.out.println("please enter what is there in header");
                 }
                 
                 
                 
                 
            }
            if(a.equals("w")){
                writemail(Account_num);
            }
             if(a.equals("n")){ 
                 if(num==eacc.size()-2){
                     nextpage(num+1);
                     System.out.println("no more next messages");
                 }
                
                 else{
               nextpage(num+2);
                 }
            }
             if(a.equals("p")){
                 if(num==1){
                     nextpage(num-1);
                     
                 }
                
                 else{
               nextpage(num-2);
                 }
            }
             if(a.equals("s")){
                 sentemail(Account_num);
                 
             }
             if(a.equals("x")){
               ema();
             }
                    
            
           
            
        }
        catch(SQLException e){
            System.out.println("error in welcome");
            e.printStackTrace();
        }
        finally{
            try{
                connection.close();
                statement.close();
               resultset.close();
                r2.close();
                r3.close();
            }
            catch(Exception e){
            }
          
        }
        
    }
    public void writemail(String s){
        Scanner sc=new Scanner(System.in);
        System.out.println("whom u wnt to send ");
        String a=sc.nextLine();
        System.out.println();
        System.out.println("message subject");
        String b=sc.nextLine();
        System.out.println();
        System.out.println("message");
        String c=sc.nextLine();
        String d="";
        
        
        final String DATABASE_URL="jdbc:mysql://mis-sql.uhcl.edu/gandhariv9568"; 
        Connection connection=null;
        Statement statement=null;
        ResultSet resultset=null;
       ResultSet resultset1=null;
         try{
            connection=DriverManager.getConnection(DATABASE_URL,"gandhariv9568","1494883");
            statement=connection.createStatement();
            resultset=statement.executeQuery("select * from email_account where email='"+s+"'");
            if(resultset.next()){
                d=resultset.getString(1);
            }
             resultset1 = statement.executeQuery("Select * "
                     + "from nextaccount");
             
             int nextNum = 0;
             
             
             if(resultset1.next())
             {
                
                 nextNum = resultset1.getInt(1) + 1;
                
                 
             }
             else{
                 int j=statement.executeUpdate("insert into nextaccount values('"+nextNum+"')");
             }
             
             
              int g=statement.executeUpdate("update nextaccount set nextaccountnumb='"+nextNum+"'");
            if(!a.equals(null)&&!b.equals(null)&&!c.equals(null)){
           int h=statement.executeUpdate("insert into email_all values('"+s+"','"+a+"','"+d+"','"+b+"','"+c+"','"+DateAndTime.DateTime()+"','"+0+"','"+nextNum+"')");
           System.out.println("message successfully sent");
             welcome l=new welcome();
              l.showmain(s,1);
              
            }
        }
        catch(SQLException e){
            System.out.println("error in writememail");
            e.printStackTrace();
        }
        finally{
            try{
                connection.close();
                statement.close();
                resultset.close();
                resultset1.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }
    public void nextpage(int n){
    
    welcome ar=new welcome();
    ar.showmain(Account_num, n);
}
    public void setnum(int num){
        this.num=num;
    
}
   public int getnum(){
        return num;
    
} 

    private void sentemail(String Account_num) {
         ArrayList<email_account> eacc1=new ArrayList<email_account>();
          final String DATABASE_URL="jdbc:mysql://mis-sql.uhcl.edu/gandhariv9568"; 
        Connection connection=null;
        Statement statement=null;
        ResultSet r2=null;
     
         try{
            connection=DriverManager.getConnection(DATABASE_URL,"gandhariv9568","1494883");
            statement=connection.createStatement();
          
             r2=statement.executeQuery("select * from email_all where email_all.email='"+Account_num+"' order by email_all.dateandtime DESC");
            if(r2.next()){
                
                for(int i=0;i<r2.getRow();i++){
                  
                    
                eacc1.add(new email_account(r2.getString(1),r2.getString(2),r2.getString(3),r2.getString(4),r2.getString(5),r2.getString(6),r2.getInt(7),r2.getInt(8)));
                r2.next();
               
                }
                
            
            }
            
        }
        catch(SQLException e){
            System.out.println("error in writememail");
            e.printStackTrace();
        }
        finally{
            try{
                connection.close();
                statement.close();
                r2.close();
              
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
         for(int i=0;i<eacc1.size();i++){
                System.out.println(eacc1.get(i).getto()+","+eacc1.get(i).getsubject()+" "+eacc1.get(i).getdate());
            }
         Scanner sc=new Scanner(System.in);
         System.out.println("go to main main menu press m");
         String h=sc.next();
         if(h.equals("m")){
             welcome a=new welcome();
             a.showmain(Account_num, 1);
         }
    } 

    private void ema() {
        System.out.println("logged out");
    }
}
