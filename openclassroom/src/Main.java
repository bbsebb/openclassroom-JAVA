import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Main {

	public static void main(String[] args) {
		
	JFrame g = new JFrame("Test");
	g.setSize(400, 400);
	g.setLocationRelativeTo(null);
	BeanPropertiesTable BeanPorperties = new BeanPropertiesTable();
	BeanPorperties.setInstance((Object) new JButton("test"));
	g.getContentPane().add(BeanPorperties);
	g.setVisible(true);
		
	}

}
