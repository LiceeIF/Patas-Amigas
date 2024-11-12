import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pessoa") 
public class PessoaServlet extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html"); 
        PrintWriter writer = res.getWriter();

        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h1>Lepo</h1>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
