<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
    <html>
      <head>
        <title>Neat App</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
      </head>
      <body>
        <h1>Neat</h1>
        <form action="/response" method="post">
          <label for="url">Enter Recipe URL:</label>
          <input type="text" id="url" name="url">
          <input type="submit" value="Submit" id="submit">
        </form>
      </body>
    </html>