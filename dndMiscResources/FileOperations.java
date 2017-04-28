package dndMiscResources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileOperations {
	
	public void writePCToFile(PlayerCharacter pc){
		String fileName = ".\\src\\dndMiscResources\\Characters\\" + pc.getPlayerName() + ".ser";
		try{
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(pc);
			oos.close();
		} catch (FileNotFoundException ex){
			ex.printStackTrace();
		} catch (IOException ex){
			ex.printStackTrace();
		}
	}
	
	public void listExisting(){
		String dirName = ".\\src\\dndMiscResources\\Characters"; // Directory containing char files
		File dir = new File(dirName); // create file object of the directory
		
		// Actually code found off stackoverflow. Annotated with what I think is going on.
		File[] x = dir.listFiles(new FilenameFilter() { // Create array of Files that is a list of the files in the directory
	        public boolean accept(File dir, String name) { // 
	            return name.toLowerCase().endsWith(".ser"); // Returns whether the file, in lowercase, ends with .ser (i.e. .serial)
	        }
	    });
		for(int i = 0; i < x.length; i++){
			String p = x[i].toString();
			System.out.println(p.substring(dirName.length()+1, p.length()-4));
		}
	}
	
	public boolean pcExists(String playerName){
		String path = ".\\src\\dndMiscResources\\Characters\\" + playerName + ".ser";
		File fileToCheck = new File(path);
		return fileToCheck.exists();
	}
	
	public void createFile(String playerName){
		String path = ".\\src\\dndMiscResources\\Characters\\" + playerName + ".ser";
		File toCreate = new File(path);
		try{
			toCreate.createNewFile();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public PlayerCharacter readPCFromFile(String playerName){
		String fileName = ".\\src\\dndMiscResources\\Characters\\" + playerName + ".ser";
		PlayerCharacter toRet = new PlayerCharacter();
		try{
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			PlayerCharacter ret = (PlayerCharacter) ois.readObject();
			ois.close();
			
			System.out.println("Loading " + ret.getName());
			toRet = ret;
		} catch (FileNotFoundException ex){
			ex.printStackTrace();
		} catch (IOException ex){
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return toRet;
	}
}
