import java.util.Scanner;

public class Mainxiaomi2 {
	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		while(n.hasNext()){
			String in=n.nextLine();
			System.out.println(reverse(in));
		}
		
	}
    public static String reverse(String s) {

        String res="",tmp;
        String[] array=s.trim().split(" ");

        for(int i=0,j=array.length-1;i<j;i++,j--){
            while(array[i].equals("")){
                i++;
            }
            while(array[j].equals("")){
                j--;
            }
            tmp=array[i];
            array[i]=array[j];
            array[j]=tmp;
        }

        for(int i=0;i<array.length;i++){
            if(!array[i].equals("")){
                res +=array[i]+" ";
            }
        }
        return res.trim();
    }
}