package org.apache.pdfbox.debugger.treestatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import javax.swing.tree.TreePath;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.debugger.ui.ArrayEntry;
import org.apache.pdfbox.debugger.ui.MapEntry;
import org.apache.pdfbox.debugger.ui.PageEntry;
import org.apache.pdfbox.debugger.ui.XrefEntry;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.pdfparser.COSParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TreeStatusDiffblueTest {
  /**
   * Test {@link TreeStatus#getStringForPath(TreePath)}.
   *
   * <ul>
   *   <li>Given {@link COSName} {@link COSName#getName()} return {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link TreeStatus#getStringForPath(TreePath)}
   */
  @Test
  @DisplayName(
      "Test getStringForPath(TreePath); given COSName getName() return 'Name'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TreeStatus.getStringForPath(TreePath)"})
  void testGetStringForPath_givenCOSNameGetNameReturnName_thenReturnName() {
    // Arrange
    TreeStatus treeStatus = new TreeStatus("Root Node");

    COSName k = mock(COSName.class);
    when(k.getName()).thenReturn("Name");

    MapEntry mapEntry = new MapEntry();
    mapEntry.setKey(k);
    mapEntry.setItem(new COSArray());
    mapEntry.setValue(new COSArray());
    TreePath path = new TreePath(new Object[] {"42", mapEntry});

    // Act
    String actualStringForPath = treeStatus.getStringForPath(path);

    // Assert
    verify(k).getName();
    assertEquals("Name", actualStringForPath);
  }

  /**
   * Test {@link TreeStatus#getStringForPath(TreePath)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayEntry} (default constructor) Index is one.
   *   <li>Then return {@code [1]}.
   * </ul>
   *
   * <p>Method under test: {@link TreeStatus#getStringForPath(TreePath)}
   */
  @Test
  @DisplayName(
      "Test getStringForPath(TreePath); given one; when ArrayEntry (default constructor) Index is one; then return '[1]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TreeStatus.getStringForPath(TreePath)"})
  void testGetStringForPath_givenOne_whenArrayEntryIndexIsOne_thenReturn1() {
    // Arrange
    TreeStatus treeStatus = new TreeStatus("Root Node");

    ArrayEntry arrayEntry = new ArrayEntry();
    arrayEntry.setIndex(1);
    arrayEntry.setItem(new COSArray());
    arrayEntry.setValue(new COSArray());
    TreePath path = new TreePath(new Object[] {"42", arrayEntry});

    // Act
    String actualStringForPath = treeStatus.getStringForPath(path);

    // Assert
    assertEquals("[1]", actualStringForPath);
  }

  /**
   * Test {@link TreeStatus#getStringForPath(TreePath)}.
   *
   * <ul>
   *   <li>Then return {@code CRT/Offset: 1 [1 1 R]}.
   * </ul>
   *
   * <p>Method under test: {@link TreeStatus#getStringForPath(TreePath)}
   */
  @Test
  @DisplayName("Test getStringForPath(TreePath); then return 'CRT/Offset: 1 [1 1 R]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TreeStatus.getStringForPath(TreePath)"})
  void testGetStringForPath_thenReturnCrtOffset111R() {
    // Arrange
    TreeStatus treeStatus = new TreeStatus("Root Node");
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSArray object = new COSArray();
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));

    XrefEntry xrefEntry = new XrefEntry(1, key, 1L, cosObject);
    TreePath path = new TreePath(new Object[] {"42", xrefEntry});

    // Act
    String actualStringForPath = treeStatus.getStringForPath(path);

    // Assert
    assertEquals("CRT/Offset: 1 [1 1 R]", actualStringForPath);
  }

  /**
   * Test {@link TreeStatus#getStringForPath(TreePath)}.
   *
   * <ul>
   *   <li>Then return {@code Root/Pages}.
   * </ul>
   *
   * <p>Method under test: {@link TreeStatus#getStringForPath(TreePath)}
   */
  @Test
  @DisplayName("Test getStringForPath(TreePath); then return 'Root/Pages'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TreeStatus.getStringForPath(TreePath)"})
  void testGetStringForPath_thenReturnRootPages() {
    // Arrange
    TreeStatus treeStatus = new TreeStatus("Root Node");
    TreePath path =
        new TreePath(new Object[] {"42", new PageEntry(new COSDictionary(), 10, "Page Label")});

    // Act
    String actualStringForPath = treeStatus.getStringForPath(path);

    // Assert
    assertEquals("Root/Pages", actualStringForPath);
  }

  /**
   * Test {@link TreeStatus#getStringForPath(TreePath)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TreeStatus#getStringForPath(TreePath)}
   */
  @Test
  @DisplayName("Test getStringForPath(TreePath); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TreeStatus.getStringForPath(TreePath)"})
  void testGetStringForPath_thenThrowIllegalArgumentException() {
    // Arrange
    TreeStatus treeStatus = new TreeStatus("Root Node");
    TreePath path = new TreePath(new Object[] {"42", "42"});

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> treeStatus.getStringForPath(path));
  }

  /**
   * Test {@link TreeStatus#getStringForPath(TreePath)}.
   *
   * <ul>
   *   <li>When {@link TreePath#TreePath(Object[])} with array of {@link Object} with {@code Path}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link TreeStatus#getStringForPath(TreePath)}
   */
  @Test
  @DisplayName(
      "Test getStringForPath(TreePath); when TreePath(Object[]) with array of Object with 'Path'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TreeStatus.getStringForPath(TreePath)"})
  void testGetStringForPath_whenTreePathWithArrayOfObjectWithPath_thenReturnEmptyString() {
    // Arrange
    TreeStatus treeStatus = new TreeStatus("Root Node");
    Object[] objectArray = new Object[] {"Path"};
    TreePath path = new TreePath(objectArray);

    // Act
    String actualStringForPath = treeStatus.getStringForPath(path);

    // Assert
    assertEquals("", actualStringForPath);
  }

  /**
   * Test {@link TreeStatus#getPathForString(String)}.
   *
   * <p>Method under test: {@link TreeStatus#getPathForString(String)}
   */
  @Test
  @DisplayName("Test getPathForString(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TreePath TreeStatus.getPathForString(String)"})
  void testGetPathForString() {
    // Arrange
    XrefEntry xrefEntry = new XrefEntry(1, new COSObjectKey(1L, 1), 1L, null);

    // Act and Assert
    assertNull(new TreeStatus(xrefEntry).getPathForString("Status String"));
  }

  /**
   * Test {@link TreeStatus#getPathForString(String)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary(COSDictionary)} with dict is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TreeStatus#getPathForString(String)}
   */
  @Test
  @DisplayName(
      "Test getPathForString(String); given COSDictionary(COSDictionary) with dict is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TreePath TreeStatus.getPathForString(String)"})
  void testGetPathForString_givenCOSDictionaryWithDictIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new TreeStatus(new COSDictionary(new COSDictionary())).getPathForString("Status String"));
  }

  /**
   * Test {@link TreeStatus#getPathForString(String)}.
   *
   * <ul>
   *   <li>Given {@link COSObject#COSObject(COSObjectKey, ICOSParser)} with key is {@link
   *       COSObjectKey#COSObjectKey(long, int)} and parser is {@link
   *       COSParser#COSParser(RandomAccessRead)}.
   * </ul>
   *
   * <p>Method under test: {@link TreeStatus#getPathForString(String)}
   */
  @Test
  @DisplayName(
      "Test getPathForString(String); given COSObject(COSObjectKey, ICOSParser) with key is COSObjectKey(long, int) and parser is COSParser(RandomAccessRead)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TreePath TreeStatus.getPathForString(String)"})
  void testGetPathForString_givenCOSObjectWithKeyIsCOSObjectKeyAndParserIsCOSParser()
      throws IOException {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject cosObject = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));

    // Act and Assert
    assertNull(new TreeStatus(cosObject).getPathForString("Status String"));
  }

  /**
   * Test {@link TreeStatus#getPathForString(String)}.
   *
   * <ul>
   *   <li>Given {@link COSObject#COSObject(COSObjectKey, ICOSParser)} with key is {@link
   *       COSObjectKey#COSObjectKey(long, int)} and parser is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TreeStatus#getPathForString(String)}
   */
  @Test
  @DisplayName(
      "Test getPathForString(String); given COSObject(COSObjectKey, ICOSParser) with key is COSObjectKey(long, int) and parser is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TreePath TreeStatus.getPathForString(String)"})
  void testGetPathForString_givenCOSObjectWithKeyIsCOSObjectKeyAndParserIsNull() {
    // Arrange
    COSObject cosObject = new COSObject(new COSObjectKey(1L, 1), null);

    // Act and Assert
    assertNull(new TreeStatus(cosObject).getPathForString("Status String"));
  }

  /**
   * Test {@link TreeStatus#getPathForString(String)}.
   *
   * <ul>
   *   <li>Given {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is {@code null} and
   *       objectKey is {@link COSObjectKey#COSObjectKey(long, int)}.
   * </ul>
   *
   * <p>Method under test: {@link TreeStatus#getPathForString(String)}
   */
  @Test
  @DisplayName(
      "Test getPathForString(String); given COSObject(COSBase, COSObjectKey) with object is 'null' and objectKey is COSObjectKey(long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TreePath TreeStatus.getPathForString(String)"})
  void testGetPathForString_givenCOSObjectWithObjectIsNullAndObjectKeyIsCOSObjectKey() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject cosObject = new COSObject(null, new COSObjectKey(1L, 1));

    XrefEntry xrefEntry = new XrefEntry(1, key, 1L, cosObject);

    // Act and Assert
    assertNull(new TreeStatus(xrefEntry).getPathForString("Status String"));
  }

  /**
   * Test {@link TreeStatus#getPathForString(String)}.
   *
   * <ul>
   *   <li>Given {@link MapEntry} (default constructor) Item is {@link COSArray#COSArray()}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TreeStatus#getPathForString(String)}
   */
  @Test
  @DisplayName(
      "Test getPathForString(String); given MapEntry (default constructor) Item is COSArray(); when '42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TreePath TreeStatus.getPathForString(String)"})
  void testGetPathForString_givenMapEntryItemIsCOSArray_when42_thenReturnNull() {
    // Arrange
    MapEntry mapEntry = new MapEntry();
    mapEntry.setItem(new COSArray());
    mapEntry.setValue(new COSArray());

    // Act and Assert
    assertNull(new TreeStatus(mapEntry).getPathForString("42"));
  }

  /**
   * Test {@link TreeStatus#getPathForString(String)}.
   *
   * <ul>
   *   <li>Given {@link TreeStatus#TreeStatus(Object)} with rootNode is {@link ArrayEntry} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TreeStatus#getPathForString(String)}
   */
  @Test
  @DisplayName(
      "Test getPathForString(String); given TreeStatus(Object) with rootNode is ArrayEntry (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TreePath TreeStatus.getPathForString(String)"})
  void testGetPathForString_givenTreeStatusWithRootNodeIsArrayEntry_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new TreeStatus(new ArrayEntry()).getPathForString("Status String"));
  }

  /**
   * Test {@link TreeStatus#getPathForString(String)}.
   *
   * <ul>
   *   <li>Given {@link TreeStatus#TreeStatus(Object)} with rootNode is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TreeStatus#getPathForString(String)}
   */
  @Test
  @DisplayName(
      "Test getPathForString(String); given TreeStatus(Object) with rootNode is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TreePath TreeStatus.getPathForString(String)"})
  void testGetPathForString_givenTreeStatusWithRootNodeIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new TreeStatus(new COSDictionary()).getPathForString("Status String"));
  }

  /**
   * Test {@link TreeStatus#getPathForString(String)}.
   *
   * <ul>
   *   <li>Given {@link TreeStatus#TreeStatus(Object)} with rootNode is {@link MapEntry} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TreeStatus#getPathForString(String)}
   */
  @Test
  @DisplayName(
      "Test getPathForString(String); given TreeStatus(Object) with rootNode is MapEntry (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TreePath TreeStatus.getPathForString(String)"})
  void testGetPathForString_givenTreeStatusWithRootNodeIsMapEntry_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new TreeStatus(new MapEntry()).getPathForString("Status String"));
  }

  /**
   * Test {@link TreeStatus#getPathForString(String)}.
   *
   * <ul>
   *   <li>Given {@link TreeStatus#TreeStatus(Object)} with {@code Root Node}.
   *   <li>When {@code [}.
   * </ul>
   *
   * <p>Method under test: {@link TreeStatus#getPathForString(String)}
   */
  @Test
  @DisplayName("Test getPathForString(String); given TreeStatus(Object) with 'Root Node'; when '['")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TreePath TreeStatus.getPathForString(String)"})
  void testGetPathForString_givenTreeStatusWithRootNode_whenLeftSquareBracket() {
    // Arrange, Act and Assert
    assertNull(new TreeStatus("Root Node").getPathForString("["));
  }

  /**
   * Test {@link TreeStatus#getPathForString(String)}.
   *
   * <ul>
   *   <li>Given {@link TreeStatus#TreeStatus(Object)} with {@code Root Node}.
   *   <li>When {@code Status String}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TreeStatus#getPathForString(String)}
   */
  @Test
  @DisplayName(
      "Test getPathForString(String); given TreeStatus(Object) with 'Root Node'; when 'Status String'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TreePath TreeStatus.getPathForString(String)"})
  void testGetPathForString_givenTreeStatusWithRootNode_whenStatusString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new TreeStatus("Root Node").getPathForString("Status String"));
  }

  /**
   * Test {@link TreeStatus#getPathForString(String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return LastPathComponent is {@code Root Node}.
   * </ul>
   *
   * <p>Method under test: {@link TreeStatus#getPathForString(String)}
   */
  @Test
  @DisplayName(
      "Test getPathForString(String); when '/'; then return LastPathComponent is 'Root Node'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TreePath TreeStatus.getPathForString(String)"})
  void testGetPathForString_whenSlash_thenReturnLastPathComponentIsRootNode() {
    // Arrange and Act
    TreePath actualPathForString = new TreeStatus("Root Node").getPathForString("/");

    // Assert
    assertEquals("Root Node", actualPathForString.getLastPathComponent());
    Object[] path = actualPathForString.getPath();
    assertEquals("Root Node", path[0]);
    assertNull(actualPathForString.getParentPath());
    assertEquals(1, actualPathForString.getPathCount());
    assertEquals(1, path.length);
  }
}
