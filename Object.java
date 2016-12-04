public class Object{
		private int height;
		private int width;
		private int id;
		private boolean isOnBox;
		public double rate(int bheight, int bwidth){
			double heightrate = height / (double) bheight;
			double widthrate = width / (double) bwidth;
			return (heightrate>widthrate ? heightrate : widthrate);
		}
		public int getH(){
			return height;
		}
		public int getW(){
			return width;
		}
		public int getId(){
			return id;
		}
		public boolean isOnTheBox(){
			return isOnBox;
		}
		public void putInBox(){
			isOnBox = true;
		}
		public Object(int h, int w, int i){
			width = w;
			height = h;
			id=i;
			isOnBox=false;
		}
	}