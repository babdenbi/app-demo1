<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix ="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page d'authentification</title>
</head>
<body>

<div>
<s:form action ="authentication">

<s:actionerror/>


<s:textfield name ="userName" label = "Login" >
<s:fielderror/>
</s:textfield>
<s:password name ="pwd" label = "Mot de passe" >
<s:fielderror/>
</s:password>

<s:submit type="submit" value = "Se connecter" />
<s:reset  value = "Annuler" />

</s:form>

</div>

</body>
</html>