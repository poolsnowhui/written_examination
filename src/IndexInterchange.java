
public class IndexInterchange {
	public static void main(String[] args) {
		int [] a ={3,2,0,1};
		int [] b = swapArr(a);
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i]+" ");
		}
	}
	public static int[] swapArr(int []arr){
		if(arr==null) return null;
		int [] b = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			b[arr[i]] = i;
		}
		return b;
	}
}
