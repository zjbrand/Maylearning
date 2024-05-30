package eden;

public class DirtyTalk {
	
	public static void main(String[] args) {
		
	
	//1.ある文字列
	String talkwords="U R Woundful Player,qsbn.";
	
	//2.敏感な単語を含む配列が新規する
	String[] dirtyArr= {"tmd","nnd","qsbn","sc"};
	
	talkwords=talkwords.toLowerCase();
	System.out.println(talkwords);
	
	//3.配列の中の値で文字列をマッチさせ、マッチしたものを書き換えます
	for(int i=0;i<dirtyArr.length;i++) {
		
		String replNum="";
		
		for(int j=0;j<dirtyArr[i].length();j++) {
			replNum +="*";
		}
		
		talkwords=talkwords.replace(dirtyArr[i], replNum);
	}	
	
	//4.マナーが従っている文字列を出力する  you are woundful player,***.	
	System.out.println(talkwords);
	}
}
