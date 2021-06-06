public class Solution3 {
  //조합 완탐 가능 2^17// 합의 차이
  public static void main(String[] args) {
    System.out.println(method(new int[]{3,2,1,5}));
    System.out.println(method(new int[]{-1,-2,1,2}));
    System.out.println(method(new int[]{-50,50}));
    System.out.println(method(new int[]{10,20,30,50,123,123,44,11,55,11,33,33,11,99999999,11,11,11,11}));
    System.out.println(method(new int[]{10,20,30,50,123,123,44,11,55,11,33,33,11,99999999,11,11,11,11,10,20,30,50,123,123,44,11,55,11,33,33,11,99999999,11,11,11,11}));



  }
  static int[] tempNumbers;
  static int min;
  static boolean[] check;
  static int method(int[] numbers){
    tempNumbers=numbers.clone();
    min=Integer.MAX_VALUE;
    check=new boolean[tempNumbers.length];
    dfs(0,0);
    return min;
  }

  private static void dfs(int index, int total) {
    if(index==tempNumbers.length){
      if(allChecker(check)){
        return;
      }
      int result=Math.abs(total);
      if(result<min){
        min=result;
      }
      return;
    }
    check[index]=true;
    dfs(index+1, total+tempNumbers[index]);
    check[index]=false;
    dfs(index+1, total-tempNumbers[index]);
  }
  static boolean allChecker(boolean[] check){
    for (int i = 1; i < check.length; i++) {
      if(!check[0]==check[i]){
          return false;
      }
    }
    return true;
  }
}
