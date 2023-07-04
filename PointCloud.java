//SHUBHI BHOORA 300228522
import java.util.*; 
import java.io.*; 

public class PointCloud {
	ArrayList<Point3D> pointCloud;

	PointCloud(String filename) throws IOException, FileNotFoundException {
		pointCloud = new ArrayList<Point3D>();

		//reads a file with the provided filename
		BufferedReader br = new BufferedReader(new FileReader(filename));
		br.readLine();

		String line = br.readLine();
		String[] point;

		while(line != null){
			//System.out.println(line);

			//line is split to seperate the x, y and z values
			point = line.split("	");
			Point3D pt = new Point3D(Double.parseDouble(point[0]), Double.parseDouble(point[1]),
				Double.parseDouble(point[2])); 
			
			addPoint(pt);

			//goes to next line in the file
			line = br.readLine();
		}
		br.close();
	}

	PointCloud(){
		pointCloud = new ArrayList<Point3D>();
	}

	public void addPoint(Point3D pt){
		pointCloud.add(pt);
	}

	Point3D getPoint(){
		Random rand = new Random(); 
		//returns a random point between 0 to size of arrayList
		Point3D point = pointCloud.get(rand.nextInt(pointCloud.size()));
		//System.out.println(point.getX() + " " +point.getY()+ " " + point.getZ());
		return point;
	}

	public void save(String filename) throws IOException, FileNotFoundException {
		//writes to a new file with the provided filename
		BufferedWriter bw = new BufferedWriter(new FileWriter(filename + ".xyz"));
        bw.write("x	y z");	
        bw.newLine();

        for(Point3D pt : pointCloud){
        	bw.write(pt.getX() + "	" + pt.getY() + "	" + pt.getZ());
        	bw.newLine();
        }
        bw.close();        
	}

	Iterator<Point3D> iterator(){
		return new Iterator<Point3D>(pointCloud);
	}
	
	//TEST
	/*
	public static void main(String[] args) throws IOException{
		PointCloud pc = new PointCloud("PointCloud1.xyz");
		pc.getPoint();
		pc.save("test");
	}
	*/
}

