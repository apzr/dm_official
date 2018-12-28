package com.dm.official.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dm.official.controller.MainController;


public class FileUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

	/**
	 * 获取目录下所有.ok的文件
	 * 
	 * @param path
	 * @return
	 */
	public static List<File> getFiles(String path, String suffix) {
		List<File> files = null;

		try {
			if (path == null)
				throw new IllegalArgumentException("文件路径为空");

			File tmp = new File(path);
			if (tmp.isDirectory()) {
				File[] fs = tmp.listFiles();

				files = new LinkedList<File>();
				for (int i = 0; i < fs.length; i++) {
					File f = fs[i];
					if (f.exists() && f.isFile() && f.getName().endsWith(suffix))
						files.add(f);
				}
			}
		} catch (Exception e) {
			LOGGER.error("获取文件失败：" + e.getMessage() + "\tcause：" + e.getCause());
		}

		return files;
	}

	/**
	 * 剪切文件
	 * 
	 * @param file
	 * @param path
	 */
	public static void move(File file, String path) {
		move(Arrays.asList(new File[] { file }), path);
	}

	/**
	 * 剪切文件s
	 * 
	 * @param files
	 * @param path
	 */
	public static void move(List<File> files, String path) {
		if (files != null) {
			for (File f : files) {
				try {
					if (f.renameTo(new File(path + File.separator + f.getName()))) {
						if (LOGGER.isDebugEnabled())
							LOGGER.debug("file:\t" + f.getName() + " moved");
					} else {
						if (LOGGER.isDebugEnabled())
							LOGGER.debug("file:\t" + f.getName() + " stay");
					}
				} catch (Exception e) {
					LOGGER.error("file:\t" + f.getName() + " crash, " + e.getMessage() + "<>" + e.getCause());
					continue;
				}
			}
		}
	}

	public static void main(String[] args) {
		save("d:/","111.txt","\r\n111777999", true);
		System.out.println(readLast("d:/111.txt"));
	}

	/**
	 * 保存文件
	 * @param dir
	 * @param name
	 * @param content
	 * @param append
	 * @throws IOException
	 */
	public static void save(String dir, String name, String content){
		File fp = new File(dir + File.separator + name);
		save(fp, content, true);
	}
	
	/**
	 * 保存文件
	 * @param dir
	 * @param name
	 * @param content
	 * @param append
	 * @throws IOException
	 */
	public static void save(String dir, String name, String content, boolean append){
		File fp = new File(dir + File.separator + name);
		save(fp, content, append);
	}
	
	/**
	 * 保存文件
	 * @param fp
	 * @param content
	 * @param append
	 * @throws IOException
	 */
	public static void save(File fp, String content, boolean append) {
		FileWriter writer=null;
		try {
			writer = new FileWriter(fp, append);
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			LOGGER.error("保存文件异常:"+e.getMessage());
		} finally {
			try { writer.close(); } catch (IOException e) {}
		}
	}

	/**
	 * 保存文件
	 * 
	 * @param stream
	 * @param path
	 * @param filename
	 * @throws IOException
	 */
	public static void saveFileFromInputStream(InputStream stream, String path, String filename){
		FileOutputStream fs = null;
		try {
			fs = new FileOutputStream(path + "/" + filename);
			byte[] buffer = new byte[1024 * 1024];
			int bytesum = 0;
			int byteread = 0;
			while ((byteread = stream.read(buffer)) != -1) {
				bytesum += byteread;
				fs.write(buffer, 0, byteread);
				fs.flush();
			}
			fs.close();
			stream.close();
		} catch (FileNotFoundException e) {
			LOGGER.error("保存文件异常:"+e.getMessage());
		} catch (IOException e) {
			LOGGER.error("保存文件异常:"+e.getMessage());
		} finally {
			try {
				fs.close();
				stream.close();
			} catch (Exception e) {}
			
		}
	}

	/**
	 * 保存文件
	 * 
	 * @param stream
	 * @return
	 * @throws IOException
	 */
	public static File saveFileFromInputStreamToTemp(InputStream stream) {
		File f = null;
		FileOutputStream fs = null;
		try {
			f = File.createTempFile("tmp_", "_ct");
			fs = new FileOutputStream(f);
			byte[] buffer = new byte[1024 * 1024];
			int bytesum = 0;
			int byteread = 0;
			while ((byteread = stream.read(buffer)) != -1) {
				bytesum += byteread;
				fs.write(buffer, 0, byteread);
				fs.flush();
			}
			fs.close();
			stream.close();
		} catch (Exception e) {
			LOGGER.error("保存文件异常:"+e.getMessage());
		} finally {
			try {
				fs.close();
				stream.close();
			} catch (Exception e) {}
		}

		return f;
	}

	/**
	 * 
	 * @param path
	 * @return
	 * @throws IOException 
	 */
	public static String read(String path){
		File f = new File(path);
		return read(f);
	}

	/**
	 * 
	 * @param f
	 * @return
	 * @throws IOException 
	 */
	public static String read(File f) {
		try {
			BufferedReader bf= new BufferedReader(new FileReader(f));

			StringBuffer buffer = new StringBuffer();
			String line;
			while ((line = bf.readLine())!=null) {
				buffer.append(line);
			}
			
			bf.close();
			
			return buffer.toString();
		} catch (FileNotFoundException e) {
			LOGGER.error("读取文件异常:"+e.getMessage());
		} catch (IOException e) {
			LOGGER.error("读取文件异常:"+e.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @param path
	 * @return
	 * @throws IOException 
	 */
	public static String readLast(String path){
		return readLast(new File(path));
	}
	
	/**
	 * 
	 * @param f
	 * @return
	 * @throws IOException
	 */
	public static String readLast(File f){
		try {
			BufferedReader bf= new BufferedReader(new FileReader(f));

			String buffer = "";
			String line;
			while ((line = bf.readLine())!=null) {
				buffer = line;
			}
			
			bf.close();
			
			return buffer;
		} catch (FileNotFoundException e) {
			LOGGER.error("读取文件异常:"+e.getMessage());
		} catch (IOException e) {
			LOGGER.error("读取文件异常:"+e.getMessage());
		}
		return null;
	}

	public static String readFileByName(String path, String name) throws IOException {
		return read(path + name);
	}

}
