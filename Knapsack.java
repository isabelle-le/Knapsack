package Dynamic_Program;
/**
 * Knapsack program : Use given problem in class
 * Correct answer is maximum value taking is 7, taken item number #1 #3 , solution weight = 7 < W =8
 * @author Le Thu Huong
 *
 */
public class Knapsack {
	/**
	 * @param w : weight of each item, presented in an array
	 * @param v : value of item, presented in an array
	 * @param n : number of item
	 * @param W : total capacity, that we consider in this problem
	 * @return  : an matrix of number of n+1 row and total W+1 column,
	 *            to be filled with the maximum taken value at the step of each
	 *            value of W total capacity  
	 */
	 
	public static int Knapsack(int[] w, int[] v, int n, int W) {
		int V[][] = new int [n+1][W+1];
		
		// First row is all 0 because of 0 items
		for(int j=0; j<W+1; j++) V[0][j] = 0;                    
		
		// Compare the max between notTakingItem and takingItem. Then, put the maximum in the matrix table
		for(int i=1; i<n+1; i++) {
			for(int j=0; j<W+1; j++) {
				int	notTakingItem = V[i-1][j];                                           // it is also mean keep=0
				
				// Only if weight of item smaller than weight column(j = W++) -> consider taking it 
				int takingItem = 0;
				if (w[i] <= j) {
					takingItem = v[i] + V[i-1][j-w[i]];                                 //it is also  mean keep=1
				}
				
				// Program is interested in the max number 
				V[i][j] = Math.max(notTakingItem,takingItem);
			}
			
		}
		
		
		
		
		
		// Print out the takingItem
		for(int k=n,K=W; k>0; k--) {
			
		/**
		 Program skip considering value 0 (obviously no item in it) &&
	  	 consider takingItem (Keep = 1 in algorithm) by comparing this item and the the upper row's item(same total capacity K=W)
		 Thus, if value of k and k-1 not the same, then take that item[k]
		 We minus the weight of that taking item and continuous looking for the next taking item, stop when we found 0
		 */
			if( V[k][K] != 0 && V[k][K] != V[k-1][K] ) { 
				System.out.println("Take item #"+ k + " with weight " + w[k] + " kg");
				K = K - w[k];
			}
		}
		
		return V[n][W] ;
	}	
   //END
	
	
	
	
	
	//Loading our problem
	 public static void main(String args[])
		{
			int W = 8;
			int n = 5;
			int[] w = new int[n+1];
			w[0] = 0;
			w[1] = 4;
			w[2] = 7;
			w[3] = 3;
			w[4] = 5;
			w[5] = 4;   //if change it to 1 -> then max value is 8 and item taking is #1 #3 #5
			int[] v = new int[n+1];
			v[0] = 0;
			v[1] = 5;
			v[2] = 3;
			v[3] = 2;
			v[4] = 2;
			v[5] = 1;
			System.out.println("Total given capacity is W = "+ W);
		    System.out.println("Maximum value is = "+ Knapsack(w,v,n,W));
		}
	
}
