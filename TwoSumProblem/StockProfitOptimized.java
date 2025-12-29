public class StockProfitOptimized {
     public static int maxProfit(int[] prices) 
     { 
          int minPrice = Integer.MAX_VALUE; 
          int maxProfit = 0; 
          for (int price : prices) 
          { 
               // Track minimum so far (best to buy) 
               if (price < minPrice) { 
                    minPrice = price;
               }
                // Check profit with current selling price 
                
               int profit = price - minPrice; 
               if (profit > maxProfit) {
                     maxProfit = profit; 
                    }
                }
          return maxProfit; 
     }
     
      public static void main(String[] args) { 
          int[] prices = {7, 10, 1, 3, 6, 9, 2}; 
          System.out.println(maxProfit(prices)); // Output: 8 
     }
}
