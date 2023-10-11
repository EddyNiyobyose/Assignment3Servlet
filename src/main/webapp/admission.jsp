<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Admission</title>
</head>
<body>
<form action="admmision servlet" method="post" enctype="multipart/form-data">
    <label for="fullName">Full Name:</label>
        <input type="text" id="fullName" name="fullName" required><br><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        
        <label for="phone">Phone Number:</label>
        <input type="tel" id="phone" name="phone" required><br><br>
        
        <label for="passportPhoto">Student Passport Photo (jpg or png):</label>
        <input type="file" id="passportPhoto" name="passportPhoto" accept=".jpg, .png" required><br><br>
        
        <label for="diplomaCertificate">Diploma Certificate (PDF):</label>
        <input type="file" id="diplomaCertificate" name="diplomaCertificate" accept=".pdf" required><br><br>
        
        <input type="submit" value="Submit">
    </form>
</body>
</html>
