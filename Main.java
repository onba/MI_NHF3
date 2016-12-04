import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	
	private static int baggageH;
	private static int baggageW;
	private static int objectSize;
	private static ArrayList<Object> objects = new ArrayList<>();
	public static boolean isEnoughPlace(int h, int w, Object object, int[][] baggage){
		if (object.getH()+h>baggageH || object.getW()+w> baggageW) return false;
		for (int i=h;i<object.getH()+h;i++){
			for (int j=w;j<object.getW()+w; j++){
				if (baggage[i][j]!=0) return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] split = input.split("\t");
		baggageH = Integer.parseInt(split[0]);
		baggageW = Integer.parseInt(split[1]);
		
		input = sc.nextLine();
		split = input.split("\t");
		objectSize = Integer.parseInt(split[0]);
		
		for (int i=0;i<objectSize;i++){
			input = sc.nextLine();
			split = input.split("\t");
			objects.add(new Object(Integer.parseInt(split[0]), Integer.parseInt(split[1]),i));
		}
		sc.close();
		
		int[][] baggage = new int[baggageH][baggageW];
		Object biggestOutOfBox;
		for(int j=0;j<objectSize;j++){
			int x=0;
			while(objects.get(x).isOnTheBox()) x++;
			biggestOutOfBox = objects.get(x);
		for(int i=0;i<objectSize; i++){
			if (!objects.get(i).isOnTheBox() && biggestOutOfBox.rate(baggageH, baggageW)<objects.get(i).rate(baggageH, baggageW))
				biggestOutOfBox = objects.get(i);
		}
		int h=0;
		while(!biggestOutOfBox.isOnTheBox() && h!=baggageH){
			int w=0;
			while(!biggestOutOfBox.isOnTheBox() && w!=baggageW){
				if (baggage[h][w]==0 && isEnoughPlace(h,w,biggestOutOfBox, baggage)){
					for(int k=h; k<h+biggestOutOfBox.getH();k++){
						for (int l=w;l<w+biggestOutOfBox.getW(); l++){
							baggage[k][l] = biggestOutOfBox.getId()+1;
						}
					}
					biggestOutOfBox.putInBox();
				}
				w++;
			}
		h++;
		}
		
		}
		
		
		for (int i=0;i<baggageH;i++){
			for (int j=0;j<baggageW;j++){
				if (j==baggageW-1) System.out.println(baggage[i][j]);
				else System.out.print(baggage[i][j]+"\t");
			}
		}
	}
}
