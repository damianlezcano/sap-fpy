

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Decode {

	public byte[] decode(String filename) {
		String str = load(filename);
		return Base64.getDecoder().decode(str);
	}

	public String load(String filename) {
	    String content = "";
	    try
	    {
	        content = new String ( Files.readAllBytes( Paths.get(filename + ".enc") ) );
	    } 
	    catch (IOException e) 
	    {
	        e.printStackTrace();
	    }
	    return content;
	}
	
	public void save(String filename, byte[] content) throws IOException {
		Files.write(Paths.get(filename), content);
	}

	public static void main(String[] args) throws IOException {
		System.out.println("#P1");
		String filename = args[0];
		System.out.println("#P2");
		Decode decode = new Decode();
		System.out.println("#P3");
		byte[] content = decode.decode(filename);
		System.out.println("#P4");
		decode.save(filename, content);
	}
}
