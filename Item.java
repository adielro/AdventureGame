
public class Item {

	String name;
	String passive;
	int hpBonus;
	int dmgBonus;
	int price;

	void printItem() {
		System.out.println("Name: " + this.name);
		System.out.println("HP bonus: " + this.hpBonus);
		System.out.println("Damage bonus: " + this.dmgBonus);
		System.out.println("Passive: " + passive);
		System.out.println("Price: " + this.price);
	}

}

class Hats extends Item {
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
			this.hpBonus = (int) (((p.getLvl() * rand) + 1) / 100) + 3;
			this.dmgBonus = (int) (((p.getLvl() * rand) + 1) / 100) + 3;
			this.price = 10 * (int) (((p.getLvl() * rand) + 1) / 100) + 3;
			this.passive = "This unique item will finger you while you sleep";
			if (this.price <= 0)
				this.price = (int) (Math.random()*10)%4;
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
			if (this.price <= 0)
				this.price = (int) (Math.random()*10)%4;
			break;
		}

	}
}