package org.apache.pdfbox.util.filetypedetector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.apache.pdfbox.util.filetypedetector.ByteTrie.ByteTrieNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ByteTrieDiffblueTest {
  /**
   * Test ByteTrieNode getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ByteTrieNode}
   *   <li>{@link ByteTrieNode#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test ByteTrieNode getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ByteTrieNode.<init>()", "Object ByteTrieNode.getValue()"})
  void testByteTrieNodeGettersAndSetters() {
    // Arrange and Act
    ByteTrieNode<Object> actualByteTrieNode = new ByteTrieNode<>();

    // Assert
    assertNull(actualByteTrieNode.getValue());
  }

  /**
   * Test ByteTrieNode {@link ByteTrieNode#setValue(Object)}.
   *
   * <ul>
   *   <li>Given {@link ByteTrieNode} (default constructor).
   *   <li>Then {@link ByteTrieNode} (default constructor) Value is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ByteTrieNode#setValue(Object)}
   */
  @Test
  @DisplayName(
      "Test ByteTrieNode setValue(Object); given ByteTrieNode (default constructor); then ByteTrieNode (default constructor) Value is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ByteTrieNode.setValue(Object)"})
  void testByteTrieNodeSetValue_givenByteTrieNode_thenByteTrieNodeValueIsValue() {
    // Arrange
    ByteTrieNode<Object> byteTrieNode = new ByteTrieNode<>();

    // Act
    byteTrieNode.setValue("Value");

    // Assert
    assertEquals("Value", byteTrieNode.getValue());
  }

  /**
   * Test ByteTrieNode {@link ByteTrieNode#setValue(Object)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link ByteTrieNode#setValue(Object)}
   */
  @Test
  @DisplayName("Test ByteTrieNode setValue(Object); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ByteTrieNode.setValue(Object)"})
  void testByteTrieNodeSetValue_thenThrowIllegalStateException() {
    // Arrange
    ByteTrieNode<Object> byteTrieNode = new ByteTrieNode<>();
    byteTrieNode.setValue("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> byteTrieNode.setValue("Value"));
  }

  /**
   * Test {@link ByteTrie#find(byte[])}.
   *
   * <ul>
   *   <li>Given 2D array of {@code byte} with A backspace A backspace A backspace A Bytes is {@code
   *       UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ByteTrie#find(byte[])}
   */
  @Test
  @DisplayName(
      "Test find(byte[]); given 2D array of byte with A backspace A backspace A backspace A Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ByteTrie.find(byte[])"})
  void testFind_given2dArrayOfByteWithABackspaceABackspaceABackspaceABytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    ByteTrie<Object> byteTrie = new ByteTrie<>();
    byteTrie.addPath("Value", "A\bA\bA\bA\b".getBytes("UTF-8"));

    // Act
    Object actualFindResult = byteTrie.find("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualFindResult);
  }

  /**
   * Test {@link ByteTrie#find(byte[])}.
   *
   * <ul>
   *   <li>Given {@link ByteTrie} (default constructor).
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ByteTrie#find(byte[])}
   */
  @Test
  @DisplayName(
      "Test find(byte[]); given ByteTrie (default constructor); when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ByteTrie.find(byte[])"})
  void testFind_givenByteTrie_whenAxaxaxaxBytesIsUtf8_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange
    ByteTrie<Object> byteTrie = new ByteTrie<>();

    // Act
    Object actualFindResult = byteTrie.find("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualFindResult);
  }

  /**
   * Test {@link ByteTrie#find(byte[])}.
   *
   * <ul>
   *   <li>Given {@link ByteTrie} (default constructor).
   *   <li>When empty array of {@code byte}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ByteTrie#find(byte[])}
   */
  @Test
  @DisplayName(
      "Test find(byte[]); given ByteTrie (default constructor); when empty array of byte; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ByteTrie.find(byte[])"})
  void testFind_givenByteTrie_whenEmptyArrayOfByte_thenReturnNull() {
    // Arrange
    ByteTrie<Object> byteTrie = new ByteTrie<>();

    // Act
    Object actualFindResult = byteTrie.find(new byte[] {});

    // Assert
    assertNull(actualFindResult);
  }

  /**
   * Test {@link ByteTrie#find(byte[])}.
   *
   * <ul>
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ByteTrie#find(byte[])}
   */
  @Test
  @DisplayName("Test find(byte[]); then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ByteTrie.find(byte[])"})
  void testFind_thenReturnValue() throws UnsupportedEncodingException {
    // Arrange
    ByteTrie<Object> byteTrie = new ByteTrie<>();
    byteTrie.addPath("Value", "A\bA\bA\bA\b".getBytes("UTF-8"));

    // Act
    Object actualFindResult = byteTrie.find("A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8"));

    // Assert
    assertEquals("Value", actualFindResult);
  }

  /**
   * Test {@link ByteTrie#addPath(Object, byte[][])}.
   *
   * <ul>
   *   <li>Given {@link ByteTrie} (default constructor) addPath {@code null} and {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ByteTrie#addPath(Object, byte[][])}
   */
  @Test
  @DisplayName(
      "Test addPath(Object, byte[][]); given ByteTrie (default constructor) addPath 'null' and 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ByteTrie.addPath(Object, byte[][])"})
  void testAddPath_givenByteTrieAddPathNullAndAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    ByteTrie<Object> byteTrie = new ByteTrie<>();
    byteTrie.addPath(null, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    byteTrie.addPath("Value", "AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    assertEquals(8, byteTrie.getMaxDepth());
  }

  /**
   * Test {@link ByteTrie#addPath(Object, byte[][])}.
   *
   * <ul>
   *   <li>Given {@link ByteTrie} (default constructor).
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then {@link ByteTrie} (default constructor) MaxDepth is eight.
   * </ul>
   *
   * <p>Method under test: {@link ByteTrie#addPath(Object, byte[][])}
   */
  @Test
  @DisplayName(
      "Test addPath(Object, byte[][]); given ByteTrie (default constructor); when 'AXAXAXAX' Bytes is 'UTF-8'; then ByteTrie (default constructor) MaxDepth is eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ByteTrie.addPath(Object, byte[][])"})
  void testAddPath_givenByteTrie_whenAxaxaxaxBytesIsUtf8_thenByteTrieMaxDepthIsEight()
      throws UnsupportedEncodingException {
    // Arrange
    ByteTrie<Object> byteTrie = new ByteTrie<>();

    // Act
    byteTrie.addPath("Value", "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(8, byteTrie.getMaxDepth());
  }

  /**
   * Test {@link ByteTrie#getMaxDepth()}.
   *
   * <p>Method under test: {@link ByteTrie#getMaxDepth()}
   */
  @Test
  @DisplayName("Test getMaxDepth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ByteTrie.getMaxDepth()"})
  void testGetMaxDepth() {
    // Arrange
    ByteTrie<Object> byteTrie = new ByteTrie<>();

    // Act and Assert
    assertEquals(0, byteTrie.getMaxDepth());
  }

  /**
   * Test new {@link ByteTrie} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ByteTrie}
   */
  @Test
  @DisplayName("Test new ByteTrie (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ByteTrie.<init>()"})
  void testNewByteTrie() {
    // Arrange and Act
    ByteTrie<Object> actualByteTrie = new ByteTrie<>();

    // Assert
    assertEquals(0, actualByteTrie.getMaxDepth());
  }
}
