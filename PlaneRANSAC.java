//SHUBHI BHOORA 300228522
import java.io.*; 

public class PlaneRANSAC {
	double eps;
	PointCloud pc;

	public PlaneRANSAC(PointCloud pc){
		this.pc = pc;
	}

	public void setEps(double eps){
		this.eps = eps;
	}
 	
	public double getEps(){
		return eps;
	}

	public int getNumberOfIterations(double confidence, double percentageOfPointsOnPlane){
		//based on the formula provided in the project pdf
		double k = Math.log10(1-confidence)/Math.log10(1-Math.pow(percentageOfPointsOnPlane,3)); 
		return (int)k;
	}

	public void run(int numberOfIterations, String filename) throws IOException{
		Point3D p1, p2, p3;
		Plane3D plane;
		PointCloud dominantPC = new PointCloud(); 
		int bestSupport = 0;

		for(int i = 0; i<numberOfIterations; i++){	
			//System.out.println(pc.pointCloud.size());

			//a temporary PointCloud to store the support points for the new plane
			PointCloud tempPC = new PointCloud();
			int support = 0;
			p1 = pc.getPoint();
			p2 = pc.getPoint();
			p3 = pc.getPoint();

			//creates a new plane based on the 3 random points
			plane = new Plane3D(p1,p2,p3);
			Iterator<Point3D> it = pc.iterator();

			//iterates through all the points in pc
			while (it.hasNext()){
				Point3D pt = it.next();
				//if the given point is under the eps value, it is counted as a support for the plane
				if(plane.getDistance(pt) < eps){
					tempPC.addPoint(pt); //adds the support point to the PointCloud for the plane
					support++;
				}
			}

			//stores the best support points count and the potential dominant plane
			if(support > bestSupport){
				bestSupport = support;
				dominantPC = tempPC;
			}
		}
		
		//System.out.println("DOM PLANE: "+dominantPC.pointCloud.size());
		dominantPC.save(filename);
	}

}