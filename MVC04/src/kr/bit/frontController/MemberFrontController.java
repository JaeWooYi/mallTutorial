package kr.bit.frontController;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.controller.Controller;
import kr.bit.controller.MemberContentController;
import kr.bit.controller.MemberDeleteController;
import kr.bit.controller.MemberInsertController;
import kr.bit.controller.MemberListController;
import kr.bit.controller.MemberRegisterController;
import kr.bit.controller.MemberUpdateController;
import kr.bit.model.*;

@WebServlet("*.do")
public class MemberFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 한글깨짐 방지
		request.setCharacterEncoding("euc-kr");
		
		// 1. 클라이언트가 어떤 요청을 했는지 파악하기
		String url = request.getRequestURI();
		System.out.println(url);
		String ctx = request.getContextPath();
		System.out.println(ctx);
		
		// 2. 실제로 요청한 명령이 무엇인지 파악하기
		String command = url.substring(ctx.length());
		System.out.println(command);	// ex) memberList.do
		
		// 3. 요청에 따른 분기작업(if~else if)
		Controller controller = null;
		String nextPage = null;
		if(command.equals("/memberList.do")) {
			
			controller = new MemberListController();
			nextPage = controller.requestHandler(request, response);
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);	// 포워딩
			rd.forward(request, response);
			
		}else if(command.equals("/memberInsert.do")) {
			
			controller = new MemberInsertController();
			controller.requestHandler(request, response);
			response.sendRedirect(nextPage);
			
		}else if(command.equals("/memberRegister.do")) {
			
			controller = new MemberRegisterController();
			nextPage = controller.requestHandler(request, response);
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);	// 포워딩
			rd.forward(request, response);
			
		}else if(command.equals("/memberContent.do")) {
			
			controller = new MemberContentController();
			nextPage = controller.requestHandler(request, response);
			RequestDispatcher rd=request.getRequestDispatcher(nextPage);
			rd.forward(request, response); //-----------------------------------▲
			
		}else if(command.equals("/memberUpdate.do")) {
			
			controller = new MemberUpdateController();
			nextPage = controller.requestHandler(request, response);
			response.sendRedirect(nextPage);
			
		}else if(command.equals("/memberDelete.do")) {
			
			controller = new MemberDeleteController();
			nextPage = controller.requestHandler(request, response);
			response.sendRedirect(nextPage);
			
		}
	}

}
