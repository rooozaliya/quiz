package com.clarkngo.quizme.web.dao;

import com.clarkngo.quizme.web.config.MySqlDS;
import com.clarkngo.quizme.web.domain.CourseType;
import com.clarkngo.quizme.web.domain.QuizType;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseTypeDao {
    private DataSource ds;
    private Connection conn;


    public CourseTypeDao() {
        this.ds = MySqlDS.getDs();
    }

    public List<CourseType> getCourseTypes() {
        List<CourseType> courseTypes = new ArrayList<>();
        PreparedStatement ps = null;
        try {
            this.conn = ds.getConnection();
            ps = conn.prepareStatement("SELECT * FROM coursetype");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CourseType qt = new CourseType();
                qt.setCourseTypeId(rs.getInt("Id"));
                qt.setName(rs.getString("Name"));
                qt.setDescription(rs.getString("Description"));
                qt.setImageUrl(rs.getString("ImageURL"));

                courseTypes.add(qt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return courseTypes;
    }

    public CourseType getCourseType(int id) {
        CourseType courseType = new CourseType();
        PreparedStatement ps = null;
        try {
            this.conn = ds.getConnection();
            ps = conn.prepareStatement("SELECT * FROM coursetype WHERE Id=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                courseType.setCourseTypeId(rs.getInt("Id"));
                courseType.setName(rs.getString("Name"));
                courseType.setDescription(rs.getString("Description"));
                courseType.setImageUrl(rs.getString("ImageURL"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return courseType;
    }
}
