package org.apache.pdfbox.pdmodel.interactive.digitalsignature;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.pdfbox.pdfwriter.COSWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SigningSupportDiffblueTest {
  /**
   * Test {@link SigningSupport#getContent()}.
   * <ul>
   *   <li>Then return read is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link SigningSupport#getContent()}
   */
  @Test
  @DisplayName("Test getContent(); then return read is eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"InputStream SigningSupport.getContent()"})
  void testGetContent_thenReturnReadIsEight() throws IOException {
    // Arrange
    COSWriter cosWriter = mock(COSWriter.class);
    when(cosWriter.getDataToSign()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    InputStream actualContent = (new SigningSupport(cosWriter)).getContent();

    // Assert
    verify(cosWriter).getDataToSign();
    byte[] byteArray = new byte[8];
    assertEquals(8, actualContent.read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link SigningSupport#setSignature(byte[])}.
   * <ul>
   *   <li>Then calls {@link COSWriter#writeExternalSignature(byte[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SigningSupport#setSignature(byte[])}
   */
  @Test
  @DisplayName("Test setSignature(byte[]); then calls writeExternalSignature(byte[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SigningSupport.setSignature(byte[])"})
  void testSetSignature_thenCallsWriteExternalSignature() throws IOException {
    // Arrange
    COSWriter cosWriter = mock(COSWriter.class);
    doNothing().when(cosWriter).writeExternalSignature(Mockito.<byte[]>any());
    SigningSupport signingSupport = new SigningSupport(cosWriter);

    // Act
    signingSupport.setSignature("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(cosWriter).writeExternalSignature(isA(byte[].class));
  }
}
