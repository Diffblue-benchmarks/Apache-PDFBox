package org.apache.fontbox.cmap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;

class CMapDiffblueTest {
  /**
   * Method under test: {@link CMap#hasCIDMappings()}
   */
  @Test
  void testHasCIDMappings() {
    // Arrange, Act and Assert
    assertFalse((new CMap()).hasCIDMappings());
  }

  /**
   * Method under test: {@link CMap#hasCIDMappings()}
   */
  @Test
  void testHasCIDMappings2() {
    // Arrange
    CMap cMap = new CMap();
    cMap.addCIDMapping(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1);

    // Act and Assert
    assertTrue(cMap.hasCIDMappings());
  }

  /**
   * Method under test: {@link CMap#hasCIDMappings()}
   */
  @Test
  void testHasCIDMappings3() {
    // Arrange
    CMap cMap = new CMap();
    cMap.addCIDRange(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1);

    // Act and Assert
    assertTrue(cMap.hasCIDMappings());
  }

  /**
   * Method under test: {@link CMap#hasUnicodeMappings()}
   */
  @Test
  void testHasUnicodeMappings() {
    // Arrange, Act and Assert
    assertFalse((new CMap()).hasUnicodeMappings());
  }

  /**
   * Method under test: {@link CMap#toUnicode(int)}
   */
  @Test
  void testToUnicode() {
    // Arrange, Act and Assert
    assertNull((new CMap()).toUnicode(1));
    assertNull((new CMap()).toUnicode(256));
    assertNull((new CMap()).toUnicode(1, 3));
    assertNull((new CMap()).toUnicode(1, 1));
    assertNull((new CMap()).toUnicode(1, 2));
  }

