//////////////////////////////
//character counter for files
//////////////////////////////
import java.io.*;
public class CharacterCounter {

	private final char look;
	private FileReader file01 = new FileReader("src/File01.txt");

	//Constructor
	CharacterCounter(FileReader file, char look) throws IOException {
		this.file01 = file;
		this.look = look;
	}

	//find file and read it into a String
	private String readFile() throws IOException {
		String everything;

		try(BufferedReader br = new BufferedReader(file01)) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			everything = sb.toString();
		}
		return everything;
	}
	
	//read through the string and count for character
	private int countCharacter(String line) {
		int count = 0;

		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == look) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		FileReader file01 = new FileReader("src/File01.txt");
		CharacterCounter cc = new CharacterCounter(file01, 'x');

		System.out.println(cc.countCharacter(cc.readFile()));
	}

}