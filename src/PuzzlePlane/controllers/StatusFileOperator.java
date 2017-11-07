package PuzzlePlane.controllers;

import java.util.List;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class StatusFileOperator {
	File file;
	Scanner scan;
	BufferedWriter writer;
	
	public StatusFileOperator(String path){
		this.file = new File(path);
	}
	
	public StatusFileOperator() {
		
	}
	
	public void setFilePath(String path) {
		this.file = new File(path);
	}
		
	public void writeFile(List<Boolean> status){
		try {
			this.writer = new BufferedWriter(new FileWriter(this.file, false));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (boolean s: status) {
			String content = String.valueOf(s? 1:0)+" ";
			try {
				this.writer.write(content);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			this.writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Boolean> loadFile(){
		ArrayList<Boolean> status = new ArrayList<>();
		try {
			this.scan = new Scanner(this.file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String str = scan.nextLine();
		String[] arr = str.split(" ");
		for(int i = 0; i<10;i++) {
			status.add(Integer.parseInt(arr[0])==1);
		}
		this.scan.close();
		System.out.println(status);
		return status;
	}

}
