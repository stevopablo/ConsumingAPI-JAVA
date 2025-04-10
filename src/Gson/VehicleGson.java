package Gson;

import Model.Vehicle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class VehicleGson {
    public static void main(String[] args) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter fileWriter = new FileWriter("Cars.json");

        Vehicle toyota = new Vehicle("corolla", "toyota", "2020", "120000");

        String gsonCorolla = gson.toJson(toyota);
        System.out.println("gsonCorolla = " + gsonCorolla);
        fileWriter.write(gsonCorolla);
        fileWriter.close();
    }
}
