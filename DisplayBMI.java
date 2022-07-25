import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/DisplayBMI"})
public class DisplayBMI extends HttpServlet {
  static int User_Counter = 0;
  static int Under_Weight_Counter = 0;
  static int Obese_Counter = 0;  
 
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
       
       ServletContext s = request.getServletContext();
       String name = (String) s.getAttribute("username");
       
        PrintWriter out = response.getWriter();
       out.println("<html><body>");
       out.println("Welcome, "+name+"<br><br><br>");
       out.println("<form action='DisplayBMI' method='post'>");
       out.println("Enter Your<br>");
       out.println("Weight in kilometers "+"<input type='text' name='weight'/><br><br>");
       out.println("Height in meters "+"<input type='text' name='height'/><br><br>");
       out.println("<input type='submit' value='BMI'>");
       out.println("</body></html>");
       
       
       out.println("<br>"); 
       
       double weight=Double.parseDouble(request.getParameter("weight"));
       double height=Double.parseDouble(request.getParameter("height"));
       
       double BMI = weight / (height*height);
       
       if(BMI>0&&BMI<18.5){
       out.println("Your BMI ="+BMI+" You are Underweight");
      Under_Weight_Counter++ ;
       out.println("<br>");
       }
       else if(BMI>=18.5&&BMI<25){
       out.println("Your BMI ="+BMI+" You are Normal (healthy weight)");
       out.println("<br>");
       }
       else if(BMI>=25&&BMI<30){
       out.println("Your BMI ="+BMI+" You are Overweight");
       out.println("<br>");
       }
       else if (BMI>30){
       out.println("Your BMI ="+BMI+" You are Obese");   
       Obese_Counter++;
       out.println("<br>");
       }
       User_Counter++;
    
    
 
    double Obese_Ratio = (Obese_Counter*100)/User_Counter;
     double Under_weight_Ratio = (Under_Weight_Counter*100)/User_Counter;    
     ServletContext app = request.getServletContext();
    app.setAttribute("Obese_Ratio",Obese_Ratio );
    app.setAttribute("Under_weight_Ratio",Under_weight_Ratio );
 
    }  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
