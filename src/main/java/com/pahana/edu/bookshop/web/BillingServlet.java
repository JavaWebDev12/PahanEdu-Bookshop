package com.pahana.edu.bookshop.web;

import com.pahana.edu.bookshop.dao.CustomerDao;
import com.pahana.edu.bookshop.model.Customer;
import com.pahana.edu.bookshop.service.BillingService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BillingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerDao dao = new CustomerDao(getServletContext());
        List<Customer> customers = dao.findAll();
        req.setAttribute("customers", customers);
        req.getRequestDispatcher("/billing.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accountNumber = req.getParameter("accountNumber");
        CustomerDao dao = new CustomerDao(getServletContext());
        Customer c = dao.findByAccount(accountNumber);
        if (c == null) {
            req.setAttribute("error", "Customer not found");
            doGet(req, resp);
            return;
        }
        int units = c.getUnitsConsumed();
        double amount = BillingService.calculateAmount(units);
        req.setAttribute("customer", c);
        req.setAttribute("units", units);
        req.setAttribute("amount", amount);
        req.getRequestDispatcher("/bill_view.jsp").forward(req, resp);
    }
}

