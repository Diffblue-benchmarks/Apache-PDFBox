package org.apache.pdfbox.pdmodel.graphics.blend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.graphics.blend.BlendMode.BlendChannelFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlendModeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlendMode#getBlendChannelFunction()}
   *   <li>{@link BlendMode#getBlendFunction()}
   *   <li>{@link BlendMode#getCOSName()}
   *   <li>{@link BlendMode#isSeparableBlendMode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BlendChannelFunction BlendMode.getBlendChannelFunction()",
    "BlendMode.BlendFunction BlendMode.getBlendFunction()",
    "COSName BlendMode.getCOSName()",
    "boolean BlendMode.isSeparableBlendMode()"
  })
  void testGettersAndSetters() {
    // Arrange
    BlendMode blendMode = BlendMode.COLOR;

    // Act
    BlendChannelFunction actualBlendChannelFunction = blendMode.getBlendChannelFunction();
    blendMode.getBlendFunction();
    COSName actualCOSName = blendMode.getCOSName();

    // Assert
    assertNull(actualBlendChannelFunction);
    assertFalse(blendMode.isSeparableBlendMode());
    assertSame(COSName.COLOR, actualCOSName);
  }

  /**
   * Test {@link BlendMode#getInstance(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   *   <li>Then return COSName is {@link COSName#NORMAL}.
   * </ul>
   *
   * <p>Method under test: {@link BlendMode#getInstance(COSBase)}
   */
  @Test
  @DisplayName("Test getInstance(COSBase); when A; then return COSName is NORMAL")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlendMode BlendMode.getInstance(COSBase)"})
  void testGetInstance_whenA_thenReturnCOSNameIsNormal() {
    // Arrange and Act
    BlendMode actualInstance = BlendMode.getInstance(COSName.A);

    // Assert
    assertNull(actualInstance.getBlendFunction());
    assertTrue(actualInstance.isSeparableBlendMode());
    assertSame(COSName.NORMAL, actualInstance.getCOSName());
  }
}
