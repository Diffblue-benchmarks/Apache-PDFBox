package org.apache.pdfbox.pdfparser.xref;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.apache.pdfbox.cos.COSObjectKey;
import org.junit.jupiter.api.Test;

class FreeXReferenceDiffblueTest {
  /**
   * Method under test: {@link FreeXReference#getThirdColumnValue()}
   */
  @Test
  void testGetThirdColumnValue() {
    // Arrange, Act and Assert
    assertEquals(65535L, FreeXReference.NULL_ENTRY.getThirdColumnValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FreeXReference#toString()}
   *   <li>{@link FreeXReference#getReferencedKey()}
   *   <li>{@link FreeXReference#getSecondColumnValue()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);

    FreeXReference freeXReference = new FreeXReference(key, 1L);

    // Act
    String actualToStringResult = freeXReference.toString();
    COSObjectKey actualReferencedKey = freeXReference.getReferencedKey();

    // Assert
    assertEquals("FreeReference{key=1 1 R, nextFreeObject=1, type=0 }", actualToStringResult);
    assertEquals(1L, freeXReference.getSecondColumnValue());
    assertSame(key, actualReferencedKey);
  }

  /**
   * Method under test: {@link FreeXReference#FreeXReference(COSObjectKey, long)}
   */
  @Test
  void testNewFreeXReference() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);

    // Act
    FreeXReference actualFreeXReference = new FreeXReference(key, 1L);

    // Assert
    assertEquals(0L, actualFreeXReference.getFirstColumnValue());
    assertEquals(1L, actualFreeXReference.getSecondColumnValue());
    assertEquals(1L, actualFreeXReference.getThirdColumnValue());
    assertEquals(XReferenceType.FREE, actualFreeXReference.getType());
    assertSame(key, actualFreeXReference.getReferencedKey());
  }
}
