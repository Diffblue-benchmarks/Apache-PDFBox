package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.MissingResourceException;
import org.apache.pdfbox.pdmodel.PDResources;
import org.junit.jupiter.api.Test;

class PDColorSpaceDiffblueTest {
  /**
   * Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  void testCreate() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(COSBoolean.FALSE));
    assertThrows(IOException.class, () -> PDColorSpace.create(COSFloat.ONE));
    assertThrows(IOException.class, () -> PDColorSpace.create(COSInteger.ONE));
    assertThrows(MissingResourceException.class, () -> PDColorSpace.create(COSName.A));
    assertThrows(IOException.class,
        () -> PDColorSpace.create(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1))));
    assertThrows(IOException.class, () -> PDColorSpace.create(new COSArray()));
    assertThrows(IOException.class, () -> PDColorSpace.create(new COSDictionary()));
    assertThrows(IOException.class, () -> PDColorSpace.create(new COSStream()));
    assertThrows(IOException.class, () -> PDColorSpace.create(COSBoolean.FALSE, new PDResources()));
    assertThrows(IOException.class, () -> PDColorSpace.create(COSFloat.ONE, new PDResources()));
    assertThrows(IOException.class, () -> PDColorSpace.create(COSInteger.ONE, new PDResources()));
    assertThrows(MissingResourceException.class, () -> PDColorSpace.create(COSName.A, new PDResources()));
    assertThrows(IOException.class, () -> PDColorSpace.create(COSBoolean.FALSE, new PDResources(), true));
    assertThrows(IOException.class, () -> PDColorSpace.create(COSFloat.ONE, new PDResources(), true));
    assertThrows(IOException.class, () -> PDColorSpace.create(COSInteger.ONE, new PDResources(), true));
    assertThrows(MissingResourceException.class, () -> PDColorSpace.create(COSName.A, new PDResources(), true));
  }

  /**
   * Method under test: {@link PDColorSpace#create(COSBase)}
   */
  @Test
  void testCreate2() throws IOException {
    // Arrange
    COSArray colorSpace = new COSArray();
    colorSpace.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace));
  }

  /**
   * Method under test: {@link PDColorSpace#create(COSBase, PDResources)}
   */
  @Test
  void testCreate3() throws IOException {
    // Arrange
    COSObject colorSpace = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace, new PDResources()));
  }

  /**
   * Method under test: {@link PDColorSpace#create(COSBase, PDResources)}
   */
  @Test
  void testCreate4() throws IOException {
    // Arrange
    COSArray colorSpace = new COSArray();

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace, new PDResources()));
  }

  /**
   * Method under test: {@link PDColorSpace#create(COSBase, PDResources)}
   */
  @Test
  void testCreate5() throws IOException {
    // Arrange
    COSDictionary colorSpace = new COSDictionary();

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace, new PDResources()));
  }

  /**
   * Method under test: {@link PDColorSpace#create(COSBase, PDResources)}
   */
  @Test
  void testCreate6() throws IOException {
    // Arrange
    COSStream colorSpace = new COSStream();

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace, new PDResources()));
  }

  /**
   * Method under test: {@link PDColorSpace#create(COSBase, PDResources, boolean)}
   */
  @Test
  void testCreate7() throws IOException {
    // Arrange
    COSObject colorSpace = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace, new PDResources(), true));
  }

  /**
   * Method under test: {@link PDColorSpace#create(COSBase, PDResources, boolean)}
   */
  @Test
  void testCreate8() throws IOException {
    // Arrange
    COSArray colorSpace = new COSArray();

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace, new PDResources(), true));
  }

  /**
   * Method under test: {@link PDColorSpace#create(COSBase, PDResources, boolean)}
   */
  @Test
  void testCreate9() throws IOException {
    // Arrange
    COSDictionary colorSpace = new COSDictionary();

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace, new PDResources(), true));
  }

  /**
   * Method under test: {@link PDColorSpace#create(COSBase, PDResources, boolean)}
   */
  @Test
  void testCreate10() throws IOException {
    // Arrange
    COSStream colorSpace = new COSStream();

    // Act and Assert
    assertThrows(IOException.class, () -> PDColorSpace.create(colorSpace, new PDResources(), true));
  }

  /**
   * Method under test: {@link PDColorSpace#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange
    PDCalGray pdCalGray = new PDCalGray();

    // Act and Assert
    assertSame(pdCalGray.array, pdCalGray.getCOSObject());
  }

  /**
   * Method under test: {@link PDColorSpace#getCOSObject()}
   */
  @Test
  void testGetCOSObject2() {
    // Arrange
    PDDeviceGray pdDeviceGray = PDDeviceGray.INSTANCE;

    // Act
    COSBase actualCOSObject = pdDeviceGray.getCOSObject();

    // Assert
    COSName cosName = ((COSName) actualCOSObject).DEVICEGRAY;
    assertSame(cosName, actualCOSObject);
    assertSame(cosName, pdDeviceGray.getCOSObject());
  }
}
