package com.epam.app.inputstream;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyInputStream extends FilterInputStream {
    private byte[] buf;
    private int pos;

    private void ensureOpen() throws IOException {
        if (in == null)
            throw new IOException("Stream closed");
    }

    private MyInputStream(InputStream in, int size) {
        super(in);
        if (size <= 0) {
            throw new IllegalArgumentException("size <= 0");
        }
        this.buf = new byte[size];
        this.pos = size;
    }

    public MyInputStream(InputStream in) {
        this(in, 1);
    }

    @Override
    public int read() throws IOException {
        ensureOpen();
        if (pos < buf.length) {
            return buf[pos++] & 0xff;
        }
        return super.read();
    }

    public void unread(int b) throws IOException {
        ensureOpen();
        if (pos == 0) {
            throw new IOException("Push back buffer is full");
        }
        buf[--pos] = (byte) b;
    }
}

