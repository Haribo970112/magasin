package kr.magasin.prdPaging.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.magasin.basket.model.service.BasketService;
import kr.magasin.basket.model.vo.BasketT;
import kr.magasin.member.model.service.MemberService;
import kr.magasin.member.model.vo.Member;
import kr.magasin.prdPaging.model.service.ProductLeeService;
import kr.magasin.prdPaging.model.vo.ProductAll;

/**
 * Servlet implementation class AddOrderServlet
 */
@WebServlet(name = "AddOrder", urlPatterns = { "/addOrder" })
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int count = Integer.parseInt(request.getParameter("count"));
		System.out.println("결제확인페이지 도착!!!!");
		ArrayList<BasketT> list = new ArrayList<BasketT>();
		BasketT bt = null;
		//basket.jsp에서 받아온 값 
		for(int i=0;i<count;i++) {
			bt = new BasketT();
			int basketId = Integer.parseInt(request.getParameter("basketId"+i));
			String prdDtlId = request.getParameter("prdDtlId"+i);
			String prdDtlSize = request.getParameter("prdDtlSize"+i);
			String prdDtlColor =request.getParameter("prdDtlColor"+i);
			String basketUserId =request.getParameter("basketUserId"+i);
			String prdName = request.getParameter("prdName"+i);
			int prdCount = Integer.parseInt(request.getParameter("prdCount"+i));
			int prdPrice = Integer.parseInt(request.getParameter("prdPrice"+i));	
			
			bt = new BasketT(basketId, prdDtlId, prdDtlSize, prdDtlColor, basketUserId, prdName, prdCount, prdPrice);
			list.add(bt);
		}
		if(!list.isEmpty()) {
			for(int i=0;i<count;i++) {
				System.out.println("list 잘들어노는지 확인");
				System.out.println(i+"번쨰"+list.get(i).getPrdName());
			}
		}else {
			System.out.println("list안들어옴");
		}
		
		

		ProductLeeService service = new ProductLeeService();
		ArrayList<ProductAll> pay = service.insertBasket(list, count);
		MemberService service2 = new MemberService();
		BasketService service3 = new BasketService(); 
		int result = service3.deleteBasket(list,count);
		//int result2 = service.deleteCountProduct(list, count);
		Member m =  service2.selectOne(list.get(0).getBasketUserId());
		
			
		HttpSession session = request.getSession(false);
		session.setAttribute("member", m);
		request.setAttribute("ProductAll", pay);
		if(!pay.isEmpty()) {
			System.out.println("pay 잘들어왔는지 확인"+pay.get(0).getPrdDtlSize());
		}
		
		System.out.println("member 잘들어왔는지 확인"+m.getId());
		RequestDispatcher rd = request.getRequestDispatcher("/views/prdPage/expays2.jsp");
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
