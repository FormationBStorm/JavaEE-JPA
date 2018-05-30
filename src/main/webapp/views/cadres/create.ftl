<#import "../layout.ftl" as Main>
<@Main.layout "Create - Cadre" "">
<form method="post" action="/WebApp/cadres/create">
    <#list fields as field>
        <div class="form-group">
            <label for="${field.dbName}">${field.formatName}</label>
            <#if field.optional>
                <input type="${field.inputType}" class="form-control" id="${field.dbName}" name="${field.dbName}">
            <#else>
                <input type="${field.inputType}" class="form-control" id="${field.dbName}" name="${field.dbName}" required>
            </#if>
            <#if (form.erreurs)??>
                <span class="error">${(form.erreurs[field.dbName])!}</span>
            </#if>
        </div>
    </#list>

    <div class="form-group">
        <button type="submit" class="btn btn-lg btn-primary">Créer un cadre</button>
    </div>
</form>
</@Main.layout>