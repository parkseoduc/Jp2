package dao;

import database.Connector;
import entity.Result;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResultDAOImpl implements RepositoryDAO<Result, Integer> {

    @Override
    public ArrayList<Result> all() {
        ArrayList<Result> list = new ArrayList<>();
        String sql = "SELECT * FROM results";
        try {
            Statement stmt = Connector.getInstance().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Result r = new Result(
                        rs.getInt("id"),
                        rs.getDouble("mank"),
                        rs.getInt("student_id"),
                        rs.getInt("subject_id")
                );
                list.add(r);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Result findById(Integer id) {
        String sql = "SELECT * FROM results WHERE id = " + id;
        try {
            Statement stmt = Connector.getInstance().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                Result r = new Result(
                        rs.getInt("id"),
                        rs.getDouble("mank"),
                        rs.getInt("student_id"),
                        rs.getInt("subject_id")
                );
                rs.close();
                stmt.close();
                return r;
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean create(Result data) {
        String sql = "INSERT INTO results (id, mank, student_id, subject_id) VALUES ("
                + data.getId() + ", "
                + data.getMank() + ", "
                + data.getStudentId() + ", "
                + data.getSubjectId() + ")";
        try {
            Statement stmt = Connector.getInstance().createStatement();
            int rows = stmt.executeUpdate(sql);
            stmt.close();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean update(Result data) {
        String sql = "UPDATE results SET "
                + "mank = " + data.getMank() + ", "
                + "student_id = " + data.getStudentId() + ", "
                + "subject_id = " + data.getSubjectId()
                + " WHERE id = " + data.getId();
        try {
            Statement stmt = Connector.getInstance().createStatement();
            int rows = stmt.executeUpdate(sql);
            stmt.close();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delete(Integer id) {
        String sql = "DELETE FROM results WHERE id = " + id;
        try {
            Statement stmt = Connector.getInstance().createStatement();
            int rows = stmt.executeUpdate(sql);
            stmt.close();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}