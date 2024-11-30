public record Color(int alfa, int red, int green, int blue) {

    public Color(int alfa, int red, int green, int blue) {
        if (alfa < 0) alfa = 0;
        else if (alfa > 255) alfa = 255;

        if (red < 0) red = 0;
        else if (red > 255) red = 255;

        if (green < 0) green = 0;
        else if (green > 255) green = 255;

        if (blue < 0) blue = 0;
        else if (blue > 255) blue = 255;

        this.alfa = alfa;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public Color(int red, int green, int blue) {
        this(0,red,green,blue);
    }
}