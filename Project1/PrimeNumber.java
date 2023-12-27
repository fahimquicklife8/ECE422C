package assignment1;
//
//public class PrimeNumber {
//    public static void main(String[] args) {
//        for (int i = 2; i <= 100; i++) {
//            if(isPrime(i)){
//                System.out.print(i + " ");
//            }
//        }
//    }
//
//    public static boolean isPrime(int n){
//        for (int j = 2; j < n; j++){
//            if(n % j == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//}


public class PrimeNumber{

    public static void main(String[] args) {
        int i;
        for ( i = 2; i<= 100; i++){
            if(isPrime(i)){
                System.out.print(" "+ i);
            }
        }

    }
    public static boolean isPrime(int n){
       int j;
        if(n <= 1){
            return false;
        }
        for(j = 2; j<n; j++){
            if(n%j == 0){
                return false;
            }
        }
        return true;
    }

}
