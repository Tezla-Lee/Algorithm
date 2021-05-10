package minimum_cost_to_move_chips_to_the_same_position;

/**
 * https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
 */
class Solution {
    public int minCostToMoveChips(int[] position) {
        int evenCount = 0;

        for (int pos : position) {
            if (pos % 2 == 0) {
                evenCount++;
            }
        }

        return Math.min(evenCount, position.length - evenCount);
    }
}