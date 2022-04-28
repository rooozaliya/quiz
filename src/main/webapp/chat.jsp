<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chat</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style>
        *{
            margin: 0;
            padding: 0;
        }
        .rating {
            float: left;
            height: 46px;
            padding: 0 10px;
        }
        .rating:not(:checked) > input {
            position:absolute;
            top:-9999px;
        }
        .rating:not(:checked) > label {
            float:right;
            width:1em;
            overflow:hidden;
            white-space:nowrap;
            cursor:pointer;
            font-size:30px;
            color:#ccc;
        }
        .rating:not(:checked) > label:before {
            content: '★ ';
        }
        .rating > input:checked ~ label {
            color: #ffc700;
        }
        .rating:not(:checked) > label:hover,
        .rating:not(:checked) > label:hover ~ label {
            color: #deb217;
        }
        .rating > input:checked + label:hover,
        .rating > input:checked + label:hover ~ label,
        .rating > input:checked ~ label:hover,
        .rating > input:checked ~ label:hover ~ label,
        .rating > label:hover ~ input:checked ~ label {
            color: #c59b08;
        }
        input[type=text], select, textarea {
            width: 100%; /* Full width */
            padding: 12px; /* Some padding */
            border: 1px solid #ccc; /* Gray border */
            border-radius: 4px; /* Rounded borders */
            box-sizing: border-box; /* Make sure that padding and width stays in place */
            margin-top: 6px; /* Add a top margin */
            margin-bottom: 16px; /* Bottom margin */
            resize: vertical /* Allow the user to vertically resize the textarea (not horizontally) */
        }

        /* Style the submit button with a specific background color etc */
        input[type=submit] {
            background-color: #04AA6D;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        /* When moving the mouse over the submit button, add a darker green color */
        input[type=submit]:hover {
            background-color: #45a049;
        }

        /* Add a background color and some padding around the form */
        .container {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }
        /* Modified from: https://github.com/mukulkant/Star-rating-using-pure-css */
    </style>
</head>
<body>
<jsp:include page="nav.jsp" flush="true" />
<div class="container">
  <table>
                        <thead>
                        <th>UserName</th>
                        </thead>
                        <c:forEach items="${listChats}" var="chat">
                          <tr>
                            <td><c:out value="${chat.getDescription()}"/></td>
                          </tr>
                        </c:forEach>
        </table>

    <form action="${pageContext.request.contextPath}/chat" method="POST"">
      <input type="hidden" name="userId" value="1" />
        <br>
        <h3>Ваш комментарий:</h3>
        <textarea id="description" name="description" placeholder="Напишите что-нибудь.." style="height:200px"></textarea>

        <input type="submit" value="Отправить">

    </form>


</div>
</body>
</html>
