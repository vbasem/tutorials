package shared;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class SerializationHelper
{
	public static final String SERIALIZATION_PATH = "c:\\temp\\object";
	
	public static ObjectOutputStream globalOos = null;
	public static ObjectInputStream globalOis = null;
	
	protected static void initializeOutputStream() {
		if (globalOos == null) {
			// output stream and object output stream
			OutputStream os;
			try
			{
				os = new FileOutputStream(SerializationHelper.getSerializationFileHandle());
				globalOos = new ObjectOutputStream(os);
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	private static void initializeInputStream() {
		if (globalOis == null) {
			InputStream is;
			try
			{
				is = new FileInputStream(getSerializationFileHandle());
				globalOis = new ObjectInputStream(is);
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static File getSerializationFileHandle() {
		
		File f= new File(SERIALIZATION_PATH);
		
		if (!f.exists()) {
			try
			{
				f.createNewFile();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return f;
	}
	
	public static void serializeObject(Object o) throws IOException {
		// output stream and object output stream
		OutputStream os = new FileOutputStream(SerializationHelper.getSerializationFileHandle());
		ObjectOutputStream oos = new ObjectOutputStream(os);
		
		// write object to file
		oos.writeObject(o);
		
		// close handles
		oos.close();
	}
	
	public static Object deserializerObject() throws IOException, ClassNotFoundException {
		// input stream and object input stream form file
		InputStream is = new FileInputStream(getSerializationFileHandle());
		
		ObjectInputStream ois = new ObjectInputStream(is);
		
		return ois.readObject();
	}
	
	public static void contuniesSerialization(Object o) throws IOException {
		initializeOutputStream();
		
		globalOos.writeObject(o);
	}
	
	public static Object continuesDeserialization() throws ClassNotFoundException, IOException {
		initializeInputStream();
		return globalOis.readObject();
	}
}
