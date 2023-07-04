//SHUBHI BHOORA 300228522
import java.util.*; 

public class Iterator<Point3D>{
	int current;
	ArrayList<Point3D> arrayList;

	public Iterator(ArrayList<Point3D> arrayList){
		current = 0;
		this.arrayList = arrayList;
	}

	public boolean hasNext(){
		return current+1 < arrayList.size();
	}

	public Point3D next(){
		Point3D point = arrayList.get(current);
		current ++;
		return point;
	}

	public void remove(){
		arrayList.remove(current);
	}
}