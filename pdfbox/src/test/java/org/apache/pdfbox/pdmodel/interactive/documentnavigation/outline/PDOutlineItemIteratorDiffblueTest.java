package org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDOutlineItemIteratorDiffblueTest {
  /**
   * Test {@link PDOutlineItemIterator#PDOutlineItemIterator(PDOutlineItem)}.
   *
   * <p>Method under test: {@link PDOutlineItemIterator#PDOutlineItemIterator(PDOutlineItem)}
   */
  @Test
  @DisplayName("Test new PDOutlineItemIterator(PDOutlineItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineItemIterator.<init>(PDOutlineItem)"})
  void testNewPDOutlineItemIterator() {
    // Arrange
    PDOutlineItem startingItem = new PDOutlineItem();

    // Act
    PDOutlineItemIterator actualPdOutlineItemIterator = new PDOutlineItemIterator(startingItem);

    // Assert
    PDOutlineItem actualNextResult = actualPdOutlineItemIterator.next();
    assertFalse(actualPdOutlineItemIterator.hasNext());
    assertSame(startingItem, actualNextResult);
  }

  /**
   * Test {@link PDOutlineItemIterator#hasNext()}.
   *
   * <ul>
   *   <li>Given {@link PDOutlineItemIterator#PDOutlineItemIterator(PDOutlineItem)} with
   *       startingItem is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineItemIterator#hasNext()}
   */
  @Test
  @DisplayName(
      "Test hasNext(); given PDOutlineItemIterator(PDOutlineItem) with startingItem is 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOutlineItemIterator.hasNext()"})
  void testHasNext_givenPDOutlineItemIteratorWithStartingItemIsNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDOutlineItemIterator(null).hasNext());
  }

  /**
   * Test {@link PDOutlineItemIterator#hasNext()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineItemIterator#hasNext()}
   */
  @Test
  @DisplayName("Test hasNext(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOutlineItemIterator.hasNext()"})
  void testHasNext_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new PDOutlineItemIterator(new PDOutlineItem()).hasNext());
  }

  /**
   * Test {@link PDOutlineItemIterator#next()}.
   *
   * <ul>
   *   <li>Then not {@link PDOutlineItemIterator#PDOutlineItemIterator(PDOutlineItem)} with
   *       startingItem is {@link PDOutlineItem#PDOutlineItem()} hasNext.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineItemIterator#next()}
   */
  @Test
  @DisplayName(
      "Test next(); then not PDOutlineItemIterator(PDOutlineItem) with startingItem is PDOutlineItem() hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDOutlineItem PDOutlineItemIterator.next()"})
  void testNext_thenNotPDOutlineItemIteratorWithStartingItemIsPDOutlineItemHasNext() {
    // Arrange
    PDOutlineItem startingItem = new PDOutlineItem();
    PDOutlineItemIterator pdOutlineItemIterator = new PDOutlineItemIterator(startingItem);

    // Act
    PDOutlineItem actualNextResult = pdOutlineItemIterator.next();

    // Assert
    assertFalse(pdOutlineItemIterator.hasNext());
    assertSame(startingItem, actualNextResult);
  }

  /**
   * Test {@link PDOutlineItemIterator#next()}.
   *
   * <ul>
   *   <li>Then throw {@link NoSuchElementException}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineItemIterator#next()}
   */
  @Test
  @DisplayName("Test next(); then throw NoSuchElementException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDOutlineItem PDOutlineItemIterator.next()"})
  void testNext_thenThrowNoSuchElementException() {
    // Arrange, Act and Assert
    assertThrows(NoSuchElementException.class, () -> new PDOutlineItemIterator(null).next());
  }

  /**
   * Test {@link PDOutlineItemIterator#remove()}.
   *
   * <p>Method under test: {@link PDOutlineItemIterator#remove()}
   */
  @Test
  @DisplayName("Test remove()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineItemIterator.remove()"})
  void testRemove() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new PDOutlineItemIterator(new PDOutlineItem()).remove());
  }
}
