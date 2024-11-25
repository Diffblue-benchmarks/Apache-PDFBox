package org.apache.pdfbox.debugger.treestatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import javax.swing.tree.TreePath;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.debugger.ui.ArrayEntry;
import org.apache.pdfbox.debugger.ui.MapEntry;
import org.apache.pdfbox.debugger.ui.PageEntry;
import org.apache.pdfbox.debugger.ui.XrefEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TreeStatusDiffblueTest {
  /**
   * Test {@link TreeStatus#getStringForPath(TreePath)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link ArrayEntry} (default constructor) Index is one.</li>
   *   <li>Then return {@code [1]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TreeStatus#getStringForPath(TreePath)}
   */
  @Test
  @DisplayName("Test getStringForPath(TreePath); given one; when ArrayEntry (default constructor) Index is one; then return '[1]'")
  void testGetStringForPath_givenOne_whenArrayEntryIndexIsOne_thenReturn1() {
    // Arrange
    TreeStatus treeStatus = new TreeStatus("Root Node");

    ArrayEntry arrayEntry = new ArrayEntry();
    arrayEntry.setIndex(1);
    arrayEntry.setItem(new COSArray());
    arrayEntry.setValue(new COSArray());

    // Act and Assert
    assertEquals("[1]", treeStatus.getStringForPath(new TreePath(new Object[]{"42", arrayEntry})));
  }

  /**
   * Test {@link TreeStatus#getStringForPath(TreePath)}.
   * <ul>
   *   <li>Then return {@code CRT/Offset: 1 [1 1 R]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TreeStatus#getStringForPath(TreePath)}
   */
  @Test
  @DisplayName("Test getStringForPath(TreePath); then return 'CRT/Offset: 1 [1 1 R]'")
  void testGetStringForPath_thenReturnCrtOffset111R() {
    // Arrange
    TreeStatus treeStatus = new TreeStatus("Root Node");
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSArray object = new COSArray();

    // Act and Assert
    assertEquals("CRT/Offset: 1 [1 1 R]", treeStatus.getStringForPath(
        new TreePath(new Object[]{"42", new XrefEntry(1, key, 1L, new COSObject(object, new COSObjectKey(1L, 1)))})));
  }

  /**
   * Test {@link TreeStatus#getStringForPath(TreePath)}.
   * <ul>
   *   <li>Then return {@code Root/Pages}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TreeStatus#getStringForPath(TreePath)}
   */
  @Test
  @DisplayName("Test getStringForPath(TreePath); then return 'Root/Pages'")
  void testGetStringForPath_thenReturnRootPages() {
    // Arrange
    TreeStatus treeStatus = new TreeStatus("Root Node");

    // Act and Assert
    assertEquals("Root/Pages", treeStatus
        .getStringForPath(new TreePath(new Object[]{"42", new PageEntry(new COSDictionary(), 10, "Page Label")})));
  }

  /**
   * Test {@link TreeStatus#getStringForPath(TreePath)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TreeStatus#getStringForPath(TreePath)}
   */
  @Test
  @DisplayName("Test getStringForPath(TreePath); then throw IllegalArgumentException")
  void testGetStringForPath_thenThrowIllegalArgumentException() {
    // Arrange
    TreeStatus treeStatus = new TreeStatus("Root Node");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> treeStatus.getStringForPath(new TreePath(new Object[]{"42", "42"})));
  }

  /**
   * Test {@link TreeStatus#getStringForPath(TreePath)}.
   * <ul>
   *   <li>When {@link TreePath#TreePath(Object[])} with array of {@link Object}
   * with {@code 42}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TreeStatus#getStringForPath(TreePath)}
   */
  @Test
  @DisplayName("Test getStringForPath(TreePath); when TreePath(Object[]) with array of Object with '42'; then return empty string")
  void testGetStringForPath_whenTreePathWithArrayOfObjectWith42_thenReturnEmptyString() {
    // Arrange
    TreeStatus treeStatus = new TreeStatus("Root Node");

    // Act and Assert
    assertEquals("", treeStatus.getStringForPath(new TreePath(new Object[]{"42"})));
  }

  /**
   * Test {@link TreeStatus#getPathForString(String)}.
   * <p>
   * Method under test: {@link TreeStatus#getPathForString(String)}
   */
  @Test
  @DisplayName("Test getPathForString(String)")
  void testGetPathForString() {
    // Arrange, Act and Assert
    assertNull((new TreeStatus(new XrefEntry(1, new COSObjectKey(1L, 1), 1L, null))).getPathForString("Status String"));
  }

  /**
   * Test {@link TreeStatus#getPathForString(String)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary(COSDictionary)} with dict is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TreeStatus#getPathForString(String)}
   */
  @Test
  @DisplayName("Test getPathForString(String); given COSDictionary(COSDictionary) with dict is COSDictionary(); then return 'null'")
  void testGetPathForString_givenCOSDictionaryWithDictIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new TreeStatus(new COSDictionary(new COSDictionary()))).getPathForString("Status String"));
  }

  /**
   * Test {@link TreeStatus#getPathForString(String)}.
   * <ul>
   *   <li>Given {@link MapEntry} (default constructor) Item is
   * {@link COSArray#COSArray()}.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TreeStatus#getPathForString(String)}
   */
  @Test
  @DisplayName("Test getPathForString(String); given MapEntry (default constructor) Item is COSArray(); when '42'; then return 'null'")
  void testGetPathForString_givenMapEntryItemIsCOSArray_when42_thenReturnNull() {
    // Arrange
    MapEntry mapEntry = new MapEntry();
    mapEntry.setItem(new COSArray());
    mapEntry.setValue(new COSArray());

    // Act and Assert
    assertNull((new TreeStatus(mapEntry)).getPathForString("42"));
  }

  /**
   * Test {@link TreeStatus#getPathForString(String)}.
   * <ul>
   *   <li>Given {@link TreeStatus#TreeStatus(Object)} with rootNode is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TreeStatus#getPathForString(String)}
   */
  @Test
  @DisplayName("Test getPathForString(String); given TreeStatus(Object) with rootNode is COSDictionary(); then return 'null'")
  void testGetPathForString_givenTreeStatusWithRootNodeIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new TreeStatus(new COSDictionary())).getPathForString("Status String"));
  }

  /**
   * Test {@link TreeStatus#getPathForString(String)}.
   * <ul>
   *   <li>Given {@link TreeStatus#TreeStatus(Object)} with rootNode is
   * {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TreeStatus#getPathForString(String)}
   */
  @Test
  @DisplayName("Test getPathForString(String); given TreeStatus(Object) with rootNode is COSStream(); then return 'null'")
  void testGetPathForString_givenTreeStatusWithRootNodeIsCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new TreeStatus(new COSStream())).getPathForString("Status String"));
  }

  /**
   * Test {@link TreeStatus#getPathForString(String)}.
   * <ul>
   *   <li>Given {@link TreeStatus#TreeStatus(Object)} with {@code Root Node}.</li>
   *   <li>When {@code [}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TreeStatus#getPathForString(String)}
   */
  @Test
  @DisplayName("Test getPathForString(String); given TreeStatus(Object) with 'Root Node'; when '['")
  void testGetPathForString_givenTreeStatusWithRootNode_whenLeftSquareBracket() {
    // Arrange, Act and Assert
    assertNull((new TreeStatus("Root Node")).getPathForString("["));
  }

  /**
   * Test {@link TreeStatus#getPathForString(String)}.
   * <ul>
   *   <li>Given {@link TreeStatus#TreeStatus(Object)} with {@code Root Node}.</li>
   *   <li>When {@code Status String}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TreeStatus#getPathForString(String)}
   */
  @Test
  @DisplayName("Test getPathForString(String); given TreeStatus(Object) with 'Root Node'; when 'Status String'; then return 'null'")
  void testGetPathForString_givenTreeStatusWithRootNode_whenStatusString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new TreeStatus("Root Node")).getPathForString("Status String"));
  }

  /**
   * Test {@link TreeStatus#getPathForString(String)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return LastPathComponent is {@code Root Node}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TreeStatus#getPathForString(String)}
   */
  @Test
  @DisplayName("Test getPathForString(String); when '/'; then return LastPathComponent is 'Root Node'")
  void testGetPathForString_whenSlash_thenReturnLastPathComponentIsRootNode() {
    // Arrange and Act
    TreePath actualPathForString = (new TreeStatus("Root Node")).getPathForString("/");

    // Assert
    assertEquals("Root Node", actualPathForString.getLastPathComponent());
    Object[] path = actualPathForString.getPath();
    assertEquals("Root Node", path[0]);
    assertNull(actualPathForString.getParentPath());
    assertEquals(1, actualPathForString.getPathCount());
    assertEquals(1, path.length);
  }
}
