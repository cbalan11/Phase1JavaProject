import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.Path;
import java.util.regex.*;

public class FileOperationsApp {

boolean found = false;
 public void findMyFile(String name,File file)
   {
       File[] list = file.listFiles();
       if(list!=null)
       for (File fil : list)
       {
           if (fil.isDirectory())
           {
           
findMyFile(name,fil);
           }
           else if (name.equalsIgnoreCase(fil.getName()))
           {
               System.out.println("File found in " + fil.getParentFile());
               break;
           }
           
 
           
System.out.println("File not similar with " + fil.getName());
       }
   }
public static void main(String[] args) throws IOException {
// TODO Auto-generated method stub

		System.out.println(" ^ HELLO, USER! ^ ");
		System.out.println("This application was developed by Balan Costin");
		System.out.println("~ These are the file operations you can choose from ~");
		System.out.println("Order files in ascending order : choose A");
		System.out.println("Add a user specified file from the app : choose B");
		System.out.println("Delete a user specified file from the app : choose C");
		System.out.println("Search a user specified file from the app : choose D");
		System.out.println("Close the application : choose ESC");
		System.out.println("~ You looked for ~");

Scanner scan = new Scanner(System.in);

String optionChosen = scan.next();
System.out.println(optionChosen);

switch(optionChosen) {
case "A":
	System.out.println(" - SORT FILES IN ASCENDING ORDER IN A SPECIFIED DIRECTORY - ");
	Scanner readerAsc = new Scanner(System.in);
	boolean successAsc = false;
	System.out.println("Enter path of directory to sort:"); 
	String dirAsc = readerAsc.nextLine();
	File folder = new File(dirAsc);
	if (folder.isDirectory()) {
		File[] fileList = folder.listFiles();
		Arrays.sort(fileList);
		for (File file:fileList) {
			System.out.println(file.getName());
	}
	}
	readerAsc.close();
	break;
case "B":
		System.out.println(" - ADDING A NEW FILE TO A SPECIFIED DIRECTORY - ");
		Scanner reader = new Scanner(System.in);
		boolean success = false;
		System.out.println("Enter path of directory to create:"); 
		String dir = reader.nextLine();
		System.out.println("Enter file name to be created "); 
		String filename = reader.nextLine(); 
		File f = new File(filename); 
		if (f.exists()) { 
			System.out.println("File already exists"); } 
		else { 
			System.out.println("No such file exists, creating now"); 
		success = f.createNewFile(); 
			if (success) { 
			System.out.printf("Successfully created new file: %s%n", f); 
		} 
			else { 
			System.out.printf("Failed to create new file: %s%n", f); 
		} 
		} 
		reader.close();
		break;
case "C":
	System.out.println(" - DELETE FILE FROM A SPECIFIED DIRECTORY - ");
	Scanner reader2 = new Scanner(System.in);
	System.out.println("Enter path of directory to delete:"); 
	String dir2 = reader2.nextLine();
	System.out.println("Enter file name to be deleted "); 
	String filename2 = reader2.nextLine(); 
	dir2 = dir2 + "\\" + filename2;
	String path = FileSystems.getDefault().getPath(dir2).toString();
	//Files.delete(path);
	File file = new File(path);
	if (file.exists()) {
	   file.delete();
	   System.out.println("File deleted!");
	} 
	else {
	   System.err.println(
	       "The app can't get '" + file + "' ('" + file.getAbsolutePath() + "')");
	}
	reader2.close();
	break;
case "D":
	System.out.println(" - SEARCH FOR A FILE FROM A SPECIFIED DIRECTORY - ");
	Scanner reader3 = new Scanner(System.in);
	System.out.println("Enter path of directory to search in:"); 
	String dir3 = reader3.nextLine();
	System.out.println("Enter file name to be searched "); 
	String filenameToSearch = reader3.nextLine(); 
	FileOperationsApp ff = new FileOperationsApp();
	ff.findMyFile(filenameToSearch,new File(dir3));
	reader3.close();
	break;
case "ESC":
	System.out.println(" - APPLICATION CLOSED BY USER - ");
	System.exit(0);
	break;
default:
       System.out.println("INVALID - this is not a valid option. Please retry!");
}
	scan.close();

}

}
