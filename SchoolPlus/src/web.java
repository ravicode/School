
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ravi
 */
public class web {

    public web ()
    {
    try{
	URL url = new URL("http://www.duccsystems.com");
	URLConnection connection = url.openConnection();
	connection.connect();
	Scanner in = new Scanner(connection.getInputStream());

	while(in.hasNextLine()){

		String line = in.nextLine();
		System.out.println(line);

				}
}

catch(Exception e)
		{
		System.out.println(e);
}
    }

    public static void main(String args[])
    {
        new web();
    }
}
