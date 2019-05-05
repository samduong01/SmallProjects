/**
 * Created by sam on 6/26/18.
 */
public class Space {
    String name = "UNCHECKED";
    String label = "[=]";

    int x;
    int y;

    //randomly generate mine
    //based of max avialable mines for difficulty level
    public Space(int x, int y){
         this.x = x;
         this.y = y;
         if(Math.random()<0.25){
             this.name = "BOMB";
         }
    }

    public void update(){
        if(this.name == "FLAG"){
            this.label = "[>]";
        }

        if(this.name == "EMPTY"){
            this.label = "[ ]";
        }

        if(this.name == "BOMB"){
            this.label = "[*]";
        }

        if(this.name == "QUESTION"){
            this.label = "[?]";
        }

    }

}
