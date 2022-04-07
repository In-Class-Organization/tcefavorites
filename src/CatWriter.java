import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class CatWriter {

	public static void main(String [] args) {
		Cat cat = new Cat("Fuzzy",true,new Date(6,10,2006));
		Cat cat2 = new Cat("Stripe", false, new Date(8, 11, 2018));
		ArrayList<Cat> ourCats = new ArrayList<Cat>();
		ourCats.add(cat);
		ourCats.add(cat2);
		System.out.println(cat);
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("cat.bin"));
//			out.writeObject(ourCats);
			out.writeObject(cat);
			out.writeObject(cat2);
			out.close();
		}
		catch (IOException e) {
			System.out.println("IO Error occured");
			e.printStackTrace();
		}
	}
	
}
