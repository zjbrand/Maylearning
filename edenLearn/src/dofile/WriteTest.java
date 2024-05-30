package dofile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class WriteTest {

	public static void main(String[] args) throws IOException {
		
		String[] arr= {"Hello!","你好!","こんにちは!"};
		
		List<String> strList=new ArrayList<>();
		strList.add("Hello");
		strList.add("你好");
		strList.add("こんにちは");
		strList.add("nihao");
		
		System.out.println(arr);
		
		for(String str:arr) {
			System.out.println(str);
		}
		
		System.out.println(strList);
		
		for(String str:strList) {
			System.out.println(str);
		}
		
		File fdir=new File("C:\\edenTeach");
		fdir.mkdir();
		
		File fdir1=new File("C:\\edenTeach\\aa");
		fdir1.mkdir();

		//String filePath="C://edenTeach//aa//1.txt";
		String filePath="C://edenTeach//aa//1.txt";
		
		File fileBuild=new File(filePath);
		
		fileBuild.createNewFile();
		
		String userContract="用户注册协议\n"
				+ "    用户注册协议\n"
				+ "        欢迎注册成为京东用户！在您注册过程中，您需要完成我们的注册流程并通过点击同意的形式在线签署以下协议，\n请您务必仔细阅读、充分理解协议中的条款内容后再点击同意（尤其是以粗体或下划线标识的条款，因为这些条款可能会明确您应履行的义务或对您的权利有所限制）。\n"
				+ "        【请您注意】如果您不同意以下协议全部或任何条款约定，请您停止注册。您停止注册后将仅可以浏览我们的商品信息但无法享受我们的产品或服务。如您按照注册流程提示填写信息，阅读并点击同意上述协议且完成全部注册流程后，即表示您已充分阅读、理解并接受协议的全部内容，并表明您同意我们可以依据协议内容来处理您的个人信息，并同意我们将您的订单信息共享给为完成此订单所必须的第三方合作方（详情查看\n"
				+ "    ";
		
		FileOutputStream fos= new FileOutputStream(filePath);
		
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		
		
		BufferedWriter bw= new BufferedWriter(osw);
		
		bw.write(userContract);
		
		bw.write(strList.toString()+"\n\n\n");
		
		for(int i=0;i<arr.length;i++) {
			bw.write(arr[i]);
		}
		
		bw.close();
	}

}
