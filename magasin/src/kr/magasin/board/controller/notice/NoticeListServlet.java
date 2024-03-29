package kr.magasin.board.controller.notice;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.magasin.board.model.service.NoticeService;

import kr.magasin.board.model.vo.PageData;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet(name = "noticeList", urlPatterns = { "/noticeList" })
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public NoticeListServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
//		페이징 처리 합니다..
		
		
		int reqPage;
		try {
			reqPage = Integer.parseInt(request.getParameter("reqPage"));
			
		}catch(NumberFormatException e){
			reqPage = 1;
			
		}
		NoticeService service = new NoticeService();
		PageData pd  = service.noticeList(reqPage);
		request.setAttribute("noticeList", pd.getNoticeList());
		request.setAttribute("pageNavi", pd.getPageNavi());
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/board/notice/noticeList.jsp");
		rd.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
