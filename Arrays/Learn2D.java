public class Learn2D {
    public static void main(String[] args) {
        int[] total = new int[5];
        int j;
        //int total=0;

        int[][] b = {{1,2,4,7,6}, {3,4,5,9,0}};

        for (int i=0; i<b.length; i++){
            for (j=0; j<b[i].length; j++){
                total[j]=b[i][j] + b[i+1][j];
                //total[j] += b[i][j];

                //for (int k=0);
            //}
        }
        System.out.println(total[j]);
    } //total=0;
    }
    //System.out.println(total);
}