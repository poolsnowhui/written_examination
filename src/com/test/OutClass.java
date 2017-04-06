package com.test;

import java.util.Iterator;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class OutClass {
	static Byte b ;
	static char c;
	static short s;
	static int i ;
	static long l;
	static float f;
	static double d;
	static boolean bo;
	static int count = 1;
	Iterator<String> it;
	ThreadLocal<String> ts ;
	abstract class InnerClass{
		 abstract float func();
	}
	ReadWriteLock rwl = new ReentrantReadWriteLock();
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, ClassNotFoundException, InstantiationException {
        Class<?> classType = Class.forName("java.lang.Byte");  
        System.out.println(classType.getSimpleName()+":");
		for (Byte i = Byte.MIN_VALUE; i < Byte.MAX_VALUE; i++) {
			if(count++==10){
				count =0;
				System.out.println(i+" ");
			}else{
				System.out.print(i+" ");
			}
		}
		System.out.println(Byte.MAX_VALUE);
		
		classType = Class.forName("java.lang.Character");  
		System.out.println(classType.getSimpleName()+":");
		for (Character i = Character.MIN_VALUE; i < Character.MAX_VALUE; i++) {
			if(count++==10){
				count =0;
				System.out.println(i+" ");
			}else{
				System.out.print(i+" ");
			}
		}
		System.out.println(Character.MAX_VALUE);
		
		classType = Class.forName("java.lang.Short");  
		System.out.println(classType.getSimpleName()+":");
		for (Short i = Short.MIN_VALUE; i < Short.MAX_VALUE; i++) {
			if(count++==10){
				count =0;
				System.out.println(i+" ");
			}else{
				System.out.print(i+" ");
			}
		}
		System.out.println(Short.MAX_VALUE);
		
		 classType = Class.forName("java.lang.Integer");  
		System.out.println(classType.getSimpleName()+":");
		for (Integer i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
			if(count++==10){
				count =0;
				System.out.println(i+" ");
			}else{
				System.out.print(i+" ");
			}
		}
		System.out.println(Integer.MAX_VALUE);
		
//		 classType = Class.forName("java.lang.Long");  
//		System.out.println(classType.getSimpleName()+":");
//		for (Long i = Long.MIN_VALUE; i <= Long.MAX_VALUE; i++) {
//			if(count++==10){
//				count =0;
//				System.out.println(i+" ");
//			}else{
//				System.out.print(i+" ");
//			}
//		}
//		System.out.println();
//		
//		 classType = Class.forName("java.lang.Float");  
//		System.out.println(classType.getSimpleName()+":");
//		for (Float i = Float.MIN_VALUE; i <= Float.MAX_VALUE; i++) {
//			if(count++==10){
//				count =0;
//				System.out.println(i+" ");
//			}else{
//				System.out.print(i+" ");
//			}
//		}
//		System.out.println();
//		
//		 classType = Class.forName("java.lang.Double");  
//		System.out.println(classType.getSimpleName()+":");
//		for (Double i = Double.MIN_VALUE; i <= Double.MAX_VALUE; i++) {
//			if(count++==10){
//				count =0;
//				System.out.println(i+" ");
//			}else{
//				System.out.print(i+" ");
//			}
//		}
//		System.out.println();
//		
//		 classType = Class.forName("java.lang.Boolean");  
//		System.out.println(classType.getSimpleName()+":");
//		System.out.println(Boolean.FALSE);
//		System.out.println(Boolean.TRUE);
//		System.out.println();
//		
	}
}
