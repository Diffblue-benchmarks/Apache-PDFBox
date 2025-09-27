package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FDFOptionElementDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FDFOptionElement#FDFOptionElement(COSArray)}
   *   <li>{@link FDFOptionElement#getCOSArray()}
   *   <li>{@link FDFOptionElement#getCOSObject()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FDFOptionElement.<init>(COSArray)",
    "COSArray FDFOptionElement.getCOSArray()",
    "COSBase FDFOptionElement.getCOSObject()"
  })
  void testGettersAndSetters() {
    // Arrange
    COSArray o = new COSArray();

    // Act
    FDFOptionElement actualFdfOptionElement = new FDFOptionElement(o);
    COSArray actualCOSArray = actualFdfOptionElement.getCOSArray();
    COSBase actualCOSObject = actualFdfOptionElement.getCOSObject();

    // Assert
    assertTrue(actualCOSArray.toList().isEmpty());
    assertSame(o, actualCOSArray);
    assertSame(o, actualCOSObject);
  }

  /**
   * Test {@link FDFOptionElement#FDFOptionElement()}.
   *
   * <p>Method under test: {@link FDFOptionElement#FDFOptionElement()}
   */
  @Test
  @DisplayName("Test new FDFOptionElement()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFOptionElement.<init>()"})
  void testNewFDFOptionElement() {
    // Arrange and Act
    FDFOptionElement actualFdfOptionElement = new FDFOptionElement();

    // Assert
    COSArray cOSArray = actualFdfOptionElement.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSString);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSString);
    assertEquals("", ((COSString) getResult).getASCII());
    assertEquals("", ((COSString) getResult).getString());
    assertEquals("", ((COSString) getResult).toHexString());
    assertEquals("", actualFdfOptionElement.getDefaultAppearanceString());
    assertEquals("", actualFdfOptionElement.getOption());
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertFalse(((COSString) getResult).getForceHexForm());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualFdfOptionElement.getCOSObject());
    assertArrayEquals(new byte[] {}, ((COSString) getResult).getBytes());
  }

  /**
   * Test {@link FDFOptionElement#getOption()}.
   *
   * <ul>
   *   <li>Given {@link FDFOptionElement#FDFOptionElement()} Option is {@code Opt}.
   *   <li>Then return {@code Opt}.
   * </ul>
   *
   * <p>Method under test: {@link FDFOptionElement#getOption()}
   */
  @Test
  @DisplayName("Test getOption(); given FDFOptionElement() Option is 'Opt'; then return 'Opt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFOptionElement.getOption()"})
  void testGetOption_givenFDFOptionElementOptionIsOpt_thenReturnOpt() {
    // Arrange
    FDFOptionElement fdfOptionElement = new FDFOptionElement();
    fdfOptionElement.setOption("Opt");

    // Act and Assert
    assertEquals("Opt", fdfOptionElement.getOption());
  }

  /**
   * Test {@link FDFOptionElement#getOption()}.
   *
   * <ul>
   *   <li>Given {@link FDFOptionElement#FDFOptionElement()}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link FDFOptionElement#getOption()}
   */
  @Test
  @DisplayName("Test getOption(); given FDFOptionElement(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFOptionElement.getOption()"})
  void testGetOption_givenFDFOptionElement_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new FDFOptionElement().getOption());
  }

  /**
   * Test {@link FDFOptionElement#setOption(String)}.
   *
   * <ul>
   *   <li>Given {@link FDFOptionElement#FDFOptionElement()}.
   *   <li>Then {@link FDFOptionElement#FDFOptionElement()} COSArray toList size is two.
   * </ul>
   *
   * <p>Method under test: {@link FDFOptionElement#setOption(String)}
   */
  @Test
  @DisplayName(
      "Test setOption(String); given FDFOptionElement(); then FDFOptionElement() COSArray toList size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFOptionElement.setOption(String)"})
  void testSetOption_givenFDFOptionElement_thenFDFOptionElementCOSArrayToListSizeIsTwo()
      throws UnsupportedEncodingException {
    // Arrange
    FDFOptionElement fdfOptionElement = new FDFOptionElement();

    // Act
    fdfOptionElement.setOption("Opt");

    // Assert
    List<? extends COSBase> toListResult = fdfOptionElement.getCOSArray().toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSString);
    assertEquals("4F7074", ((COSString) getResult).toHexString());
    assertEquals("Opt", ((COSString) getResult).getASCII());
    assertEquals("Opt", ((COSString) getResult).getString());
    assertEquals("Opt", fdfOptionElement.getOption());
    assertArrayEquals("Opt".getBytes("UTF-8"), ((COSString) getResult).getBytes());
  }

  /**
   * Test {@link FDFOptionElement#getDefaultAppearanceString()}.
   *
   * <ul>
   *   <li>Given {@link FDFOptionElement#FDFOptionElement()}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link FDFOptionElement#getDefaultAppearanceString()}
   */
  @Test
  @DisplayName(
      "Test getDefaultAppearanceString(); given FDFOptionElement(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFOptionElement.getDefaultAppearanceString()"})
  void testGetDefaultAppearanceString_givenFDFOptionElement_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new FDFOptionElement().getDefaultAppearanceString());
  }

  /**
   * Test {@link FDFOptionElement#getDefaultAppearanceString()}.
   *
   * <ul>
   *   <li>Then return {@code Da}.
   * </ul>
   *
   * <p>Method under test: {@link FDFOptionElement#getDefaultAppearanceString()}
   */
  @Test
  @DisplayName("Test getDefaultAppearanceString(); then return 'Da'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFOptionElement.getDefaultAppearanceString()"})
  void testGetDefaultAppearanceString_thenReturnDa() {
    // Arrange
    FDFOptionElement fdfOptionElement = new FDFOptionElement();
    fdfOptionElement.setDefaultAppearanceString("Da");

    // Act and Assert
    assertEquals("Da", fdfOptionElement.getDefaultAppearanceString());
  }

  /**
   * Test {@link FDFOptionElement#setDefaultAppearanceString(String)}.
   *
   * <ul>
   *   <li>Then {@link FDFOptionElement#FDFOptionElement()} COSArray toList size is two.
   * </ul>
   *
   * <p>Method under test: {@link FDFOptionElement#setDefaultAppearanceString(String)}
   */
  @Test
  @DisplayName(
      "Test setDefaultAppearanceString(String); then FDFOptionElement() COSArray toList size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFOptionElement.setDefaultAppearanceString(String)"})
  void testSetDefaultAppearanceString_thenFDFOptionElementCOSArrayToListSizeIsTwo() {
    // Arrange
    FDFOptionElement fdfOptionElement = new FDFOptionElement();

    // Act
    fdfOptionElement.setDefaultAppearanceString("Da");

    // Assert
    List<? extends COSBase> toListResult = fdfOptionElement.getCOSArray().toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSString);
    assertEquals("4461", ((COSString) getResult).toHexString());
    assertEquals("Da", ((COSString) getResult).getASCII());
    assertEquals("Da", ((COSString) getResult).getString());
    assertEquals("Da", fdfOptionElement.getDefaultAppearanceString());
    assertArrayEquals(new byte[] {'D', 'a'}, ((COSString) getResult).getBytes());
  }
}
