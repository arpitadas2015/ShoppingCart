import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.service.SubscriptionService;
import com.example.service.Impl.SubscriptionServiceImp;

public class SimpleServlet  extends HttpServlet{
	/**
	 * 
	 */
	
	
	 private SubscriptionService subsServ=new SubscriptionServiceImp();
	 private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws IOException{
		
		String result=null;
		System.out.println(request.getRequestURI());
		System.out.println(request.getParameter("subsType"));
		String subsType=request.getParameter("subsType");
		String invoiceCharge=request.getParameter("invoiveAmount");
		System.out.println(invoiceCharge);
		String period = request.getParameter("periods");
		String startDate=request.getParameter("fromDate");
		String endDate=request.getParameter("toDate");
		try {
			 result=subsServ.generateInvoive(invoiceCharge, subsType, period, startDate, endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		        PrintWriter out = response.getWriter();
		        out.println("<html>");
		        out.println("<head>");
		        out.println("<style>");
		        out.println("body { background-color: #E6E6FA;}");
		        out.println("</style>");
		        out.println("</head>");
		        out.println("<body>");
		        out.println("<h1>Invoice of Current Subscription</h1>");
		        out.println("<h2>Report generated by: arpitadas</h2>");
		        out.println("<h3>Amount</h3>");
		        out.print(invoiceCharge);
		        out.println("<h3>Subscription Type : </h3>");
		        out.print(subsType);
		        out.println("<h3>Invoice Date/Dates</h3>");
		        out.print(result);
		        out.println("</body>");
		        out.println("</html>"); 
		    }

}
