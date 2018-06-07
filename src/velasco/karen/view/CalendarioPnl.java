package velasco.karen.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Date;
import java.util.Properties;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class CalendarioPnl extends JPanel{
	JDatePanelImpl datePanel;
    DateLabelFormatter dateLabelFormatter;
    JDatePickerImpl datePicker;
    Date date;
    
    JLabel lblTitulo;
    
    public CalendarioPnl(String titulo) {
        
        super.setSize(new Dimension(150,150));
        super.setLayout(new FlowLayout());//new BoxLayout(this, BoxLayout.Y_AXIS)
        
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        
        datePanel = new JDatePanelImpl(model, p);
        
        dateLabelFormatter = new DateLabelFormatter();
        
        datePicker = new JDatePickerImpl(datePanel, dateLabelFormatter);
            
        lblTitulo = new JLabel(titulo);
        lblTitulo.setPreferredSize(new Dimension(170,40));
        
        super.add(lblTitulo);
        super.add(datePicker);
    }
    
    
    public JDatePickerImpl getDatePicker() {
		return datePicker;
	}


	public void setDatePicker(JDatePickerImpl datePicker) {
		this.datePicker = datePicker;
	}


	public String getStringDate(){
        return dateLabelFormatter.getStringDate();
    }

	public JDatePanelImpl getDatePanel() {
		return datePanel;
	}

	public void setDatePanel(JDatePanelImpl datePanel) {
		this.datePanel = datePanel;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
    
    
    
    /*
    public void resetCalendar(){
        datePicker.getJFormattedTextField().setText("");
    }
    */
    
    /*public static void main(String[] args) {
        JFrame jframe = new JFrame();
        jframe.setLayout(new BorderLayout());
        jframe.setSize(new Dimension(300,300));
        
        CalendarioPnl pnl = new CalendarioPnl("Fecha de nacimiento");
        
        JButton btn = new JButton("OK");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //
                System.out.println("Despues del btn");
                String fecha = pnl.getStringDate();
                System.out.println(fecha);
            }
        });
        
        
        jframe.add(pnl, BorderLayout.CENTER);
        jframe.add(btn, BorderLayout.SOUTH);
        jframe.setVisible(true);
    }*/
}
