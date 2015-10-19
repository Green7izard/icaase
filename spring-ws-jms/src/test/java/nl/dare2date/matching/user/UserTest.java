package nl.dare2date.matching.user;

import nl.dare2date.matching.interests.Interest;
import nl.dare2date.matching.interests.InterestType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Bas on 15-10-2015.
 */
public class UserTest {

    @Test
    public void testMatch100(){
        User user1= new User();
        User user2= new User();
        Interest int1 = new Interest();
        int1.setName("test1");
        int1.setType(InterestType.OTHER);
        Interest int2 = new Interest();
        int2.setName("test2");
        int2.setType(InterestType.OTHER);
        Interest int3 = new Interest();
        int3.setName("test3");
        int3.setType(InterestType.OTHER);
        List<Interest> lijst = new ArrayList<Interest>(3);
        lijst.add(int1);
        user1.setInterests(lijst);
        user2.setInterests(new ArrayList<Interest>(0));
        assertEquals(0, user1.match(user2).toOrchestration().getScore());
        user2.setInterests(lijst);
        assertEquals(100, user1.match(user2).toOrchestration().getScore());
        assertEquals(100, user2.match(user1).toOrchestration().getScore());
        lijst.add(int2);
        assertEquals(100, user1.match(user2).toOrchestration().getScore());
        assertEquals(100, user2.match(user1).toOrchestration().getScore());
        lijst.add(int3);
        assertEquals(100, user1.match(user2).toOrchestration().getScore());
        assertEquals(100, user2.match(user1).toOrchestration().getScore());
    }

    @Test
    public void testMatch50(){
        User user1= new User();
        User user2= new User();
        Interest int1 = new Interest();
        int1.setName("test1");
        int1.setType(InterestType.OTHER);
        Interest int2 = new Interest();
        int2.setName("test2");
        int2.setType(InterestType.OTHER);
        Interest int3 = new Interest();
        int3.setName("test3");
        int3.setType(InterestType.OTHER);
        List<Interest> lijst = new ArrayList<Interest>(2);
        List<Interest> lijst2 = new ArrayList<Interest>(2);
        lijst.add(int1);
        lijst2.add(int3);
        user1.setInterests(lijst);
        user2.setInterests(lijst2);
        assertEquals(0, user1.match(user2).toOrchestration().getScore());
        assertEquals(0, user2.match(user1).toOrchestration().getScore());
        lijst.add(int2);
        assertEquals(0, user1.match(user2).toOrchestration().getScore());
        assertEquals(0, user2.match(user1).toOrchestration().getScore());
        lijst2.add(int2);
        assertEquals(50, user1.match(user2).toOrchestration().getScore());
        assertEquals(50, user2.match(user1).toOrchestration().getScore());
    }
}
