public class MaxSameStr {

    public static void main(String[] args) {
        String str1 = "abcdefga";
        String str2 = "abdefg";
        System.out.println("the max same sub string is: " + getMaxSameStr(str1,str2)); 
    }

    public static String getMaxSameStr(String str1,String str2){
        String maxSameStr = "";
        String temp = "";

        int len = str1.length();
        for(int i=0;i<len;i++){
            temp = str1.substring(i,len);
            if(str2.indexOf(temp) != -1){
                maxSameStr = temp;
                break;
            }
        }
        return maxSameStr;
    }

}