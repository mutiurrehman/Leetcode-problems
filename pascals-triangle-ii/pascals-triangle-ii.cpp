class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<int> result(rowIndex + 1, 1);
        long current_multiplier = 1;
        for (int n = 1; n <= rowIndex / 2; ++n) {
            current_multiplier *= (rowIndex - n + 1);
            current_multiplier /= n;
            result[n] = current_multiplier;
        }
        for (int n = rowIndex / 2 + 1; n < rowIndex; ++n) {
            result[n] = result[rowIndex - n];
        }
        return result;
    }
};