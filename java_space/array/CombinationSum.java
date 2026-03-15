package array;

import java.util.ArrayList;
import java.util.List;

class CombinationSum {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> path) {

        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (target < 0) return;

        for (int i = start; i < candidates.length; i++) {

            path.add(candidates[i]);

            backtrack(candidates, target - candidates[i], i, path);

            path.remove(path.size() - 1);
        }
    }
}