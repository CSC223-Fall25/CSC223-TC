package csc223.tc;

public class FUber {

    public static float euclidean(float x1, float y1, float x2, float y2) {
        return (float)Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));
        //double part1 = Math.pow((x1 - x2),2);
        //double part2 = Math.pow((y1 - y2),2);
        //float part3 = (float) part1 + (float) part2;
        //return (float) Math.sqrt(part3);
    }

    public static float manhattan(float x1, float y1, float x2, float y2) {
        // Implement the method here
        return (float) ((x1 - x2)/(y1-y2));
    }
}
