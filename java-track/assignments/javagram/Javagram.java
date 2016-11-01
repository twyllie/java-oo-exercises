package javagram;

import javagram.filters.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Javagram {
	
	private static ArrayList<Filter> filters = new ArrayList<Filter>();
	
	private static void addFilter(Filter filter){
		filters.add(filter);
	}
	

	public static void main(String[] args) {
		
		// Build ArrayList of available filters. Sadly hardcoded :(
		addFilter(new BlueFilter());
		addFilter(new InvertFilter());
		addFilter(new GrayscaleFilter());
		
		// Create the base path for images		
		String[] baseParts = {System.getProperty("user.dir"), "images"};
		String opened = "";
		String dir = String.join(File.separator, baseParts);
		String relPath = "";
		Picture picture = null;
		Scanner in = new Scanner(System.in);
		
		// prompt user for image to filter and validate input
		String imagePath = "path not set";
		do {
			
			
			// try to open the file
			try {
				
				System.out.println("Image path (relative to " + dir + "):");
				relPath = in.next();
				
				String[] relPathParts = relPath.split(File.separator);
				opened = relPathParts[relPathParts.length -1];
				imagePath = dir + File.separator + String.join(File.separator, Arrays.asList(relPathParts));

				picture = new Picture(imagePath);
				
			} catch (RuntimeException e) {
				System.out.println("Could not open image: " + imagePath);
			}
			
		} while(picture == null);
		
		//  prompt user for filter and validate input
		Filter filter = null;
		boolean valid = false;
		int input = 0;
		do{
			try{
				input = displayFilterMenu(in);
				filter = getFilter(input);
				valid = true;
			}
			catch(IndexOutOfBoundsException error){
				System.out.println("That was not a valid selection.");
				valid = false;
			}
			catch(InputMismatchException error){
				System.out.println("You have not entered a valid integer. Please enter only an integer.");
				valid = false;
				in.next();
			}
		}while(!valid);

		// filter and display image
		Picture processed = filter.process(picture);
		processed.show();
		
		System.out.println("Image successfully filtered");
		
		// save image, if desired
		boolean unsure = false;
		do{
			unsure = false;
			System.out.println("Save image to (relative to " + dir + ") (type 'exit' to quit w/o saving):");
			String fileName = in.next();
			
			// TODO - if the user enters the same file name as the input file, confirm that they want to overwrite the original
			
			if (fileName.equals("exit")) {
				System.out.println("Image not saved");
			} 
			
			else if(fileName.equals(opened)||fileName.equals(relPath)) {
				System.out.println("This will save over the current file. Are you sure?\nPlease enter 'y' or 'n'");
				String sure = in.next();
				
				if (sure == "y" || sure == "Y"){
					System.out.println("The original file has been overwritten");
				}
				
				else {
					System.out.println("Please enter a different file name");
					unsure = true;
				}
				
			} 
			
			else {
				String absFileName = dir + File.separator + fileName;
				processed.save(absFileName);
				System.out.println("Image saved to " + absFileName);
			}
		}while(unsure == true);
		
		// close input scanner
		in.close();
	}
	
	private static Filter getFilter(int input) {
		int index = input - 1;
		return filters.get(index);	
	}
	
	private static int displayFilterMenu(Scanner in){
		System.out.println("Please select a filter to use:");
		for(int i = 0; i < filters.size(); i++){
			System.out.println((i+1) + "- " + filters.get(i).getTitle());
			System.out.println("    Effect: " + filters.get(i).getDesc());
		}
		int input = in.nextInt();
		return input;
	}

}