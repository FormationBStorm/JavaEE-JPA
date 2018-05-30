<#macro layout title="" js="">
<!doctype html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${title} - WebApp</title>
    <script type="application/javascript" src="/WebApp/public/js/jquery/jquery-3.1.js"></script>
    <script type="application/javascript" src="/WebApp/public/js/bootstrap/bootstrap.min.js"></script>

    <link type="text/css" rel="stylesheet" href="/WebApp/public/css/bootstrap/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <#nested />
    </div>

    ${js}
</body>
</html>
</#macro>