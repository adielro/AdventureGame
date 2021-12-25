
public class Wolf extends Beast {

	public Wolf(Player p) {
		this.hp = 85 + (p.getLvl() - 1) * 15;
		this.dmg = 4 + (p.getLvl() - 1) * 2;
		this.exp = 4 * p.getLvl();
		this.goldDrop = 6 + (int) (Math.random() * 2 + 1) * p.getLvl();
		this.alive = true;
	}
}
