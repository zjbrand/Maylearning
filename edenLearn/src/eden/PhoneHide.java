package eden;

public class PhoneHide {

	public static void main(String[] args) {
		// 139 5177 6623
		String phoneNum1 = " 13951776623  ";
		String phoneNum2 = " 6623 ";
		String phoneNum3 = " 51774567asd ";

		String plusMark = "+";
		String starMark = "*";

		String numcheck = phoneNumcheck(phoneNum2, starMark);

		System.out.println(numcheck);
	}

	//----------------------------------------------------------------//
	public static String phoneNumcheck(String p, String m) {

		p = p.trim();

		if (p.isEmpty() || p.isBlank()) {
			return "電話番号は空してはいけない";
		}

		if (p.length() != 11) {
			return "番号の桁数は間違いです、も一度入力してください。";
		}

		if (!p.matches("\\d+")) {
			return "電話番号は数字のみが構成されます。";
		}

		String firstNum = p.substring(0, 3);

		firstNum = firstNum + m + m + m + m;

		String secondNum = p.substring(7);

		String phNumHide = firstNum + secondNum;

		return phNumHide;
	}

}
