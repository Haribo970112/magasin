package kr.magasin.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.magasin.board.model.dao.ReviewDao;
import kr.magasin.board.model.vo.PageData;
import kr.magasin.board.model.vo.Review;
import kr.magasin.common.JDBCTemplate;

public class ReviewService {
	ReviewDao dao = new ReviewDao();
	public PageData reviewList(int reqPage) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		/*ArrayList<Notice> list = dao.noticeList(conn);*/
		int numberPage = 15;
		int totalCount = dao.totalCount(conn);
		int totalPage = (totalCount % numberPage ==0) ? (totalCount/ numberPage) : (totalCount/numberPage)+1;
		int start = (reqPage-1)* numberPage +1;
		int end = reqPage*numberPage;
		ArrayList<Review> list = dao.reviewList(conn,start, end);
		String pageNavi = "";
		int pageNaviSize = 5;
		int pageNo = ((reqPage-1) / pageNaviSize) * pageNaviSize + 1;
		if(pageNo!=1) {
			pageNavi += "<a class='btn' href='/reviewList?reqPage="+(pageNo-1)+"'>이전</a>";
		}
		int i= 1;
		while(!(i++>pageNaviSize|| pageNo>totalPage)) {
			if(reqPage == pageNo) {
				pageNavi += "<span class='selectPage'>"+pageNo+"</span>";
			}else {
				pageNavi += "<a class='btn' href='/reviewList?reqPage="+pageNo+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		if(pageNo <= totalPage) {
			pageNavi += "<a class='btn' href='/reviewList?reqPage="+pageNo+ "'>다음</a>";
		}
		PageData pd = new PageData(pageNavi, null, list, null, null);
		
		JDBCTemplate.close(conn);
		return pd;
		
	}

}
