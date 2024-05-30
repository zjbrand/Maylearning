package eden;

public class RegexEmail {
	
	//メールアドレスを検証する
	//3256566@qq.com   zhengsan3@gmail.com    delih9889@pci.com.cn
	
	public static void main(String[] args) {
		
		String regexMail="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		String regexMail1="\\w+@[\\w&&[^_]]{2,6}(\\.[a-z\\+A-Z]{2,3}){1,3}";
		
		
		String mail="3256566@qq.com.cn.org";
		
		System.out.println(mail.matches(regexMail1));
		
		String regexMark="[a-z\\+A-Z]+";
		
		String backhash="+++";
		
		System.out.println(backhash.matches(regexMark));
		
		
	}

}
