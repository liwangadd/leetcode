package leetcode;

public class T1603 {

    class ParkingSystem {

        private int big, medium, small;

        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public boolean addCar(int carType) {
            switch (carType) {
                case 1:
                    return this.big-- > 0;
                case 2:
                    return this.medium-- > 0;
                case 3:
                    return this.small-- > 0;
            }
            return false;
        }
    }
}
