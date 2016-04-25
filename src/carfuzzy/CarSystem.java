package carfuzzy;

/**
 *
 * @author ugurcem
 */
public class CarSystem {

    public enum Speed {

        verySlow(0d, 16d, 32d),
        slow(16d, 38d, 60d),
        medium(50d, 75d, 100d),
        fast(90d, 120d, 150d),
        veryFast(140d, 170d, 200d);
        
        double a[] = new double[3];

        Speed(double a, double b, double c) {
            this.a[0] = a;
            this.a[1] = b;
            this.a[2] = c;
        }

        public double[] getValue() {
            return a;
        }

    }

    public enum Distance {

        veryClose(0d, 20d, 40d),
        close(20d, 40d, 60d),
        normal(40d, 60d, 80d),
        away(60d, 80d, 100d);
        
        double a[] = new double[3];

        Distance(double a, double b, double c) {
            this.a[0] = a;
            this.a[1] = b;
            this.a[2] = c;
        }

        public double[] getValue() {
            return a;
        }
    }

    public enum Output {

        stop(0d, 1d, 2d, 3d),
        slowDown(2d, 3.5d, 4.5d, 6d),
        keepPace(4.5d, 5.5d, 7d, 8d),
        speedUp(6d, 7d, 9d, 10d);
        double a[] = new double[4];

        Output(double a, double b, double c, double d) {
            this.a[0] = a;
            this.a[1] = b;
            this.a[2] = c;
            this.a[3] = d;
        }

        public double[] getValue() {
            return a;
        }
    }

}
