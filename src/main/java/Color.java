import jakarta.persistence.Embeddable;

@Embeddable
public record Color(int alpha, int red, int green, int blue) {

    public Color {
        if (alpha < 0) alpha = 0;
        else if (alpha > 255) alpha = 255;

        if (red < 0) red = 0;
        else if (red > 255) red = 255;

        if (green < 0) green = 0;
        else if (green > 255) green = 255;

        if (blue < 0) blue = 0;
        else if (blue > 255) blue = 255;
    }

    public Color(int red, int green, int blue) {
        this(0, red, green, blue);  // Default alpha to 0
    }

    @Override
    public String toString() {
        return String.format("0x%02X", alpha) + String.format("%02X", red) + String.format("%02X", green) + String.format("%02X", blue);
    }
}
