package business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import data.*;
import entities.*;

public class Controller {
	
	


public static String getDate(Date date) {
   //useful method
	
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    return format.format(date);
}




}
