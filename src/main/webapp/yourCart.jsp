<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
  <head>
    <title>CD Shop</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
  </head>
  <body>
        <h1>Your cart</h1>
        <table>
            <tr>
                <th>Quantity</th>
                <th>Description</th>
                <th>Price</th>
                <th>Amount</th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${sessionScope.cart.items}">
            <tr>
                <td>
                    <form action="" method="post">
                        <input type="hidden" name="productCode" value="${item.product.productCode}">
                        <input type="number" name="quantity" value="${item.quantity}">
                        <input type="submit" value="Update">
                    </form>
                </td>
                <td>${item.product.description}</td>
                <td>${item.product.priceCurrencyFormat}</td>
                <td>${item.totalCurrencyFormat}</td>
                <td>
                    <form action="" method="post">
                        <input type="hidden" name="productCode" value="<c:out value='${item.product.productCode}'/>">
                        <input type="hidden" name ="quantity" value="0">
                        <input type="submit" value="Remove Item">
                    </form>
                </td>
            </tr>
            </c:forEach>
        </table>

        <c:choose>
            <c:when test ="${cart.count == 0}">
                <p>Your cart is empty.</p>
            </c:when>
            <c:when test ="${cart.count == 1}">
                <p>You have 1 item in your cart.</p>
            </c:when>
            <c:otherwise>
                <p>You have ${cart.count} items in your cart.</p>
            </c:otherwise>
        </c:choose>
        <p><b>Total:</b> <i>${cart.total}$<i></p>
        <p><b>To change the quantity</b>, enter the new quantity and click on the Update button</p>
        <form action="" method="post">
            <input type="hidden" name="action" value="shop">
            <input type="submit" value="Continue Shopping">
        </form>
        <form action="" method="post">
               <input type="hidden" name="action" value="checkOut">
               <input type="submit" value="Check out">
        </form>
  </body>
</html>
