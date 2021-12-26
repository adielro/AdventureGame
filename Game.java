import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {
	JFrame window;
	Container con;
	JPanel namePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel nameLabel, hpLabel, hpLabelNumber, expLabel, expLabelNumber;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 160);
	Font startButtonFont = new Font("Times New Roman", Font.PLAIN, 80);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 55);
	JButton startButton, choice1, choice2, choice3, choice4, choice5;
	JTextArea mainTextArea;
	Player p;
	String position;
	Mobs currentMonster;
	boolean clickAssure = false;
	boolean createNewShop = true;
	boolean missingGold = false;
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();

	public static void main(String[] args) {

		new Game();

	}

	public Game() {

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();

		window = new JFrame();
		window.setSize(dim.width / 2, dim.height - dim.height / 3);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		con = window.getContentPane();
		window.setLocation(1000, 360);
		window.setResizable(false);

		namePanel = new JPanel();

		namePanel.setBounds(window.getWidth() / 6, dim.height / 50, window.getWidth() - window.getWidth() / 3,
				window.getHeight() / 3);
		namePanel.setBackground(Color.black);
		nameLabel = new JLabel("Text Adventure");
		nameLabel.setForeground(Color.white);
		nameLabel.setFont(titleFont);

		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(window.getWidth() / 3, window.getHeight() / 2, window.getWidth() / 3,
				window.getHeight() / 3);
		startButtonPanel.setBackground(Color.black);

		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(startButtonFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);

		namePanel.add(nameLabel);
		startButtonPanel.add(startButton);

		con.add(namePanel);
		con.add(startButtonPanel);
		window.setVisible(true);
	}

	public void createGameScreen() {
		namePanel.setVisible(false);
		startButton.setVisible(false);

		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(window.getWidth() / 30, 100, window.getWidth() - window.getWidth() / 50,
				window.getHeight() / 2);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);

		mainTextArea = new JTextArea("This is the main text area");
		mainTextArea.setBounds(window.getWidth() / 100, window.getHeight() / 10,
				window.getWidth() - window.getWidth() / 50, window.getHeight() / 2);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setEditable(false);
		mainTextPanel.add(mainTextArea);

		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(window.getWidth() / 3, window.getHeight() - window.getHeight() / 2,
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
		playerPanel.setBounds(100, 15, window.getWidth() / 2, 100);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1, 1));
		con.add(playerPanel);
		hpLabel = new JLabel("HP: ");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
//		hpLabelNumber = new JLabel();
//		hpLabelNumber.setFont(normalFont);
//		hpLabelNumber.setForeground(Color.white);
//		playerPanel.add(hpLabelNumber);
		expLabel = new JLabel("EXP: ");
		expLabel.setFont(normalFont);
		expLabel.setForeground(Color.white);
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
		if (!missingGold)
			mainTextArea.setText("1. " + getItemDetails(p.shop[0]) + "\n2." + getItemDetails(p.shop[1]) + "\n3. "
					+ getItemDetails(p.shop[2]) + "\n4. Health potion, Health regen: 25% hp, Price: "
					+ p.getPotionPrice() + " Gold" + "\nWhat would you like to do?");
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
			shop[i] = new Hats(p);
		}
		return shop;
	}

	public String getItemDetails(Item i) {
		if (i != null) {
			return i.name + ", HP bonus: " + i.hpBonus + ", DMG bonus: " + i.dmgBonus + ", Price: " + i.price + " Gold";
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
		int randNum = (int) (Math.random() * 4) + 1;
		Mobs monster;
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
		default:
			monster = new Skeleton(p);
			break;
		}
		this.currentMonster = monster;
	}

	public void fightOrFlight() {
		position = "fightOrFlight";
		if (this.currentMonster == null || !this.currentMonster.isAlive())
			generateRandomMob(p);
		mainTextArea.setText("You encountered an enemy!\nDetails: " + currentMonster.getClass().getSimpleName()
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
		choice1.setText("Start over");
		choice2.setText("");
		choice3.setText("");
		clickAssure = false;
	}

	public void missingGoldPrint(Item i) {
		mainTextArea.setText(mainTextArea.getText() + "\nMissing " + (i.price - p.getGold()) + " gold!");
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
							} else
								missingGoldPrint(p.shop[0]);
							missingGold = true;
						}
						shop();
						break;
					case "c2":
						if (p.shop[1] != null) {
							if (p.buyItem(p.shop[1]) == true)
								p.shop[1] = null;
							else
								missingGoldPrint(p.shop[1]);
							missingGold = true;
						}

						shop();
						break;
					case "c3":
						if (p.shop[2] != null)
							if (p.buyItem(p.shop[2]) == true)
								p.shop[2] = null;
							else
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
									+ "\nGold gained: " + currentMonster.goldDrop + "\nTotal gold: " + p.getGold()
									+ "\n\n\nNow what?");
							expLabel.setText("EXP: " + p.getCurrentExp() + " / " + p.getExpNeeded());
							clickAssure = false;
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
								mainTextArea.setText(mainTextArea.getText() + " and stole "
										+ (int) (dmgToPlayer * temp.lifeStealRate / 100) + " hp");
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
				case "c1":
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
