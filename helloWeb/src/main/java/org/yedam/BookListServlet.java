package org.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yedam.service.bookVO;


/**
 * Servlet implementation class BookListServlet
 */
@WebServlet("/BookListServlet")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService svc = new BookServiceImpl();
		List<bookVO> list = svc.bookList();
		System.out.println(list);
		
		response.setContentType("text/xml; charset= UTF-8");
		
		PrintWriter out = response.getWriter();
		String str = "<dataset>";
		
		for(bookVO vo : list) {
			str += "<record>";
			str += "<id>" + vo.getId() + "</id>";
			str += "<name>" + vo.getName() + "</name>";
			str += "<writer>" + vo.getWriter() + "</writer>";
			str += "<publish>" + vo.getPublish() + "</publish>";
			str += "<price>" + vo.getPrice() + "</price>";
			str += "</record>";
		}
		str += "</dataset>";
		out.print(str);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
