package com.pahana.edu.bookshop.web;

import com.pahana.edu.bookshop.dao.CustomerDao;
import com.pahana.edu.bookshop.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";
        CustomerDao dao = new CustomerDao(getServletContext());

        switch (action) {
            case "create":
                req.setAttribute("customer", new Customer());
                req.setAttribute("mode", "create");
                req.getRequestDispatcher("/customer_form.jsp").forward(req, resp);
                return;
            case "edit":
                String acc = req.getParameter("accountNumber");
                Customer c = dao.findByAccount(acc);
                req.setAttribute("customer", c);
                req.setAttribute("mode", "edit");
                req.getRequestDispatcher("/customer_form.jsp").forward(req, resp);
                return;
            case "view":
                String account = req.getParameter("accountNumber");
                Customer customer = dao.findByAccount(account);
                req.setAttribute("customer", customer);
                req.getRequestDispatcher("/customer_view.jsp").forward(req, resp);
                return;
            case "delete":
                String id = req.getParameter("accountNumber");
                if (id != null) dao.delete(id);
                resp.sendRedirect(req.getContextPath() + "/customers");
                return;
            case "list":
            default:
                List<Customer> customers = dao.findAll();
                req.setAttribute("customers", customers);
                req.getRequestDispatcher("/customers.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accountNumber = req.getParameter("accountNumber");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String telephone = req.getParameter("telephone");
        int units = 0;
        try { units = Integer.parseInt(req.getParameter("unitsConsumed")); } catch (Exception ignored) {}

        CustomerDao dao = new CustomerDao(getServletContext());
        dao.save(new Customer(accountNumber, name, address, telephone, units));
        resp.sendRedirect(req.getContextPath() + "/customers");
    }
}

