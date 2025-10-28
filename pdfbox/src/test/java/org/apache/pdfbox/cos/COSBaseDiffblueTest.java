package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.Test;

class COSBaseDiffblueTest {
  /**
   * Method under test: {@link COSBase#getCOSObject()}
   */
  @Test
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
   * Method under test: {@link COSBase#getCOSObject()}
   */
  @Test
  void testGetCOSObject2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    // Act
    COSBase actualCOSObject = cosArray.getCOSObject();

    // Assert
    verify(object).getCOSObject();
    assertSame(cosArray, actualCOSObject);
  }

  /**
   * Method under test: {@link COSBase#isDirect()}
   */
  @Test
  void testIsDirect() {
    // Arrange, Act and Assert
    assertTrue((new COSArray()).isDirect());
    assertFalse(COSBoolean.FALSE.isDirect());
  }

  /**
   * Method under test: {@link COSBase#isDirect()}
   */
  @Test
  void testIsDirect2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    // Act
    boolean actualIsDirectResult = cosArray.isDirect();

    // Assert
    verify(object).getCOSObject();
    assertTrue(actualIsDirectResult);
  }

  /**
   * Method under test: {@link COSBase#setDirect(boolean)}
   */
  @Test
  void testSetDirect() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    // Act
    cosArray.setDirect(true);

    // Assert
    verify(object).getCOSObject();
  }

  /**
   * Method under test: {@link COSBase#getKey()}
   */
  @Test
  void testGetKey() {
    // Arrange, Act and Assert
    assertNull((new COSArray()).getKey());
  }

  /**
   * Method under test: {@link COSBase#getKey()}
   */
  @Test
  void testGetKey2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    // Act
    COSObjectKey actualKey = cosArray.getKey();

    // Assert
    verify(object).getCOSObject();
    assertNull(actualKey);
  }

  /**
   * Method under test: {@link COSBase#setKey(COSObjectKey)}
   */
  @Test
  void testSetKey() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    // Act
    cosArray.setKey(new COSObjectKey(1L, 1));

    // Assert
    verify(object).getCOSObject();
  }
}
