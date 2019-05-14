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
import exception.NoRowsUpdatedRuntimeException;
import service.UserService;

@WebServlet(urlPatterns = { "/edit" })
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	        request.getRequestDispatcher("edit.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<String> messages = new ArrayList<String>();
		HttpSession session = request.getSession();
		User editUser = getEditUser(request);


		if (isValid(request, messages) == true) {

			try {
				new UserService().update(editUser);
			} catch (NoRowsUpdatedRuntimeException e) {
				messages.add("データを確認してください");
				session.setAttribute("errorMessages", messages);
				request.setAttribute("editUser", editUser);
				request.getRequestDispatcher("edit.jsp").forward(request, response);
				return;
			}

			session.setAttribute("loginUser", editUser);

			response.sendRedirect("./");
		} else {
			session.setAttribute("errorMessages", messages);
			request.setAttribute("editUser", editUser);
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		}
	}

	private User getEditUser(HttpServletRequest request)
			throws IOException, ServletException {

		User editUser = new User();
		editUser.setName(request.getParameter("name"));
		editUser.setAccountid(request.getParameter("accountid"));
		editUser.setPassword(request.getParameter("password"));
		return editUser;
	}

	private boolean isValid(HttpServletRequest request, List<String> messages) {

		String accountid = request.getParameter("accountid");
		String password = request.getParameter("password");
		String passwordConfirm = request.getParameter("passwordConfirm");

		if (StringUtils.isEmpty(accountid) == true) {
			messages.add("IDを入力してください");
		}
		if(!password.matches("^!// && [¥!-~]{6,20}$")) {
			messages.add("パスワードは記号を含む全ての半角文字で6文字以上20文字以下で入力してください");
		}
		if(StringUtils.isEmpty(password) == true) {
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