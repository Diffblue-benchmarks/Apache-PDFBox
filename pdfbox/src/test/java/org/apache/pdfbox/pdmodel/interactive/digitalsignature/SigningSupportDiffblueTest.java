package org.apache.pdfbox.pdmodel.interactive.digitalsignature;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.pdfwriter.COSWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SigningSupportDiffblueTest {
  /**
   * Test {@link SigningSupport#setSignature(byte[])}.
   *
   * <ul>
   *   <li>Then calls {@link COSWriter#writeExternalSignature(byte[])}.
   * </ul>
   *
   * <p>Method under test: {@link SigningSupport#setSignature(byte[])}
   */
  @Test
  @DisplayName("Test setSignature(byte[]); then calls writeExternalSignature(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SigningSupport.setSignature(byte[])"})
  void testSetSignature_thenCallsWriteExternalSignature() throws IOException {
    // Arrange
    COSWriter cosWriter = mock(COSWriter.class);
    doNothing().when(cosWriter).writeExternalSignature(Mockito.<byte[]>any());

    // Act
    new SigningSupport(cosWriter).setSignature("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(cosWriter).writeExternalSignature(isA(byte[].class));
  }
}
