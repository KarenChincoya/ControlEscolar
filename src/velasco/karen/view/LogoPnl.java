package velasco.karen.view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LogoPnl extends JPanel{
	
	public LogoPnl() {
		try {
			BufferedImage image;
			image = ImageIO.read(new File("logo2.jpg"));
			JLabel label = new JLabel(new ImageIcon(image));
		    super.add(label);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("No se leyo la img");
		}
	    
	}

}
