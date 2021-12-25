
public class GrimReaper extends Undead{

	public GrimReaper(Player p) {
		this.hp = 125 + (p.getLvl() - 1) * 23;
		this.dmg = 8 + (p.getLvl() - 1) * 5;
		this.exp = 7 * p.getLvl();
		this.goldDrop = 10 + (int) (Math.random() * 4 + 1) * p.getLvl();
		this.alive = true;
		this.trait = "Undead";
	}
	
}
