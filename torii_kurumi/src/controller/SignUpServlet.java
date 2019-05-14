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

import org.apache.commons.lang.StringUtils;

import beans.User;
import service.UserService;

@WebServlet(urlPatterns = { "/signup" })
public class SignUpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        List<String> messages = new ArrayList<String>();		//空のリストを生成

        HttpSession session = request.getSession();    			//sessionの開始
        if (isValid(request, messages) == true) {				//requestを受け取れたならば

            User user = new User();								//userクラスを生成
            user.setName(request.getParameter("name"));			//userにセットさせる
            user.setAccountid(request.getParameter("accountid"));
            user.setPassword(request.getParameter("password"));

            new UserService().register(user);

            response.sendRedirect("./");				//redirect先をホーム画面へ
        } else {
            session.setAttribute("errorMessages", messages);			//sessionの範囲で保持
            response.sendRedirect("signup");			//redirect先を新規登録画面へ
        }
    }

	private boolean isValid(HttpServletRequest request, List<String> messages) {				//真偽値
		String accountid = request.getParameter("accountid");
		String password = request.getParameter("password");
		String passwordConfirm = request.getParameter("passwordConfirm");

		if (StringUtils.isEmpty(accountid) == true) {
			messages.add("IDを入力してください");
		}
		if (StringUtils.isEmpty(password) == true) {
			messages.add("パスワードを入力してください");
		}

		if(!password.matches("^[¥!-~]{6,20}$")) {
			messages.add("パスワードは記号を含む全ての半角文字で6文字以上20文字以下で入力してください");
		}

		if(!accountid.matches("^\\w{6,20}$")) {
			messages.add("IDは6文字以上20文字以下の半角英数字で入力してください");
		}

		if(!password.equals(passwordConfirm)) {
			messages.add("パスワードと確認用パスワードが一致していません");
		}

		// TODO アカウントが既に利用されていないか、既に登録されていないかなどの確認も必要
		if (messages.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
}