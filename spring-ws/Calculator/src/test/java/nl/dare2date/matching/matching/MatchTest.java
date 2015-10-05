package nl.dare2date.matching.matching;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Bas on 5-10-2015.
 */
public class MatchTest {
    @Test
    public void testCompare(){
        Match one = new Match(null, 1);
        Match two = new Match(null, 2);
        Assert.assertEquals(1, one.compareTo(two));
        Assert.assertEquals(-1, two.compareTo(one));
    }

    @Test
    public void testCompareEquals(){
        Match one = new Match(null, 1);
        Match two = new Match(null, 1);
        Assert.assertEquals(0, one.compareTo(two));
    }

    @Test
    public void testSort(){
        Match one = new Match(null, 1);
        Match two = new Match(null, 2);
        List<Match> toSort = new ArrayList<Match>(2);
        toSort.add(two);
        toSort.add(one);
        Collections.sort(toSort);
        Assert.assertEquals(two, toSort.get(0));
        Assert.assertEquals(one, toSort.get(1));
    }
    @Test
    public void testSort2(){
        Match one = new Match(null, 1);
        Match two = new Match(null, 2);
        List<Match> toSort = new ArrayList<Match>(2);
        toSort.add(one);
        toSort.add(two);
        Collections.sort(toSort);
        Assert.assertEquals(two, toSort.get(0));
        Assert.assertEquals(one, toSort.get(1));
    }
}
