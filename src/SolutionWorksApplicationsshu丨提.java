
public class SolutionWorksApplicationsshu丨提 {

	public static void main(String[] args) {
		String s="WORKSAPPLICATIONS";
		int nRows=3;
		System.out.println(solution(s, nRows));

	}
	public static String solution(String s,int nRows){
		char a[][] = new char[nRows][s.length()/2+1];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				a[i][j]=' ';
			}
		}
		 for (int i = 0,j=0,k=0; k < s.length(); ) {
			if(j%2==0){
				a[i][j] = s.charAt(k);
				k++;
			}else{
				if(i==1){
					a[i][j] = s.charAt(k);
					k++;
				}
			}
			if(++i%nRows==0){
				i=0;j++;
			}
		}
		 StringBuffer sb = new StringBuffer();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				sb.append(a[i][j]);
			}
			sb.append("\n");
		}
		return sb.toString();
		
	}

}
