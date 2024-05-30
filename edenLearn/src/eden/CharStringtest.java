package eden;

public class CharStringtest {

	public static void main(String[] args) {
		
		/*char ch1='こ';
		char ch2='ん';
		char ch3='に';
		char ch4='ち';
		char ch5='は';*/
		
		//String chaString=""+ch1+ch2+ch3+ch4+ch5;		
		
		/*System.out.println(ch1);
		System.out.println(ch2);
		System.out.println(ch3);
		System.out.println(ch4);
		System.out.println(ch5);*/
		
		char ch5='李';//unicode
		int c=ch5;
		System.out.println(c);
		
		/*System.out.println("最小值：Character.MIN_VALUE="  
		        + (int) Character.MIN_VALUE);  
		// 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台  
		System.out.println("最大值：Character.MAX_VALUE="  
		        + (int) Character.MAX_VALUE); */
		
		String chaString="こんにちは";
		
		//反復処理　遍历
		for(int i=0;i<chaString.length();i++) {
			char cha=chaString.charAt(i);//char単一の文字
			System.out.println(cha);
		}
		
		char[] charArray = chaString.toCharArray();
		
		System.out.println(charArray);
		
//======================================================================================================//
		
		String phoneNum="  13546576451  ";			
		
		String afterCheck=PhoneHide.phoneNumcheck(phoneNum, "&");
		
		System.out.println(afterCheck);
		

	}
}
