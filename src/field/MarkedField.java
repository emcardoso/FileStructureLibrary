package field;

import java.io.IOException;
import java.util.LinkedList;

public abstract class MarkedField implements VariableSizeField {
    protected byte fieldMarker;
    private BytePageList p;

    public MarkedField() {
        p = new BytePageList(256);
        fieldMarker = getFieldMarker();
    }

    public abstract byte getFieldMarker();

    public void read(ReadStream rs) throws IOException {
        int date;
        // ler do arquivo
        date = rs.read();
        while ((date != -1) && (date != fieldMarker)) {
              p.add((byte)date);           
              date = rs.read();
        }
        byte v[] = p.getContent();
        unpack(v);
    }

    public void write(WriteStream ws) throws IOException {
        byte v[] = pack();
        ws.write(v);
        ws.write(new byte[]{fieldMarker});
    }
}