package org.exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Superhero> superHeroes = new ArrayList<Superhero>();


    public static void readFile(String fileName) throws IOException {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));

            String currentLine = reader.readLine();

            while (currentLine != null) {
                Superhero superhero = new Superhero();
                String[] data = currentLine.split(",");
                superhero.setSuperheroName(data[0]);
                superhero.setRealName(data[1]);
                superhero.setPlaceOfBirth(data[2]);
                superHeroes.add(superhero);
                currentLine = reader.readLine();
            }
        } finally {
            assert reader != null;
            reader.close();
        }
    }

    // TODO write to a text file
    public static void writeFile(String fileName, String name, String result) throws IOException {

    }

    // TODO write the code so the user can play the game
    public static String playGame() {
        return "";
    }

    public static void main(String[] args) {
        try {
            readFile("input.txt");
        } catch (IOException e) {
            System.out.println("Error while reading the file: " + e.getMessage());
        }

        // sanity check
        for (int i = 0; i < superHeroes.size(); i++) {
            System.out.println(superHeroes.get(i).getSuperheroName());
        }

        // TODO read the data from the user

        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = userInput.nextLine();

        // TODO start playing the game

        // TODO write the results to the file
    }
}
