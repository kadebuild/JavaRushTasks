package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("D:\\Shared\\Programming\\Java\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task39\\task3913\\logs"));
        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
        System.out.println(logParser.getIPsForEvent(Event.LOGIN,null, new Date()));
        System.out.println(logParser.getIPsForStatus(Status.OK,null, new Date()));
        System.out.println(logParser.getIPsForUser("Vasya Pupkin", null, null));
        System.out.println(logParser.execute("get status for date = «30.01.2014 12:56:22″»"));
    }
}