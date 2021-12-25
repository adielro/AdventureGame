
public class Mobs {
	protected int hp;
	protected int dmg;
	protected int exp;
	protected int goldDrop;
	protected int lvl;
	protected boolean alive;
	protected String trait;
	protected String traitBonus;

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getDmg() {
		return dmg;
	}

	public void setDmg(int dmg) {
		this.dmg = dmg;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getGoldDrop() {
		return goldDrop;
	}

	public void setGoldDrop(int goldDrop) {
		this.goldDrop = goldDrop;
	}

	public boolean isAlive() {
		this.checkPulse();
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	void checkPulse() {
		if (this.hp <= 0)
			this.alive = false;
	}

	int basicAttack(Player p) {
		int max = 115;
		int min = 90;
		int range = max - min + 1;
		double rand = (int) (Math.random() * range) + min;
		int dmgDealt = (int) (this.dmg * rand) / 100;
		p.setHp(p.getHp() - dmgDealt);
		return dmgDealt;
	}

	void printMobInfo() {
		if (this.getClass().getSimpleName().equals("Skeleton"))
			this.printSkeletonAscii();
		System.out.println("Name: " + this.getClass().getSimpleName());
		System.out.println("Trait: " + this.trait);
		System.out.println("HP: " + this.getHp());
		System.out.println("Trait bonus: " + this.traitBonus);
		System.out.println();
	}
	
	
	void printSkeletonAscii() {
		System.out.println("                             .___.");
		System.out.println("          /)              ,-^     ^-.");
		System.out.println("         //              /           \"");
		System.out.println("------|  |--------------/             \\-------------------.__");
		System.out.println("MWMWMW|  |>>>>>>>>>>>>> | />>\\   />>\\ |>>>>>>>>>>>>>>>>>>>>>>:>");
		System.out.println("------|  |--------------| \\__/   \\__/ |-------------------'^^");
		System.out.println("         \\\\              \\    /|\\    /");
		System.out.println("          \\)              \\   \\_/   /");
		System.out.println("                           |       |");
		System.out.println("                           |+H+H+H+|");
		System.out.println("                           \\       /");
		System.out.println("                            ^-----^");
	}

}
