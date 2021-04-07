package verify.exam00;

import java.util.Collections;
import java.util.Vector;

public class CardVectorBox {
	private final int numOfCards = Card.deck.length * Card.stic.length;// 40
	private Vector vCard;

	public CardVectorBox() {
		make();
	}

	private void make() {
		init();
		fulling();
	}

	private void init() {
		vCard = new Vector(5, 5);
		vCard.clear();
	}

	public void fulling() {
		int count = 0;
		while (true) {
			Card cd = new Card();// 임의의 카드를 만든다.
			if (!vCard.contains(cd)) {// 같은것이 없다면
				vCard.add(cd);// add
				count++;
			}
			if (count == numOfCards) {// 40
				break;
			}
		}
	}

	public Vector getAllCards() {
		return vCard;
	}

	public void shuffles() {
		Collections.shuffle(vCard);
	}
}
