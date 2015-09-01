package com.lk.notepad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.os.Environment;

public class NoteListManager {
	private List<String> titles = new ArrayList<String>();
	private String[] contents;
	static final String SDCARD_PATH = Environment.getExternalStorageDirectory().toString() + "/Note";
	
	public NoteListManager(){
//		getNoteList();
	}
	
	//获得目录中的文件放到List中
	public List<String> getNoteList(){
		File sdCardfile = new File(SDCARD_PATH);
		if(sdCardfile.length() > 0){
			File[] files = sdCardfile.listFiles();
			for(int i =0; i<files.length; i++){
				if(files[i].getName().endsWith(".txt")){
					titles.add(files[i].getName());
				}
			}
			return titles;
		}
		return null;
	}
	
	public StringBuilder getNoteContent(String noteName){
		File file = new File(SDCARD_PATH, noteName + ".txt");
		if(file.exists()){
			try {
				InputStream is = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String line;
				StringBuilder values = new StringBuilder("");
				while((line = br.readLine()) != null){
					values.append(line);
				}
				br.close();
				isr.close();
				is.close();
				return values;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
		
	}
	
}
