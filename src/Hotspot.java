
 public class Hotspot{

 	private static Long eden;

 	private static Long fromSurvivor;

 	private static Long toSurvivor;

 	private static Long old;

 	private static Long useEden;

 	private static Long useFrom;

 	private static Long useTo;

 	private static Long useOld;

 	private static boolean swapFlag;//fromSurvivor与toSurvivor交换的标识

 	 static{

 		fromSurvivor = (long) (1000 * 1024 * 1024);
 		
 		toSurvivor = (long) (1000 * 1024 * 1024);

 		eden = 8 * fromSurvivor;

 		old = eden;

 		useEden = useFrom = useTo = useOld = 0l;

 		swapFlag = false;

 	}

 	public static boolean  alloc(long num){
 		
 		if(num > eden - useEden){

 			if(old - useOld > num){
 				useOld += num;
 				return true;
 			}else{
 				return false;
 			}

 		}else{

 			useEden += num;
 			return true; 
 		}
 	}

 	public static boolean gc(){
 		if(!swapFlag){
 			if(old - useOld > useTo){

 				useOld += useTo;
 				useTo = 0l;
 				if(toSurvivor - useTo > useEden + useFrom){
 					useTo += useEden + useFrom;
 					useEden = useFrom = 0l;
 				}
 				swapFlag = true;//交换survivor
 				return true;
 			}else{//回收永久代，采用计数法
 				return true;
 			}
 		}else{
 			if(old - useOld > useFrom){

 				useOld += useFrom;
 				useFrom = 0l;
 				if(fromSurvivor - useFrom > useEden + useTo){
 					useFrom += useEden + useTo;
 					useEden = useTo = 0l;
 				}
 				swapFlag = true;//交换survivor
 				return true;
 			}else{//回收永久代，采用计数法
 				return true;
 			}

 		}
 	}

 }