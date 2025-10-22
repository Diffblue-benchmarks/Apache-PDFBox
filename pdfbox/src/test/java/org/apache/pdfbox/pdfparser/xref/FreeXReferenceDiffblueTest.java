package org.apache.pdfbox.pdfparser.xref;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSObjectKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FreeXReferenceDiffblueTest {
  /**
   * Test {@link FreeXReference#FreeXReference(COSObjectKey, long)}.
   * <p>
   * Method under test: {@link FreeXReference#FreeXReference(COSObjectKey, long)}
   */
  @Test
  @DisplayName("Test new FreeXReference(COSObjectKey, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FreeXReference.<init>(COSObjectKey, long)"})
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

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FreeXReference#toString()}
   *   <li>{@link FreeXReference#getReferencedKey()}
   *   <li>{@link FreeXReference#getSecondColumnValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSObjectKey FreeXReference.getReferencedKey()", "long FreeXReference.getSecondColumnValue()",
      "String FreeXReference.toString()"})
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
   * Test {@link FreeXReference#getThirdColumnValue()}.
   * <ul>
   *   <li>Given {@link FreeXReference#NULL_ENTRY}.</li>
   *   <li>Then return {@code 65535}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreeXReference#getThirdColumnValue()}
   */
  @Test
  @DisplayName("Test getThirdColumnValue(); given NULL_ENTRY; then return '65535'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long FreeXReference.getThirdColumnValue()"})
  void testGetThirdColumnValue_givenNull_entry_thenReturn65535() {
    // Arrange, Act and Assert
    assertEquals(65535L, FreeXReference.NULL_ENTRY.getThirdColumnValue());
  }
}
