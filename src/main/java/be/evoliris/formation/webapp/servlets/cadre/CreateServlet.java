package be.evoliris.formation.webapp.servlets.cadre;

import be.evoliris.formation.webapp.forms.Cadre.CreateForm;
import be.evoliris.formation.webapp.models.beans.Cadre;
import be.evoliris.formation.webapp.models.enums.CadreField;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CadreCreate", urlPatterns = "/cadres/createCadre")
public class CreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateForm form = new CreateForm();
        Cadre cadre = new Cadre();

        req.setAttribute("form", form);
        req.setAttribute("cadre", cadre);
        req.setAttribute("fields", CadreField.values());
        req.getRequestDispatcher("createCadre.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateForm form = new CreateForm();
        Cadre cadre = form.createCadre(req);
        String resultat = null;

        req.setAttribute("form", form);
        req.setAttribute("cadre", cadre);
        req.setAttribute("fields", CadreField.values());

        if(form.getErreurs().isEmpty()){
            System.out.println("PAS D'ERREUR!!!!");
            System.out.println(cadre);
            req.getRequestDispatcher("../home.ftl").forward(req, resp);
            return;
        }
        System.out.println(form);
        req.getRequestDispatcher("createCadre.ftl").forward(req, resp);
    }
}
