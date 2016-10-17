/**
 * @File name:  MyFilenameFilter.java
 * @Create on:  2014-11-10 16:30:59
 * @Author   :  sgl
 */
package com.songguoliang.entity;

import java.io.File;
import java.io.FilenameFilter;
/**
 * 实现FilenameFilter接口
 * @date 2014-11-10 16:31:23
 * @author sgl
 */
public class MyFilenameFilter implements FilenameFilter{

	public boolean accept(File dir, String name) {
		//如果文件名以.java结尾，或者文件对应一个路径，返回true
		return name.endsWith(".java")||new File(name).isDirectory();
	}

}

