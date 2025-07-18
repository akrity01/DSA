class Solution {
    public int maxProfit(int[] prices) {
     int profit=0;
     int buyPrice=Integer.MAX_VALUE;
     int maxiProfit=Integer.MIN_VALUE;
        for ( int i = 0; i< prices.length;i++)
        { 
            if (buyPrice<prices[i])
            {
                profit=prices[i]-buyPrice;
               maxiProfit=Math.max(maxiProfit,profit);
            }
            else
            {   
                buyPrice=prices[i];
                 maxiProfit=Math.max(maxiProfit,profit);
            }
            }
            return maxiProfit;
        }
    }
