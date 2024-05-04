<%@ page import="java.util.Random" %>

<!DOCTYPE html>
<html>
<head>
    <title>Addition Quiz</title>
</head>
<body>
    <h2>Addition Quiz</h2>

    <form action="quizResult.jsp" method="post">
        <% 
            Random rand = new Random();
            int num1 = rand.nextInt(10) + 1;
            int num2 = rand.nextInt(10) + 1;
            int answer = num1 + num2;
            session.setAttribute("answer", answer);
        %>
        <p>What is <%= num1 %> + <%= num2 %>?</p>
        <input type="text" name="userAnswer" required>
        <br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
