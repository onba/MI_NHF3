public class Object{
		private int height;
		private int width;
		private int id;
		private boolean isOnBox;
		public boolean rateH(Object compared){
			if (compared.getH()==height)
			return (compared.area()>area() ? true : false);
			return (compared.getH()>height ? true : false);
		}
		public boolean rateW(Object compared){
			if (compared.getW()==width)
				return (compared.area()>area() ? true : false);
				return (compared.getW()>width? true : false);
		}
		public int area(){
			return height*width;
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