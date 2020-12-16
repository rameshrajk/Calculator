import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1423386472639079185L;//eclipse wanted a serial
	//priv vars
	private String buffer = "0", tot = "0", lastDoneOp = "none", binStr, currentBase = "dec";
	private JPanel optionsPan1, optionsPan2, buttonsPan;//diff areas of calc for the two radio options sections and main button section
	private ButtonGroup optionsGroup1, optionsGroup2;//diff groups for radio options
	private JRadioButton hexButt, decButt, octButt, binButt, qwordButt, dwordButt, wordButt, byteButt;//radio buttons
	private JButton bemptty, bemptty2, bemptty3, bemptty4, bemptty5, bemptty6, bemptty7, bemptty8, bemptty9, bemptty10, bemptty11, bemptty12, bemptty13, bemptty14, bemptty15,
					a, b, c, d, e, f, mod, backspace, ce, clear, plusmin, root, percent, fraction, equals, plus, minus, multiply, divide, period,//all other buttons
					one, two, three, four, five, six, seven, eight, nine, zero, quot;
	private JTextField resultDisplay;//area where results are displayed
	//design not exactly windows 10 but has functionality in diff layout
	public Calculator() {
		//create layout and butts
		GroupLayout layout = new GroupLayout(getContentPane());
		setLayout(layout);
		createResultArea();
		createRadioButtons();
		createButtons();
		//horizontal and vertical group layouts
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGap(10)
							.addComponent(resultDisplay))
						.addGap(5)
						.addGroup(layout.createSequentialGroup())
						.addComponent(buttonsPan, GroupLayout.Alignment.CENTER, 200, 250, 500)));
		layout.setVerticalGroup(
				layout.createSequentialGroup()
					.addGap(10)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(resultDisplay))
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING))
					.addComponent(buttonsPan, 200, 250, 500));
	}
	
	private void createResultArea() {
		//result diplay
		resultDisplay = new JTextField(10);
		resultDisplay.setEditable(false);
		resultDisplay.setHorizontalAlignment(JTextField.RIGHT);
		resultDisplay.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 35));
		resultDisplay.setText("0");
		resultDisplay.setMaximumSize(new Dimension(390, 75));
		resultDisplay.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		resultDisplay.setBackground(new Color(50, 70, 50, 77));
	}
	
	private void createRadioButtons() {
		//panel 1 contains radio buttons for base conversions
		optionsPan1 = new JPanel();
		optionsPan1.setLayout(new GridLayout(4, 1));
		optionsGroup1 = new ButtonGroup();
		hexButt = new JRadioButton("Hex");
		decButt = new JRadioButton("Dec");
		octButt = new JRadioButton("Oct");
		binButt = new JRadioButton("Bin");
		hexButt.addActionListener(this);
		decButt.addActionListener(this);
		octButt.addActionListener(this);
		binButt.addActionListener(this);
		hexButt.setFont(new Font("Serif", Font.PLAIN, 11));
		decButt.setFont(new Font("Serif", Font.PLAIN, 11));
		octButt.setFont(new Font("Serif", Font.PLAIN, 11));
		binButt.setFont(new Font("Serif", Font.PLAIN, 11));
		optionsGroup1.add(hexButt);
		optionsGroup1.add(decButt);
		optionsGroup1.add(octButt);
		optionsGroup1.add(binButt);
		optionsPan1.add(hexButt);
		optionsPan1.add(decButt);
		optionsPan1.add(octButt);
		optionsPan1.add(binButt);
		optionsPan1.setBorder(BorderFactory.createEtchedBorder());
		decButt.setSelected(true);//dec is def
		//panel 2, word buttons don't actually do anything in this implementation
		optionsPan2 = new JPanel();
		optionsPan2.setLayout(new GridLayout(4, 1));
		optionsGroup2 = new ButtonGroup();
		qwordButt = new JRadioButton("Qword");
		dwordButt = new JRadioButton("Dword");
		wordButt = new JRadioButton("Word");
		byteButt = new JRadioButton("Byte");		
		qwordButt.setFont(new Font("Serif", Font.PLAIN, 11));
		dwordButt.setFont(new Font("Serif", Font.PLAIN, 11));
		wordButt.setFont(new Font("Serif", Font.PLAIN, 11));
		byteButt.setFont(new Font("Serif", Font.PLAIN, 11));		
		optionsGroup2.add(qwordButt);
		optionsGroup2.add(dwordButt);
		optionsGroup2.add(wordButt);
		optionsGroup2.add(byteButt);		
		optionsPan2.add(qwordButt);
		optionsPan2.add(dwordButt);
		optionsPan2.add(wordButt);
		optionsPan2.add(byteButt);		
		optionsPan2.setBorder(BorderFactory.createEtchedBorder());		
		qwordButt.setSelected(true);//qword is def
	}
	
	private void createButtons() {//creates all other non-radio buttons
		buttonsPan = new JPanel();
		buttonsPan.setLayout(new GridBagLayout());
		GridBagConstraints boundz = new GridBagConstraints();
		Dimension buttonSize = new Dimension(100, 100);//size of butts		
		//non-responsive buttons to fill space
		bemptty = new JButton();
		bemptty.setOpaque(true);
		bemptty.setPreferredSize(buttonSize);
		bemptty.setEnabled(false);		
		bemptty2 = new JButton();
		bemptty2.setOpaque(true);
		bemptty2.setPreferredSize(buttonSize);
		bemptty2.setEnabled(false);		
		bemptty3 = new JButton();
		bemptty3.setOpaque(true);
		bemptty3.setPreferredSize(buttonSize);
		bemptty3.setEnabled(false);		
		bemptty4 = new JButton();
		bemptty4.setOpaque(true);
		bemptty4.setPreferredSize(buttonSize);
		bemptty4.setEnabled(false);		
		bemptty5 = new JButton();
		bemptty5.setOpaque(true);
		bemptty5.setPreferredSize(buttonSize);
		bemptty5.setEnabled(false);		
		bemptty6 = new JButton();
		bemptty6.setOpaque(true);
		bemptty6.setPreferredSize(buttonSize);
		bemptty6.setEnabled(false);		
		bemptty7 = new JButton();
		bemptty7.setOpaque(true);
		bemptty7.setPreferredSize(buttonSize);
		bemptty7.setEnabled(false);		
		bemptty8 = new JButton();
		bemptty8.setOpaque(true);
		bemptty8.setPreferredSize(buttonSize);
		bemptty8.setEnabled(false);		
		bemptty9 = new JButton();
		bemptty9.setOpaque(true);
		bemptty9.setPreferredSize(buttonSize);
		bemptty9.setEnabled(false);		
		bemptty10 = new JButton();
		bemptty10.setOpaque(true);
		bemptty10.setPreferredSize(buttonSize);
		bemptty10.setEnabled(false);		
		bemptty11 = new JButton();
		bemptty11.setOpaque(true);
		bemptty11.setPreferredSize(buttonSize);
		bemptty11.setEnabled(false);		
		bemptty12 = new JButton();
		bemptty12.setOpaque(true);
		bemptty12.setPreferredSize(buttonSize);
		bemptty12.setEnabled(false);		
		bemptty13 = new JButton();
		bemptty13.setOpaque(true);
		bemptty13.setPreferredSize(buttonSize);
		bemptty13.setEnabled(false);		
		bemptty14 = new JButton();
		bemptty14.setOpaque(true);
		bemptty14.setPreferredSize(buttonSize);
		bemptty14.setEnabled(false);		
		bemptty15 = new JButton();
		bemptty15.setOpaque(true);
		bemptty15.setPreferredSize(buttonSize);
		bemptty15.setEnabled(false);		
		//quot butt
		quot = new JButton("Quot");
		quot.setOpaque(false);
		quot.setPreferredSize(buttonSize);
		quot.setBorder(null);
		quot.setFont(new Font("Serif", Font.PLAIN, 9));
		quot.addActionListener(this);		
		//mod butt
		mod = new JButton("Mod");
		mod.setPreferredSize(buttonSize);
		mod.setBorder(null);
		mod.setFont(new Font("Serif", Font.PLAIN, 9));
		mod.addActionListener(this);
		//letter butts
		a = new JButton("A");
		a.setPreferredSize(buttonSize);
		a.setEnabled(false);
		a.addActionListener(this);		
		b = new JButton("B");
		b.setPreferredSize(buttonSize);
		b.setEnabled(false);
		b.addActionListener(this);		
		c = new JButton("C");
		c.setPreferredSize(buttonSize);
		c.setEnabled(false);
		c.addActionListener(this);		
		d = new JButton("D");
		d.setPreferredSize(buttonSize);
		d.setEnabled(false);
		d.addActionListener(this);		
		e = new JButton("E");
		e.setPreferredSize(buttonSize);
		e.setEnabled(false);
		e.addActionListener(this);	
		f = new JButton("F");
		f.setPreferredSize(buttonSize);
		f.setEnabled(false);
		f.addActionListener(this);		
		//nums
		zero = new JButton("0");
		zero.setPreferredSize(new Dimension(20, 10));
		zero.addActionListener(this);		
		one = new JButton("1");
		one.setPreferredSize(buttonSize);
		one.addActionListener(this);		
		two = new JButton("2");
		two.setPreferredSize(buttonSize);
		two.addActionListener(this);		
		three = new JButton("3");
		three.setPreferredSize(buttonSize);
		three.addActionListener(this);		
		four = new JButton("4");
		four.setPreferredSize(buttonSize);
		four.addActionListener(this);		
		five = new JButton("5");
		five.setPreferredSize(buttonSize);
		five.addActionListener(this);		
		six = new JButton("6");
		six.setPreferredSize(buttonSize);
		six.addActionListener(this);	
		seven = new JButton("7");
		seven.setPreferredSize(buttonSize);
		seven.addActionListener(this);		
		eight = new JButton("8");
		eight.setPreferredSize(buttonSize);
		eight.addActionListener(this);		
		nine = new JButton("9");
		nine.setPreferredSize(buttonSize);
		nine.addActionListener(this);		
		//backspace butt
		backspace = new JButton("\u2190");
		backspace.setPreferredSize(buttonSize);
		backspace.setBorder(null);
		backspace.addActionListener(this);		
		//clear recent entry
		ce = new JButton("CE");
		ce.setPreferredSize(buttonSize);
		ce.setBorder(null);
		ce.addActionListener(this);
		//clear all
		clear = new JButton("C");
		clear.setPreferredSize(buttonSize);
		clear.addActionListener(this);		
		//operation butts
		plusmin = new JButton("\u00B1");
		plusmin.setPreferredSize(buttonSize);
		plusmin.addActionListener(this);		
		divide = new JButton("/");
		divide.setPreferredSize(buttonSize);
		divide.addActionListener(this);		
		multiply = new JButton("*");
		multiply.setPreferredSize(buttonSize);
		multiply.addActionListener(this);	
		minus = new JButton("-");
		minus.setPreferredSize(buttonSize);
		minus.addActionListener(this);		
		plus = new JButton("+");
		plus.setPreferredSize(buttonSize);
		plus.addActionListener(this);		
		root = new JButton("\u221A");
		root.setPreferredSize(buttonSize);
		root.addActionListener(this);		
		percent = new JButton("%");
		percent.setPreferredSize(buttonSize);
		percent.setBorder(null);
		percent.addActionListener(this);		
		fraction = new JButton("1\u2044x");
		fraction.setPreferredSize(buttonSize);
		fraction.setBorder(null);
		fraction.addActionListener(this);		
		equals = new JButton("=");
		equals.setPreferredSize(new Dimension(10, 20));
		equals.addActionListener(this);		
		period = new JButton(".");
		period.setPreferredSize(buttonSize);
		period.addActionListener(this);		
		//add bounds, or the grid vals for each button
		boundz.fill = GridBagConstraints.BOTH;//The GridBagConstraints class specifies bounds for components that are laid out using the GridBagLayout class.
		boundz.ipady = 10;		
		boundz.ipadx = 18;
		boundz.gridheight = 3;
		boundz.gridwidth = 2;
		boundz.gridx = 0;
		boundz.gridy = 0;
		buttonsPan.add(optionsPan1, boundz);
		boundz.gridheight = 3;
		boundz.gridwidth = 2;
		boundz.gridx = 0;
		boundz.gridy = 3;
		buttonsPan.add(optionsPan2, boundz);		
		boundz.ipadx = 0;
		boundz.gridheight = 1;
		boundz.gridwidth = 1;
		boundz.gridx = 2;
		boundz.gridy = 0;
		buttonsPan.add(quot, boundz);
		boundz.gridx = 3;
		boundz.gridy = 0;
		buttonsPan.add(mod, boundz);
		boundz.gridx = 4;
		boundz.gridy = 0;
		buttonsPan.add(a, boundz);
		boundz.gridx = 5;
		boundz.gridy = 0;
		buttonsPan.add(bemptty9, boundz);
		boundz.gridx = 6;
		boundz.gridy = 0;
		buttonsPan.add(bemptty10, boundz);
		boundz.gridx = 7;
		boundz.gridy = 0;
		buttonsPan.add(bemptty11, boundz);
		boundz.gridx = 8;
		boundz.gridy = 0;
		buttonsPan.add(bemptty12, boundz);
		boundz.gridx = 9;
		boundz.gridy = 0;
		buttonsPan.add(bemptty13, boundz);
		//row 2
		boundz.gridx = 2;
		boundz.gridy = 1;
		buttonsPan.add(bemptty, boundz);
		boundz.gridx = 3;
		boundz.gridy = 1;
		buttonsPan.add(bemptty2, boundz);
		boundz.gridx = 4;
		boundz.gridy = 1;
		buttonsPan.add(b, boundz);
		boundz.gridx = 5;
		boundz.gridy = 1;
		buttonsPan.add(backspace, boundz);
		boundz.gridx = 6;
		boundz.gridy = 1;
		buttonsPan.add(ce, boundz);
		boundz.gridx = 7;
		boundz.gridy = 1;
		buttonsPan.add(clear, boundz);
		boundz.gridx = 8;
		boundz.gridy = 1;
		buttonsPan.add(plusmin, boundz);
		boundz.gridx = 9;
		boundz.gridy = 1;
		buttonsPan.add(root, boundz);
		//row 3
		boundz.gridx = 2;
		boundz.gridy = 2;
		buttonsPan.add(bemptty3, boundz);
		boundz.gridx = 3;
		boundz.gridy = 2;
		buttonsPan.add(bemptty4, boundz);
		boundz.gridx = 4;
		boundz.gridy = 2;
		buttonsPan.add(c, boundz);
		boundz.gridx = 5;
		boundz.gridy = 2;
		buttonsPan.add(seven, boundz);
		boundz.gridx = 6;
		boundz.gridy = 2;
		buttonsPan.add(eight, boundz);
		boundz.gridx = 7;
		boundz.gridy = 2;
		buttonsPan.add(nine, boundz);
		boundz.gridx = 8;
		boundz.gridy = 2;
		buttonsPan.add(divide, boundz);
		boundz.gridx = 9;
		boundz.gridy = 2;
		buttonsPan.add(percent, boundz);		
		//row 4
		boundz.gridx = 2;
		boundz.gridy = 3;
		buttonsPan.add(bemptty5, boundz);
		boundz.gridx = 3;
		boundz.gridy = 3;
		buttonsPan.add(bemptty6, boundz);
		boundz.gridx = 4;
		boundz.gridy = 3;
		buttonsPan.add(d, boundz);
		boundz.gridx = 5;
		boundz.gridy = 3;
		buttonsPan.add(four, boundz);
		boundz.gridx = 6;
		boundz.gridy = 3;
		buttonsPan.add(five, boundz);
		boundz.gridx = 7;
		boundz.gridy = 3;
		buttonsPan.add(six, boundz);
		boundz.gridx = 8;
		boundz.gridy = 3;
		buttonsPan.add(multiply, boundz);
		boundz.gridx = 9;
		boundz.gridy = 3;
		buttonsPan.add(fraction, boundz);
		//row 5
		boundz.gridx = 2;
		boundz.gridy = 4;
		buttonsPan.add(bemptty7, boundz);
		boundz.gridx = 3;
		boundz.gridy = 4;
		buttonsPan.add(bemptty8, boundz);
		boundz.gridx = 4;
		boundz.gridy = 4;
		buttonsPan.add(e, boundz);
		boundz.gridx = 5;
		boundz.gridy = 4;
		buttonsPan.add(one, boundz);
		boundz.gridx = 6;
		boundz.gridy = 4;
		buttonsPan.add(two, boundz);
		boundz.gridx = 7;
		boundz.gridy = 4;
		buttonsPan.add(three, boundz);
		boundz.gridx = 8;
		boundz.gridy = 4;
		buttonsPan.add(minus, boundz);
		boundz.gridx = 9;
		boundz.gridy = 4;
		boundz.gridheight = 2;
		buttonsPan.add(equals, boundz);		
		//row 7
		boundz.gridheight = 1;
		boundz.gridx = 2;
		boundz.gridy = 5;
		buttonsPan.add(bemptty14, boundz);
		boundz.gridx = 3;
		boundz.gridy = 5;
		buttonsPan.add(bemptty15, boundz);
		boundz.gridx = 4;
		boundz.gridy = 5;
		buttonsPan.add(f, boundz);
		boundz.gridx = 5;
		boundz.gridy = 5;
		boundz.gridwidth = 2;
		buttonsPan.add(zero, boundz);
		boundz.gridwidth = 1;
		boundz.gridx = 7;
		boundz.gridy = 5;
		buttonsPan.add(period, boundz);
		boundz.gridx = 8;
		boundz.gridy = 5;
		buttonsPan.add(plus, boundz);
	}
	//responsible for all action events, the butts
	@Override
	public void actionPerformed(ActionEvent e) {			
		if (e.getSource() == zero) {
			if (buffer != "0") {
				addToBuffer("0");//every event works with data buffer
				displayBuffer();//displays the numbers we're working with
				bufferToBin();//converts to bin if needed for display
			}
			else {
				if (resultDisplay.getText() != "0") {
					displayBuffer();
				}
			}
		}
		else if (e.getSource() == one) {
			addToBuffer("1");
			displayBuffer();
			bufferToBin();
		}
		else if (e.getSource() == two) {
			addToBuffer("2");
			displayBuffer();
			bufferToBin();
		}
		else if (e.getSource() == three) {
			addToBuffer("3");
			displayBuffer();
			bufferToBin();
		}
		else if (e.getSource() == four) {
			addToBuffer("4");
			displayBuffer();
			bufferToBin();
		}
		else if (e.getSource() == five) {
			addToBuffer("5");
			displayBuffer();
			bufferToBin();
		}
		else if (e.getSource() == six) {
			addToBuffer("6");
			displayBuffer();
			bufferToBin();
		}
		else if (e.getSource() == seven) {
			addToBuffer("7");
			displayBuffer();
			bufferToBin();
		}
		else if (e.getSource() == eight) {
			addToBuffer("8");
			displayBuffer();
			bufferToBin();
		}
		else if (e.getSource() == nine) {
			addToBuffer("9");
			displayBuffer();
			bufferToBin();
		}
		else if (e.getSource() == period) {
			if (isInt(buffer)) {
				if (buffer == "0") {
					buffer += ".";
				}
				else {
					addToBuffer(".");					
				}				
				displayBuffer();
				bufferToBin();
			}
		}		
		else if (e.getSource() == a) {
			addToBuffer("A");
			displayBuffer();
			bufferToBin();
		}
		else if (e.getSource() == b) {
			addToBuffer("B");
			displayBuffer();
			bufferToBin();
		}
		else if (e.getSource() == c) {
			addToBuffer("C");
			displayBuffer();
			bufferToBin();
		}
		else if (e.getSource() == d) {
			addToBuffer("D");
			displayBuffer();
			bufferToBin();
		}
		else if (e.getSource() == this.e) {
			addToBuffer("E");
			displayBuffer();
			bufferToBin();
		}
		else if (e.getSource() == f) {
			addToBuffer("F");
			displayBuffer();
			bufferToBin();
		}	
		else if (e.getSource() == backspace) {
			if (buffer.length() == 1) {
				buffer = "0";
			}
			else if (buffer.length() == 2 && (buffer.charAt(0) == '-')) {
				buffer = "0";
			}
			else {
				buffer = buffer.substring(0, buffer.length() - 1);
			}
			displayBuffer();
			bufferToBin();
		}
		else if (e.getSource() == clear) {
			buffer = "0";
			tot = "0";
			displayBuffer();
			bufferToBin();
		}
		else if (e.getSource() == ce) {
			buffer = "0";
			displayBuffer();
			bufferToBin();
		}
		else if (e.getSource() == plus) {
			completelastDoneOp();
			if (buffer != "Cannot divide by zero") {
				tot = buffer;
				bufferToBin();
			}
			displayBuffer();
			buffer = "0";
			lastDoneOp = "add";
		}
		else if (e.getSource() == minus) {
			completelastDoneOp();
			if (buffer != "Cannot divide by zero") {
				tot = buffer;
				bufferToBin();
			}
			displayBuffer();
			buffer = "0";
			lastDoneOp = "subtract";
		}
		else if (e.getSource() == multiply) {
			completelastDoneOp();
			if (buffer != "Cannot divide by zero") {
				tot = buffer;
				bufferToBin();
			}
			displayBuffer();
			buffer = "0";
			lastDoneOp = "multiply";
		}
		else if (e.getSource() == divide || e.getSource() == quot) {
			completelastDoneOp();
			if (buffer != "Cannot divide by zero") {
				tot = buffer;
				bufferToBin();
			}
			displayBuffer();
			buffer = "0";
			lastDoneOp = "divide";
		}
		else if (e.getSource() == plusmin) {
			buffer = -Long.parseLong(buffer) + "";
			displayBuffer();
			bufferToBin();
		}
		else if (e.getSource() == equals) {
			completelastDoneOp();
			if (buffer != "Cannot divide by zero") {
				tot = buffer;
				bufferToBin();
			}
			displayBuffer();
			buffer = "0";
			lastDoneOp = "equals";
		}
		else if (e.getSource() == mod) {
			completelastDoneOp();
			if (buffer != "Cannot divide by zero") {
				tot = buffer;
				bufferToBin();
			}
			displayBuffer();
			buffer = "0";
			lastDoneOp = "mod";
		}
		else if (e.getSource() == root) {
			if (currentBase == "dec") {
				buffer = Math.sqrt(Double.parseDouble(buffer)) + "";
				if (buffer.charAt(buffer.length() - 1) == '0' && buffer.charAt(buffer.length() - 2) == '.')
				{
					buffer = remDecimal(buffer);
				}
			}
			if (buffer.equals("NaN")) {
				buffer = "Undefined";
				displayBuffer();
				buffer = "0";
			}
			else {
				displayBuffer();
			}
			bufferToBin();
		}
		else if (e.getSource() == percent) {
			if (currentBase == "dec") {
				buffer = (Double.valueOf(tot) * (Double.valueOf(buffer) / 100.0)) + "";
				if (buffer.charAt(buffer.length() - 1) == '0' && buffer.charAt(buffer.length() - 2) == '.') {
					buffer = remDecimal(buffer);
				}
			}
			displayBuffer();
			bufferToBin();
		}
		else if (e.getSource() == fraction) {
			if (currentBase == "dec") {
				buffer = (1.0 / Double.valueOf(buffer)) + "";
				if (buffer.charAt(buffer.length() - 1) == '0' && buffer.charAt(buffer.length() - 2) == '.') {
					buffer = remDecimal(buffer);
				}
			}
			displayBuffer();
			bufferToBin();
		}
		else if (e.getSource() == hexButt) {
			if (lastDoneOp != "none") {
				//buffer is tot if operation is mid-freeze
				buffer = tot;
				lastDoneOp = "none";
			}			
			if (currentBase == "dec") {
				if (!isInt(buffer)) {
					buffer = remDecimal(buffer);
				}
				buffer = convertDecToHex();
				root.setEnabled(false);
				percent.setEnabled(false);
				fraction.setEnabled(false);
			}
			else if (currentBase == "oct") {
				buffer = convertOctToHex();
				eight.setEnabled(true);
				nine.setEnabled(true);
			}
			else if (currentBase == "bin") {
				buffer = convertBinToHex();
				two.setEnabled(true);
				three.setEnabled(true);
				four.setEnabled(true);
				five.setEnabled(true);
				six.setEnabled(true);
				seven.setEnabled(true);
				eight.setEnabled(true);
				nine.setEnabled(true);
			}
			currentBase = "hex";
			displayBuffer();			
			a.setEnabled(true);
			b.setEnabled(true);
			c.setEnabled(true);
			d.setEnabled(true);
			this.e.setEnabled(true);
			f.setEnabled(true);
			period.setEnabled(false);
		}
		else if (e.getSource() == octButt) {
			if (lastDoneOp != "none") {
				// Set the buffer as the tot if we have a hanging operation
				buffer = tot;
				lastDoneOp = "none";
			}			
			if (currentBase == "dec") {
				if (!isInt(buffer)) {
					buffer = remDecimal(buffer);
				}
				buffer = convertDecToOct();
				root.setEnabled(false);
				percent.setEnabled(false);
				fraction.setEnabled(false);
			}
			else if (currentBase == "hex") {
				buffer = convertHexToOct();
			}
			else if (currentBase == "bin") {
				buffer = convertBinToOct();
				two.setEnabled(true);
				three.setEnabled(true);
				four.setEnabled(true);
				five.setEnabled(true);
				six.setEnabled(true);
				seven.setEnabled(true);
			}
			currentBase = "oct";
			displayBuffer();			
			if (a.isEnabled()) {
				a.setEnabled(false);
				b.setEnabled(false);
				c.setEnabled(false);
				d.setEnabled(false);
				this.e.setEnabled(false);
				f.setEnabled(false);
			}
			period.setEnabled(false);
			eight.setEnabled(false);
			nine.setEnabled(false);
		}
		else if (e.getSource() == binButt) {
			if (lastDoneOp != "none") {
				buffer = tot;
				lastDoneOp = "none";
			}		
			if (currentBase == "dec") {
				if (!isInt(buffer)) {
					buffer = remDecimal(buffer);
				}
				buffer = convertDecToBin();
				root.setEnabled(false);
				percent.setEnabled(false);
				fraction.setEnabled(false);
			}
			else if (currentBase == "hex") {
				buffer = convertHexToBin();
			}
			else if (currentBase == "oct") {
				buffer = convertOctToBin();
				eight.setEnabled(true);
				nine.setEnabled(true);
			}
			currentBase = "bin";
			displayBuffer();			
			two.setEnabled(false);
			three.setEnabled(false);
			four.setEnabled(false);
			five.setEnabled(false);
			six.setEnabled(false);
			seven.setEnabled(false);
			eight.setEnabled(false);
			nine.setEnabled(false);			
			if (a.isEnabled()) {
				a.setEnabled(false);
				b.setEnabled(false);
				c.setEnabled(false);
				d.setEnabled(false);
				this.e.setEnabled(false);
				f.setEnabled(false);
			}
			period.setEnabled(false);
		}
		else if (e.getSource() == decButt) {
			if (lastDoneOp != "none") {
				buffer = tot;
				lastDoneOp = "none";
			}			
			if (currentBase == "hex") {
				buffer = convertHexToDec();
			}
			else if (currentBase == "oct") {
				buffer = convertOctToDec();
				eight.setEnabled(true);
				nine.setEnabled(true);
			}
			else if (currentBase == "bin") {
				buffer = convertBinToDec();
				two.setEnabled(true);
				three.setEnabled(true);
				four.setEnabled(true);
				five.setEnabled(true);
				six.setEnabled(true);
				seven.setEnabled(true);
				eight.setEnabled(true);
				nine.setEnabled(true);
			}
			currentBase = "dec";
			displayBuffer();		
			if (a.isEnabled()) {
				a.setEnabled(false);
				b.setEnabled(false);
				c.setEnabled(false);
				d.setEnabled(false);
				this.e.setEnabled(false);
				f.setEnabled(false);
			}
			period.setEnabled(true);
			root.setEnabled(true);
			percent.setEnabled(true);
			fraction.setEnabled(true);
		}
	}

	public void completelastDoneOp() {
		if (buffer.length() > 1) {
			if (buffer.charAt(buffer.length() - 1) == '0' && (buffer.charAt(buffer.length() - 2)) == '.') {
				buffer = remDecimal(buffer);
			}
		}		
		//for multiple, diff operations, do last operation first
		if (lastDoneOp == "add") {
			if (currentBase == "dec") {
				if (isInt(buffer) && isInt(tot)) {
					buffer = (Long.parseLong(buffer) + Long.parseLong(tot)) + "";										
				}
				else {
					buffer = (Double.parseDouble(buffer) + Double.parseDouble(tot)) + "";
				}
			}
			else if (currentBase == "hex") {
				buffer = Long.toHexString(Long.parseLong(buffer, 16) + Long.parseLong(tot, 16)).toUpperCase();
			}
			else if (currentBase == "oct") {
				buffer = Long.toOctalString(Long.parseLong(buffer, 8) + Long.parseLong(tot, 8));
			}
			else {
				buffer = Long.toBinaryString(Long.parseLong(buffer, 2) + Long.parseLong(tot, 2));
			}
		}
		else if (lastDoneOp == "subtract") {
			if (currentBase == "dec") {
				if (isInt(buffer) && isInt(tot)) {
					buffer = (Long.parseLong(tot) - Long.parseLong(buffer)) + "";										
				}
				else {
					buffer = (Double.parseDouble(tot) - Double.parseDouble(buffer)) + "";
				}
			}
			else if (currentBase == "hex") {
				buffer = Long.toHexString(Long.parseLong(tot, 16) - Long.parseLong(buffer, 16)).toUpperCase();
			}
			else if (currentBase == "oct") {
				buffer = Long.toOctalString(Long.parseLong(tot, 8) - Long.parseLong(buffer, 8));
			}
			else {
				buffer = Long.toBinaryString(Long.parseLong(tot, 2) - Long.parseLong(buffer, 2));
			}
		}
		else if (lastDoneOp == "multiply") {
			if (currentBase == "dec") {
				if (isInt(buffer) && isInt(tot)) {
					buffer = (Long.parseLong(buffer) * Long.parseLong(tot)) + "";						
				}
				else {
					buffer = (Double.parseDouble(buffer) * Double.parseDouble(tot)) + "";
				}
			}
			else if (currentBase == "hex") {
				buffer = Long.toHexString(Long.parseLong(buffer, 16) * Long.parseLong(tot, 16)).toUpperCase();	
			}
			else if (currentBase == "oct") {
				buffer = Long.toOctalString(Long.parseLong(buffer, 8) * Long.parseLong(tot, 8));	
			}
			else {
				buffer = Long.toBinaryString(Long.parseLong(buffer, 2) * Long.parseLong(tot, 2));	
			}
		}
		else if (lastDoneOp == "divide") {
			if (Double.valueOf(buffer) == 0.0) {
				buffer = "Cannot divide by zero";
			}
			else if (currentBase == "dec") {
				buffer = (Double.parseDouble(tot) / Double.parseDouble(buffer)) + "";
				if (buffer.charAt(buffer.length() - 1) == '0' && (buffer.charAt(buffer.length() - 2)) == '.') {
					buffer = remDecimal(buffer);
				}
			}
			else if (currentBase == "hex") {
				buffer = Long.toHexString(Long.parseLong(tot, 16) / Long.parseLong(buffer, 16)).toUpperCase();	
			}
			else if (currentBase == "oct") {
				buffer = Long.toOctalString(Long.parseLong(tot, 8) / Long.parseLong(buffer, 8));	
			}
			else {
				buffer = Long.toBinaryString(Long.parseLong(tot, 2) / Long.parseLong(buffer, 2));	
			}
		}
		else if (lastDoneOp == "mod") {
			if (currentBase == "dec") {
				if (isInt(buffer) && isInt(tot)) {
					buffer = (Long.parseLong(tot) % Long.parseLong(buffer)) + "";
				}
				else {
					buffer = (Double.parseDouble(tot) % Double.parseDouble(buffer)) + "";
				}
			}
			else if (currentBase == "hex") {
				buffer = Long.toHexString(Long.parseLong(tot, 16) % Long.parseLong(buffer, 16)).toUpperCase();
			}
			else if (currentBase == "oct") {
				buffer = Long.toOctalString(Long.parseLong(tot, 8) % Long.parseLong(buffer, 8));
			}
			else {
				buffer = Long.toBinaryString(Long.parseLong(tot, 2) % Long.parseLong(buffer, 2));
			}
		}
	}
	//conv methods
	public String convertHexToDec() {
		return new BigInteger(buffer, 16).toString(10);
	}	
	public String convertOctToDec() {
		return new BigInteger(buffer, 8).toString(10);
	}	
	public String convertBinToDec() {
		return new BigInteger(buffer, 2).toString(10);
	}	
	public String convertDecToOct() {
		return new BigInteger(buffer, 10).toString(8);
	}	
	public String convertHexToOct() {
		return new BigInteger(buffer, 16).toString(8);
	}	
	public String convertBinToOct() {
		return new BigInteger(buffer, 2).toString(8);
	}	
	public String convertDecToHex() {
		return new BigInteger(buffer, 10).toString(16).toUpperCase();
	}	
	public String convertOctToHex() {	
		return new BigInteger(buffer, 8).toString(16).toUpperCase();
	}	
	public String convertBinToHex() {
		return new BigInteger(buffer, 2).toString(16).toUpperCase();
	}	
	public String convertDecToBin() {
		return new BigInteger(buffer, 10).toString(2);
	}	
	public String convertHexToBin() {
		return new BigInteger(buffer, 16).toString(2);
	}	
	public String convertOctToBin() {
		return new BigInteger(buffer, 8).toString(2);
	}	
	public void addToBuffer(String num) {
		if (buffer.equals("0")) {
			buffer = num;
		}
		else {
			buffer += num;
		}
	}	
	public boolean isInt(String number) {//method to find if num is int
			for (int i = 0; i < number.length(); ++i) {
				if (number.charAt(i) == '.') {
					return false;
				}
			}
		return true;
	}	
	public String remDecimal(String number) {//remove decimal in string number
		for (int i = 0; i < number.length(); ++i)
		{
			if (number.charAt(i) == '.') {
				return number.substring(0, i);
			}
		}
		return number;
	}	
	boolean isNeg() {//to check if buffer has negative sign
		if (binStr.charAt(0) == '-') {
			return true;
		}
		return false;
	}
	//display buffer
	public void displayBuffer() {
		resultDisplay.setText(buffer);
	}
	//convert buffer to binary
	public void bufferToBin() {
		if (currentBase == "dec") {
			String bufferAsInt;
			if (!isInt(buffer)) {
				bufferAsInt = remDecimal(buffer);//rid of dec
			}
			else {
				bufferAsInt = buffer;
			}			
			binStr = new BigInteger(bufferAsInt, 10).toString(2);
		}
		else if (currentBase == "oct") {
			binStr = new BigInteger(buffer, 8).toString(2);
		}
		else if (currentBase == "hex") {
			binStr = new BigInteger(buffer, 16).toString(2);
		}
		else {
			binStr = buffer;
		}		
		//if has neg, rid of it
		if (isNeg()) {
			binStr = binStr.substring(1, binStr.length());
		}
		//buffer converted, if bin option not chosen
		int binLength = binStr.length();
		if (binLength != 64) {
			for (int i = 0; i < (64 - binLength); ++i) {
				binStr = "0" + binStr;
			}
		}
	}
}