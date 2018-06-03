package velasco.karen.view;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFormattedTextField.AbstractFormatter;

public class DateLabelFormatter extends AbstractFormatter{
	private String datePattern = "YYYY-MM-dd";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
    private String valorFinal;
    
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }

    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
           
            System.out.println("Dentro de DateLabelFormatter "+dateFormatter.format(cal.getTime()));
            
            this.valorFinal = dateFormatter.format(cal.getTime());
            
            return dateFormatter.format(cal.getTime());
           
        }
        return "";
    }
    
    public String getStringDate(){
    	
        return this.valorFinal;
    }
}
