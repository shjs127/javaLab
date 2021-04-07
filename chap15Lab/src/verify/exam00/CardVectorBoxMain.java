package verify.exam00;

import java.util.Vector;

public class CardVectorBoxMain {
	public static void main(String[] args) {
		CardVectorBox box = new CardVectorBox();
		Vector cards = box.getAllCards();
		println(cards);
		System.out.println("\n-----------------");
		box.shuffles();// Ä«µå¼¯±â
		cards = box.getAllCards();
		println(cards);
	}

	public static void println(Vector cards) {
		for (int i = 0; i < cards.size(); i++) {
			System.out.print((Card) cards.get(i));
			if ((i + 1) % 10 == 0) {
				System.out.println();
			}
		}
	}
}
