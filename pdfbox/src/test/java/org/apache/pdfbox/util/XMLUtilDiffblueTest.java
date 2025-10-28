package org.apache.pdfbox.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.github.jaiimageio.impl.plugins.tiff.TIFFFieldNode;
import com.github.jaiimageio.plugins.tiff.TIFFField;
import com.github.jaiimageio.plugins.tiff.TIFFTag;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;

class XMLUtilDiffblueTest {
  /**
   * Method under test: {@link XMLUtil#parse(InputStream)}
   */
  @Test
  void testParse() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> XMLUtil.parse(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    assertThrows(IOException.class, () -> XMLUtil.parse(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), true));
  }

  /**
   * Method under test: {@link XMLUtil#getNodeValue(Element)}
   */
  @Test
  void testGetNodeValue() {
    // Arrange, Act and Assert
    assertEquals("", XMLUtil.getNodeValue(new IIOMetadataNode("foo")));
    assertEquals("",
        XMLUtil.getNodeValue(new TIFFFieldNode(new TIFFField(new TIFFTag("Name", TIFFTag.TIFF_SRATIONAL, 1), 42))));
  }
}
