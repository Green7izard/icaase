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

    @Test
    public void testSortEnMasse(){
        Match a = new Match(null, -1);
        Match b = new Match(null, 2);
        Match c = new Match(null, 3);
        Match d = new Match(null, 4);
        Match e = new Match(null, 5);
        Match f = new Match(null, 6);
        Match g = new Match(null, 7);
        Match h = new Match(null, 8);
        Match i = new Match(null, 9);
        Match j = new Match(null, 10);
        List<Match> toSort = new ArrayList<Match>(10);
        toSort.add(c);
        toSort.add(a);
        toSort.add(j);
        toSort.add(h);
        toSort.add(b);
        toSort.add(e);
        toSort.add(i);
        toSort.add(f);
        toSort.add(d);
        toSort.add(g);
        Collections.sort(toSort);
        Assert.assertEquals(j, toSort.get(0));
        Assert.assertEquals(i, toSort.get(1));
        Assert.assertEquals(h, toSort.get(2));
        Assert.assertEquals(g, toSort.get(3));
        Assert.assertEquals(f, toSort.get(4));
        Assert.assertEquals(e, toSort.get(5));
        Assert.assertEquals(d, toSort.get(6));
        Assert.assertEquals(c, toSort.get(7));
        Assert.assertEquals(b, toSort.get(8));
        Assert.assertEquals(a, toSort.get(9));
    }
}
