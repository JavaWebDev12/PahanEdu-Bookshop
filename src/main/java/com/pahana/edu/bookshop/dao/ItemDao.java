package com.pahana.edu.bookshop.dao;

import com.pahana.edu.bookshop.model.Item;
import com.pahana.edu.bookshop.util.DataStore;

import javax.servlet.ServletContext;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ItemDao {
    private final ServletContext context;

    public ItemDao(ServletContext context) {
        this.context = context;
    }

    public synchronized List<Item> findAll() {
        List<Item> list = new ArrayList<>();
        File file = DataStore.resolveDataFile(context, DataStore.ITEMS_FILE);
        ensureSeedData(file);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;
                String[] p = line.split(",");
                if (p.length >= 3) {
                    list.add(new Item(p[0], p[1], Double.parseDouble(p[2])));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read items", e);
        }
        return list;
    }

    public synchronized Item findById(String id) {
        return findAll().stream().filter(i -> i.getId().equals(id)).findFirst().orElse(null);
    }

    public synchronized void save(Item item) {
        List<Item> all = findAll();
        Optional<Item> existing = all.stream().filter(i -> i.getId().equals(item.getId())).findFirst();
        if (existing.isPresent()) {
            int idx = -1;
            for (int i = 0; i < all.size(); i++) {
                if (all.get(i).getId().equals(item.getId())) { idx = i; break; }
            }
            if (idx >= 0) all.set(idx, item);
        } else {
            all.add(item);
        }
        writeAll(all);
    }

    public synchronized void delete(String id) {
        List<Item> all = findAll();
        all.removeIf(i -> i.getId().equals(id));
        writeAll(all);
    }

    private void writeAll(List<Item> items) {
        File file = DataStore.resolveDataFile(context, DataStore.ITEMS_FILE);
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false), StandardCharsets.UTF_8))) {
            writer.write("# id,name,unitPrice\n");
            for (Item i : items) {
                writer.write(String.join(",",
                        escape(i.getId()),
                        escape(i.getName()),
                        Double.toString(i.getUnitPrice())));
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to write items", e);
        }
    }

    private void ensureSeedData(File file) {
        if (file.exists()) return;
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {
            writer.write("# id,name,unitPrice\n");
            writer.write("ITM-001,Notebook,250.0\n");
            writer.write("ITM-002,Pen,50.0\n");
            writer.write("ITM-003,Textbook,1200.0\n");
        } catch (IOException e) {
            throw new RuntimeException("Failed to seed items", e);
        }
    }

    private String escape(String s) {
        if (s == null) return "";
        return s.replace(",", " ").trim();
    }
}

