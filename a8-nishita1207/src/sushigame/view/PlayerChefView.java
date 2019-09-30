package sushigame.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import comp401sushi.AvocadoPortion;
import comp401sushi.CrabPortion;
import comp401sushi.EelPortion;
import comp401sushi.IngredientPortion;
import comp401sushi.Nigiri;
import comp401sushi.Plate;
import comp401sushi.RedPlate;
import comp401sushi.RicePortion;
import comp401sushi.Roll;
import comp401sushi.Sashimi;
import comp401sushi.SeaweedPortion;
import comp401sushi.ShrimpPortion;
import comp401sushi.Sushi;
import comp401sushi.TunaPortion;

public class PlayerChefView extends JPanel implements ActionListener {

	private List<ChefViewListener> listeners;
	private Sushi kmpRoll;
	private Sushi crabSashimi;
	private Sushi eelSashimi;
	private Sushi salmonSashimi;
	private Sushi shrimpSashimi;
	private Sushi tunaSashimi;
	private Sushi eelNigiri;
	private Sushi crabNigiri;
	
	private Sushi shrimpNigiri;
	private Sushi tunaNigiri;
	private int belt_size;
	private String type;
	private String[] positionArray;

	public PlayerChefView(int belt_size) {
		this.belt_size = belt_size;
		listeners = new ArrayList<ChefViewListener>();
		positionArray = new String[belt_size];

		for (int i = 0; i < belt_size; i++) {
			positionArray[i] = "" + i;
		}

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JButton sashimi_option = new JButton("Construct Sashimi");
		sashimi_option.setActionCommand("make_sashimi");
		sashimi_option.addActionListener(this);
		add(sashimi_option);
		
		JButton nigiri_option = new JButton("Construct Nigiri");
		nigiri_option.setActionCommand("make_nigiri");
		nigiri_option.addActionListener(this);
		add(nigiri_option);

		JButton roll_option = new JButton("COnstruct Roll");
		roll_option.setActionCommand("make_roll");
		roll_option.addActionListener(this);
		add(roll_option);

		kmpRoll = new Roll("KMP Roll", new IngredientPortion[] {new EelPortion(1.0), new AvocadoPortion(0.5), new SeaweedPortion(0.2)});
		crabSashimi = new Sashimi(Sashimi.SashimiType.CRAB);
		eelSashimi = new Sashimi(Sashimi.SashimiType.EEL);
		shrimpSashimi = new Sashimi(Sashimi.SashimiType.SHRIMP);
		tunaSashimi = new Sashimi(Sashimi.SashimiType.TUNA);

		crabNigiri = new Nigiri(Nigiri.NigiriType.CRAB);
		eelNigiri = new Nigiri(Nigiri.NigiriType.EEL);
		shrimpNigiri = new Nigiri(Nigiri.NigiriType.SHRIMP);
		tunaNigiri = new Nigiri(Nigiri.NigiriType.TUNA);

	}

	public void registerChefListener(ChefViewListener cl) {
		listeners.add(cl);
	}

	private void makeRedPlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleRedPlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeGreenPlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleGreenPlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeBluePlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleBluePlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeGoldPlateRequest(Sushi plate_sushi, int plate_position, double price) {
		for (ChefViewListener l : listeners) {
			l.handleGoldPlateRequest(plate_sushi, plate_position, price);
		}
	}

