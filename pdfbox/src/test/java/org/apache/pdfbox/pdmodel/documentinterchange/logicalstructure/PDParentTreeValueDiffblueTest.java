package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.Test;

class PDParentTreeValueDiffblueTest {
  /**
   * Method under test: {@link PDParentTreeValue#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange
    PDParentTreeValue pdParentTreeValue = new PDParentTreeValue(new COSArray());

    // Act
    COSBase actualCOSObject = pdParentTreeValue.getCOSObject();

    // Assert
    assertTrue(actualCOSObject instanceof COSArray);
    assertTrue(((COSArray) actualCOSObject).toList().isEmpty());
    assertSame(pdParentTreeValue.obj, actualCOSObject);
  }

  /**
   * Method under test: {@link PDParentTreeValue#getCOSObject()}
   */
  @Test
  void testGetCOSObject2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray obj = new COSArray();
    obj.add(object);
    PDParentTreeValue pdParentTreeValue = new PDParentTreeValue(obj);

    // Act
    COSBase actualCOSObject = pdParentTreeValue.getCOSObject();

    // Assert
    verify(object).getCOSObject();
    assertSame(pdParentTreeValue.obj, actualCOSObject);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDParentTreeValue#PDParentTreeValue(COSArray)}
   *   <li>{@link PDParentTreeValue#toString()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("COSArray{[]}", (new PDParentTreeValue(new COSArray())).toString());
    assertEquals("COSDictionary{}", (new PDParentTreeValue(new COSDictionary())).toString());
  }
}
