package cn.zhanglian2010.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileUtils {

	public static void appendContent(String fileName, String content){
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(fileName, true));
			out.write(content);
		} catch (IOException e) {
			
		} finally {
			if (out != null){
				try {
					out.close();
				} catch (IOException e) {
					
				}
			}
		}
	}
	
	public static void copy(File src, File dest) throws IOException {
		FileChannel inChannel = new FileInputStream(src).getChannel();
		FileChannel outChannel = new FileOutputStream(dest).getChannel();
		try{
			// magic number for Windows, 64Mb - 32Kb)
			int maxCount = (64 * 1024 * 1024) - (32 * 1024);
			long size = inChannel.size();
			long position = 0;
			while (position < size){
				position += inChannel.transferTo(position, maxCount, outChannel);
			}
		}
		finally{
			if ( inChannel != null ){
				inChannel.close();
			}
			if ( outChannel != null ){
				outChannel.close();
			}
		}
	}
	
	public static File[] listDirectory(String rootFileName){
		File dir = new File(rootFileName);
		FileFilter fileFilter = getDirectoryFilter();
		return dir.listFiles(fileFilter);
	}
	
	private static FileFilter getDirectoryFilter(){
		return new FileFilter() {
			public boolean accept(File file) {
				return file.isDirectory();
			}
		};
	}

}
