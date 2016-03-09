<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><tiles:getAsString name="title" /></title>
</head>
<body>
<div class="container-fluid fill">
    <tiles:insertAttribute name="navbar" />
    <br><br>
    <tiles:insertAttribute name="body" />
    <br><br>
    <tiles:insertAttribute name="footer" />
</div>
</body>
</html>