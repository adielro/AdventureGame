import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Game {
	JFrame window;
	Container con;
	JPanel namePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel levelLabel, nameLabel, hpLabel, expLabel, expLabelNumber;
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Dimension dim = toolkit.getScreenSize();
	Font titleFont = new Font("Times New Roman", Font.PLAIN, (int) (dim.getHeight() / 13));
	Font startButtonFont = new Font("Times New Roman", Font.PLAIN, (int) (dim.getHeight() / 30));
	Font normalFont = new Font("Times New Roman", Font.PLAIN, (int) (dim.getHeight() / 40));
	JButton startButton, choice1, choice2, choice3, choice4, choice5;
	JTextPane mainTextArea;
	Player p;
	String position;
	Mobs currentMonster;
	boolean clickAssure = false;
	boolean createNewShop = true;
	boolean missingGold = false;
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	JPanelWithBackground startScreen;
	StyledDocument doc;
	javax.swing.text.Style style;

	public static void main(String[] args) {

		new Game();

	}

	public Game() {

		window = new JFrame();
		window.setSize(dim.width / 2, dim.height - dim.height / 3);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		con = window.getContentPane();
		window.setLocation((int) (dim.getWidth() / 4), (int) (dim.getHeight() / 5));
		window.setResizable(false);
		startScreen = null;
		try {
			startScreen = new JPanelWithBackground();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		startScreen.setBounds(0, 0, dim.width / 2, dim.height - dim.height / 3);
//		window.add(startScreen);
		startScreen.transferFocusBackward();

//		namePanel = new JPanel();
//
//		namePanel.setBounds(window.getWidth() / 6, dim.height / 50, window.getWidth() - window.getWidth() / 3,
//				window.getHeight() / 3);
//		namePanel.setBackground(Color.black);
		nameLabel = new JLabel("Text Adventure");
		nameLabel.setForeground(Color.black);
		nameLabel.setFont(titleFont);
		nameLabel.setBounds(window.getWidth() / 6, dim.height / 50, window.getWidth() - window.getWidth() / 3,
				window.getHeight() / 3);
//		startButtonPanel = new JPanel();
//		startButtonPanel.setBounds(window.getWidth() / 3, window.getHeight() - (window.getHeight() / 4),
//				window.getWidth() / 3, window.getHeight() / 3);
//		startButtonPanel.setBackground(Color.black);

		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.orange);
		startButton.setFont(startButtonFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);
		startButton.setBounds(window.getWidth() / 2 - (window.getWidth() / 10),
				window.getHeight() - (window.getHeight() / 4), window.getWidth() / 6, window.getHeight() / 15);
//		namePanel.add(nameLabel);
//		startButtonPanel.add(startButton);

//		con.add(nameLabel);
		startScreen.setLayout(null);
		startScreen.add(nameLabel);
		startScreen.add(startButton);

//		con.add(namePanel);
//		con.add(startButtonPanel);
		con.add(startScreen);
		window.setVisible(true);

	}

	public void createGameScreen() {
//		startScreen.setVisible(false);
//		namePanel.setVisible(false);
//		startButtonPanel.setVisible(false);
		startButton.setVisible(false);

		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(0, window.getHeight() / 10, window.getWidth(), window.getHeight() / 3);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);

		mainTextArea = new JTextPane();
		mainTextArea.setBounds(0, window.getHeight() / 10, window.getWidth(), window.getHeight() / 4);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
//		mainTextArea.setLineWrap(true);
		mainTextArea.setEditable(false);
		doc = mainTextArea.getStyledDocument();

		style = mainTextArea.addStyle("I'm a Style", null);

		mainTextPanel.add(mainTextArea);

		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(window.getWidth() / 3, window.getHeight() - (int) (window.getHeight() / 2.6),
				window.getWidth() / 3, window.getHeight() / 3);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(5, 1));
		con.add(choiceButtonPanel);

		choice1 = new JButton("Fight");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choice1.setForeground(Color.orange);
