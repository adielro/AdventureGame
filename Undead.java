
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
		this.traitBonus = "Undead get a change to heal certain amount of \ntheir health after they attack";
		lastHitTraitOccured = false;
	}

}

class Skeleton extends Undead {

	public Skeleton(Player p) {
		this.lifeStealChance = 15;
		this.lifeStealRate = 15;
		this.hp = 100 + (p.getLvl() - 1) * 10;
		this.dmg = 5 + (p.getLvl() - 1) * 2;
		this.exp = 5 * p.getLvl();
		this.goldDrop = 8 + (int) (Math.random() * 2 + 1) * p.getLvl();
		this.alive = true;
	}

}

class Wraith extends Undead {

	public Wraith(Player p) {
		this.lifeStealChance = 20;
		this.lifeStealRate = 20;
		this.hp = 115 + (p.getLvl() - 1) * 15;
		this.dmg = 6 + (p.getLvl() - 1) * 3;
		this.exp = 6 * p.getLvl();
		this.goldDrop = 9 + (int) (Math.random() * 3 + 1) * p.getLvl();
		this.alive = true;
		this.trait = "Undead";
	}
}

class GrimReaper extends Undead {

	public GrimReaper(Player p) {
		this.lifeStealChance = 30;
		this.lifeStealRate = 20;
		this.hp = 125 + (p.getLvl() - 1) * 17;
		this.dmg = 7 + (p.getLvl() - 1) * 4;
		this.exp = 9 * p.getLvl();
		this.goldDrop = 12 + (int) (Math.random() * 4 + 1) * p.getLvl();
		this.alive = true;
		this.trait = "Undead";
	}

}