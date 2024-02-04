public class RandomEnterer {
    public static int randomEntering(int min, int max){
        max -= min;
        return (int)(Math.random()*(++max))+min;
    }
}
