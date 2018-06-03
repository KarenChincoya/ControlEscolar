package velasco.karen.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import velasco.karen.DAO.CarreraDAO;
import velasco.karen.objects.Carrera;

public class CarrerasCombo extends JPanel implements ActionListener{
	private Integer selectedIndex;
    
    public CarrerasCombo() {
        super(new BorderLayout());
 
        CarreraDAO daoCarreras = new CarreraDAO();
        ArrayList<String> carreras = daoCarreras.getCarreras();
        
        String[] carrerStrings = new String[carreras.size()];
        
        for(int i=0; i<carreras.size(); i++) {
        	carrerStrings[i] = carreras.get(i);
        }
        //Create the combo box, select the item at index 4.
        //Indices start at 0, so 4 specifies the pig.
        JComboBox petList = new JComboBox(carrerStrings);
        petList.setSelectedIndex(0);
        petList.addActionListener(this);
 
        Integer selectedIndex = petList.getSelectedIndex();
        System.out.println("Selected index: "+selectedIndex);
        
        add(petList, BorderLayout.PAGE_START);

    }
 
    /** Listens to the combo box. */
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        
        Integer si = (Integer)cb.getSelectedIndex();
        System.out.println("Selected index = "+si);
        this.selectedIndex = si;
        System.out.println("Index del Combo Box = "+this.getSelectedIndex());
    }

    public Integer getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(Integer selectedIndex) {
        System.out.println("Dentro de set selected index: "+selectedIndex);
        this.selectedIndex = selectedIndex;
    }
}
