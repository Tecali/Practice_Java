import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverlapedRemover {
	//private List<Coordinate> coordinates = new ArrayList(); 
	public List<Coordinate> getNonOverlaped(List<Coordinate> coordinates){
		List<Coordinate> results = new ArrayList();

		for(int i=0; i<coordinates.size()-1; i++){
			if(coordinates.get(i).getX()<=coordinates.get(i+1).getX() && coordinates.get(i).getY()> coordinates.get(i+1).getX()){
				if(coordinates.get(i+1).getY()> coordinates.get(i).getY()){
					coordinates.get(i).setY(coordinates.get(i+1).getY());
				}
				coordinates.remove(coordinates.get(i+1));
				getNonOverlaped(coordinates);
			}
		}
		results.addAll(coordinates);
		return results;
	}
	
public static void main(String[] args){
	Coordinate c = new Coordinate(1, 8, "F");
	Coordinate c2 = new Coordinate(2, 4, "S");
	Coordinate c3 = new Coordinate(5, 9, "TH");
	Coordinate c4 = new Coordinate(-5, 15, "Fo");
	Coordinate c5 = new Coordinate(5, 8, "Fi");
	Coordinate c6 = new Coordinate(6, 11, "S");
	Coordinate c7 = new Coordinate(-1, 10, "Se");
	Coordinate c8 = new Coordinate(12, 20,"E");
	List<Coordinate> crds = new ArrayList<Coordinate>();
	crds.add(c);
	crds.add(c2);
	crds.add(c3);
	crds.add(c4);
	crds.add(c5);
	crds.add(c6);
	crds.add(c7);
	crds.add(c8);
	OverlapedRemover ovrl = new OverlapedRemover();
	//List<Coordinate> rslts = ovrl.getNonOverlaped(crds);
//	Collections.sort(crds, new Comparator<Coordinate>(){
//		public int compare(Coordinate c1, Coordinate c2){
//			return c1.getX() - c2.getX();
//		}
//	});
	crds.sort(Comparator.comparing(Coordinate::getX).thenComparing(Coordinate::getY));
	//crds.sort((cc1, cc2) -> cc1.getX()-cc2.getX());
	System.out.println(" ========================== ORGINAL===================");
	for(Coordinate cor : crds){
		System.out.println("X: " +cor.getX()+ " And y: "+cor.getY());
	}
	System.out.println(" ========================== TRIMMED ===================");
	for(Coordinate cor : ovrl.getNonOverlaped(crds)){
		System.out.println("X: " +cor.getX()+ " And y: "+cor.getY());
	}
}
}


