package Quest;

import Quest.Rooms.RandomRoomGenerator;
import Quest.Rooms.Room;

import java.util.ArrayList;

public class Quest {
    private ArrayList<Room> rooms;
    private RandomRoomGenerator roomGenerator;
//    private int questDifficulty;

    public Quest(){
        this.rooms = new ArrayList<Room>();
        this.roomGenerator = new RandomRoomGenerator();
//        this.questDifficulty = questDifficulty;
    }

    public void generateQuest(int questDifficulty){
        if (questDifficulty == 1){
            this.generateEasyQuest(questDifficulty);
        } else if (questDifficulty == 2){
            this.generateMediumQuest();
        } else {
            generateHardQuest();
        }
    }

    private void generateEasyQuest(int questDifficulty) {
        int roomDifficulty = 0;
        for (int i = questDifficulty * 2; i > 0; i--) {
            roomDifficulty += 1;
            for (int j = 0; j < 3; j++) {
                this.rooms.add(roomGenerator.generateRoom(roomDifficulty));
            }
        }
    }

    private void generateMediumQuest() {

    }

    private void generateHardQuest() {

    }
}
