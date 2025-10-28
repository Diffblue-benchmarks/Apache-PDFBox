package org.apache.xmpbox.xml;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;

class DomXmpParserDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DomXmpParser#setStrictParsing(boolean)}
   *   <li>{@link DomXmpParser#isStrictParsing()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() throws XmpParsingException {
    // Arrange
    DomXmpParser domXmpParser = new DomXmpParser();

    // Act
    domXmpParser.setStrictParsing(true);

    // Assert that nothing has changed
    assertTrue(domXmpParser.isStrictParsing());
  }

  /**
   * Method under test:
   * {@link DomXmpParser.NamespaceFinder#containsNamespace(String)}
   */
  @Test
  void testNamespaceFinderContainsNamespace() {
    // Arrange, Act and Assert
    assertFalse((new DomXmpParser.NamespaceFinder()).containsNamespace("Namespace"));
  }

  /**
   * Method under test: {@link DomXmpParser.NamespaceFinder#push(Element)}
   */
  @Test
  void testNamespaceFinderPush() {
    // Arrange
    DomXmpParser.NamespaceFinder namespaceFinder = new DomXmpParser.NamespaceFinder();

    // Act
    namespaceFinder.push(new IIOMetadataNode("foo"));

    // Assert
    assertTrue(namespaceFinder.pop().isEmpty());
  }

  /**
   * Method under test: {@link DomXmpParser#parse(InputStream)}
   */
  @Test
  void testParse() throws UnsupportedEncodingException, XmpParsingException {
    // Arrange
    DomXmpParser domXmpParser = new DomXmpParser();

    // Act and Assert
    assertThrows(XmpParsingException.class,
        () -> domXmpParser.parse(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Method under test: {@link DomXmpParser#parse(byte[])}
   */
  @Test
  void testParse2() throws UnsupportedEncodingException, XmpParsingException {
    // Arrange
    DomXmpParser domXmpParser = new DomXmpParser();

    // Act and Assert
    assertThrows(XmpParsingException.class, () -> domXmpParser.parse("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link DomXmpParser}
   */
  @Test
  void testNewDomXmpParser() throws XmpParsingException {
    // Arrange, Act and Assert
    assertTrue((new DomXmpParser()).isStrictParsing());
  }
}
