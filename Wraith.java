
public class Wraith extends Undead {

	public Wraith(Player p) {
		this.hp = 115 + (p.getLvl() - 1) * 20;
		this.dmg = 7 + (p.getLvl() - 1) * 3;
		this.exp = 6 * p.getLvl();
		this.goldDrop = 9 + (int) (Math.random() * 3 + 1) * p.getLvl();
		this.alive = true;
		this.trait = "Undead";
	}
}
