<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <h1 style="color: red;text-align: center;">List of Download files</h1>
    
    <c:choose>
    	<c:when test="${!empty filesList }">
    		<table align="center" border="1" style="background: fuchsia;">
    			<tr>
    				<th>File Name</th><th>Operation</th>
    			</tr>
    			<c:forEach var="file" items="${fileList}">
    				<tr>
    					<td> ${file} </td>
    					<td><a href="download.htm?fname=${file}">DownLoad</a></td>
    				</tr>
    			</c:forEach>
    		</table>
    	</c:when>
    	<c:otherwise>
    		<h1 style="color: red;text-align: center;">No Files are found</h1>
    	</c:otherwise>
    </c:choose>