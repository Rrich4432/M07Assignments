<%@ page import="java.io.*, java.util.*" %>

<%
    int userAnswer = Integer.parseInt(request.getParameter("userAnswer"));
    int answer = (int) session.getAttribute("answer");
    boolean isCorrect = userAnswer == answer;
%>

<!DOCTYPE html>
<html>
<head>
    <title>Quiz Result</title>
</head>
<body>
    <h2>Quiz Result</h2>
    <p>Your answer: <%= userAnswer %></p>
    <p>Correct answer: <%= answer %></p>
    <p><%= (isCorrect) ? "Congratulations! Your answer is correct." : "Sorry, your answer is incorrect." %></p>
</body>
</html>
