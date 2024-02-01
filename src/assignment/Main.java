package assignment;

import java.math.BigInteger;

public class Main {
	
	//I did not make separate classes for each method
	//In order to run different algorithms, make the changes in the Main class below

    //Algorithm 1 Method
    public static BigInteger Fib1(int n){
        if (n<2){
            return BigInteger.valueOf(n);
        } else {
            return Fib1(n-1).add(Fib1(n-2));

        }
    }

    //Algorithm 2 Method
    public static BigInteger Fib2(int n){
        BigInteger i =  BigInteger.ONE;
        BigInteger j = BigInteger.ZERO;
        
        for (int k = 1 ; k <= n ; k++) {
            j = i.add(j);
            i = j.subtract(i);
        }
        return j;
    }

    //Initialise Array for Fib3 Algorithm
    public static BigInteger Fib3(int n) {
    	BigInteger[] f = new BigInteger[5001];
        f[0] = BigInteger.ZERO;
        f[1] = f[2] = BigInteger.ONE;
        return Fib3Alg(n,f);
    }
    
    //Algorithm 3 Method
    public static BigInteger Fib3Alg (int n, BigInteger[] f) {    	       
    	
        if (n < 3) {
            return f[n];
        }
        if (f[n] != null){
            return f[n];
        }
        
        int k;        
        if (n%2 != 0){
            k = (n+1)/2;
            f[n] = (Fib3Alg(k,f).pow(2)).add(Fib3Alg(k-1,f).pow(2));
        } else {
            k = n/2;
            f[n] = (BigInteger.TWO.multiply(Fib3Alg(k-1,f)).add(Fib3Alg(k,f))).multiply(Fib3Alg(k,f));
        }
        return f[n];
        
     
    }
    
    
	public static void main(String[] args) {
		
		int n;
		
		//change n value here (currently running for Fib(5000))
		for (n = 0 ; n <= 5000; n++) {		
			
			long start = System.nanoTime();
			
			//change x(); here (currently running for Fib3())
			Fib3(n);
			
			long end = System.nanoTime();
			long duration = end - start;
			
			System.out.println(n + " " + duration);
		
		}
		
	}

    
}
