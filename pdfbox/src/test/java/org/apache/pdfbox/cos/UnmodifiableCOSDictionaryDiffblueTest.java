package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UnmodifiableCOSDictionaryDiffblueTest {
  /**
   * Test {@link UnmodifiableCOSDictionary#UnmodifiableCOSDictionary(COSDictionary)}.
   *
   * <ul>
   *   <li>Then return UpdateState OriginDocumentState is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UnmodifiableCOSDictionary#UnmodifiableCOSDictionary(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new UnmodifiableCOSDictionary(COSDictionary); then return UpdateState OriginDocumentState is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UnmodifiableCOSDictionary.<init>(COSDictionary)"})
  void testNewUnmodifiableCOSDictionary_thenReturnUpdateStateOriginDocumentStateIsNull() {
    // Arrange and Act
    UnmodifiableCOSDictionary actualUnmodifiableCOSDictionary =
        new UnmodifiableCOSDictionary(new COSDictionary());

    // Assert
    COSUpdateState updateState = actualUnmodifiableCOSDictionary.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualUnmodifiableCOSDictionary.getKey());
    assertEquals(0, actualUnmodifiableCOSDictionary.size());
    COSIncrement toIncrementResult = actualUnmodifiableCOSDictionary.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualUnmodifiableCOSDictionary.isDirect());
    assertFalse(actualUnmodifiableCOSDictionary.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(actualUnmodifiableCOSDictionary.getValues().isEmpty());
    assertTrue(actualUnmodifiableCOSDictionary.items.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link UnmodifiableCOSDictionary#setNeedToBeUpdated(boolean)}.
   *
   * <p>Method under test: {@link UnmodifiableCOSDictionary#setNeedToBeUpdated(boolean)}
   */
  @Test
  @DisplayName("Test setNeedToBeUpdated(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UnmodifiableCOSDictionary.setNeedToBeUpdated(boolean)"})
  void testSetNeedToBeUpdated() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new UnmodifiableCOSDictionary(new COSDictionary()).setNeedToBeUpdated(true));
  }
}
