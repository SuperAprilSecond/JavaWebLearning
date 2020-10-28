package servlet;

import dao.IUserdao;
import dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int userId = Integer.parseInt(id);

        IUserdao ud = new UserDaoImpl();

        if(ud.delete(userId)){
            req.setAttribute("xiaoxi", "删除成功");
            req.getRequestDispatcher("/FindUserList").forward(req, resp);//转发
        }else{
            resp.sendRedirect("index.jsp");
        }

    }
}
