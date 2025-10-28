package org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSNull;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.graphics.color.PDGamma;
import org.junit.jupiter.api.Test;

class PDFourColoursDiffblueTest {
  /**
   * Method under test: {@link PDFourColours#getBeforeColour()}
   */
  @Test
  void testGetBeforeColour() {
    // Arrange, Act and Assert
    assertNull((new PDFourColours()).getBeforeColour());
  }

  /**
   * Method under test: {@link PDFourColours#getBeforeColour()}
   */
  @Test
  void testGetBeforeColour2() {
    // Arrange
    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);

    // Act and Assert
    assertNull((new PDFourColours(array)).getBeforeColour());
  }

  /**
   * Method under test: {@link PDFourColours#getBeforeColour()}
   */
  @Test
  void testGetBeforeColour3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSBoolean.FALSE);

    // Act
    PDGamma actualBeforeColour = (new PDFourColours(array)).getBeforeColour();

    // Assert
    verify(object).getCOSObject();
    assertNull(actualBeforeColour);
  }

  /**
   * Method under test: {@link PDFourColours#getBeforeColour()}
   */
  @Test
  void testGetBeforeColour4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    COSArray cosArray = new COSArray();
    when(object.getCOSObject()).thenReturn(cosArray);

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSBoolean.FALSE);

    // Act
    PDGamma actualBeforeColour = (new PDFourColours(array)).getBeforeColour();

    // Assert
    verify(object).getCOSObject();
    COSArray cOSArray = actualBeforeColour.getCOSArray();
    assertTrue(cOSArray.toList().isEmpty());
    assertSame(cosArray, cOSArray);
    assertSame(cosArray, actualBeforeColour.getCOSObject());
  }

  /**
   * Method under test: {@link PDFourColours#getBeforeColour()}
   */
  @Test
  void testGetBeforeColour5() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSBoolean.FALSE);

    // Act
    PDGamma actualBeforeColour = (new PDFourColours(array)).getBeforeColour();

    // Assert
    verify(object).getCOSObject();
    assertNull(actualBeforeColour);
  }

  /**
   * Method under test: {@link PDFourColours#setBeforeColour(PDGamma)}
   */
  @Test
  void testSetBeforeColour() {
    // Arrange
    PDFourColours pdFourColours = new PDFourColours();

    // Act
    pdFourColours.setBeforeColour(new PDGamma());

    // Assert
    COSBase cOSObject = pdFourColours.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSNull);
    assertNull(getResult.getKey());
    PDGamma beforeColour = pdFourColours.getBeforeColour();
    assertEquals(0.0f, beforeColour.getB());
    assertEquals(0.0f, beforeColour.getG());
    assertEquals(0.0f, beforeColour.getR());
    assertFalse(getResult.isDirect());
    assertSame(getResult, toListResult.get(2));
    assertSame(getResult, toListResult.get(3));
  }

  /**
   * Method under test: {@link PDFourColours#setBeforeColour(PDGamma)}
   */
  @Test
  void testSetBeforeColour2() {
    // Arrange
    PDFourColours pdFourColours = new PDFourColours();

    // Act
    pdFourColours.setBeforeColour(null);

    // Assert
    COSBase cOSObject = pdFourColours.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSNull);
    assertNull(pdFourColours.getBeforeColour());
    assertSame(getResult, toListResult.get(1));
    assertSame(getResult, toListResult.get(2));
    assertSame(getResult, toListResult.get(3));
  }

  /**
   * Method under test: {@link PDFourColours#setBeforeColour(PDGamma)}
   */
  @Test
  void testSetBeforeColour3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);
    PDFourColours pdFourColours = new PDFourColours(array);

    // Act
    pdFourColours.setBeforeColour(new PDGamma());

    // Assert
    verify(object).getCOSObject();
    PDGamma beforeColour = pdFourColours.getBeforeColour();
    assertEquals(0.0f, beforeColour.getB());
    assertEquals(0.0f, beforeColour.getG());
    assertEquals(0.0f, beforeColour.getR());
    assertSame(array, pdFourColours.getCOSObject());
  }

  /**
   * Method under test: {@link PDFourColours#getAfterColour()}
   */
  @Test
  void testGetAfterColour() {
    // Arrange, Act and Assert
    assertNull((new PDFourColours()).getAfterColour());
  }

  /**
   * Method under test: {@link PDFourColours#getAfterColour()}
   */
  @Test
  void testGetAfterColour2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);

    // Act
    PDGamma actualAfterColour = (new PDFourColours(array)).getAfterColour();

    // Assert
    verify(object).getCOSObject();
    assertNull(actualAfterColour);
  }

  /**
   * Method under test: {@link PDFourColours#getAfterColour()}
   */
  @Test
  void testGetAfterColour3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);
    array.add(object);

    // Act
    PDGamma actualAfterColour = (new PDFourColours(array)).getAfterColour();

    // Assert
    verify(object).getCOSObject();
    assertNull(actualAfterColour);
  }

  /**
   * Method under test: {@link PDFourColours#getAfterColour()}
   */
  @Test
  void testGetAfterColour4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    COSArray cosArray = new COSArray();
    when(object.getCOSObject()).thenReturn(cosArray);

    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);
    array.add(object);

    // Act
    PDGamma actualAfterColour = (new PDFourColours(array)).getAfterColour();

    // Assert
    verify(object).getCOSObject();
    COSArray cOSArray = actualAfterColour.getCOSArray();
    assertTrue(cOSArray.toList().isEmpty());
    assertSame(cosArray, cOSArray);
    assertSame(cosArray, actualAfterColour.getCOSObject());
  }

  /**
   * Method under test: {@link PDFourColours#getAfterColour()}
   */
  @Test
  void testGetAfterColour5() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);
    array.add(object);

    // Act
    PDGamma actualAfterColour = (new PDFourColours(array)).getAfterColour();

    // Assert
    verify(object).getCOSObject();
    assertNull(actualAfterColour);
  }

  /**
   * Method under test: {@link PDFourColours#setAfterColour(PDGamma)}
   */
  @Test
  void testSetAfterColour() {
    // Arrange
    PDFourColours pdFourColours = new PDFourColours();

    // Act
    pdFourColours.setAfterColour(new PDGamma());

    // Assert
    COSBase cOSObject = pdFourColours.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    PDGamma afterColour = pdFourColours.getAfterColour();
    assertEquals(0.0f, afterColour.getB());
    assertEquals(0.0f, afterColour.getG());
    assertEquals(0.0f, afterColour.getR());
    assertEquals(4, ((COSArray) cOSObject).toList().size());
  }

  /**
   * Method under test: {@link PDFourColours#setAfterColour(PDGamma)}
   */
  @Test
  void testSetAfterColour2() {
    // Arrange
    PDFourColours pdFourColours = new PDFourColours();

    // Act
    pdFourColours.setAfterColour(null);

    // Assert
    COSBase cOSObject = pdFourColours.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    assertNull(pdFourColours.getAfterColour());
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    assertSame(toListResult.get(0), toListResult.get(1));
  }

  /**
   * Method under test: {@link PDFourColours#setAfterColour(PDGamma)}
   */
  @Test
  void testSetAfterColour3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);
    PDFourColours pdFourColours = new PDFourColours(array);

    // Act
    pdFourColours.setAfterColour(new PDGamma());

    // Assert
    verify(object).getCOSObject();
    PDGamma afterColour = pdFourColours.getAfterColour();
    assertEquals(0.0f, afterColour.getB());
    assertEquals(0.0f, afterColour.getG());
    assertEquals(0.0f, afterColour.getR());
    assertSame(array, pdFourColours.getCOSObject());
  }

  /**
   * Method under test: {@link PDFourColours#getStartColour()}
   */
  @Test
  void testGetStartColour() {
    // Arrange, Act and Assert
    assertNull((new PDFourColours()).getStartColour());
  }

  /**
   * Method under test: {@link PDFourColours#getStartColour()}
   */
  @Test
  void testGetStartColour2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);

    // Act
    PDGamma actualStartColour = (new PDFourColours(array)).getStartColour();

    // Assert
    verify(object).getCOSObject();
    assertNull(actualStartColour);
  }

  /**
   * Method under test: {@link PDFourColours#getStartColour()}
   */
  @Test
  void testGetStartColour3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);
    array.add(COSBoolean.FALSE);
    array.add(object);

    // Act
    PDGamma actualStartColour = (new PDFourColours(array)).getStartColour();

    // Assert
    verify(object).getCOSObject();
    assertNull(actualStartColour);
  }

  /**
   * Method under test: {@link PDFourColours#getStartColour()}
   */
  @Test
  void testGetStartColour4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    COSArray cosArray = new COSArray();
    when(object.getCOSObject()).thenReturn(cosArray);

    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);
    array.add(COSBoolean.FALSE);
    array.add(object);

    // Act
    PDGamma actualStartColour = (new PDFourColours(array)).getStartColour();

    // Assert
    verify(object).getCOSObject();
    COSArray cOSArray = actualStartColour.getCOSArray();
    assertTrue(cOSArray.toList().isEmpty());
    assertSame(cosArray, cOSArray);
    assertSame(cosArray, actualStartColour.getCOSObject());
  }

  /**
   * Method under test: {@link PDFourColours#getStartColour()}
   */
  @Test
  void testGetStartColour5() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(2L, 2)));

    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);
    array.add(COSBoolean.FALSE);
    array.add(object);

    // Act
    PDGamma actualStartColour = (new PDFourColours(array)).getStartColour();

    // Assert
    verify(object).getCOSObject();
    assertNull(actualStartColour);
  }

  /**
   * Method under test: {@link PDFourColours#setStartColour(PDGamma)}
   */
  @Test
  void testSetStartColour() {
    // Arrange
    PDFourColours pdFourColours = new PDFourColours();

    // Act
    pdFourColours.setStartColour(new PDGamma());

    // Assert
    COSBase cOSObject = pdFourColours.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    PDGamma startColour = pdFourColours.getStartColour();
    assertEquals(0.0f, startColour.getB());
    assertEquals(0.0f, startColour.getG());
    assertEquals(0.0f, startColour.getR());
    assertEquals(4, ((COSArray) cOSObject).toList().size());
  }

  /**
   * Method under test: {@link PDFourColours#setStartColour(PDGamma)}
   */
  @Test
  void testSetStartColour2() {
    // Arrange
    PDFourColours pdFourColours = new PDFourColours();

    // Act
    pdFourColours.setStartColour(null);

    // Assert
    COSBase cOSObject = pdFourColours.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    assertNull(pdFourColours.getStartColour());
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    assertSame(toListResult.get(0), toListResult.get(2));
  }

  /**
   * Method under test: {@link PDFourColours#setStartColour(PDGamma)}
   */
  @Test
  void testSetStartColour3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);
    PDFourColours pdFourColours = new PDFourColours(array);

    // Act
    pdFourColours.setStartColour(new PDGamma());

    // Assert
    verify(object).getCOSObject();
    PDGamma startColour = pdFourColours.getStartColour();
    assertEquals(0.0f, startColour.getB());
    assertEquals(0.0f, startColour.getG());
    assertEquals(0.0f, startColour.getR());
    assertSame(array, pdFourColours.getCOSObject());
  }

  /**
   * Method under test: {@link PDFourColours#getEndColour()}
   */
  @Test
  void testGetEndColour() {
    // Arrange, Act and Assert
    assertNull((new PDFourColours()).getEndColour());
  }

  /**
   * Method under test: {@link PDFourColours#getEndColour()}
   */
  @Test
  void testGetEndColour2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);

    // Act
    PDGamma actualEndColour = (new PDFourColours(array)).getEndColour();

    // Assert
    verify(object).getCOSObject();
    assertNull(actualEndColour);
  }

  /**
   * Method under test: {@link PDFourColours#setEndColour(PDGamma)}
   */
  @Test
  void testSetEndColour() {
    // Arrange
    PDFourColours pdFourColours = new PDFourColours();

    // Act
    pdFourColours.setEndColour(new PDGamma());

    // Assert
    COSBase cOSObject = pdFourColours.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    PDGamma endColour = pdFourColours.getEndColour();
    assertEquals(0.0f, endColour.getB());
    assertEquals(0.0f, endColour.getG());
    assertEquals(0.0f, endColour.getR());
    assertEquals(4, ((COSArray) cOSObject).toList().size());
  }

  /**
   * Method under test: {@link PDFourColours#setEndColour(PDGamma)}
   */
  @Test
  void testSetEndColour2() {
    // Arrange
    PDFourColours pdFourColours = new PDFourColours();

    // Act
    pdFourColours.setEndColour(null);

    // Assert
    COSBase cOSObject = pdFourColours.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    assertNull(pdFourColours.getEndColour());
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    assertSame(toListResult.get(0), toListResult.get(3));
  }

  /**
   * Method under test: {@link PDFourColours#setEndColour(PDGamma)}
   */
  @Test
  void testSetEndColour3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);
    PDFourColours pdFourColours = new PDFourColours(array);

    // Act
    pdFourColours.setEndColour(new PDGamma());

    // Assert
    verify(object).getCOSObject();
    PDGamma endColour = pdFourColours.getEndColour();
    assertEquals(0.0f, endColour.getB());
    assertEquals(0.0f, endColour.getG());
    assertEquals(0.0f, endColour.getR());
    assertSame(array, pdFourColours.getCOSObject());
  }

  /**
   * Method under test: {@link PDFourColours#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange, Act and Assert
    assertTrue((new PDFourColours()).getCOSObject() instanceof COSArray);
  }

  /**
   * Method under test: {@link PDFourColours#PDFourColours()}
   */
  @Test
  void testNewPDFourColours() {
    // Arrange and Act
    PDFourColours actualPdFourColours = new PDFourColours();

    // Assert
    COSBase cOSObject = actualPdFourColours.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSNull);
    assertNull(getResult.getKey());
    assertNull(actualPdFourColours.getAfterColour());
    assertNull(actualPdFourColours.getBeforeColour());
    assertNull(actualPdFourColours.getEndColour());
    assertNull(actualPdFourColours.getStartColour());
    assertFalse(getResult.isDirect());
    assertSame(getResult, toListResult.get(1));
    assertSame(getResult, toListResult.get(2));
    assertSame(getResult, toListResult.get(3));
  }

  /**
   * Method under test: {@link PDFourColours#PDFourColours(COSArray)}
   */
  @Test
  void testNewPDFourColours2() {
    // Arrange
    COSArray array = new COSArray();

    // Act
    PDFourColours actualPdFourColours = new PDFourColours(array);

    // Assert
    assertNull(actualPdFourColours.getAfterColour());
    assertNull(actualPdFourColours.getBeforeColour());
    assertNull(actualPdFourColours.getEndColour());
    assertNull(actualPdFourColours.getStartColour());
    assertEquals(5, array.toList().size());
    assertSame(array, actualPdFourColours.getCOSObject());
  }

  /**
   * Method under test: {@link PDFourColours#PDFourColours(COSArray)}
   */
  @Test
  void testNewPDFourColours3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);

    // Act
    PDFourColours actualPdFourColours = new PDFourColours(array);

    // Assert
    verify(object).getCOSObject();
    assertNull(actualPdFourColours.getAfterColour());
    assertNull(actualPdFourColours.getBeforeColour());
    assertNull(actualPdFourColours.getEndColour());
    assertNull(actualPdFourColours.getStartColour());
    assertEquals(5, array.toList().size());
    assertSame(array, actualPdFourColours.getCOSObject());
  }
}
