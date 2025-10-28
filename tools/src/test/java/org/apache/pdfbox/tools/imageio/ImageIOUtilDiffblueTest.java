package org.apache.pdfbox.tools.imageio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.junit.jupiter.api.Test;

class ImageIOUtilDiffblueTest {
  /**
   * Method under test:
   * {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream)}
   */
  @Test
  void testWriteImage() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);

    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    boolean actualWriteImageResult = ImageIOUtil.writeImage(image, "Format Name", output);

    // Assert
    assertEquals(0, output.toByteArray().length);
    assertFalse(actualWriteImageResult);
  }

  /**
   * Method under test:
   * {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream)}
   */
  @Test
  void testWriteImage2() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);

    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    boolean actualWriteImageResult = ImageIOUtil.writeImage(image, "png", output);

    // Assert
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals((byte) -119, toByteArrayResult[0]);
    assertEquals((byte) -126, toByteArrayResult[89]);
    assertEquals((byte) -21, toByteArrayResult[76]);
    assertEquals((byte) -22, toByteArrayResult[75]);
    assertEquals((byte) -56, toByteArrayResult[74]);
    assertEquals((byte) -7, toByteArrayResult[77]);
    assertEquals((byte) -82, toByteArrayResult[86]);
    assertEquals((byte) 0, toByteArrayResult[10]);
    assertEquals((byte) 0, toByteArrayResult[17]);
    assertEquals((byte) 0, toByteArrayResult[18]);
    assertEquals((byte) 0, toByteArrayResult[20]);
    assertEquals((byte) 0, toByteArrayResult[21]);
    assertEquals((byte) 0, toByteArrayResult[22]);
    assertEquals((byte) 0, toByteArrayResult[68]);
    assertEquals((byte) 0, toByteArrayResult[69]);
    assertEquals((byte) 0, toByteArrayResult[70]);
    assertEquals((byte) 0, toByteArrayResult[72]);
    assertEquals((byte) 0, toByteArrayResult[78]);
    assertEquals((byte) 0, toByteArrayResult[79]);
    assertEquals((byte) 0, toByteArrayResult[8]);
    assertEquals((byte) 0, toByteArrayResult[80]);
    assertEquals((byte) 0, toByteArrayResult[81]);
    assertEquals((byte) 0, toByteArrayResult[9]);
    assertEquals((byte) 0, toByteArrayResult[Short.SIZE]);
    assertEquals((byte) 1, toByteArrayResult[19]);
    assertEquals((byte) 1, toByteArrayResult[23]);
    assertEquals((byte) 1, toByteArrayResult[73]);
    assertEquals((byte) 26, toByteArrayResult[6]);
    assertEquals((byte) 4, toByteArrayResult[71]);
    assertEquals(90, toByteArrayResult.length);
    assertTrue(actualWriteImageResult);
    assertEquals('B', toByteArrayResult[87]);
    assertEquals('D', toByteArrayResult[14]);
    assertEquals('D', toByteArrayResult[85]);
    assertEquals('E', toByteArrayResult[83]);
    assertEquals('G', toByteArrayResult[3]);
    assertEquals('H', toByteArrayResult[13]);
    assertEquals('I', toByteArrayResult[12]);
    assertEquals('I', toByteArrayResult[82]);
    assertEquals('N', toByteArrayResult[2]);
    assertEquals('N', toByteArrayResult[84]);
    assertEquals('P', toByteArrayResult[1]);
    assertEquals('R', toByteArrayResult[15]);
    assertEquals('\b', toByteArrayResult[24]);
    assertEquals('\n', toByteArrayResult[5]);
    assertEquals('\n', toByteArrayResult[7]);
    assertEquals('\r', toByteArrayResult[11]);
    assertEquals('\r', toByteArrayResult[4]);
    assertEquals('`', toByteArrayResult[65]);
    assertEquals('`', toByteArrayResult[66]);
    assertEquals('`', toByteArrayResult[67]);
    assertEquals('`', toByteArrayResult[88]);
  }

  /**
   * Method under test:
   * {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream)}
   */
  @Test
  void testWriteImage3() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);

    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    boolean actualWriteImageResult = ImageIOUtil.writeImage(image, "tif", output);

    // Assert
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals((byte) 0, toByteArrayResult[11]);
    assertEquals((byte) 0, toByteArrayResult[12]);
    assertEquals((byte) 0, toByteArrayResult[14]);
    assertEquals((byte) 0, toByteArrayResult[15]);
    assertEquals((byte) 0, toByteArrayResult[18]);
    assertEquals((byte) 0, toByteArrayResult[184]);
    assertEquals((byte) 0, toByteArrayResult[185]);
    assertEquals((byte) 0, toByteArrayResult[186]);
    assertEquals((byte) 0, toByteArrayResult[188]);
    assertEquals((byte) 0, toByteArrayResult[189]);
    assertEquals((byte) 0, toByteArrayResult[190]);
    assertEquals((byte) 0, toByteArrayResult[192]);
    assertEquals((byte) 0, toByteArrayResult[193]);
    assertEquals((byte) 0, toByteArrayResult[194]);
    assertEquals((byte) 0, toByteArrayResult[2]);
    assertEquals((byte) 0, toByteArrayResult[20]);
    assertEquals((byte) 0, toByteArrayResult[202]);
    assertEquals((byte) 0, toByteArrayResult[204]);
    assertEquals((byte) 0, toByteArrayResult[21]);
    assertEquals((byte) 0, toByteArrayResult[24]);
    assertEquals((byte) 0, toByteArrayResult[4]);
    assertEquals((byte) 0, toByteArrayResult[5]);
    assertEquals((byte) 0, toByteArrayResult[6]);
    assertEquals((byte) 0, toByteArrayResult[8]);
    assertEquals((byte) 0, toByteArrayResult[Short.SIZE]);
    assertEquals((byte) 16, toByteArrayResult[207]);
    assertEquals((byte) 1, toByteArrayResult[10]);
    assertEquals((byte) 1, toByteArrayResult[17]);
    assertEquals((byte) 1, toByteArrayResult[187]);
    assertEquals((byte) 1, toByteArrayResult[19]);
    assertEquals((byte) 1, toByteArrayResult[195]);
    assertEquals((byte) 1, toByteArrayResult[22]);
    assertEquals((byte) 1, toByteArrayResult[23]);
    assertEquals(208, toByteArrayResult.length);
    assertEquals((byte) 3, toByteArrayResult[13]);
    assertTrue(actualWriteImageResult);
    assertEquals(Byte.MIN_VALUE, toByteArrayResult[203]);
    assertEquals(' ', toByteArrayResult[205]);
    assertEquals('*', toByteArrayResult[3]);
    assertEquals('B', toByteArrayResult[199]);
    assertEquals('D', toByteArrayResult[197]);
    assertEquals('F', toByteArrayResult[198]);
    assertEquals('H', toByteArrayResult[183]);
    assertEquals('H', toByteArrayResult[191]);
    assertEquals('M', toByteArrayResult[0]);
    assertEquals('M', toByteArrayResult[1]);
    assertEquals('O', toByteArrayResult[200]);
    assertEquals('P', toByteArrayResult[196]);
    assertEquals('P', toByteArrayResult[206]);
    assertEquals('X', toByteArrayResult[201]);
    assertEquals('\b', toByteArrayResult[7]);
    assertEquals('\r', toByteArrayResult[9]);
  }

  /**
   * Method under test:
   * {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream)}
   */
  @Test
  void testWriteImage4() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);

    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    boolean actualWriteImageResult = ImageIOUtil.writeImage(image, "jpeg", output);

    // Assert
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals((byte) -1, toByteArrayResult[0]);
    assertEquals((byte) -1, toByteArrayResult[2]);
    assertEquals((byte) -1, toByteArrayResult[20]);
    assertEquals((byte) -1, toByteArrayResult[609]);
    assertEquals((byte) -1, toByteArrayResult[623]);
    assertEquals((byte) -1, toByteArrayResult[631]);
    assertEquals((byte) -32, toByteArrayResult[3]);
    assertEquals((byte) -37, toByteArrayResult[21]);
    assertEquals((byte) -38, toByteArrayResult[610]);
    assertEquals((byte) -39, toByteArrayResult[632]);
    assertEquals((byte) -40, toByteArrayResult[1]);
    assertEquals((byte) -6, toByteArrayResult[608]);
    assertEquals((byte) -6, toByteArrayResult[626]);
    assertEquals((byte) -94, toByteArrayResult[628]);
    assertEquals((byte) 0, toByteArrayResult[10]);
    assertEquals((byte) 0, toByteArrayResult[14]);
    assertEquals((byte) 0, toByteArrayResult[18]);
    assertEquals((byte) 0, toByteArrayResult[19]);
    assertEquals((byte) 0, toByteArrayResult[22]);
    assertEquals((byte) 0, toByteArrayResult[24]);
    assertEquals((byte) 0, toByteArrayResult[4]);
    assertEquals((byte) 0, toByteArrayResult[611]);
    assertEquals((byte) 0, toByteArrayResult[615]);
    assertEquals((byte) 0, toByteArrayResult[620]);
    assertEquals((byte) 0, toByteArrayResult[622]);
    assertEquals((byte) 0, toByteArrayResult[624]);
    assertEquals((byte) 0, toByteArrayResult[Short.SIZE]);
    assertEquals((byte) 16, toByteArrayResult[5]);
    assertEquals((byte) 17, toByteArrayResult[617]);
    assertEquals((byte) 17, toByteArrayResult[619]);
    assertEquals((byte) 1, toByteArrayResult[11]);
    assertEquals((byte) 1, toByteArrayResult[13]);
    assertEquals((byte) 1, toByteArrayResult[614]);
    assertEquals((byte) 2, toByteArrayResult[12]);
    assertEquals((byte) 2, toByteArrayResult[616]);
    assertEquals((byte) 3, toByteArrayResult[613]);
    assertEquals((byte) 3, toByteArrayResult[618]);
    assertEquals(633, toByteArrayResult.length);
    assertTrue(actualWriteImageResult);
    assertEquals(Byte.MIN_VALUE, toByteArrayResult[629]);
    assertEquals('(', toByteArrayResult[627]);
    assertEquals('?', toByteArrayResult[621]);
    assertEquals('?', toByteArrayResult[625]);
    assertEquals('?', toByteArrayResult[630]);
    assertEquals('C', toByteArrayResult[23]);
    assertEquals('F', toByteArrayResult[7]);
    assertEquals('F', toByteArrayResult[9]);
    assertEquals('H', toByteArrayResult[15]);
    assertEquals('H', toByteArrayResult[17]);
    assertEquals('I', toByteArrayResult[8]);
    assertEquals('J', toByteArrayResult[6]);
    assertEquals('\f', toByteArrayResult[612]);
  }

  /**
   * Method under test:
   * {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream)}
   */
  @Test
  void testWriteImage5() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);

    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    boolean actualWriteImageResult = ImageIOUtil.writeImage(image, "jpg", output);

    // Assert
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals((byte) -1, toByteArrayResult[0]);
    assertEquals((byte) -1, toByteArrayResult[2]);
    assertEquals((byte) -1, toByteArrayResult[20]);
    assertEquals((byte) -1, toByteArrayResult[609]);
    assertEquals((byte) -1, toByteArrayResult[623]);
    assertEquals((byte) -1, toByteArrayResult[631]);
    assertEquals((byte) -32, toByteArrayResult[3]);
    assertEquals((byte) -37, toByteArrayResult[21]);
    assertEquals((byte) -38, toByteArrayResult[610]);
    assertEquals((byte) -39, toByteArrayResult[632]);
    assertEquals((byte) -40, toByteArrayResult[1]);
    assertEquals((byte) -6, toByteArrayResult[608]);
    assertEquals((byte) -6, toByteArrayResult[626]);
    assertEquals((byte) -94, toByteArrayResult[628]);
    assertEquals((byte) 0, toByteArrayResult[10]);
    assertEquals((byte) 0, toByteArrayResult[14]);
    assertEquals((byte) 0, toByteArrayResult[18]);
    assertEquals((byte) 0, toByteArrayResult[19]);
    assertEquals((byte) 0, toByteArrayResult[22]);
    assertEquals((byte) 0, toByteArrayResult[24]);
    assertEquals((byte) 0, toByteArrayResult[4]);
    assertEquals((byte) 0, toByteArrayResult[611]);
    assertEquals((byte) 0, toByteArrayResult[615]);
    assertEquals((byte) 0, toByteArrayResult[620]);
    assertEquals((byte) 0, toByteArrayResult[622]);
    assertEquals((byte) 0, toByteArrayResult[624]);
    assertEquals((byte) 0, toByteArrayResult[Short.SIZE]);
    assertEquals((byte) 16, toByteArrayResult[5]);
    assertEquals((byte) 17, toByteArrayResult[617]);
    assertEquals((byte) 17, toByteArrayResult[619]);
    assertEquals((byte) 1, toByteArrayResult[11]);
    assertEquals((byte) 1, toByteArrayResult[13]);
    assertEquals((byte) 1, toByteArrayResult[614]);
    assertEquals((byte) 2, toByteArrayResult[12]);
    assertEquals((byte) 2, toByteArrayResult[616]);
    assertEquals((byte) 3, toByteArrayResult[613]);
    assertEquals((byte) 3, toByteArrayResult[618]);
    assertEquals(633, toByteArrayResult.length);
    assertTrue(actualWriteImageResult);
    assertEquals(Byte.MIN_VALUE, toByteArrayResult[629]);
    assertEquals('(', toByteArrayResult[627]);
    assertEquals('?', toByteArrayResult[621]);
    assertEquals('?', toByteArrayResult[625]);
    assertEquals('?', toByteArrayResult[630]);
    assertEquals('C', toByteArrayResult[23]);
    assertEquals('F', toByteArrayResult[7]);
    assertEquals('F', toByteArrayResult[9]);
    assertEquals('H', toByteArrayResult[15]);
    assertEquals('H', toByteArrayResult[17]);
    assertEquals('I', toByteArrayResult[8]);
    assertEquals('J', toByteArrayResult[6]);
    assertEquals('\f', toByteArrayResult[612]);
  }

  /**
   * Method under test:
   * {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream)}
   */
  @Test
  void testWriteImage6() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(72, 1, 1);

    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    boolean actualWriteImageResult = ImageIOUtil.writeImage(image, "tif", output);

    // Assert
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals((byte) -120, toByteArrayResult[221]);
    assertEquals((byte) -124, toByteArrayResult[212]);
    assertEquals((byte) -72, toByteArrayResult[216]);
    assertEquals((byte) -92, toByteArrayResult[226]);
    assertEquals((byte) 0, toByteArrayResult[11]);
    assertEquals((byte) 0, toByteArrayResult[12]);
    assertEquals((byte) 0, toByteArrayResult[14]);
    assertEquals((byte) 0, toByteArrayResult[15]);
    assertEquals((byte) 0, toByteArrayResult[18]);
    assertEquals((byte) 0, toByteArrayResult[2]);
    assertEquals((byte) 0, toByteArrayResult[20]);
    assertEquals((byte) 0, toByteArrayResult[204]);
    assertEquals((byte) 0, toByteArrayResult[21]);
    assertEquals((byte) 0, toByteArrayResult[24]);
    assertEquals((byte) 0, toByteArrayResult[4]);
    assertEquals((byte) 0, toByteArrayResult[5]);
    assertEquals((byte) 0, toByteArrayResult[6]);
    assertEquals((byte) 0, toByteArrayResult[8]);
    assertEquals((byte) 0, toByteArrayResult[Short.SIZE]);
    assertEquals((byte) 15, toByteArrayResult[220]);
    assertEquals((byte) 1, toByteArrayResult[10]);
    assertEquals((byte) 1, toByteArrayResult[17]);
    assertEquals((byte) 1, toByteArrayResult[22]);
    assertEquals((byte) 1, toByteArrayResult[23]);
    assertEquals(229, toByteArrayResult.length);
    assertEquals((byte) 22, toByteArrayResult[209]);
    assertEquals((byte) 26, toByteArrayResult[227]);
    assertEquals((byte) 29, toByteArrayResult[219]);
    assertEquals((byte) 2, toByteArrayResult[228]);
    assertEquals((byte) 3, toByteArrayResult[13]);
    assertEquals((byte) 7, toByteArrayResult[211]);
    assertTrue(actualWriteImageResult);
    assertEquals(' ', toByteArrayResult[205]);
    assertEquals('$', toByteArrayResult[208]);
    assertEquals('*', toByteArrayResult[3]);
    assertEquals('6', toByteArrayResult[218]);
    assertEquals('8', toByteArrayResult[207]);
    assertEquals('8', toByteArrayResult[225]);
    assertEquals('B', toByteArrayResult[213]);
    assertEquals('D', toByteArrayResult[222]);
    assertEquals('H', toByteArrayResult[19]);
    assertEquals('M', toByteArrayResult[0]);
    assertEquals('M', toByteArrayResult[1]);
    assertEquals('P', toByteArrayResult[206]);
    assertEquals('P', toByteArrayResult[215]);
    assertEquals('Q', toByteArrayResult[224]);
    assertEquals('\b', toByteArrayResult[7]);
    assertEquals('\r', toByteArrayResult[210]);
    assertEquals('\r', toByteArrayResult[9]);
    assertEquals('a', toByteArrayResult[214]);
    assertEquals('b', toByteArrayResult[223]);
    assertEquals('d', toByteArrayResult[217]);
  }

  /**
   * Method under test:
   * {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream)}
   */
  @Test
  void testWriteImage7() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(72, 1, BufferedImage.TYPE_BYTE_BINARY);

    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    boolean actualWriteImageResult = ImageIOUtil.writeImage(image, "tif", output);

    // Assert
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals((byte) -96, toByteArrayResult[184]);
    assertEquals((byte) -96, toByteArrayResult[186]);
    assertEquals((byte) 0, toByteArrayResult[11]);
    assertEquals((byte) 0, toByteArrayResult[12]);
    assertEquals((byte) 0, toByteArrayResult[14]);
    assertEquals((byte) 0, toByteArrayResult[15]);
    assertEquals((byte) 0, toByteArrayResult[165]);
    assertEquals((byte) 0, toByteArrayResult[166]);
    assertEquals((byte) 0, toByteArrayResult[168]);
    assertEquals((byte) 0, toByteArrayResult[169]);
    assertEquals((byte) 0, toByteArrayResult[170]);
    assertEquals((byte) 0, toByteArrayResult[172]);
    assertEquals((byte) 0, toByteArrayResult[173]);
    assertEquals((byte) 0, toByteArrayResult[174]);
    assertEquals((byte) 0, toByteArrayResult[18]);
    assertEquals((byte) 0, toByteArrayResult[182]);
    assertEquals((byte) 0, toByteArrayResult[188]);
    assertEquals((byte) 0, toByteArrayResult[2]);
    assertEquals((byte) 0, toByteArrayResult[20]);
    assertEquals((byte) 0, toByteArrayResult[21]);
    assertEquals((byte) 0, toByteArrayResult[24]);
    assertEquals((byte) 0, toByteArrayResult[4]);
    assertEquals((byte) 0, toByteArrayResult[5]);
    assertEquals((byte) 0, toByteArrayResult[6]);
    assertEquals((byte) 0, toByteArrayResult[8]);
    assertEquals((byte) 0, toByteArrayResult[Short.SIZE]);
    assertEquals(190, toByteArrayResult.length);
    assertEquals((byte) 1, toByteArrayResult[10]);
    assertEquals((byte) 1, toByteArrayResult[167]);
    assertEquals((byte) 1, toByteArrayResult[17]);
    assertEquals((byte) 1, toByteArrayResult[175]);
    assertEquals((byte) 1, toByteArrayResult[22]);
    assertEquals((byte) 1, toByteArrayResult[23]);
    assertEquals((byte) 2, toByteArrayResult[187]);
    assertEquals((byte) 3, toByteArrayResult[13]);
    assertTrue(actualWriteImageResult);
    assertEquals(' ', toByteArrayResult[189]);
    assertEquals('&', toByteArrayResult[183]);
    assertEquals('*', toByteArrayResult[3]);
    assertEquals('B', toByteArrayResult[179]);
    assertEquals('D', toByteArrayResult[177]);
    assertEquals('F', toByteArrayResult[178]);
    assertEquals('H', toByteArrayResult[171]);
    assertEquals('H', toByteArrayResult[19]);
    assertEquals('M', toByteArrayResult[0]);
    assertEquals('M', toByteArrayResult[1]);
    assertEquals('O', toByteArrayResult[180]);
    assertEquals('P', toByteArrayResult[176]);
    assertEquals('X', toByteArrayResult[181]);
    assertEquals('\b', toByteArrayResult[7]);
    assertEquals('\f', toByteArrayResult[9]);
    assertEquals('x', toByteArrayResult[185]);
  }

  /**
   * Method under test:
   * {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int)}
   */
  @Test
  void testWriteImage8() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);

    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    boolean actualWriteImageResult = ImageIOUtil.writeImage(image, "Format Name", output, 19088743);

    // Assert
    assertEquals(0, output.toByteArray().length);
    assertFalse(actualWriteImageResult);
  }

  /**
   * Method under test:
   * {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int)}
   */
  @Test
  void testWriteImage9() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);

    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    boolean actualWriteImageResult = ImageIOUtil.writeImage(image, "png", output, 19088743);

    // Assert
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals((byte) -119, toByteArrayResult[0]);
    assertEquals((byte) -126, toByteArrayResult[89]);
    assertEquals((byte) -21, toByteArrayResult[76]);
    assertEquals((byte) -22, toByteArrayResult[75]);
    assertEquals((byte) -56, toByteArrayResult[74]);
    assertEquals((byte) -7, toByteArrayResult[77]);
    assertEquals((byte) -82, toByteArrayResult[86]);
    assertEquals((byte) 0, toByteArrayResult[10]);
    assertEquals((byte) 0, toByteArrayResult[17]);
    assertEquals((byte) 0, toByteArrayResult[18]);
    assertEquals((byte) 0, toByteArrayResult[20]);
    assertEquals((byte) 0, toByteArrayResult[21]);
    assertEquals((byte) 0, toByteArrayResult[22]);
    assertEquals((byte) 0, toByteArrayResult[68]);
    assertEquals((byte) 0, toByteArrayResult[69]);
    assertEquals((byte) 0, toByteArrayResult[70]);
    assertEquals((byte) 0, toByteArrayResult[72]);
    assertEquals((byte) 0, toByteArrayResult[78]);
    assertEquals((byte) 0, toByteArrayResult[79]);
    assertEquals((byte) 0, toByteArrayResult[8]);
    assertEquals((byte) 0, toByteArrayResult[80]);
    assertEquals((byte) 0, toByteArrayResult[81]);
    assertEquals((byte) 0, toByteArrayResult[9]);
    assertEquals((byte) 0, toByteArrayResult[Short.SIZE]);
    assertEquals((byte) 1, toByteArrayResult[19]);
    assertEquals((byte) 1, toByteArrayResult[23]);
    assertEquals((byte) 1, toByteArrayResult[73]);
    assertEquals((byte) 26, toByteArrayResult[6]);
    assertEquals((byte) 4, toByteArrayResult[71]);
    assertEquals(90, toByteArrayResult.length);
    assertTrue(actualWriteImageResult);
    assertEquals('B', toByteArrayResult[87]);
    assertEquals('D', toByteArrayResult[14]);
    assertEquals('D', toByteArrayResult[85]);
    assertEquals('E', toByteArrayResult[83]);
    assertEquals('G', toByteArrayResult[3]);
    assertEquals('H', toByteArrayResult[13]);
    assertEquals('I', toByteArrayResult[12]);
    assertEquals('I', toByteArrayResult[82]);
    assertEquals('N', toByteArrayResult[2]);
    assertEquals('N', toByteArrayResult[84]);
    assertEquals('P', toByteArrayResult[1]);
    assertEquals('R', toByteArrayResult[15]);
    assertEquals('\b', toByteArrayResult[24]);
    assertEquals('\n', toByteArrayResult[5]);
    assertEquals('\n', toByteArrayResult[7]);
    assertEquals('\r', toByteArrayResult[11]);
    assertEquals('\r', toByteArrayResult[4]);
    assertEquals('`', toByteArrayResult[65]);
    assertEquals('`', toByteArrayResult[66]);
    assertEquals('`', toByteArrayResult[67]);
    assertEquals('`', toByteArrayResult[88]);
  }

  /**
   * Method under test:
   * {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int)}
   */
  @Test
  void testWriteImage10() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);

    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    boolean actualWriteImageResult = ImageIOUtil.writeImage(image, "tif", output, 19088743);

    // Assert
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals((byte) 0, toByteArrayResult[11]);
    assertEquals((byte) 0, toByteArrayResult[12]);
    assertEquals((byte) 0, toByteArrayResult[14]);
    assertEquals((byte) 0, toByteArrayResult[15]);
    assertEquals((byte) 0, toByteArrayResult[18]);
    assertEquals((byte) 0, toByteArrayResult[184]);
    assertEquals((byte) 0, toByteArrayResult[185]);
    assertEquals((byte) 0, toByteArrayResult[186]);
    assertEquals((byte) 0, toByteArrayResult[192]);
    assertEquals((byte) 0, toByteArrayResult[193]);
    assertEquals((byte) 0, toByteArrayResult[194]);
    assertEquals((byte) 0, toByteArrayResult[2]);
    assertEquals((byte) 0, toByteArrayResult[20]);
    assertEquals((byte) 0, toByteArrayResult[202]);
    assertEquals((byte) 0, toByteArrayResult[204]);
    assertEquals((byte) 0, toByteArrayResult[21]);
    assertEquals((byte) 0, toByteArrayResult[24]);
    assertEquals((byte) 0, toByteArrayResult[4]);
    assertEquals((byte) 0, toByteArrayResult[5]);
    assertEquals((byte) 0, toByteArrayResult[6]);
    assertEquals((byte) 0, toByteArrayResult[8]);
    assertEquals((byte) 0, toByteArrayResult[Short.SIZE]);
    assertEquals((byte) 16, toByteArrayResult[207]);
    assertEquals((byte) 1, toByteArrayResult[10]);
    assertEquals((byte) 1, toByteArrayResult[17]);
    assertEquals((byte) 1, toByteArrayResult[187]);
    assertEquals((byte) 1, toByteArrayResult[188]);
    assertEquals((byte) 1, toByteArrayResult[19]);
    assertEquals((byte) 1, toByteArrayResult[195]);
    assertEquals((byte) 1, toByteArrayResult[22]);
    assertEquals((byte) 1, toByteArrayResult[23]);
    assertEquals(208, toByteArrayResult.length);
    assertEquals((byte) 3, toByteArrayResult[13]);
    assertTrue(actualWriteImageResult);
    assertEquals(Byte.MIN_VALUE, toByteArrayResult[203]);
    assertEquals(' ', toByteArrayResult[205]);
    assertEquals('#', toByteArrayResult[189]);
    assertEquals('*', toByteArrayResult[3]);
    assertEquals('B', toByteArrayResult[199]);
    assertEquals('D', toByteArrayResult[197]);
    assertEquals('E', toByteArrayResult[190]);
    assertEquals('F', toByteArrayResult[198]);
    assertEquals('M', toByteArrayResult[0]);
    assertEquals('M', toByteArrayResult[1]);
    assertEquals('O', toByteArrayResult[200]);
    assertEquals('P', toByteArrayResult[196]);
    assertEquals('P', toByteArrayResult[206]);
    assertEquals('X', toByteArrayResult[201]);
    assertEquals('\b', toByteArrayResult[7]);
    assertEquals('\r', toByteArrayResult[9]);
    assertEquals('g', toByteArrayResult[183]);
    assertEquals('g', toByteArrayResult[191]);
  }

  /**
   * Method under test:
   * {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int)}
   */
  @Test
  void testWriteImage11() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_BINARY);

    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    boolean actualWriteImageResult = ImageIOUtil.writeImage(image, "tif", output, 19088743);

    // Assert
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals((byte) 0, toByteArrayResult[11]);
    assertEquals((byte) 0, toByteArrayResult[12]);
    assertEquals((byte) 0, toByteArrayResult[14]);
    assertEquals((byte) 0, toByteArrayResult[15]);
    assertEquals((byte) 0, toByteArrayResult[164]);
    assertEquals((byte) 0, toByteArrayResult[165]);
    assertEquals((byte) 0, toByteArrayResult[166]);
    assertEquals((byte) 0, toByteArrayResult[172]);
    assertEquals((byte) 0, toByteArrayResult[173]);
    assertEquals((byte) 0, toByteArrayResult[174]);
    assertEquals((byte) 0, toByteArrayResult[18]);
    assertEquals((byte) 0, toByteArrayResult[182]);
    assertEquals((byte) 0, toByteArrayResult[185]);
    assertEquals((byte) 0, toByteArrayResult[2]);
    assertEquals((byte) 0, toByteArrayResult[20]);
    assertEquals((byte) 0, toByteArrayResult[21]);
    assertEquals((byte) 0, toByteArrayResult[24]);
    assertEquals((byte) 0, toByteArrayResult[4]);
    assertEquals((byte) 0, toByteArrayResult[5]);
    assertEquals((byte) 0, toByteArrayResult[6]);
    assertEquals((byte) 0, toByteArrayResult[8]);
    assertEquals((byte) 0, toByteArrayResult[Short.SIZE]);
    assertEquals((byte) 16, toByteArrayResult[186]);
    assertEquals(187, toByteArrayResult.length);
    assertEquals((byte) 1, toByteArrayResult[10]);
    assertEquals((byte) 1, toByteArrayResult[167]);
    assertEquals((byte) 1, toByteArrayResult[168]);
    assertEquals((byte) 1, toByteArrayResult[17]);
    assertEquals((byte) 1, toByteArrayResult[175]);
    assertEquals((byte) 1, toByteArrayResult[184]);
    assertEquals((byte) 1, toByteArrayResult[19]);
    assertEquals((byte) 1, toByteArrayResult[22]);
    assertEquals((byte) 1, toByteArrayResult[23]);
    assertEquals((byte) 3, toByteArrayResult[13]);
    assertTrue(actualWriteImageResult);
    assertEquals('#', toByteArrayResult[169]);
    assertEquals('*', toByteArrayResult[3]);
    assertEquals('B', toByteArrayResult[179]);
    assertEquals('D', toByteArrayResult[177]);
    assertEquals('E', toByteArrayResult[162]);
    assertEquals('E', toByteArrayResult[170]);
    assertEquals('F', toByteArrayResult[178]);
    assertEquals('M', toByteArrayResult[0]);
    assertEquals('M', toByteArrayResult[1]);
    assertEquals('O', toByteArrayResult[180]);
    assertEquals('P', toByteArrayResult[176]);
    assertEquals('P', toByteArrayResult[183]);
    assertEquals('X', toByteArrayResult[181]);
    assertEquals('\b', toByteArrayResult[7]);
    assertEquals('\f', toByteArrayResult[9]);
    assertEquals('g', toByteArrayResult[163]);
    assertEquals('g', toByteArrayResult[171]);
  }

  /**
   * Method under test:
   * {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int)}
   */
  @Test
  void testWriteImage12() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);

    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    boolean actualWriteImageResult = ImageIOUtil.writeImage(image, "jpeg", output, 1);

    // Assert
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals((byte) -1, toByteArrayResult[0]);
    assertEquals((byte) -1, toByteArrayResult[2]);
    assertEquals((byte) -1, toByteArrayResult[20]);
    assertEquals((byte) -1, toByteArrayResult[609]);
    assertEquals((byte) -1, toByteArrayResult[623]);
    assertEquals((byte) -1, toByteArrayResult[631]);
    assertEquals((byte) -32, toByteArrayResult[3]);
    assertEquals((byte) -37, toByteArrayResult[21]);
    assertEquals((byte) -38, toByteArrayResult[610]);
    assertEquals((byte) -39, toByteArrayResult[632]);
    assertEquals((byte) -40, toByteArrayResult[1]);
    assertEquals((byte) -6, toByteArrayResult[608]);
    assertEquals((byte) -6, toByteArrayResult[626]);
    assertEquals((byte) -94, toByteArrayResult[628]);
    assertEquals((byte) 0, toByteArrayResult[10]);
    assertEquals((byte) 0, toByteArrayResult[14]);
    assertEquals((byte) 0, toByteArrayResult[18]);
    assertEquals((byte) 0, toByteArrayResult[19]);
    assertEquals((byte) 0, toByteArrayResult[22]);
    assertEquals((byte) 0, toByteArrayResult[24]);
    assertEquals((byte) 0, toByteArrayResult[4]);
    assertEquals((byte) 0, toByteArrayResult[611]);
    assertEquals((byte) 0, toByteArrayResult[615]);
    assertEquals((byte) 0, toByteArrayResult[620]);
    assertEquals((byte) 0, toByteArrayResult[622]);
    assertEquals((byte) 0, toByteArrayResult[624]);
    assertEquals((byte) 0, toByteArrayResult[Short.SIZE]);
    assertEquals((byte) 16, toByteArrayResult[5]);
    assertEquals((byte) 17, toByteArrayResult[617]);
    assertEquals((byte) 17, toByteArrayResult[619]);
    assertEquals((byte) 1, toByteArrayResult[11]);
    assertEquals((byte) 1, toByteArrayResult[13]);
    assertEquals((byte) 1, toByteArrayResult[15]);
    assertEquals((byte) 1, toByteArrayResult[17]);
    assertEquals((byte) 1, toByteArrayResult[614]);
    assertEquals((byte) 2, toByteArrayResult[12]);
    assertEquals((byte) 2, toByteArrayResult[616]);
    assertEquals((byte) 3, toByteArrayResult[613]);
    assertEquals((byte) 3, toByteArrayResult[618]);
    assertEquals(633, toByteArrayResult.length);
    assertTrue(actualWriteImageResult);
    assertEquals(Byte.MIN_VALUE, toByteArrayResult[629]);
    assertEquals('(', toByteArrayResult[627]);
    assertEquals('?', toByteArrayResult[621]);
    assertEquals('?', toByteArrayResult[625]);
    assertEquals('?', toByteArrayResult[630]);
    assertEquals('C', toByteArrayResult[23]);
    assertEquals('F', toByteArrayResult[7]);
    assertEquals('F', toByteArrayResult[9]);
    assertEquals('I', toByteArrayResult[8]);
    assertEquals('J', toByteArrayResult[6]);
    assertEquals('\f', toByteArrayResult[612]);
  }

  /**
   * Method under test:
   * {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int, float)}
   */
  @Test
  void testWriteImage13() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);

    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    boolean actualWriteImageResult = ImageIOUtil.writeImage(image, "Format Name", output, 19088743, 10.0f);

    // Assert
    assertEquals(0, output.toByteArray().length);
    assertFalse(actualWriteImageResult);
  }

  /**
   * Method under test:
   * {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int, float)}
   */
  @Test
  void testWriteImage14() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);

    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    boolean actualWriteImageResult = ImageIOUtil.writeImage(image, "tif", output, 19088743, 10.0f);

    // Assert
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals((byte) 0, toByteArrayResult[11]);
    assertEquals((byte) 0, toByteArrayResult[12]);
    assertEquals((byte) 0, toByteArrayResult[14]);
    assertEquals((byte) 0, toByteArrayResult[15]);
    assertEquals((byte) 0, toByteArrayResult[18]);
    assertEquals((byte) 0, toByteArrayResult[184]);
    assertEquals((byte) 0, toByteArrayResult[185]);
    assertEquals((byte) 0, toByteArrayResult[186]);
    assertEquals((byte) 0, toByteArrayResult[192]);
    assertEquals((byte) 0, toByteArrayResult[193]);
    assertEquals((byte) 0, toByteArrayResult[194]);
    assertEquals((byte) 0, toByteArrayResult[2]);
    assertEquals((byte) 0, toByteArrayResult[20]);
    assertEquals((byte) 0, toByteArrayResult[202]);
    assertEquals((byte) 0, toByteArrayResult[204]);
    assertEquals((byte) 0, toByteArrayResult[21]);
    assertEquals((byte) 0, toByteArrayResult[24]);
    assertEquals((byte) 0, toByteArrayResult[4]);
    assertEquals((byte) 0, toByteArrayResult[5]);
    assertEquals((byte) 0, toByteArrayResult[6]);
    assertEquals((byte) 0, toByteArrayResult[8]);
    assertEquals((byte) 0, toByteArrayResult[Short.SIZE]);
    assertEquals((byte) 16, toByteArrayResult[207]);
    assertEquals((byte) 1, toByteArrayResult[10]);
    assertEquals((byte) 1, toByteArrayResult[17]);
    assertEquals((byte) 1, toByteArrayResult[187]);
    assertEquals((byte) 1, toByteArrayResult[188]);
    assertEquals((byte) 1, toByteArrayResult[19]);
    assertEquals((byte) 1, toByteArrayResult[195]);
    assertEquals((byte) 1, toByteArrayResult[22]);
    assertEquals((byte) 1, toByteArrayResult[23]);
    assertEquals(208, toByteArrayResult.length);
    assertEquals((byte) 3, toByteArrayResult[13]);
    assertTrue(actualWriteImageResult);
    assertEquals(Byte.MIN_VALUE, toByteArrayResult[203]);
    assertEquals(' ', toByteArrayResult[205]);
    assertEquals('#', toByteArrayResult[189]);
    assertEquals('*', toByteArrayResult[3]);
    assertEquals('B', toByteArrayResult[199]);
    assertEquals('D', toByteArrayResult[197]);
    assertEquals('E', toByteArrayResult[190]);
    assertEquals('F', toByteArrayResult[198]);
    assertEquals('M', toByteArrayResult[0]);
    assertEquals('M', toByteArrayResult[1]);
    assertEquals('O', toByteArrayResult[200]);
    assertEquals('P', toByteArrayResult[196]);
    assertEquals('P', toByteArrayResult[206]);
    assertEquals('X', toByteArrayResult[201]);
    assertEquals('\b', toByteArrayResult[7]);
    assertEquals('\r', toByteArrayResult[9]);
    assertEquals('g', toByteArrayResult[183]);
    assertEquals('g', toByteArrayResult[191]);
  }

  /**
   * Method under test:
   * {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int, float)}
   */
  @Test
  void testWriteImage15() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);

    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    boolean actualWriteImageResult = ImageIOUtil.writeImage(image, "png", output, 19088743, 0.0f);

    // Assert
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals((byte) -119, toByteArrayResult[0]);
    assertEquals((byte) -126, toByteArrayResult[89]);
    assertEquals((byte) -21, toByteArrayResult[76]);
    assertEquals((byte) -22, toByteArrayResult[75]);
    assertEquals((byte) -56, toByteArrayResult[74]);
    assertEquals((byte) -7, toByteArrayResult[77]);
    assertEquals((byte) -82, toByteArrayResult[86]);
    assertEquals((byte) 0, toByteArrayResult[10]);
    assertEquals((byte) 0, toByteArrayResult[17]);
    assertEquals((byte) 0, toByteArrayResult[18]);
    assertEquals((byte) 0, toByteArrayResult[20]);
    assertEquals((byte) 0, toByteArrayResult[21]);
    assertEquals((byte) 0, toByteArrayResult[22]);
    assertEquals((byte) 0, toByteArrayResult[68]);
    assertEquals((byte) 0, toByteArrayResult[69]);
    assertEquals((byte) 0, toByteArrayResult[70]);
    assertEquals((byte) 0, toByteArrayResult[72]);
    assertEquals((byte) 0, toByteArrayResult[78]);
    assertEquals((byte) 0, toByteArrayResult[79]);
    assertEquals((byte) 0, toByteArrayResult[8]);
    assertEquals((byte) 0, toByteArrayResult[80]);
    assertEquals((byte) 0, toByteArrayResult[81]);
    assertEquals((byte) 0, toByteArrayResult[9]);
    assertEquals((byte) 0, toByteArrayResult[Short.SIZE]);
    assertEquals((byte) 1, toByteArrayResult[19]);
    assertEquals((byte) 1, toByteArrayResult[23]);
    assertEquals((byte) 1, toByteArrayResult[73]);
    assertEquals((byte) 26, toByteArrayResult[6]);
    assertEquals((byte) 4, toByteArrayResult[71]);
    assertEquals(90, toByteArrayResult.length);
    assertTrue(actualWriteImageResult);
    assertEquals('B', toByteArrayResult[87]);
    assertEquals('D', toByteArrayResult[14]);
    assertEquals('D', toByteArrayResult[85]);
    assertEquals('E', toByteArrayResult[83]);
    assertEquals('G', toByteArrayResult[3]);
    assertEquals('H', toByteArrayResult[13]);
    assertEquals('I', toByteArrayResult[12]);
    assertEquals('I', toByteArrayResult[82]);
    assertEquals('N', toByteArrayResult[2]);
    assertEquals('N', toByteArrayResult[84]);
    assertEquals('P', toByteArrayResult[1]);
    assertEquals('R', toByteArrayResult[15]);
    assertEquals('\b', toByteArrayResult[24]);
    assertEquals('\n', toByteArrayResult[5]);
    assertEquals('\n', toByteArrayResult[7]);
    assertEquals('\r', toByteArrayResult[11]);
    assertEquals('\r', toByteArrayResult[4]);
    assertEquals('`', toByteArrayResult[65]);
    assertEquals('`', toByteArrayResult[66]);
    assertEquals('`', toByteArrayResult[67]);
    assertEquals('`', toByteArrayResult[88]);
  }

  /**
   * Method under test:
   * {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int, float)}
   */
  @Test
  void testWriteImage16() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_BINARY);

    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    boolean actualWriteImageResult = ImageIOUtil.writeImage(image, "tif", output, 19088743, 10.0f);

    // Assert
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals((byte) 0, toByteArrayResult[11]);
    assertEquals((byte) 0, toByteArrayResult[12]);
    assertEquals((byte) 0, toByteArrayResult[14]);
    assertEquals((byte) 0, toByteArrayResult[15]);
    assertEquals((byte) 0, toByteArrayResult[164]);
    assertEquals((byte) 0, toByteArrayResult[165]);
    assertEquals((byte) 0, toByteArrayResult[166]);
    assertEquals((byte) 0, toByteArrayResult[172]);
    assertEquals((byte) 0, toByteArrayResult[173]);
    assertEquals((byte) 0, toByteArrayResult[174]);
    assertEquals((byte) 0, toByteArrayResult[18]);
    assertEquals((byte) 0, toByteArrayResult[182]);
    assertEquals((byte) 0, toByteArrayResult[185]);
    assertEquals((byte) 0, toByteArrayResult[2]);
    assertEquals((byte) 0, toByteArrayResult[20]);
    assertEquals((byte) 0, toByteArrayResult[21]);
    assertEquals((byte) 0, toByteArrayResult[24]);
    assertEquals((byte) 0, toByteArrayResult[4]);
    assertEquals((byte) 0, toByteArrayResult[5]);
    assertEquals((byte) 0, toByteArrayResult[6]);
    assertEquals((byte) 0, toByteArrayResult[8]);
    assertEquals((byte) 0, toByteArrayResult[Short.SIZE]);
    assertEquals((byte) 16, toByteArrayResult[186]);
    assertEquals(187, toByteArrayResult.length);
    assertEquals((byte) 1, toByteArrayResult[10]);
    assertEquals((byte) 1, toByteArrayResult[167]);
    assertEquals((byte) 1, toByteArrayResult[168]);
    assertEquals((byte) 1, toByteArrayResult[17]);
    assertEquals((byte) 1, toByteArrayResult[175]);
    assertEquals((byte) 1, toByteArrayResult[184]);
    assertEquals((byte) 1, toByteArrayResult[19]);
    assertEquals((byte) 1, toByteArrayResult[22]);
    assertEquals((byte) 1, toByteArrayResult[23]);
    assertEquals((byte) 3, toByteArrayResult[13]);
    assertTrue(actualWriteImageResult);
    assertEquals('#', toByteArrayResult[169]);
    assertEquals('*', toByteArrayResult[3]);
    assertEquals('B', toByteArrayResult[179]);
    assertEquals('D', toByteArrayResult[177]);
    assertEquals('E', toByteArrayResult[162]);
    assertEquals('E', toByteArrayResult[170]);
    assertEquals('F', toByteArrayResult[178]);
    assertEquals('M', toByteArrayResult[0]);
    assertEquals('M', toByteArrayResult[1]);
    assertEquals('O', toByteArrayResult[180]);
    assertEquals('P', toByteArrayResult[176]);
    assertEquals('P', toByteArrayResult[183]);
    assertEquals('X', toByteArrayResult[181]);
    assertEquals('\b', toByteArrayResult[7]);
    assertEquals('\f', toByteArrayResult[9]);
    assertEquals('g', toByteArrayResult[163]);
    assertEquals('g', toByteArrayResult[171]);
  }

  /**
   * Method under test:
   * {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int, float)}
   */
  @Test
  void testWriteImage17() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);

    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    boolean actualWriteImageResult = ImageIOUtil.writeImage(image, "jpeg", output, 1, 0.0f);

    // Assert
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals((byte) -114, toByteArrayResult[623]);
    assertEquals((byte) -118, toByteArrayResult[624]);
    assertEquals((byte) -1, toByteArrayResult[0]);
    assertEquals((byte) -1, toByteArrayResult[2]);
    assertEquals((byte) -1, toByteArrayResult[20]);
    assertEquals((byte) -1, toByteArrayResult[609]);
    assertEquals((byte) -1, toByteArrayResult[628]);
    assertEquals((byte) -32, toByteArrayResult[3]);
    assertEquals((byte) -37, toByteArrayResult[21]);
    assertEquals((byte) -38, toByteArrayResult[610]);
    assertEquals((byte) -39, toByteArrayResult[629]);
    assertEquals((byte) -40, toByteArrayResult[1]);
    assertEquals((byte) -6, toByteArrayResult[608]);
    assertEquals((byte) -7, toByteArrayResult[607]);
    assertEquals((byte) -8, toByteArrayResult[606]);
    assertEquals((byte) -96, toByteArrayResult[626]);
    assertEquals((byte) -9, toByteArrayResult[605]);
    assertEquals((byte) 0, toByteArrayResult[10]);
    assertEquals((byte) 0, toByteArrayResult[14]);
    assertEquals((byte) 0, toByteArrayResult[18]);
    assertEquals((byte) 0, toByteArrayResult[19]);
    assertEquals((byte) 0, toByteArrayResult[22]);
    assertEquals((byte) 0, toByteArrayResult[24]);
    assertEquals((byte) 0, toByteArrayResult[4]);
    assertEquals((byte) 0, toByteArrayResult[611]);
    assertEquals((byte) 0, toByteArrayResult[615]);
    assertEquals((byte) 0, toByteArrayResult[620]);
    assertEquals((byte) 0, toByteArrayResult[622]);
    assertEquals((byte) 0, toByteArrayResult[Short.SIZE]);
    assertEquals((byte) 15, toByteArrayResult[627]);
    assertEquals((byte) 16, toByteArrayResult[5]);
    assertEquals((byte) 17, toByteArrayResult[617]);
    assertEquals((byte) 17, toByteArrayResult[619]);
    assertEquals((byte) 1, toByteArrayResult[11]);
    assertEquals((byte) 1, toByteArrayResult[13]);
    assertEquals((byte) 1, toByteArrayResult[15]);
    assertEquals((byte) 1, toByteArrayResult[17]);
    assertEquals((byte) 1, toByteArrayResult[614]);
    assertEquals((byte) 2, toByteArrayResult[12]);
    assertEquals((byte) 2, toByteArrayResult[616]);
    assertEquals((byte) 3, toByteArrayResult[613]);
    assertEquals((byte) 3, toByteArrayResult[618]);
    assertEquals(630, toByteArrayResult.length);
    assertTrue(actualWriteImageResult);
    assertEquals('(', toByteArrayResult[625]);
    assertEquals('?', toByteArrayResult[621]);
    assertEquals('C', toByteArrayResult[23]);
    assertEquals('F', toByteArrayResult[7]);
    assertEquals('F', toByteArrayResult[9]);
    assertEquals('I', toByteArrayResult[8]);
    assertEquals('J', toByteArrayResult[6]);
    assertEquals('\f', toByteArrayResult[612]);
  }

  /**
   * Method under test:
   * {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int, float, String)}
   */
  @Test
  void testWriteImage18() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);

    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    boolean actualWriteImageResult = ImageIOUtil.writeImage(image, "Format Name", output, 19088743, 10.0f,
        "Compression Type");

    // Assert
    assertEquals(0, output.toByteArray().length);
    assertFalse(actualWriteImageResult);
  }

  /**
   * Method under test:
   * {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int, float, String)}
   */
  @Test
  void testWriteImage19() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);

    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    boolean actualWriteImageResult = ImageIOUtil.writeImage(image, "png", output, 19088743, 0.0f, "Compression Type");

    // Assert
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals((byte) -119, toByteArrayResult[0]);
    assertEquals((byte) -126, toByteArrayResult[89]);
    assertEquals((byte) -21, toByteArrayResult[76]);
    assertEquals((byte) -22, toByteArrayResult[75]);
    assertEquals((byte) -56, toByteArrayResult[74]);
    assertEquals((byte) -7, toByteArrayResult[77]);
    assertEquals((byte) -82, toByteArrayResult[86]);
    assertEquals((byte) 0, toByteArrayResult[10]);
    assertEquals((byte) 0, toByteArrayResult[17]);
    assertEquals((byte) 0, toByteArrayResult[18]);
    assertEquals((byte) 0, toByteArrayResult[20]);
    assertEquals((byte) 0, toByteArrayResult[21]);
    assertEquals((byte) 0, toByteArrayResult[22]);
    assertEquals((byte) 0, toByteArrayResult[68]);
    assertEquals((byte) 0, toByteArrayResult[69]);
    assertEquals((byte) 0, toByteArrayResult[70]);
    assertEquals((byte) 0, toByteArrayResult[72]);
    assertEquals((byte) 0, toByteArrayResult[78]);
    assertEquals((byte) 0, toByteArrayResult[79]);
    assertEquals((byte) 0, toByteArrayResult[8]);
    assertEquals((byte) 0, toByteArrayResult[80]);
    assertEquals((byte) 0, toByteArrayResult[81]);
    assertEquals((byte) 0, toByteArrayResult[9]);
    assertEquals((byte) 0, toByteArrayResult[Short.SIZE]);
    assertEquals((byte) 1, toByteArrayResult[19]);
    assertEquals((byte) 1, toByteArrayResult[23]);
    assertEquals((byte) 1, toByteArrayResult[73]);
    assertEquals((byte) 26, toByteArrayResult[6]);
    assertEquals((byte) 4, toByteArrayResult[71]);
    assertEquals(90, toByteArrayResult.length);
    assertTrue(actualWriteImageResult);
    assertEquals('B', toByteArrayResult[87]);
    assertEquals('D', toByteArrayResult[14]);
    assertEquals('D', toByteArrayResult[85]);
    assertEquals('E', toByteArrayResult[83]);
    assertEquals('G', toByteArrayResult[3]);
    assertEquals('H', toByteArrayResult[13]);
    assertEquals('I', toByteArrayResult[12]);
    assertEquals('I', toByteArrayResult[82]);
    assertEquals('N', toByteArrayResult[2]);
    assertEquals('N', toByteArrayResult[84]);
    assertEquals('P', toByteArrayResult[1]);
    assertEquals('R', toByteArrayResult[15]);
    assertEquals('\b', toByteArrayResult[24]);
    assertEquals('\n', toByteArrayResult[5]);
    assertEquals('\n', toByteArrayResult[7]);
    assertEquals('\r', toByteArrayResult[11]);
    assertEquals('\r', toByteArrayResult[4]);
    assertEquals('`', toByteArrayResult[65]);
    assertEquals('`', toByteArrayResult[66]);
    assertEquals('`', toByteArrayResult[67]);
    assertEquals('`', toByteArrayResult[88]);
  }

  /**
   * Method under test:
   * {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int, float, String)}
   */
  @Test
  void testWriteImage20() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);

    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    boolean actualWriteImageResult = ImageIOUtil.writeImage(image, "tif", output, 19088743, 10.0f, "");

    // Assert
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals((byte) 0, toByteArrayResult[11]);
    assertEquals((byte) 0, toByteArrayResult[12]);
    assertEquals((byte) 0, toByteArrayResult[14]);
    assertEquals((byte) 0, toByteArrayResult[15]);
    assertEquals((byte) 0, toByteArrayResult[18]);
    assertEquals((byte) 0, toByteArrayResult[184]);
    assertEquals((byte) 0, toByteArrayResult[185]);
    assertEquals((byte) 0, toByteArrayResult[186]);
    assertEquals((byte) 0, toByteArrayResult[192]);
    assertEquals((byte) 0, toByteArrayResult[193]);
    assertEquals((byte) 0, toByteArrayResult[194]);
    assertEquals((byte) 0, toByteArrayResult[2]);
    assertEquals((byte) 0, toByteArrayResult[20]);
    assertEquals((byte) 0, toByteArrayResult[202]);
    assertEquals((byte) 0, toByteArrayResult[204]);
    assertEquals((byte) 0, toByteArrayResult[21]);
    assertEquals((byte) 0, toByteArrayResult[24]);
    assertEquals((byte) 0, toByteArrayResult[4]);
    assertEquals((byte) 0, toByteArrayResult[5]);
    assertEquals((byte) 0, toByteArrayResult[6]);
    assertEquals((byte) 0, toByteArrayResult[8]);
    assertEquals((byte) 0, toByteArrayResult[Short.SIZE]);
    assertEquals((byte) 16, toByteArrayResult[207]);
    assertEquals((byte) 1, toByteArrayResult[10]);
    assertEquals((byte) 1, toByteArrayResult[17]);
    assertEquals((byte) 1, toByteArrayResult[187]);
    assertEquals((byte) 1, toByteArrayResult[188]);
    assertEquals((byte) 1, toByteArrayResult[19]);
    assertEquals((byte) 1, toByteArrayResult[195]);
    assertEquals((byte) 1, toByteArrayResult[22]);
    assertEquals((byte) 1, toByteArrayResult[23]);
    assertEquals(208, toByteArrayResult.length);
    assertEquals((byte) 3, toByteArrayResult[13]);
    assertTrue(actualWriteImageResult);
    assertEquals(Byte.MIN_VALUE, toByteArrayResult[203]);
    assertEquals(' ', toByteArrayResult[205]);
    assertEquals('#', toByteArrayResult[189]);
    assertEquals('*', toByteArrayResult[3]);
    assertEquals('B', toByteArrayResult[199]);
    assertEquals('D', toByteArrayResult[197]);
    assertEquals('E', toByteArrayResult[190]);
    assertEquals('F', toByteArrayResult[198]);
    assertEquals('M', toByteArrayResult[0]);
    assertEquals('M', toByteArrayResult[1]);
    assertEquals('O', toByteArrayResult[200]);
    assertEquals('P', toByteArrayResult[196]);
    assertEquals('P', toByteArrayResult[206]);
    assertEquals('X', toByteArrayResult[201]);
    assertEquals('\b', toByteArrayResult[7]);
    assertEquals('\r', toByteArrayResult[9]);
    assertEquals('g', toByteArrayResult[183]);
    assertEquals('g', toByteArrayResult[191]);
  }

  /**
   * Method under test:
   * {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int, float, String)}
   */
  @Test
  void testWriteImage21() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);

    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    boolean actualWriteImageResult = ImageIOUtil.writeImage(image, "tif", output, 19088743, 10.0f, null);

    // Assert
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals((byte) 0, toByteArrayResult[11]);
    assertEquals((byte) 0, toByteArrayResult[12]);
    assertEquals((byte) 0, toByteArrayResult[14]);
    assertEquals((byte) 0, toByteArrayResult[15]);
    assertEquals((byte) 0, toByteArrayResult[18]);
    assertEquals((byte) 0, toByteArrayResult[184]);
    assertEquals((byte) 0, toByteArrayResult[185]);
    assertEquals((byte) 0, toByteArrayResult[186]);
    assertEquals((byte) 0, toByteArrayResult[192]);
    assertEquals((byte) 0, toByteArrayResult[193]);
    assertEquals((byte) 0, toByteArrayResult[194]);
    assertEquals((byte) 0, toByteArrayResult[2]);
    assertEquals((byte) 0, toByteArrayResult[20]);
    assertEquals((byte) 0, toByteArrayResult[202]);
    assertEquals((byte) 0, toByteArrayResult[203]);
    assertEquals((byte) 0, toByteArrayResult[204]);
    assertEquals((byte) 0, toByteArrayResult[205]);
    assertEquals((byte) 0, toByteArrayResult[21]);
    assertEquals((byte) 0, toByteArrayResult[24]);
    assertEquals((byte) 0, toByteArrayResult[4]);
    assertEquals((byte) 0, toByteArrayResult[5]);
    assertEquals((byte) 0, toByteArrayResult[6]);
    assertEquals((byte) 0, toByteArrayResult[8]);
    assertEquals((byte) 0, toByteArrayResult[Short.SIZE]);
    assertEquals((byte) 1, toByteArrayResult[10]);
    assertEquals((byte) 1, toByteArrayResult[17]);
    assertEquals((byte) 1, toByteArrayResult[187]);
    assertEquals((byte) 1, toByteArrayResult[188]);
    assertEquals((byte) 1, toByteArrayResult[19]);
    assertEquals((byte) 1, toByteArrayResult[195]);
    assertEquals((byte) 1, toByteArrayResult[22]);
    assertEquals((byte) 1, toByteArrayResult[23]);
    assertEquals(206, toByteArrayResult.length);
    assertEquals((byte) 3, toByteArrayResult[13]);
    assertTrue(actualWriteImageResult);
    assertEquals('#', toByteArrayResult[181]);
    assertEquals('#', toByteArrayResult[189]);
    assertEquals('*', toByteArrayResult[3]);
    assertEquals('B', toByteArrayResult[199]);
    assertEquals('D', toByteArrayResult[197]);
    assertEquals('E', toByteArrayResult[182]);
    assertEquals('E', toByteArrayResult[190]);
    assertEquals('F', toByteArrayResult[198]);
    assertEquals('M', toByteArrayResult[0]);
    assertEquals('M', toByteArrayResult[1]);
    assertEquals('O', toByteArrayResult[200]);
    assertEquals('P', toByteArrayResult[196]);
    assertEquals('X', toByteArrayResult[201]);
    assertEquals('\b', toByteArrayResult[7]);
    assertEquals('\r', toByteArrayResult[9]);
    assertEquals('g', toByteArrayResult[183]);
    assertEquals('g', toByteArrayResult[191]);
  }

  /**
   * Method under test:
   * {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int, float, String)}
   */
  @Test
  void testWriteImage22() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_BINARY);

    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    boolean actualWriteImageResult = ImageIOUtil.writeImage(image, "tif", output, 19088743, 10.0f, "");

    // Assert
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals((byte) 0, toByteArrayResult[11]);
    assertEquals((byte) 0, toByteArrayResult[12]);
    assertEquals((byte) 0, toByteArrayResult[14]);
    assertEquals((byte) 0, toByteArrayResult[15]);
    assertEquals((byte) 0, toByteArrayResult[164]);
    assertEquals((byte) 0, toByteArrayResult[165]);
    assertEquals((byte) 0, toByteArrayResult[166]);
    assertEquals((byte) 0, toByteArrayResult[172]);
    assertEquals((byte) 0, toByteArrayResult[173]);
    assertEquals((byte) 0, toByteArrayResult[174]);
    assertEquals((byte) 0, toByteArrayResult[18]);
    assertEquals((byte) 0, toByteArrayResult[182]);
    assertEquals((byte) 0, toByteArrayResult[185]);
    assertEquals((byte) 0, toByteArrayResult[2]);
    assertEquals((byte) 0, toByteArrayResult[20]);
    assertEquals((byte) 0, toByteArrayResult[21]);
    assertEquals((byte) 0, toByteArrayResult[24]);
    assertEquals((byte) 0, toByteArrayResult[4]);
    assertEquals((byte) 0, toByteArrayResult[5]);
    assertEquals((byte) 0, toByteArrayResult[6]);
    assertEquals((byte) 0, toByteArrayResult[8]);
    assertEquals((byte) 0, toByteArrayResult[Short.SIZE]);
    assertEquals((byte) 16, toByteArrayResult[186]);
    assertEquals(187, toByteArrayResult.length);
    assertEquals((byte) 1, toByteArrayResult[10]);
    assertEquals((byte) 1, toByteArrayResult[167]);
    assertEquals((byte) 1, toByteArrayResult[168]);
    assertEquals((byte) 1, toByteArrayResult[17]);
    assertEquals((byte) 1, toByteArrayResult[175]);
    assertEquals((byte) 1, toByteArrayResult[184]);
    assertEquals((byte) 1, toByteArrayResult[19]);
    assertEquals((byte) 1, toByteArrayResult[22]);
    assertEquals((byte) 1, toByteArrayResult[23]);
    assertEquals((byte) 3, toByteArrayResult[13]);
    assertTrue(actualWriteImageResult);
    assertEquals('#', toByteArrayResult[169]);
    assertEquals('*', toByteArrayResult[3]);
    assertEquals('B', toByteArrayResult[179]);
    assertEquals('D', toByteArrayResult[177]);
    assertEquals('E', toByteArrayResult[162]);
    assertEquals('E', toByteArrayResult[170]);
    assertEquals('F', toByteArrayResult[178]);
    assertEquals('M', toByteArrayResult[0]);
    assertEquals('M', toByteArrayResult[1]);
    assertEquals('O', toByteArrayResult[180]);
    assertEquals('P', toByteArrayResult[176]);
    assertEquals('P', toByteArrayResult[183]);
    assertEquals('X', toByteArrayResult[181]);
    assertEquals('\b', toByteArrayResult[7]);
    assertEquals('\f', toByteArrayResult[9]);
    assertEquals('g', toByteArrayResult[163]);
    assertEquals('g', toByteArrayResult[171]);
  }

  /**
   * Method under test:
   * {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int, float, String)}
   */
  @Test
  void testWriteImage23() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);

    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    boolean actualWriteImageResult = ImageIOUtil.writeImage(image, "jpeg", output, 1, 0.0f, "Compression Type");

    // Assert
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals((byte) -114, toByteArrayResult[623]);
    assertEquals((byte) -118, toByteArrayResult[624]);
    assertEquals((byte) -1, toByteArrayResult[0]);
    assertEquals((byte) -1, toByteArrayResult[2]);
    assertEquals((byte) -1, toByteArrayResult[20]);
    assertEquals((byte) -1, toByteArrayResult[609]);
    assertEquals((byte) -1, toByteArrayResult[628]);
    assertEquals((byte) -32, toByteArrayResult[3]);
    assertEquals((byte) -37, toByteArrayResult[21]);
    assertEquals((byte) -38, toByteArrayResult[610]);
    assertEquals((byte) -39, toByteArrayResult[629]);
    assertEquals((byte) -40, toByteArrayResult[1]);
    assertEquals((byte) -6, toByteArrayResult[608]);
    assertEquals((byte) -7, toByteArrayResult[607]);
    assertEquals((byte) -8, toByteArrayResult[606]);
    assertEquals((byte) -96, toByteArrayResult[626]);
    assertEquals((byte) -9, toByteArrayResult[605]);
    assertEquals((byte) 0, toByteArrayResult[10]);
    assertEquals((byte) 0, toByteArrayResult[14]);
    assertEquals((byte) 0, toByteArrayResult[18]);
    assertEquals((byte) 0, toByteArrayResult[19]);
    assertEquals((byte) 0, toByteArrayResult[22]);
    assertEquals((byte) 0, toByteArrayResult[24]);
    assertEquals((byte) 0, toByteArrayResult[4]);
    assertEquals((byte) 0, toByteArrayResult[611]);
    assertEquals((byte) 0, toByteArrayResult[615]);
    assertEquals((byte) 0, toByteArrayResult[620]);
    assertEquals((byte) 0, toByteArrayResult[622]);
    assertEquals((byte) 0, toByteArrayResult[Short.SIZE]);
    assertEquals((byte) 15, toByteArrayResult[627]);
    assertEquals((byte) 16, toByteArrayResult[5]);
    assertEquals((byte) 17, toByteArrayResult[617]);
    assertEquals((byte) 17, toByteArrayResult[619]);
    assertEquals((byte) 1, toByteArrayResult[11]);
    assertEquals((byte) 1, toByteArrayResult[13]);
    assertEquals((byte) 1, toByteArrayResult[15]);
    assertEquals((byte) 1, toByteArrayResult[17]);
    assertEquals((byte) 1, toByteArrayResult[614]);
    assertEquals((byte) 2, toByteArrayResult[12]);
    assertEquals((byte) 2, toByteArrayResult[616]);
    assertEquals((byte) 3, toByteArrayResult[613]);
    assertEquals((byte) 3, toByteArrayResult[618]);
    assertEquals(630, toByteArrayResult.length);
    assertTrue(actualWriteImageResult);
    assertEquals('(', toByteArrayResult[625]);
    assertEquals('?', toByteArrayResult[621]);
    assertEquals('C', toByteArrayResult[23]);
    assertEquals('F', toByteArrayResult[7]);
    assertEquals('F', toByteArrayResult[9]);
    assertEquals('I', toByteArrayResult[8]);
    assertEquals('J', toByteArrayResult[6]);
    assertEquals('\f', toByteArrayResult[612]);
  }
}
