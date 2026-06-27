package playground.challenges.patterns;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BridgePatternTest {

    @Test
    public void testBridge_TvPower() {
        BridgePattern.Device tv = new BridgePattern.Tv();
        BridgePattern.RemoteControl remote = new BridgePattern.RemoteControl(tv);

        assertFalse(tv.isEnabled());
        remote.togglePower();
        assertTrue(tv.isEnabled());
        remote.togglePower();
        assertFalse(tv.isEnabled());
    }

    @Test
    public void testBridge_RadioVolume() {
        BridgePattern.Device radio = new BridgePattern.Radio();
        BridgePattern.RemoteControl remote = new BridgePattern.RemoteControl(radio);

        assertEquals(10, radio.getVolume());
        remote.volumeUp();
        assertEquals(20, radio.getVolume());
        remote.volumeDown();
        assertEquals(10, radio.getVolume());
    }

    @Test
    public void testBridge_AdvancedMute() {
        BridgePattern.Device tv = new BridgePattern.Tv();
        BridgePattern.AdvancedRemoteControl advRemote = new BridgePattern.AdvancedRemoteControl(tv);

        assertEquals(30, tv.getVolume());
        advRemote.mute();
        assertEquals(0, tv.getVolume());
    }
}
