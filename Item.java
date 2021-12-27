
public class Item {

	String name;
	String passive;
	int hpBonus;
	int dmgBonus;
	int price;
	int placeInInventory;

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
		placeInInventory = 0;
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
			this.hpBonus = (int) ((p.getLvl() * rand)) / 10;
			this.dmgBonus = (int) ((p.getLvl() * rand)) / 60;
			this.price = (int) ((p.getLvl() * rand) / 10);
			this.passive = "This unique item will finger you while you sleep";
			if (this.price <= 0)
				this.price = (int) (Math.random() * 10) % 4;
			break;
		case 2:
			this.name = "Banana helmet";
			max = 105;
			min = 85;
			range = max - min + 1;
			rand = (int) (Math.random() * range) + min;
			this.hpBonus = (int) ((p.getLvl() * rand)) / 10;
			this.dmgBonus = (int) ((p.getLvl() * rand)) / 60;
			this.price = (int) ((p.getLvl() * rand) / 10);
			this.passive = "Banana helmet, use it with caution!";
			if (this.price <= 0)
				this.price = (int) (Math.random() * 10) % 4;
			break;
		}

	}
}

class Chest extends Item {
	public Chest(Player p) {
		placeInInventory = 1;
		int chestType = (int) (Math.random() * 2 + 1);
		int max, min, range;
		double rand;

		switch (chestType) {
		case 1:
			this.name = "Chest of brawlers";
			max = 125;
			min = 85;
			range = max - min + 1;
			rand = (int) (Math.random() * range) + min;
			this.hpBonus = (int) ((p.getLvl() * rand)) / 10;
			this.dmgBonus = (int) ((p.getLvl() * rand)) / 60;
			this.price = (int) ((p.getLvl() * rand) / 10);
			this.passive = "if true == false { do somthing}";
			if (this.price <= 0)
				this.price = (int) (Math.random() * 10) % 4;
			break;
		case 2:
			this.name = "Mighty chest";
			max = 145;
			min = 85;
			range = max - min + 1;
			rand = (int) (Math.random() * range) + min;
			this.hpBonus = (int) ((p.getLvl() * rand)) / 10;
			this.dmgBonus = (int) ((p.getLvl() * rand)) / 60;
			this.price = (int) ((p.getLvl() * rand) / 10);
			this.passive = "Rude";
			if (this.price <= 0)
				this.price = (int) (Math.random() * 10) % 4;
			break;
		}

	}

}

class Gloves extends Item {
	public Gloves(Player p) {
		placeInInventory = 2;
		int chestType = (int) (Math.random() * 2 + 1);
		int max, min, range;
		double rand;

		switch (chestType) {
		case 1:
			this.name = "Gloves of wisdom";
			max = 125;
			min = 85;
			range = max - min + 1;
			rand = (int) (Math.random() * range) + min;
			this.hpBonus = (int) ((p.getLvl() * rand)) / 10;
			this.dmgBonus = (int) ((p.getLvl() * rand)) / 60;
			this.price = (int) ((p.getLvl() * rand) / 10);
			this.passive = "somthing";
			if (this.price <= 0)
				this.price = (int) (Math.random() * 10) % 4;
			break;
		case 2:
			this.name = "Seekers gloves";
			max = 145;
			min = 85;
			range = max - min + 1;
			rand = (int) (Math.random() * range) + min;
			this.hpBonus = (int) ((p.getLvl() * rand)) / 10;
			this.dmgBonus = (int) ((p.getLvl() * rand)) / 60;
			this.price = (int) ((p.getLvl() * rand) / 10);
			this.passive = "Rude";
			if (this.price <= 0)
				this.price = (int) (Math.random() * 10) % 4;
			break;
		}

	}

}



class Pants extends Item {
	public Pants(Player p) {
		placeInInventory = 3;
		int chestType = (int) (Math.random() * 2 + 1);
		int max, min, range;
		double rand;

		switch (chestType) {
		case 1:
			this.name = "Pants of surviver";
			max = 125;
			min = 85;
			range = max - min + 1;
			rand = (int) (Math.random() * range) + min;
			this.hpBonus = (int) ((p.getLvl() * rand)) / 10;
			this.dmgBonus = (int) ((p.getLvl() * rand)) / 60;
			this.price = (int) ((p.getLvl() * rand) / 10);
			this.passive = "somthing";
			if (this.price <= 0)
				this.price = (int) (Math.random() * 10) % 4;
			break;
		case 2:
			this.name = "Sushi pants";
			max = 145;
			min = 85;
			range = max - min + 1;
			rand = (int) (Math.random() * range) + min;
			this.hpBonus = (int) ((p.getLvl() * rand)) / 10;
			this.dmgBonus = (int) ((p.getLvl() * rand)) / 60;
			this.price = (int) ((p.getLvl() * rand) / 10);
			this.passive = "Rude";
			if (this.price <= 0)
				this.price = (int) (Math.random() * 10) % 4;
			break;
		}

	}

}


class Shoes extends Item {
	public Shoes(Player p) {
		placeInInventory = 4;
		int chestType = (int) (Math.random() * 2 + 1);
		int max, min, range;
		double rand;

		switch (chestType) {
		case 1:
			this.name = "Shoes or slowness";
			max = 125;
			min = 85;
			range = max - min + 1;
			rand = (int) (Math.random() * range) + min;
			this.hpBonus = (int) ((p.getLvl() * rand)) / 10;
			this.dmgBonus = (int) ((p.getLvl() * rand)) / 60;
			this.price = (int) ((p.getLvl() * rand) / 10);
			this.passive = "somthing";
			if (this.price <= 0)
				this.price = (int) (Math.random() * 10) % 4;
			break;
		case 2:
			this.name = "Jordans";
			max = 145;
			min = 85;
			range = max - min + 1;
			rand = (int) (Math.random() * range) + min;
			this.hpBonus = (int) ((p.getLvl() * rand)) / 10;
			this.dmgBonus = (int) ((p.getLvl() * rand)) / 60;
			this.price = (int) ((p.getLvl() * rand) / 10);
			this.passive = "Rude";
			if (this.price <= 0)
				this.price = (int) (Math.random() * 10) % 4;
			break;
		}

	}

}

class Weapon extends Item {
	public Weapon(Player p) {
		placeInInventory = 5;
		int chestType = (int) (Math.random() * 2 + 1);
		int max, min, range;
		double rand;

		switch (chestType) {
		case 1:
			this.name = "Bow of agility";
			max = 125;
			min = 85;
			range = max - min + 1;
			rand = (int) (Math.random() * range) + min;
			this.hpBonus = (int) ((p.getLvl() * rand)) / 10;
			this.dmgBonus = (int) ((p.getLvl() * rand)) / 60;
			this.price = (int) ((p.getLvl() * rand) / 10);
			this.passive = "somthing";
			if (this.price <= 0)
				this.price = (int) (Math.random() * 10) % 4;
			break;
		case 2:
			this.name = "Sword of OPiness";
			max = 145;
			min = 85;
			range = max - min + 1;
			rand = (int) (Math.random() * range) + min;
			this.hpBonus = (int) ((p.getLvl() * rand)) / 10;
			this.dmgBonus = (int) ((p.getLvl() * rand)) / 60;
			this.price = (int) ((p.getLvl() * rand) / 10);
			this.passive = "Rude";
			if (this.price <= 0)
				this.price = (int) (Math.random() * 10) % 4;
			break;
		}

	}

}

