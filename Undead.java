
public class Undead extends Mobs {
	int lifeStealChance;
	int lifeStealRate;

	boolean traitBonus(int dmgDealt) {
		double lifeSteal = Math.random() * 100;
		if (lifeSteal < this.lifeStealChance) {
			System.out.println(dmgDealt);
			double heal = (double) dmgDealt * ((double) lifeStealRate / 100);
			this.hp += (int) heal;
			System.out.println(heal);
			return true;
		}
		return false;
	}

	public Undead() {
		this.trait = "Undead";
		this.traitBonus = "Undead has a chance to heal certain amount of \ntheir health after they attack";
		lastHitTraitOccured = false;
	}

}

class Skeleton extends Undead {

	public Skeleton(Player p) {
		this.lifeStealChance = 10;
		this.lifeStealRate = 15;
		this.hp = (int) (35 * Math.random()) * p.getLvl();
		this.dmg = 4 + (p.getLvl() - 1) * 2;
		this.exp = 3 * p.getLvl();
		this.goldDrop = 6 * ((int) (Math.random() + 1) * p.getLvl());
		this.alive = true;
	}

}

class Wraith extends Undead {

	public Wraith(Player p) {
		this.lifeStealChance = 20;
		this.lifeStealRate = 20;
		this.hp = (int) (50 * Math.random()) * p.getLvl();
		this.dmg = 5 + (p.getLvl() - 1) * 3;
		this.exp = 6 * p.getLvl();
		this.goldDrop = 7 * ((int) (Math.random() + 1) * p.getLvl());
		this.alive = true;
		this.trait = "Undead";
	}
}

class GrimReaper extends Undead {
	
	public GrimReaper(Player p) {
		this.lifeStealChance = 30;
		this.lifeStealRate = 20;
		this.hp = (int) (75 * Math.random()) * p.getLvl();
		this.dmg = 5 + (p.getLvl() - 1) * 4;
		this.exp = 7 * p.getLvl();
		this.goldDrop = 8 * ((int) (Math.random() + 1) * p.getLvl());
		this.alive = true;
		this.trait = "Undead";
	}
}

class Vampire extends Undead {
	public Vampire(Player p) {
		this.lifeStealChance = 60;
		this.lifeStealRate = 30;
		this.hp = (int) (95 * Math.random()) * p.getLvl();
		this.dmg = 15 + (p.getLvl() - 1) * 4;
		this.exp = 8 * p.getLvl();
		this.goldDrop = 10 * ((int) (Math.random() + 1) * p.getLvl());
		this.alive = true;
		this.trait = "Undead";
	}
}

class Zombie extends Undead {
	public Zombie(Player p) {
		this.lifeStealChance = 15;
		this.lifeStealRate = 15;
		this.hp = (int) (55 * Math.random()) * p.getLvl();
		this.dmg = 5 + (p.getLvl() - 1) * 3;
		this.exp = 6 * p.getLvl();
		this.goldDrop = 7 * ((int) (Math.random() + 1) * p.getLvl());
		this.alive = true;
		this.trait = "Undead";
	}
}

