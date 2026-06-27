package playground.challenges.patterns;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("DP05 - Bridge (Controle Remoto de Dispositivo)")
public class BridgePatternTest {

    @Test
    @DisplayName("Caso 1: Ligar e desligar TV pelo Controle Remoto")
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
    @DisplayName("Caso 2: Alterar volume do Rádio pelo Controle Remoto")
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
    @DisplayName("Caso 3: Mudar volume da TV para mudo usando Controle Remoto Avançado")
    public void testBridge_AdvancedMute() {
        BridgePattern.Device tv = new BridgePattern.Tv();
        BridgePattern.AdvancedRemoteControl advRemote = new BridgePattern.AdvancedRemoteControl(tv);

        assertEquals(30, tv.getVolume());
        advRemote.mute();
        assertEquals(0, tv.getVolume());
    }
}
