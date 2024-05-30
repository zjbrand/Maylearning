package eden;

import java.util.Scanner;

public class RegexTest {
	/*
	 * 規則：qq番号は6桁から20桁まで、0で始まってはいけず、数字のみでなければならない
	 */
	public static void main(String[] args) {
		
		//String qq="958945678a";
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("qq番号を入力してください：");
		String QQ=scan.next();		
		
		//index
		
		/*char ch='\r';
		int in=ch;
		System.out.println(in);	*/
				
		//System.out.println(qq.charAt(3));
		
		//System.out.println(checkqq(qq));
		//正規表現検証
		String regex="[1-9]\\d{5,19}";
		
		boolean match = QQ.matches(regex);
				
		
		//System.out.println(qq.matches(regex));
		//System.out.println(match);
		
		if(match==true) {
			System.out.println("QQ番号は正しいです");
		}else {
			System.out.println("QQ番号は間違いです");
		}
		
		
	}
	
	public static boolean checkqq(String qq) {
		
		int len=qq.length();
		
		if(len<6||len>20) {
			return false;
		}
		
		if(qq.startsWith("0")) {
			return false;
		}
		
		for(int i=0;i<qq.length();i++) {
			char c=qq.charAt(i);
			if(c<'0'||c>'9') {
				return false;
			}
		}
				
		return true;
	}

}
