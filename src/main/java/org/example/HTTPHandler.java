package org.example;

import java.io.BufferedOutputStream;
import java.io.IOException;

public interface HTTPHandler {
    public abstract void handle(Request request, BufferedOutputStream responseStream) throws IOException;
}
