package web.component;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cust.Cust;
import com.cust.CustBiz;

/**
 * Servlet implementation class CustListServlet
 */
@WebServlet({ "/CustListServlet", "/clist" })
public class CustListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CustBiz biz;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustListServlet() {
        super();
        // TODO Auto-generated constructor stub
        biz=new CustBiz();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Cust> list=null;
		response.setCharacterEncoding("EUC-KR");
		PrintWriter out =response.getWriter();
		String result="<table border=1 style='width:300px'>";
		result+="<tr><td>id</td><td>pwd</td><td>name</td><td>age</td></tr>";
		
		try {
			list=biz.get();
			for(Cust cust:list) {
				String id=cust.getId();
				String pwd=cust.getPwd();
				String name=cust.getName();
				int age=cust.getAge();
				result+="<tr><td><a href='cdetail?id="+id+"&pwd="+pwd+"&name="+name+"&age="+age+"'>"+id+"</a></td>";
				result+="<td>"+pwd+"</td>";
				result+="<td>"+name+"</td>";
				result+="<td>"+age+"</td></tr>";
			}
			result+="</table>";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result+="<h1> List Fail </h1>";
			e.printStackTrace();
		}
		out.println(result);
		out.close();
		
	}

}
