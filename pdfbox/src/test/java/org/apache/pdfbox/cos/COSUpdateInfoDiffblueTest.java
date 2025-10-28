package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.Test;

class COSUpdateInfoDiffblueTest {
  /**
   * Method under test: {@link COSUpdateInfo#isNeedToBeUpdated()}
   */
  @Test
  void testIsNeedToBeUpdated() {
    // Arrange, Act and Assert
    assertFalse((new COSArray()).isNeedToBeUpdated());
  }

  /**
   * Method under test: {@link COSUpdateInfo#isNeedToBeUpdated()}
   */
  @Test
  void testIsNeedToBeUpdated2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    // Act
    boolean actualIsNeedToBeUpdatedResult = cosArray.isNeedToBeUpdated();

    // Assert
    verify(object).getCOSObject();
    assertFalse(actualIsNeedToBeUpdatedResult);
  }

  /**
   * Method under test: {@link COSUpdateInfo#setNeedToBeUpdated(boolean)}
   */
  @Test
  void testSetNeedToBeUpdated() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    // Act
    cosArray.setNeedToBeUpdated(true);

    // Assert that nothing has changed
    verify(object).getCOSObject();
  }

  /**
   * Method under test: {@link COSUpdateInfo#toIncrement()}
   */
  @Test
  void testToIncrement() {
    // Arrange and Act
    COSIncrement actualToIncrementResult = (new COSArray()).toIncrement();

    // Assert
    assertFalse(actualToIncrementResult.iterator().hasNext());
    assertTrue(actualToIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link COSUpdateInfo#toIncrement()}
   */
  @Test
  void testToIncrement2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    // Act
    COSIncrement actualToIncrementResult = cosArray.toIncrement();

    // Assert
    verify(object).getCOSObject();
    assertFalse(actualToIncrementResult.iterator().hasNext());
    assertTrue(actualToIncrementResult.getObjects().isEmpty());
  }
}
