package be.evoliris.formation.webapp.models.enums;

public enum CadreField {
    NOM("pers_nom", "nom du cadre", "text", false),
    PRENOM("pers_prenom", "prenom du cadre", "text", false),
    SALAIRE("pers_salaire", "salaire du cadre", "number", false),
    ADRESSE("pers_adresse", "domicile du cadre", "text", true),
    DATE_ENTRE_FONCTION("pers_dateEmploi", "date d'entrée en fonction", "date", false),
    BUREAU("cadre_bureau", "nom du bureau", "text", true);

    private String dbName;
    private String formatName;
    private String inputType;
    private boolean isOptional;

    private CadreField(String dbName, String formatName, String inputType, boolean isOptional) {
        this.dbName = dbName;
        this.formatName = formatName;
        this.inputType = inputType;
        this.isOptional = isOptional;
    }

    public String getDbName() {
        return dbName;
    }

    public String getFormatName() {
        return formatName;
    }

    public String getInputType() {
        return inputType;
    }

    public boolean isOptional() {
        return isOptional;
    }
}
