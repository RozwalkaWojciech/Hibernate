package servlet;

import model.Person;
import service.PersonService;
import utils.Formatter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;


@WebServlet("/person")
public class PersonServlet extends HttpServlet {

    @Inject
    PersonService personService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        LocalDate birthDate = Formatter.localDateFromString(req.getParameter("birthdate"));
        Person person = new Person(name, lastName, birthDate);
        personService.savePerson(person);
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(String.format("Person saved: %s", person.toString()));
    }
}
