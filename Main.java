//SHUBHI BHOORA 300228522
import java.io.*; 

public class Main {
	public static void main(String[] args) throws IOException{
		//file, eps, confidence, percentage
		String[] params = new String[] {"PointCloud3.xyz","0.1","0.99","0.3"};
		for(int i=0;i<args.length;i++){params[i]=args[i];}
		String file = params[0].replace(".xyz","");

		PointCloud pc = new PointCloud(params[0]);
		PlaneRANSAC ransac = new PlaneRANSAC(pc);

		ransac.setEps(Double.parseDouble(params[1]));
		int iterations = ransac.getNumberOfIterations(Double.parseDouble(params[2]),Double.parseDouble(params[3]));
		//System.out.println(iterations);

		for(int i=0; i<3; i++){
			ransac.run(iterations, file+"_p"+(i+1));
		}
	}
}