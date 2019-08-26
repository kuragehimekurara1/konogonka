package konogonka.Tools.NPDM;

import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;

public class ServiceAccessControlProvider {

    private LinkedHashMap<Byte, String> collection;

    public ServiceAccessControlProvider(byte[] bytes){
        collection = new LinkedHashMap<>();
        byte key;
        String value;

        int i = 0;

        while (i < bytes.length){
            key = bytes[i];
            value = new String(bytes, i+1, getSize(key), StandardCharsets.UTF_8);
            collection.put(key, value);
            i += getSize(key)+1;
        }
    }

    private int getSize(byte control) {
        return ((byte) 0x7 & control) + 1;
    }

    public LinkedHashMap<Byte, String> getCollection() { return collection; }
}
