/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuan.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;
import tuan.blos.RoomBLO;

/**
 *
 * @author macbookpro
 */
public class ValidateInputObj {
     private SimpleDateFormat formatter;

    public ValidateInputObj() {
        formatter = new SimpleDateFormat("dd-MM-yyyy");
    }
    public boolean checkDate(String date){
        boolean check = false;
        formatter.setLenient(false);
        Calendar c = Calendar.getInstance();
        Date chkDate = null;
        c.add(Calendar.YEAR, -18);
        Date index = c.getTime();
        try{
            chkDate = formatter.parse(date);
            if(chkDate.compareTo(index)<=0){
                check = true;
            }
            
        }
        catch(Exception e){
            return check;
        }
        return check;
    }
    public boolean checkFormatDate(String date){
        boolean check = false;
        formatter.setLenient(false);
        try{
            formatter.parse(date);
            check = true;
        }
        catch(Exception e){
            return check;
        }
        return check;
    }
    public Date parseDate(String date){
        Date d = new Date();
        try {
            d = formatter.parse(date);
        } catch (Exception e) {
            return null;
        }
        return d;
    }
    public boolean checkEmail(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 
    public boolean checkExistRoom(String roomID){
        RoomBLO blo = new RoomBLO();
        return blo.checkExistRoom(roomID);
    }
    public boolean checkNumber(String number){
        boolean check = false;
        try {
            if(Integer.parseInt(number)>0){
                check = true;
            }
        } catch (Exception e) {
            return check;
        }
        return check;
    }
    public static void main(String[] args) {
        ValidateInputObj v = new ValidateInputObj();
        //System.out.println(v.checkExistRoom("P007"));
        Calendar index = Calendar.getInstance();
        try {
            System.out.println(v.checkDate("11-3-2003"));
        } catch (Exception e) {
        }
    }
   
}
