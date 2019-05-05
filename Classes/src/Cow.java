/**
 * Created by sam on 3/12/19.
 */
public class Cow extends Animal  implements Laser,Missle{
    public int var = 0;
    public Cow(){
        super();
    }

    public void var(){

    }
    public void display() {
        System.out.println("test");
    }

    public void displayMissle(){
        System.out.println("Display Missle");
    }
}
