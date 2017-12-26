/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uhcl_email;



/**
 *
 * @author vikra
 */
public class email_account {
    private String email_account;
    private String  to;
    private String from;
    private String subject;
    private String message;
    private String datentime;
    private int neworold;
    private int accountnum;
    public email_account(String s,String a,String b,String c,String d,String f,int g,int h){
        email_account=s;
        to=a;
        from=b;
        subject=c;
        message=d;
        datentime=f;
        neworold=g;
        accountnum=h;
    }
    public void setto(String a){
        to=a;
    }
    public String getto(){
       return to;
    }
     public void setfrom(String a){
        from=a;
    }
    public String getfrom(){
       return from;
    }
     public void setsubject(String a){
        subject=a;
    }
    public String getsubject(){
       return subject;
    }
     public void setmessage(String a){
        message=a;
    }
    public String getmessage(){
       return message;
    }
     public void setemail_account(String a){
        email_account=a;
    }
    public String getemail_account(){
       return email_account;
    }
      public String getdate(){
       return datentime;
    }
       public int getoldornew(){
       return neworold;
    }
    public void setoldornew(int a){
        neworold=a;
    }

    public int getAccountnum() {
        return accountnum;
    }

    public void setAccountnum(int accountnum) {
        this.accountnum = accountnum;
    }
    
    
    
    
    
}
