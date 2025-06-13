package demo1;

import database.Connector;
import entity.Student;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ShowStudent {
    public static void main(String[] args){
        // viết code nhập vào id của 1 người và tìm trong db dữ liệu sinh viên đó
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập ID sinh viên: ");
            int id = scanner.nextInt();

            // ket noi db
            Connector connector = Connector.getInstance();
            Statement stt = connector.createStatement();
//             GET DATA
            String query = "SELECT * FROM students WHERE id = " + id;
            ResultSet rs = stt.executeQuery(query);
            Student s = null;
            while (rs.next()) {
                Integer studentId = rs.getInt("id");
                String name = rs.getString("name");
                String telephone = rs.getString("telephone");
                Integer age = rs.getInt("age");
                s = new Student(id,name,age,telephone);
            }
            s.showInfo();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}