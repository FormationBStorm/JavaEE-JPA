package be.evoliris.formation.webapp.servlets;

import be.evoliris.formation.webapp.repositories.users.UserRepository;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeServlet extends HttpServlet {
    @EJB
    private UserRepository ur;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        User u = new User();
//        u.setUsername("Ruth");
//        u.setPassword("Biblop");
//
//        ur.insert(u);

        req.getRequestDispatcher("/views/home.ftl").forward(req, resp);
    }
}
