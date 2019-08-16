import java.util.*;

/**
 * Created by sam on 6/19/19.
 */
public class TicTacToe {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[][] board = new String[3][3];
        ArrayList<String> oneWinArray = new ArrayList<>();
        ArrayList<ArrayList<String>> twoWinsArray = new ArrayList<>();
        for(int i = 0;i<3;i++){
            String s = sc.next();

            for(int j = 0;j<3;j++){
                board[i][j] = Character.toString(s.charAt(j));
            }
        }

        int oneWin = 0;
        int twoWin = 0;
        for(int i = 0;i<3;i++){
            String[] row = board[i];
            HashSet<String> hashSet = new HashSet<>();
            for(int j = 0;j<3;j++){
                hashSet.add(row[j]);
            }

            if(hashSet.size() == 2){
                HashSet<String> vals = new HashSet<>();
                for(int r = 0;r<3;r++){
                    vals.add(row[r]);
                }
                ArrayList<String> list = new ArrayList<>(vals);

                Collections.sort(list);

                if(!twoWinsArray.contains(list)) {
                    twoWinsArray.add(list);
                    twoWin++;
                }
            }else if(hashSet.size()==1){
                if(!oneWinArray.contains(row[0])) {
                    oneWinArray.add(row[0]);
                    oneWin++;
                }
            }
        }

        for(int i = 0;i<3;i++){
            String[] col = new String[3];
            for(int j = 0;j<3;j++){
                col[j] = board[j][i];
            }

            HashSet<String> hashSet = new HashSet<>();
            for(int j = 0;j<3;j++){
                hashSet.add(col[j]);
            }

            if(hashSet.size() == 2){
                HashSet<String> vals = new HashSet<>();
                for(int r = 0;r<3;r++){
                    vals.add(col[r]);
                }
                ArrayList<String> list = new ArrayList<>(vals);

                Collections.sort(list);

                if(!twoWinsArray.contains(list)) {
                    twoWinsArray.add(list);
                    twoWin++;
                }
            }else if(hashSet.size()==1){
                if(!oneWinArray.contains(col[0])) {
                    oneWinArray.add(col[0]);
                    oneWin++;
                }
            }

        }

        String[] diag = new String[3];

        for(int i = 0;i<3;i++){
            diag[i] = board[i][i];
        }

        HashSet<String> hashSet = new HashSet<>();
        for(int j = 0;j<3;j++){
            hashSet.add(diag[j]);
        }

        if(hashSet.size() == 2){
            HashSet<String> vals = new HashSet<>();
            for(int r = 0;r<3;r++){
                vals.add(diag[r]);
            }
            ArrayList<String> list = new ArrayList<>(vals);

            Collections.sort(list);

            if(!twoWinsArray.contains(list)) {
                twoWinsArray.add(list);
                twoWin++;
            }
        }else if(hashSet.size()==1){
            if(!oneWinArray.contains(diag[0])) {
                oneWinArray.add(diag[0]);
                oneWin++;
            }
        }


        String[] diag1 = new String[3];

        diag1[0] = board[0][2];
        diag1[1] = board[1][1];
        diag[2] = board[2][0];

        HashSet<String> hashSet1 = new HashSet<>();
        for(int j = 0;j<3;j++){
            hashSet.add(diag1[j]);
        }

        if(hashSet1.size() == 2){
            HashSet<String> vals = new HashSet<>();
            for(int r = 0;r<3;r++){
                vals.add(diag1[r]);
            }


            ArrayList<String> list = new ArrayList<>(vals);
            Collections.sort(list);

            if(!twoWinsArray.contains(list)) {
                twoWinsArray.add(list);
                twoWin++;
            }
        }else if(hashSet1.size()==1){
            if(!oneWinArray.contains(diag1[0])) {
                oneWinArray.add(diag1[0]);
                oneWin++;
            }
        }

        System.out.println(oneWin);
        System.out.println(twoWin);
    }
}
