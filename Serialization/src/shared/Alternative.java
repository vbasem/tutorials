package shared;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * 
 * This is the alternative to serializeable
 *
 * Externalizable requires the user to specify how fields are serialized
 * or deserialized
 *
 */
public class Alternative implements Externalizable {

    @Override
    public void readExternal(ObjectInput arg0) throws IOException,
	    ClassNotFoundException {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void writeExternal(ObjectOutput arg0) throws IOException {
	// TODO Auto-generated method stub
	
    }

}
