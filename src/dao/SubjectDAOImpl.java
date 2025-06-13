package dao;

import database.Connector;
import entity.Subject;

import java.sql.*;
import java.util.ArrayList;

public class SubjectDAOImpl implements RepositoryDAO<Subject, Integer> {

    @Override
    public ArrayList<Subject> all() {
        ArrayList<Subject> list = new ArrayList<>();
        String sql = "SELECT * FROM subjects";
        try {
            Statement stmt = Connector.getInstance().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Subject s = new Subject(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("hours"),
                        rs.getDouble("cost")
                );
                list.add(s);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Subject findById(Integer id) {
        String sql = "SELECT * FROM subjects WHERE id = " + id;
        try {
            Statement stmt = Connector.getInstance().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                Subject s = new Subject(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("hours"),
                        rs.getDouble("cost")
                );
                rs.close();
                stmt.close();
                return s;
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean create(Subject s) {
        String sql = "INSERT INTO subjects (id, name, hours, cost) VALUES ("
                + s.getId() + ", '"
                + s.getName() + "', "
                + s.getHours() + ", "
                + s.getCost() + ")";
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
    public Boolean update(Subject s) {
        String sql = "UPDATE subjects SET "
                + "name = '" + s.getName() + "', "
                + "hours = " + s.getHours() + ", "
                + "cost = " + s.getCost()
                + " WHERE id = " + s.getId();
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
        String sql = "DELETE FROM subjects WHERE id = " + id;
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
