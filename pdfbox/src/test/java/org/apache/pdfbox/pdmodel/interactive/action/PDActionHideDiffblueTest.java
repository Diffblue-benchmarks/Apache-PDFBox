package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDActionHideDiffblueTest {
  /**
   * Test {@link PDActionHide#PDActionHide(COSDictionary)}.
   * <p>
   * Method under test: {@link PDActionHide#PDActionHide(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDActionHide(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionHide.<init>(COSDictionary)"})
  void testNewPDActionHide() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new PDActionHide(a)).getCOSObject());
  }

  /**
   * Test {@link PDActionHide#PDActionHide()}.
   * <p>
   * Method under test: {@link PDActionHide#PDActionHide()}
   */
  @Test
  @DisplayName("Test new PDActionHide()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionHide.<init>()"})
  void testNewPDActionHide2() {
    // Arrange and Act
    PDActionHide actualPdActionHide = new PDActionHide();

    // Assert
    assertNull(actualPdActionHide.getNext());
    assertNull(actualPdActionHide.getT());
    COSDictionary cOSObject = actualPdActionHide.getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertTrue(actualPdActionHide.getH());
    assertEquals(PDAction.TYPE, actualPdActionHide.getType());
    assertEquals(PDActionHide.SUB_TYPE, actualPdActionHide.getSubType());
  }

  /**
   * Test {@link PDActionHide#getT()}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   *   <li>Then return {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionHide#getT()}
   */
  @Test
  @DisplayName("Test getT(); given COSObjectKey(long, int) with num is one and gen is one; then return FALSE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSBase PDActionHide.getT()"})
  void testGetT_givenCOSObjectKeyWithNumIsOneAndGenIsOne_thenReturnFalse() {
    // Arrange
    PDActionHide pdActionHide = new PDActionHide();
    pdActionHide.setT(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Act
    COSBase actualT = pdActionHide.getT();

    // Assert
    assertSame(((COSBoolean) actualT).FALSE, actualT);
  }

  /**
   * Test {@link PDActionHide#getT()}.
   * <ul>
   *   <li>Given {@link PDActionHide#PDActionHide()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionHide#getT()}
   */
  @Test
  @DisplayName("Test getT(); given PDActionHide(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSBase PDActionHide.getT()"})
  void testGetT_givenPDActionHide_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDActionHide()).getT());
  }

  /**
   * Test {@link PDActionHide#setT(COSBase)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionHide#setT(COSBase)}
   */
  @Test
  @DisplayName("Test setT(COSBase); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionHide.setT(COSBase)"})
  void testSetT_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDActionHide pdActionHide = new PDActionHide();

    COSDictionary t = new COSDictionary();
    t.setKey(new COSObjectKey(1L, 1));

    // Act
    pdActionHide.setT(t);

    // Assert
    COSDictionary cOSObject = pdActionHide.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(t, pdActionHide.getT());
  }

  /**
   * Test {@link PDActionHide#setT(COSBase)}.
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.</li>
   *   <li>Then {@link PDActionHide#PDActionHide()} T is {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionHide#setT(COSBase)}
   */
  @Test
  @DisplayName("Test setT(COSBase); when COSArray(); then PDActionHide() T is COSArray()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionHide.setT(COSBase)"})
  void testSetT_whenCOSArray_thenPDActionHideTIsCOSArray() {
    // Arrange
    PDActionHide pdActionHide = new PDActionHide();
    COSArray t = new COSArray();

    // Act
    pdActionHide.setT(t);

    // Assert
    COSDictionary cOSObject = pdActionHide.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(t, pdActionHide.getT());
  }

  /**
   * Test {@link PDActionHide#setT(COSBase)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link PDActionHide#PDActionHide()} T is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionHide#setT(COSBase)}
   */
  @Test
  @DisplayName("Test setT(COSBase); when COSDictionary(); then PDActionHide() T is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionHide.setT(COSBase)"})
  void testSetT_whenCOSDictionary_thenPDActionHideTIsCOSDictionary() {
    // Arrange
    PDActionHide pdActionHide = new PDActionHide();
    COSDictionary t = new COSDictionary();

    // Act
    pdActionHide.setT(t);

    // Assert
    COSDictionary cOSObject = pdActionHide.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(t, pdActionHide.getT());
  }

  /**
   * Test {@link PDActionHide#setT(COSBase)}.
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionHide#setT(COSBase)}
   */
  @Test
  @DisplayName("Test setT(COSBase); when COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionHide.setT(COSBase)"})
  void testSetT_whenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDActionHide pdActionHide = new PDActionHide();

    // Act
    pdActionHide.setT(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Assert
    COSDictionary cOSObject = pdActionHide.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDActionHide#setT(COSBase)}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then {@link PDActionHide#PDActionHide()} T is {@link COSBoolean#FALSE} {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionHide#setT(COSBase)}
   */
  @Test
  @DisplayName("Test setT(COSBase); when FALSE; then PDActionHide() T is FALSE FALSE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionHide.setT(COSBase)"})
  void testSetT_whenFalse_thenPDActionHideTIsFalseFalse() {
    // Arrange
    PDActionHide pdActionHide = new PDActionHide();
    COSBoolean t = COSBoolean.FALSE;

    // Act
    pdActionHide.setT(t);

    // Assert
    COSDictionary cOSObject = pdActionHide.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSBoolean expectedT = t.FALSE;
    assertSame(expectedT, pdActionHide.getT());
  }

  /**
   * Test {@link PDActionHide#setT(COSBase)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDActionHide#PDActionHide()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionHide#setT(COSBase)}
   */
  @Test
  @DisplayName("Test setT(COSBase); when 'null'; then PDActionHide() COSObject Values size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionHide.setT(COSBase)"})
  void testSetT_whenNull_thenPDActionHideCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDActionHide pdActionHide = new PDActionHide();

    // Act
    pdActionHide.setT(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdActionHide.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDActionHide#getH()}.
   * <ul>
   *   <li>Given {@link PDActionHide#PDActionHide()} H is {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionHide#getH()}
   */
  @Test
  @DisplayName("Test getH(); given PDActionHide() H is 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDActionHide.getH()"})
  void testGetH_givenPDActionHideHIsFalse_thenReturnFalse() {
    // Arrange
    PDActionHide pdActionHide = new PDActionHide();
    pdActionHide.setH(false);

    // Act and Assert
    assertFalse(pdActionHide.getH());
  }

  /**
   * Test {@link PDActionHide#getH()}.
   * <ul>
   *   <li>Given {@link PDActionHide#PDActionHide()} H is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionHide#getH()}
   */
  @Test
  @DisplayName("Test getH(); given PDActionHide() H is 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDActionHide.getH()"})
  void testGetH_givenPDActionHideHIsTrue_thenReturnTrue() {
    // Arrange
    PDActionHide pdActionHide = new PDActionHide();
    pdActionHide.setH(true);

    // Act and Assert
    assertTrue(pdActionHide.getH());
  }

  /**
   * Test {@link PDActionHide#getH()}.
   * <ul>
   *   <li>Given {@link PDActionHide#PDActionHide()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionHide#getH()}
   */
  @Test
  @DisplayName("Test getH(); given PDActionHide(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDActionHide.getH()"})
  void testGetH_givenPDActionHide_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new PDActionHide()).getH());
  }

  /**
   * Test {@link PDActionHide#setH(boolean)}.
   * <ul>
   *   <li>Given {@link PDActionHide#PDActionHide()}.</li>
   *   <li>When {@code false}.</li>
   *   <li>Then not {@link PDActionHide#PDActionHide()} H.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionHide#setH(boolean)}
   */
  @Test
  @DisplayName("Test setH(boolean); given PDActionHide(); when 'false'; then not PDActionHide() H")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionHide.setH(boolean)"})
  void testSetH_givenPDActionHide_whenFalse_thenNotPDActionHideH() {
    // Arrange
    PDActionHide pdActionHide = new PDActionHide();

    // Act
    pdActionHide.setH(false);

    // Assert
    COSDictionary cOSObject = pdActionHide.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdActionHide.getH());
  }

  /**
   * Test {@link PDActionHide#setH(boolean)}.
   * <ul>
   *   <li>Given {@link PDActionHide#PDActionHide()}.</li>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link PDActionHide#PDActionHide()} H.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionHide#setH(boolean)}
   */
  @Test
  @DisplayName("Test setH(boolean); given PDActionHide(); when 'true'; then PDActionHide() H")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionHide.setH(boolean)"})
  void testSetH_givenPDActionHide_whenTrue_thenPDActionHideH() {
    // Arrange
    PDActionHide pdActionHide = new PDActionHide();

    // Act
    pdActionHide.setH(true);

    // Assert
    COSDictionary cOSObject = pdActionHide.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdActionHide.getH());
  }
}
