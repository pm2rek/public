package com.pm2rek.battle;

import java.util.List;

public class Recursion {

	static void GeneratePermutations(List<List<String>> Lists, List<String> result, int depth, String current) {
		if (depth == Lists.size()) {
			result.add(current);
			return;
		}

		for (int i = 0; i < Lists.get(depth).size(); ++i) {
			GeneratePermutations(Lists, result, depth + 1, current + Lists.get(depth).get(i));
		}
	}

}
