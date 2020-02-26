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

    public int roomCount() {
        return this.rooms.size();
    }

    public void generateQuest(int questDifficulty){
        int roomDifficulty = 0;
        for (int i = questDifficulty * 2; i > 0; i--) {
            roomDifficulty += 1;
            for (int j = 0; j < 2; j++) {
                this.rooms.add(roomGenerator.generateRoom(roomDifficulty));
            }
        }
    }

    public Room getCurrentRoom(int index) {
        return this.rooms.get(index);
    }

    public boolean lastRoom(Room room){
        return this.rooms.indexOf(room) == this.rooms.size() - 1;
    }
}
