package WN;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.annotation.XmlType;
import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TwitterServlet extends HttpServlet {

    private static String NEW_MESSAGE = "message";
    private static String AUTHOR = "author";
    private static String DEFAULT_AUTHOR= "anonim";
    private List<Message> messages;

    @Override
    public void init() throws ServletException{

        messages = new ArrayList<>();



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("<h1> Wiadomosci: </h1>");
        messages.forEach(message -> printMassage(out, message));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newMessage = req.getParameter(NEW_MESSAGE);
        String author = Optional.ofNullable(req.getParameter(AUTHOR)).orElse(DEFAULT_AUTHOR);

        if (newMessage != null){
            Message message = new Message(newMessage, author , LocalDateTime.now());

            messages.add(message);
        }
        doGet(req ,resp);
    }


    private void printMassage(PrintWriter out , Message message) {
        out.print("<h1> " + message.getMessage()+ "</h1> ");
    }
}
