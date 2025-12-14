package com.example;

public class App {

    public static void main(String[] args) {
        String cmd = null;
        String text = null;

        // Получаем аргументы
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
            } 
            // ====== НОВАЯ КОМАНДА RM ======
            else if ("rm".equals(cmd)) {
                int id = -1;
                for (String arg : args) {
                    if (arg.startsWith("--id=")) {
                        id = Integer.parseInt(arg.substring(5));
                    }
                }
                if (id == -1) {
                    System.out.println("ID not provided");
                } else {
                    boolean ok = NotesStore.remove(id);
                    if (ok) {
                        System.out.println("Removed #" + id);
                    } else {
                        System.out.println("Not found #" + id);
                    }
                }
            } 
            else {
                System.out.println("Unknown command");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
