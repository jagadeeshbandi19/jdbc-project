package myjdbc2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class tom {
	public static void main(String[] args) {
		int studentId;
		String studentName;
		String studentclg;

		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/myjdbc2","root","root");

			while(true) {
				
				System.out.println("student menu"
						+ "\n1.Add studentr Details"
						+ "\n2.Update student Details"
						+ "\n3.Delete/Drop student Details"
						+	"\n4.View All student Details"
						+ "\n5.Exit...!");

				System.out.println("Enter your Choice:-");
				int choice=sc.nextInt();
				

				switch (choice) {
				case 1:
					PreparedStatement preparedStatement=connection.prepareStatement("insert into jagadeesh values(?,?,?)");
					System.out.println("Enter student  Id");
					studentId=sc.nextInt();
					System.out.println("Enter student  Name");
					studentName=sc.next();
					System.out.println("Enter student clg");
					studentclg=sc.next();
					preparedStatement.setInt(1,studentId);
					preparedStatement.setString(2,studentName);
					preparedStatement.setString(3, studentclg);
					preparedStatement.execute();
					System.out.println("student Details Added Sucessfully..");
					break;
				case 2:
					PreparedStatement preparedStatement1=connection.prepareStatement("update jagadeesh Set Name='Raju' where Id=?");
					System.out.println("Enter student Id");
					studentId=sc.nextInt();
					preparedStatement1.setInt(1, studentId);
					preparedStatement1.execute();
					System.out.println("student Details updated");
					break;
				case 3:
					PreparedStatement preparedStatement2=connection.prepareStatement("delete from jagadeesh where id=?");
					System.out.println("Enter student Id");
					studentId=sc.nextInt();
					preparedStatement2.setInt(1, studentId);
					preparedStatement2.execute();
					System.out.println("Data Deleted");

					break;
				case 4:
					PreparedStatement preparedStatement3=connection.prepareStatement("Select * from jagadeesh");
					ResultSet resultSet=preparedStatement3.executeQuery();
					while(resultSet.next()) {
						System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3));
					}
					preparedStatement3.execute();
					connection.close();
					break;
				case 5:
					System.out.println("Thank you");
					System.exit(0);
					break;


				default:
					System.out.println("Invalid Choice");
				}
			}
		}
		catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
}


