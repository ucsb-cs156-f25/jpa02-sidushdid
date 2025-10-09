package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_correct_value(){
        assertEquals(true, team.equals(team));
        assertEquals(false, team.equals("thing"));
        Team otherTeam = new Team("test-team");
        assertEquals(true, team.equals(otherTeam));
        otherTeam.setMembers(new ArrayList<String>(Arrays.asList("Chris G.")));
        assertEquals(false, team.equals(otherTeam));
        otherTeam.setName("expected-failure");
        assertEquals(false, team.equals(otherTeam));
        otherTeam.setMembers(new ArrayList<String>());
        assertEquals(false, team.equals(otherTeam));
    }

    @Test
    public void hashCode_returns_correct_hash_code(){
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
        int result = team.hashCode();
        assertEquals(-1226298695, result);
    }
}
