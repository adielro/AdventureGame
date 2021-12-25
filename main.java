//import java.util.Scanner;
//
//public class main {
//
//	public static void main(String[] args) {
//		
//		new Game();
//	
//		
//		
//		
//		
//		
//		
//		
//		
//		
////		boolean game = true;
////		int winsUntilShop = 0;
////		Scanner scan = new Scanner(System.in);
////		Player myPlayer = new Player();
////		while (game) {
////			int choice = -1;
////			boolean validChoice;
////			Mobs s = generateRandomMob(myPlayer);
////			System.out.println("Encountered an enemy!\n");
////			s.printMobInfo();
////			System.out.println("What would you do?\n");
////			System.out.println("1.Fight!\n2.Run.");
////			choice = scan.nextInt();
////			if (choice == 1)
////				while (s.isAlive()) {
////					System.out.println("1.Basic attack\n2.Dance");
////					validChoice = false;
////					while (!validChoice) {
////						choice = scan.nextInt();
////						switch (choice) {
////						case 1:
////							myPlayer.basicAttack(s);
////							validChoice = true;
////							if (!s.isAlive())
////								winsUntilShop++;
////							break;
////
////						case 2:
////							System.out.println("Wow, you can really dance!");
////							validChoice = true;
////							break;
////						default:
////							System.out.println("Invalid choice!");
////							break;
////						}
////					}
////					if (!myPlayer.isAlive()) {
////						System.out.println("You are dead!\nGood luck next time player.");
////						game = false;
////						break;
////					}
////						
////				}
////			else
////				System.out.println("Pussy.");
////
////			validChoice = false;
////			if (winsUntilShop == 3) {
////				winsUntilShop = 0;
////				System.out.println("Your gold: " + myPlayer.getGold());
////				Item[] shop = generateShop(myPlayer);
////				while (validChoice == false) {
////					System.out.println((shop.length + 1) + ".Nothing, i'm poor.");
////					choice = scan.nextInt();
////					switch (choice) {
////					case 1:
////						
////						myPlayer.buyItem(shop[0]);
////						validChoice = true;
////						break;
////					case 2:
////						myPlayer.buyItem(shop[1]);
////						validChoice = true;
////						break;
////					case 3:
////						myPlayer.buyItem(shop[2]);
////						validChoice = true;
////						break;
////					case 4:
////						myPlayer.buyItem(shop[3]);
////						validChoice = true;
////						break;
////					case 5:
////						validChoice = true;
////						break;
////					}
////				}
////			}
////			
////			
////			validChoice = false;
////			while (!validChoice && myPlayer.isAlive()) {
////				System.out.println("-----------------------------------------------------");
////				System.out.println("Menu: ");
////				System.out.println("1.Keep playing!");
////				System.out.println("2.Stats");
////				System.out.println("3.End game");
////				choice = scan.nextInt();
////				switch (choice) {
////				case 1:
////					validChoice = true;
////					break;
////				case 2:
////					myPlayer.printPlayerDetails();
////					break;
////				case 3:
////					game = false;
////					validChoice = true;
////					System.out.println("\n                        GG");
////					break;
////				default:
////					System.out.println("Invalid choice!");
////				}
////			}
////		}
//	}
//	
//	
//	public game() {
//		
//	}
//	
//	
//
//	static Mobs generateRandomMob(Player p) {
//		int randNum = (int) (Math.random() * 4) + 1;
//		switch (randNum) {
//		case 1:
//			Skeleton s = new Skeleton(p);
//			return s;
//		case 2:
//			Wraith w = new Wraith(p);
//			return w;
//		case 3:
//			GrimReaper g = new GrimReaper(p);
//			return g;
//		case 4:
//			Wolf wolf = new Wolf(p);
//			return wolf;
//		default:
//			Skeleton m = new Skeleton(p);
//			return m;
//
//		}
//	}
//	
//	static Item[] generateShop(Player p) {
//		Item[] shop = new Item[4];
//		System.out.println("-----------------------------------------------------\n");
//		System.out.println("Hey player!");
//		System.out.println("You can buy only one item at a item, choose wisely.\n");
//		for (int i = 0; i < shop.length; i++) {
//			shop[i] = new Hats(p);
//			System.out.println((i+1)  + ": ");
//			shop[i].printItem();
//			System.out.println();
//		}
//		return shop;
//	}
//	
//}
