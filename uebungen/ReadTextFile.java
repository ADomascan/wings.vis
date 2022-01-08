import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class ReadTextFile {

	public static void main(String[] args) {
		BufferedReader in = null;
		try {
			URL url = ReadTextFile.class.getResource("textdatei.txt");
			in = new BufferedReader(new FileReader(url.getPath()));
			String s = "";
			String res;
			while ((res = in.readLine()) != null) {
				s = s + res + "\n";
			}
			System.out.println(s);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}