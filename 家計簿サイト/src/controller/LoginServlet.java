package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import service.LoginService;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        String accountid = request.getParameter("accountid");		//accountidを引数に値を取得
        String password = request.getParameter("password");

        LoginService loginService = new LoginService();              //loginServiceの生成
        User user = loginService.login(accountid, password);         //userに送信されたIDとpassをセット

        HttpSession session = request.getSession();
        if (user != null) {					//ID.passの値が存在する場合

            session.setAttribute("loginUser", user);
            response.sendRedirect("./");	//redirect先をホームへ
        } else {							//空の場合

            List<String> messages = new ArrayList<String>();
            messages.add("ログインに失敗しました。");
            session.setAttribute("errorMessages", messages);

            response.sendRedirect("login");
        }
    }

}