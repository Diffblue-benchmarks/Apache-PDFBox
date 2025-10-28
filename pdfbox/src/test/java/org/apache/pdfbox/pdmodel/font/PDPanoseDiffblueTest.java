package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;

class PDPanoseDiffblueTest {
  /**
   * Method under test: {@link PDPanose#getFamilyClass()}
   */
  @Test
  void testGetFamilyClass() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(16728, (new PDPanose("AXAXAXAX".getBytes("UTF-8"))).getFamilyClass());
  }

  /**
   * Method under test: {@link PDPanose#getPanose()}
   */
  @Test
  void testGetPanose() throws UnsupportedEncodingException {
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

  /**
   * Method under test: {@link PDPanose#PDPanose(byte[])}
   */
  @Test
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
}
