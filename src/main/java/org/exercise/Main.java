package org.exercise;

import java.io.*;
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
    public static void writeFile(String fileName, String name, int score) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        BufferedWriter buffer = new BufferedWriter(writer);
        buffer.write(name + " scored " + score + "/" + superHeroes.size());
        buffer.close();
    }

    // TODO write the code so the user can play the game
    public static int playGame(Scanner scanner) {
        int correct = 0;
        int numQuestions = superHeroes.size();
        int currQuestionIdx = 0;

        while (currQuestionIdx < superHeroes.size()) {
            System.out.println();
            String answer = getUserInput("What is " + superHeroes.get(currQuestionIdx).getSuperheroName() + "'s secret identity?", scanner);
            System.out.println(answer + " was entered.");
            if (answer.equalsIgnoreCase(superHeroes.get(currQuestionIdx).getRealName())) {
                correct++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect!");
            }
            currQuestionIdx++;
            if (currQuestionIdx < superHeroes.size()) {
                System.out.println("Your current score is " + correct + "/" + superHeroes.size());
            } else {
                System.out.println("Your final score is " + correct + "/" + superHeroes.size());
            }

        }
        return correct;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        try {
            readFile("input.txt");
        } catch (IOException e) {
            System.out.println("Error while reading the file: " + e.getMessage());
        }

        // sanity check
//        for (int i = 0; i < superHeroes.size(); i++) {
//            System.out.println(superHeroes.get(i).getSuperheroName());
//        }

        // TODO read the data from the user
        String name = getUserInput("Please enter your name: ", scanner);

        // TODO start playing the game
        int score;
        score = playGame(scanner);

        // TODO write the results to the file
        writeFile("output.txt", name, score);
        scanner.close();
    }

    public static String getUserInput(String question, Scanner scanner) {
        System.out.print(question);
        String userInput = scanner.nextLine();
        return userInput;
    }
}
