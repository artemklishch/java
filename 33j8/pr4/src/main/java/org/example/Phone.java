package org.example;

public class Phone {
    private double memory;
    private double screenDiagonal;
    private double batteryLife;
    private String marker;
    private String model;

    private Phone(Builder builder) {
       this.memory = builder.memory;
       this.marker = builder.marker;
       this.batteryLife = builder.batteryLife;
       this.model = builder.model;
       this.screenDiagonal = builder.screenDiagonal;
    }
    static class Builder {
        private double memory;
        private double screenDiagonal;
        private double batteryLife;
        private String marker;
        private String model;

        public Phone build() {
            return new Phone(this);
        }
        public Builder(java.lang.String marker) {
            this.marker = marker;
        }

        public Builder setModel(java.lang.String model) {
            this.model = model;
            return this;
        }


        public Builder setMemory(double memory) {
            this.memory = memory;
            return this;
        }

        public Builder setScreenDiagonal(double screenDiagonal) {
            this.screenDiagonal = screenDiagonal;
            return this;
        }

        public Builder setBatteryLife(double batteryLife) {
            this.batteryLife = batteryLife;
            return this;
        }

        public Builder setMarker(java.lang.String marker) {
            this.marker = marker;
            return this;
        }

        public double getMemory() {
            return memory;
        }

        public double getScreenDiagonal() {
            return screenDiagonal;
        }

        public double getBatteryLife() {
            return batteryLife;
        }

        public java.lang.String getMarker() {
            return marker;
        }

        public java.lang.String getModel() {
            return model;
        }
    }

    public double getMemory() {
        return memory;
    }

    public double getScreenDiagonal() {
        return screenDiagonal;
    }

    public double getBatteryLife() {
        return batteryLife;
    }

    public java.lang.String getMarker() {
        return marker;
    }

    public java.lang.String getModel() {
        return model;
    }
}
