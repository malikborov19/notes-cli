package com.example;

import java.io.*;
import java.util.*;

public class NotesStore {

    private static final String FILE_PATH = "data/notes.csv";

    public static void add(String text) throws IOException {
        File file = new File(FILE_PATH);
        file.getParentFile().mkdirs();

        int nextId = getNextId();

        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(nextId + ";" + text + "\n");
        }
    }

    public static List<String> list() throws IOException {
        File file = new File(FILE_PATH);
        List<String> notes = new ArrayList<>();

        if (!file.exists()) {
            return notes;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                notes.add(line);
            }
        }

        return notes;
    }

    private static int getNextId() throws IOException {
        List<String> notes = list();
        if (notes.isEmpty()) {
            return 1;
        }
        String last = notes.get(notes.size() - 1);
        return Integer.parseInt(last.split(";")[0]) + 1;
    }
}
