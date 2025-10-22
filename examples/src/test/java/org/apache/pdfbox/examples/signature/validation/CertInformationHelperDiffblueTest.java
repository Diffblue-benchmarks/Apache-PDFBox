package org.apache.pdfbox.examples.signature.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CertInformationHelperDiffblueTest {
  /**
   * Test {@link CertInformationHelper#getSha1Hash(byte[])}.
   * <p>
   * Method under test: {@link CertInformationHelper#getSha1Hash(byte[])}
   */
  @Test
  @DisplayName("Test getSha1Hash(byte[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String CertInformationHelper.getSha1Hash(byte[])"})
  void testGetSha1Hash() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("666356E49057D972D65214688F70C403054BF933",
        CertInformationHelper.getSha1Hash("AXAXAXAX".getBytes("UTF-8")));
  }
}
