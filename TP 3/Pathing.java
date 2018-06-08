
import java.util.LinkedList;

//Method for finding the shortest path
//Using BFS Algorithm, source : sumber: http://stackoverflow.com/questions/10099221/breadth-first-search-on-an-8x8-grid-in-java
public class Pathing {
	public static double shortestPathfinder(String startCoordinate, String finishCoordinate, Map map) {
		double counter = 0;
		LinkedList<int[]> queue = new LinkedList<int[]>();

		int startI = ((((int) startCoordinate.charAt(0)) - 65) * 10)
				+ (Integer.parseInt(startCoordinate.substring(1, 2)));
		int startJ = ((((int) startCoordinate.charAt(2)) - 81) * 10) + (Integer.parseInt(startCoordinate.substring(3)));
		int finishI = ((((int) finishCoordinate.charAt(0)) - 65) * 10)
				+ (Integer.parseInt(finishCoordinate.substring(1, 2)));
		int finishJ = ((((int) finishCoordinate.charAt(2)) - 81) * 10)
				+ (Integer.parseInt(finishCoordinate.substring(3)));

		int[] start = { startI, startJ, 0 };
		queue.add(start);
		map.set('S', startI, startJ);

		int[][][] traceback = new int[Map.HEIGHT][Map.WIDTH][2];
		boolean[][] visitHistory = new boolean[Map.HEIGHT][Map.WIDTH];

		while (queue.peek() != null) {
			int[] arr = queue.remove();
			// '#' detection from vertical (I)
			if (arr[0] - 1 >= 0 && map.get(arr[0] - 1, arr[1]) != '#' && visitHistory[arr[0] - 1][arr[1]] != true) {
				if (map.get(arr[0] - 1, arr[1]) == 'F') {
					traceback[arr[0] - 1][arr[1]][0] = arr[0];
					traceback[arr[0] - 1][arr[1]][1] = arr[1];
					arr[2]++;
					break;
				} else {
					// map.getMap()[arr[0]-1][arr[1]] = '.';
					visitHistory[arr[0] - 1][arr[1]] = true;
					traceback[arr[0] - 1][arr[1]][0] = arr[0];
					traceback[arr[0] - 1][arr[1]][1] = arr[1];
					int[] temp = { arr[0] - 1, arr[1], arr[2] + 1 };
					queue.add(temp);
				}
			}

			// '#' detection from horizontal (J)
			if (arr[1] - 1 >= 0 && map.get(arr[0], arr[1] - 1) != '#' && visitHistory[arr[0]][arr[1] - 1] != true) {
				if (map.get(arr[0], arr[1]) == 'F') {
					traceback[arr[0]][arr[1] - 1][0] = arr[0];
					traceback[arr[0]][arr[1] - 1][1] = arr[1];
					arr[2]++;
					break;
				} else {
					visitHistory[arr[0]][arr[1] - 1] = true;
					traceback[arr[0]][arr[1] - 1][0] = arr[0];
					traceback[arr[0]][arr[1] - 1][1] = arr[1];
					int[] temp = { arr[0], arr[1] - 1, arr[2] + 1 };
					queue.add(temp);
				}
			}

			if (arr[1] + 1 <= Map.WIDTH && map.get(arr[0], arr[1] + 1) != '#'
					&& visitHistory[arr[0]][arr[1] + 1] != true) {
				if (map.get(arr[0], arr[1] + 1) == 'F') {
					traceback[arr[0]][arr[1] + 1][0] = arr[0];
					traceback[arr[0]][arr[1] + 1][1] = arr[1];
					arr[2]++;
					break;
				} else {
					visitHistory[arr[0]][arr[1] + 1] = true;
					traceback[arr[0]][arr[1] + 1][0] = arr[0];
					traceback[arr[0]][arr[1] + 1][1] = arr[1];
					int[] temp = { arr[0], arr[1] + 1, arr[2] + 1 };
					queue.add(temp);
				}
			}

			if (arr[0] + 1 <= Map.HEIGHT && map.get(arr[0] + 1, arr[1]) != '#'
					&& visitHistory[arr[0] + 1][arr[1]] != true) {
				if (map.get(arr[0] + 1, arr[1]) == 'F') {
					traceback[arr[0] + 1][arr[1]][0] = arr[0];
					traceback[arr[0] + 1][arr[1]][1] = arr[1];
					arr[2]++;
					break;
				} else {
					visitHistory[arr[0] + 1][arr[1]] = true;
					traceback[arr[0] + 1][arr[1]][0] = arr[0];
					traceback[arr[0] + 1][arr[1]][1] = arr[1];
					int[] temp = { arr[0] + 1, arr[1], arr[2] + 1 };
					queue.add(temp);
				}
			}
		}
		int iNow = finishI;
		int jNow = finishJ;
		map.set('S', startI, startJ);

		while (!(iNow == startI && jNow == startJ)) {
			map.set('.', iNow, jNow);
			int iSekarang = iNow;
			int jSekarang = jNow;
			iNow = traceback[iSekarang][jSekarang][0];
			jNow = traceback[iSekarang][jSekarang][1];
			if (iNow == 0 && jNow == 0) {
				break;
			}
		}
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 100; j++) {
				if (map.get(i, j) == '.') {
					counter++;
				}
			}
		}
		map.set('F', finishI, finishJ);
		return counter;
	}
	
	//Method for checking the start and finish coordinates
	public static boolean checkPath(String startCoordinate, String finishCoordinate, Map map) {
		boolean cantStart = false;
		boolean cantFinish = false;
		int startI = ((((int) startCoordinate.charAt(0)) - 65) * 10)
				+ (Integer.parseInt(startCoordinate.substring(1, 2)));
		int startJ = ((((int) startCoordinate.charAt(2)) - 81) * 10) + (Integer.parseInt(startCoordinate.substring(3)));
		int finishI = ((((int) finishCoordinate.charAt(0)) - 65) * 10)
				+ (Integer.parseInt(finishCoordinate.substring(1, 2)));
		int finishJ = ((((int) finishCoordinate.charAt(2)) - 81) * 10)
				+ (Integer.parseInt(finishCoordinate.substring(3)));
		
		if (map.get(startI, startJ) == '#') {
			cantStart = true;
		}
		
		if (map.get(finishI, finishJ) == '#') {
			cantFinish = true;
		}
		
		if (cantStart || cantFinish) {
			return true;
		}
		return false;
	}
}