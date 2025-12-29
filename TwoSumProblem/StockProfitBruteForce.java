public class StockProfitBruteForce {
     static int maxProfit(int[] prices) {
          int maxProfit=0;
          for(int i=0; i<prices.length; i++) {
               for(int j=i+1; j<prices.length; j++) {
                    int profit = prices[j] - prices[i];
                    if(profit > maxProfit) {
                         maxProfit= profit;
                    }
               }
          }
          return maxProfit;
     }

     public static void main(String[] args) {
           int[] prices = {7, 10, 1, 3, 6, 9, 2};
        System.out.println(maxProfit(prices)); // Output: 8

        int[] prices1 = {7, 6, 4, 3, 1}; 
        System.out.println(maxProfit(prices1)); // Output: 0

        int[] prices2 = {1, 3, 6, 9, 11};
        System.out.println(maxProfit(prices2)); // Output: 10 

     }
}
