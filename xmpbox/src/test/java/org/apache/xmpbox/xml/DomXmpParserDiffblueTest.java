package org.apache.xmpbox.xml;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import javax.imageio.metadata.IIOMetadataNode;
import org.apache.xmpbox.xml.DomXmpParser.NamespaceFinder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;

class DomXmpParserDiffblueTest {
  /**
   * Test NamespaceFinder {@link NamespaceFinder#containsNamespace(String)}.
   * <p>
   * Method under test: {@link NamespaceFinder#containsNamespace(String)}
   */
  @Test
  @DisplayName("Test NamespaceFinder containsNamespace(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NamespaceFinder.containsNamespace(String)"})
  void testNamespaceFinderContainsNamespace() {
    // Arrange, Act and Assert
    assertFalse((new NamespaceFinder()).containsNamespace("Namespace"));
  }

  /**
   * Test NamespaceFinder {@link NamespaceFinder#push(Element)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   *   <li>Then {@link NamespaceFinder} (default constructor) pop Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link NamespaceFinder#push(Element)}
   */
  @Test
  @DisplayName("Test NamespaceFinder push(Element); when IIOMetadataNode(String) with 'foo'; then NamespaceFinder (default constructor) pop Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NamespaceFinder.push(Element)"})
  void testNamespaceFinderPush_whenIIOMetadataNodeWithFoo_thenNamespaceFinderPopEmpty() {
    // Arrange
    NamespaceFinder namespaceFinder = new NamespaceFinder();

    // Act
    namespaceFinder.push(new IIOMetadataNode("foo"));

    // Assert
    assertTrue(namespaceFinder.pop().isEmpty());
  }

  /**
   * Test {@link DomXmpParser#DomXmpParser()}.
   * <p>
   * Method under test: default or parameterless constructor of {@link DomXmpParser}
   */
  @Test
  @DisplayName("Test new DomXmpParser()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DomXmpParser.<init>()"})
  void testNewDomXmpParser() throws XmpParsingException {
    // Arrange, Act and Assert
    assertTrue((new DomXmpParser()).isStrictParsing());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DomXmpParser#setStrictParsing(boolean)}
   *   <li>{@link DomXmpParser#isStrictParsing()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DomXmpParser.isStrictParsing()", "void DomXmpParser.setStrictParsing(boolean)"})
  void testGettersAndSetters() throws XmpParsingException {
    // Arrange
    DomXmpParser domXmpParser = new DomXmpParser();

    // Act
    domXmpParser.setStrictParsing(true);

    // Assert
    assertTrue(domXmpParser.isStrictParsing());
  }

  /**
   * Test {@link DomXmpParser#parse(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link XmpParsingException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomXmpParser#parse(InputStream)}
   */
  @Test
  @DisplayName("Test parse(InputStream) with 'input'; then throw XmpParsingException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.xmpbox.XMPMetadata DomXmpParser.parse(InputStream)"})
  void testParseWithInput_thenThrowXmpParsingException() throws UnsupportedEncodingException, XmpParsingException {
    // Arrange
    DomXmpParser domXmpParser = new DomXmpParser();

    // Act and Assert
    assertThrows(XmpParsingException.class,
        () -> domXmpParser.parse(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link DomXmpParser#parse(byte[])} with {@code xmp}.
   * <p>
   * Method under test: {@link DomXmpParser#parse(byte[])}
   */
  @Test
  @DisplayName("Test parse(byte[]) with 'xmp'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.xmpbox.XMPMetadata DomXmpParser.parse(byte[])"})
  void testParseWithXmp() throws UnsupportedEncodingException, XmpParsingException {
    // Arrange
    DomXmpParser domXmpParser = new DomXmpParser();

    // Act and Assert
    assertThrows(XmpParsingException.class, () -> domXmpParser.parse("AXAXAXAX".getBytes("UTF-8")));
  }
}
