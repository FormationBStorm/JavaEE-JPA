package be.evoliris.formation.webapp.servlets.cadre;

import be.evoliris.formation.webapp.forms.personnels.cadres.CreateForm;
import be.evoliris.formation.webapp.models.beans.personnels.Cadre;
import be.evoliris.formation.webapp.models.beans.salles.Salle;
import be.evoliris.formation.webapp.models.enums.CadreField;
import be.evoliris.formation.webapp.repositories.cadres.CadreRepository;
import be.evoliris.formation.webapp.repositories.salles.SalleRepository;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CadreCreate", urlPatterns = "/cadres/create")
public class CreateServlet extends HttpServlet {
    @EJB private CadreRepository cadreRepository;
    @EJB private SalleRepository salleRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateForm form = new CreateForm();
        Cadre cadre = new Cadre();

        req.setAttribute("form", form);
        req.setAttribute("cadre", cadre);
        req.setAttribute("fields", CadreField.values());
        req.getRequestDispatcher("/views/cadres/create.ftl").forward(req, resp);
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

            Salle salle = salleRepository.findByNom(req.getParameter(CadreField.BUREAU.getDbName()));
            cadre.setBureau(salle);
            cadreRepository.insert(cadre);

            resp.sendRedirect("/WebApp/");
            return;
        }
        System.out.println(form);
        req.getRequestDispatcher("/views/cadres/create.ftl").forward(req, resp);
    }
}
