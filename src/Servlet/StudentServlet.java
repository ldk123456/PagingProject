package Servlet;

import bean.PageBean;
import bean.Student;
import dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentServlet")
public class StudentServlet extends HttpServlet {

    private StudentDao studentDao = new StudentDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        int pc = getPc(request);
        String url = request.getRequestURI() + "?";
        PageBean<Student> pageBean = studentDao.findByPage(pc);
        pageBean.setUrl(url);
        request.setAttribute("pb", pageBean);// 保存数据到request域对象中
        request.getRequestDispatcher("/message.jsp").forward(request, response);// 跳转到message.jsp页面
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * 获取pc
     *
     * @param request
     * @return
     */
    private int getPc(HttpServletRequest request) {
        int pc = 1;
        String paramPc = request.getParameter("pc");// 获取传来的参数pc
        if (null != paramPc && !paramPc.trim().isEmpty())// 判断是否为空或空字符串
            pc = Integer.parseInt(paramPc.trim());
        return pc;
    }
}
