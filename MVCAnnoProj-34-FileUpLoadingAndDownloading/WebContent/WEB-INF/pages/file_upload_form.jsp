<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
    <h1 style="color: red;text-align: center;">File UpLoading</h1>
    
    <form:form modelAttribute="uplCmd" enctype="multipart/form-data">
    Select File1::<input type="file" name="file1"/><br><br>
    Select File2::<input type="file" name="file2"><br><br>
    				<input type="submit" value="Upload">
    </form:form>