<#import "../layout.ftl" as Main>
<#assign js>
    <script>
        $(document).ready(function(){
            $("input:text").attr("placeholder", "blop");
        })
    </script>
</#assign>
<@Main.layout "Create - Cadre" js>
<form method="post" action="/WebApp/cadres/create">
    <#list fields as field>
        <div class="form-group row">
            <label for="${field.dbName}" class="col-xs-2 col-form-label">${field.formatName}<#if !(field.optional)>*</#if></label>
            <div class="col-xs-10">
            <#if field.optional>
                <input type="${field.inputType}" class="form-control" id="${field.dbName}" name="${field.dbName}" placeholder="">
            <#else>
                <input type="${field.inputType}" class="form-control" id="${field.dbName}" name="${field.dbName}" required>
            </#if>
            </div>
            <#if (form.erreurs)??>
                <span class="error col-xs-12">${(form.erreurs[field.dbName])!}</span>
            </#if>
        </div>
    </#list>

    <div class="form-group row">
        <button type="submit" class="btn btn-lg btn-primary">Créer un cadre</button>
    </div>
</form>
</@Main.layout>