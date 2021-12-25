
public class Skeleton extends Undead {

	public Skeleton(Player p) {
		this.hp = 100 + (p.getLvl() - 1) * 15;
		this.dmg = 5 + (p.getLvl() - 1) * 2;
		this.exp = 5 * p.getLvl();
		this.goldDrop = 8 + (int)( Math.random() * 2 + 1)  * p.getLvl();
		this.alive = true;
	}
	
	
}
