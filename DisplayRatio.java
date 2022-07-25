import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/DisplayRatio"})
public class DisplayRatio extends HttpServlet {
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       processRequest(request, response);
       PrintWriter out = response.getWriter();
       
       ServletContext acc = request.getServletContext();
       double Obese_Ratio = (double) acc.getAttribute("Obese_Ratio");
       double Under_weight_Ratio = (double) acc.getAttribute("Under_weight_Ratio");       
       out.println("<h4>The ratio of obese Guests:"+Obese_Ratio+"%</h4>");
       out.println("<h4>The ratio of underweight Guests:"+Under_weight_Ratio+"%</h4>");
    }    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
