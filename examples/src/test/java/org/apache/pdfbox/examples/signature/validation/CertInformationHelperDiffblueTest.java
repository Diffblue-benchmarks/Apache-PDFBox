package org.apache.pdfbox.examples.signature.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CertInformationHelperDiffblueTest {
  /**
   * Test {@link CertInformationHelper#getSha1Hash(byte[])}.
   * <ul>
   *   <li>Then return {@code 666356E49057D972D65214688F70C403054BF933}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CertInformationHelper#getSha1Hash(byte[])}
   */
  @Test
  @DisplayName("Test getSha1Hash(byte[]); then return '666356E49057D972D65214688F70C403054BF933'")
  void testGetSha1Hash_thenReturn666356e49057d972d65214688f70c403054bf933() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("666356E49057D972D65214688F70C403054BF933",
        CertInformationHelper.getSha1Hash("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link CertInformationHelper#getSha1Hash(byte[])}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@code BAFB1FD5F1FAB34FCD835A3D2EB0F6D686CB33FD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CertInformationHelper#getSha1Hash(byte[])}
   */
  @Test
  @DisplayName("Test getSha1Hash(byte[]); when 'A'; then return 'BAFB1FD5F1FAB34FCD835A3D2EB0F6D686CB33FD'")
  void testGetSha1Hash_whenA_thenReturnBafb1fd5f1fab34fcd835a3d2eb0f6d686cb33fd() {
    // Arrange, Act and Assert
    assertEquals("BAFB1FD5F1FAB34FCD835A3D2EB0F6D686CB33FD",
        CertInformationHelper.getSha1Hash(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }
}
