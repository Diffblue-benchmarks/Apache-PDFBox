package org.apache.pdfbox.pdmodel.graphics.blend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BlendModeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BlendMode#getBlendChannelFunction()}
   *   <li>{@link BlendMode#getBlendFunction()}
   *   <li>{@link BlendMode#getCOSName()}
   *   <li>{@link BlendMode#isSeparableBlendMode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    BlendMode blendMode = BlendMode.COLOR;

    // Act
    BlendMode.BlendChannelFunction actualBlendChannelFunction = blendMode.getBlendChannelFunction();
    blendMode.getBlendFunction();
    COSName actualCOSName = blendMode.getCOSName();

    // Assert
    assertNull(actualBlendChannelFunction);
    assertFalse(blendMode.isSeparableBlendMode());
    assertSame(actualCOSName.COLOR, actualCOSName);
  }

  /**
   * Test {@link BlendMode#getInstance(COSBase)}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>When {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then return COSName Name is {@code Normal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlendMode#getInstance(COSBase)}
   */
  @Test
  @DisplayName("Test getInstance(COSBase); given FALSE; when COSArray() add FALSE; then return COSName Name is 'Normal'")
  void testGetInstance_givenFalse_whenCOSArrayAddFalse_thenReturnCOSNameNameIsNormal() {
    // Arrange
    COSArray cosBlendMode = new COSArray();
    cosBlendMode.add(COSBoolean.FALSE);

    // Act
    BlendMode actualInstance = BlendMode.getInstance(cosBlendMode);

    // Assert
    COSName cOSName = actualInstance.getCOSName();
    assertEquals("Normal", cOSName.getName());
    assertNull(cOSName.getKey());
    assertNull(actualInstance.getBlendFunction());
    assertFalse(cOSName.isDirect());
    assertFalse(cOSName.isEmpty());
    assertTrue(actualInstance.isSeparableBlendMode());
  }

  /**
   * Test {@link BlendMode#getInstance(COSBase)}.
   * <ul>
   *   <li>When {@link COSName#A}.</li>
   *   <li>Then return COSName is {@link COSName#A} {@link COSName#NORMAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlendMode#getInstance(COSBase)}
   */
  @Test
  @DisplayName("Test getInstance(COSBase); when A; then return COSName is A NORMAL")
  void testGetInstance_whenA_thenReturnCOSNameIsANormal() {
    // Arrange
    COSName cosBlendMode = COSName.A;

    // Act
    BlendMode actualInstance = BlendMode.getInstance(cosBlendMode);

    // Assert
    assertNull(actualInstance.getBlendFunction());
    assertTrue(actualInstance.isSeparableBlendMode());
    COSName expectedCOSName = cosBlendMode.NORMAL;
    assertSame(expectedCOSName, actualInstance.getCOSName());
  }

  /**
   * Test {@link BlendMode#getInstance(COSBase)}.
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.</li>
   *   <li>Then return COSName Name is {@code Normal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlendMode#getInstance(COSBase)}
   */
  @Test
  @DisplayName("Test getInstance(COSBase); when COSArray(); then return COSName Name is 'Normal'")
  void testGetInstance_whenCOSArray_thenReturnCOSNameNameIsNormal() {
    // Arrange and Act
    BlendMode actualInstance = BlendMode.getInstance(new COSArray());

    // Assert
    COSName cOSName = actualInstance.getCOSName();
    assertEquals("Normal", cOSName.getName());
    assertNull(cOSName.getKey());
    assertNull(actualInstance.getBlendFunction());
    assertFalse(cOSName.isDirect());
    assertFalse(cOSName.isEmpty());
    assertTrue(actualInstance.isSeparableBlendMode());
  }

  /**
   * Test {@link BlendMode#getInstance(COSBase)}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then return COSName Name is {@code Normal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlendMode#getInstance(COSBase)}
   */
  @Test
  @DisplayName("Test getInstance(COSBase); when FALSE; then return COSName Name is 'Normal'")
  void testGetInstance_whenFalse_thenReturnCOSNameNameIsNormal() {
    // Arrange and Act
    BlendMode actualInstance = BlendMode.getInstance(COSBoolean.FALSE);

    // Assert
    COSName cOSName = actualInstance.getCOSName();
    assertEquals("Normal", cOSName.getName());
    assertNull(cOSName.getKey());
    assertNull(actualInstance.getBlendFunction());
    assertFalse(cOSName.isDirect());
    assertFalse(cOSName.isEmpty());
    assertTrue(actualInstance.isSeparableBlendMode());
  }
}
