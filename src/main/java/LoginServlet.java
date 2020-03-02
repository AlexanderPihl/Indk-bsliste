import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //response.getWriter().println("Du har ramt LoginServlet");

        ServletContext servletContext = getServletContext();

        String navn = request.getParameter("Navn");
        String kodeord = request.getParameter("Kodeord");

        if(servletContext.getAttribute("brugerMap") == null) {

            Map<String, String> brugerMap = new HashMap<>();

                brugerMap.put("test","test");

            servletContext.setAttribute("brugerMap", brugerMap);
        }

        if (!((Map<String,String>)servletContext.getAttribute("brugerMap")).containsKey(navn)) {

            //Gå til loginside.
            request.setAttribute("besked","Brugeren findes ikke");
            request.getRequestDispatcher("index.jsp").forward(request,response);

        }

        if (((Map<String,String>)servletContext.getAttribute("brugerMap")).get(navn).equalsIgnoreCase(kodeord)){

            //Gå til huskelisten
            response.getWriter().println("Klar til login - alt er fint :-)");
            request.getRequestDispatcher("WEB-INF/Huskeliste.jsp").forward(request,response);
        }

        // Gå til login dvs. index siden.
        request.setAttribute("besked","Dit login er forkert");
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
