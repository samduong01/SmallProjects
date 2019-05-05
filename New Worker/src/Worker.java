/**
 * Created by sam on 10/10/17.
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

/**
 * Created by sam on 10/6/17.
 */
public class Worker {
    int name;
    int height;
    String gender;
    String workplace;
    String position;
    String timeOfDay;
    String safteyOfWork;
    String flag = "grey";
    int rating = 0;

    //CONSTRUCTER

    public Worker(int name){
        this.name = name;
    }

    //SETTERS
    public void setName(int name){
        this.name = name;
    }

    public void setRating(int rating){
        this.rating = rating;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public void setGender(boolean isMale){
        if(isMale){
            this.gender = "male";
        }else{
            this.gender = "female";
        }
    }
    public void setFlag(String flag){
        this.flag = flag;
    }

    public void setWorkplace(boolean isFactory){
        if(isFactory){
            this.workplace = "factory";
        }else{
            this.workplace = "sales";
        }
    }

    public void setPosition(boolean isSupervisor){
        if(isSupervisor) {
            this.position = "supervisor";
        }else{
            this.position = "worker";
        }
    }

    public void setTimeOfDay(boolean isNight){
        if(isNight) {
            this.timeOfDay = "night";
        }else{
            this.timeOfDay = "day";
        }
    }

    public void setSafteyOfWork(boolean isSafe){
        if(isSafe) {
            this.safteyOfWork = "safe";
        }else{
            this.safteyOfWork = "not safe";
        }
    }

    //GETTERS

    public int getRating(){
        return  this.rating;
    }

    public String getFlag(){
        return this.flag;
    }

    public double getHeight(){
        return this.height;
    }

    public String getGender(){
        return this.gender;
    }

    public String getWorkplace(){
        return this.workplace;
    }

    public String getPosition(){
        return this.position;
    }

    public String getTimeOfDay(){
        return this.timeOfDay;
    }

    public String getSafteyOfWork(){
        return this.safteyOfWork;
    }



    static ArrayList<Node> stringArray = new ArrayList<>();
    public void intialize(int i){

            setAtributes(i);

    }

    public boolean random(){
        Random rand = new Random();
        if(Math.random() < 0.5){
            return true;
        }else{
            return false;
        }
    }

    public boolean randomSaftey(){
        Random rand = new Random();
        if(Math.random() < 0.75){
            return true;
        }else{
            return false;
        }
    }

    public int randomHeight(){
        int max = 100;
        int min = 22;
        Random rand = new Random();
        int n = rand.nextInt((max - min) + 1) + min;
        return n;
    }

    public int randomRating(){
        int max = 200;
        int min = 0;
        Random rand = new Random();
        int n = rand.nextInt((max - min) + 1) + min;
        return n;
    }

    public void setAtributes(int i){
        setName(i);
        setGender(random());
        setPosition(random());
        setSafteyOfWork(randomSaftey());
        setTimeOfDay(random());
        setWorkplace(random());
        setHeight(randomHeight());
        setRating(randomRating());
    }

}

