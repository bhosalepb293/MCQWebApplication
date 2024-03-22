package Controller;

import java.io.IOException;
import java.net.URI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.DTO;

@WebServlet(urlPatterns = {"/displaybookLink","/addbookLink","/updatebookLink"})
public class Controller extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getServletPath();
		
		switch(url) {
			case "/displaybookLink":
				display(req,resp);
				break;
			case "/addbookLink":
				addBook(req, resp);
				break;
			case "/updatebookLink":
				updateBook(req,resp);
				break;
		}
	}

	void display(HttpServletRequest req, HttpServletResponse resp) {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = null;
		String auth = null;
		String pages = null;
		
		DTO dto = new DTO();
		dto.setBook_id(id);
		
		DAO dao = new DAO();
		ResultSet rs = dao.details(dto);
		
		try {
			if(rs.next()) {
				name = rs.getString(2);
				auth = rs.getString(3);
				pages = rs.getString(4);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("id", id);
		req.setAttribute("name", name);
		req.setAttribute("auth", auth);
		req.setAttribute("pages", pages);
		try {
			req.getRequestDispatcher("UpdateBook.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void addBook (HttpServletRequest req, HttpServletResponse resp){
		String name = req.getParameter("book_name");
		String auth = req.getParameter("book_auth");
		String pages = req.getParameter("no_of_pages");
		
		DTO dto = new DTO();
		dto.setBook_name(name);
		dto.setBook_auth(auth);
		dto.setNo_of_pages(pages);
		
		DAO dao = new DAO();
		int res =  dao.addBook(dto);
		
		if(res>0) {
			try {
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	void updateBook (HttpServletRequest req, HttpServletResponse resp) {
		int id = Integer.parseInt(req.getParameter("book_id"));
		String name = req.getParameter("book_name");
		String auth = req.getParameter("book_auth");
		String pages = req.getParameter("no_of_pages");
		
		DTO dto = new DTO();
		dto.setBook_id(id);
		dto.setBook_name(name);
		dto.setBook_auth(auth);
		dto.setNo_of_pages(pages);
		
		DAO dao = new DAO();
		int res = dao.updateBook(dto);
		
		if(res>0) {
			try {
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
