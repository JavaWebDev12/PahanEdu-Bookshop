package com.pahana.edu.bookshop.web;

import com.pahana.edu.bookshop.dao.ItemDao;
import com.pahana.edu.bookshop.model.Item;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";
        ItemDao dao = new ItemDao(getServletContext());

        switch (action) {
            case "create":
                req.setAttribute("item", new Item());
                req.setAttribute("mode", "create");
                req.getRequestDispatcher("/item_form.jsp").forward(req, resp);
                return;
            case "edit":
                String id = req.getParameter("id");
                Item item = dao.findById(id);
                req.setAttribute("item", item);
                req.setAttribute("mode", "edit");
                req.getRequestDispatcher("/item_form.jsp").forward(req, resp);
                return;
            case "delete":
                String delId = req.getParameter("id");
                if (delId != null) dao.delete(delId);
                resp.sendRedirect(req.getContextPath() + "/items");
                return;
            case "list":
            default:
                List<Item> items = dao.findAll();
                req.setAttribute("items", items);
                req.getRequestDispatcher("/items.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        double price = 0.0;
        try { price = Double.parseDouble(req.getParameter("unitPrice")); } catch (Exception ignored) {}

        ItemDao dao = new ItemDao(getServletContext());
        dao.save(new Item(id, name, price));
        resp.sendRedirect(req.getContextPath() + "/items");
    }
}

