package com.pm2rek.battle;

import java.util.ArrayList;
import java.util.List;

public class Jugde {

    public static List<List<String>> generateJudgeScore(int min,int max,int increment) {
        List<String> scoreRange = new ArrayList<>();
        List<String> possibilities = new ArrayList<>();
        List<List<String>> listScoreRange = new ArrayList<>();
        List<String> combination = new ArrayList<>();
        List<List<String>> combinations = new ArrayList<>();


        for (int i = min; i <= max; i+=increment) {
            String tmp = String.valueOf(i);
            scoreRange.add(tmp + ",");
        }

        listScoreRange.add(scoreRange);
        listScoreRange.add(scoreRange);
        listScoreRange.add(scoreRange);

        Recursion recursion = new Recursion();
        recursion.GeneratePermutations(listScoreRange, possibilities, 0, "");


        for (String list : possibilities) {
            String[] temp = list.split(",");

            Integer sum = Integer.valueOf(temp[0]) + Integer.valueOf(temp[1]) + Integer.valueOf(temp[2]);
            if (sum == 100) {
                combination.add(list);
            }
        }
        System.out.println(combination.size());
        combinations.add(combination);
        combinations.add(combination);
        combinations.add(combination);
        return combinations;
    }
}
