package be.evoliris.formation.webapp.servlets;

import be.evoliris.formation.webapp.models.User;
import be.evoliris.formation.webapp.repositories.UserRepository;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeServlet extends HttpServlet {
    @EJB
    private UserRepository ur;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User u = new User();
        u.setUsername("Ruth");
        u.setPassword("Biblop");

        ur.insert(u);

        req.getRequestDispatcher("home.ftl").forward(req, resp);
    }
}