//		choice1.setBorder(BorderFactory.createEmptyBorder());
		choiceButtonPanel.add(choice1);
		choice2 = new JButton("choice two");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choice2.setForeground(Color.orange);
		choiceButtonPanel.add(choice2);
		choice3 = new JButton("choice three");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choice3.setForeground(Color.orange);
		choiceButtonPanel.add(choice3);
		choice4 = new JButton("choice four");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choice4.setForeground(Color.orange);
		choiceButtonPanel.add(choice4);
		choice5 = new JButton("choice five");
		choice5.setBackground(Color.black);
		choice5.setForeground(Color.white);
		choice5.setFont(normalFont);
		choice5.setFocusPainted(false);
		choice5.addActionListener(choiceHandler);
		choice5.setActionCommand("c5");
		choice5.setForeground(Color.orange);
		choiceButtonPanel.add(choice5);

		playerPanel = new JPanel();
		playerPanel.setBounds(0, window.getHeight() / 100, window.getWidth(), window.getHeight() / 20);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1, 3));
		con.add(playerPanel);
		levelLabel = new JLabel("Level: ");
		levelLabel.setFont(normalFont);
		levelLabel.setForeground(Color.white);
		playerPanel.add(levelLabel);
		hpLabel = new JLabel("HP: ");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.red);
		playerPanel.add(hpLabel);
//		hpLabelNumber = new JLabel();
//		hpLabelNumber.setFont(normalFont);
//		hpLabelNumber.setForeground(Color.white);
//		playerPanel.add(hpLabelNumber);
		expLabel = new JLabel("EXP: ");
		expLabel.setFont(normalFont);
		expLabel.setForeground(Color.yellow);
		playerPanel.add(expLabel);
