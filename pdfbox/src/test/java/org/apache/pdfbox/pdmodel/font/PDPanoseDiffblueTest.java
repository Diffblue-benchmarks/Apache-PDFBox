package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDPanoseDiffblueTest {
  /**
   * Test {@link PDPanose#PDPanose(byte[])}.
   * <p>
   * Method under test: {@link PDPanose#PDPanose(byte[])}
   */
  @Test
  @DisplayName("Test new PDPanose(byte[])")
  void testNewPDPanose() throws UnsupportedEncodingException {
    // Arrange and Act
    PDPanose actualPdPanose = new PDPanose("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    PDPanoseClassification panose = actualPdPanose.getPanose();
    assertEquals(0, panose.getArmStyle());
    assertEquals(0, panose.getLetterform());
    assertEquals(0, panose.getMidline());
    assertEquals(0, panose.getXHeight());
    assertEquals(16728, actualPdPanose.getFamilyClass());
    assertEquals(65, panose.getContrast());
    assertEquals(65, panose.getFamilyKind());
    assertEquals(65, panose.getWeight());
    assertEquals(88, panose.getProportion());
    assertEquals(88, panose.getSerifStyle());
    assertEquals(88, panose.getStrokeVariation());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0}, panose.getBytes());
  }

  /**
   * Test {@link PDPanose#getFamilyClass()}.
   * <ul>
   *   <li>Given {@link PDPanose#PDPanose(byte[])} with bytes is {@code AXAXAXAX}
   * Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 16728}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPanose#getFamilyClass()}
   */
  @Test
  @DisplayName("Test getFamilyClass(); given PDPanose(byte[]) with bytes is 'AXAXAXAX' Bytes is 'UTF-8'; then return '16728'")
  void testGetFamilyClass_givenPDPanoseWithBytesIsAxaxaxaxBytesIsUtf8_thenReturn16728()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(16728, (new PDPanose("AXAXAXAX".getBytes("UTF-8"))).getFamilyClass());
  }

  /**
   * Test {@link PDPanose#getPanose()}.
   * <ul>
   *   <li>Then return ArmStyle is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPanose#getPanose()}
   */
  @Test
  @DisplayName("Test getPanose(); then return ArmStyle is zero")
  void testGetPanose_thenReturnArmStyleIsZero() throws UnsupportedEncodingException {
    // Arrange and Act
    PDPanoseClassification actualPanose = (new PDPanose("AXAXAXAX".getBytes("UTF-8"))).getPanose();

    // Assert
    assertEquals(0, actualPanose.getArmStyle());
    assertEquals(0, actualPanose.getLetterform());
    assertEquals(0, actualPanose.getMidline());
    assertEquals(0, actualPanose.getXHeight());
    assertEquals(65, actualPanose.getContrast());
    assertEquals(65, actualPanose.getFamilyKind());
    assertEquals(65, actualPanose.getWeight());
    assertEquals(88, actualPanose.getProportion());
    assertEquals(88, actualPanose.getSerifStyle());
    assertEquals(88, actualPanose.getStrokeVariation());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0}, actualPanose.getBytes());
  }
}
