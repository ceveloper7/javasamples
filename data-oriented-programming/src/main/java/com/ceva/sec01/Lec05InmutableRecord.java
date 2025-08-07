package com.ceva.sec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Lec05InmutableRecord {

    private static final Logger log = LoggerFactory.getLogger(Lec05InmutableRecord.class);

    public record Team(String name, List<String> members){
        // compact constructor
        public Team{
            // copy members list in a new object reference list
            members = List.copyOf(members);
        }
    }

    public static void main(String[] args) {
        var members = new ArrayList<String>();

        members.add("Sam");
        members.add("Mike");

        var team = new Team("dev team", members);
        log.info("{}", team);

        members.add("Jack");
        log.info("{}", team);
    }
}
