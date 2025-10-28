package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;

class PDActionSoundDiffblueTest {
  /**
   * Method under test: {@link PDActionSound#setSound(COSStream)}
   */
  @Test
  void testSetSound() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();
    COSStream sound = new COSStream();

    // Act
    pdActionSound.setSound(sound);

    // Assert
    COSDictionary cOSObject = pdActionSound.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(sound, pdActionSound.getSound());
  }

  /**
   * Method under test: {@link PDActionSound#setSound(COSStream)}
   */
  @Test
  void testSetSound2() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();

    // Act
    pdActionSound.setSound(null);

    // Assert
    assertNull(pdActionSound.getSound());
    COSDictionary cOSObject = pdActionSound.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDActionSound#setSound(COSStream)}
   */
  @Test
  void testSetSound3() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();

    COSStream sound = new COSStream();
    sound.setDirect(true);

    // Act
    pdActionSound.setSound(sound);

    // Assert
    COSDictionary cOSObject = pdActionSound.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(sound, pdActionSound.getSound());
  }

  /**
   * Method under test: {@link PDActionSound#setSound(COSStream)}
   */
  @Test
  void testSetSound4() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();

    COSStream sound = new COSStream();
    sound.setKey(new COSObjectKey(1L, 1));

    // Act
    pdActionSound.setSound(sound);

    // Assert
    COSDictionary cOSObject = pdActionSound.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(sound, pdActionSound.getSound());
  }

  /**
   * Method under test: {@link PDActionSound#getSound()}
   */
  @Test
  void testGetSound() {
    // Arrange, Act and Assert
    assertNull((new PDActionSound()).getSound());
  }

  /**
   * Method under test: {@link PDActionSound#getSound()}
   */
  @Test
  void testGetSound2() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();
    COSStream sound = new COSStream();
    pdActionSound.setSound(sound);

    // Act and Assert
    assertSame(sound, pdActionSound.getSound());
  }

  /**
   * Method under test: {@link PDActionSound#getSound()}
   */
  @Test
  void testGetSound3() {
    // Arrange
    COSStream sound = new COSStream();
    sound.setKey(new COSObjectKey(1L, 1));

    PDActionSound pdActionSound = new PDActionSound();
    pdActionSound.setSound(sound);

    // Act and Assert
    assertSame(sound, pdActionSound.getSound());
  }

  /**
   * Method under test: {@link PDActionSound#setVolume(float)}
   */
  @Test
  void testSetVolume() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDActionSound()).setVolume(10.0f));
    assertThrows(IllegalArgumentException.class, () -> (new PDActionSound()).setVolume(-1.0000001f));
  }

  /**
   * Method under test: {@link PDActionSound#setVolume(float)}
   */
  @Test
  void testSetVolume2() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();

    // Act
    pdActionSound.setVolume(-1.0f);

    // Assert
    assertEquals(-1.0f, pdActionSound.getVolume());
    COSDictionary cOSObject = pdActionSound.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDActionSound#getVolume()}
   */
  @Test
  void testGetVolume() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDActionSound()).getVolume());
  }

  /**
   * Method under test: {@link PDActionSound#getVolume()}
   */
  @Test
  void testGetVolume2() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();
    pdActionSound.setVolume(1.0f);

    // Act and Assert
    assertEquals(1.0f, pdActionSound.getVolume());
  }

  /**
   * Method under test: {@link PDActionSound#setSynchronous(boolean)}
   */
  @Test
  void testSetSynchronous() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();

    // Act
    pdActionSound.setSynchronous(true);

    // Assert
    COSDictionary cOSObject = pdActionSound.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdActionSound.getSynchronous());
  }

  /**
   * Method under test: {@link PDActionSound#setSynchronous(boolean)}
   */
  @Test
  void testSetSynchronous2() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();

    // Act
    pdActionSound.setSynchronous(false);

    // Assert
    COSDictionary cOSObject = pdActionSound.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdActionSound.getSynchronous());
  }

  /**
   * Method under test: {@link PDActionSound#getSynchronous()}
   */
  @Test
  void testGetSynchronous() {
    // Arrange, Act and Assert
    assertFalse((new PDActionSound()).getSynchronous());
  }

  /**
   * Method under test: {@link PDActionSound#getSynchronous()}
   */
  @Test
  void testGetSynchronous2() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();
    pdActionSound.setSynchronous(true);

    // Act and Assert
    assertTrue(pdActionSound.getSynchronous());
  }

  /**
   * Method under test: {@link PDActionSound#getSynchronous()}
   */
  @Test
  void testGetSynchronous3() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();
    pdActionSound.setSynchronous(false);

    // Act and Assert
    assertFalse(pdActionSound.getSynchronous());
  }

  /**
   * Method under test: {@link PDActionSound#setRepeat(boolean)}
   */
  @Test
  void testSetRepeat() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();

    // Act
    pdActionSound.setRepeat(true);

    // Assert
    COSDictionary cOSObject = pdActionSound.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdActionSound.getRepeat());
  }

  /**
   * Method under test: {@link PDActionSound#setRepeat(boolean)}
   */
  @Test
  void testSetRepeat2() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();

    // Act
    pdActionSound.setRepeat(false);

    // Assert
    COSDictionary cOSObject = pdActionSound.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdActionSound.getRepeat());
  }

  /**
   * Method under test: {@link PDActionSound#getRepeat()}
   */
  @Test
  void testGetRepeat() {
    // Arrange, Act and Assert
    assertFalse((new PDActionSound()).getRepeat());
  }

  /**
   * Method under test: {@link PDActionSound#getRepeat()}
   */
  @Test
  void testGetRepeat2() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();
    pdActionSound.setRepeat(true);

    // Act and Assert
    assertTrue(pdActionSound.getRepeat());
  }

  /**
   * Method under test: {@link PDActionSound#getRepeat()}
   */
  @Test
  void testGetRepeat3() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();
    pdActionSound.setRepeat(false);

    // Act and Assert
    assertFalse(pdActionSound.getRepeat());
  }

  /**
   * Method under test: {@link PDActionSound#setMix(boolean)}
   */
  @Test
  void testSetMix() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();

    // Act
    pdActionSound.setMix(true);

    // Assert
    COSDictionary cOSObject = pdActionSound.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdActionSound.getMix());
  }

  /**
   * Method under test: {@link PDActionSound#setMix(boolean)}
   */
  @Test
  void testSetMix2() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();

    // Act
    pdActionSound.setMix(false);

    // Assert
    COSDictionary cOSObject = pdActionSound.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdActionSound.getMix());
  }

  /**
   * Method under test: {@link PDActionSound#getMix()}
   */
  @Test
  void testGetMix() {
    // Arrange, Act and Assert
    assertFalse((new PDActionSound()).getMix());
  }

  /**
   * Method under test: {@link PDActionSound#getMix()}
   */
  @Test
  void testGetMix2() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();
    pdActionSound.setMix(true);

    // Act and Assert
    assertTrue(pdActionSound.getMix());
  }

  /**
   * Method under test: {@link PDActionSound#getMix()}
   */
  @Test
  void testGetMix3() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();
    pdActionSound.setMix(false);

    // Act and Assert
    assertFalse(pdActionSound.getMix());
  }

  /**
   * Method under test: {@link PDActionSound#PDActionSound(COSDictionary)}
   */
  @Test
  void testNewPDActionSound() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new PDActionSound(a)).getCOSObject());
  }

  /**
   * Method under test: {@link PDActionSound#PDActionSound()}
   */
  @Test
  void testNewPDActionSound2() {
    // Arrange and Act
    PDActionSound actualPdActionSound = new PDActionSound();

    // Assert
    assertNull(actualPdActionSound.getNext());
    COSDictionary cOSObject = actualPdActionSound.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdActionSound.getSound());
    assertEquals(1.0f, actualPdActionSound.getVolume());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdActionSound.getMix());
    assertFalse(actualPdActionSound.getRepeat());
    assertFalse(actualPdActionSound.getSynchronous());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPdActionSound.getType());
    assertEquals(PDActionSound.SUB_TYPE, actualPdActionSound.getSubType());
  }
}
