package mission.Q13;

import java.util.List;
/**
 * 전체 로또번호 정보를 담을 객체
 */
public class Lottos {
	char charSort;
	boolean typeCheck;
	List<Integer> numList;
	public Lottos(char charSort, boolean typeCheck, List<Integer> numList) {
		this.charSort = charSort;
		this.typeCheck = typeCheck;
		this.numList = numList;
	}
	public char getCharSort() {
		return charSort;
	}
	public void setCharSort(char charSort) {
		this.charSort = charSort;
	}
	public boolean getTypeCheck() {
		return typeCheck;
	}
	public void setTypeCheck(boolean typeCheck) {
		this.typeCheck = typeCheck;
	}
	public List<Integer> getNumList() {
		return numList;
	}
	public void setNumList(List<Integer> numList) {
		this.numList = numList;
	}
	
	@Override
	public String toString() {
		return "Lottos [charSort=" + charSort + ", typeCheck=" + typeCheck + ", numList=" + numList + "]";
	}
}