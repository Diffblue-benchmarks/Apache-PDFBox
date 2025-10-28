package org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class PDOutlineItemIteratorDiffblueTest {
  /**
   * Method under test: {@link PDOutlineItemIterator#hasNext()}
   */
  @Test
  void testHasNext() {
    // Arrange, Act and Assert
    assertTrue((new PDOutlineItemIterator(new PDOutlineItem())).hasNext());
    assertFalse((new PDOutlineItemIterator(null)).hasNext());
  }

  /**
   * Method under test: {@link PDOutlineItemIterator#next()}
   */
  @Test
  void testNext() {
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
   * Method under test: {@link PDOutlineItemIterator#next()}
   */
  @Test
  void testNext2() {
    // Arrange, Act and Assert
    assertThrows(NoSuchElementException.class, () -> (new PDOutlineItemIterator(null)).next());
  }

  /**
   * Method under test: {@link PDOutlineItemIterator#remove()}
   */
  @Test
  void testRemove() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new PDOutlineItemIterator(new PDOutlineItem())).remove());
  }

  /**
   * Method under test:
   * {@link PDOutlineItemIterator#PDOutlineItemIterator(PDOutlineItem)}
   */
  @Test
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
}
