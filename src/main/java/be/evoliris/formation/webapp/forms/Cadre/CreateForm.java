package be.evoliris.formation.webapp.forms.Cadre;

import be.evoliris.formation.webapp.models.beans.Cadre;
import be.evoliris.formation.webapp.models.enums.CadreField;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CreateForm {
    private String result;
    private Map<String, String> erreurs = new HashMap<>();

    public Cadre createCadre(HttpServletRequest request){
        Cadre cadre = new Cadre();

        CadreField[] cadreFields = CadreField.values();
        Map<CadreField, String> values = new HashMap<>();

        for(CadreField field : cadreFields){
            String value = getValueField(request, field);
            values.put(field, value);
        }

        for(Map.Entry<CadreField,String> entry : values.entrySet()){
            try{
                validation(entry.getKey(), entry.getValue());
                cadre.addField(entry.getKey(), entry.getValue());
            }catch (Exception e){
                addErreur(entry.getKey(), e.getMessage());
            }
        }

        if(erreurs.size() != 0){
            result = "Création échouée !";
        }else{
            result = "Création réussie !";
        }

        return  cadre;
    }

    private void addErreur(CadreField key, String message) {
        this.erreurs.put(key.getDbName(), message);
    }

    public String getResult() {
        return result;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    private static void validation(CadreField key, String value) throws Exception{
        switch (key){
            case NOM:
                if(value == null)throw new Exception("Le nom est obligatoire");
                if(value.length() < 5)throw new Exception("Le nom doit être d'au moins 5 caractères");
                break;
            case PRENOM:
                if(value == null)throw new Exception("Le prenom est obligatoire");
                if(value.length() < 5)throw new Exception("Le prenom doit être d'au moins 5 caractères");
                break;
            case ADRESSE:
                if(value != null && !value.equals("") && value.length() < 5)throw new Exception("L'adresse doit faire plus de 5 caractères");
                break;
            case SALAIRE:
                if(value == null)throw new Exception("Le salaire du cadre est obligatoire");
                if(Double.parseDouble(value) < 1500D)throw new Exception("Le salaire du cadre doit être supérieur à 1500");
                break;
            case DATE_ENTRE_FONCTION:
                if(value == null)throw new Exception("La date est obligatoire");
                if(!value.matches("\\d+-\\d+-\\d+"))throw new Exception("La doit doit être au format yyyy-MM-dd");
                break;
            default: break;
        }
    }

    private static String getValueField(HttpServletRequest request, CadreField field){
        return request.getParameter(field.getDbName());
    }

    @Override
    public String toString() {
        return "CreateForm{" +
                "result='" + result + '\'' +
                ", erreurs=" + erreurs +
                '}';
    }
}
