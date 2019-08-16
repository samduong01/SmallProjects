import java.util.ArrayList;
        import java.util.Scanner;
        import java.util.Vector;

/**
 * Created by sam on 6/25/19.
 */
public class ContMilk {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int people = sc.nextInt();
        int milks = sc.nextInt();
        int numLogs = sc.nextInt();
        int pplSick = sc.nextInt();
        Vector<Person> everyone = new Vector<>();
        Vector<Person> sick = new Vector<>();

        Vector<Integer> badMilk = new Vector<>();

        for(int i = 0;i<people;i++){
            everyone.add(new Person(i+1));
        }

        for(int i = 0;i<numLogs;i++){
            int index = sc.nextInt()-1;
            everyone.get(index).milk.add(sc.nextInt());
            everyone.get(index).time.add(sc.nextInt());
        }
        int count = 0;
        for(int i = 0;i<pplSick;i++){
            Person person = new Person(sc.nextInt());
            person.sick = sc.nextInt();
            sick.add(person);
        }

        for(int i = 0;i<pplSick;i++){
            int p = sick.get(i).name;
            int t = sick.get(i).sick;
            Vector<Integer> milk = new Vector<>(everyone.get(p-1).milk);
            Vector<Integer> time = new Vector<>(everyone.get(p-1).time);

            for(int j = 0;j<time.size();j++){
                if(time.get(j)<t){
                    badMilk.add(milk.get(j));
                }
            }
        }

        int badMillkSingle = 0;

        for(int j = 0;j<badMilk.size();j++) {
            int badM = badMilk.get(j);
            boolean isF = false;
            for (int i = 0; i < pplSick; i++) {
                int p = sick.get(i).name;
                Vector<Integer> m = new Vector<>(everyone.get(p - 1).milk);
                if(m.contains(badM)){
                    isF = true;
                }else{
                    isF = false;
                    break;
                }
            }
            if(isF){
                badMillkSingle = badM;
                break;
            }
        }


        if(pplSick==1){
            for(int i = 0;i<everyone.size();i++){
                boolean isFound = false;
                for(int j = 0;j<badMilk.size();j++){
                    if(everyone.get(i).milk.contains(badMilk.get(j))){
                        isFound = true;
                    }
                }
                if(isFound){
                    count++;
                }
            }
            System.out.println(count);

        }else {
            for (int i = 0; i < everyone.size(); i++) {
                if (everyone.get(i).milk.contains(badMillkSingle)) {
                    count++;
                }
            }
            if(badMillkSingle==0){
                System.out.println(people);
            }else {
                System.out.println(count);
            }
        }
    }
}
class Person{
    int name;
    int sick;
    Vector<Integer> milk = new Vector<>();
    Vector<Integer> time = new Vector<>();

    Person(int name){
        this.name = name;
    }
}

