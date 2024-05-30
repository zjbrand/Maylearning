package eden;

import java.util.Scanner;

public class MoneyReverse {
	/*
	金額を７桁以内で入力し、桁が足りない場合は０を追加してください。中国の大文字を表す。
			１．0~9999999の範囲内判断する。
			
			２３５零佰零拾零万零仟贰佰叁拾伍元   贰叁伍
			[壹,贰,叁,肆，伍，陆，柒，捌，玖]
	*/
	public static void main(String[] args) {
				
		//1.データ正しくかどうかを検証機能
		int money = checkMoney();
		System.out.println(money);
		
		//2.大文字を変更する機能
		//int money =2356;//贰叁伍
		
		String moneyStr="";
		while(true) {
			int remain=money%10;
			
			String capital=getCapital(remain);
			moneyStr=capital+moneyStr;
			
			money=money/10;
			if(money==0) {
				break;//ループの終了を役割する
			}			
		}
		
		System.out.println(moneyStr);		
		
		//3.ぜろと単位を挿入 零零零零贰叁伍
		int count=7-moneyStr.length();
		
		for(int i=0;i<count;i++) {			
			moneyStr="零"+moneyStr;
		}
		
		//System.out.println(moneyStr);
		
		String[] unit= {"佰","拾","万","仟","佰","拾","元"};		
		
		//moneyStr=零零零贰叁伍陆
		String result="";
		for(int i=0;i<moneyStr.length();i++) {
			char cha=moneyStr.charAt(i);//char単一の文字
			
			result=result+cha;
			result=result+unit[i];		
		}
		//result=零佰零拾零万零仟贰佰叁拾伍元
		
		//4.変更された金額を出力する
		System.out.println(result);
		
	}
	
	static int checkMoney() {		
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("金額を入力してください：");
		
		while(!scanner.hasNextInt()) {
			
			System.out.println("金額は数字だけです、もう一度入力してください。");
			scanner.next();
		}
		
		while(true) {
			
			long num=scanner.nextInt();			
			
			if(num>=0 && num<9999999) {
				//入力した金額が正しいの場合
				return (int)num;
			}else {	
				System.out.println("金額は0から9999999までの数字です、もう一度入力してください。");
				scanner.nextLine();	//空白含むものを読み取る		
			}
		}			
		
	}

	
	static String getCapital(int n) {
		
		String[] arrString={"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};				
		
		return arrString[n];
	}
	
}
