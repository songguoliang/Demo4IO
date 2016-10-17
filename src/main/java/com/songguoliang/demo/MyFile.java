/**
 * @File name:  MyFile.java
 * @Create on:  2014-11-10 16:11:27
 * @Author   :  sgl
 */
package com.songguoliang.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

import com.songguoliang.entity.MyFilenameFilter;

/**
 * IO流例子
 * @date 2014-11-10 16:11:45
 * @author sgl
 */
public class MyFile {
	/**
	 * 文件File类
	 * @date 2014-11-10 16:26:28
	 * @author sgl
	 */
	@Test
	public void test1(){
		//以当前路径来创建一个File对象
		File file= new File(".");
		//直接获取文件名，输出一个点
		System.out.println(file.getName());
		//获取相对路径的父路径 可能出错，下面代码输出null
		System.out.println(file.getParent());
		//listRoots静态方法列出所有的磁盘根路径
		File[]roots=File.listRoots();
		System.out.println("=====系统所有根路径如下========");
		for(File root:roots){
			System.out.println(root);
		}
	}
	/**
	 * FilenameFilter类
	 * @date 2014-11-10 16:27:14
	 * @author sgl
	 */
	@Test
	public void test2(){
		File file=new File(".");
		String[]nameList=file.list(new MyFilenameFilter());
		for(String name:nameList){
			System.out.println(name);
		}
		
	}
	/**
	 * FileInputStream
	 * @date 2014-11-10 17:24:29
	 * @author sgl
	 */
	@Test
	public void test3(){
		FileInputStream fis=null;
		try {
			//创建字节输入流
			fis=new FileInputStream("FileInputStreamTest.txt");
			//创建一个长度为1024的“竹筒”
			byte[] bbuf=new byte[1024];
			//用于保存实际读取的字节数
			int hasRead=0;
			while((hasRead=fis.read(bbuf))>0){
				//取出“竹筒”中的水滴(字节)，将字节数组转换成字符串输入！
				System.out.println(new String(bbuf,0,hasRead,"utf-8"));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * FileReader
	 * @date 2014-11-10 17:52:36
	 * @author sgl
	 */
	@Test
	public void test4(){
		FileReader fr=null;
		try {
			//创建字符输入流
			fr=new FileReader("FileInputStreamTest.txt");
			//创建一个长度为32的“竹筒”
			char[]cbuf=new char[32];
			//用于保存实际读取的字符数
			int hasRead=0;
			while((hasRead=fr.read(cbuf))>0){
				//取出“竹筒”中的水滴(字节)，将字符数组转换成字符串输入！
				System.out.println(new String(cbuf,0,hasRead));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (fr!=null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	/**
	 * FileOutputStream类
	 * @date 2014年11月11日 下午4:40:53
	 * @author sgl
	 */
	@Test
	public void test5(){
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			//创建字节输入流
			fis=new FileInputStream("FileInputStreamTest.txt");
			//创建字节输出流
			fos=new FileOutputStream("newFile.txt");
			byte[]bbuf=new byte[32];
			int hasRead=0;
			while((hasRead=fis.read(bbuf))>0){
				//每读一次，即写入文件输出流，读了多少就写多少
				fos.write(bbuf,0,hasRead);
			}
			System.out.println("复制完毕！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	/**
	 * FileWrite类
	 * @date 2014年11月11日 下午4:59:17
	 * @author sgl
	 */
	@Test
	public void test6(){
		FileWriter fw=null;
		FileReader fr=null;
		try {
			fr=new FileReader("FileInputStreamTest.txt");
			fw=new FileWriter("newFile.txt");
			char[]c=new char[32];
			int hasRead=0;
			while((hasRead=fr.read(c))>0){
				fw.write(c,0,hasRead);
				fw.write("测试");
			}
			fw.write("锦瑟 - 李商隐\r\n");
			fw.write("锦瑟无端五十弦，一弦一柱思华年。\r\n");
			fw.write("庄生晓梦迷蝴蝶，望帝春心托杜鹃。\r\n");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(fw!=null){
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

