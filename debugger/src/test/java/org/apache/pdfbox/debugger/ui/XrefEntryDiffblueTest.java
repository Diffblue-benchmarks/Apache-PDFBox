package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class XrefEntryDiffblueTest {
  /**
   * Test {@link XrefEntry#XrefEntry(int, COSObjectKey, long, COSObject)}.
   * <p>
   * Method under test:
   * {@link XrefEntry#XrefEntry(int, COSObjectKey, long, COSObject)}
   */
  @Test
  @DisplayName("Test new XrefEntry(int, COSObjectKey, long, COSObject)")
  void testNewXrefEntry() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSArray object = new COSArray();
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));

    // Act
    XrefEntry actualXrefEntry = new XrefEntry(1, key, 1L, cosObject);

    // Assert
    COSBase object2 = actualXrefEntry.getObject();
    assertTrue(object2 instanceof COSArray);
    assertEquals("CRT/Offset: 1 [1 1 R]", actualXrefEntry.getPath());
    assertEquals(1, actualXrefEntry.getIndex());
    assertTrue(((COSArray) object2).toList().isEmpty());
    assertSame(object, object2);
    assertSame(cosObject, actualXrefEntry.getCOSObject());
    assertSame(key, actualXrefEntry.getKey());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link XrefEntry#getCOSObject()}
   *   <li>{@link XrefEntry#getIndex()}
   *   <li>{@link XrefEntry#getKey()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSArray object = new COSArray();
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));

    XrefEntry xrefEntry = new XrefEntry(1, key, 1L, cosObject);

    // Act
    COSObject actualCOSObject = xrefEntry.getCOSObject();
    int actualIndex = xrefEntry.getIndex();

    // Assert
    assertEquals(1, actualIndex);
    assertSame(cosObject, actualCOSObject);
    assertSame(key, xrefEntry.getKey());
  }

  /**
   * Test {@link XrefEntry#getObject()}.
   * <ul>
   *   <li>Then return {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XrefEntry#getObject()}
   */
  @Test
  @DisplayName("Test getObject(); then return COSArray")
  void testGetObject_thenReturnCOSArray() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSArray object = new COSArray();

    // Act
    COSBase actualObject = (new XrefEntry(1, key, 1L, new COSObject(object, new COSObjectKey(1L, 1)))).getObject();

    // Assert
    assertTrue(actualObject instanceof COSArray);
    assertTrue(((COSArray) actualObject).toList().isEmpty());
    assertSame(object, actualObject);
  }

  /**
   * Test {@link XrefEntry#getObject()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XrefEntry#getObject()}
   */
  @Test
  @DisplayName("Test getObject(); then return 'null'")
  void testGetObject_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new XrefEntry(1, new COSObjectKey(1L, 1), 1L, null)).getObject());
  }

  /**
   * Test {@link XrefEntry#getPath()}.
   * <ul>
   *   <li>Then return {@code CRT/Compressed object stream: 1 [1 1 R]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XrefEntry#getPath()}
   */
  @Test
  @DisplayName("Test getPath(); then return 'CRT/Compressed object stream: 1 [1 1 R]'")
  void testGetPath_thenReturnCrtCompressedObjectStream111R() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSArray object = new COSArray();

    // Act and Assert
    assertEquals("CRT/Compressed object stream: 1 [1 1 R]",
        (new XrefEntry(1, key, -1L, new COSObject(object, new COSObjectKey(1L, 1)))).getPath());
  }

  /**
   * Test {@link XrefEntry#getPath()}.
   * <ul>
   *   <li>Then return {@code CRT/(null)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XrefEntry#getPath()}
   */
  @Test
  @DisplayName("Test getPath(); then return 'CRT/(null)'")
  void testGetPath_thenReturnCrtNull() {
    // Arrange
    COSArray object = new COSArray();

    // Act and Assert
    assertEquals("CRT/(null)", (new XrefEntry(1, null, 1L, new COSObject(object, new COSObjectKey(1L, 1)))).getPath());
  }

  /**
   * Test {@link XrefEntry#getPath()}.
   * <ul>
   *   <li>Then return {@code CRT/Offset: 1 [1 1 R]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XrefEntry#getPath()}
   */
  @Test
  @DisplayName("Test getPath(); then return 'CRT/Offset: 1 [1 1 R]'")
  void testGetPath_thenReturnCrtOffset111R() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSArray object = new COSArray();

    // Act and Assert
    assertEquals("CRT/Offset: 1 [1 1 R]",
        (new XrefEntry(1, key, 1L, new COSObject(object, new COSObjectKey(1L, 1)))).getPath());
  }

  /**
   * Test {@link XrefEntry#toString()}.
   * <ul>
   *   <li>Then return {@code Compressed object stream: 1 [1 1 R]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XrefEntry#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'Compressed object stream: 1 [1 1 R]'")
  void testToString_thenReturnCompressedObjectStream111R() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSArray object = new COSArray();

    // Act and Assert
    assertEquals("Compressed object stream: 1 [1 1 R]",
        (new XrefEntry(1, key, -1L, new COSObject(object, new COSObjectKey(1L, 1)))).toString());
  }

  /**
   * Test {@link XrefEntry#toString()}.
   * <ul>
   *   <li>Then return {@code (null)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XrefEntry#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return '(null)'")
  void testToString_thenReturnNull() {
    // Arrange
    COSArray object = new COSArray();

    // Act and Assert
    assertEquals("(null)", (new XrefEntry(1, null, 1L, new COSObject(object, new COSObjectKey(1L, 1)))).toString());
  }

  /**
   * Test {@link XrefEntry#toString()}.
   * <ul>
   *   <li>Then return {@code Offset: 1 [1 1 R]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XrefEntry#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'Offset: 1 [1 1 R]'")
  void testToString_thenReturnOffset111R() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSArray object = new COSArray();

    // Act and Assert
    assertEquals("Offset: 1 [1 1 R]",
        (new XrefEntry(1, key, 1L, new COSObject(object, new COSObjectKey(1L, 1)))).toString());
  }
}
