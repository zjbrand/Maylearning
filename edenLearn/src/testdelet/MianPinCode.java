package testdelet;


import java.util.Scanner;

public class MianPinCode {

	public static void main(String[] args) {
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("金額を入力してください：");
		while (true) {
			String money = sc1.next();
			if (checkMoney(money)) {
				System.out.println(kanjiTranslate(money));
				break;
			} else {
				System.out.println("金額を再入力してください：");
			}
		}
	}

	//数字検証
	public static boolean checkMoney(String money) {
		money.trim();
		if (money.isEmpty()) {
			System.out.println("金額は空です");
			return false;
		}
		if (money.length() > 7) {
			System.out.println("金額の桁数は７位以内です。");
			return false;
		}
		if (!money.matches("\\d+")) {
			System.out.println("金額は数字のみを入力してください。");
			return false;
		}
		return true;
	}

	//漢字転換+単位追加
	public static String kanjiTranslate(String money) {
		while (money.length() < 7) {
			money = "0" + money;
		}
		String[] unit = { "佰", "拾", "万", "仟", "佰", "拾", "元", };
		String[] numberKanji = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
		String kanjiMoney = "";
		for (int i = 0; i < money.length(); i++) {
			kanjiMoney += numberKanji[money.charAt(i) - '0'] + unit[i];
		}
		return kanjiMoney;
	}
}
