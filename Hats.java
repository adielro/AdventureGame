
public class Hats extends Item {
	public Hats(Player p) {
		int hatType = (int) (Math.random() * 2 + 1);
		int max, min, range;
		double rand;
		switch (hatType) {
		case 1:
			this.name = "Hat of doom";
			max = 115;
			min = 90;
			range = max - min + 1;
			rand = (int) (Math.random() * range) + min;
			this.hpBonus = (int) (((p.getLvl()  * rand) + 1) / 100) + 3;
			this.dmgBonus = (int) (((p.getLvl()  * rand) + 1) / 100) + 3;
			this.price = 10 * (int) (((p.getLvl()  * rand) + 1) / 100) + 3;
			this.passive = "This unique item will finger you while you sleep";
			break;
		case 2:
			this.name = "Banana helmet";
			max = 105;
			min = 85;
			range = max - min + 1;
			rand = (int) (Math.random() * range) + min;
			this.hpBonus = (int) ((p.getLvl() / 100) * rand);
			this.dmgBonus = (int) ((p.getLvl() / 100) * rand);
			this.price = (int) ((p.getLvl() / 100) * rand);
			this.passive = "Banana helmet, use it with caution!";
			break;
		}
		
	}
}
