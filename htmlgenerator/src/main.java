import gui.ava.html.image.generator.HtmlImageGenerator;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		if (args.length != 1) {  
            System.out.println("Wrong arguments.");  
            return;  
        }  
        String file = args[0];
        File htmlFile = new File(file);
        if(htmlFile.exists()){
        	String html = readFile(file);
        	HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
    		imageGenerator.loadHtml(html);
    		imageGenerator.saveAsImage("output.png");
    		System.out.println("done..."); 
        }else{
        	System.out.println("html file doesn't exist."); 
        }
        return;
	}
	
	private static String readFile(String pathname) throws IOException {

	    File file = new File(pathname);
	    StringBuilder fileContents = new StringBuilder((int)file.length());
	    Scanner scanner = new Scanner(file);
	    String lineSeparator = System.getProperty("line.separator");

	    try {
	        while(scanner.hasNextLine()) {        
	            fileContents.append(scanner.nextLine() + lineSeparator);
	        }
	        return fileContents.toString();
	    } finally {
	        scanner.close();
	    }
	}

}
