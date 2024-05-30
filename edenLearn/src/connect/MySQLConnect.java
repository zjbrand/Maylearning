package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnect {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/eden?useSSL=false&serverTimezone=UTC","root", "5312448th");		
		
		Statement statement = connection.createStatement();
		
		//String s="select * from employees";
		
		//String s="update employees set department='営業部' where employee_id=19";
		
		//String s="update employees set department='AI技術部' where department='情報技術部'";
		
		//String s="select * from employees where employee_name like '__'";		
		//String s="update employees set address=substring(address,1,2) where true";
		//String s1="update employees set id_card_number=substring(id_card_number,9) where true";
		//String s2="update employees set id_card_number=lpad(id_card_number,12,'0') where true";
		String s3="select\n"
				+ "    employee_name,department,\n"
				+ "    (case when age<=30 then '若者' when age>=31 and age<=35 then '青年' else '中年' end) as '年齢段'\n"
				+ "from\n"
				+ "    employees ";
		
		//int op1 = statement.executeUpdate(s1);
		//int op2 = statement.executeUpdate(s2);
		
		//System.out.println(op1);
		//System.out.println(op2);
		ResultSet resultSet = statement.executeQuery(s3);
		
		while(resultSet.next()) {
			
			String name=resultSet.getString("employee_name");
			String department=resultSet.getString("department");
			String ageGroup=resultSet.getString("年齢段");
			
			/*int id=resultSet.getInt("employee_id");
			String name=resultSet.getString("employee_name");
			String gender=resultSet.getString("gender");
			int age=resultSet.getInt("age");
			String department=resultSet.getString("department");
			int salary=resultSet.getInt("salary");
			String address=resultSet.getString("address");
			String idCardNumber=resultSet.getString("id_card_number");
			
			System.out.println(id+"  "+name+"  "+gender+"  "+age+"  "+department+"  "+salary+"  "+
			address+"  "+idCardNumber);*/
			
			System.out.println(name+"  "+department+"  "+ageGroup);
		}
		
		connection.close();

	}

}
