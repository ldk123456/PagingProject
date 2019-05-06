package dao;

import bean.PageBean;
import bean.Student;
import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public PageBean<Student> findByPage(int pc) {
        int ps = 3;// 定义每页显示数据为3条
        int all = 0;// 初始化总页数为0

        // 初始化数据库连接对象
        Connection conn = DBUtil.getConnection();
        Statement st = null;
        ResultSet rs = null;

        String sql = "select count(*) from student";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next())
                all = Integer.parseInt(rs.getString("count(*)"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(st, rs, conn);
        }

        PageBean<Student> pageBean = new PageBean<Student>();
        pageBean.setPc(pc);// 请求页码
        pageBean.setAll(all);// 总页数
        pageBean.setPs(ps);// 每页显示记录数

        // 从第(pc-1)*ps条记录开始查询ps条记录
        sql = "select id,name,gender,age,grade,address from student limit "
                + (pc - 1) * ps + " , " + ps;
        List<Student> studentLists = new ArrayList<>();
        conn = DBUtil.getConnection();
        st = null;
        rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);// resultSet获取执行结果
            while (rs.next()) {
                Student student = new Student();
                student.setId(Integer.parseInt(rs.getString("id")));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setAge(rs.getInt("age"));
                student.setAddress(rs.getString("address"));
                student.setGrade(rs.getInt("grade"));
                studentLists.add(student);// 添加对象到集合
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(st, rs, conn);
        }
        pageBean.setBeanList(studentLists);
        return pageBean;
    }
}
