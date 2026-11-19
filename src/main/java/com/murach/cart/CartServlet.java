package com.murach.cart;

import com.murach.business.Cart;
import com.murach.business.Product;
import com.murach.business.Item;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class CartServlet extends HttpServlet {
    Product[] ALL_PRODUCTS = {
            new Product("001", "86 (the band) - True Life Songs and Pictures", 14.95f),
            new Product("002", "Paddlefoot - The first CD", 12.95f),
            new Product("003", "Paddlefoot - The second CD", 14.95f),
            new Product("004", "Joe Rut - Genuine Wood Grained Finish", 12.95f)
    };

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/index.html";
        String action = request.getParameter("action");
        if(action == null) {
            action = "cart";
        }

        if (action.equals("shop")) {
            url = "/index.html";
        }
        else if (action.equals("cart")) {
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");

            String quantityStr = request.getParameter("quantity");
            String productCode = request.getParameter("productCode");

            int quantity;
            try {
                quantity = Integer.parseInt(quantityStr);
                if (quantity < 0) {
                    quantity = 1;
                }
            } catch (NumberFormatException nfe) {
                quantity = 1;
            }

            if (cart == null) {
                cart = new Cart();
            }

            Product product = null;
            for (Product p:ALL_PRODUCTS) {
                if (p.getProductCode().equals(productCode)) {
                    product = p;
                    break;
                }
            }

            Item newItem = new Item();
            newItem.setQuantity(quantity);
            newItem.setProduct(product);

            if (quantity > 0) {
                cart.addItem(newItem);
            } else if (quantity == 0) {
                cart.removeItem(newItem);
            }
            session.setAttribute("cart", cart);
            url = "/yourCart.jsp";
        } else if (action.equals("checkOut")) {
            url = "/checkOut.jsp";
        } else if (action.equals("back")) {
            HttpSession session = request.getSession();
            session.removeAttribute("cart");
            url = "/index.html";
        }

        getServletContext()
                .getRequestDispatcher(url).forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
