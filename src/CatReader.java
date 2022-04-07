import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class CatReader {

	public static void main(String [] args) {
		ObjectInputStream in=null;
		ArrayList<Cat> myCats = new ArrayList<Cat>();
		try { 
			System.out.println("Cat reader!");
			in = new ObjectInputStream(new FileInputStream("cat.bin"));

			while (true)
			{
				Object o = in.readObject();
				Cat aCat = (Cat) o;
				myCats.add(aCat);
			}

/*			
			if (o instanceof ArrayList()) {
				Cat cat = (Cat) o;
				System.out.println(cat);
			}
			else {
				System.out.println("File did not contain a cat");
			} */
		} 
		catch (ClassNotFoundException e) {
			System.out.println("Class IO had problem");
			System.exit(0);
			
		}
		catch (EOFException e) {
			System.out.println("Read all the cats!");
		}
		
		catch (IOException e) {
			System.out.println("Error");
		}
		for (Cat aCat: myCats)
		{
			System.out.println(aCat);
		}
	}
}