  /**
   * Method under test: {@link CMap#toUnicode(byte[])}
   */
  @Test
  void testToUnicode2() throws UnsupportedEncodingException {
    // Arrange
    CMap cMap = new CMap();

    // Act and Assert
    assertNull(cMap.toUnicode("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link CMap#readCode(InputStream)}
   */
  @Test
  void testReadCode() throws IOException {
    // Arrange
    CMap cMap = new CMap();
    byte[] startBytes = "AXAXAXAX".getBytes("UTF-8");
    cMap.addCodespaceRange(new CodespaceRange(startBytes, "AXAXAXAX".getBytes("UTF-8")));
    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    int actualReadCodeResult = cMap.readCode(in);

    // Assert
    assertEquals(-1, in.read(new byte[]{}));
    assertEquals(1096302936, actualReadCodeResult);
  }

  /**
   * Method under test: {@link CMap#readCode(InputStream)}
   */
  @Test
  void testReadCode2() throws IOException {
    // Arrange
    CMap cMap = new CMap();
    byte[] startBytes = "AXAXAXAX".getBytes("UTF-8");
    cMap.addCodespaceRange(new CodespaceRange(startBytes, "AXAXAXAX".getBytes("UTF-8")));
    byte[] startBytes2 = "AXAXAXAX".getBytes("UTF-8");
    cMap.addCodespaceRange(new CodespaceRange(startBytes2, "AXAXAXAX".getBytes("UTF-8")));
    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    int actualReadCodeResult = cMap.readCode(in);

    // Assert
    assertEquals(-1, in.read(new byte[]{}));
    assertEquals(1096302936, actualReadCodeResult);
  }

  /**
   * Method under test: {@link CMap#readCode(InputStream)}
   */
  @Test
  void testReadCode3() throws IOException {
    // Arrange
    CMap cMap = new CMap();
    byte[] startBytes = "XXAXAXAX".getBytes("UTF-8");
    cMap.addCodespaceRange(new CodespaceRange(startBytes, "AXAXAXAX".getBytes("UTF-8")));
    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(1096302936, cMap.readCode(in));
    byte[] byteArray = new byte[4];
    assertEquals(4, in.read(byteArray));
    assertArrayEquals("AXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link CMap#readCode(InputStream)}
   */
  @Test
  void testReadCode4() throws IOException {
    // Arrange
    CMap cMap = new CMap();
    cMap.addCodespaceRange(
        new CodespaceRange("AXAXAXAX".getBytes("UTF-8"), new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(1096302936, cMap.readCode(in));
    byte[] byteArray = new byte[4];
    assertEquals(4, in.read(byteArray));
    assertArrayEquals("AXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link CMap#toInt(byte[])}
   */
  @Test
  void testToInt() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1096302936, CMap.toInt("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link CMap#toCID(int)}
   */
  @Test
  void testToCID() {
    // Arrange, Act and Assert
    assertEquals(0, (new CMap()).toCID(1));
    assertEquals(0, (new CMap()).toCID(3, 3));
  }

  /**
   * Method under test: {@link CMap#toCID(int)}
   */
  @Test
  void testToCID2() {
    // Arrange
    CMap cMap = new CMap();
    cMap.addCIDMapping(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1);

    // Act and Assert
    assertEquals(0, cMap.toCID(1));
  }

  /**
   * Method under test: {@link CMap#toCID(int)}
   */
  @Test
  void testToCID3() {
    // Arrange
    CMap cMap = new CMap();
    cMap.addCIDRange(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1);

    // Act and Assert
    assertEquals(0, cMap.toCID(1));
  }

  /**
   * Method under test: {@link CMap#toCID(int)}
   */
  @Test
  void testToCID4() {
    // Arrange
    CMap cMap = new CMap();
    cMap.addCIDRange(new byte[]{'A', 1, 'A', 1, -1, 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1);

    // Act and Assert
    assertEquals(16695041, cMap.toCID(1));
  }

  /**
   * Method under test: {@link CMap#toCID(int, int)}
   */
  @Test
  void testToCID5() {
    // Arrange
    CMap cMap = new CMap();
    cMap.addCIDMapping(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1);

    // Act and Assert
    assertEquals(0, cMap.toCID(3, 3));
  }

  /**
   * Method under test: {@link CMap#toCID(int, int)}
   */
  @Test
  void testToCID6() {
    // Arrange
    CMap cMap = new CMap();
    cMap.addCIDRange(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1);

    // Act and Assert
    assertEquals(0, cMap.toCID(3, 3));
  }

  /**
   * Method under test: {@link CMap#toCID(byte[])}
   */
  @Test
  void testToCID7() throws UnsupportedEncodingException {
    // Arrange
    CMap cMap = new CMap();

    // Act and Assert
    assertEquals(0, cMap.toCID("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link CMap#toCID(byte[])}
   */
  @Test
  void testToCID8() throws UnsupportedEncodingException {
    // Arrange
    CMap cMap = new CMap();
    cMap.addCIDMapping(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1);

    // Act and Assert
    assertEquals(0, cMap.toCID("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link CMap#toCID(byte[])}
   */
  @Test
  void testToCID9() throws UnsupportedEncodingException {
    // Arrange
    CMap cMap = new CMap();
    cMap.addCIDRange(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1);

    // Act and Assert
    assertEquals(0, cMap.toCID("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link CMap#toCID(byte[])}
   */
  @Test
  void testToCID10() throws UnsupportedEncodingException {
    // Arrange
    CMap cMap = new CMap();
    cMap.addCIDRange(new byte[]{'A', 1, 'A', 1, 'X', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1);

    // Act and Assert
    assertEquals(0, cMap.toCID("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link CMap#toCID(byte[])}
   */
  @Test
  void testToCID11() throws UnsupportedEncodingException {
    // Arrange
    CMap cMap = new CMap();
    cMap.addCIDRange(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'X', 1, 'A', 1}, 1);

    // Act and Assert
    assertEquals(5701720, cMap.toCID("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link CMap#addCharMapping(byte[], String)}
   */
  @Test
  void testAddCharMapping() throws UnsupportedEncodingException {
    // Arrange
    CMap cMap = new CMap();

    // Act
    cMap.addCharMapping("AXAXAXAX".getBytes("UTF-8"), "Unicode");

    // Assert
    assertEquals(-1, cMap.getSpaceMapping());
  }

  /**
   * Method under test: {@link CMap#addCharMapping(byte[], String)}
   */
  @Test
  void testAddCharMapping2() {
    // Arrange
    CMap cMap = new CMap();

    // Act
    cMap.addCharMapping(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, " ");

    // Assert
    assertEquals(1096302936, cMap.getSpaceMapping());
  }

  /**
   * Method under test: {@link CMap#getCodesFromUnicode(String)}
   */
  @Test
  void testGetCodesFromUnicode() {
    // Arrange, Act and Assert
    assertNull((new CMap()).getCodesFromUnicode("Unicode"));
  }

  /**
   * Method under test: {@link CMap#addCIDMapping(byte[], int)}
   */
  @Test
  void testAddCIDMapping() throws UnsupportedEncodingException {
    // Arrange
    CMap cMap = new CMap();

    // Act
    cMap.addCIDMapping("AXAXAXAX".getBytes("UTF-8"), 1);

    // Assert
    assertTrue(cMap.hasCIDMappings());
  }

  /**
   * Method under test: {@link CMap#addCIDMapping(byte[], int)}
   */
  @Test
  void testAddCIDMapping2() throws UnsupportedEncodingException {
    // Arrange
    CMap cMap = new CMap();
    cMap.addCIDMapping("A\bA\bA\bA\b".getBytes("UTF-8"), 1);

    // Act
    cMap.addCIDMapping("AXAXAXAX".getBytes("UTF-8"), 1);

    // Assert
    assertTrue(cMap.hasCIDMappings());
  }

  /**
   * Method under test: {@link CMap#addCIDRange(byte[], byte[], int)}
   */
  @Test
  void testAddCIDRange() throws UnsupportedEncodingException {
    // Arrange
    CMap cMap = new CMap();
    byte[] from = "AXAXAXAX".getBytes("UTF-8");

    // Act
    cMap.addCIDRange(from, "AXAXAXAX".getBytes("UTF-8"), 1);

    // Assert
    assertTrue(cMap.hasCIDMappings());
  }

  /**
   * Method under test: {@link CMap#addCIDRange(byte[], byte[], int)}
   */
  @Test
  void testAddCIDRange2() throws UnsupportedEncodingException {
    // Arrange
    CMap cMap = new CMap();
    byte[] from = "A\bA\bA\bA\b".getBytes("UTF-8");
    cMap.addCIDRange(from, "A\bA\bA\bA\b".getBytes("UTF-8"), 1);
    byte[] from2 = "AXAXAXAX".getBytes("UTF-8");

    // Act
    cMap.addCIDRange(from2, "AXAXAXAX".getBytes("UTF-8"), 1);

    // Assert
    assertTrue(cMap.hasCIDMappings());
  }

  /**
   * Method under test: {@link CMap#addCodespaceRange(CodespaceRange)}
   */
  @Test
  void testAddCodespaceRange() {
    // Arrange
    CMap cMap = new CMap();
    CodespaceRange range = mock(CodespaceRange.class);
    when(range.getCodeLength()).thenReturn(3);

    // Act
    cMap.addCodespaceRange(range);

    // Assert
    verify(range, atLeast(1)).getCodeLength();
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CMap}
   *   <li>{@link CMap#setName(String)}
   *   <li>{@link CMap#setOrdering(String)}
   *   <li>{@link CMap#setRegistry(String)}
   *   <li>{@link CMap#setSupplement(int)}
   *   <li>{@link CMap#setType(int)}
   *   <li>{@link CMap#setVersion(String)}
   *   <li>{@link CMap#setWMode(int)}
   *   <li>{@link CMap#getName()}
   *   <li>{@link CMap#getOrdering()}
   *   <li>{@link CMap#getRegistry()}
   *   <li>{@link CMap#getSpaceMapping()}
   *   <li>{@link CMap#getSupplement()}
   *   <li>{@link CMap#getType()}
   *   <li>{@link CMap#getVersion()}
   *   <li>{@link CMap#getWMode()}
   *   <li>{@link CMap#toString()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    CMap actualCMap = new CMap();
    actualCMap.setName("Name");
    actualCMap.setOrdering("New Ordering");
    actualCMap.setRegistry("New Registry");
    actualCMap.setSupplement(1);
    actualCMap.setType(1);
    actualCMap.setVersion("1.0.2");
    actualCMap.setWMode(1);
    String actualName = actualCMap.getName();
    String actualOrdering = actualCMap.getOrdering();
    String actualRegistry = actualCMap.getRegistry();
    int actualSpaceMapping = actualCMap.getSpaceMapping();
    int actualSupplement = actualCMap.getSupplement();
    int actualType = actualCMap.getType();
    String actualVersion = actualCMap.getVersion();
    int actualWMode = actualCMap.getWMode();

    // Assert that nothing has changed
    assertEquals("1.0.2", actualVersion);
    assertEquals("Name", actualName);
    assertEquals("Name", actualCMap.toString());
    assertEquals("New Ordering", actualOrdering);
    assertEquals("New Registry", actualRegistry);
    assertEquals(-1, actualSpaceMapping);
    assertEquals(1, actualSupplement);
    assertEquals(1, actualType);
    assertEquals(1, actualWMode);
  }
}
