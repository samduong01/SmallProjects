/**
 * Created by sam on 7/13/17.
 */
public class Items {
    private int amount;
    private int price;
    private String order;

    public Items(int amountIn, int priceIn, String orderIn){
        order = orderIn;
        amount= amountIn;
        price = priceIn;


    }



    public int getTotalCost(){

        int newPrice = amount * price;

        return newPrice;
    }

    public String getOrder(){


        return order;
    }

}
