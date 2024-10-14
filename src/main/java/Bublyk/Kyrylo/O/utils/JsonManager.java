package Bublyk.Kyrylo.O.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import Bublyk.Kyrylo.O.model.University;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class JsonManager {

    private Gson gson;

    public JsonManager() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    // Метод для запису об'єкта в JSON файл
    public void writeUniversityToFile(University university, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(university, writer);
        }
    }

    // Метод для зчитування JSON з файлу та перетворення в об'єкт University
    public University readUniversityFromFile(String filePath) throws IOException {
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, University.class);
        }
    }
}
