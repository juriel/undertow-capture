package net.comtor.undertow.capture;

import io.undertow.io.Receiver;
import io.undertow.server.HttpServerExchange;

/**
 *
 * @author juriel
 */
public class CustomFullBytesCallback implements Receiver.FullBytesCallback {

    public CustomFullBytesCallback() {
    }

    @Override
    public void handle(HttpServerExchange hse, byte[] bytes) {
        System.out.println(new String(bytes));
    }

}
