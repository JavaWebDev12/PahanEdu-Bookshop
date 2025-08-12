package com.pahana.edu.bookshop.dao;

import com.pahana.edu.bookshop.model.Customer;
import com.pahana.edu.bookshop.util.DataStore;

import javax.servlet.ServletContext;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class CustomerDao {
    private final ServletContext context;

    public CustomerDao(ServletContext context) {
        this.context = context;
    }

    public synchronized List<Customer> findAll() {
        List<Customer> list = new ArrayList<>();
        File file = DataStore.resolveDataFile(context, DataStore.CUSTOMERS_FILE);
        ensureSeedData(file);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;
                String[] p = line.split(",");
                if (p.length >= 5) {
                    list.add(new Customer(p[0], p[1], p[2], p[3], Integer.parseInt(p[4])));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read customers", e);
        }
        return list;
    }

    public synchronized Customer findByAccount(String accountNumber) {
        return findAll().stream()
                .filter(c -> c.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElse(null);
    }

    public synchronized void save(Customer customer) {
        List<Customer> all = findAll();
        Optional<Customer> existing = all.stream()
                .filter(c -> c.getAccountNumber().equals(customer.getAccountNumber()))
                .findFirst();
        if (existing.isPresent()) {
            // update
            int idx = -1;
            for (int i = 0; i < all.size(); i++) {
                if (all.get(i).getAccountNumber().equals(customer.getAccountNumber())) {
                    idx = i;
                    break;
                }
            }
            if (idx >= 0) {
                all.set(idx, customer);
            }
        } else {
            all.add(customer);
        }
        writeAll(all);
    }

    public synchronized void delete(String accountNumber) {
        List<Customer> all = findAll();
        all.removeIf(c -> c.getAccountNumber().equals(accountNumber));
        writeAll(all);
    }

    private void writeAll(List<Customer> customers) {
        File file = DataStore.resolveDataFile(context, DataStore.CUSTOMERS_FILE);
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false), StandardCharsets.UTF_8))) {
            writer.write("# accountNumber,name,address,telephone,unitsConsumed\n");
            for (Customer c : customers) {
                writer.write(String.join(",",
                        escape(c.getAccountNumber()),
                        escape(c.getName()),
                        escape(c.getAddress()),
                        escape(c.getTelephone()),
                        Integer.toString(c.getUnitsConsumed())));
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to write customers", e);
        }
    }

    private void ensureSeedData(File file) {
        if (file.exists()) return;
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {
            writer.write("# accountNumber,name,address,telephone,unitsConsumed\n");
            writer.write("CUST-1001,John Doe,10 Flower Rd,0771234567,75\n");
            writer.write("CUST-1002,Jane Smith,22 Palm Grove,0719876543,120\n");
        } catch (IOException e) {
            throw new RuntimeException("Failed to seed customers", e);
        }
    }

    private String escape(String s) {
        if (s == null) return "";
        return s.replace(",", " ").trim();
    }
}

