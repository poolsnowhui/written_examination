import java.util.*;
public class Main1_0{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            StringBuffer sb=new StringBuffer();
            while(N-->0){
            	int eachN = sc.nextInt();
            	while(eachN-->0){
            		sb.append(sc.next());
            		sb.append(",");
            	}
            }
            String[] str=sb.toString().split(",");
            int k=sc.nextInt();
            TreeSet<Unit> queue=getMost(str,k);
            while(!queue.isEmpty()){
            	Unit word=queue.pollFirst();
            	System.out.println(word.getVal()+" "+word.getCount());
            }
        }
        sc.close();
    }
    public static TreeSet<Unit> getMost(String str[],int k){
    	Map<String ,Integer> maps=new HashMap<String ,Integer>();
    	for(int i=0;i<str.length;i++){
    		if(maps.containsKey(str[i])){
    			maps.put(str[i],maps.get(str[i])+1);
    		}else{
    			maps.put(str[i],1);
    		}
    	}
    	TreeSet<Unit> queue=new TreeSet<Unit>(new myComparator());
    	for(Map.Entry<String ,Integer> entry:maps.entrySet()){
    		if(queue.size()<k){
    			queue.add(new Unit(entry.getKey(),entry.getValue()));
    		}else{
    			if(entry.getValue()>queue.last().getCount()){
    				queue.pollLast();
    				queue.add(new Unit(entry.getKey(),entry.getValue()));
    			}else if(entry.getValue()==queue.last().getCount()){
    				if(entry.getKey().compareTo(queue.last().getVal())<0){
    					queue.pollLast();
        				queue.add(new Unit(entry.getKey(),entry.getValue()));
    				}
    			}
    		}
    	}
    	return queue;
    }
}

class myComparator implements Comparator<Unit>{
	@Override
	public int compare(Unit o1, Unit o2) {
		// TODO Auto-generated method stub
		if(o1.getCount()<o2.getCount()){
			return 1;
		}else if(o1.getCount()>o2.getCount()){
			return -1;
		}else{
			return o1.getVal().compareTo(o2.getVal());
		}
	}
} 

class Unit{
	int count;
	String value;
	public Unit(String val,int count){
		this.count=count;
		this.value=val;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getVal() {
		return value;
	}
	public void setVal(String value) {
		this.value = value;
	}
	
}