	public void sashimiMaker() {
		//		String type;
		JFrame newFrame = new JFrame("Make Sashimi");
		newFrame.setBackground(Color.CYAN);
		newFrame.setSize(700, 300);
		newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel newPanel = new JPanel();
		newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));
		newFrame.add(newPanel);

		JLabel nameLabel = new JLabel("Select your type of sashimi, color of plate, and position. If plate is gold, select a price");
		nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(nameLabel);

		JLabel typeLabel = new JLabel("Select type of sashimi");
		typeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(typeLabel);

		String[] typeOptions = {"Crab" , "Eel", "Shrimp", "Tuna" };
		final JComboBox<String> typeOptionPane = new JComboBox<String>(typeOptions);
		typeOptionPane.setMaximumSize(typeOptionPane.getPreferredSize());
		typeOptionPane.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(typeOptionPane);

		Hashtable<Integer, JLabel> lMap = new Hashtable<>();
		lMap.put(Integer.valueOf(50), new JLabel("$5.0"));
		lMap.put(Integer.valueOf(75), new JLabel("$7.5"));
		lMap.put(Integer.valueOf(100), new JLabel("$10.0"));

		JLabel priceLabel = new JLabel("Price");
		priceLabel.setVisible(false);
		priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(priceLabel);

		JSlider price = new JSlider(50,100);
		price.setLabelTable(lMap);
		price.setPaintLabels(true);
		//		price.addChangeListener(this);
		price.setName("price");
		price.setVisible(false);
		price.setAlignmentX(Component.CENTER_ALIGNMENT);
		price.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent event) {
				int current = ((JSlider)event.getSource()).getValue();
				double currentX = current / 10.0;
				priceLabel.setText("The price is $" + currentX);
			}

		});
		newPanel.add(price);
		price.setMajorTickSpacing(10);
		price.setMinorTickSpacing(1);
		price.setPaintTicks(true);

		JLabel plateLabel = new JLabel("Select the type of plate");
		plateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(plateLabel);		

		String[] plates = { "Red", "Blue", "Green", "Gold" };
		final JComboBox<String> plateOptions = new JComboBox<String> (plates);
		plateOptions.setMaximumSize(plateOptions.getPreferredSize());
		plateOptions.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(plateOptions);
		plateOptions.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (plateOptions.getSelectedItem().toString().equals("Gold")) {
					price.setVisible(true);
					priceLabel.setVisible(true);
				} else {
					price.setVisible(false);
					priceLabel.setVisible(false);
				}
			}

		});

		JLabel positionLabel = new JLabel("Select the position");
		positionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(positionLabel);

		final JComboBox<String> numbers = new JComboBox<String> (positionArray);
		numbers.setMaximumSize(numbers.getPreferredSize());
		numbers.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(numbers);

		JButton make = new JButton("Make a Sashimi!");
		make.setActionCommand("Make");
		make.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(make);
		make.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object numberSelected = numbers.getSelectedItem();
				int newNumber = Integer.parseInt(numberSelected.toString());
				//				Object typeSelected = typeOptionPane.getSelectedItem();
				//				Object plateSelected = plateOptions.getSelectedItem();
				int priceFinal = price.getValue();
				double priceX = priceFinal / 10.0;

				switch(typeOptionPane.getSelectedItem().toString()) {
				case "Crab": 
					switch(plateOptions.getSelectedItem().toString()) {
					case "Red":
						makeRedPlateRequest(crabSashimi, newNumber);
						break;
					case "Blue":
						makeBluePlateRequest(crabSashimi, newNumber);
						break;
					case "Green":
						makeGreenPlateRequest(crabSashimi, newNumber);
					case "Gold":
						makeGoldPlateRequest(crabSashimi, newNumber,  priceX);
					}
					break;
				case "Eel":
					switch(plateOptions.getSelectedItem().toString()) {
					case "RED":
						makeRedPlateRequest(eelSashimi, newNumber);
						break;
					case "BLUE":
						makeBluePlateRequest(eelSashimi, newNumber);
						break;
					case "GREEN":
						makeGreenPlateRequest(eelSashimi, newNumber);
					case "GOLD":
						makeGoldPlateRequest(eelSashimi, newNumber,  priceX);
					}
					break;
				
					
				case "Shrimp":
					switch(plateOptions.getSelectedItem().toString()) {
					case "RED":
						makeRedPlateRequest(shrimpSashimi, newNumber);
						break;
					case "BLUE":
						makeBluePlateRequest(shrimpSashimi, newNumber);
						break;
					case "GREEN":
						makeGreenPlateRequest(shrimpSashimi, newNumber);
					case "GOLD":
						makeGoldPlateRequest(shrimpSashimi, newNumber,  priceX);
					}
					break;
				case "Tuna":
					switch(plateOptions.getSelectedItem().toString()) {
					case "RED":
						makeRedPlateRequest(tunaSashimi, newNumber);
						break;
					case "BLUE":
						makeBluePlateRequest(tunaSashimi, newNumber);
						break;
					case "GREEN":
						makeGreenPlateRequest(tunaSashimi, newNumber);
					case "GOLD":
						makeGoldPlateRequest(tunaSashimi, newNumber,  priceX);
					}
				}
				newFrame.setVisible(false);
			}
		});

		newFrame.setVisible(true);

	}

	public void nigiriMaker() {
		//		String type;
		JFrame newFrame = new JFrame("Make Nigiri");
		newFrame.setBackground(Color.CYAN);
		newFrame.setSize(700, 300);
		newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel newPanel = new JPanel();
		newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));
		newFrame.add(newPanel);

		JLabel label = new JLabel("Select your type of nigiri, color of plate, and position. If the plate is gold, select a price");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(label);

		JLabel typeLabel = new JLabel("Select a type of nigiri");
		typeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(typeLabel);

		String[] typeOptions = {  "Crab" , "Eel", "Shrimp", "Tuna" };
		final JComboBox<String> typeOptionPane = new JComboBox<String>(typeOptions);
		typeOptionPane.setMaximumSize(typeOptionPane.getPreferredSize());
		typeOptionPane.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(typeOptionPane);

		Hashtable labelTable = new Hashtable();
		labelTable.put(Integer.valueOf(50), new JLabel("$5.0"));
		labelTable.put(Integer.valueOf(75), new JLabel("$7.5"));
		labelTable.put(Integer.valueOf(100), new JLabel("$10.0"));

		JLabel priceLabel = new JLabel("Price");
		priceLabel.setVisible(false);
		priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(priceLabel);

		JSlider price = new JSlider(50,100);
		price.setLabelTable(labelTable);
		price.setPaintLabels(true);
		//		price.addChangeListener(this);
		price.setName("price");
		price.setVisible(false);
		price.setAlignmentX(Component.CENTER_ALIGNMENT);
		price.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent event) {
				int current = ((JSlider)event.getSource()).getValue();
				double currentX = current / 10.0;
				priceLabel.setText("The price is $" + currentX);
			}

		});
		newPanel.add(price);
		price.setMajorTickSpacing(10);
		price.setMinorTickSpacing(1);
		price.setPaintTicks(true);

		JLabel plateLabel = new JLabel("Select a type of plate");
		plateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(plateLabel);

		String[] plates = { "Red", "Blue", "Green", "Gold" };
		final JComboBox<String> plateOptions = new JComboBox<String> (plates);
		plateOptions.setMaximumSize(plateOptions.getPreferredSize());
		plateOptions.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(plateOptions);
		plateOptions.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (plateOptions.getSelectedItem().toString().equals("Gold")) {
					price.setVisible(true);
					priceLabel.setVisible(true);
				} else {
					price.setVisible(false);
					priceLabel.setVisible(false);
				}
			}

		});

		JLabel positionLabel = new JLabel("Select a position");
		positionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(positionLabel);

		final JComboBox<String> numbers = new JComboBox<String> (positionArray);
		numbers.setMaximumSize(numbers.getPreferredSize());
		numbers.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(numbers);

		JButton make = new JButton("Make a Nigiri!");
		make.setActionCommand("make");
		make.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(make);
		make.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object numberSelected = numbers.getSelectedItem();
				int newNumber = Integer.parseInt(numberSelected.toString());
				//				Object typeSelected = typeOptionPane.getSelectedItem();
				//				Object plateSelected = plateOptions.getSelectedItem();
				int priceFinal = price.getValue();
				double priceX = priceFinal / 10.0;

				switch(typeOptionPane.getSelectedItem().toString()) {
				case "Crab": 
					switch(plateOptions.getSelectedItem().toString()) {
					case "Red":
						makeRedPlateRequest(crabNigiri, newNumber);
						break;
					case "Blue":
						makeBluePlateRequest(crabNigiri, newNumber);
						break;
					case "Green":
						makeGreenPlateRequest(crabNigiri, newNumber);
					case "Gold":
						makeGoldPlateRequest(crabNigiri, newNumber,  priceX);
					}
					break;
				case "Eel":
					switch(plateOptions.getSelectedItem().toString()) {
					case "RED":
						makeRedPlateRequest(eelNigiri, newNumber);
						break;
					case "BLUE":
						makeBluePlateRequest(eelNigiri, newNumber);
						break;
					case "GREEN":
						makeGreenPlateRequest(eelNigiri, newNumber);
					case "GOLD":
						makeGoldPlateRequest(eelNigiri, newNumber,  priceX);
					}
					break;
				case "Shrimp":
					switch(plateOptions.getSelectedItem().toString()) {
					case "RED":
						makeRedPlateRequest(shrimpNigiri, newNumber);
						break;
					case "BLUE":
						makeBluePlateRequest(shrimpNigiri, newNumber);
						break;
					case "GREEN":
						makeGreenPlateRequest(shrimpNigiri, newNumber);
					case "GOLD":
						makeGoldPlateRequest(shrimpNigiri, newNumber,  priceX);
					}
					break;
				case "Tuna":
					switch(plateOptions.getSelectedItem().toString()) {
					case "RED":
						makeRedPlateRequest(tunaNigiri, newNumber);
						break;
					case "BLUE":
						makeBluePlateRequest(tunaNigiri, newNumber);
						break;
					case "GREEN":
						makeGreenPlateRequest(tunaNigiri, newNumber);
					case "GOLD":
						makeGoldPlateRequest(tunaNigiri, newNumber,  priceX);
					}
				}
				newFrame.setVisible(false);
			}
		});

		newFrame.setVisible(true);
	}

	public void rollMaker() {
		JFrame newFrame = new JFrame("Make a Roll");
		newFrame.setBackground(Color.CYAN);
		newFrame.setSize(700, 700);
		newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel newPanel = new JPanel();
		newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));
		newFrame.add(newPanel);

		JLabel label = new JLabel("Write the name of the roll in the whitespace below!");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(label);

		JTextField name = new JTextField("Default", 2);
		name.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(name);

	

		Hashtable labelTable = new Hashtable();
		labelTable.put(Integer.valueOf(0), new JLabel("0.0 Ounces"));
		labelTable.put(Integer.valueOf(75), new JLabel());
		labelTable.put(Integer.valueOf(150), new JLabel("1.5 Ounces"));

		JLabel riceLabel = new JLabel("Rice");
		riceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(riceLabel);

		JSlider riceSlider = new JSlider(0, 150);
		riceSlider.setLabelTable(labelTable);
		riceSlider.setPaintLabels(true);
		riceSlider.setName("Rice Slider");
		riceSlider.setValue(0);
		riceSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent event) {
				int current = ((JSlider)event.getSource()).getValue();
				double currentX = current / 100.0;
				riceLabel.setText("Rice: " + currentX + " ounces");
			}

		});
		newPanel.add(riceSlider);

		JLabel seaweedLabel = new JLabel("Seaweed");
		seaweedLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(seaweedLabel);

		JSlider seaweedSlider = new JSlider(0, 150);
		seaweedSlider.setLabelTable(labelTable);
		seaweedSlider.setPaintLabels(true);
		seaweedSlider.setName("Seaweed Slider");
		seaweedSlider.setValue(0);
		seaweedSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent event) {
				int current = ((JSlider)event.getSource()).getValue();
				double currentX = current / 100.0;
				seaweedLabel.setText("Seaweed: " + currentX + " ounces");
			}

		});
		newPanel.add(seaweedSlider);

		JLabel avocadoLabel = new JLabel("Avocado");
		avocadoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(avocadoLabel);

		JSlider avocadoSlider = new JSlider(0, 150);
		avocadoSlider.setLabelTable(labelTable);
		avocadoSlider.setPaintLabels(true);
		avocadoSlider.setName("Avocado Slider");
		avocadoSlider.setValue(0);
		avocadoSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent event) {
				int current = ((JSlider)event.getSource()).getValue();
				double currentX = current / 100.0;
				avocadoLabel.setText("Avocado: " + currentX + " ounces");
			}

		});
		newPanel.add(avocadoSlider);

		JLabel crabLabel = new JLabel("Crab");
		crabLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(crabLabel);

		JSlider crabSlider = new JSlider(0, 150);
		crabSlider.setLabelTable(labelTable);
		crabSlider.setPaintLabels(true);
		crabSlider.setName("Crab Slider");
		crabSlider.setValue(0);
		crabSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent event) {
				int current = ((JSlider)event.getSource()).getValue();
				double currentX = current / 100.0;
				crabLabel.setText("Crab: " + currentX + " ounces");
			}

		});
		newPanel.add(crabSlider);

		JLabel eelLabel = new JLabel("Eel");
		eelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(eelLabel);

		JSlider eelSlider = new JSlider(0, 150);
		eelSlider.setLabelTable(labelTable);
		eelSlider.setPaintLabels(true);
		eelSlider.setName("Eel Slider");
		eelSlider.setValue(0);
		eelSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent event) {
				int current = ((JSlider)event.getSource()).getValue();
				double currentX = current / 100.0;
				eelLabel.setText("Eel: " + currentX + " ounces");
			}

		});
		newPanel.add(eelSlider);

		JLabel salmonLabel = new JLabel("Salmon");
		salmonLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(salmonLabel);

		JSlider salmonSlider = new JSlider(0, 150);
		salmonSlider.setLabelTable(labelTable);
		salmonSlider.setPaintLabels(true);
		salmonSlider.setName("Salmon Slider");
		salmonSlider.setValue(0);
		salmonSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent event) {
				int current = ((JSlider)event.getSource()).getValue();
				double currentX = current / 100.0;
				salmonLabel.setText("Salmon: " + currentX + " ounces");
			}

		});
		newPanel.add(salmonSlider);

		JLabel shrimpLabel = new JLabel("Shrimp");
		shrimpLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(shrimpLabel);

		JSlider shrimpSlider = new JSlider(0, 150);
		shrimpSlider.setLabelTable(labelTable);
		shrimpSlider.setPaintLabels(true);
		shrimpSlider.setName("Shrimp Slider");
		shrimpSlider.setValue(0);
		shrimpSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent event) {
				int current = ((JSlider)event.getSource()).getValue();
				double currentX = current / 100.0;
				shrimpLabel.setText("Shrimp: " + currentX + " ounces");
			}

		});
		newPanel.add(shrimpSlider);

		JLabel tunaLabel = new JLabel("Tuna");
		tunaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(tunaLabel);

		JSlider tunaSlider = new JSlider(0, 150);
		tunaSlider.setLabelTable(labelTable);
		tunaSlider.setPaintLabels(true);
		tunaSlider.setValue(0);
		tunaSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent event) {
				int current = ((JSlider)event.getSource()).getValue();
				double currentX = current / 100.0;
				tunaLabel.setText("Tuna: " + currentX + " ounces");
			}

		});
		tunaSlider.setName("Tuna Slider");

		newPanel.add(tunaSlider);

		Hashtable priceTable = new Hashtable();
		priceTable.put(Integer.valueOf(55), new JLabel("$5.5"));
		priceTable.put(Integer.valueOf(70), new JLabel("$7.0"));
		priceTable.put(Integer.valueOf(100), new JLabel("$10.0"));

		JLabel priceLabel = new JLabel("Price");
		priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(priceLabel);

		JSlider price = new JSlider(50,100);
		price.setLabelTable(priceTable);
		price.setPaintLabels(true);
		//		price.addChangeListener(this);
		price.setName("price");
		price.setVisible(true);
		price.setAlignmentX(Component.CENTER_ALIGNMENT);
		price.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent event) {
				int current = ((JSlider)event.getSource()).getValue();
				double pricecost = current / 10.0;
				priceLabel.setText("The price is $" + pricecost);
			}

		});
		newPanel.add(price);
		price.setMajorTickSpacing(10);
		price.setMinorTickSpacing(1);
		price.setPaintTicks(true);

		final JComboBox<String> numbers = new JComboBox<String> (positionArray);
		numbers.setMaximumSize(numbers.getPreferredSize());
		numbers.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(numbers);

		JButton make = new JButton("Make a roll");
		make.setAlignmentX(Component.CENTER_ALIGNMENT);
		newPanel.add(make);
		make.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String rollName = name.getText();

				Object numberSelected = numbers.getSelectedItem();
				int newNumber = Integer.parseInt(numberSelected.toString());
				

				int avocadoFinal = avocadoSlider.getValue();
				double avocadoNum = avocadoFinal / 100.0;

				int crabFinal = crabSlider.getValue();
				double crabNum = crabFinal / 100.0;

				int eelFinal = eelSlider.getValue();
				double eelNum = eelFinal / 100.0;

				int priceFinal = price.getValue();
				double priceTotal = priceFinal / 10.0;

				int riceFinal = riceSlider.getValue();
				double riceNum = riceFinal / 100.0;

				int seaweedFinal = seaweedSlider.getValue();
				double seaweedNum = seaweedFinal / 100.0;


				int shrimpFinal = shrimpSlider.getValue();
				double shrimpNum = shrimpFinal / 100.0;

				int tunaFinal = tunaSlider.getValue();
				double tunaNum = tunaFinal / 100.0;

				int ingredIndex =0;

				int[] binary = new int[8];
				List<IngredientPortion> ingreds = new ArrayList<IngredientPortion>();
				
				if (avocadoNum > 0) {
					ingredIndex++;
					AvocadoPortion avocado = new AvocadoPortion(avocadoNum);
					binary[2] = 1;
					ingreds.add(avocado);
				}
				if (crabNum > 0) {
					ingredIndex++;
					CrabPortion crab = new CrabPortion(crabNum);
					binary[3] = 1;
					ingreds.add(crab);
				}
				if (eelNum > 0) {
					ingredIndex++;
					EelPortion eel = new EelPortion(eelNum);
					binary[4] = 1;	
					ingreds.add(eel);
				}


				if (riceNum > 0) {
					ingredIndex++;
					RicePortion rice = new RicePortion(riceNum);
					binary[0] = 1;
					ingreds.add(rice);
				}
				if (seaweedNum > 0) {
					ingredIndex++;
					SeaweedPortion seaweed = new SeaweedPortion(seaweedNum);
					binary[1] = 1;
					ingreds.add(seaweed);

				
				if (shrimpNum > 0) {
					ingredIndex++;
					ShrimpPortion shrimp = new ShrimpPortion(shrimpNum);
					binary[6] = 1;
					ingreds.add(shrimp);
				}
				if (tunaNum > 0) {
					ingredIndex++;
					TunaPortion tuna = new TunaPortion(tunaNum);
					binary[7] = 1;
					ingreds.add(tuna);
				}


				if (binary[0] == 1) {

				}

				IngredientPortion[] ingredients = new IngredientPortion[ingreds.size()];
				ingreds.toArray(ingredients);
				Roll playerRoll = new Roll(rollName, ingredients);
				makeGoldPlateRequest(playerRoll, newNumber, priceTotal);

				newFrame.setVisible(false);

			}
				
			}});
			
			newFrame.setVisible(true);
	

	}

	public void createRoll() {
		List<IngredientPortion> ing = new ArrayList<IngredientPortion>();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "make_sashimi":
			sashimiMaker();
			break;
		case "make_nigiri":
			nigiriMaker();
			break;
		case "make_roll":
			rollMaker();
		}
	}
}




