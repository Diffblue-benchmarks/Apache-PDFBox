package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.AbstractMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ToUnicodeWriterDiffblueTest {
  /**
   * Method under test: {@link ToUnicodeWriter#add(int, String)}
   */
  @Test
  void testAdd() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new ToUnicodeWriter()).add(0, null));
    assertThrows(IllegalArgumentException.class, () -> (new ToUnicodeWriter()).add(0, ""));
    assertThrows(IllegalArgumentException.class, () -> (new ToUnicodeWriter()).add(-1, null));
    assertThrows(IllegalArgumentException.class, () -> (new ToUnicodeWriter()).add(65536, null));
  }

  /**
   * Method under test: {@link ToUnicodeWriter#writeTo(OutputStream)}
   */
  @Test
  void testWriteTo() throws IOException {
    // Arrange
    ToUnicodeWriter toUnicodeWriter = new ToUnicodeWriter();
    ByteArrayOutputStream out = new ByteArrayOutputStream(1);

    // Act
    toUnicodeWriter.writeTo(out);

    // Assert that nothing has changed
    byte[] toByteArrayResult = out.toByteArray();
    assertEquals(304, toByteArrayResult.length);
    assertEquals(' ', toByteArrayResult[17]);
    assertEquals(' ', toByteArrayResult[291]);
    assertEquals(' ', toByteArrayResult[8]);
    assertEquals('/', toByteArrayResult[0]);
    assertEquals('/', toByteArrayResult[9]);
    assertEquals('C', toByteArrayResult[1]);
    assertEquals('D', toByteArrayResult[3]);
    assertEquals('I', toByteArrayResult[2]);
    assertEquals('I', toByteArrayResult[4]);
    assertEquals('P', toByteArrayResult[PDPanoseClassification.LENGTH]);
    assertEquals('S', toByteArrayResult[14]);
    assertEquals('\n', toByteArrayResult[295]);
    assertEquals('\n', toByteArrayResult[299]);
    assertEquals('\n', toByteArrayResult[303]);
    assertEquals('c', toByteArrayResult[13]);
    assertEquals('c', toByteArrayResult[289]);
    assertEquals('d', toByteArrayResult[21]);
    assertEquals('d', toByteArrayResult[298]);
    assertEquals('d', toByteArrayResult[302]);
    assertEquals('e', toByteArrayResult[15]);
    assertEquals('e', toByteArrayResult[23]);
    assertEquals('e', toByteArrayResult[282]);
    assertEquals('e', toByteArrayResult[284]);
    assertEquals('e', toByteArrayResult[290]);
    assertEquals('e', toByteArrayResult[296]);
    assertEquals('e', toByteArrayResult[300]);
    assertEquals('f', toByteArrayResult[18]);
    assertEquals('f', toByteArrayResult[279]);
    assertEquals('i', toByteArrayResult[19]);
    assertEquals('i', toByteArrayResult[280]);
    assertEquals('i', toByteArrayResult[6]);
    assertEquals('n', toByteArrayResult[20]);
    assertEquals('n', toByteArrayResult[281]);
    assertEquals('n', toByteArrayResult[297]);
    assertEquals('n', toByteArrayResult[301]);
    assertEquals('n', toByteArrayResult[5]);
    assertEquals('o', toByteArrayResult[286]);
    assertEquals('o', toByteArrayResult[293]);
    assertEquals('o', toByteArrayResult[PDPanose.LENGTH]);
    assertEquals('p', toByteArrayResult[292]);
    assertEquals('p', toByteArrayResult[294]);
    assertEquals('r', toByteArrayResult[11]);
    assertEquals('r', toByteArrayResult[22]);
    assertEquals('r', toByteArrayResult[283]);
    assertEquals('r', toByteArrayResult[288]);
    assertEquals('s', toByteArrayResult[24]);
    assertEquals('s', toByteArrayResult[285]);
    assertEquals('t', toByteArrayResult[7]);
    assertEquals('t', toByteArrayResult[Short.SIZE]);
    assertEquals('u', toByteArrayResult[287]);
  }

  /**
   * Method under test: {@link ToUnicodeWriter#writeTo(OutputStream)}
   */
  @Test
  void testWriteTo2() throws IOException {
    // Arrange
    ToUnicodeWriter toUnicodeWriter = new ToUnicodeWriter();
    toUnicodeWriter.add(1, "/CIDInit /ProcSet findresource begin");
    ByteArrayOutputStream out = new ByteArrayOutputStream(1);

    // Act
    toUnicodeWriter.writeTo(out);

    // Assert
    byte[] toByteArrayResult = out.toByteArray();
    assertEquals(492, toByteArrayResult.length);
    assertEquals(' ', toByteArrayResult[17]);
    assertEquals(' ', toByteArrayResult[479]);
    assertEquals(' ', toByteArrayResult[8]);
    assertEquals('/', toByteArrayResult[0]);
    assertEquals('/', toByteArrayResult[9]);
    assertEquals('C', toByteArrayResult[1]);
    assertEquals('D', toByteArrayResult[3]);
    assertEquals('I', toByteArrayResult[2]);
    assertEquals('I', toByteArrayResult[4]);
    assertEquals('P', toByteArrayResult[PDPanoseClassification.LENGTH]);
    assertEquals('S', toByteArrayResult[14]);
    assertEquals('\n', toByteArrayResult[483]);
    assertEquals('\n', toByteArrayResult[487]);
    assertEquals('\n', toByteArrayResult[491]);
    assertEquals('c', toByteArrayResult[13]);
    assertEquals('c', toByteArrayResult[477]);
    assertEquals('d', toByteArrayResult[21]);
    assertEquals('d', toByteArrayResult[486]);
    assertEquals('d', toByteArrayResult[490]);
    assertEquals('e', toByteArrayResult[15]);
    assertEquals('e', toByteArrayResult[23]);
    assertEquals('e', toByteArrayResult[470]);
    assertEquals('e', toByteArrayResult[472]);
    assertEquals('e', toByteArrayResult[478]);
    assertEquals('e', toByteArrayResult[484]);
    assertEquals('e', toByteArrayResult[488]);
    assertEquals('f', toByteArrayResult[18]);
    assertEquals('f', toByteArrayResult[467]);
    assertEquals('i', toByteArrayResult[19]);
    assertEquals('i', toByteArrayResult[468]);
    assertEquals('i', toByteArrayResult[6]);
    assertEquals('n', toByteArrayResult[20]);
    assertEquals('n', toByteArrayResult[469]);
    assertEquals('n', toByteArrayResult[485]);
    assertEquals('n', toByteArrayResult[489]);
    assertEquals('n', toByteArrayResult[5]);
    assertEquals('o', toByteArrayResult[474]);
    assertEquals('o', toByteArrayResult[481]);
    assertEquals('o', toByteArrayResult[PDPanose.LENGTH]);
    assertEquals('p', toByteArrayResult[480]);
    assertEquals('p', toByteArrayResult[482]);
    assertEquals('r', toByteArrayResult[11]);
    assertEquals('r', toByteArrayResult[22]);
    assertEquals('r', toByteArrayResult[471]);
    assertEquals('r', toByteArrayResult[476]);
    assertEquals('s', toByteArrayResult[24]);
    assertEquals('s', toByteArrayResult[473]);
    assertEquals('t', toByteArrayResult[7]);
    assertEquals('t', toByteArrayResult[Short.SIZE]);
    assertEquals('u', toByteArrayResult[475]);
  }

  /**
   * Method under test: {@link ToUnicodeWriter#writeTo(OutputStream)}
   */
  @Test
  void testWriteTo3() throws IOException {
    // Arrange
    ToUnicodeWriter toUnicodeWriter = new ToUnicodeWriter();
    toUnicodeWriter.add(2, "9,9 ");
    toUnicodeWriter.add(1, "/CIDInit /ProcSet findresource begin");
    ByteArrayOutputStream out = new ByteArrayOutputStream(1);

    // Act
    toUnicodeWriter.writeTo(out);

    // Assert
    byte[] toByteArrayResult = out.toByteArray();
    assertEquals(525, toByteArrayResult.length);
    assertEquals(' ', toByteArrayResult[17]);
    assertEquals(' ', toByteArrayResult[512]);
    assertEquals(' ', toByteArrayResult[8]);
    assertEquals('/', toByteArrayResult[0]);
    assertEquals('/', toByteArrayResult[9]);
    assertEquals('C', toByteArrayResult[1]);
    assertEquals('D', toByteArrayResult[3]);
    assertEquals('I', toByteArrayResult[2]);
    assertEquals('I', toByteArrayResult[4]);
    assertEquals('P', toByteArrayResult[PDPanoseClassification.LENGTH]);
    assertEquals('S', toByteArrayResult[14]);
    assertEquals('\n', toByteArrayResult[516]);
    assertEquals('\n', toByteArrayResult[520]);
    assertEquals('\n', toByteArrayResult[524]);
    assertEquals('c', toByteArrayResult[13]);
    assertEquals('c', toByteArrayResult[510]);
    assertEquals('d', toByteArrayResult[21]);
    assertEquals('d', toByteArrayResult[519]);
    assertEquals('d', toByteArrayResult[523]);
    assertEquals('e', toByteArrayResult[15]);
    assertEquals('e', toByteArrayResult[23]);
    assertEquals('e', toByteArrayResult[503]);
    assertEquals('e', toByteArrayResult[505]);
    assertEquals('e', toByteArrayResult[511]);
    assertEquals('e', toByteArrayResult[517]);
    assertEquals('e', toByteArrayResult[521]);
    assertEquals('f', toByteArrayResult[18]);
    assertEquals('f', toByteArrayResult[500]);
    assertEquals('i', toByteArrayResult[19]);
    assertEquals('i', toByteArrayResult[501]);
    assertEquals('i', toByteArrayResult[6]);
    assertEquals('n', toByteArrayResult[20]);
    assertEquals('n', toByteArrayResult[5]);
    assertEquals('n', toByteArrayResult[502]);
    assertEquals('n', toByteArrayResult[518]);
    assertEquals('n', toByteArrayResult[522]);
    assertEquals('o', toByteArrayResult[507]);
    assertEquals('o', toByteArrayResult[514]);
    assertEquals('o', toByteArrayResult[PDPanose.LENGTH]);
    assertEquals('p', toByteArrayResult[513]);
    assertEquals('p', toByteArrayResult[515]);
    assertEquals('r', toByteArrayResult[11]);
    assertEquals('r', toByteArrayResult[22]);
    assertEquals('r', toByteArrayResult[504]);
    assertEquals('r', toByteArrayResult[509]);
    assertEquals('s', toByteArrayResult[24]);
    assertEquals('s', toByteArrayResult[506]);
    assertEquals('t', toByteArrayResult[7]);
    assertEquals('t', toByteArrayResult[Short.SIZE]);
    assertEquals('u', toByteArrayResult[508]);
  }

  /**
   * Method under test: {@link ToUnicodeWriter#writeTo(OutputStream)}
   */
  @Test
  void testWriteTo4() throws IOException {
    // Arrange
    ToUnicodeWriter toUnicodeWriter = new ToUnicodeWriter();
    toUnicodeWriter.setWMode(PDPanoseClassification.LENGTH);
    toUnicodeWriter.add(1, "/CIDInit /ProcSet findresource begin");
    ByteArrayOutputStream out = new ByteArrayOutputStream(1);

    // Act
    toUnicodeWriter.writeTo(out);

    // Assert
    byte[] toByteArrayResult = out.toByteArray();
    assertEquals(507, toByteArrayResult.length);
    assertEquals(' ', toByteArrayResult[17]);
    assertEquals(' ', toByteArrayResult[494]);
    assertEquals(' ', toByteArrayResult[8]);
    assertEquals('/', toByteArrayResult[0]);
    assertEquals('/', toByteArrayResult[9]);
    assertEquals('C', toByteArrayResult[1]);
    assertEquals('D', toByteArrayResult[3]);
    assertEquals('I', toByteArrayResult[2]);
    assertEquals('I', toByteArrayResult[4]);
    assertEquals('P', toByteArrayResult[PDPanoseClassification.LENGTH]);
    assertEquals('S', toByteArrayResult[14]);
    assertEquals('\n', toByteArrayResult[498]);
    assertEquals('\n', toByteArrayResult[502]);
    assertEquals('\n', toByteArrayResult[506]);
    assertEquals('c', toByteArrayResult[13]);
    assertEquals('c', toByteArrayResult[492]);
    assertEquals('d', toByteArrayResult[21]);
    assertEquals('d', toByteArrayResult[501]);
    assertEquals('d', toByteArrayResult[505]);
    assertEquals('e', toByteArrayResult[15]);
    assertEquals('e', toByteArrayResult[23]);
    assertEquals('e', toByteArrayResult[485]);
    assertEquals('e', toByteArrayResult[487]);
    assertEquals('e', toByteArrayResult[493]);
    assertEquals('e', toByteArrayResult[499]);
    assertEquals('e', toByteArrayResult[503]);
    assertEquals('f', toByteArrayResult[18]);
    assertEquals('f', toByteArrayResult[482]);
    assertEquals('i', toByteArrayResult[19]);
    assertEquals('i', toByteArrayResult[483]);
    assertEquals('i', toByteArrayResult[6]);
    assertEquals('n', toByteArrayResult[20]);
    assertEquals('n', toByteArrayResult[484]);
    assertEquals('n', toByteArrayResult[5]);
    assertEquals('n', toByteArrayResult[500]);
    assertEquals('n', toByteArrayResult[504]);
    assertEquals('o', toByteArrayResult[489]);
    assertEquals('o', toByteArrayResult[496]);
    assertEquals('o', toByteArrayResult[PDPanose.LENGTH]);
    assertEquals('p', toByteArrayResult[495]);
    assertEquals('p', toByteArrayResult[497]);
    assertEquals('r', toByteArrayResult[11]);
    assertEquals('r', toByteArrayResult[22]);
    assertEquals('r', toByteArrayResult[486]);
    assertEquals('r', toByteArrayResult[491]);
    assertEquals('s', toByteArrayResult[24]);
    assertEquals('s', toByteArrayResult[488]);
    assertEquals('t', toByteArrayResult[7]);
    assertEquals('t', toByteArrayResult[Short.SIZE]);
    assertEquals('u', toByteArrayResult[490]);
  }

  /**
   * Method under test: {@link ToUnicodeWriter#writeTo(OutputStream)}
   */
  @Test
  void testWriteTo5() throws IOException {
    // Arrange
    ToUnicodeWriter toUnicodeWriter = new ToUnicodeWriter();
    toUnicodeWriter.add(3, "9,9 ");
    toUnicodeWriter.add(1, "/CIDInit /ProcSet findresource begin");
    ByteArrayOutputStream out = new ByteArrayOutputStream(1);

    // Act
    toUnicodeWriter.writeTo(out);

    // Assert
    byte[] toByteArrayResult = out.toByteArray();
    assertEquals(525, toByteArrayResult.length);
    assertEquals(' ', toByteArrayResult[17]);
    assertEquals(' ', toByteArrayResult[512]);
    assertEquals(' ', toByteArrayResult[8]);
    assertEquals('/', toByteArrayResult[0]);
    assertEquals('/', toByteArrayResult[9]);
    assertEquals('C', toByteArrayResult[1]);
    assertEquals('D', toByteArrayResult[3]);
    assertEquals('I', toByteArrayResult[2]);
    assertEquals('I', toByteArrayResult[4]);
    assertEquals('P', toByteArrayResult[PDPanoseClassification.LENGTH]);
    assertEquals('S', toByteArrayResult[14]);
    assertEquals('\n', toByteArrayResult[516]);
    assertEquals('\n', toByteArrayResult[520]);
    assertEquals('\n', toByteArrayResult[524]);
    assertEquals('c', toByteArrayResult[13]);
    assertEquals('c', toByteArrayResult[510]);
    assertEquals('d', toByteArrayResult[21]);
    assertEquals('d', toByteArrayResult[519]);
    assertEquals('d', toByteArrayResult[523]);
    assertEquals('e', toByteArrayResult[15]);
    assertEquals('e', toByteArrayResult[23]);
    assertEquals('e', toByteArrayResult[503]);
    assertEquals('e', toByteArrayResult[505]);
    assertEquals('e', toByteArrayResult[511]);
    assertEquals('e', toByteArrayResult[517]);
    assertEquals('e', toByteArrayResult[521]);
    assertEquals('f', toByteArrayResult[18]);
    assertEquals('f', toByteArrayResult[500]);
    assertEquals('i', toByteArrayResult[19]);
    assertEquals('i', toByteArrayResult[501]);
    assertEquals('i', toByteArrayResult[6]);
    assertEquals('n', toByteArrayResult[20]);
    assertEquals('n', toByteArrayResult[5]);
    assertEquals('n', toByteArrayResult[502]);
    assertEquals('n', toByteArrayResult[518]);
    assertEquals('n', toByteArrayResult[522]);
    assertEquals('o', toByteArrayResult[507]);
    assertEquals('o', toByteArrayResult[514]);
    assertEquals('o', toByteArrayResult[PDPanose.LENGTH]);
    assertEquals('p', toByteArrayResult[513]);
    assertEquals('p', toByteArrayResult[515]);
    assertEquals('r', toByteArrayResult[11]);
    assertEquals('r', toByteArrayResult[22]);
    assertEquals('r', toByteArrayResult[504]);
    assertEquals('r', toByteArrayResult[509]);
    assertEquals('s', toByteArrayResult[24]);
    assertEquals('s', toByteArrayResult[506]);
    assertEquals('t', toByteArrayResult[7]);
    assertEquals('t', toByteArrayResult[Short.SIZE]);
    assertEquals('u', toByteArrayResult[508]);
  }

  /**
   * Method under test:
   * {@link ToUnicodeWriter#allowCIDToUnicodeRange(Map.Entry, Map.Entry)}
   */
  @Test
  void testAllowCIDToUnicodeRange() {
    // Arrange
    AbstractMap.SimpleEntry<Integer, String> prev = new AbstractMap.SimpleEntry<>(1, "foo");

    // Act and Assert
    assertFalse(ToUnicodeWriter.allowCIDToUnicodeRange(prev, new AbstractMap.SimpleEntry<>(1, "foo")));
  }

  /**
   * Method under test:
   * {@link ToUnicodeWriter#allowCIDToUnicodeRange(Map.Entry, Map.Entry)}
   */
  @Test
  void testAllowCIDToUnicodeRange2() {
    // Arrange, Act and Assert
    assertFalse(ToUnicodeWriter.allowCIDToUnicodeRange(null, null));
  }

  /**
   * Method under test:
   * {@link ToUnicodeWriter#allowCIDToUnicodeRange(Map.Entry, Map.Entry)}
   */
  @Test
  void testAllowCIDToUnicodeRange3() {
    // Arrange, Act and Assert
    assertFalse(ToUnicodeWriter.allowCIDToUnicodeRange(new AbstractMap.SimpleEntry<>(1, "foo"), null));
  }

  /**
   * Method under test:
   * {@link ToUnicodeWriter#allowCIDToUnicodeRange(Map.Entry, Map.Entry)}
   */
  @Test
  void testAllowCIDToUnicodeRange4() {
    // Arrange
    AbstractMap.SimpleEntry<Integer, String> prev = new AbstractMap.SimpleEntry<>(0, "foo");

    // Act and Assert
    assertFalse(ToUnicodeWriter.allowCIDToUnicodeRange(prev, new AbstractMap.SimpleEntry<>(1, "foo")));
  }

  /**
   * Method under test:
   * {@link ToUnicodeWriter#allowCIDToUnicodeRange(Map.Entry, Map.Entry)}
   */
  @Test
  void testAllowCIDToUnicodeRange5() {
    // Arrange
    AbstractMap.SimpleEntry<Integer, String> prev = new AbstractMap.SimpleEntry<>(0, "");

    // Act and Assert
    assertFalse(ToUnicodeWriter.allowCIDToUnicodeRange(prev, new AbstractMap.SimpleEntry<>(1, "foo")));
  }

  /**
   * Method under test:
   * {@link ToUnicodeWriter#allowCIDToUnicodeRange(Map.Entry, Map.Entry)}
   */
  @Test
  void testAllowCIDToUnicodeRange6() {
    // Arrange
    AbstractMap.SimpleEntry<Integer, String> prev = new AbstractMap.SimpleEntry<>(0, "foo");

    // Act and Assert
    assertFalse(ToUnicodeWriter.allowCIDToUnicodeRange(prev, new AbstractMap.SimpleEntry<>(1, "")));
  }

  /**
   * Method under test:
   * {@link ToUnicodeWriter#allowCIDToUnicodeRange(Map.Entry, Map.Entry)}
   */
  @Test
  void testAllowCIDToUnicodeRange7() {
    // Arrange
    AbstractMap.SimpleEntry<Integer, String> prev = new AbstractMap.SimpleEntry<>(-1, "foo");

    // Act and Assert
    assertFalse(ToUnicodeWriter.allowCIDToUnicodeRange(prev, new AbstractMap.SimpleEntry<>(0, "foo")));
  }

  /**
   * Method under test: {@link ToUnicodeWriter#allowCodeRange(int, int)}
   */
  @Test
  void testAllowCodeRange() {
    // Arrange, Act and Assert
    assertFalse(ToUnicodeWriter.allowCodeRange(1, 1));
    assertTrue(ToUnicodeWriter.allowCodeRange(0, 1));
    assertFalse(ToUnicodeWriter.allowCodeRange(-1, 0));
  }

  /**
   * Method under test:
   * {@link ToUnicodeWriter#allowDestinationRange(String, String)}
   */
  @Test
  void testAllowDestinationRange() {
    // Arrange, Act and Assert
    assertFalse(ToUnicodeWriter.allowDestinationRange("Prev", "Next"));
    assertFalse(ToUnicodeWriter.allowDestinationRange("", ""));
    assertFalse(ToUnicodeWriter.allowDestinationRange("Prev", ""));
  }
}
