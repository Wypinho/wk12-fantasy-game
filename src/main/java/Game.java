import Players.Healer.Cleric;
import Players.MeleeFighter.Knight;
import Players.Player;
import Quest.Quest;
import Quest.Rooms.Room;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Game {
    private ArrayList<Player> players;
    Scanner scanner;
    Quest quest;

    public Game(){
        this.players = new ArrayList<Player>();
        scanner = new Scanner(System.in);
        quest = new Quest();
    }

    public void playGame(){
        System.out.println("Welcome to Dragons & Dungeons!");
        this.playerSetUp();
        this.gameSetUp();
        for (int i = 0; i < quest.roomCount(); i++){
            Room currentRoom = quest.getCurrentRoom(i);
            this.enterRoom(currentRoom);
            this.describeRoom();
        }
    }

    private void describeRoom() {
    }

    private void enterRoom(Room currentRoom) {
        currentRoom.populateRoom(this.players);
    }

    private void gameSetUp() {
        System.out.println("Select thy difficulty level: Easy, Medium or Hard?");

        String difficultySelection = scanner.next();
        String difficulty = difficultySelection;

        if (difficultySelection.equals("Easy")){
            quest.generateQuest(1);
        } else if (difficultySelection.equals("Medium")){
            quest.generateQuest(2);
        } else if (difficultySelection.equals("Hard")){
            quest.generateQuest(3);
        }
    }

    private void playerSetUp() {
        System.out.println("How many shall brave the dungeon?");

        String input = scanner.next();
        int players = parseInt(input);

        for(int i = 0; i < players; i++){
            String namePrompt = String.format("Player %s, enter your name: ", (i + 1));
            System.out.println(namePrompt);
            String playerName = scanner.next();

            String classPrompt = String.format("Player %s, select your class: ", (i + 1));
            System.out.println(classPrompt);
            System.out.println("Select Knight or Cleric?");
            String playerClass = scanner.next();

            this.addPlayer(playerName, playerClass);
        }
    }

//    made public for testing access
    public void addPlayer(String playerName, String playerClass) {
        if (playerClass.equals("Knight")){
            Player player = new Knight(playerName);
            this.players.add(player);
        } else if (playerClass.equals("Cleric")){
            Player player = new Cleric(playerName);
            this.players.add(player);
        }
    }

    public int playerCount() {
        return this.players.size();
    }
}
