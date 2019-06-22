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

import beans.Comment;
import beans.User;
import beans.UserMessage;
import service.CommentService;
import service.MessageService;
import service.UserService;

@WebServlet(urlPatterns = { "/index.jsp" })
public class TopServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

    	List<UserMessage> messages = new MessageService().getMessage();
    	User user = (User) request.getSession().getAttribute("loginUser");
        boolean isShowMessageForm;
        if (user != null) {
            isShowMessageForm = true;
        } else {
            isShowMessageForm = false;
        }

        request.setAttribute("messages", messages);
        request.setAttribute("isShowMessageForm", isShowMessageForm);

        List<Comment> commentUser = new CommentService().getComment();



        request.setAttribute("commentUser", commentUser);


        request.getRequestDispatcher("top.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

    	List<String> messages = new ArrayList<String>();

    	HttpSession session = request.getSession();
    	if(isValid(request, messages) == true) {

    		User user = (User) session.getAttribute("loginUser");

    		 Comment comment = new Comment();
    		 comment.setComment(request.getParameter("comment"));
    		 comment.setUserId(user.getId());
    		 comment.setMessageid(Integer.parseInt(request.getParameter("messageid")));


    		new CommentService().register(comment);

    		response.sendRedirect("./");
    	}else {
    		session.setAttribute("errorMessages", messages);
    		response.sendRedirect("./");
    	}

    	User user = new User();
    	user.setSearch(request.getParameter("search"));
    	user.setDatesearch(request.getParameter("datesearch"));
    	user.setDatesearch(request.getParameter("date"));

    	new UserService().search(user);
    	



    }

    private boolean isValid(HttpServletRequest request, List<String> messages) {

    	String comment = request.getParameter("comment");

    	if (500 < comment.length()) {
            messages.add("500文字以下で入力してください");
        }
    	if(StringUtils.isEmpty(comment)) {
    		messages.add("空では登録できません");
    	}

    	if(messages.size() == 0) {
    		return true;
    	}else {
    		return false;
    	}

    }


}