package verify.exam00;

public class Card {
	public static final String[] deck = { "H", "D", "S", "C" };
	public static final String[] stic = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "T" };
	private String card;

	public Card() {
		init();
	}

	public Card(Card cd) {
		card = cd.getCard().trim();// ��������
	}

	public void init() {
		int a = (int) (Math.random() * deck.length); // 0~3
		int b = (int) (Math.random() * stic.length); // 0~9
		card = deck[a] + stic[b];// H 8
	}// ī�忡 ���� �Ҵ�

	public String getCard() {// ī�尪
		return card;
	}

	public String toString() {// ���ĺ���
		return "[" + card + "] ";// [H8]
	}

	public boolean equals(Object obj) {
		boolean isS = false;
		Card cd = (Card) obj;
		if (card.equals(cd.getCard())) {
			isS = true;
		}
		return isS;
	}

	public int hashCode() {
		return card.hashCode() + 137;
	}
}
