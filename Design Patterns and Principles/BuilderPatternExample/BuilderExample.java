public class BuilderExample {

    // Computer class with Builder
    static class Computer {
        private String CPU;
        private String RAM;
        private String storage;
        private String graphicsCard;

        // Private constructor called by Builder
        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.storage = builder.storage;
            this.graphicsCard = builder.graphicsCard;
        }

        public void showConfig() {
            System.out.println("CPU: " + CPU);
            System.out.println("RAM: " + RAM);
            System.out.println("Storage: " + storage);
            System.out.println("Graphics Card: " + graphicsCard);
        }

        // Static nested Builder class
        static class Builder {
            private String CPU;
            private String RAM;
            private String storage;
            private String graphicsCard;

            public Builder setCPU(String CPU) {
                this.CPU = CPU;
                return this;
            }

            public Builder setRAM(String RAM) {
                this.RAM = RAM;
                return this;
            }

            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            public Builder setGraphicsCard(String graphicsCard) {
                this.graphicsCard = graphicsCard;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }
    }

    // Main method inside same file
    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder()
                .setCPU("Intel i3")
                .setRAM("8GB")
                .build();

        Computer gamingComputer = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4090")
                .build();

        System.out.println("Basic Computer Configuration:");
        basicComputer.showConfig();

        System.out.println("\nGaming Computer Configuration:");
        gamingComputer.showConfig();
    }
}
