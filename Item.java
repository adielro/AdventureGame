
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
