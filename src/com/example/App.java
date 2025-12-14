package com.example;

public class App {

    public static void main(String[] args) {
        String cmd = null;
        String text = null;

        for (String arg : args) {
            if (arg.startsWith("--cmd=")) {
                cmd = arg.substring(6);
            }
            if (arg.startsWith("--text=")) {
                text = arg.substring(7).replace("\"", "");
            }
        }

        try {
            if ("add".equals(cmd)) {
                NotesStore.add(text);
            } else if ("list".equals(cmd)) {
                var notes = NotesStore.list();
                if (notes.isEmpty()) {
                    System.out.println("(empty)");
                } else {
                    notes.forEach(System.out::println);
                }
            } else {
                System.out.println("Unknown command");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
