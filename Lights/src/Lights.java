/**
 * Created by sam on 8/29/17.
 */
public class Lights {
    String lightName;
    public String image;

    public Lights(String lightName){
        this.lightName = lightName;
    }

    public void setImage(String image){
        this.image = image;
    }

    public void changeImage() {
        if(this.image == "O"){
            this.image = "X";
        }else{
            this.image = "O";
        }
    }
}
