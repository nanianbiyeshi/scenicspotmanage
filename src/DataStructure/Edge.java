package DataStructure;

public class Edge {
private String Sfont;
private int Weight;
public String getSfont() {
	return Sfont;
}
public void setSfont(String sfont) {
	Sfont = sfont;
}
public int getWeight() {
	return Weight;
}
public void setWeight(int weight) {
	Weight = weight;
}

public Edge(String sfont, int weight) {
	super();
	Sfont = sfont;
	Weight = weight;
}


}
