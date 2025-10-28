package org.apache.pdfbox.examples.signature.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;

class CertInformationHelperDiffblueTest {
  /**
   * Method under test: {@link CertInformationHelper#getSha1Hash(byte[])}
   */
  @Test
  void testGetSha1Hash() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("666356E49057D972D65214688F70C403054BF933",
        CertInformationHelper.getSha1Hash("AXAXAXAX".getBytes("UTF-8")));
  }
}
