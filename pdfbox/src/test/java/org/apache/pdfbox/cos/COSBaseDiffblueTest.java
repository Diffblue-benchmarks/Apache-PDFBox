package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class COSBaseDiffblueTest {
  /**
   * Test {@link COSBase#getCOSObject()}.
   * <p>
   * Method under test: {@link COSBase#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSBase COSBase.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange
    COSArray cosArray = new COSArray();

    // Act
    COSBase actualCOSObject = cosArray.getCOSObject();

    // Assert
    assertTrue(actualCOSObject instanceof COSArray);
    assertTrue(((COSArray) actualCOSObject).toList().isEmpty());
    assertSame(cosArray, actualCOSObject);
  }

  /**
   * Test {@link COSBase#isDirect()}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSBase#isDirect()}
   */
  @Test
  @DisplayName("Test isDirect(); given COSArray(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSBase.isDirect()"})
  void testIsDirect_givenCOSArray_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new COSArray()).isDirect());
  }

  /**
   * Test {@link COSBase#isDirect()}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSBase#isDirect()}
   */
  @Test
  @DisplayName("Test isDirect(); given FALSE; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSBase.isDirect()"})
  void testIsDirect_givenFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(COSBoolean.FALSE.isDirect());
  }

  /**
   * Test {@link COSBase#getKey()}.
   * <p>
   * Method under test: {@link COSBase#getKey()}
   */
  @Test
  @DisplayName("Test getKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSObjectKey COSBase.getKey()"})
  void testGetKey() {
    // Arrange, Act and Assert
    assertNull((new COSArray()).getKey());
  }
}