//		expLabelNumber = new JLabel();
//		expLabelNumber.setFont(normalFont);
//		expLabelNumber.setForeground(Color.white);
//		playerPanel.add(expLabelNumber);
		p = new Player();
		choiceButtonPanel.setVisible(true);
		playerSetup();
	}

	public void playerSetup() {
		levelLabel.setText("Level: " + p.getLvl());
		hpLabel.setText("HP: " + p.getHp() + " / " + p.getMaxHp());
		expLabel.setText("EXP: " + p.getCurrentExp() + " / " + p.getExpNeeded());

		townGate();
	}

	public void townGate() {

		position = "townGate";
		mainTextArea.setText("What would you like to do?");
		choice1.setText("Fight");
		choice2.setText("Shop");
		choice3.setText("Drink potion (" + p.getPotions() + " left)");
		choice4.setText("Player stats");
		choice5.setText("End game");

	}

	public void shop() {
		if (p.threeLevels) {
			this.createNewShop = true;
			p.threeLevels = false;
		}
		position = "shop";
		if (this.createNewShop == true)
			p.shop = generateShop();
		createNewShop = false;
		hpLabel.setText("HP: " + p.getHp() + " / " + p.getMaxHp());
		expLabel.setText("Gold: " + p.getGold());
		if (!missingGold) {
			String item1 = getItemDetails(p.shop[0]);
			String item2 = getItemDetails(p.shop[1]);
			String item3 = getItemDetails(p.shop[2]);
			mainTextArea.setText(
					"1." + item1 + "\n2." + item2 + "\n3." + item3 + "\n4.Health potion, Health regen: 25% hp, Price: "
							+ p.getPotionPrice() + " Gold" + "\nWould you like to buy anything?");
			// ---------------- item 1
			if (p.shop[0] != null) {

				int hpDiff = 0;
				int hpInd = mainTextArea.getText().indexOf("HP:", mainTextArea.getText().indexOf("1.")) + 4;
				String hpDiffStr = "" + 0;

				int dmgDiff = 0;
				int dmgInd = mainTextArea.getText().indexOf("DMG:", mainTextArea.getText().indexOf("1.")) + 7;
				String dmgDiffStr = "" + 0;

				if (p.getInventory()[p.shop[0].placeInInventory] != null) {

					if (p.getInventory()[p.shop[0].placeInInventory].hpBonus != p.shop[0].hpBonus) {
						hpDiff = p.getInventory()[p.shop[0].placeInInventory].hpBonus - p.shop[0].hpBonus;

						if (hpDiff > 0) { // red
							StyleConstants.setForeground(style, Color.red);
							hpDiffStr = "-" + hpDiff;
						} else {
							hpDiff *= -1;
							hpDiffStr = "+" + hpDiff;
							StyleConstants.setForeground(style, Color.green);
						}
					}
					try {

						doc.insertString(hpInd, hpDiffStr, style);
					} catch (BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//--------------------- DMG
					if (p.getInventory()[p.shop[0].placeInInventory].dmgBonus != p.shop[0].dmgBonus) {
						dmgDiff = p.getInventory()[p.shop[0].placeInInventory].dmgBonus - p.shop[0].dmgBonus;

						if (dmgDiff > 0) { // red
							StyleConstants.setForeground(style, Color.red);
							dmgDiffStr = "-" + dmgDiff;
						} else {
							dmgDiff *= -1;
							dmgDiffStr = "+" + dmgDiff;
							StyleConstants.setForeground(style, Color.green);
						}
					}
					try {
						doc.insertString(dmgInd, dmgDiffStr, style);
					} catch (BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// ----------------
				} else {
					hpDiffStr = "" + p.shop[0].hpBonus;
					dmgDiffStr = "" + p.shop[0].dmgBonus;
					try {
						doc.insertString(hpInd, hpDiffStr, style);
						doc.insertString(dmgInd, dmgDiffStr, style);
					} catch (BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}

			// ---------------- item 2
			if (p.shop[1] != null) {
				int hpDiff = 0;
				int hpInd = mainTextArea.getText().indexOf("HP:", mainTextArea.getText().indexOf("2.")) + 4;
				String hpDiffStr = "" + 0;

				int dmgDiff = 0;
				int dmgInd = mainTextArea.getText().indexOf("DMG:", mainTextArea.getText().indexOf("2.")) + 7;
				String dmgDiffStr = "" + 0;

				if (p.getInventory()[p.shop[1].placeInInventory] != null) {

					if (p.getInventory()[p.shop[1].placeInInventory].hpBonus != p.shop[1].hpBonus) {
						hpDiff = p.getInventory()[p.shop[1].placeInInventory].hpBonus - p.shop[1].hpBonus;

						if (hpDiff > 0) { // red
							StyleConstants.setForeground(style, Color.red);
							hpDiffStr = "-" + hpDiff;
						} else {
							hpDiff *= -1;
							hpDiffStr = "+" + hpDiff;
							StyleConstants.setForeground(style, Color.green);
						}
					}
					try {

						doc.insertString(hpInd, hpDiffStr, style);
					} catch (BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//--------------------- DMG
					if (p.getInventory()[p.shop[1].placeInInventory].dmgBonus != p.shop[1].dmgBonus) {
						dmgDiff = p.getInventory()[p.shop[1].placeInInventory].dmgBonus - p.shop[1].dmgBonus;

						if (dmgDiff > 0) { // red
							StyleConstants.setForeground(style, Color.red);
							dmgDiffStr = "-" + dmgDiff;
						} else {
							dmgDiff *= -1;
							dmgDiffStr = "+" + dmgDiff;
							StyleConstants.setForeground(style, Color.green);
						}
					}
					try {

						doc.insertString(dmgInd, dmgDiffStr, style);
					} catch (BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// ----------------
				} else {
					hpDiffStr = "" + p.shop[1].hpBonus;
					dmgDiffStr = "" + p.shop[1].dmgBonus;
					try {
						doc.insertString(hpInd, hpDiffStr, style);
						doc.insertString(dmgInd, dmgDiffStr, style);
					} catch (BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
			// ---------------- item 3
			if (p.shop[2] != null) {
				int hpDiff = 0;
				int hpInd = mainTextArea.getText().indexOf("HP:", mainTextArea.getText().indexOf("3.")) + 4;
				String hpDiffStr = "" + 0;

				int dmgDiff = 0;
				int dmgInd = mainTextArea.getText().indexOf("DMG:", mainTextArea.getText().indexOf("3.")) + 7;
				String dmgDiffStr = "" + 0;

				if (p.getInventory()[p.shop[2].placeInInventory] != null) {

					if (p.getInventory()[p.shop[2].placeInInventory].hpBonus != p.shop[2].hpBonus) {
						hpDiff = p.getInventory()[p.shop[2].placeInInventory].hpBonus - p.shop[2].hpBonus;

						if (hpDiff > 0) { // red
							StyleConstants.setForeground(style, Color.red);
							hpDiffStr = "-" + hpDiff;
						} else {
							hpDiff *= -1;
							hpDiffStr = "+" + hpDiff;
							StyleConstants.setForeground(style, Color.green);
						}
					}
					try {

						doc.insertString(hpInd, hpDiffStr, style);
					} catch (BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// --------------------- DMG
					if (p.getInventory()[p.shop[2].placeInInventory].dmgBonus != p.shop[2].dmgBonus) {
						dmgDiff = p.getInventory()[p.shop[2].placeInInventory].dmgBonus - p.shop[2].dmgBonus;

						if (dmgDiff > 0) { // red
							StyleConstants.setForeground(style, Color.red);
							dmgDiffStr = "-" + dmgDiff;
						} else {
							dmgDiff *= -1;
							dmgDiffStr = "+" + dmgDiff;
							StyleConstants.setForeground(style, Color.green);
						}
					}
					try {

						doc.insertString(dmgInd, dmgDiffStr, style);
					} catch (BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// ----------------
				} else {
					hpDiffStr = "" + p.shop[2].hpBonus;
					dmgDiffStr = "" + p.shop[2].dmgBonus;
					try {
						doc.insertString(hpInd, hpDiffStr, style);
						doc.insertString(dmgInd, dmgDiffStr, style);
					} catch (BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}
		if (p.shop[0] != null)
			choice1.setText("Buy " + p.shop[0].name);
		else
			choice1.setText("Bought");
		if (p.shop[1] != null)
			choice2.setText("Buy " + p.shop[1].name);
		else
			choice2.setText("Bought");
		if (p.shop[2] != null)
			choice3.setText("Buy " + p.shop[2].name);
		else
			choice3.setText("Bought");

		choice4.setText("Buy health potion (" + p.getPotions() + ")");
		choice5.setText("Go back town");
		missingGold = false;
	}

	public Item[] generateShop() {

		Item[] shop = new Item[3];
		for (int i = 0; i < shop.length; i++) {
			int itemType = (int) (Math.random() * 6) + 1;
			switch (itemType) {
			case 1:
				shop[i] = new Hats(p);
				break;
			case 2:
				shop[i] = new Chest(p);
				break;
			case 3:
				shop[i] = new Gloves(p);
				break;
			case 4:
				shop[i] = new Pants(p);
				break;
			case 5:
				shop[i] = new Shoes(p);
				break;
			case 6:
				shop[i] = new Weapon(p);
				break;
			}
		}
		return shop;
	}

	public String getItemDetails(Item i) {
		if (i != null) {
			return i.name + ", HP: " + ", DMG: " + ", Price: " + i.price + " Gold";
		} else
			return "Bought";

	}

	public void showStats() {
		position = "stats";
		mainTextArea.setText("Level: " + p.getLvl() + "\nExp requiered for next level: " + p.getExpNeeded() + "\nHP: "
				+ p.getHp() + " / " + p.getMaxHp() + "\nDMG: " + p.getDmg() + "\nGold: " + p.getGold() + "\nYou have "
				+ p.getUpgradePoints() + " upgrade points");
		choice1.setText("Level up max hp");
		choice2.setText("Level up damage");
		choice3.setText("Go back");
		choice4.setText("");
		choice5.setText("");

	}

	public void generateRandomMob(Player p) {
		int randNum = (int) (Math.random() * 10) + 1;
		Mobs monster = null;
		switch (randNum) {
		case 1:
			monster = new Skeleton(p);
			break;
		case 2:
			monster = new Wraith(p);
			break;
		case 3:
			monster = new GrimReaper(p);
			break;
		case 4:
			monster = new Wolf(p);
			break;
		case 5:
			monster = new Vampire(p);
			break;
		case 6:
			monster = new Zombie(p);
			break;
		case 7:
			monster = new Bigfoot(p);
			break;
		case 8:
			monster = new Minotaur(p);
			break;
		case 9:
			monster = new Centaurs(p);
			break;
		case 10:
			monster = new Goblin(p);
			break;

		}
		this.currentMonster = monster;
	}

	public void fightOrFlight() {
		position = "fightOrFlight";
		if (this.currentMonster == null || !this.currentMonster.isAlive())
			generateRandomMob(p);
		mainTextArea.setText("You encountered an enemy!\nName: " + currentMonster.getClass().getSimpleName()
				+ "\nTrait: " + currentMonster.trait + "\nHP: " + currentMonster.getHp() + "\nTrait bonus: "
				+ currentMonster.traitBonus + "\nYour move?");
		choice1.setText("Bring it.");
		choice2.setText("Bah bye");
		choice3.setText("");
		choice4.setText("");
		choice5.setText("");
	}

	public void fightScene() {
		position = "fight";
		choice1.setText("Use basic attack");
		choice2.setText("Use condom of Ozz");
		choice3.setText("Drink potion (" + p.getPotions() + " left)");
		choice4.setText("Run");
	}

	public void wonFight() {
		levelLabel.setText("Level: " + p.getLvl());
		position = "wonFight";
		choice1.setText("Keep fighting!");
		choice2.setText("Go back town");
		choice3.setText("");
		choice4.setText("");
		choice5.setText("");
		clickAssure = false;
	}

	public void lose() {
		position = "dead";
		mainTextArea.setText(mainTextArea.getText() + "\nYou are dead!");
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice5.setText("Start over");
		clickAssure = false;
	}

	public void missingGoldPrint(Item i) {
		String search = mainTextArea.getText();
		int ind = search.indexOf("Missing");
		if (ind == -1) {
			StyleConstants.setForeground(style, Color.white);
			mainTextArea.setText(mainTextArea.getText() + "\nMissing " + (i.price - p.getGold()) + " gold!");
		}
	}

	public class TitleScreenHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			createGameScreen();
		}

	}

	public class ChoiceHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			String yourChoice = event.getActionCommand();
			if (position.equals("townGate")) {
				clickAssure = false;
				switch (yourChoice) {

				case "c1":
					fightOrFlight();
					break;
				case "c2":
					shop();
					break;
				case "c3":
					if (p.getPotions() > 0)
						p.drinkPotion();
					hpLabel.setText("HP: " + p.getHp() + " / " + p.getMaxHp());
					choice3.setText("Drink potion (" + p.getPotions() + " left)");
					break;
				case "c4":
					showStats();
					break;
				case "c5":

					break;
				}

			}

			if (position.equals("shop")) {

				if (clickAssure) {
					switch (yourChoice) {
					case "c1":
						if (p.shop[0] != null) {
							if (p.buyItem(p.shop[0]) == true) {
								p.shop[0] = null;
								shop();
							} else {
								missingGoldPrint(p.shop[0]);
							}
							missingGold = true;
						}
						shop();
						break;
					case "c2":
						if (p.shop[1] != null) {
							if (p.buyItem(p.shop[1]) == true) {
								p.shop[1] = null;
								shop();
							} else
								missingGoldPrint(p.shop[1]);
							missingGold = true;
						}

						shop();
						break;
					case "c3":
						if (p.shop[2] != null)
							if (p.buyItem(p.shop[2]) == true) {
								p.shop[2] = null;
								shop();
							} else
								missingGoldPrint(p.shop[2]);
						missingGold = true;
						shop();
						break;
					case "c4":
						p.buyPotion();
						shop();
						break;
					case "c5":
						playerSetup();

					}
				}

			}

			if (position.equals("wonFight") && clickAssure) {
				switch (yourChoice) {
				case "c1":
					clickAssure = false;
					fightOrFlight();
					break;
				case "c2":
					townGate();
					break;
				}
			}
			if (position.equals("fightOrFlight") && clickAssure) {
				switch (yourChoice) {
				case "c1":
					mainTextArea.setText(currentMonster.getClass().getSimpleName() + " HP: " + currentMonster.getHp()
							+ "\nYour turn!");
					clickAssure = false;
					fightScene();
					break;
				case "c2":
					playerSetup();
					break;
				}
			}

			if (clickAssure) {

				if (position.equals("stats")) {
					switch (yourChoice) {
					case "c1":
						if (p.getUpgradePoints() > 0) {
							p.upgradeMaxHp();
							hpLabel.setText("HP: " + p.getHp() + " / " + p.getMaxHp());
							showStats();
						} else
							mainTextArea.setText("Level: " + p.getLvl() + "\nExp requiered for next level: "
									+ p.getExpNeeded() + "\nHP: " + p.getHp() + " / " + p.getMaxHp() + "\nDMG: "
									+ p.getDmg() + "\nGold: " + p.getGold() + "\nYou have " + p.getUpgradePoints()
									+ " upgrade points\nNot enough points!");
						break;
					case "c2":
						if (p.getUpgradePoints() > 0) {
							p.upgradeDmg();
							showStats();
						} else
							mainTextArea.setText("Level: " + p.getLvl() + "\nExp requiered for next level: "
									+ p.getExpNeeded() + "\nHP: " + p.getHp() + " / " + p.getMaxHp() + "\nDMG: "
									+ p.getDmg() + "\nGold: " + p.getGold() + "\nYou have " + p.getUpgradePoints()
									+ " upgrade points\nNot enough points!");
						break;
					case "c3":
						townGate();
						break;

					}
				}

				if (position.equals("fight")) {
					String mobName = currentMonster.getClass().getSimpleName();
					switch (yourChoice) {
					case "c1":
						int dmgToMob = p.basicAttack(currentMonster);
						if (!currentMonster.isAlive()) {
							hpLabel.setText("HP: " + p.getHp() + " / " + p.getMaxHp());
							mainTextArea.setText(mobName + " is dead!\nExp gained: " + currentMonster.exp
									+ "\nGold gained: " + currentMonster.goldDrop + "\nTotal gold: " + p.getGold());
							if (p.lvlUp)
								mainTextArea.setText(mainTextArea.getText() + "\nLevel up!\n" + p.getUpgradePoints()
										+ " upgrade points are available");
							mainTextArea.setText(mainTextArea.getText() + "\n\nNow what?");
							expLabel.setText("EXP: " + p.getCurrentExp() + " / " + p.getExpNeeded());
							clickAssure = false;
							p.lvlUp = false;
							wonFight();
							break;
						}

						mainTextArea.setText(mobName + " HP: " + currentMonster.getHp()
								+ "\nYou swinged your sword at the " + mobName + " dealing " + dmgToMob + " damage\n");
						int dmgToPlayer = currentMonster.basicAttack(p);
						mainTextArea.setText(mainTextArea.getText() + mobName + " slashed you in return dealing "
								+ dmgToPlayer + " damage");
						if (currentMonster.lastHitTraitOccured) {
							if (currentMonster instanceof Undead) {
								Undead temp = (Undead) currentMonster;
								mainTextArea.setText(mobName + " HP: " + currentMonster.getHp()
										+ "\nYou swinged your sword at the " + mobName + " dealing " + dmgToMob
										+ " damage\n" + mobName + " slashed you in return dealing " + dmgToPlayer
										+ " damage" + " and stole " + (int) (dmgToPlayer * temp.lifeStealRate / 100)
										+ " hp");
							} else if (currentMonster instanceof Beast) {
								mainTextArea.setText(
										mobName + " HP: " + currentMonster.getHp() + "\nYou swinged your sword at the "
												+ mobName + " dealing " + dmgToMob + " damage\n" + mobName
												+ " slashed you in return dealing " + dmgToPlayer * 2 + " damage");
							}
						}
						if (p.getHp() <= 0) {
							p.setHp(0);
							lose();
						} else
							mainTextArea.setText(mainTextArea.getText() + "\nNow what?");
						hpLabel.setText("HP: " + p.getHp() + " / " + p.getMaxHp());
						break;
					case "c2":
						mainTextArea.setText(
								mobName + " HP: " + currentMonster.getHp() + "\nThe " + mobName + " is disgust.\n");
						dmgToPlayer = currentMonster.basicAttack(p);
						mainTextArea.setText(mainTextArea.getText() + mobName + " slashed you in return dealing "
								+ dmgToPlayer + " damage!\nNow what?");
						hpLabel.setText("HP: " + p.getHp() + " / " + p.getMaxHp());
						fightScene();
						break;

					case "c3":
						if (p.getPotions() > 0)
							p.drinkPotion();
						hpLabel.setText("HP: " + p.getHp() + " / " + p.getMaxHp());
						choice3.setText("Drink potion (" + p.getPotions() + " left)");
						break;

					case "c4":
						townGate();
						break;
					}
				}
			}

			if (position == "dead" && clickAssure) {
				switch (yourChoice) {
				case "c5":
					p = new Player();
					createNewShop = true;
					playerSetup();
					break;

				}
			}

			clickAssure = true;

		}

	}

}

class JPanelWithBackground extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -891509991838385340L;
	private Image backgroundImage;

	// Some code to initialize the background image.
	// Here, we use the constructor to load the image. This
	// can vary depending on the use case of the panel.
	public JPanelWithBackground() throws IOException {
		backgroundImage = ImageIO
				.read(new File("C:\\Users\\Adiel\\eclipse-workspace\\TextAdventure\\src\\BackgroundImage3.jpg"));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Draw the background image.
		g.drawImage(backgroundImage, 0, 0, this);
	}
}