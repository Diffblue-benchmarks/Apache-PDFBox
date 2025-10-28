package org.apache.pdfbox;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LoaderDiffblueTest {
  /**
   * Method under test: {@link Loader#loadFDF(InputStream)}
   */
  @Test
  void testLoadFDF() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any()))
        .thenThrow(new IOException("org.apache.pdfbox.pdfparser.nonSequentialPDFParser.eofLookupRange"));
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Loader.loadFDF(input));
    verify(input).read(isA(byte[].class));
    verify(input, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
  }
}
