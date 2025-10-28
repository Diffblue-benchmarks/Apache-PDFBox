package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;

class PDPanoseClassificationDiffblueTest {
  /**
   * Method under test: {@link PDPanoseClassification#getFamilyKind()}
   */
  @Test
  void testGetFamilyKind() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(65, (new PDPanoseClassification("AXAXAXAX".getBytes("UTF-8"))).getFamilyKind());
  }

  /**
   * Method under test: {@link PDPanoseClassification#getSerifStyle()}
   */
  @Test
  void testGetSerifStyle() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(88, (new PDPanoseClassification("AXAXAXAX".getBytes("UTF-8"))).getSerifStyle());
  }

  /**
   * Method under test: {@link PDPanoseClassification#getWeight()}
   */
  @Test
  void testGetWeight() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(65, (new PDPanoseClassification("AXAXAXAX".getBytes("UTF-8"))).getWeight());
  }

  /**
   * Method under test: {@link PDPanoseClassification#getProportion()}
   */
  @Test
  void testGetProportion() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(88, (new PDPanoseClassification("AXAXAXAX".getBytes("UTF-8"))).getProportion());
  }

  /**
   * Method under test: {@link PDPanoseClassification#getContrast()}
   */
  @Test
  void testGetContrast() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(65, (new PDPanoseClassification("AXAXAXAX".getBytes("UTF-8"))).getContrast());
  }

  /**
   * Method under test: {@link PDPanoseClassification#getStrokeVariation()}
   */
  @Test
  void testGetStrokeVariation() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(88, (new PDPanoseClassification("AXAXAXAX".getBytes("UTF-8"))).getStrokeVariation());
  }

  /**
   * Method under test: {@link PDPanoseClassification#getArmStyle()}
   */
  @Test
  void testGetArmStyle() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(65, (new PDPanoseClassification("AXAXAXAX".getBytes("UTF-8"))).getArmStyle());
  }

  /**
   * Method under test: {@link PDPanoseClassification#getLetterform()}
   */
  @Test
  void testGetLetterform() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(88, (new PDPanoseClassification("AXAXAXAX".getBytes("UTF-8"))).getLetterform());
  }

  /**
   * Method under test: {@link PDPanoseClassification#getMidline()}
   */
  @Test
  void testGetMidline() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(65, (new PDPanoseClassification("A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8"))).getMidline());
  }

  /**
   * Method under test: {@link PDPanoseClassification#getXHeight()}
   */
  @Test
  void testGetXHeight() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(9, (new PDPanoseClassification("A\tA\tA\tA\tA\tA\tA\tA\t".getBytes("UTF-8"))).getXHeight());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDPanoseClassification#PDPanoseClassification(byte[])}
   *   <li>{@link PDPanoseClassification#getBytes()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertSame(bytes, (new PDPanoseClassification(bytes)).getBytes());
  }
}
