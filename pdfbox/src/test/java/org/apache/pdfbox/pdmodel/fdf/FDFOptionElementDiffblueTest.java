package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.Test;

class FDFOptionElementDiffblueTest {
  /**
   * Method under test: {@link FDFOptionElement#getOption()}
   */
  @Test
  void testGetOption() {
    // Arrange, Act and Assert
    assertEquals("", (new FDFOptionElement()).getOption());
  }

  /**
   * Method under test: {@link FDFOptionElement#getOption()}
   */
  @Test
  void testGetOption2() {
    // Arrange
    FDFOptionElement fdfOptionElement = new FDFOptionElement();
    fdfOptionElement.setOption("Opt");

    // Act and Assert
    assertEquals("Opt", fdfOptionElement.getOption());
  }

  /**
   * Method under test: {@link FDFOptionElement#setOption(String)}
   */
  @Test
  void testSetOption() throws UnsupportedEncodingException {
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
    byte[] expectedBytes = "Opt".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((COSString) getResult).getBytes());
  }

  /**
   * Method under test: {@link FDFOptionElement#setOption(String)}
   */
  @Test
  void testSetOption2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray o = new COSArray();
    o.add(object);
    FDFOptionElement fdfOptionElement = new FDFOptionElement(o);

    // Act
    fdfOptionElement.setOption("Opt");

    // Assert
    verify(object).getCOSObject();
    assertEquals("Opt", fdfOptionElement.getOption());
    assertSame(o, fdfOptionElement.getCOSArray());
  }

  /**
   * Method under test: {@link FDFOptionElement#getDefaultAppearanceString()}
   */
  @Test
  void testGetDefaultAppearanceString() {
    // Arrange, Act and Assert
    assertEquals("", (new FDFOptionElement()).getDefaultAppearanceString());
  }

  /**
   * Method under test: {@link FDFOptionElement#getDefaultAppearanceString()}
   */
  @Test
  void testGetDefaultAppearanceString2() {
    // Arrange
    FDFOptionElement fdfOptionElement = new FDFOptionElement();
    fdfOptionElement.setDefaultAppearanceString("Da");

    // Act and Assert
    assertEquals("Da", fdfOptionElement.getDefaultAppearanceString());
  }

  /**
   * Method under test:
   * {@link FDFOptionElement#setDefaultAppearanceString(String)}
   */
  @Test
  void testSetDefaultAppearanceString() {
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
    assertArrayEquals(new byte[]{'D', 'a'}, ((COSString) getResult).getBytes());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FDFOptionElement#FDFOptionElement(COSArray)}
   *   <li>{@link FDFOptionElement#getCOSArray()}
   *   <li>{@link FDFOptionElement#getCOSObject()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link FDFOptionElement#FDFOptionElement()}
   */
  @Test
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
    assertEquals(0, ((COSString) getResult).getBytes().length);
    assertFalse(getResult.isDirect());
    assertFalse(((COSString) getResult).getForceHexForm());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualFdfOptionElement.getCOSObject());
  }
}
