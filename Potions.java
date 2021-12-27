
public class Potions extends Item {
	int price;
}

class HealthPotion extends Potions {

	public HealthPotion(Player p) {
		this.price = p.getLvl() * 2;
	}

}