package playground.challenges.practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("PT03 - Montador de Veículos")
public class VehicleAssemblerTest {

    @Test
    @DisplayName("Caso 1: Montar veículo completo com sucesso")
    public void testSuccessfulBuild() {
        VehicleAssembler.Vehicle vehicle = new VehicleAssembler.Builder()
                .model("Sedan X")
                .engine("2.0 Turbo")
                .color("Preto")
                .airConditioning(true)
                .sunroof(true)
                .build();

        assertNotNull(vehicle);
        assertEquals("Sedan X", vehicle.getModel());
        assertEquals("2.0 Turbo", vehicle.getEngine());
        assertEquals("Preto", vehicle.getColor());
        assertTrue(vehicle.hasAirConditioning());
        assertTrue(vehicle.hasSunroof());
    }

    @Test
    @DisplayName("Caso 2: Montar veículo com valores padrão")
    public void testDefaultValues() {
        VehicleAssembler.Vehicle vehicle = new VehicleAssembler.Builder()
                .model("SUV Y")
                .engine("1.6")
                .build();

        assertNotNull(vehicle);
        assertEquals("SUV Y", vehicle.getModel());
        assertEquals("1.6", vehicle.getEngine());
        assertEquals("Branco", vehicle.getColor()); // Padrão
        assertFalse(vehicle.hasAirConditioning());  // Padrão
        assertFalse(vehicle.hasSunroof());          // Padrão
    }

    @Test
    @DisplayName("Caso 3: Falha na montagem por falta de parâmetros obrigatórios")
    public void testBuildFailure() {
        VehicleAssembler.Builder builderNoModel = new VehicleAssembler.Builder().engine("V8");
        assertThrows(IllegalStateException.class, builderNoModel::build);

        VehicleAssembler.Builder builderNoEngine = new VehicleAssembler.Builder().model("Esportivo Z");
        assertThrows(IllegalStateException.class, builderNoEngine::build);
    }
}
