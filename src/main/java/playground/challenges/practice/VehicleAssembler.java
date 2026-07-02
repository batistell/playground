package playground.challenges.practice;

/**
 * PT03: Montador de Veículos
 * 
 * Requisito:
 * Você precisa criar uma representação para objetos complexos do tipo `Vehicle`.
 * Um veículo possui parâmetros obrigatórios (modelo, motor) e opcionais (cor, ar-condicionado, teto-solar).
 * Evite criar múltiplos construtores sobrecarregados e forneça uma interface passo a passo e
 * fluida para a montagem de objetos válidos.
 * 
 * Exercício:
 * Implemente a estrutura de montagem fluida para a classe Vehicle.
 */
public class VehicleAssembler {

    public static class Vehicle {
        private final String model;
        private final String engine;
        private final String color;
        private final boolean hasAirConditioning;
        private final boolean hasSunroof;

        // Construtor privado para ser chamado apenas pelo montador.
        private Vehicle(String model, String engine, String color, boolean hasAirConditioning, boolean hasSunroof) {
            this.model = model;
            this.engine = engine;
            this.color = color;
            this.hasAirConditioning = hasAirConditioning;
            this.hasSunroof = hasSunroof;
        }

        public String getModel() { return model; }
        public String getEngine() { return engine; }
        public String getColor() { return color; }
        public boolean hasAirConditioning() { return hasAirConditioning; }
        public boolean hasSunroof() { return hasSunroof; }
    }

    // TODO: Implemente a classe Builder para construir objetos do tipo Vehicle de forma fluida.
    // - Métodos de configuração: model(String), engine(String), color(String), airConditioning(boolean), sunroof(boolean).
    // - Método de criação: build() retornando o Vehicle final.
    // - O modelo e motor são obrigatórios (lance IllegalStateException no build() se não forem fornecidos).
    // - A cor padrão deve ser "Branco" e os booleanos falsos se não forem definidos.
    public static class Builder {
        private String model;
        private String engine;
        private String color = "Branco";
        private boolean hasAirConditioning;
        private boolean hasSunroof;

        public Builder model(String model) {
            // TODO: Configure o modelo.
            this.model = model;
            return this;
        }

        public Builder engine(String engine) {
            // TODO: Configure o motor.
            this.engine = engine;
            return this;
        }

        public Builder color(String color) {
            // TODO: Configure a cor.
            this.color = color;
            return this;
        }

        public Builder airConditioning(boolean hasAirConditioning) {
            // TODO: Configure ar-condicionado.
            this.hasAirConditioning = hasAirConditioning;
            return this;
        }

        public Builder sunroof(boolean hasSunroof) {
            // TODO: Configure teto-solar.
            this.hasSunroof = hasSunroof;
            return this;
        }

        public Vehicle build() {
            // TODO: Valide os parâmetros obrigatórios e retorne o Vehicle final.
            if (model == null ||
            engine == null) throw new IllegalStateException();
            return new Vehicle(model,
                    engine,
                    color,
                    hasAirConditioning,
                    hasSunroof);
        }
    }
}
