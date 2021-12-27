
public class Player {
	private int lvl, maxHp, hp, dmg, currentExp, expNeeded, gold, potions, levelsToNewShop, upgradePoints, potionPrice,
			potionPriceCoeff;
	private Item[] inventory = new Item[6]; // 0 helmet, 1 chest, 2 Gauntlet, 3 legs, 4 shoes, 5 weapon.
	boolean alive, threeLevels, lvlUp;
	Item[] shop;

	public Player() {
		this.lvl = 1;
		this.maxHp = 150;
		this.hp = this.maxHp;
		this.dmg = 30;
		this.currentExp = 0;
		this.expNeeded = 20;
		this.gold = 0;
		this.potions = 0;
		this.threeLevels = false;
		this.levelsToNewShop = 0;
		this.upgradePoints = 0;
		this.lvlUp = false;
		this.potionPriceCoeff = 2;
		potionPriceUpdate();
	}

	public int getPotionPrice() {
		return potionPrice;
	}

	public void setPotionPrice(int potionPrice) {
		this.potionPrice = potionPrice;
	}

	public int getLvl() {
		return lvl;
	}

	public int getHp() {
		return hp;
	}

	public int getDmg() {
		return dmg;
	}

	public int getCurrentExp() {
		return currentExp;
	}

	public int getExpNeeded() {
		return expNeeded;
	}

	public int getGold() {
		return gold;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setDmg(int dmg) {
		this.dmg = dmg;
	}

	public void setCurrentExp(int currentExp) {
		this.currentExp = currentExp;
	}

	public void setExpNeeded(int expNeeded) {
		this.expNeeded = expNeeded;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getPotions() {
		return potions;
	}

	public void setPotions(int potions) {
		this.potions = potions;
	}

	public Item[] getInventory() {
		return inventory;
	}

	public void setInventory(Item[] inventory) {
		this.inventory = inventory;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int getLevelsToNewShop() {
		return levelsToNewShop;
	}

	public void setLevelsToNewShop(int levelsToNewShop) {
		this.levelsToNewShop = levelsToNewShop;
	}

	public int getUpgradePoints() {
		return upgradePoints;
	}

	public void setUpgradePoints(int upgradePoints) {
		this.upgradePoints = upgradePoints;
	}

	public boolean isThreeLevels() {
		return threeLevels;
	}

	public void setThreeLevels(boolean threeLevels) {
		this.threeLevels = threeLevels;
	}

	public Item[] getShop() {
		return shop;
	}

	public void setShop(Item[] shop) {
		this.shop = shop;
	}

	// Dealing damage to mob (80-125 percent base damage).
	int basicAttack(Mobs m) {
		int max = 125;
		int min = 80;
		int range = max - min + 1;
		double rand = (int) (Math.random() * range) + min;
		int dmgDealt = (int) (this.dmg * rand) / 100;
		m.setHp(m.getHp() - dmgDealt);
		if (!m.isAlive())
			this.monsterKilled(m);
		else {
			System.out.println("-----------------------------------------------------");
			System.out.println(m.getClass().getSimpleName() + " Fight's back using his basic attack!");
			// m.basicAttack(this);
			this.printBattleDetaisl(m);
		}
		return dmgDealt;
	}

	void monsterKilled(Mobs m) {
		double hpRegen = (int) ((this.maxHp - this.hp) * 0.2);
		this.currentExp += m.getExp();
		this.gold += m.getGoldDrop();
		this.hp += hpRegen;
		String mobName = m.getClass().getSimpleName();
		System.out.println("-----------------------------------------------------");
		System.out.println(mobName + " is dead!\n");
		System.out.println("Exp gained: " + m.exp);
		System.out.println("Gold gained: " + m.getGoldDrop());
		System.out.println("Current hp: " + this.getHp());
		if (this.currentExp >= this.getExpNeeded())
			this.levelUp();
	}

	void levelUp() {
		potionPriceUpdate();
		this.lvlUp = true;
		this.levelsToNewShop++;
		this.lvl++;
		this.hp += (int) ((this.maxHp - this.hp) * 0.5);
		this.currentExp -= this.expNeeded;
		this.expNeeded *= 1.25;
		this.upgradePoints += 5;
		System.out.println("*****************************************************");
		System.out.println("                       Level up!");
		this.printPlayerDetails();
		if (this.levelsToNewShop == 3) {
			this.levelsToNewShop = 0;
			threeLevels = true;
		}
		if (this.currentExp >= this.getExpNeeded())
			this.levelUp();

	}

	void printPlayerDetails() {
		System.out.println("-----------------------------------------------------");
		System.out.println("          **********Player stats**********");
		System.out.println("Current level: " + this.lvl);
		System.out.println("Exp requiered for next level: " + this.getExpNeeded());
		System.out.println("Max hp: " + this.maxHp);
		System.out.println("Current hp: " + this.hp);
		System.out.println("Gold: " + this.gold);

	}

	void printBattleDetaisl(Mobs m) {
		if (this.hp <= 0)
			this.hp = 0;
		String mobName = m.getClass().getSimpleName();
		System.out.println("Your hp: " + this.getHp());
		System.out.println(mobName + " hp: " + m.getHp() + "\n");
	}

	public boolean isAlive() {
		return this.hp > 0;
	}

	boolean buyItem(Item i) {
		if (this.gold < i.price) {
			return false;
		}
		this.gold -= i.price;
		if (inventory[i.placeInInventory] != null) {
			System.out.println("Selling your old item.. ew.\nAnyway, you get only 25% of the price, it's sweaty af.");
			this.gold += (int) (inventory[i.placeInInventory].price * 0.25);
			this.removeItem(this.inventory[i.placeInInventory]);

		}
		inventory[i.placeInInventory] = i;
		this.equipItem(i);
		return true;

	}

	boolean buyPotion() {

		if (this.gold >= potionPrice) {
			this.potions++;
			this.gold -= potionPrice;
			return true;
		}
		return false;
	}

	void potionPriceUpdate() {
		potionPrice = this.lvl * potionPriceCoeff;
	}

	void drinkPotion() {
		if (this.potions > 0 && this.hp < this.maxHp) {
			if (this.hp + (this.maxHp * 0.25) <= this.maxHp)
				this.hp += (this.maxHp * 0.25);
			else
				this.hp = this.maxHp;
			this.potions--;
		}
	}

	void equipItem(Item i) {
		this.maxHp += i.hpBonus;
		this.hp += i.hpBonus;
		this.dmg += i.dmgBonus;
	}

	void removeItem(Item i) {
		this.hp -= i.hpBonus;
		this.dmg -= i.dmgBonus;
	}

	void upgradeMaxHp() {
		this.maxHp += 8;
		this.hp += 8;
		this.upgradePoints--;
	}

	void upgradeDmg() {
		this.dmg += 2;
		this.upgradePoints--;
	}

}