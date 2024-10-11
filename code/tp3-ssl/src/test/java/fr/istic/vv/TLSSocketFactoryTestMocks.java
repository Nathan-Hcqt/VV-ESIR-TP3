package fr.istic.vv;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TLSSocketFactoryTestMocks {

    @Test 
    public void reparedSocket_NullProtocols(){

        TLSSocketFactory fmock = new TLSSocketFactory();
        SSLSocket mockSocket = mock(SSLSocket.class);

        when(mockSocket.getSupportedProtocols()).thenReturn(null);
        when(mockSocket.getEnabledProtocols()).thenReturn(null);

        fmock.prepareSocket(mockSocket);
        verify(mockSocket, never()).setEnabledProtocols(any());

    }

    @Test
    public void typical(){
        TLSSocketFactory fmock = new TLSSocketFactory();
        SSLSocket mockSocket = mock(SSLSocket.class);

        when(mockSocket.getSupportedProtocols()).thenReturn(shuffle(new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"}));
        when(mockSocket.getEnabledProtocols()).thenReturn(shuffle(new String[]{"SSLv3", "TLSv1"}));

        fmock.prepareSocket(mockSocket);
        verify(mockSocket).setEnabledProtocols(argThat(protocols -> Arrays.equals(protocols, new String[] {"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3" })));
    }

    private String[] shuffle(String[] in) {
        List<String> list = Arrays.asList(in);
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }

}