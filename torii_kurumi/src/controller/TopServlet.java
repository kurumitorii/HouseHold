package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/index.jsp" })   				//マッピングするurlパターンをindexで設定する
public class TopServlet extends HttpServlet {			//extendsキーワードを付けて継承元を指定する
	private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

             request.getRequestDispatcher("/top.jsp").forward(request, response);

    }
}