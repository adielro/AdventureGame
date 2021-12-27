
public class Beast extends Mobs {
	int doubleDmgChance;

	public Beast() {
		this.trait = "Beast";
		this.traitBonus = "Beast has a chance to deal double damage, oh and also laid your sister.";
	}

	boolean traitBonus(int dmgDealt) {
		double doubleDmg = Math.random() * 100;
		if (doubleDmg < this.doubleDmgChance) {
			System.out.println("X2 dmg");
			return true;
		}
		return false;
	}

}

class Wolf extends Beast {

	public Wolf(Player p) {
		this.doubleDmgChance = 5;
		this.hp = (int) (35 * Math.random()) * p.getLvl();
		this.dmg = 4 + (p.getLvl() - 1) * 2;
		this.exp = 3 * p.getLvl();
		this.goldDrop = 6 * ((int) (Math.random() + 1) * p.getLvl());
		this.alive = true;
	}
}

class Goblin extends Beast {

	public Goblin(Player p) {
		this.doubleDmgChance = 10;
		this.hp = (int) (50 * Math.random()) * p.getLvl();
		this.dmg = 5 + (p.getLvl() - 1) * 3;
		this.exp = 6 * p.getLvl();
		this.goldDrop = 7 * ((int) (Math.random() + 1) * p.getLvl());
		this.alive = true;
	}
}

class Centaurs extends Beast {
	public Centaurs(Player p) {
		this.doubleDmgChance = 15;
		this.hp = (int) (75 * Math.random()) * p.getLvl();
		this.dmg = 5 + (p.getLvl() - 1) * 4;
		this.exp = 7 * p.getLvl();
		this.goldDrop = 8 * ((int) (Math.random() + 1) * p.getLvl());
		this.alive = true;
	}
}

class Minotaur extends Beast {
	public Minotaur(Player p) {
		this.doubleDmgChance = 20;
		this.hp = (int) (95 * Math.random()) * p.getLvl();
		this.dmg = 15 + (p.getLvl() - 1) * 4;
		this.exp = 8 * p.getLvl();
		this.goldDrop = 10 * ((int) (Math.random() + 1) * p.getLvl());
		this.alive = true;
	}
}

class Bigfoot extends Beast {
	public Bigfoot(Player p) {
		this.doubleDmgChance = 20;
		this.hp = (int) (120 * Math.random()) * p.getLvl();
		this.dmg = 15 + (p.getLvl() - 1) * 4;
		this.exp = (int) 9 * p.getLvl();
		this.goldDrop = 13 * ((int) (Math.random() + 1) * p.getLvl());
		this.alive = true;
	}
}
