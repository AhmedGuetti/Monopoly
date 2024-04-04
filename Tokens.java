public enum Tokens {
    Car,
    Cat,
    Hat,
    Dog,
    Timble,
    Cannon;

    public static Tokens fromString(String s) {
        switch (s) {
            case "Car":
                return Car;
            case "Cat":
                return Cat;
            case "Hat":
                return Hat;
            case "Dog":
                return Dog;
            case "Timble":
                return Timble;
            case "Cannon":
                return Cannon;
            default:
                throw new IllegalArgumentException("Invalid token: " + s);
        }
    }

    public static Tokens fromNumber(int s) {
        switch (s) {
            case 1:
                return Car;
            case 2:
                return Cat;
            case 3:
                return Hat;
            case 4:
                return Dog;
            case 5:
                return Timble;
            case 6:
                return Cannon;
            default:
                throw new IllegalArgumentException("Invalid token: " + s);
        }
    }

    public static String toStringo(Tokens t) {
        switch (t) {
            case Car:
                return "\033[30;47;1m";
            case Cat:
                return "\033[31;47;1m";
            case Hat:
                return "\033[32;47;1m";
            case Dog:
                return "\033[33;47;1m";
            case Timble:
                return "\033[34;47;1m";
            case Cannon:
                return "\033[35;47;1m";
            default:
                throw new IllegalArgumentException("Invalid token: " + t);
        }
    }
}