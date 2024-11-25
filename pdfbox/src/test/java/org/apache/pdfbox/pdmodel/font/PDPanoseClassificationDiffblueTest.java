package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDPanoseClassificationDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDPanoseClassification#PDPanoseClassification(byte[])}
   *   <li>{@link PDPanoseClassification#getBytes()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertSame(bytes, (new PDPanoseClassification(bytes)).getBytes());
  }

  /**
   * Test {@link PDPanoseClassification#getFamilyKind()}.
   * <ul>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPanoseClassification#getFamilyKind()}
   */
  @Test
  @DisplayName("Test getFamilyKind(); then return sixty-five")
  void testGetFamilyKind_thenReturnSixtyFive() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(65, (new PDPanoseClassification("AXAXAXAX".getBytes("UTF-8"))).getFamilyKind());
  }

  /**
   * Test {@link PDPanoseClassification#getSerifStyle()}.
   * <ul>
   *   <li>Then return eighty-eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPanoseClassification#getSerifStyle()}
   */
  @Test
  @DisplayName("Test getSerifStyle(); then return eighty-eight")
  void testGetSerifStyle_thenReturnEightyEight() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(88, (new PDPanoseClassification("AXAXAXAX".getBytes("UTF-8"))).getSerifStyle());
  }

  /**
   * Test {@link PDPanoseClassification#getWeight()}.
   * <ul>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPanoseClassification#getWeight()}
   */
  @Test
  @DisplayName("Test getWeight(); then return sixty-five")
  void testGetWeight_thenReturnSixtyFive() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(65, (new PDPanoseClassification("AXAXAXAX".getBytes("UTF-8"))).getWeight());
  }

  /**
   * Test {@link PDPanoseClassification#getProportion()}.
   * <ul>
   *   <li>Then return eighty-eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPanoseClassification#getProportion()}
   */
  @Test
  @DisplayName("Test getProportion(); then return eighty-eight")
  void testGetProportion_thenReturnEightyEight() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(88, (new PDPanoseClassification("AXAXAXAX".getBytes("UTF-8"))).getProportion());
  }

  /**
   * Test {@link PDPanoseClassification#getContrast()}.
   * <ul>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPanoseClassification#getContrast()}
   */
  @Test
  @DisplayName("Test getContrast(); then return sixty-five")
  void testGetContrast_thenReturnSixtyFive() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(65, (new PDPanoseClassification("AXAXAXAX".getBytes("UTF-8"))).getContrast());
  }

  /**
   * Test {@link PDPanoseClassification#getStrokeVariation()}.
   * <ul>
   *   <li>Then return eighty-eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPanoseClassification#getStrokeVariation()}
   */
  @Test
  @DisplayName("Test getStrokeVariation(); then return eighty-eight")
  void testGetStrokeVariation_thenReturnEightyEight() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(88, (new PDPanoseClassification("AXAXAXAX".getBytes("UTF-8"))).getStrokeVariation());
  }

  /**
   * Test {@link PDPanoseClassification#getArmStyle()}.
   * <ul>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPanoseClassification#getArmStyle()}
   */
  @Test
  @DisplayName("Test getArmStyle(); then return sixty-five")
  void testGetArmStyle_thenReturnSixtyFive() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(65, (new PDPanoseClassification("AXAXAXAX".getBytes("UTF-8"))).getArmStyle());
  }

  /**
   * Test {@link PDPanoseClassification#getLetterform()}.
   * <ul>
   *   <li>Then return eighty-eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPanoseClassification#getLetterform()}
   */
  @Test
  @DisplayName("Test getLetterform(); then return eighty-eight")
  void testGetLetterform_thenReturnEightyEight() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(88, (new PDPanoseClassification("AXAXAXAX".getBytes("UTF-8"))).getLetterform());
  }

  /**
   * Test {@link PDPanoseClassification#getMidline()}.
   * <ul>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPanoseClassification#getMidline()}
   */
  @Test
  @DisplayName("Test getMidline(); then return sixty-five")
  void testGetMidline_thenReturnSixtyFive() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(65, (new PDPanoseClassification("A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8"))).getMidline());
  }

  /**
   * Test {@link PDPanoseClassification#getXHeight()}.
   * <ul>
   *   <li>Then return nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPanoseClassification#getXHeight()}
   */
  @Test
  @DisplayName("Test getXHeight(); then return nine")
  void testGetXHeight_thenReturnNine() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(9, (new PDPanoseClassification("A\tA\tA\tA\tA\tA\tA\tA\t".getBytes("UTF-8"))).getXHeight());
  }
}
