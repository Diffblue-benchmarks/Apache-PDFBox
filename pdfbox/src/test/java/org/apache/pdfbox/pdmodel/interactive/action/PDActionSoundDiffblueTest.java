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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDActionSoundDiffblueTest {
  /**
   * Test {@link PDActionSound#PDActionSound(COSDictionary)}.
   * <p>
   * Method under test: {@link PDActionSound#PDActionSound(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDActionSound(COSDictionary)")
  void testNewPDActionSound() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new PDActionSound(a)).getCOSObject());
  }

  /**
   * Test {@link PDActionSound#PDActionSound()}.
   * <p>
   * Method under test: {@link PDActionSound#PDActionSound()}
   */
  @Test
  @DisplayName("Test new PDActionSound()")
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

  /**
   * Test {@link PDActionSound#setSound(COSStream)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#setSound(COSStream)}
   */
  @Test
  @DisplayName("Test setSound(COSStream); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetSound_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
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
   * Test {@link PDActionSound#setSound(COSStream)}.
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDActionSound#PDActionSound()} Sound is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#setSound(COSStream)}
   */
  @Test
  @DisplayName("Test setSound(COSStream); given PDActionSound(); when 'null'; then PDActionSound() Sound is 'null'")
  void testSetSound_givenPDActionSound_whenNull_thenPDActionSoundSoundIsNull() {
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
   * Test {@link PDActionSound#setSound(COSStream)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSStream#COSStream()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#setSound(COSStream)}
   */
  @Test
  @DisplayName("Test setSound(COSStream); given 'true'; when COSStream() Direct is 'true'")
  void testSetSound_givenTrue_whenCOSStreamDirectIsTrue() {
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
   * Test {@link PDActionSound#setSound(COSStream)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then {@link PDActionSound#PDActionSound()} COSObject Values size is
   * three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#setSound(COSStream)}
   */
  @Test
  @DisplayName("Test setSound(COSStream); when COSStream(); then PDActionSound() COSObject Values size is three")
  void testSetSound_whenCOSStream_thenPDActionSoundCOSObjectValuesSizeIsThree() {
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
   * Test {@link PDActionSound#getSound()}.
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()} Sound is
   * {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#getSound()}
   */
  @Test
  @DisplayName("Test getSound(); given PDActionSound() Sound is COSStream(); then return COSStream()")
  void testGetSound_givenPDActionSoundSoundIsCOSStream_thenReturnCOSStream() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();
    COSStream sound = new COSStream();
    pdActionSound.setSound(sound);

    // Act and Assert
    assertSame(sound, pdActionSound.getSound());
  }

  /**
   * Test {@link PDActionSound#getSound()}.
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound(COSDictionary)} with a is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#getSound()}
   */
  @Test
  @DisplayName("Test getSound(); given PDActionSound(COSDictionary) with a is COSDictionary(); then return 'null'")
  void testGetSound_givenPDActionSoundWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDActionSound(new COSDictionary())).getSound());
  }

  /**
   * Test {@link PDActionSound#getSound()}.
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#getSound()}
   */
  @Test
  @DisplayName("Test getSound(); given PDActionSound(); then return 'null'")
  void testGetSound_givenPDActionSound_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDActionSound()).getSound());
  }

  /**
   * Test {@link PDActionSound#getSound()}.
   * <ul>
   *   <li>Then return Key is {@link COSObjectKey#COSObjectKey(long, int)} with num
   * is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#getSound()}
   */
  @Test
  @DisplayName("Test getSound(); then return Key is COSObjectKey(long, int) with num is one and gen is one")
  void testGetSound_thenReturnKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSStream sound = new COSStream();
    COSObjectKey key = new COSObjectKey(1L, 1);

    sound.setKey(key);

    PDActionSound pdActionSound = new PDActionSound();
    pdActionSound.setSound(sound);

    // Act and Assert
    assertSame(key, pdActionSound.getSound().getKey());
  }

  /**
   * Test {@link PDActionSound#setVolume(float)}.
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()}.</li>
   *   <li>When {@code -1.0000001}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#setVolume(float)}
   */
  @Test
  @DisplayName("Test setVolume(float); given PDActionSound(); when '-1.0000001'; then throw IllegalArgumentException")
  void testSetVolume_givenPDActionSound_when10000001_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDActionSound()).setVolume(-1.0000001f));
  }

  /**
   * Test {@link PDActionSound#setVolume(float)}.
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()}.</li>
   *   <li>When minus one.</li>
   *   <li>Then {@link PDActionSound#PDActionSound()} Volume is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#setVolume(float)}
   */
  @Test
  @DisplayName("Test setVolume(float); given PDActionSound(); when minus one; then PDActionSound() Volume is minus one")
  void testSetVolume_givenPDActionSound_whenMinusOne_thenPDActionSoundVolumeIsMinusOne() {
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
   * Test {@link PDActionSound#setVolume(float)}.
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()}.</li>
   *   <li>When ten.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#setVolume(float)}
   */
  @Test
  @DisplayName("Test setVolume(float); given PDActionSound(); when ten; then throw IllegalArgumentException")
  void testSetVolume_givenPDActionSound_whenTen_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDActionSound()).setVolume(10.0f));
  }

  /**
   * Test {@link PDActionSound#getVolume()}.
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()} Volume is one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#getVolume()}
   */
  @Test
  @DisplayName("Test getVolume(); given PDActionSound() Volume is one; then return one")
  void testGetVolume_givenPDActionSoundVolumeIsOne_thenReturnOne() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();
    pdActionSound.setVolume(1.0f);

    // Act and Assert
    assertEquals(1.0f, pdActionSound.getVolume());
  }

  /**
   * Test {@link PDActionSound#getVolume()}.
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound(COSDictionary)} with a is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#getVolume()}
   */
  @Test
  @DisplayName("Test getVolume(); given PDActionSound(COSDictionary) with a is COSDictionary(); then return one")
  void testGetVolume_givenPDActionSoundWithAIsCOSDictionary_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDActionSound(new COSDictionary())).getVolume());
  }

  /**
   * Test {@link PDActionSound#getVolume()}.
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#getVolume()}
   */
  @Test
  @DisplayName("Test getVolume(); given PDActionSound(); then return one")
  void testGetVolume_givenPDActionSound_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDActionSound()).getVolume());
  }

  /**
   * Test {@link PDActionSound#setSynchronous(boolean)}.
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()}.</li>
   *   <li>When {@code false}.</li>
   *   <li>Then not {@link PDActionSound#PDActionSound()} Synchronous.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#setSynchronous(boolean)}
   */
  @Test
  @DisplayName("Test setSynchronous(boolean); given PDActionSound(); when 'false'; then not PDActionSound() Synchronous")
  void testSetSynchronous_givenPDActionSound_whenFalse_thenNotPDActionSoundSynchronous() {
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
   * Test {@link PDActionSound#setSynchronous(boolean)}.
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()}.</li>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link PDActionSound#PDActionSound()} Synchronous.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#setSynchronous(boolean)}
   */
  @Test
  @DisplayName("Test setSynchronous(boolean); given PDActionSound(); when 'true'; then PDActionSound() Synchronous")
  void testSetSynchronous_givenPDActionSound_whenTrue_thenPDActionSoundSynchronous() {
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
   * Test {@link PDActionSound#getSynchronous()}.
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()} Synchronous is
   * {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#getSynchronous()}
   */
  @Test
  @DisplayName("Test getSynchronous(); given PDActionSound() Synchronous is 'false'; then return 'false'")
  void testGetSynchronous_givenPDActionSoundSynchronousIsFalse_thenReturnFalse() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();
    pdActionSound.setSynchronous(false);

    // Act and Assert
    assertFalse(pdActionSound.getSynchronous());
  }

  /**
   * Test {@link PDActionSound#getSynchronous()}.
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()} Synchronous is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#getSynchronous()}
   */
  @Test
  @DisplayName("Test getSynchronous(); given PDActionSound() Synchronous is 'true'; then return 'true'")
  void testGetSynchronous_givenPDActionSoundSynchronousIsTrue_thenReturnTrue() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();
    pdActionSound.setSynchronous(true);

    // Act and Assert
    assertTrue(pdActionSound.getSynchronous());
  }

  /**
   * Test {@link PDActionSound#getSynchronous()}.
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound(COSDictionary)} with a is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#getSynchronous()}
   */
  @Test
  @DisplayName("Test getSynchronous(); given PDActionSound(COSDictionary) with a is COSDictionary(); then return 'false'")
  void testGetSynchronous_givenPDActionSoundWithAIsCOSDictionary_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDActionSound(new COSDictionary())).getSynchronous());
  }

  /**
   * Test {@link PDActionSound#getSynchronous()}.
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#getSynchronous()}
   */
  @Test
  @DisplayName("Test getSynchronous(); given PDActionSound(); then return 'false'")
  void testGetSynchronous_givenPDActionSound_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDActionSound()).getSynchronous());
  }

  /**
   * Test {@link PDActionSound#setRepeat(boolean)}.
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()}.</li>
   *   <li>When {@code false}.</li>
   *   <li>Then not {@link PDActionSound#PDActionSound()} Repeat.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#setRepeat(boolean)}
   */
  @Test
  @DisplayName("Test setRepeat(boolean); given PDActionSound(); when 'false'; then not PDActionSound() Repeat")
  void testSetRepeat_givenPDActionSound_whenFalse_thenNotPDActionSoundRepeat() {
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
   * Test {@link PDActionSound#setRepeat(boolean)}.
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()}.</li>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link PDActionSound#PDActionSound()} Repeat.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#setRepeat(boolean)}
   */
  @Test
  @DisplayName("Test setRepeat(boolean); given PDActionSound(); when 'true'; then PDActionSound() Repeat")
  void testSetRepeat_givenPDActionSound_whenTrue_thenPDActionSoundRepeat() {
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
   * Test {@link PDActionSound#getRepeat()}.
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()} Repeat is {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#getRepeat()}
   */
  @Test
  @DisplayName("Test getRepeat(); given PDActionSound() Repeat is 'false'; then return 'false'")
  void testGetRepeat_givenPDActionSoundRepeatIsFalse_thenReturnFalse() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();
    pdActionSound.setRepeat(false);

    // Act and Assert
    assertFalse(pdActionSound.getRepeat());
  }

  /**
   * Test {@link PDActionSound#getRepeat()}.
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()} Repeat is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#getRepeat()}
   */
  @Test
  @DisplayName("Test getRepeat(); given PDActionSound() Repeat is 'true'; then return 'true'")
  void testGetRepeat_givenPDActionSoundRepeatIsTrue_thenReturnTrue() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();
    pdActionSound.setRepeat(true);

    // Act and Assert
    assertTrue(pdActionSound.getRepeat());
  }

  /**
   * Test {@link PDActionSound#getRepeat()}.
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound(COSDictionary)} with a is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#getRepeat()}
   */
  @Test
  @DisplayName("Test getRepeat(); given PDActionSound(COSDictionary) with a is COSDictionary(); then return 'false'")
  void testGetRepeat_givenPDActionSoundWithAIsCOSDictionary_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDActionSound(new COSDictionary())).getRepeat());
  }

  /**
   * Test {@link PDActionSound#getRepeat()}.
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#getRepeat()}
   */
  @Test
  @DisplayName("Test getRepeat(); given PDActionSound(); then return 'false'")
  void testGetRepeat_givenPDActionSound_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDActionSound()).getRepeat());
  }

  /**
   * Test {@link PDActionSound#setMix(boolean)}.
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()}.</li>
   *   <li>When {@code false}.</li>
   *   <li>Then not {@link PDActionSound#PDActionSound()} Mix.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#setMix(boolean)}
   */
  @Test
  @DisplayName("Test setMix(boolean); given PDActionSound(); when 'false'; then not PDActionSound() Mix")
  void testSetMix_givenPDActionSound_whenFalse_thenNotPDActionSoundMix() {
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
   * Test {@link PDActionSound#setMix(boolean)}.
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()}.</li>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link PDActionSound#PDActionSound()} Mix.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#setMix(boolean)}
   */
  @Test
  @DisplayName("Test setMix(boolean); given PDActionSound(); when 'true'; then PDActionSound() Mix")
  void testSetMix_givenPDActionSound_whenTrue_thenPDActionSoundMix() {
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
   * Test {@link PDActionSound#getMix()}.
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()} Mix is {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#getMix()}
   */
  @Test
  @DisplayName("Test getMix(); given PDActionSound() Mix is 'false'; then return 'false'")
  void testGetMix_givenPDActionSoundMixIsFalse_thenReturnFalse() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();
    pdActionSound.setMix(false);

    // Act and Assert
    assertFalse(pdActionSound.getMix());
  }

  /**
   * Test {@link PDActionSound#getMix()}.
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()} Mix is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#getMix()}
   */
  @Test
  @DisplayName("Test getMix(); given PDActionSound() Mix is 'true'; then return 'true'")
  void testGetMix_givenPDActionSoundMixIsTrue_thenReturnTrue() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();
    pdActionSound.setMix(true);

    // Act and Assert
    assertTrue(pdActionSound.getMix());
  }

  /**
   * Test {@link PDActionSound#getMix()}.
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound(COSDictionary)} with a is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#getMix()}
   */
  @Test
  @DisplayName("Test getMix(); given PDActionSound(COSDictionary) with a is COSDictionary(); then return 'false'")
  void testGetMix_givenPDActionSoundWithAIsCOSDictionary_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDActionSound(new COSDictionary())).getMix());
  }

  /**
   * Test {@link PDActionSound#getMix()}.
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionSound#getMix()}
   */
  @Test
  @DisplayName("Test getMix(); given PDActionSound(); then return 'false'")
  void testGetMix_givenPDActionSound_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDActionSound()).getMix());
  }
}
