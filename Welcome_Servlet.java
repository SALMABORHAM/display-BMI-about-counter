import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Welcome_Servlet"})
public class Welcome_Servlet extends HttpServlet {

    
    
 static int Admin_Counter = 0 ;
 
 
 
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
        
            
            
            response.setContentType("text/html"); 
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String button = request.getParameter("button");
        PrintWriter out = response.getWriter();
        
       if("admin".equals(button)){
            if(name.equals("admin")&&password.equals("12345")){
                if( Admin_Counter ==0 ){
        out.println("<h4>The ratio of obese Guests:"+"0%</h4>");
        out.println("<h4>The ratio of underweight Guests:"+"0%</h4>");
                Admin_Counter++;
                }
                
                else{
                      
                request.getRequestDispatcher("DisplayRatio").forward(request, response);
                }
            }
            else
       {
       out.println("<h4> Invalid username or password </h4>"); 
        request.getRequestDispatcher("index.html").include(request, response);
       }
       }
       
        else{
             Admin_Counter++;
        request.getRequestDispatcher("Servlet_1").include(request, response);
        }
        
     }
   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    }
