package org.apache.pdfbox.util.filetypedetector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.UnsupportedEncodingException;
import org.apache.pdfbox.util.filetypedetector.ByteTrie.ByteTrieNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ByteTrieDiffblueTest {
  /**
   * Test ByteTrieNode getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ByteTrie.ByteTrieNode}
   *   <li>{@link ByteTrie.ByteTrieNode#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test ByteTrieNode getters and setters")
  void testByteTrieNodeGettersAndSetters() {
    // Arrange and Act
    ByteTrie.ByteTrieNode<Object> actualByteTrieNode = new ByteTrie.ByteTrieNode<>();

    // Assert
    assertNull(actualByteTrieNode.getValue());
  }

  /**
   * Test ByteTrieNode {@link ByteTrieNode#setValue(Object)}.
   * <ul>
   *   <li>Given {@link ByteTrieNode} (default constructor).</li>
   *   <li>Then {@link ByteTrieNode} (default constructor) Value is
   * {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteTrie.ByteTrieNode#setValue(Object)}
   */
  @Test
  @DisplayName("Test ByteTrieNode setValue(Object); given ByteTrieNode (default constructor); then ByteTrieNode (default constructor) Value is 'Value'")
  void testByteTrieNodeSetValue_givenByteTrieNode_thenByteTrieNodeValueIsValue() {
    // Arrange
    ByteTrie.ByteTrieNode<Object> byteTrieNode = new ByteTrie.ByteTrieNode<>();

    // Act
    byteTrieNode.setValue("Value");

    // Assert
    assertEquals("Value", byteTrieNode.getValue());
  }

  /**
   * Test ByteTrieNode {@link ByteTrieNode#setValue(Object)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteTrie.ByteTrieNode#setValue(Object)}
   */
  @Test
  @DisplayName("Test ByteTrieNode setValue(Object); then throw IllegalStateException")
  void testByteTrieNodeSetValue_thenThrowIllegalStateException() {
    // Arrange
    ByteTrie.ByteTrieNode<Object> byteTrieNode = new ByteTrie.ByteTrieNode<>();
    byteTrieNode.setValue("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> byteTrieNode.setValue("Value"));
  }

  /**
   * Test {@link ByteTrie#find(byte[])}.
   * <ul>
   *   <li>Given 2D array of {@code byte} with A backspace A backspace A backspace A
   * Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteTrie#find(byte[])}
   */
  @Test
  @DisplayName("Test find(byte[]); given 2D array of byte with A backspace A backspace A backspace A Bytes is 'UTF-8'")
  void testFind_given2dArrayOfByteWithABackspaceABackspaceABackspaceABytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ByteTrie<Object> byteTrie = new ByteTrie<>();
    byteTrie.addPath("Value", "A\bA\bA\bA\b".getBytes("UTF-8"));

    // Act and Assert
    assertNull(byteTrie.find("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteTrie#find(byte[])}.
   * <ul>
   *   <li>Given {@link ByteTrie} (default constructor).</li>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteTrie#find(byte[])}
   */
  @Test
  @DisplayName("Test find(byte[]); given ByteTrie (default constructor); when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'null'")
  void testFind_givenByteTrie_whenAxaxaxaxBytesIsUtf8_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange
    ByteTrie<Object> byteTrie = new ByteTrie<>();

    // Act and Assert
    assertNull(byteTrie.find("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteTrie#find(byte[])}.
   * <ul>
   *   <li>Given {@link ByteTrie} (default constructor).</li>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteTrie#find(byte[])}
   */
  @Test
  @DisplayName("Test find(byte[]); given ByteTrie (default constructor); when empty array of byte; then return 'null'")
  void testFind_givenByteTrie_whenEmptyArrayOfByte_thenReturnNull() {
    // Arrange
    ByteTrie<Object> byteTrie = new ByteTrie<>();

    // Act and Assert
    assertNull(byteTrie.find(new byte[]{}));
  }

  /**
   * Test {@link ByteTrie#find(byte[])}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteTrie#find(byte[])}
   */
  @Test
  @DisplayName("Test find(byte[]); then return 'Value'")
  void testFind_thenReturnValue() throws UnsupportedEncodingException {
    // Arrange
    ByteTrie<Object> byteTrie = new ByteTrie<>();
    byteTrie.addPath("Value", "A\bA\bA\bA\b".getBytes("UTF-8"));

    // Act and Assert
    assertEquals("Value", byteTrie.find("A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteTrie#addPath(Object, byte[][])}.
   * <ul>
   *   <li>Given {@link ByteTrie} (default constructor).</li>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then {@link ByteTrie} (default constructor) MaxDepth is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteTrie#addPath(Object, byte[][])}
   */
  @Test
  @DisplayName("Test addPath(Object, byte[][]); given ByteTrie (default constructor); when 'AXAXAXAX' Bytes is 'UTF-8'; then ByteTrie (default constructor) MaxDepth is eight")
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
   * <p>
   * Method under test: {@link ByteTrie#getMaxDepth()}
   */
  @Test
  @DisplayName("Test getMaxDepth()")
  void testGetMaxDepth() {
    // Arrange
    ByteTrie<Object> byteTrie = new ByteTrie<>();

    // Act and Assert
    assertEquals(0, byteTrie.getMaxDepth());
  }

  /**
   * Test new {@link ByteTrie} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ByteTrie}
   */
  @Test
  @DisplayName("Test new ByteTrie (default constructor)")
  void testNewByteTrie() {
    // Arrange and Act
    ByteTrie<Object> actualByteTrie = new ByteTrie<>();

    // Assert
    assertEquals(0, actualByteTrie.getMaxDepth());
  }
}
