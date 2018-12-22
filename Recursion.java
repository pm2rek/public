package com.pm2rek.recursion;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Recursion {

	void GeneratePermutations(List<List<String>> Lists, List<String> result, int depth, String current) {
		if (depth == Lists.size()) {
			result.add(current);
			return;
		}

		for (int i = 0; i < Lists.get(depth).size(); ++i) {
			GeneratePermutations(Lists, result, depth + 1, current + Lists.get(depth).get(i));
		}
	}

	public static void main(String[] args) {
		List<String> s1 = new ArrayList<>();
		List<String> s2 = new ArrayList<>();
		List<String> s3 = new ArrayList<>();
		List<String> res = new ArrayList<>();

		for (int i = 0; i <= 100; i+=5) {
			String tmp = String.valueOf(i);
			s1.add(tmp + ",");
			s2.add(tmp + ",");
			s3.add(tmp + ",");
		}
		List<List<String>> sAll = new ArrayList<>();
		sAll.add(s1);
		sAll.add(s2);
		sAll.add(s3);

		Recursion dupa = new Recursion();
		dupa.GeneratePermutations(sAll, res, 0, "");
		List<String> combinations = new ArrayList<>();

		for (String list : res) {
			String[] temp = list.split(",");

			Integer sum = Integer.valueOf(temp[0]) + Integer.valueOf(temp[1]) + Integer.valueOf(temp[2]);
			if (sum == 100) {
				combinations.add(list);
			}
		}
		System.out.println(combinations.size());
		
//		for (String string : combinations) {
//			System.out.println(string);
//		}
		
		List<List<String>> combo = new ArrayList<>();
		combo.add(combinations);
		combo.add(combinations);
		combo.add(combinations);
		List<String> result = new ArrayList<>();
		dupa.GeneratePermutations(combo, result, 0, "");
		System.out.println(result.size());
		
		List<String> scoreTable = new ArrayList<>();
		for (String string : result) {
			String[] temp = string.split(",");
			double score1 = (Double.valueOf(temp[0])+Double.valueOf(temp[3])+Double.valueOf(temp[6]))/((temp.length/3)*2);
			double score2 = (Double.valueOf(temp[1])+Double.valueOf(temp[4])+Double.valueOf(temp[7]))/((temp.length/3)*2);
			double score3 = (Double.valueOf(temp[2])+Double.valueOf(temp[5])+Double.valueOf(temp[8]))/((temp.length/3)*2);
			scoreTable.add(score1 +";"+score2+";"+score3);
//			if (score3>36&&score3<40) {
//				System.out.println(string);
//			}
		}
		
		List<String> publicScoreResult = new ArrayList<>();
		List<String> publicScore = new ArrayList<>();
		publicScore.add(";50.00;30.00;20.00;");
//		publicScore.add("50,00.20,00.30,00.");
//		publicScore.add("30,00.50,00.20,00.");
//		publicScore.add("30,00.20,00.50,00.");
//		publicScore.add("20,00.50,00.30,00.");
//		publicScore.add("20,00.30,00.50,00.");
		List<List<String>> publicScoreRec = new ArrayList<>();
		publicScoreRec.add(scoreTable);
		publicScoreRec.add(publicScore);
		
		dupa.GeneratePermutations(publicScoreRec, publicScoreResult, 0, "");
//		System.out.println(publicScoreResult.size());
//		System.out.println(publicScoreResult.get(1532));
//		for (String string : publicScoreResult) {
//			System.out.println(string);
//		}
		
		List<String> finalResults = new ArrayList<>();
		Integer countWin1=0, countWin2=0, countWin3=0;
		for (String string1 : publicScoreResult) {
			String[] temp = string1.split(";");
			double score1 = Double.valueOf(temp[0]) + Double.valueOf(temp[3]);
			double score2 = Double.valueOf(temp[1]) + Double.valueOf(temp[4]);
			double score3 = Double.valueOf(temp[2]) + Double.valueOf(temp[5]);
			if (score1>score2 && score1>score3) {
				countWin1++;
			} else if (score2>score1 && score2>score3) {
				countWin2++;
			} else if (score3>score1 && score3>score2) {
				countWin3++;
				//System.out.println(string1);
			} 
		}
		Integer sum = countWin1+countWin2+countWin3;
		Double win1Perc = Double.valueOf(countWin1)/sum;
		Double win2Perc = Double.valueOf(countWin2)/sum;
		Double win3Perc = Double.valueOf(countWin3)/sum;
		System.out.println("Win1 = "+countWin1+ "  in % = "+ win1Perc);
		System.out.println("Win2 = "+countWin2+ "  in % = "+ win2Perc);
		System.out.println("Win3 = "+countWin3+ "  in % = "+ win3Perc);
		System.out.println(sum);
	}

}
