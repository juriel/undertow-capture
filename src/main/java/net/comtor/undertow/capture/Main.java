package net.comtor.undertow.capture;

import io.undertow.Undertow;

/**
 *
 * @author juriel
 */
public class Main {

    public static void main(String args[]) {
        int PORT = Integer.parseInt(args[0]);
        Undertow server = Undertow.builder()
                .addHttpListener(PORT, "0.0.0.0")
                .setHandler(new CaptureAllHandler())
                .build();

        server.start();

    }

}
