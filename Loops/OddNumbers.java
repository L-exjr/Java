public class OddNumbers {
    public static void main(String[] args){
        int i;

        for (i=0; i<=20; i++){
            if (i==0) continue;{
                System.out.println(i++);
                if (i==20) break;
            }
        }
    }
}