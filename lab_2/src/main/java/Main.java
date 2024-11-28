public class Main {
    public static void main(String[] args) {
        Color new_color = new Color(143,255,100,155);
        System.out.println(new_color);

        Color new_color2 = new Color(200,-5,2951);
        System.out.println(new_color2);

        System.out.println("Color 1: " + new_color.alfa() + ", " + new_color.red() + ", " + new_color.green() + ", " + new_color.blue());
        System.out.println("Color 2: " + new_color2.alfa() + ", " + new_color2.red() + ", " + new_color2.green() + ", " + new_color2.blue());
    }
}
