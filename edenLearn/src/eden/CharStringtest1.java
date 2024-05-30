package eden;

public class CharStringtest1 {
	
	public static void main(String[] args) {
		
		//じゃバスクリブト　という文字は単一の文字を定義し
		char ch1='じ';
		char ch2='ゃ';
		char ch3='バ';
		char ch4='ス';
		char ch5='ク';
		char ch6='リ';
		char ch7='ブ';
		char ch8='ト';
		
		//これらの文字が文字列に変更する
		String charString=""+ch1+ch2+ch3+ch4+ch5+ch6+ch7+ch8;
		System.out.println(charString);
		
		//文字列を単一の文字に分割し,文字配列に配置します
		char[] charArray = charString.toCharArray();
		
		//{'じ','ゃ','バ','ス','ク','リ','ブ','ト'}
		
		System.out.println("-------------------------------------");
		System.out.println(charArray);
		System.out.println("-------------------------------------");
		
		//じゃバスクリブト->じ$ゃ$バ$ス$ク$リ$ブ$ト$
		
		//この配列を反復処理し、各文字をコンソールに出力します。
		
		String chString="";
		for(char c:charArray) {
			chString=chString+c+'$';			
		}		
		System.out.println(chString);
		
		
		int[] arr= {1,2,3,4};		
		String[] arrString= {"1","2","3","4"};
		char[] arrChar= {'1','2','3','4'};
		
		
		System.out.println(arr);
		System.out.println(arrString);
		System.out.println(arrChar);
		
		/*char[] charArr= {'じ','ゃ','バ','ス','ク','リ','ブ','ト'};
		System.out.println(charArr);
		123456789 a b c d e f 
		*/
		//じゃバスクリブト
//index  0 1 2 
		String substring = charString.substring(0, 3);
		
		substring=substring + "****";
		
		System.out.println(substring);
		
	}
	

}
