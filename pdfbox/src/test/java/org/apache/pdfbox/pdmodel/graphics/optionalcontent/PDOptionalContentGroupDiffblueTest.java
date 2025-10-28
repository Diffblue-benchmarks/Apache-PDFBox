package org.apache.pdfbox.pdmodel.graphics.optionalcontent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.rendering.RenderDestination;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDOptionalContentGroupDiffblueTest {
  /**
   * Method under test: {@link PDOptionalContentGroup#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("Name", (new PDOptionalContentGroup("Name")).getName());
    assertEquals("", (new PDOptionalContentGroup("")).getName());
  }

  /**
   * Method under test:
   * {@link PDOptionalContentGroup#getRenderState(RenderDestination)}
   */
  @Test
  void testGetRenderState() {
    // Arrange, Act and Assert
    assertNull((new PDOptionalContentGroup("Name")).getRenderState(RenderDestination.EXPORT));
  }

  /**
   * Method under test:
   * {@link PDOptionalContentGroup#PDOptionalContentGroup(String)}
   */
  @Test
  void testNewPDOptionalContentGroup() {
    // Arrange and Act
    PDOptionalContentGroup actualPdOptionalContentGroup = new PDOptionalContentGroup("Name");

    // Assert
    assertEquals("Name", actualPdOptionalContentGroup.getName());
    COSDictionary cOSObject = actualPdOptionalContentGroup.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDOptionalContentGroup#PDOptionalContentGroup(String)}
   */
  @Test
  void testNewPDOptionalContentGroup2() {
    // Arrange and Act
    PDOptionalContentGroup actualPdOptionalContentGroup = new PDOptionalContentGroup((String) null);

    // Assert
    assertNull(actualPdOptionalContentGroup.getName());
    COSDictionary cOSObject = actualPdOptionalContentGroup.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDOptionalContentGroup#PDOptionalContentGroup(COSDictionary)}
   */
  @Test
  void testNewPDOptionalContentGroup3() {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDOptionalContentGroup(dict));
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Method under test:
   * {@link PDOptionalContentGroup#PDOptionalContentGroup(COSDictionary)}
   */
  @Test
  void testNewPDOptionalContentGroup4() {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSFloat.ONE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDOptionalContentGroup(dict));
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Method under test:
   * {@link PDOptionalContentGroup#PDOptionalContentGroup(COSDictionary)}
   */
  @Test
  void testNewPDOptionalContentGroup5() {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSInteger.ONE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDOptionalContentGroup(dict));
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Method under test:
   * {@link PDOptionalContentGroup#PDOptionalContentGroup(COSDictionary)}
   */
  @Test
  void testNewPDOptionalContentGroup6() {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSName.A);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDOptionalContentGroup(dict));
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Method under test:
   * {@link PDOptionalContentGroup#PDOptionalContentGroup(COSDictionary)}
   */
  @Test
  void testNewPDOptionalContentGroup7() throws IOException {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSString.parseHex("0123456789ABCDEF"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDOptionalContentGroup(dict));
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Method under test: {@link PDOptionalContentGroup.RenderState#getName()}
   */
  @Test
  void testRenderStateGetName() {
    // Arrange and Act
    COSName actualName = PDOptionalContentGroup.RenderState.valueOf("ON").getName();

    // Assert
    assertSame(actualName.ON, actualName);
  }

  /**
   * Method under test:
   * {@link PDOptionalContentGroup.RenderState#valueOf(COSName)}
   */
  @Test
  void testRenderStateValueOf() {
    // Arrange, Act and Assert
    assertNull(PDOptionalContentGroup.RenderState.valueOf((COSName) null));
  }
}
