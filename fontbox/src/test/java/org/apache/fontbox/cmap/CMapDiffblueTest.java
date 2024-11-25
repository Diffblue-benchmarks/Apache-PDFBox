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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CMapDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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

  /**
   * Test {@link CMap#hasCIDMappings()}.
   * <p>
   * Method under test: {@link CMap#hasCIDMappings()}
   */
  @Test
  @DisplayName("Test hasCIDMappings()")
  void testHasCIDMappings() {
    // Arrange
    CMap cMap = new CMap();
    cMap.addCIDRange(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1);

    // Act and Assert
    assertTrue(cMap.hasCIDMappings());
  }

  /**
   * Test {@link CMap#hasCIDMappings()}.
   * <ul>
   *   <li>Given {@link CMap#CMap()} addCIDMapping array of {@code byte} with
   * {@code A} and one and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMap#hasCIDMappings()}
   */
  @Test
  @DisplayName("Test hasCIDMappings(); given CMap() addCIDMapping array of byte with 'A' and one and one")
  void testHasCIDMappings_givenCMapAddCIDMappingArrayOfByteWithAAndOneAndOne() {
    // Arrange
    CMap cMap = new CMap();
    cMap.addCIDMapping(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1);

    // Act and Assert
    assertTrue(cMap.hasCIDMappings());
  }

  /**
   * Test {@link CMap#hasCIDMappings()}.
   * <ul>
   *   <li>Given {@link CMap#CMap()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMap#hasCIDMappings()}
   */
  @Test
  @DisplayName("Test hasCIDMappings(); given CMap(); then return 'false'")
  void testHasCIDMappings_givenCMap_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new CMap()).hasCIDMappings());
  }

  /**
   * Test {@link CMap#hasUnicodeMappings()}.
   * <p>
   * Method under test: {@link CMap#hasUnicodeMappings()}
   */
  @Test
  @DisplayName("Test hasUnicodeMappings()")
  void testHasUnicodeMappings() {
    // Arrange, Act and Assert
    assertFalse((new CMap()).hasUnicodeMappings());
  }

  /**
   * Test {@link CMap#toUnicode(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link CMap#toUnicode(byte[])}
   */
  @Test
  @DisplayName("Test toUnicode(byte[]) with 'byte[]'")
  void testToUnicodeWithByte() throws UnsupportedEncodingException {
    // Arrange
    CMap cMap = new CMap();

    // Act and Assert
    assertNull(cMap.toUnicode("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link CMap#toUnicode(int, int)} with {@code int}, {@code int}.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMap#toUnicode(int, int)}
   */
  @Test
  @DisplayName("Test toUnicode(int, int) with 'int', 'int'; when one")
  void testToUnicodeWithIntInt_whenOne() {
    // Arrange, Act and Assert
    assertNull((new CMap()).toUnicode(1, 1));
  }

  /**
   * Test {@link CMap#toUnicode(int, int)} with {@code int}, {@code int}.
   * <ul>
   *   <li>When three.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMap#toUnicode(int, int)}
   */
  @Test
  @DisplayName("Test toUnicode(int, int) with 'int', 'int'; when three")
  void testToUnicodeWithIntInt_whenThree() {
    // Arrange, Act and Assert
    assertNull((new CMap()).toUnicode(1, 3));
  }

  /**
   * Test {@link CMap#toUnicode(int, int)} with {@code int}, {@code int}.
   * <ul>
   *   <li>When two.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMap#toUnicode(int, int)}
   */
  @Test
  @DisplayName("Test toUnicode(int, int) with 'int', 'int'; when two")
  void testToUnicodeWithIntInt_whenTwo() {
    // Arrange, Act and Assert
    assertNull((new CMap()).toUnicode(1, 2));
  }

  /**
   * Test {@link CMap#toUnicode(int)} with {@code int}.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMap#toUnicode(int)}
   */
  @Test
  @DisplayName("Test toUnicode(int) with 'int'; when one")
  void testToUnicodeWithInt_whenOne() {
    // Arrange, Act and Assert
    assertNull((new CMap()).toUnicode(1));
  }

  /**
   * Test {@link CMap#toUnicode(int)} with {@code int}.
   * <ul>
   *   <li>When two hundred fifty-six.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMap#toUnicode(int)}
   */
  @Test
  @DisplayName("Test toUnicode(int) with 'int'; when two hundred fifty-six")
  void testToUnicodeWithInt_whenTwoHundredFiftySix() {
    // Arrange, Act and Assert
    assertNull((new CMap()).toUnicode(256));
  }

  /**
   * Test {@link CMap#readCode(InputStream)}.
   * <p>
   * Method under test: {@link CMap#readCode(InputStream)}
   */
  @Test
  @DisplayName("Test readCode(InputStream)")
  void testReadCode() throws IOException {
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
   * Test {@link CMap#readCode(InputStream)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8} read is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMap#readCode(InputStream)}
   */
  @Test
  @DisplayName("Test readCode(InputStream); given 'A'; then ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8' read is four")
  void testReadCode_givenA_thenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8ReadIsFour() throws IOException {
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
   * Test {@link CMap#readCode(InputStream)}.
   * <ul>
   *   <li>Then {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8} read is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMap#readCode(InputStream)}
   */
  @Test
  @DisplayName("Test readCode(InputStream); then ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8' read is minus one")
  void testReadCode_thenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8ReadIsMinusOne() throws IOException {
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
   * Test {@link CMap#readCode(InputStream)}.
   * <ul>
   *   <li>Then {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8} read is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMap#readCode(InputStream)}
   */
  @Test
  @DisplayName("Test readCode(InputStream); then ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8' read is minus one")
  void testReadCode_thenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8ReadIsMinusOne2() throws IOException {
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
   * Test {@link CMap#toInt(byte[])} with {@code data}.
   * <p>
   * Method under test: {@link CMap#toInt(byte[])}
   */
  @Test
  @DisplayName("Test toInt(byte[]) with 'data'")
  void testToIntWithData() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1096302936, CMap.toInt("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link CMap#toCID(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link CMap#toCID(byte[])}
   */
  @Test
  @DisplayName("Test toCID(byte[]) with 'byte[]'")
  void testToCIDWithByte() throws UnsupportedEncodingException {
    // Arrange
    CMap cMap = new CMap();
    cMap.addCIDRange(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1);

    // Act and Assert
    assertEquals(0, cMap.toCID("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link CMap#toCID(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Given {@link CMap#CMap()} addCIDMapping array of {@code byte} with
   * {@code A} and one and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMap#toCID(byte[])}
   */
  @Test
  @DisplayName("Test toCID(byte[]) with 'byte[]'; given CMap() addCIDMapping array of byte with 'A' and one and one")
  void testToCIDWithByte_givenCMapAddCIDMappingArrayOfByteWithAAndOneAndOne() throws UnsupportedEncodingException {
    // Arrange
    CMap cMap = new CMap();
    cMap.addCIDMapping(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1);

    // Act and Assert
    assertEquals(0, cMap.toCID("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link CMap#toCID(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Given {@link CMap#CMap()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMap#toCID(byte[])}
   */
  @Test
  @DisplayName("Test toCID(byte[]) with 'byte[]'; given CMap(); then return zero")
  void testToCIDWithByte_givenCMap_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    CMap cMap = new CMap();

    // Act and Assert
    assertEquals(0, cMap.toCID("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link CMap#toCID(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Given {@code X}.</li>
   *   <li>Then return {@code 5701720}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMap#toCID(byte[])}
   */
  @Test
  @DisplayName("Test toCID(byte[]) with 'byte[]'; given 'X'; then return '5701720'")
  void testToCIDWithByte_givenX_thenReturn5701720() throws UnsupportedEncodingException {
    // Arrange
    CMap cMap = new CMap();
    cMap.addCIDRange(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'X', 1, 'A', 1}, 1);

    // Act and Assert
    assertEquals(5701720, cMap.toCID("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link CMap#toCID(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Given {@code X}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMap#toCID(byte[])}
   */
  @Test
  @DisplayName("Test toCID(byte[]) with 'byte[]'; given 'X'; then return zero")
  void testToCIDWithByte_givenX_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    CMap cMap = new CMap();
    cMap.addCIDRange(new byte[]{'A', 1, 'A', 1, 'X', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1);

    // Act and Assert
    assertEquals(0, cMap.toCID("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link CMap#toCID(int)} with {@code int}.
   * <p>
   * Method under test: {@link CMap#toCID(int)}
   */
  @Test
  @DisplayName("Test toCID(int) with 'int'")
  void testToCIDWithInt() {
    // Arrange
    CMap cMap = new CMap();
    cMap.addCIDRange(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1);

    // Act and Assert
    assertEquals(0, cMap.toCID(1));
  }

  /**
   * Test {@link CMap#toCID(int, int)} with {@code int}, {@code int}.
   * <p>
   * Method under test: {@link CMap#toCID(int, int)}
   */
  @Test
  @DisplayName("Test toCID(int, int) with 'int', 'int'")
  void testToCIDWithIntInt() {
    // Arrange
    CMap cMap = new CMap();
    cMap.addCIDRange(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1);

    // Act and Assert
    assertEquals(0, cMap.toCID(3, 3));
  }

  /**
   * Test {@link CMap#toCID(int, int)} with {@code int}, {@code int}.
   * <ul>
   *   <li>Given {@link CMap#CMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMap#toCID(int, int)}
   */
  @Test
  @DisplayName("Test toCID(int, int) with 'int', 'int'; given CMap()")
  void testToCIDWithIntInt_givenCMap() {
    // Arrange, Act and Assert
    assertEquals(0, (new CMap()).toCID(3, 3));
  }

  /**
   * Test {@link CMap#toCID(int, int)} with {@code int}, {@code int}.
   * <ul>
   *   <li>Given {@link CMap#CMap()} addCIDMapping array of {@code byte} with
   * {@code A} and one and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMap#toCID(int, int)}
   */
  @Test
  @DisplayName("Test toCID(int, int) with 'int', 'int'; given CMap() addCIDMapping array of byte with 'A' and one and one")
  void testToCIDWithIntInt_givenCMapAddCIDMappingArrayOfByteWithAAndOneAndOne() {
    // Arrange
    CMap cMap = new CMap();
    cMap.addCIDMapping(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1);

    // Act and Assert
    assertEquals(0, cMap.toCID(3, 3));
  }

  /**
   * Test {@link CMap#toCID(int)} with {@code int}.
   * <ul>
   *   <li>Given {@link CMap#CMap()} addCIDMapping array of {@code byte} with
   * {@code A} and one and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMap#toCID(int)}
   */
  @Test
  @DisplayName("Test toCID(int) with 'int'; given CMap() addCIDMapping array of byte with 'A' and one and one")
  void testToCIDWithInt_givenCMapAddCIDMappingArrayOfByteWithAAndOneAndOne() {
    // Arrange
    CMap cMap = new CMap();
    cMap.addCIDMapping(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1);

    // Act and Assert
    assertEquals(0, cMap.toCID(1));
  }

  /**
   * Test {@link CMap#toCID(int)} with {@code int}.
   * <ul>
   *   <li>Given {@link CMap#CMap()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMap#toCID(int)}
   */
  @Test
  @DisplayName("Test toCID(int) with 'int'; given CMap(); then return zero")
  void testToCIDWithInt_givenCMap_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new CMap()).toCID(1));
  }

  /**
   * Test {@link CMap#toCID(int)} with {@code int}.
   * <ul>
   *   <li>Then return {@code 16695041}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMap#toCID(int)}
   */
  @Test
  @DisplayName("Test toCID(int) with 'int'; then return '16695041'")
  void testToCIDWithInt_thenReturn16695041() {
    // Arrange
    CMap cMap = new CMap();
    cMap.addCIDRange(new byte[]{'A', 1, 'A', 1, -1, 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1);

    // Act and Assert
    assertEquals(16695041, cMap.toCID(1));
  }

  /**
   * Test {@link CMap#addCharMapping(byte[], String)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then {@link CMap#CMap()} SpaceMapping is {@code 1096302936}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMap#addCharMapping(byte[], String)}
   */
  @Test
  @DisplayName("Test addCharMapping(byte[], String); when 'A'; then CMap() SpaceMapping is '1096302936'")
  void testAddCharMapping_whenA_thenCMapSpaceMappingIs1096302936() {
    // Arrange
    CMap cMap = new CMap();

    // Act
    cMap.addCharMapping(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, " ");

    // Assert
    assertEquals(1096302936, cMap.getSpaceMapping());
  }

  /**
   * Test {@link CMap#addCharMapping(byte[], String)}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then {@link CMap#CMap()} SpaceMapping is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMap#addCharMapping(byte[], String)}
   */
  @Test
  @DisplayName("Test addCharMapping(byte[], String); when 'AXAXAXAX' Bytes is 'UTF-8'; then CMap() SpaceMapping is minus one")
  void testAddCharMapping_whenAxaxaxaxBytesIsUtf8_thenCMapSpaceMappingIsMinusOne() throws UnsupportedEncodingException {
    // Arrange
    CMap cMap = new CMap();

    // Act
    cMap.addCharMapping("AXAXAXAX".getBytes("UTF-8"), "Unicode");

    // Assert
    assertEquals(-1, cMap.getSpaceMapping());
  }

  /**
   * Test {@link CMap#getCodesFromUnicode(String)}.
   * <p>
   * Method under test: {@link CMap#getCodesFromUnicode(String)}
   */
  @Test
  @DisplayName("Test getCodesFromUnicode(String)")
  void testGetCodesFromUnicode() {
    // Arrange, Act and Assert
    assertNull((new CMap()).getCodesFromUnicode("Unicode"));
  }

  /**
   * Test {@link CMap#addCIDMapping(byte[], int)}.
   * <p>
   * Method under test: {@link CMap#addCIDMapping(byte[], int)}
   */
  @Test
  @DisplayName("Test addCIDMapping(byte[], int)")
  void testAddCIDMapping() throws UnsupportedEncodingException {
    // Arrange
    CMap cMap = new CMap();
    cMap.addCIDMapping("A\bA\bA\bA\b".getBytes("UTF-8"), 1);

    // Act
    cMap.addCIDMapping("AXAXAXAX".getBytes("UTF-8"), 1);

    // Assert
    assertTrue(cMap.hasCIDMappings());
  }

  /**
   * Test {@link CMap#addCIDMapping(byte[], int)}.
   * <ul>
   *   <li>Given {@link CMap#CMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMap#addCIDMapping(byte[], int)}
   */
  @Test
  @DisplayName("Test addCIDMapping(byte[], int); given CMap()")
  void testAddCIDMapping_givenCMap() throws UnsupportedEncodingException {
    // Arrange
    CMap cMap = new CMap();

    // Act
    cMap.addCIDMapping("AXAXAXAX".getBytes("UTF-8"), 1);

    // Assert
    assertTrue(cMap.hasCIDMappings());
  }

  /**
   * Test {@link CMap#addCIDRange(byte[], byte[], int)} with {@code from},
   * {@code to}, {@code cid}.
   * <p>
   * Method under test: {@link CMap#addCIDRange(byte[], byte[], int)}
   */
  @Test
  @DisplayName("Test addCIDRange(byte[], byte[], int) with 'from', 'to', 'cid'")
  void testAddCIDRangeWithFromToCid() throws UnsupportedEncodingException {
    // Arrange
    CMap cMap = new CMap();
    byte[] from = "AXAXAXAX".getBytes("UTF-8");

    // Act
    cMap.addCIDRange(from, "AXAXAXAX".getBytes("UTF-8"), 1);

    // Assert
    assertTrue(cMap.hasCIDMappings());
  }

  /**
   * Test {@link CMap#addCIDRange(byte[], byte[], int)} with {@code from},
   * {@code to}, {@code cid}.
   * <p>
   * Method under test: {@link CMap#addCIDRange(byte[], byte[], int)}
   */
  @Test
  @DisplayName("Test addCIDRange(byte[], byte[], int) with 'from', 'to', 'cid'")
  void testAddCIDRangeWithFromToCid2() throws UnsupportedEncodingException {
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
   * Test {@link CMap#addCodespaceRange(CodespaceRange)}.
   * <ul>
   *   <li>Given three.</li>
   *   <li>Then calls {@link CodespaceRange#getCodeLength()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMap#addCodespaceRange(CodespaceRange)}
   */
  @Test
  @DisplayName("Test addCodespaceRange(CodespaceRange); given three; then calls getCodeLength()")
  void testAddCodespaceRange_givenThree_thenCallsGetCodeLength() {
    // Arrange
    CMap cMap = new CMap();
    CodespaceRange range = mock(CodespaceRange.class);
    when(range.getCodeLength()).thenReturn(3);

    // Act
    cMap.addCodespaceRange(range);

    // Assert
    verify(range, atLeast(1)).getCodeLength();
  }
}
