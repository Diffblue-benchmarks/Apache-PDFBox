package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class XrefEntryDiffblueTest {
  /**
   * Test {@link XrefEntry#XrefEntry(int, COSObjectKey, long, COSObject)}.
   *
   * <p>Method under test: {@link XrefEntry#XrefEntry(int, COSObjectKey, long, COSObject)}
   */
  @Test
  @DisplayName("Test new XrefEntry(int, COSObjectKey, long, COSObject)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XrefEntry.<init>(int, COSObjectKey, long, COSObject)"})
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
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link XrefEntry#getCOSObject()}
   *   <li>{@link XrefEntry#getIndex()}
   *   <li>{@link XrefEntry#getKey()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "COSObject XrefEntry.getCOSObject()",
    "int XrefEntry.getIndex()",
    "COSObjectKey XrefEntry.getKey()"
  })
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
   *
   * <ul>
   *   <li>Then return {@link COSArray}.
   * </ul>
   *
   * <p>Method under test: {@link XrefEntry#getObject()}
   */
  @Test
  @DisplayName("Test getObject(); then return COSArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase XrefEntry.getObject()"})
  void testGetObject_thenReturnCOSArray() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSArray object = new COSArray();
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));

    XrefEntry xrefEntry = new XrefEntry(1, key, 1L, cosObject);

    // Act
    COSBase actualObject = xrefEntry.getObject();

    // Assert
    assertTrue(actualObject instanceof COSArray);
    assertTrue(((COSArray) actualObject).toList().isEmpty());
    assertSame(object, actualObject);
  }

  /**
   * Test {@link XrefEntry#getObject()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XrefEntry#getObject()}
   */
  @Test
  @DisplayName("Test getObject(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase XrefEntry.getObject()"})
  void testGetObject_thenReturnNull() {
    // Arrange
    XrefEntry xrefEntry = new XrefEntry(1, new COSObjectKey(1L, 1), 1L, null);

    // Act and Assert
    assertNull(xrefEntry.getObject());
  }

  /**
   * Test {@link XrefEntry#getPath()}.
   *
   * <ul>
   *   <li>Then return {@code CRT/Compressed object stream: 1 [1 1 R]}.
   * </ul>
   *
   * <p>Method under test: {@link XrefEntry#getPath()}
   */
  @Test
  @DisplayName("Test getPath(); then return 'CRT/Compressed object stream: 1 [1 1 R]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String XrefEntry.getPath()"})
  void testGetPath_thenReturnCrtCompressedObjectStream111R() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSArray object = new COSArray();
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));

    XrefEntry xrefEntry = new XrefEntry(1, key, -1L, cosObject);

    // Act and Assert
    assertEquals("CRT/Compressed object stream: 1 [1 1 R]", xrefEntry.getPath());
  }

  /**
   * Test {@link XrefEntry#getPath()}.
   *
   * <ul>
   *   <li>Then return {@code CRT/(null)}.
   * </ul>
   *
   * <p>Method under test: {@link XrefEntry#getPath()}
   */
  @Test
  @DisplayName("Test getPath(); then return 'CRT/(null)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String XrefEntry.getPath()"})
  void testGetPath_thenReturnCrtNull() {
    // Arrange
    COSArray object = new COSArray();
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));
    XrefEntry xrefEntry = new XrefEntry(1, null, 0L, cosObject);

    // Act and Assert
    assertEquals("CRT/(null)", xrefEntry.getPath());
  }

  /**
   * Test {@link XrefEntry#getPath()}.
   *
   * <ul>
   *   <li>Then return {@code CRT/Offset: 1 [1 1 R]}.
   * </ul>
   *
   * <p>Method under test: {@link XrefEntry#getPath()}
   */
  @Test
  @DisplayName("Test getPath(); then return 'CRT/Offset: 1 [1 1 R]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String XrefEntry.getPath()"})
  void testGetPath_thenReturnCrtOffset111R() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSArray object = new COSArray();
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));

    XrefEntry xrefEntry = new XrefEntry(1, key, 1L, cosObject);

    // Act and Assert
    assertEquals("CRT/Offset: 1 [1 1 R]", xrefEntry.getPath());
  }

  /**
   * Test {@link XrefEntry#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Compressed object stream: 1 [1 1 R]}.
   * </ul>
   *
   * <p>Method under test: {@link XrefEntry#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'Compressed object stream: 1 [1 1 R]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String XrefEntry.toString()"})
  void testToString_thenReturnCompressedObjectStream111R() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSArray object = new COSArray();
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));

    XrefEntry xrefEntry = new XrefEntry(1, key, -1L, cosObject);

    // Act and Assert
    assertEquals("Compressed object stream: 1 [1 1 R]", xrefEntry.toString());
  }

  /**
   * Test {@link XrefEntry#toString()}.
   *
   * <ul>
   *   <li>Then return {@code (null)}.
   * </ul>
   *
   * <p>Method under test: {@link XrefEntry#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return '(null)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String XrefEntry.toString()"})
  void testToString_thenReturnNull() {
    // Arrange
    COSArray object = new COSArray();
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));
    XrefEntry xrefEntry = new XrefEntry(1, null, 0L, cosObject);

    // Act and Assert
    assertEquals("(null)", xrefEntry.toString());
  }

  /**
   * Test {@link XrefEntry#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Offset: 1 [1 1 R]}.
   * </ul>
   *
   * <p>Method under test: {@link XrefEntry#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'Offset: 1 [1 1 R]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String XrefEntry.toString()"})
  void testToString_thenReturnOffset111R() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSArray object = new COSArray();
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));

    XrefEntry xrefEntry = new XrefEntry(1, key, 1L, cosObject);

    // Act and Assert
    assertEquals("Offset: 1 [1 1 R]", xrefEntry.toString());
  }
}
