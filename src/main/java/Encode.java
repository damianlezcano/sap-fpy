

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Encode {

	public String encoder(String filePath) {
		String base64File = "";
		File file = new File(filePath);
		try (FileInputStream imageInFile = new FileInputStream(file)) {
			// Reading a file from file system
			byte fileData[] = new byte[(int) file.length()];
			imageInFile.read(fileData);
			base64File = Base64.getEncoder().encodeToString(fileData);
		} catch (FileNotFoundException e) {
			System.out.println("File not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while reading the file " + ioe);
		}
		return base64File;
	}

	public void save(String filename, String content) throws IOException {
		Files.write(Paths.get(filename), content.getBytes());
	}

	public static void main(String[] args) throws IOException {
		String filename = args[0];
		Encode encode = new Encode();
		String content = encode.encoder(filename);
		encode.save(filename + ".enc", content);
	}
}
