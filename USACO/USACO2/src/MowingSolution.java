import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class MowingSolution
{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //set up the lawn, by first getting its worst-case dimensions
        int numOfSteps = Integer.parseInt(br.readLine());
        int[][] lawn = new int[numOfSteps * 10 + 1][numOfSteps * 10 + 1];

        int curr_r = numOfSteps / 2, curr_c = numOfSteps / 2;
        int t = 0;
        int tightest_dist = -1;

        for (int i = 0; i < numOfSteps; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String direction = st.nextToken();
            int stepVal = Integer.parseInt(st.nextToken());

            for (int j = 0; j < stepVal; j++) {
                if (direction == "N") {
                    if (lawn[curr_r][curr_c] != 0) {
                        int delta = t - lawn[curr_r][curr_c];
                        if (tightest_dist == -1 || delta < tightest_dist) {
                            tightest_dist = delta;
                        }
                    }
                    lawn[curr_r++][curr_c] = t++;
                } else if (direction == "S") {
                    if (lawn[curr_r][curr_c] != 0) {
                        int delta = t - lawn[curr_r][curr_c];
                        if (tightest_dist == -1 || delta < tightest_dist) {
                            tightest_dist = delta;
                        }
                    }
                    lawn[curr_r--][curr_c] = t++;
                } else if (direction == "E") {
                    if (lawn[curr_r][curr_c] != 0) {
                        int delta = t - lawn[curr_r][curr_c];
                        if (tightest_dist == -1 || delta < tightest_dist) {
                            tightest_dist = delta;
                        }
                    }
                    lawn[curr_r][curr_c++] = t++;
                } else {
                    if (lawn[curr_r][curr_c] != 0) {
                        int delta = t - lawn[curr_r][curr_c];
                        if (tightest_dist == -1 || delta < tightest_dist) {
                            tightest_dist = delta;
                        }
                    }
                    lawn[curr_r][curr_c--] = t++;
                }
            }
        }
    }