/**
 * Created by sam on 2/10/18.
 */

import java.util.*;
import java.io.*;
import java.math.*;

public class Customer {
    String name = "bob";
    int level = 0;
    int items = 0;

    public Customer(String name,int level,int items){
        this.name = name;
        this.level = level;
        this.items = items;
    }

    public int compareTo(Customer customer){
        if(this.level>customer.level){
            return this.level-level;
        }else{
            return customer.items-items;
        }
    }





}
