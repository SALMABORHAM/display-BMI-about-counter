import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Servlet_1"})
public class Servlet_1 extends HttpServlet {

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
        
       String name = request.getParameter("username");
      
       
       ServletContext s = request.getServletContext();
    s.setAttribute("username",name );
   

    
       out.println("<html><body>");
       out.println("Welcome, "+name+"<br><br>");
       out.println("<form action='DisplayBMI' method='post'>");
       out.println("Enter Your<br>");
       out.println("Weight in kilometers "+"<input type='text' name='weight'/><br>");
       out.println("Height in meters "+"<input type='text' name='height'/><br>");
       out.println("<input type='submit' value='BMI'>");
       out.println("</body></html>");
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
