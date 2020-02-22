package QuestTests;

import Quest.Quest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuestTest {
    Quest quest;

    @Before
    public void before(){
        quest = new Quest();
    }

    @Test
    public void easyQuestHas4Rooms(){
        quest.generateQuest(1);
        assertEquals(4, quest.roomCount());
    }

    @Test
    public void mediumQuestHas8Rooms(){
        quest.generateQuest(2);
        assertEquals(8, quest.roomCount());
    }

    @Test
    public void hardQuestHas12Rooms(){
        quest.generateQuest(3);
        assertEquals(12, quest.roomCount());
    }
}
