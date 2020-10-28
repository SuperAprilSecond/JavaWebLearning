package servlet;

import dao.IUserdao;
import dao.UserDaoImpl;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name"); //获取jsp页面传过来的参数
        String pwd = req.getParameter("pwd");
        String sex = req.getParameter("sex");
        String home = req.getParameter("home");
        String info = req.getParameter("info");

        User user = new User(); //实例化一个对象，组装属性
        user.setName(name);
        user.setPwd(pwd);
        user.setSex(sex);
        user.setHome(home);
        user.setInfo(info);

        IUserdao ud = new UserDaoImpl();

        if(ud.register(user)){
            req.setAttribute("username", name);  //向request域中放置参数
            //request.setAttribute("xiaoxi", "注册成功");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);  //转发到登录页面
        }else{
            resp.sendRedirect("index.jsp");//重定向到首页
        }

    }
}
