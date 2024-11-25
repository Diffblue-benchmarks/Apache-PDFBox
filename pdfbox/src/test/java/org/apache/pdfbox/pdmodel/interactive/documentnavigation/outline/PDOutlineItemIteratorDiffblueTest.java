package org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDOutlineItemIteratorDiffblueTest {
  /**
   * Test {@link PDOutlineItemIterator#PDOutlineItemIterator(PDOutlineItem)}.
   * <p>
   * Method under test:
   * {@link PDOutlineItemIterator#PDOutlineItemIterator(PDOutlineItem)}
   */
  @Test
  @DisplayName("Test new PDOutlineItemIterator(PDOutlineItem)")
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
   * <ul>
   *   <li>Given {@link PDOutlineItemIterator#PDOutlineItemIterator(PDOutlineItem)}
   * with startingItem is {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItemIterator#hasNext()}
   */
  @Test
  @DisplayName("Test hasNext(); given PDOutlineItemIterator(PDOutlineItem) with startingItem is 'null'; then return 'false'")
  void testHasNext_givenPDOutlineItemIteratorWithStartingItemIsNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDOutlineItemIterator(null)).hasNext());
  }

  /**
   * Test {@link PDOutlineItemIterator#hasNext()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItemIterator#hasNext()}
   */
  @Test
  @DisplayName("Test hasNext(); then return 'true'")
  void testHasNext_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new PDOutlineItemIterator(new PDOutlineItem())).hasNext());
  }

  /**
   * Test {@link PDOutlineItemIterator#next()}.
   * <ul>
   *   <li>Then not
   * {@link PDOutlineItemIterator#PDOutlineItemIterator(PDOutlineItem)} with
   * startingItem is {@link PDOutlineItem#PDOutlineItem()} hasNext.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItemIterator#next()}
   */
  @Test
  @DisplayName("Test next(); then not PDOutlineItemIterator(PDOutlineItem) with startingItem is PDOutlineItem() hasNext")
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
   * <ul>
   *   <li>Then throw {@link NoSuchElementException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItemIterator#next()}
   */
  @Test
  @DisplayName("Test next(); then throw NoSuchElementException")
  void testNext_thenThrowNoSuchElementException() {
    // Arrange, Act and Assert
    assertThrows(NoSuchElementException.class, () -> (new PDOutlineItemIterator(null)).next());
  }

  /**
   * Test {@link PDOutlineItemIterator#remove()}.
   * <p>
   * Method under test: {@link PDOutlineItemIterator#remove()}
   */
  @Test
  @DisplayName("Test remove()")
  void testRemove() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new PDOutlineItemIterator(new PDOutlineItem())).remove());
  }
}
