import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
	File file = new File(args[0]);
	if (!file.exists()) {
	    System.out.println(args[0] + " does not exist.");
	    return;
	}
	if (!(file.isFile() && file.canRead())) {
	    System.out.println(file.getName() + " cannot be read from.");
	    return;
	}
	try {
	    FileInputStream fis = new FileInputStream(file);
	    char current;
	    while (fis.available() > 0) {
		current = (char) fis.read();
		System.out.print(current);
		System.out.print(':');
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}
