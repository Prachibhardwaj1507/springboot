package com.example.todo.dao;
import com.example.todo.model.Todo;
import com.example.todo.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class TodoDao {

    // CREATE
    public void insert(Todo t) throws SQLException {
        String sql = "INSERT INTO todos (title, description, completed) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, t.getTitle());
            ps.setString(2, t.getDescription());
            ps.setBoolean(3, t.isCompleted());
            ps.executeUpdate();
        }
    }

    // READ ALL
    public List<Todo> getAll() throws SQLException {
        List<Todo> list = new ArrayList<>();
        String sql = "SELECT * FROM todos ORDER BY id DESC";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Todo(rs.getInt("id"), rs.getString("title"),
                        rs.getString("description"), rs.getBoolean("completed")));
            }
        }
        return list;
    }

    // READ ONE
    public Todo getById(int id) throws SQLException {
        String sql = "SELECT * FROM todos WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Todo(rs.getInt("id"), rs.getString("title"),
                            rs.getString("description"), rs.getBoolean("completed"));
                }
            }
        }
        return null;
    }

    // UPDATE
    public void update(Todo t) throws SQLException {
        String sql = "UPDATE todos SET title=?, description=?, completed=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, t.getTitle());
            ps.setString(2, t.getDescription());
            ps.setBoolean(3, t.isCompleted());
            ps.setInt(4, t.getId());
            ps.executeUpdate();
        }
    }

    // DELETE
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM todos WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}