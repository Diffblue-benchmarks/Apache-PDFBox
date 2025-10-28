package org.apache.pdfbox.pdmodel.interactive.digitalsignature;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.pdfbox.pdfwriter.COSWriter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SigningSupportDiffblueTest {
  /**
   * Method under test: {@link SigningSupport#getContent()}
   */
  @Test
  void testGetContent() throws IOException {
    // Arrange
    COSWriter cosWriter = mock(COSWriter.class);
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    when(cosWriter.getDataToSign()).thenReturn(byteArrayInputStream);

    // Act
    InputStream actualContent = (new SigningSupport(cosWriter)).getContent();

    // Assert
    verify(cosWriter).getDataToSign();
    byte[] byteArray = new byte[8];
    assertEquals(8, actualContent.read(byteArray));
    assertSame(byteArrayInputStream, actualContent);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link SigningSupport#setSignature(byte[])}
   */
  @Test
  void testSetSignature() throws IOException {
    // Arrange
    COSWriter cosWriter = mock(COSWriter.class);
    doNothing().when(cosWriter).writeExternalSignature(Mockito.<byte[]>any());
    SigningSupport signingSupport = new SigningSupport(cosWriter);

    // Act
    signingSupport.setSignature("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    verify(cosWriter).writeExternalSignature(isA(byte[].class));
  }
}
