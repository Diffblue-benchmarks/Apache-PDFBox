package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.Test;

class PDColorDiffblueTest {
  /**
   * Method under test: {@link PDColor#getComponents()}
   */
  @Test
  void testGetComponents() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f}, (new PDColor(new COSArray(), PDDeviceGray.INSTANCE)).getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDColor#getComponents()}
   */
  @Test
  void testGetComponents2() {
    // Arrange
    COSArray array = new COSArray();

    // Act and Assert
    assertArrayEquals(new float[]{0.0f}, (new PDColor(array, new PDCalGray())).getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDColor#isPattern()}
   */
  @Test
  void testIsPattern() {
    // Arrange, Act and Assert
    assertFalse((new PDColor(new COSArray(), PDDeviceGray.INSTANCE)).isPattern());
    assertTrue((new PDColor(COSName.A, PDDeviceGray.INSTANCE)).isPattern());
  }

  /**
   * Method under test: {@link PDColor#toRGB()}
   */
  @Test
  void testToRGB() throws IOException {
    // Arrange, Act and Assert
    assertEquals(167772150, (new PDColor(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, PDDeviceGray.INSTANCE)).toRGB());
  }

  /**
   * Method under test: {@link PDColor#toCOSArray()}
   */
  @Test
  void testToCOSArray() {
    // Arrange, Act and Assert
    assertTrue((new PDColor(new COSArray(), PDDeviceGray.INSTANCE)).toCOSArray().toList().isEmpty());
  }

  /**
   * Method under test: {@link PDColor#toCOSArray()}
   */
  @Test
  void testToCOSArray2() {
    // Arrange, Act and Assert
    List<? extends COSBase> toListResult = (new PDColor(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, PDDeviceGray.INSTANCE))
        .toCOSArray()
        .toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertEquals(getResult, getResult3);
    assertEquals(getResult2, getResult4);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDColor#toString()}
   *   <li>{@link PDColor#getColorSpace()}
   *   <li>{@link PDColor#getPatternName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDColor pdColor = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    String actualToStringResult = pdColor.toString();
    PDColorSpace actualColorSpace = pdColor.getColorSpace();

    // Assert
    assertEquals("PDColor{components=[], patternName=null, colorSpace=DeviceGray}", actualToStringResult);
    assertNull(pdColor.getPatternName());
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Method under test: {@link PDColor#PDColor(COSArray, PDColorSpace)}
   */
  @Test
  void testNewPDColor() {
    // Arrange
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act
    PDColor actualPdColor = new PDColor(new COSArray(), colorSpace);

    // Assert
    assertNull(actualPdColor.getPatternName());
    assertFalse(actualPdColor.isPattern());
    PDDeviceGray expectedColorSpace = colorSpace.INSTANCE;
    assertSame(expectedColorSpace, actualPdColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, actualPdColor.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDColor#PDColor(COSArray, PDColorSpace)}
   */
  @Test
  void testNewPDColor2() {
    // Arrange
    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act
    PDColor actualPdColor = new PDColor(array, colorSpace);

    // Assert
    assertNull(actualPdColor.getPatternName());
    assertFalse(actualPdColor.isPattern());
    PDDeviceGray expectedColorSpace = colorSpace.INSTANCE;
    assertSame(expectedColorSpace, actualPdColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, actualPdColor.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDColor#PDColor(COSArray, PDColorSpace)}
   */
  @Test
  void testNewPDColor3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSBoolean.FALSE);
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act
    PDColor actualPdColor = new PDColor(array, colorSpace);

    // Assert
    verify(object).getCOSObject();
    assertNull(actualPdColor.getPatternName());
    assertFalse(actualPdColor.isPattern());
    PDDeviceGray expectedColorSpace = colorSpace.INSTANCE;
    assertSame(expectedColorSpace, actualPdColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, actualPdColor.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDColor#PDColor(COSArray, PDColorSpace)}
   */
  @Test
  void testNewPDColor4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSFloat.ONE);

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSBoolean.FALSE);
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act
    PDColor actualPdColor = new PDColor(array, colorSpace);

    // Assert
    verify(object).getCOSObject();
    assertNull(actualPdColor.getPatternName());
    assertFalse(actualPdColor.isPattern());
    PDDeviceGray expectedColorSpace = colorSpace.INSTANCE;
    assertSame(expectedColorSpace, actualPdColor.getColorSpace());
    assertArrayEquals(new float[]{1.0f}, actualPdColor.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDColor#PDColor(COSArray, PDColorSpace)}
   */
  @Test
  void testNewPDColor5() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSInteger.ONE);

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSBoolean.FALSE);
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act
    PDColor actualPdColor = new PDColor(array, colorSpace);

    // Assert
    verify(object).getCOSObject();
    assertNull(actualPdColor.getPatternName());
    assertFalse(actualPdColor.isPattern());
    PDDeviceGray expectedColorSpace = colorSpace.INSTANCE;
    assertSame(expectedColorSpace, actualPdColor.getColorSpace());
    assertArrayEquals(new float[]{1.0f}, actualPdColor.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDColor#PDColor(COSArray, PDColorSpace)}
   */
  @Test
  void testNewPDColor6() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSName.A);

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSBoolean.FALSE);
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act
    PDColor actualPdColor = new PDColor(array, colorSpace);

    // Assert
    verify(object).getCOSObject();
    assertNull(actualPdColor.getPatternName());
    assertFalse(actualPdColor.isPattern());
    PDDeviceGray expectedColorSpace = colorSpace.INSTANCE;
    assertSame(expectedColorSpace, actualPdColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, actualPdColor.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDColor#PDColor(COSArray, PDColorSpace)}
   */
  @Test
  void testNewPDColor7() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(new COSArray());

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSBoolean.FALSE);
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act
    PDColor actualPdColor = new PDColor(array, colorSpace);

    // Assert
    verify(object).getCOSObject();
    assertNull(actualPdColor.getPatternName());
    assertFalse(actualPdColor.isPattern());
    PDDeviceGray expectedColorSpace = colorSpace.INSTANCE;
    assertSame(expectedColorSpace, actualPdColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, actualPdColor.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDColor#PDColor(COSArray, PDColorSpace)}
   */
  @Test
  void testNewPDColor8() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(new COSFloat(10.0f));

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSBoolean.FALSE);
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act
    PDColor actualPdColor = new PDColor(array, colorSpace);

    // Assert
    verify(object).getCOSObject();
    assertNull(actualPdColor.getPatternName());
    assertFalse(actualPdColor.isPattern());
    PDDeviceGray expectedColorSpace = colorSpace.INSTANCE;
    assertSame(expectedColorSpace, actualPdColor.getColorSpace());
    assertArrayEquals(new float[]{10.0f}, actualPdColor.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDColor#PDColor(COSArray, PDColorSpace)}
   */
  @Test
  void testNewPDColor9() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(new COSDictionary());

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSBoolean.FALSE);
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act
    PDColor actualPdColor = new PDColor(array, colorSpace);

    // Assert
    verify(object).getCOSObject();
    assertNull(actualPdColor.getPatternName());
    assertFalse(actualPdColor.isPattern());
    PDDeviceGray expectedColorSpace = colorSpace.INSTANCE;
    assertSame(expectedColorSpace, actualPdColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, actualPdColor.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDColor#PDColor(COSArray, PDColorSpace)}
   */
  @Test
  void testNewPDColor10() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(4L, 4)));

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSBoolean.FALSE);
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act
    PDColor actualPdColor = new PDColor(array, colorSpace);

    // Assert
    verify(object).getCOSObject();
    assertNull(actualPdColor.getPatternName());
    assertFalse(actualPdColor.isPattern());
    PDDeviceGray expectedColorSpace = colorSpace.INSTANCE;
    assertSame(expectedColorSpace, actualPdColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, actualPdColor.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDColor#PDColor(COSArray, PDColorSpace)}
   */
  @Test
  void testNewPDColor11() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(new COSStream());

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSBoolean.FALSE);
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act
    PDColor actualPdColor = new PDColor(array, colorSpace);

    // Assert
    verify(object).getCOSObject();
    assertNull(actualPdColor.getPatternName());
    assertFalse(actualPdColor.isPattern());
    PDDeviceGray expectedColorSpace = colorSpace.INSTANCE;
    assertSame(expectedColorSpace, actualPdColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, actualPdColor.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDColor#PDColor(COSName, PDColorSpace)}
   */
  @Test
  void testNewPDColor12() {
    // Arrange
    COSName patternName = COSName.A;
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act
    PDColor actualPdColor = new PDColor(patternName, colorSpace);

    // Assert
    assertTrue(actualPdColor.isPattern());
    COSName expectedPatternName = patternName.A;
    assertSame(expectedPatternName, actualPdColor.getPatternName());
    PDDeviceGray expectedColorSpace = colorSpace.INSTANCE;
    assertSame(expectedColorSpace, actualPdColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, actualPdColor.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDColor#PDColor(float[], COSName, PDColorSpace)}
   */
  @Test
  void testNewPDColor13() {
    // Arrange
    COSName patternName = COSName.A;
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act
    PDColor actualPdColor = new PDColor(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, patternName, colorSpace);

    // Assert
    assertTrue(actualPdColor.isPattern());
    COSName expectedPatternName = patternName.A;
    assertSame(expectedPatternName, actualPdColor.getPatternName());
    PDDeviceGray expectedColorSpace = colorSpace.INSTANCE;
    assertSame(expectedColorSpace, actualPdColor.getColorSpace());
    assertArrayEquals(new float[]{10.0f}, actualPdColor.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDColor#PDColor(float[], COSName, PDColorSpace)}
   */
  @Test
  void testNewPDColor14() {
    // Arrange
    COSName patternName = COSName.A;
    PDPattern colorSpace = new PDPattern(new PDResources());

    // Act
    PDColor actualPdColor = new PDColor(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, patternName, colorSpace);

    // Assert
    assertTrue(actualPdColor.isPattern());
    assertSame(colorSpace, actualPdColor.getColorSpace());
    COSName expectedPatternName = patternName.A;
    assertSame(expectedPatternName, actualPdColor.getPatternName());
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualPdColor.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDColor#PDColor(float[], COSName, PDColorSpace)}
   */
  @Test
  void testNewPDColor15() {
    // Arrange
    COSName patternName = COSName.A;
    PDPattern colorSpace = new PDPattern(new PDResources(), PDDeviceGray.INSTANCE);

    // Act
    PDColor actualPdColor = new PDColor(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, patternName, colorSpace);

    // Assert
    assertTrue(actualPdColor.isPattern());
    assertSame(colorSpace, actualPdColor.getColorSpace());
    COSName expectedPatternName = patternName.A;
    assertSame(expectedPatternName, actualPdColor.getPatternName());
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualPdColor.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDColor#PDColor(float[], PDColorSpace)}
   */
  @Test
  void testNewPDColor16() {
    // Arrange
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act
    PDColor actualPdColor = new PDColor(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, colorSpace);

    // Assert
    assertNull(actualPdColor.getPatternName());
    assertFalse(actualPdColor.isPattern());
    PDDeviceGray expectedColorSpace = colorSpace.INSTANCE;
    assertSame(expectedColorSpace, actualPdColor.getColorSpace());
    assertArrayEquals(new float[]{10.0f}, actualPdColor.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDColor#PDColor(float[], PDColorSpace)}
   */
  @Test
  void testNewPDColor17() {
    // Arrange and Act
    PDColor actualPdColor = new PDColor(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, null);

    // Assert
    assertNull(actualPdColor.getPatternName());
    assertNull(actualPdColor.getColorSpace());
    assertFalse(actualPdColor.isPattern());
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, actualPdColor.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDColor#PDColor(float[], PDColorSpace)}
   */
  @Test
  void testNewPDColor18() {
    // Arrange
    PDCalGray colorSpace = new PDCalGray();

    // Act
    PDColor actualPdColor = new PDColor(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, colorSpace);

    // Assert
    assertNull(actualPdColor.getPatternName());
    assertFalse(actualPdColor.isPattern());
    assertSame(colorSpace, actualPdColor.getColorSpace());
    assertArrayEquals(new float[]{10.0f}, actualPdColor.getComponents(), 0.0f);
  }
}
