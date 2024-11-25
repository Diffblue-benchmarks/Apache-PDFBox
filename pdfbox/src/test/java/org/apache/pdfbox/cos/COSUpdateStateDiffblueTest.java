package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class COSUpdateStateDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link COSUpdateState#COSUpdateState(COSUpdateInfo)}
   *   <li>{@link COSUpdateState#getOriginDocumentState()}
   *   <li>{@link COSUpdateState#isUpdated()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    COSUpdateState actualCosUpdateState = new COSUpdateState(new COSArray());
    COSDocumentState actualOriginDocumentState = actualCosUpdateState.getOriginDocumentState();

    // Assert
    assertNull(actualOriginDocumentState);
    assertFalse(actualCosUpdateState.isUpdated());
  }

  /**
   * Test {@link COSUpdateState#setOriginDocumentState(COSDocumentState)} with
   * {@code originDocumentState}.
   * <p>
   * Method under test:
   * {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}
   */
  @Test
  @DisplayName("Test setOriginDocumentState(COSDocumentState) with 'originDocumentState'")
  void testSetOriginDocumentStateWithOriginDocumentState() {
    // Arrange
    COSUpdateState cosUpdateState = new COSUpdateState(new COSArray());

    COSDocumentState originDocumentState = new COSDocumentState();
    originDocumentState.setParsing(true);

    // Act
    cosUpdateState.setOriginDocumentState(originDocumentState);

    // Assert
    assertFalse(cosUpdateState.isAcceptingUpdates());
    assertFalse(cosUpdateState.isUpdated());
    assertSame(originDocumentState, cosUpdateState.getOriginDocumentState());
  }

  /**
   * Test {@link COSUpdateState#setOriginDocumentState(COSDocumentState)} with
   * {@code originDocumentState}.
   * <p>
   * Method under test:
   * {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}
   */
  @Test
  @DisplayName("Test setOriginDocumentState(COSDocumentState) with 'originDocumentState'")
  void testSetOriginDocumentStateWithOriginDocumentState2() {
    // Arrange
    COSUpdateState cosUpdateState = new COSUpdateState(new COSDictionary());

    COSDocumentState originDocumentState = new COSDocumentState();
    originDocumentState.setParsing(true);

    // Act
    cosUpdateState.setOriginDocumentState(originDocumentState);

    // Assert
    assertFalse(cosUpdateState.isAcceptingUpdates());
    assertFalse(cosUpdateState.isUpdated());
    assertSame(originDocumentState, cosUpdateState.getOriginDocumentState());
  }

  /**
   * Test {@link COSUpdateState#setOriginDocumentState(COSDocumentState)} with
   * {@code originDocumentState}.
   * <p>
   * Method under test:
   * {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}
   */
  @Test
  @DisplayName("Test setOriginDocumentState(COSDocumentState) with 'originDocumentState'")
  void testSetOriginDocumentStateWithOriginDocumentState3() {
    // Arrange
    COSUpdateState cosUpdateState = new COSUpdateState(null);

    COSDocumentState originDocumentState = new COSDocumentState();
    originDocumentState.setParsing(true);

    // Act
    cosUpdateState.setOriginDocumentState(originDocumentState);

    // Assert
    assertFalse(cosUpdateState.isAcceptingUpdates());
    assertFalse(cosUpdateState.isUpdated());
    assertSame(originDocumentState, cosUpdateState.getOriginDocumentState());
  }

  /**
   * Test {@link COSUpdateState#setOriginDocumentState(COSDocumentState)} with
   * {@code originDocumentState}.
   * <p>
   * Method under test:
   * {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}
   */
  @Test
  @DisplayName("Test setOriginDocumentState(COSDocumentState) with 'originDocumentState'")
  void testSetOriginDocumentStateWithOriginDocumentState4() {
    // Arrange
    COSUpdateState cosUpdateState = new COSUpdateState(COSArray.of(10.0f, 0.5f, 10.0f, 0.5f));

    COSDocumentState originDocumentState = new COSDocumentState();
    originDocumentState.setParsing(true);

    // Act
    cosUpdateState.setOriginDocumentState(originDocumentState);

    // Assert
    assertFalse(cosUpdateState.isAcceptingUpdates());
    assertFalse(cosUpdateState.isUpdated());
    assertSame(originDocumentState, cosUpdateState.getOriginDocumentState());
  }

  /**
   * Test {@link COSUpdateState#setOriginDocumentState(COSDocumentState)} with
   * {@code originDocumentState}.
   * <p>
   * Method under test:
   * {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}
   */
  @Test
  @DisplayName("Test setOriginDocumentState(COSDocumentState) with 'originDocumentState'")
  void testSetOriginDocumentStateWithOriginDocumentState5() {
    // Arrange
    COSUpdateState cosUpdateState = new COSUpdateState(new COSStream());

    COSDocumentState originDocumentState = new COSDocumentState();
    originDocumentState.setParsing(true);

    // Act
    cosUpdateState.setOriginDocumentState(originDocumentState);

    // Assert
    assertFalse(cosUpdateState.isAcceptingUpdates());
    assertFalse(cosUpdateState.isUpdated());
    assertSame(originDocumentState, cosUpdateState.getOriginDocumentState());
  }

  /**
   * Test {@link COSUpdateState#setOriginDocumentState(COSDocumentState)} with
   * {@code originDocumentState}.
   * <p>
   * Method under test:
   * {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}
   */
  @Test
  @DisplayName("Test setOriginDocumentState(COSDocumentState) with 'originDocumentState'")
  void testSetOriginDocumentStateWithOriginDocumentState6() {
    // Arrange
    COSUpdateState cosUpdateState = new COSUpdateState(new COSArray());

    COSDocumentState originDocumentState = new COSDocumentState();
    originDocumentState.setParsing(false);

    // Act
    cosUpdateState.setOriginDocumentState(originDocumentState);

    // Assert
    assertTrue(cosUpdateState.isAcceptingUpdates());
    assertTrue(cosUpdateState.isUpdated());
    assertSame(originDocumentState, cosUpdateState.getOriginDocumentState());
  }

  /**
   * Test {@link COSUpdateState#setOriginDocumentState(COSDocumentState)} with
   * {@code originDocumentState}.
   * <p>
   * Method under test:
   * {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}
   */
  @Test
  @DisplayName("Test setOriginDocumentState(COSDocumentState) with 'originDocumentState'")
  void testSetOriginDocumentStateWithOriginDocumentState7() {
    // Arrange
    COSUpdateState cosUpdateState = new COSUpdateState(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    COSDocumentState originDocumentState = new COSDocumentState();
    originDocumentState.setParsing(true);

    // Act
    cosUpdateState.setOriginDocumentState(originDocumentState);

    // Assert
    assertFalse(cosUpdateState.isAcceptingUpdates());
    assertFalse(cosUpdateState.isUpdated());
    assertSame(originDocumentState, cosUpdateState.getOriginDocumentState());
  }

  /**
   * Test {@link COSUpdateState#setOriginDocumentState(COSDocumentState)} with
   * {@code originDocumentState}.
   * <p>
   * Method under test:
   * {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}
   */
  @Test
  @DisplayName("Test setOriginDocumentState(COSDocumentState) with 'originDocumentState'")
  void testSetOriginDocumentStateWithOriginDocumentState8() {
    // Arrange
    COSDictionary object = new COSDictionary();
    COSUpdateState cosUpdateState = new COSUpdateState(new COSObject(object, new COSObjectKey(1L, 1)));

    COSDocumentState originDocumentState = new COSDocumentState();
    originDocumentState.setParsing(true);

    // Act
    cosUpdateState.setOriginDocumentState(originDocumentState);

    // Assert
    assertFalse(cosUpdateState.isAcceptingUpdates());
    assertFalse(cosUpdateState.isUpdated());
    assertSame(originDocumentState, cosUpdateState.getOriginDocumentState());
  }

  /**
   * Test {@link COSUpdateState#isAcceptingUpdates()}.
   * <p>
   * Method under test: {@link COSUpdateState#isAcceptingUpdates()}
   */
  @Test
  @DisplayName("Test isAcceptingUpdates()")
  void testIsAcceptingUpdates() {
    // Arrange, Act and Assert
    assertFalse((new COSUpdateState(new COSArray())).isAcceptingUpdates());
  }

  /**
   * Test {@link COSUpdateState#toIncrement()}.
   * <p>
   * Method under test: {@link COSUpdateState#toIncrement()}
   */
  @Test
  @DisplayName("Test toIncrement()")
  void testToIncrement() {
    // Arrange and Act
    COSIncrement actualToIncrementResult = (new COSUpdateState(new COSArray())).toIncrement();

    // Assert
    assertFalse(actualToIncrementResult.iterator().hasNext());
    assertTrue(actualToIncrementResult.getObjects().isEmpty());
  }
}
