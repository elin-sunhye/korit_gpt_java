package com.korit.servlet_study.dao;

import com.korit.servlet_study.config.DBConnectionMgr;
import com.korit.servlet_study.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthDao {
    public static AuthDao instance;
    private DBConnectionMgr mgr;

    private AuthDao() {
        mgr = DBConnectionMgr.getInstance();
    }

    public static AuthDao getInstance() {
        if (instance == null) {
            instance = new AuthDao();
        }

        return instance;
    }

    public User findUserByUsername(String username) {
        User foundUser = null;

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = mgr.getConnection();

            String sql = """
                    select
                        user_id,
                        username,
                        password,
                        name,
                        email
                    from
                        user_tb
                    where
                        username = ?
                    """;

            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();

            if (rs.next()) {
                foundUser = User.builder()
                        .userId(rs.getInt("user_id"))
                        .username(rs.getString("username"))
                        .password(rs.getString("password"))
                        .name(rs.getString("name"))
                        .email(rs.getString("email"))
                        .build();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mgr.freeConnection(con, ps, rs);
        }

        return foundUser;
    }

    public User signup(User user) {
        User insertedUser = null;

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = mgr.getConnection();
            String sql = """
                    insert into user_tb
                    values(default, ?, ?, ?, ?)
                    """;

            ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            ps.setString(4, user.getEmail());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                insertedUser = User.builder()
                        .userId(rs.getInt(1))
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .name(user.getName())
                        .email(user.getEmail())
                        .build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mgr.freeConnection(conn, ps);
        }

        return insertedUser;
    }
}
