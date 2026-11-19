<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>CD Shop</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
    <h1>Check Out</h1>

    <c:choose>
        <c:when test="${empty sessionScope.cart.items}">
            <p>Your cart is currently empty.</p>
        </c:when>
        <c:otherwise>
            <p>Thank you for your order! Here is your order summary:</p>
            <table>
                <tr>
                    <th>Quantity</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Amount</th>
                </tr>
                <c:forEach var="item" items="${sessionScope.cart.items}">
                <tr>
                    <td>${item.quantity}</td>
                    <td>${item.product.description}</td>
                    <td>${item.product.priceCurrencyFormat}</td>
                    <td>${item.totalCurrencyFormat}</td>
                </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
    <p><b>Total:</b> <i>${cart.total}$<i></p>
    <form action="" method="post">
        <input type="hidden" name="action" value="back">
        <input type="submit" value="Back to shop">
    </form>
</body>
</html>