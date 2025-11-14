package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSFloat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDGammaDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDGamma#PDGamma(COSArray)}
   *   <li>{@link PDGamma#getCOSArray()}
   *   <li>{@link PDGamma#getCOSObject()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDGamma.<init>(COSArray)",
    "COSArray PDGamma.getCOSArray()",
    "COSBase PDGamma.getCOSObject()"
  })
  void testGettersAndSetters() {
    // Arrange
    COSArray array = new COSArray();

    // Act
    PDGamma actualPdGamma = new PDGamma(array);
    COSArray actualCOSArray = actualPdGamma.getCOSArray();
    COSBase actualCOSObject = actualPdGamma.getCOSObject();

    // Assert
    assertTrue(actualCOSArray.toList().isEmpty());
    assertSame(array, actualCOSArray);
    assertSame(array, actualCOSObject);
  }

  /**
   * Test {@link PDGamma#getR()}.
   *
   * <ul>
   *   <li>Given {@link PDGamma#PDGamma()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDGamma#getR()}
   */
  @Test
  @DisplayName("Test getR(); given PDGamma(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDGamma.getR()"})
  void testGetR_givenPDGamma_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDGamma().getR());
  }

  /**
   * Test {@link PDGamma#getG()}.
   *
   * <ul>
   *   <li>Given {@link PDGamma#PDGamma()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDGamma#getG()}
   */
  @Test
  @DisplayName("Test getG(); given PDGamma(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDGamma.getG()"})
  void testGetG_givenPDGamma_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDGamma().getG());
  }

  /**
   * Test {@link PDGamma#setG(float)}.
   *
   * <ul>
   *   <li>Given {@link PDGamma#PDGamma()}.
   *   <li>Then {@link PDGamma#PDGamma()} COSArray toList size is three.
   * </ul>
   *
   * <p>Method under test: {@link PDGamma#setG(float)}
   */
  @Test
  @DisplayName("Test setG(float); given PDGamma(); then PDGamma() COSArray toList size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDGamma.setG(float)"})
  void testSetG_givenPDGamma_thenPDGammaCOSArrayToListSizeIsThree() {
    // Arrange
    PDGamma pdGamma = new PDGamma();

    // Act
    pdGamma.setG(10.0f);

    // Assert
    List<? extends COSBase> toListResult = pdGamma.getCOSArray().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(10.0f, pdGamma.getG());
    assertFalse(getResult.isDirect());
  }

  /**
   * Test {@link PDGamma#getB()}.
   *
   * <ul>
   *   <li>Given {@link PDGamma#PDGamma()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDGamma#getB()}
   */
  @Test
  @DisplayName("Test getB(); given PDGamma(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDGamma.getB()"})
  void testGetB_givenPDGamma_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDGamma().getB());
  }

  /**
   * Test {@link PDGamma#setB(float)}.
   *
   * <ul>
   *   <li>Given {@link PDGamma#PDGamma()}.
   *   <li>Then {@link PDGamma#PDGamma()} COSArray toList size is three.
   * </ul>
   *
   * <p>Method under test: {@link PDGamma#setB(float)}
   */
  @Test
  @DisplayName("Test setB(float); given PDGamma(); then PDGamma() COSArray toList size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDGamma.setB(float)"})
  void testSetB_givenPDGamma_thenPDGammaCOSArrayToListSizeIsThree() {
    // Arrange
    PDGamma pdGamma = new PDGamma();

    // Act
    pdGamma.setB(10.0f);

    // Assert
    List<? extends COSBase> toListResult = pdGamma.getCOSArray().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(10.0f, pdGamma.getB());
    assertFalse(getResult.isDirect());
  }
}
