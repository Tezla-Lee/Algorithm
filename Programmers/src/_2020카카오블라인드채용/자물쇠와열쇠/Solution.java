package _2020카카오블라인드채용.자물쇠와열쇠;

class Solution {

    static int lockLength, keyLength;

    public boolean solution(int[][] key, int[][] lock) {
        keyLength = key.length;
        lockLength = lock.length;

        for (int i = 0; i < 4; i++) {

            // 열쇠 돌리고 패딩
            key = rotate(key);
            int[][] paddingKey = padding(key);

            // 자물쇠 이동
            for (int j = 1; j < keyLength + lockLength; j++) {
                for (int k = 1; k < keyLength + lockLength; k++) {

                    // 자물쇠 키 결합 확인
                    boolean flag = true;
                    for (int l = 0; l < lockLength; l++) {
                        for (int o = 0; o < lockLength; o++) {
                            if (lock[l][o] == paddingKey[l + j][o + k]) {
                                flag = false;
                                break;
                            }
                        }
                        if (!flag) {
                            break;
                        }
                    }

                    if (flag) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static int[][] rotate(int[][] arr) {
        int l = arr.length;
        int[][] rotateArr = new int[l][l];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                rotateArr[i][j] = arr[j][l - i - 1];
            }
        }
        return rotateArr;
    }

    static int[][] padding(int[][] key) {
        int[][] paddingArr = new int[keyLength + 2 * lockLength][keyLength + 2 * lockLength];
        for (int i = 0; i < keyLength; i++) {
            for (int j = 0; j < keyLength; j++) {
                paddingArr[i + lockLength][j + lockLength] = key[i][j];
            }
        }
        return paddingArr;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}));
    }
}