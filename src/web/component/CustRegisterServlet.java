package web.component;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cust.Cust;
import com.cust.CustBiz;

/**
 * Servlet implementation class CustRegisterServlet
 */
@WebServlet({ "/CustRegisterServlet", "/cregister" })
public class CustRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      CustBiz biz; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustRegisterServlet() {
        super();
        biz=new CustBiz();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		
		Cust cust=new Cust(id,pwd,name,Integer.parseInt(age));
		response.setCharacterEncoding("EUC-KR");
		PrintWriter out=response.getWriter();
		
		String result="";
		try {
			biz.register(cust);
			result+="<h1>REGISTER OK "+id+" 님 환영합니다. </h1>";
			result+="<table border=1 style='width:300px'><tr><td>id</td><td>"+id+"</td></tr>";
			result+="<tr><td>pwd</td><td>"+pwd+"</td></tr>";
			result+="<tr><td>name</td><td>"+name+"</td></tr>";
			result+="<tr><td>age</td><td>"+age+"</td></tr>";
			result+="</table>";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result="<h1>Register Fail</h1>";
		}
		out.println(result);
		
	}

}
