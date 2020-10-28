package servlet;

import dao.IUserdao;
import dao.UserDaoImpl;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FindUserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IUserdao ud = new UserDaoImpl();
        List<User> userAll = ud.getUserAll();
        req.setAttribute("userAll", userAll);//向request域中放置userAll参数
        req.getRequestDispatcher("/userlist.jsp").forward(req, resp);//转发到userlist页面
    }
}
