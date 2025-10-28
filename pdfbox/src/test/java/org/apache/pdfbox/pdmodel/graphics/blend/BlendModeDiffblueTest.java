package org.apache.pdfbox.pdmodel.graphics.blend;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

class BlendModeDiffblueTest {
  /**
   * Method under test: {@link BlendMode#getInstance(COSBase)}
   */
  @Test
  void testGetInstance() {
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
   * Methods under test:
   * <ul>
   *   <li>{@link BlendMode#getBlendChannelFunction()}
   *   <li>{@link BlendMode#getBlendFunction()}
   *   <li>{@link BlendMode#getCOSName()}
   *   <li>{@link BlendMode#isSeparableBlendMode()}
   * </ul>
   */
  @Test
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
}
