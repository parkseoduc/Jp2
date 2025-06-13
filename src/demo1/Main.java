package demo1;

//import database.Connector;
//import entity.Student;
//import entity.Subject;
//import factory.DaoFactory;
//
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
import dao.ResultDAOImpl;
import entity.Result;

import java.util.ArrayList;
import java.util.Scanner;

//public class Main {
//    public static void main(String[] args){
//        try{
//            // ket noi db
//
//
//            ArrayList<Student> listStudent = DaoFactory.getDAO("student").all();
//
//
//
//            for (Student s : listStudent){
//                s.showInfo();
//            }
//            ArrayList<Subject> listSubject = DaoFactory.getDAO("subject").all();
//
//
//
//            // INSERT DATA
////            String insert_sql = "insert into students(name,age,telephone) values('Nguyễn Huy Long',19,'0988888888')";
////            stt.executeUpdate(insert_sql);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
        public class Main {
            public static void main(String[] args) {
                ResultDAOImpl resultDAO = new ResultDAOImpl();
                Scanner sc = new Scanner(System.in);

                while (true) {
                    System.out.println("\n========= MENU =========");
                    System.out.println("1. Thêm kết quả");
                    System.out.println("2. Cập nhật kết quả");
                    System.out.println("3. Xóa kết quả");
                    System.out.println("4. Hiển thị tất cả kết quả");
                    System.out.println("5. Tìm kết quả theo ID");
                    System.out.println("0. Thoát");
                    System.out.print("Chọn chức năng: ");
                    int choice = sc.nextInt();

                    switch (choice) {
                        case 1: // Thêm
                            System.out.print("Nhập ID: ");
                            int id = sc.nextInt();
                            System.out.print("Nhập điểm (mank): ");
                            double mank = sc.nextDouble();
                            System.out.print("Nhập student_id: ");
                            int studentId = sc.nextInt();
                            System.out.print("Nhập subject_id: ");
                            int subjectId = sc.nextInt();

                            Result newResult = new Result(id, mank, studentId, subjectId);
                            if (resultDAO.create(newResult)) {
                                System.out.println("✅ Thêm thành công!");
                            } else {
                                System.out.println("❌ Thêm thất bại!");
                            }
                            break;

                        case 2: // Cập nhật
                            System.out.print("Nhập ID kết quả cần sửa: ");
                            int updateId = sc.nextInt();
                            Result existing = resultDAO.findById(updateId);
                            if (existing != null) {
                                System.out.println("Thông tin cũ: " + existing);
                                System.out.print("Nhập điểm mới (mank): ");
                                double newMank = sc.nextDouble();
                                System.out.print("Nhập student_id mới: ");
                                int newStuId = sc.nextInt();
                                System.out.print("Nhập subject_id mới: ");
                                int newSubId = sc.nextInt();

                                Result updated = new Result(updateId, newMank, newStuId, newSubId);
                                if (resultDAO.update(updated)) {
                                    System.out.println("✅ Cập nhật thành công!");
                                } else {
                                    System.out.println("❌ Cập nhật thất bại!");
                                }
                            } else {
                                System.out.println("❌ Không tìm thấy kết quả!");
                            }
                            break;

                        case 3: // Xóa
                            System.out.print("Nhập ID kết quả cần xóa: ");
                            int deleteId = sc.nextInt();
                            Result result = resultDAO.findById(deleteId);
                            if (result != null) {
                                System.out.println("Bạn có chắc muốn xóa kết quả: " + result + " ? (OK để xác nhận)");
                                String confirm = sc.next();
                                if (confirm.equalsIgnoreCase("OK")) {
                                    if (resultDAO.delete(deleteId)) {
                                        System.out.println("✅ Đã xóa.");
                                    } else {
                                        System.out.println("❌ Xóa thất bại!");
                                    }
                                } else {
                                    System.out.println("❌ Hủy thao tác.");
                                }
                            } else {
                                System.out.println("❌ Không tìm thấy kết quả!");
                            }
                            break;

                        case 4: // Hiển thị tất cả
                            ArrayList<Result> all = resultDAO.all();
                            if (all.isEmpty()) {
                                System.out.println("❌ Không có dữ liệu.");
                            } else {
                                for (Result r : all) {
                                    System.out.println(r);
                                }
                            }
                            break;

                        case 5: // Tìm theo ID
                            System.out.print("Nhập ID cần tìm: ");
                            int searchId = sc.nextInt();
                            Result res = resultDAO.findById(searchId);
                            if (res != null) {
                                System.out.println("🎯 Kết quả tìm thấy: " + res);
                            } else {
                                System.out.println("❌ Không có kết quả.");
                            }
                            break;

                        case 0:
                            System.out.println("👋 Tạm biệt!");
                            return;

                        default:
                            System.out.println("❌ Lựa chọn không hợp lệ.");
                    }
                }
            }
        }
//
//    }
//}