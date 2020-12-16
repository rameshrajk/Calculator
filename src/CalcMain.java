import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

//contains main method
public class CalcMain {
	public static void main(String[] args) {
		try {
			 for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) { //get info on currently available LookAndFeels put in info array
			        if ("Nimbus".equals(info.getName())) {//started off with nimbus and couldn't get Windows to work in the end, I got display bugs \:
			            UIManager.setLookAndFeel(info.getClassName());//set LookAndFeel to class name in LookAndFeel info
			            break;
			        }		
			 }
	    }
		catch (Exception e) {//if doesn't work in other sit
				e.printStackTrace();//print the errors
		}
		//create new Calc
		Calculator myCalc = new Calculator();
		myCalc.setSize(420, 400);//myCalc size
		myCalc.setVisible(true);
		myCalc.setTitle("My Calculator");
		myCalc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myCalc.setResizable(false);
	}
}