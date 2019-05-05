/**
 * Created by sam on 8/29/17.
 */
public class Main {
    public static void main(String[] args){

            Game game = new Game();
            String test = "hi";
            game.intialize();
            game.gameType();
            game.objective();

                while(true) {
                    game.fillBoard();
                    game.update();
                    game.render();
                    game.user();
                    if(game.objectiveScored()){
                       break;
                    }
                }

                game.printStats();

                //game.fillBoard();


    }
}
