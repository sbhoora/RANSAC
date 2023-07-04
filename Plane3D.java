//SHUBHI BHOORA 300228522
public class Plane3D {
	private Point3D p1, p2, p3;
	private double a, b, c, d;

	//Plane Equation -> ax + by + cz + d = 0

	public Plane3D(Point3D p1, Point3D p2, Point3D p3){
		//finding paramters for the plane equation based on the 3 points 
		a = (p2.getY()-p1.getY())*(p3.getZ()-p1.getZ())-(p2.getZ()-p1.getZ())*(p3.getY()-p1.getY());
		b = (p2.getZ()-p1.getZ())*(p3.getX()-p1.getX())-(p2.getX()-p1.getX())*(p3.getZ()-p1.getZ());
		c = (p2.getX()-p1.getX())*(p3.getY()-p1.getY())-(p2.getY()-p1.getY())*(p3.getX()-p1.getX());
		d = -(a*p1.getX() + b*p1.getY() +c*p1.getZ());

		//System.out.println(a + ", " + b + ", " + c + ", " + d);
	}


	public Plane3D(double a, double b, double c, double d){
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	public double getDistance(Point3D pt){
		//numerator
		double top = Math.abs(a*pt.getX() + b*pt.getY() + c*pt.getZ() + d);

		//denominator
		double bot = Math.sqrt(Math.pow(a,2) + Math.pow(b,2) + Math.pow(c,2));

		//System.out.println(top/bot);
		return top/bot;
	}

	//TEST
	/*
	public static void main(String[] args){
		Point3D p1 = new Point3D(2,1,4);
		Point3D p2 = new Point3D(4,-2,7);
		Point3D p3 = new Point3D(5,3,-2);

		Plane3D p = new Plane3D(p1, p2, p3);
		p.getDistance(new Point3D(1,4,-10));
	}
	*/
}

