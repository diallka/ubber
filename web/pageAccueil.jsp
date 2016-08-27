<%-- 
    Document   : pageAccueil
    Created on : 24 juil. 2016, 16:20:12
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Page d'accueil</title>
    </head>
    <body >
        <div id="title">  <h1>Bienvenue sur Yaobber!<br>
            Site de services automobiles entre particuliers</h1>
                                                                 </div>
        
        <div id="map" > </div><br><br>
        <div id="details">
            <span style="font-size: 20px;color:blue">Conducteurs disponibles dans la region:</span>
        
        
        </div><br><br>
        
       <!-- <div id="panel" style="position: absolute;top: 750px;left: 920px;"></div>-->
        <div id="reponse" >${reponse}</div>
        


        <script src="app.js"></script>
        <script async defer
                src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBC95GpgAzzfx4qDEDw-_G76aMlpwtvoSc&callback=initMap">
        </script>
        
        <link rel="stylesheet" href="CSS/css1.css" />
        <script src="jquery-3.1.0.min.js"></script>
    </body>


</html>
