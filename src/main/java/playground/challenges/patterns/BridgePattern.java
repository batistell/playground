package playground.challenges.patterns;

/**
 * DP05: Bridge (Controle Remoto de Dispositivo)
 * 
 * O padrão Bridge desacopla uma abstração de sua implementação, de modo que as duas
 * possam variar independentemente. É excelente para evitar a explosão de subclasses
 * quando se tem dimensões ortogonais.
 * 
 * Exercício:
 * Implemente o controle remoto (`RemoteControl` e `AdvancedRemoteControl`) que interage
 * com diferentes dispositivos (`Tv` e `Radio`) através da interface comum `Device`.
 */
public class BridgePattern {

    // Implementador comum
    public interface Device {
        boolean isEnabled();
        void enable();
        void disable();
        int getVolume();
        void setVolume(int percent);
    }

    // Dispositivo Concreto: TV
    public static class Tv implements Device {
        private boolean on = false;
        private int volume = 30;

        @Override public boolean isEnabled() { return on; }
        @Override public void enable() { on = true; }
        @Override public void disable() { on = false; }
        @Override public int getVolume() { return volume; }
        @Override public void setVolume(int percent) { this.volume = Math.max(0, Math.min(100, percent)); }
    }

    // Dispositivo Concreto: Radio
    public static class Radio implements Device {
        private boolean on = false;
        private int volume = 10;

        @Override public boolean isEnabled() { return on; }
        @Override public void enable() { on = true; }
        @Override public void disable() { on = false; }
        @Override public int getVolume() { return volume; }
        @Override public void setVolume(int percent) { this.volume = Math.max(0, Math.min(100, percent)); }
    }

    // Abstração base do Controle Remoto
    public static class RemoteControl {
        protected final Device device;

        public RemoteControl(Device device) {
            this.device = device;
        }

        public void togglePower() {
            // TODO: Se o dispositivo estiver ligado, desligue-o; caso contrário, ligue-o.
        }

        public void volumeDown() {
            // TODO: Diminua o volume do dispositivo em 10%.
        }

        public void volumeUp() {
            // TODO: Aumente o volume do dispositivo em 10%.
        }
    }

    // Abstração Refinada
    public static class AdvancedRemoteControl extends RemoteControl {
        
        public AdvancedRemoteControl(Device device) {
            super(device);
        }

        public void mute() {
            // TODO: Zere o volume do dispositivo.
        }
    }
}
