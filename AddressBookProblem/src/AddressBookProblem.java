
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class AddressBookProblem {

		Scanner scanner = new Scanner(System.in);

		public static void main(String[] args) throws Exception {
			System.out.println("Welcome to address book problem");
			AddressBookProblem addressBook = new AddressBookProblem();
			addressBook.askUser();

	}

void askUser() throws Exception {
	System.out.println("Select an action..");
	System.out.println("1. To Create a new contact");
	System.out.println("2. To fill details of contact");
	System.out.println("3. To display/read details of contact");
	System.out.println("4. To delete");
	System.out.println("5. To edit the details of contact");
	System.out.println("6. Quit");
	int choice = scanner.nextInt();
	switch(choice) {
	case 1:
		System.out.print("You Choose to create a new contact \n");
		createNewContact();
		System.out.println("\n");
		askUser();
		break;
	case 2:
	        
		fillDetailsOfContact();
		System.out.println("\n");
		askUser();
		break;
	case 3:
		readDetailsOfContact();
		System.out.println("\n");
		askUser();
		break;
	case 4:
		deleteFile();
		System.out.println();
		askUser();
		break;
	case 5:
		editDetails();
		System.out.println();
		askUser();
		break;
		
	default:
		break;
	}
}

private void createNewContact() {
	System.out.print("Enter file name: ");
	String fileName = scanner.next();
	try {
		File myObj = new File("D:addressbookof"+fileName);
		if (myObj.createNewFile()) {
			System.out.println("File created: "+ myObj.getName());

		}  else {
			System.out.println("File already exists.");

	}
} catch (IOException e) {
	System.out.println("An error occured.");
	e.printStackTrace();
}

}
private void fillDetailsOfContact() {
	System.out.print("Enter file name to write: ");
	String fileName = scanner.next();
	File write = new File("D:addressbookof"+fileName);
	try{
	    if(!write.exists()){
	        System.out.println("We had to make a new file.");
	        write.createNewFile();
	    }

	    FileWriter fileWriter = new FileWriter(write, true);

	    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	    @SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in); 
	   
	    System.out.print("\nEnter firstName:");  
	    String firstName= sc.nextLine();
	    System.out.println("\nEnter lastName");
        String lastName = sc.nextLine();  
	    System.out.print("\nYou entered firstname and lastname: "+firstName +lastName);   
		bufferedWriter.write( firstName);
        bufferedWriter.write( lastName );
        System.out.print("\nEnter a address: ");
        String address= sc.nextLine();
        System.out.print("\nYou entered address: "+address);
        bufferedWriter.write(   address.toString());
        System.out.print("\nEnter city:");  
	    String city= sc.nextLine();
	    System.out.print("\nEnter state:");
        String state=sc.nextLine();
        System.out.print("\nEnter zip:");
        String zip;
        while(true) {
        	zip= sc.nextLine();                
		    String zipRegex = "^[0-9]{6}$";
		      if( zip.matches(zipRegex))
				  {
		    	  System.out.print("\nYou entered zip: "+zip);
				  break;
				  }
		     else
		    	  System.out.println("Entered zip is invalid");
        }
        
        System.out.print("\n entered city: "+city);
        bufferedWriter.write(city.toString());
        System.out.print("\nYou entered state: "+state); 
	    bufferedWriter.write( state.toString());
	    System.out.print("\nYou entered zip: "+zip); 
        bufferedWriter.write( zip.toString());
	    System.out.print("\nEnter phoneNumber: ");  
	    String phoneNumber;
	    while(true) 
		   {
		    System.out.print("\nEnter phoneNumber: ");  
		    phoneNumber= sc.nextLine();              //reads string  
		    String phoneNumberRegex = "^(\\d{2}[ ]){1}\\d{8}$";
		      if( phoneNumber.matches(phoneNumberRegex))
		      {
				  System.out.print("\nYou entered phoneNumber: "+phoneNumber);   
				  break;
		      }
		      else
		    	  System.out.println("Entered mobile number is invalid");
		   }   
		bufferedWriter.write( phoneNumber.toString() );
	    bufferedWriter.close();
	    System.out.println("\nDone");
	} catch(IOException e) {
	    System.out.println("COULD NOT WRITE INTO FILE!!");
	}
	
}

private void readDetailsOfContact() {
	System.out.print("Enter file name to read: ");
	String fileName = scanner.next();
    try {
  	  File myObj = new File("D:addressbookof" +fileName);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
          String data = myReader.nextLine();
          System.out.println(data);
        }
        myReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }


}
private void deleteFile() { 
		   @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		   System.out.print("Enter file name to delete: ");
		   String fileName = scanner.next();
		   File file = new File("D:addressbookof"+fileName); 
	        if(file.delete()) 
	        { 
	            System.out.println("File deleted successfully"); 
	        } 
	        else
	        { 
	            System.out.println("file is not available to delete"); 
	        }
	
}
private void editDetails() throws Exception 
{
	System.out.print("Enter contact name to read: ");
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);
	String contactName = scanner.next();
	System.out.println("\nYou choose to EDIT");
	System.out.println("Press 1 to EDIT Address");
	System.out.println("Press 2 to EDIT firstname");
	System.out.println("Press 3 to EDIT secondname");
	System.out.println("Press 4 to EDIT city");
	System.out.println("Press 5 to EDIT state");
	System.out.println("Press 6 to EDIT zip");
	System.out.println("Press 7 to EDIT phonenumber");

	int choice = scanner.nextInt();
	switch(choice) 
	{
	case 1:
		editoptions(choice,contactName); 
        break;
	case 2:
		editoptions(choice,contactName); 
        break;
	case 3:
		editoptions(choice,contactName); 
        break;
	case 4:
		editoptions(choice,contactName); 
        break;
	case 5:
		editoptions(choice,contactName); 
        break;
	case 6:
		editoptions(choice,contactName); 
        break;
	case 7:
		editoptions(choice,contactName); 
        break;
}
}
 public static void setVariable(int lineNumber, String data,String contactName) throws IOException 
 {
		
	    Path path = Paths.get("D:addressbookof"+contactName);
	    java.util.List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
	    lines.set(lineNumber - 1, data);
	    Files.write(path, lines, StandardCharsets.UTF_8);
 }
 void editoptions(int choice,String contactName) 
 {
	    @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
	    System.out.print("\n Enter text :");
		String Text = scanner.next();
		try
		{
		@SuppressWarnings("unused")
		File obj =new File("D:addressbookof"+contactName);
	    setVariable(choice, Text,contactName);
	    System.out.println("Done");
		} 
		catch(IOException e)
		{
		    System.out.println("COULD NOT EDIT FILE");
					
		}
 }
}
