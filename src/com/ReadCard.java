package com;

import org.xvolks.jnative.JNative;
import org.xvolks.jnative.Type;
import org.xvolks.jnative.exceptions.NativeException;
import org.xvolks.jnative.pointers.Pointer;
import org.xvolks.jnative.pointers.memory.MemoryBlockFactory;

public class ReadCard {
	public native static int HCE300_Read(int TrackNo,char[] readBuf);
	public native static int HCE300_Open(int Comport);
	public native static int HCE300_Write(int TrackNo,char[] writeBuf);
	
	JNative jnative;
	public static void main (String args[]){
		ReadCard duka = new ReadCard();
		try {
			duka.HCE300_Open();
			String str = duka.HCE300_Read().substring(0, 19);
			System.out.println(str);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NativeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void HCE300_Open() throws NativeException,IllegalAccessException
	{
		jnative = new JNative("HCE300_API","HCE300_Open");
		//端口号可能改变
		jnative.setParameter(0,3);	
		jnative.invoke();
	}
	
	public void HCE300_Write(String cardnumber) throws NativeException,IllegalAccessException{
		JNative jnative = new JNative("HCE300_API","HCE300_Write");
		Pointer WriteBuf = new Pointer(MemoryBlockFactory.createMemoryBlock(300));
		WriteBuf.setStringAt(0, cardnumber);
		jnative.setRetVal(Type.INT);
		jnative.setParameter(0, 2);
		jnative.setParameter(1, WriteBuf);	
		jnative.invoke();
		System.out.println("输出：");
	}
	
	public String HCE300_Read() throws NativeException,IllegalAccessException
	{
		System.loadLibrary("HCE300_API");
		JNative jnative = new JNative("HCE300_API","HCE300_Read");
		Pointer ReadBuf = new Pointer(MemoryBlockFactory.createMemoryBlock(300));
		jnative.setRetVal(Type.INT);  
		jnative.setParameter(0, 2);
		jnative.setParameter(1, ReadBuf);
		jnative.invoke();
		String str = ReadBuf.getAsString();
		//System.out.println("返回：" + Integer.parseInt(jnative.getRetVal()));
		ReadBuf.dispose();
		return (str);
	}
}