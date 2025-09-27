package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class COSUpdateStateDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link COSUpdateState#COSUpdateState(COSUpdateInfo)}
   *   <li>{@link COSUpdateState#getOriginDocumentState()}
   *   <li>{@link COSUpdateState#isUpdated()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void COSUpdateState.<init>(COSUpdateInfo)",
    "COSDocumentState COSUpdateState.getOriginDocumentState()",
    "boolean COSUpdateState.isUpdated()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    COSUpdateState actualCosUpdateState = new COSUpdateState(new COSArray());
    COSDocumentState actualOriginDocumentState = actualCosUpdateState.getOriginDocumentState();

    // Assert
    assertNull(actualOriginDocumentState);
    assertFalse(actualCosUpdateState.isUpdated());
  }

  /**
   * Test {@link COSUpdateState#setOriginDocumentState(COSDocumentState)} with {@code
   * originDocumentState}.
   *
   * <p>Method under test: {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}
   */
  @Test
  @DisplayName("Test setOriginDocumentState(COSDocumentState) with 'originDocumentState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSUpdateState.setOriginDocumentState(COSDocumentState)"})
  void testSetOriginDocumentStateWithOriginDocumentState() {
    // Arrange
    COSUpdateState cosUpdateState = new COSUpdateState(new COSArray());

    COSDocumentState originDocumentState = new COSDocumentState();
    originDocumentState.setParsing(true);

    // Act
    cosUpdateState.setOriginDocumentState(originDocumentState);

    // Assert
    assertSame(originDocumentState, cosUpdateState.getOriginDocumentState());
  }

  /**
   * Test {@link COSUpdateState#setOriginDocumentState(COSDocumentState)} with {@code
   * originDocumentState}.
   *
   * <p>Method under test: {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}
   */
  @Test
  @DisplayName("Test setOriginDocumentState(COSDocumentState) with 'originDocumentState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSUpdateState.setOriginDocumentState(COSDocumentState)"})
  void testSetOriginDocumentStateWithOriginDocumentState2() {
    // Arrange
    COSUpdateState cosUpdateState = new COSUpdateState(new COSArray());

    // Act
    cosUpdateState.setOriginDocumentState(null);

    // Assert that nothing has changed
    assertNull(cosUpdateState.getOriginDocumentState());
  }

  /**
   * Test {@link COSUpdateState#setOriginDocumentState(COSDocumentState)} with {@code
   * originDocumentState}.
   *
   * <p>Method under test: {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}
   */
  @Test
  @DisplayName("Test setOriginDocumentState(COSDocumentState) with 'originDocumentState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSUpdateState.setOriginDocumentState(COSDocumentState)"})
  void testSetOriginDocumentStateWithOriginDocumentState3() {
    // Arrange
    COSUpdateState cosUpdateState = new COSUpdateState(new COSDictionary());

    COSDocumentState originDocumentState = new COSDocumentState();
    originDocumentState.setParsing(true);

    // Act
    cosUpdateState.setOriginDocumentState(originDocumentState);

    // Assert
    assertSame(originDocumentState, cosUpdateState.getOriginDocumentState());
  }

  /**
   * Test {@link COSUpdateState#setOriginDocumentState(COSDocumentState)} with {@code
   * originDocumentState}.
   *
   * <p>Method under test: {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}
   */
  @Test
  @DisplayName("Test setOriginDocumentState(COSDocumentState) with 'originDocumentState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSUpdateState.setOriginDocumentState(COSDocumentState)"})
  void testSetOriginDocumentStateWithOriginDocumentState4() {
    // Arrange
    COSUpdateState cosUpdateState = new COSUpdateState(null);

    COSDocumentState originDocumentState = new COSDocumentState();
    originDocumentState.setParsing(true);

    // Act
    cosUpdateState.setOriginDocumentState(originDocumentState);

    // Assert
    assertSame(originDocumentState, cosUpdateState.getOriginDocumentState());
  }

  /**
   * Test {@link COSUpdateState#setOriginDocumentState(COSDocumentState)} with {@code
   * originDocumentState}.
   *
   * <p>Method under test: {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}
   */
  @Test
  @DisplayName("Test setOriginDocumentState(COSDocumentState) with 'originDocumentState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSUpdateState.setOriginDocumentState(COSDocumentState)"})
  void testSetOriginDocumentStateWithOriginDocumentState5() {
    // Arrange
    COSArray updateInfo = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    COSUpdateState cosUpdateState = new COSUpdateState(updateInfo);

    COSDocumentState originDocumentState = new COSDocumentState();
    originDocumentState.setParsing(true);

    // Act
    cosUpdateState.setOriginDocumentState(originDocumentState);

    // Assert
    assertSame(originDocumentState, cosUpdateState.getOriginDocumentState());
  }

  /**
   * Test {@link COSUpdateState#setOriginDocumentState(COSDocumentState)} with {@code
   * originDocumentState}.
   *
   * <p>Method under test: {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}
   */
  @Test
  @DisplayName("Test setOriginDocumentState(COSDocumentState) with 'originDocumentState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSUpdateState.setOriginDocumentState(COSDocumentState)"})
  void testSetOriginDocumentStateWithOriginDocumentState6() {
    // Arrange
    COSUpdateState cosUpdateState = new COSUpdateState(new COSStream());

    COSDocumentState originDocumentState = new COSDocumentState();
    originDocumentState.setParsing(true);

    // Act
    cosUpdateState.setOriginDocumentState(originDocumentState);

    // Assert
    assertSame(originDocumentState, cosUpdateState.getOriginDocumentState());
  }

  /**
   * Test {@link COSUpdateState#isAcceptingUpdates()}.
   *
   * <p>Method under test: {@link COSUpdateState#isAcceptingUpdates()}
   */
  @Test
  @DisplayName("Test isAcceptingUpdates()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSUpdateState.isAcceptingUpdates()"})
  void testIsAcceptingUpdates() {
    // Arrange, Act and Assert
    assertFalse(new COSUpdateState(new COSArray()).isAcceptingUpdates());
  }

  /**
   * Test {@link COSUpdateState#toIncrement()}.
   *
   * <p>Method under test: {@link COSUpdateState#toIncrement()}
   */
  @Test
  @DisplayName("Test toIncrement()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSIncrement COSUpdateState.toIncrement()"})
  void testToIncrement() {
    // Arrange and Act
    COSIncrement actualToIncrementResult = new COSUpdateState(new COSArray()).toIncrement();

    // Assert
    assertFalse(actualToIncrementResult.iterator().hasNext());
    assertTrue(actualToIncrementResult.getObjects().isEmpty());
  }
}
