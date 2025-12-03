import java.util.*;

public class FractionalKnapSack {

    // Overall Time Complexity: O(nlogn) (n+nlogn+n) = O(2nlogn) = O(nlogn) (for sorting)

    public static class ItemValue {
        int profit, weight;

        public ItemValue(int  profit, int weight){
            this.profit = profit;
            this.weight = weight;
        }

    }


    public static double getMaxProfitValue(ItemValue[] arr, int capacity){
        //1. we need to find the p/w ration and based on that we need to sort them in desc
        Arrays.sort(arr, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue item1, ItemValue item2) {
                double ratio1 = Double.valueOf(item1.profit/item1.weight);
                double ratio2 = Double.valueOf(item2.profit/item2.weight);
                if(ratio1 < ratio2){
                    return 1;  //swap
                }
                else{
                    return -1; 
                }
            }
        });

        double maxProfit = 0.0;

        for(ItemValue item : arr){
            int currWeight = (int)item.weight;
            int currProfit = (int)item.profit;

            if(capacity-currWeight >= 0){
                //this whole item can be included
                capacity -= currWeight;
                maxProfit += currProfit;
            }
            else {
                //this whole item cannot be included (we need to include a fraction of it)    ; refer to the comment at the end of the code
                double fraction = (double)capacity/(double)currWeight;
                capacity  = (int)(capacity - (currWeight * fraction));
                maxProfit += fraction * currProfit;
                break;
            }
        }

        return maxProfit;

    }

    public static void main(String[] args) {
        ItemValue[] arr = {
            new ItemValue(25, 5),
            new ItemValue(75, 10),
            new ItemValue(100, 12),
            new ItemValue(50, 4),
            new ItemValue(45, 7),
            new ItemValue(90, 9),
            new ItemValue(30,3),
        };
        int capacity = 37;
        
        //function call
        double maxProfit = getMaxProfitValue(arr, capacity);
        
        System.out.println("Maximum profit that can be obtained is for '37' capacity : "+maxProfit);
    }
}







/* We cannot take the whole item because its weight (currWeight) is greater
        than the remaining capacity in the bag.

        So we take only a *fraction* of this item.

        fraction = (remaining capacity) / (item weight)
        This tells us what portion of the entire item can fit into the bag.
        e.g., capacity = 9, item weight = 10  →  fraction = 9/10 = 0.9

        This fraction applies to BOTH:
        1. Weight (because the bag can only hold 9/10 of the item)
        2. Profit (because profit is proportional to weight)

        So:
        - fraction * currWeight  gives the weight we actually take  → 9 kg
        - fraction * currProfit  gives the profit for that portion  → 0.9 * profit

        That is why we multiply the fraction with the item's weight and profit.
        It represents taking only the portion of the item that fits in the bag.
*/